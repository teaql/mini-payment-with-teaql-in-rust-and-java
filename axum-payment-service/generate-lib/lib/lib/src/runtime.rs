use crate::*;
use teaql_core::TeaqlEntity;

use teaql_provider_postgres::PostgresProviderExt as _;

pub type DataServiceDialect = teaql_provider_postgres::PostgresDialect;
pub type DataServiceMutationExecutor = teaql_provider_postgres::PgMutationExecutor;
pub type DataServiceMutationError = teaql_provider_postgres::MutationExecutorError;
pub type DataServiceIdGenerator = teaql_provider_postgres::PgIdSpaceGenerator;
pub type DataServicePool = deadpool_postgres::Pool;
pub type DataServiceExecutor = ServiceRuntimeExecutor;
pub type ServiceRuntime = teaql_runtime::UserContext;

pub const DATABASE_URL_ENV: &str = "PAYMENT_SERVICE_CORE_DATABASE_URL";
pub const DATABASE_USER_ENV: &str = "PAYMENT_SERVICE_CORE_DATABASE_USER";
pub const DATABASE_PASSWORD_ENV: &str = "PAYMENT_SERVICE_CORE_DATABASE_PASSWORD";
#[derive(Clone, Debug, PartialEq, Eq)]
pub struct ServiceRuntimeConfig {
    pub database_url: String,
    pub database_user: String,
    pub database_password: String,
}

impl ServiceRuntimeConfig {
    pub fn from_env() -> Result<Self, ServiceRuntimeError> {
        Ok(Self {
            database_url: env_value(DATABASE_URL_ENV)?,
            database_user: env_value(DATABASE_USER_ENV)?,
            database_password: env_value(DATABASE_PASSWORD_ENV)?,
        })
    }
}

#[derive(Debug)]
pub enum ServiceRuntimeError {
    MissingEnv {
        name: &'static str,
        source: std::env::VarError,
    },
    ConnectionError(String),
    Runtime(teaql_runtime::RuntimeError),
}

impl std::fmt::Display for ServiceRuntimeError {
    fn fmt(&self, f: &mut std::fmt::Formatter<'_>) -> std::fmt::Result {
        match self {
            ServiceRuntimeError::MissingEnv { name, source } => {
                write!(f, "missing environment variable {name}: {source}")
            }
            ServiceRuntimeError::ConnectionError(err) => write!(f, "connection error: {err}"),
            ServiceRuntimeError::Runtime(err) => write!(f, "runtime error: {err}"),
        }
    }
}

impl std::error::Error for ServiceRuntimeError {
    fn source(&self) -> Option<&(dyn std::error::Error + 'static)> {
        match self {
            ServiceRuntimeError::MissingEnv { source, .. } => Some(source),
            ServiceRuntimeError::ConnectionError(_) => None,
            ServiceRuntimeError::Runtime(err) => Some(err),
        }
    }
}

impl From<teaql_runtime::RuntimeError> for ServiceRuntimeError {
    fn from(err: teaql_runtime::RuntimeError) -> Self {
        ServiceRuntimeError::Runtime(err)
    }
}

#[derive(Clone)]
pub struct LocalSchemaProvider;

impl teaql_data_service::SchemaProvider for LocalSchemaProvider {
    fn get_entity(&self, name: &str) -> Option<std::sync::Arc<teaql_core::EntityDescriptor>> {
        match name {
            "Platform" => Some(std::sync::Arc::new(crate::Platform::entity_descriptor())),
            "CachedMerchant" => Some(std::sync::Arc::new(crate::CachedMerchant::entity_descriptor())),
            "PaymentOrder" => Some(std::sync::Arc::new(crate::PaymentOrder::entity_descriptor())),
            "PaymentRecord" => Some(std::sync::Arc::new(crate::PaymentRecord::entity_descriptor())),
            "PaymentStatusType" => Some(std::sync::Arc::new(crate::PaymentStatusType::entity_descriptor())),
            "PaymentChannelType" => Some(std::sync::Arc::new(crate::PaymentChannelType::entity_descriptor())),
            _ => None,
        }
    }
}

#[derive(Clone)]
pub struct ServiceRuntimeExecutor {
    inner: teaql_sql::SqlDataServiceExecutor<
        DataServiceDialect,
        DataServiceMutationExecutor,
        LocalSchemaProvider
    >,
}

impl ServiceRuntimeExecutor {
    pub fn new(inner: DataServiceMutationExecutor) -> Self {
        Self {
            inner: teaql_sql::SqlDataServiceExecutor::new(
                DataServiceDialect::default(),
                inner,
                LocalSchemaProvider
            ),
        }
    }

}

impl teaql_data_service::DataServiceExecutor for ServiceRuntimeExecutor {
    type Error = teaql_sql::SqlExecutorError<DataServiceMutationError>;
    fn capabilities(&self) -> teaql_data_service::DataServiceCapabilities {
        teaql_data_service::DataServiceExecutor::capabilities(&self.inner)
    }
}

impl teaql_data_service::QueryExecutor for ServiceRuntimeExecutor {
    async fn query(&self, request: teaql_data_service::QueryRequest) -> Result<teaql_data_service::QueryResult, Self::Error> {
        teaql_data_service::QueryExecutor::query(&self.inner, request).await
    }
}

impl teaql_data_service::StreamQueryExecutor for ServiceRuntimeExecutor {
    async fn query_stream(&self, request: teaql_data_service::QueryRequest, chunk_size: usize) -> Result<Vec<teaql_data_service::StreamChunk>, Self::Error> {
        teaql_data_service::StreamQueryExecutor::query_stream(&self.inner, request, chunk_size).await
    }
}

impl teaql_data_service::MutationExecutor for ServiceRuntimeExecutor {
    async fn mutate(&self, request: teaql_data_service::MutationRequest) -> Result<teaql_data_service::MutationResult, Self::Error> {
        teaql_data_service::MutationExecutor::mutate(&self.inner, request).await
    }
}

impl teaql_data_service::TransactionExecutor for ServiceRuntimeExecutor {
    type Tx<'a> = teaql_sql::SqlDataServiceTransaction<'a, DataServiceDialect, <DataServiceMutationExecutor as teaql_sql::SqlTransactionTransport>::Tx<'a>, LocalSchemaProvider> where Self: 'a;

    async fn begin(&self) -> Result<Self::Tx<'_ >, Self::Error> {
        teaql_data_service::TransactionExecutor::begin(&self.inner).await
    }
}

pub async fn service_runtime_from_env() -> Result<ServiceRuntime, ServiceRuntimeError> {
    service_runtime(ServiceRuntimeConfig::from_env()?).await
}

pub async fn service_runtime(config: ServiceRuntimeConfig) -> Result<ServiceRuntime, ServiceRuntimeError> {
    let pool = connect_data_service_pool(&config).await?;
    service_runtime_from_pool(pool).await
}

pub async fn service_runtime_from_pool(pool: DataServicePool) -> Result<ServiceRuntime, ServiceRuntimeError> {
    let id_generator = DataServiceIdGenerator::new(pool.clone());
    let mutation_executor = DataServiceMutationExecutor::new(pool);let mut context = module_with_behaviors_and_checkers().into_context();
    context.set_internal_id_generator(id_generator);
    context.use_postgres_provider(mutation_executor.clone());
    let executor = ServiceRuntimeExecutor::new(mutation_executor);
    context.register_executor(executor.clone());
    context.insert_resource(executor);

    // 自动加载 Zero-Code 审计配置与 Schema 模式
    let env_config = teaql_tool_core::audit_config_from_env(&[
        "platform_data", "cached_merchant_data", "payment_order_data", "payment_record_data", "payment_status_type_data", "payment_channel_type_data"
    ]);
    let schema_mode = env_config.schema_mode;
    context.insert_resource(env_config.config.clone());
    context.insert_resource(env_config);

    match schema_mode {
        teaql_tool_core::SchemaMode::Execute => {
            context.ensure_schema().await?;
        }
        teaql_tool_core::SchemaMode::DryRun => {
            // DryRun: 目前等效于验证
            context.ensure_schema().await?;
        }
        teaql_tool_core::SchemaMode::Verify => {
            context.ensure_schema().await?;
        }
    }

    Ok(context)
}



fn env_value(name: &'static str) -> Result<String, ServiceRuntimeError> {
    std::env::var(name).map_err(|source| ServiceRuntimeError::MissingEnv { name, source })
}

async fn connect_data_service_pool(config: &ServiceRuntimeConfig) -> Result<DataServicePool, ServiceRuntimeError> {
    let pg_config = config.database_url.parse::<tokio_postgres::Config>().map_err(|e| ServiceRuntimeError::ConnectionError(e.to_string()))?;
    let mgr = deadpool_postgres::Manager::new(pg_config, tokio_postgres::NoTls);
    let pool = deadpool_postgres::Pool::builder(mgr).build().map_err(|e| ServiceRuntimeError::ConnectionError(e.to_string()))?;
    Ok(pool)
}
pub fn repository_registry() -> teaql_runtime::InMemoryEntityRegistry {
    teaql_runtime::InMemoryEntityRegistry::new()
        .with_entity("Platform")
        .with_entity("CachedMerchant")
        .with_entity("PaymentOrder")
        .with_entity("PaymentRecord")
        .with_entity("PaymentStatusType")
        .with_entity("PaymentChannelType")
}

pub fn behavior_registry() -> teaql_runtime::InMemoryEntityDataServiceBehaviorRegistry {
    teaql_runtime::InMemoryEntityDataServiceBehaviorRegistry::new()
        .with_behavior("Platform", PlatformBehavior::default())
        .with_behavior("CachedMerchant", CachedMerchantBehavior::default())
        .with_behavior("PaymentOrder", PaymentOrderBehavior::default())
        .with_behavior("PaymentRecord", PaymentRecordBehavior::default())
        .with_behavior("PaymentStatusType", PaymentStatusTypeBehavior::default())
        .with_behavior("PaymentChannelType", PaymentChannelTypeBehavior::default())
}

pub fn checker_registry() -> teaql_runtime::InMemoryCheckerRegistry {
    teaql_runtime::InMemoryCheckerRegistry::new()
        .with_checker(teaql_runtime::TypedEntityChecker::<Platform, _>::new(PlatformChecker::default()))
        .with_checker(teaql_runtime::TypedEntityChecker::<CachedMerchant, _>::new(CachedMerchantChecker::default()))
        .with_checker(teaql_runtime::TypedEntityChecker::<PaymentOrder, _>::new(PaymentOrderChecker::default()))
        .with_checker(teaql_runtime::TypedEntityChecker::<PaymentRecord, _>::new(PaymentRecordChecker::default()))
        .with_checker(teaql_runtime::TypedEntityChecker::<PaymentStatusType, _>::new(PaymentStatusTypeChecker::default()))
        .with_checker(teaql_runtime::TypedEntityChecker::<PaymentChannelType, _>::new(PaymentChannelTypeChecker::default()))
}

pub fn module() -> teaql_runtime::RuntimeModule {
    teaql_runtime::RuntimeModule::new()
        .entity::<Platform>()
        .entity::<CachedMerchant>()
        .entity::<PaymentOrder>()
        .entity::<PaymentRecord>()
        .entity::<PaymentStatusType>()
        .entity::<PaymentChannelType>()
        .initial_graph(teaql_runtime::GraphNode::new("Platform")
            .value("id", 1_u64)
            .value("name", "Payment Platform")
            .value("create_time", chrono::Utc::now())
            .value("update_time", chrono::Utc::now())
            .value("version", 1_i64))
        .initial_graph(teaql_runtime::GraphNode::new("PaymentStatusType")
            .value("id", 1001_u64)
            .value("name", "Created")
            .value("code", "CREATED")
            .value("version", 1_i64)
            .value("platform_id", 1_u64))
        .initial_graph(teaql_runtime::GraphNode::new("PaymentStatusType")
            .value("id", 1002_u64)
            .value("name", "Paying")
            .value("code", "PAYING")
            .value("version", 1_i64)
            .value("platform_id", 1_u64))
        .initial_graph(teaql_runtime::GraphNode::new("PaymentStatusType")
            .value("id", 1003_u64)
            .value("name", "Success")
            .value("code", "SUCCESS")
            .value("version", 1_i64)
            .value("platform_id", 1_u64))
        .initial_graph(teaql_runtime::GraphNode::new("PaymentStatusType")
            .value("id", 1004_u64)
            .value("name", "Failed")
            .value("code", "FAILED")
            .value("version", 1_i64)
            .value("platform_id", 1_u64))
        .initial_graph(teaql_runtime::GraphNode::new("PaymentStatusType")
            .value("id", 1005_u64)
            .value("name", "Refunded")
            .value("code", "REFUNDED")
            .value("version", 1_i64)
            .value("platform_id", 1_u64))
        .initial_graph(teaql_runtime::GraphNode::new("PaymentChannelType")
            .value("id", 1001_u64)
            .value("name", "Alipay")
            .value("code", "ALIPAY")
            .value("version", 1_i64)
            .value("platform_id", 1_u64))
        .initial_graph(teaql_runtime::GraphNode::new("PaymentChannelType")
            .value("id", 1002_u64)
            .value("name", "WeChat")
            .value("code", "WECHAT")
            .value("version", 1_i64)
            .value("platform_id", 1_u64))
        .initial_graph(teaql_runtime::GraphNode::new("PaymentChannelType")
            .value("id", 1003_u64)
            .value("name", "Stripe")
            .value("code", "STRIPE")
            .value("version", 1_i64)
            .value("platform_id", 1_u64))
}

pub fn module_with_checkers() -> teaql_runtime::RuntimeModule {
    teaql_runtime::RuntimeModule::new()
        .entity::<Platform>()
        .checker(teaql_runtime::TypedEntityChecker::<Platform, _>::new(PlatformChecker::default()))
        .entity::<CachedMerchant>()
        .checker(teaql_runtime::TypedEntityChecker::<CachedMerchant, _>::new(CachedMerchantChecker::default()))
        .entity::<PaymentOrder>()
        .checker(teaql_runtime::TypedEntityChecker::<PaymentOrder, _>::new(PaymentOrderChecker::default()))
        .entity::<PaymentRecord>()
        .checker(teaql_runtime::TypedEntityChecker::<PaymentRecord, _>::new(PaymentRecordChecker::default()))
        .entity::<PaymentStatusType>()
        .checker(teaql_runtime::TypedEntityChecker::<PaymentStatusType, _>::new(PaymentStatusTypeChecker::default()))
        .entity::<PaymentChannelType>()
        .checker(teaql_runtime::TypedEntityChecker::<PaymentChannelType, _>::new(PaymentChannelTypeChecker::default()))
        .initial_graph(teaql_runtime::GraphNode::new("Platform")
            .value("id", 1_u64)
            .value("name", "Payment Platform")
            .value("create_time", chrono::Utc::now())
            .value("update_time", chrono::Utc::now())
            .value("version", 1_i64))
        .initial_graph(teaql_runtime::GraphNode::new("PaymentStatusType")
            .value("id", 1001_u64)
            .value("name", "Created")
            .value("code", "CREATED")
            .value("version", 1_i64)
            .value("platform_id", 1_u64))
        .initial_graph(teaql_runtime::GraphNode::new("PaymentStatusType")
            .value("id", 1002_u64)
            .value("name", "Paying")
            .value("code", "PAYING")
            .value("version", 1_i64)
            .value("platform_id", 1_u64))
        .initial_graph(teaql_runtime::GraphNode::new("PaymentStatusType")
            .value("id", 1003_u64)
            .value("name", "Success")
            .value("code", "SUCCESS")
            .value("version", 1_i64)
            .value("platform_id", 1_u64))
        .initial_graph(teaql_runtime::GraphNode::new("PaymentStatusType")
            .value("id", 1004_u64)
            .value("name", "Failed")
            .value("code", "FAILED")
            .value("version", 1_i64)
            .value("platform_id", 1_u64))
        .initial_graph(teaql_runtime::GraphNode::new("PaymentStatusType")
            .value("id", 1005_u64)
            .value("name", "Refunded")
            .value("code", "REFUNDED")
            .value("version", 1_i64)
            .value("platform_id", 1_u64))
        .initial_graph(teaql_runtime::GraphNode::new("PaymentChannelType")
            .value("id", 1001_u64)
            .value("name", "Alipay")
            .value("code", "ALIPAY")
            .value("version", 1_i64)
            .value("platform_id", 1_u64))
        .initial_graph(teaql_runtime::GraphNode::new("PaymentChannelType")
            .value("id", 1002_u64)
            .value("name", "WeChat")
            .value("code", "WECHAT")
            .value("version", 1_i64)
            .value("platform_id", 1_u64))
        .initial_graph(teaql_runtime::GraphNode::new("PaymentChannelType")
            .value("id", 1003_u64)
            .value("name", "Stripe")
            .value("code", "STRIPE")
            .value("version", 1_i64)
            .value("platform_id", 1_u64))
}

pub fn module_with_behaviors() -> teaql_runtime::RuntimeModule {
    teaql_runtime::RuntimeModule::new()
        .entity_with_behavior::<Platform, _>(PlatformBehavior::default())
        .entity_with_behavior::<CachedMerchant, _>(CachedMerchantBehavior::default())
        .entity_with_behavior::<PaymentOrder, _>(PaymentOrderBehavior::default())
        .entity_with_behavior::<PaymentRecord, _>(PaymentRecordBehavior::default())
        .entity_with_behavior::<PaymentStatusType, _>(PaymentStatusTypeBehavior::default())
        .entity_with_behavior::<PaymentChannelType, _>(PaymentChannelTypeBehavior::default())
        .initial_graph(teaql_runtime::GraphNode::new("Platform")
            .value("id", 1_u64)
            .value("name", "Payment Platform")
            .value("create_time", chrono::Utc::now())
            .value("update_time", chrono::Utc::now())
            .value("version", 1_i64))
        .initial_graph(teaql_runtime::GraphNode::new("PaymentStatusType")
            .value("id", 1001_u64)
            .value("name", "Created")
            .value("code", "CREATED")
            .value("version", 1_i64)
            .value("platform_id", 1_u64))
        .initial_graph(teaql_runtime::GraphNode::new("PaymentStatusType")
            .value("id", 1002_u64)
            .value("name", "Paying")
            .value("code", "PAYING")
            .value("version", 1_i64)
            .value("platform_id", 1_u64))
        .initial_graph(teaql_runtime::GraphNode::new("PaymentStatusType")
            .value("id", 1003_u64)
            .value("name", "Success")
            .value("code", "SUCCESS")
            .value("version", 1_i64)
            .value("platform_id", 1_u64))
        .initial_graph(teaql_runtime::GraphNode::new("PaymentStatusType")
            .value("id", 1004_u64)
            .value("name", "Failed")
            .value("code", "FAILED")
            .value("version", 1_i64)
            .value("platform_id", 1_u64))
        .initial_graph(teaql_runtime::GraphNode::new("PaymentStatusType")
            .value("id", 1005_u64)
            .value("name", "Refunded")
            .value("code", "REFUNDED")
            .value("version", 1_i64)
            .value("platform_id", 1_u64))
        .initial_graph(teaql_runtime::GraphNode::new("PaymentChannelType")
            .value("id", 1001_u64)
            .value("name", "Alipay")
            .value("code", "ALIPAY")
            .value("version", 1_i64)
            .value("platform_id", 1_u64))
        .initial_graph(teaql_runtime::GraphNode::new("PaymentChannelType")
            .value("id", 1002_u64)
            .value("name", "WeChat")
            .value("code", "WECHAT")
            .value("version", 1_i64)
            .value("platform_id", 1_u64))
        .initial_graph(teaql_runtime::GraphNode::new("PaymentChannelType")
            .value("id", 1003_u64)
            .value("name", "Stripe")
            .value("code", "STRIPE")
            .value("version", 1_i64)
            .value("platform_id", 1_u64))
}

pub fn module_with_behaviors_and_checkers() -> teaql_runtime::RuntimeModule {
    teaql_runtime::RuntimeModule::new()
        .entity_with_behavior::<Platform, _>(PlatformBehavior::default())
        .checker(teaql_runtime::TypedEntityChecker::<Platform, _>::new(PlatformChecker::default()))
        .entity_with_behavior::<CachedMerchant, _>(CachedMerchantBehavior::default())
        .checker(teaql_runtime::TypedEntityChecker::<CachedMerchant, _>::new(CachedMerchantChecker::default()))
        .entity_with_behavior::<PaymentOrder, _>(PaymentOrderBehavior::default())
        .checker(teaql_runtime::TypedEntityChecker::<PaymentOrder, _>::new(PaymentOrderChecker::default()))
        .entity_with_behavior::<PaymentRecord, _>(PaymentRecordBehavior::default())
        .checker(teaql_runtime::TypedEntityChecker::<PaymentRecord, _>::new(PaymentRecordChecker::default()))
        .entity_with_behavior::<PaymentStatusType, _>(PaymentStatusTypeBehavior::default())
        .checker(teaql_runtime::TypedEntityChecker::<PaymentStatusType, _>::new(PaymentStatusTypeChecker::default()))
        .entity_with_behavior::<PaymentChannelType, _>(PaymentChannelTypeBehavior::default())
        .checker(teaql_runtime::TypedEntityChecker::<PaymentChannelType, _>::new(PaymentChannelTypeChecker::default()))
        .initial_graph(teaql_runtime::GraphNode::new("Platform")
            .value("id", 1_u64)
            .value("name", "Payment Platform")
            .value("create_time", chrono::Utc::now())
            .value("update_time", chrono::Utc::now())
            .value("version", 1_i64))
        .initial_graph(teaql_runtime::GraphNode::new("PaymentStatusType")
            .value("id", 1001_u64)
            .value("name", "Created")
            .value("code", "CREATED")
            .value("version", 1_i64)
            .value("platform_id", 1_u64))
        .initial_graph(teaql_runtime::GraphNode::new("PaymentStatusType")
            .value("id", 1002_u64)
            .value("name", "Paying")
            .value("code", "PAYING")
            .value("version", 1_i64)
            .value("platform_id", 1_u64))
        .initial_graph(teaql_runtime::GraphNode::new("PaymentStatusType")
            .value("id", 1003_u64)
            .value("name", "Success")
            .value("code", "SUCCESS")
            .value("version", 1_i64)
            .value("platform_id", 1_u64))
        .initial_graph(teaql_runtime::GraphNode::new("PaymentStatusType")
            .value("id", 1004_u64)
            .value("name", "Failed")
            .value("code", "FAILED")
            .value("version", 1_i64)
            .value("platform_id", 1_u64))
        .initial_graph(teaql_runtime::GraphNode::new("PaymentStatusType")
            .value("id", 1005_u64)
            .value("name", "Refunded")
            .value("code", "REFUNDED")
            .value("version", 1_i64)
            .value("platform_id", 1_u64))
        .initial_graph(teaql_runtime::GraphNode::new("PaymentChannelType")
            .value("id", 1001_u64)
            .value("name", "Alipay")
            .value("code", "ALIPAY")
            .value("version", 1_i64)
            .value("platform_id", 1_u64))
        .initial_graph(teaql_runtime::GraphNode::new("PaymentChannelType")
            .value("id", 1002_u64)
            .value("name", "WeChat")
            .value("code", "WECHAT")
            .value("version", 1_i64)
            .value("platform_id", 1_u64))
        .initial_graph(teaql_runtime::GraphNode::new("PaymentChannelType")
            .value("id", 1003_u64)
            .value("name", "Stripe")
            .value("code", "STRIPE")
            .value("version", 1_i64)
            .value("platform_id", 1_u64))
}