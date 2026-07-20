// ⛔ AI agents: DO NOT read this file for API discovery. Instead run: cargo teaql --input modeling/MODEL.xml rust-assist-query/payment_record
use std::collections::BTreeMap;

use teaql_macros::TeaqlEntity;

/// [TEAQL AI WARNING]
/// TeaQL was explicitly designed to PREVENT AI hallucinations and random guessing.
/// DO NOT GUESS METHOD NAMES!
/// The methods listed below are the ONLY valid ways to interact with this entity.
/// If you encounter compilation errors (e.g., method not found), DO NOT guess another method name.
/// Read the method signatures in this file before proceeding.
#[derive(Clone, Debug, PartialEq, TeaqlEntity)]
#[teaql(entity = "PaymentRecord", table = "payment_record_data", data_service = "postgres")]
pub struct PaymentRecord {
#[teaql(id)]
    id: u64,

// @source payment_model.xml:57
    channel_trade_no: String,

// @source payment_model.xml:57
    extra_params: String,

// @source payment_model.xml:57
    create_time: chrono::DateTime<chrono::Utc>,

// @source payment_model.xml:57
    update_time: chrono::DateTime<chrono::Utc>,
#[teaql(version)]
    version: i64,
// @source payment_model.xml:57
#[teaql(column = "channel")]
    channel_id: u64,

// @source payment_model.xml:57
#[teaql(column = "\"order\"")]
    order_id: u64,

// @source payment_model.xml:57
#[teaql(column = "platform")]
    platform_id: u64,
// @source payment_model.xml:57
#[teaql(relation(target = "PaymentChannelType", local_key = "channel_id", foreign_key = "id"))]
    channel: Option<crate::PaymentChannelType>,

// @source payment_model.xml:57
#[teaql(relation(target = "PaymentOrder", local_key = "order_id", foreign_key = "id"))]
    order: Option<crate::PaymentOrder>,

// @source payment_model.xml:57
#[teaql(relation(target = "Platform", local_key = "platform_id", foreign_key = "id"))]
    platform: Option<crate::Platform>,
    #[teaql(dynamic)]
    dynamic: BTreeMap<String, teaql_core::Value>,
    #[teaql(skip)]
    root: teaql_runtime::EntityRoot,
    #[teaql(skip)]
    pub __load_state: teaql_core::eval::LoadState,
}

impl PaymentRecord {
    pub fn with_id(id: u64) -> teaql_core::Value {
        teaql_core::Value::U64(id)
    }

    pub(crate) fn runtime_new(root: teaql_runtime::EntityRoot) -> Self {
        Self {
            id: 0_u64,
            channel_trade_no: String::new(),
            extra_params: String::new(),
            create_time: chrono::Utc::now(),
            update_time: chrono::Utc::now(),
            version: 0_i64,
            channel_id: 0_u64,
            order_id: 0_u64,
            platform_id: 0_u64,
            channel: None,
            order: None,
            platform: None,
            dynamic: BTreeMap::new(),
            root,
            __load_state: teaql_core::eval::LoadState::FullyLoaded,
        }
    }

    pub fn entity_key(&self) -> teaql_runtime::EntityKey {
        teaql_runtime::EntityKey::new("PaymentRecord", self.id)
    }

    pub fn attach_root_recursive(&mut self, root: teaql_runtime::EntityRoot) {
        self.root = root.clone();
        if let Some(entity) = &mut self.channel {
            entity.attach_root_recursive(root.clone());
        }
        if let Some(entity) = &mut self.order {
            entity.attach_root_recursive(root.clone());
        }
        if let Some(entity) = &mut self.platform {
            entity.attach_root_recursive(root.clone());
        }
    }

    pub fn is_loaded(&self, field_or_relation: &str) -> bool {
        self.__load_state.is_loaded(field_or_relation)
    }

    pub fn set_load_state(&mut self, state: teaql_core::eval::LoadState) {
        self.__load_state = state;
    }

    pub fn id(&self) -> u64 {
        self.changed_id().and_then(|value| value.try_u64()).unwrap_or(self.id)
    }

    pub fn update_id(&mut self, value: impl Into<teaql_core::Value>) -> &mut Self {
        let value = value.into();
        self.id = value.try_u64().unwrap_or(self.id.clone());
        self.root.set(self.entity_key(), "id", value);
        self
    }

    pub fn changed_id(&self) -> Option<teaql_core::Value> {
        self.root.get(&self.entity_key(), "id")
    }

    pub fn eval_id(&self) -> teaql_core::eval::EvalResult<u64> {
        if !self.is_loaded("id") {
                    teaql_core::eval::EvalResult::NotLoaded { failed_node: "id".to_string(), attempted_path: "id".to_string() }
                } else {
                    teaql_core::eval::EvalResult::Value(self.id())
                }}

    pub fn channel_trade_no(&self) -> String {
        self.changed_channel_trade_no().and_then(|value| value.try_text().map(|value| value.to_owned())).unwrap_or_else(|| self.channel_trade_no.clone())
    }

    pub fn update_channel_trade_no(&mut self, value: impl Into<teaql_core::Value>) -> &mut Self {
        let value = value.into();
        self.channel_trade_no = value.try_text().map(|value| value.trim().to_owned()).unwrap_or_else(|| self.channel_trade_no.clone());
        self.root.set(self.entity_key(), "channel_trade_no", value);
        self
    }

    pub fn changed_channel_trade_no(&self) -> Option<teaql_core::Value> {
        self.root.get(&self.entity_key(), "channel_trade_no")
    }

    pub fn eval_channel_trade_no(&self) -> teaql_core::eval::EvalResult<String> {
        if !self.is_loaded("channel_trade_no") {
                    teaql_core::eval::EvalResult::NotLoaded { failed_node: "channel_trade_no".to_string(), attempted_path: "channel_trade_no".to_string() }
                } else {
                    teaql_core::eval::EvalResult::Value(self.channel_trade_no())
                }}

    pub fn extra_params(&self) -> String {
        self.changed_extra_params().and_then(|value| value.try_text().map(|value| value.to_owned())).unwrap_or_else(|| self.extra_params.clone())
    }

    pub fn update_extra_params(&mut self, value: impl Into<teaql_core::Value>) -> &mut Self {
        let value = value.into();
        self.extra_params = value.try_text().map(|value| value.trim().to_owned()).unwrap_or_else(|| self.extra_params.clone());
        self.root.set(self.entity_key(), "extra_params", value);
        self
    }

    pub fn changed_extra_params(&self) -> Option<teaql_core::Value> {
        self.root.get(&self.entity_key(), "extra_params")
    }

    pub fn eval_extra_params(&self) -> teaql_core::eval::EvalResult<String> {
        if !self.is_loaded("extra_params") {
                    teaql_core::eval::EvalResult::NotLoaded { failed_node: "extra_params".to_string(), attempted_path: "extra_params".to_string() }
                } else {
                    teaql_core::eval::EvalResult::Value(self.extra_params())
                }}

    pub fn create_time(&self) -> chrono::DateTime<chrono::Utc> {
        self.changed_create_time().and_then(|value| value.try_timestamp()).unwrap_or(self.create_time)
    }

    pub fn update_create_time(&mut self, value: impl Into<teaql_core::Value>) -> &mut Self {
        let value = value.into();
        self.create_time = value.try_timestamp().unwrap_or(self.create_time.clone());
        self.root.set(self.entity_key(), "create_time", value);
        self
    }

    pub fn changed_create_time(&self) -> Option<teaql_core::Value> {
        self.root.get(&self.entity_key(), "create_time")
    }

    pub fn eval_create_time(&self) -> teaql_core::eval::EvalResult<chrono::DateTime<chrono::Utc>> {
        if !self.is_loaded("create_time") {
                    teaql_core::eval::EvalResult::NotLoaded { failed_node: "create_time".to_string(), attempted_path: "create_time".to_string() }
                } else {
                    teaql_core::eval::EvalResult::Value(self.create_time())
                }}

    pub fn update_time(&self) -> chrono::DateTime<chrono::Utc> {
        self.changed_update_time().and_then(|value| value.try_timestamp()).unwrap_or(self.update_time)
    }

    pub fn update_update_time(&mut self, value: impl Into<teaql_core::Value>) -> &mut Self {
        let value = value.into();
        self.update_time = value.try_timestamp().unwrap_or(self.update_time.clone());
        self.root.set(self.entity_key(), "update_time", value);
        self
    }

    pub fn changed_update_time(&self) -> Option<teaql_core::Value> {
        self.root.get(&self.entity_key(), "update_time")
    }

    pub fn eval_update_time(&self) -> teaql_core::eval::EvalResult<chrono::DateTime<chrono::Utc>> {
        if !self.is_loaded("update_time") {
                    teaql_core::eval::EvalResult::NotLoaded { failed_node: "update_time".to_string(), attempted_path: "update_time".to_string() }
                } else {
                    teaql_core::eval::EvalResult::Value(self.update_time())
                }}

    pub fn version(&self) -> i64 {
        self.changed_version().and_then(|value| value.try_i64()).unwrap_or(self.version)
    }

    pub fn update_version(&mut self, value: impl Into<teaql_core::Value>) -> &mut Self {
        let value = value.into();
        self.version = value.try_i64().unwrap_or(self.version.clone());
        self.root.set(self.entity_key(), "version", value);
        self
    }

    pub fn changed_version(&self) -> Option<teaql_core::Value> {
        self.root.get(&self.entity_key(), "version")
    }

    pub fn eval_version(&self) -> teaql_core::eval::EvalResult<i64> {
        if !self.is_loaded("version") {
                    teaql_core::eval::EvalResult::NotLoaded { failed_node: "version".to_string(), attempted_path: "version".to_string() }
                } else {
                    teaql_core::eval::EvalResult::Value(self.version())
                }}
    pub fn channel_id(&self) -> u64 {
        self.changed_channel_id().and_then(|value| value.try_u64()).unwrap_or(self.channel_id)
    }

    pub(crate) fn update_channel_id(&mut self, value: impl Into<teaql_core::Value>) -> &mut Self {
        let value = value.into();
        self.channel_id = value.try_u64().unwrap_or(self.channel_id.clone());
        self.root.set(self.entity_key(), "channel_id", value);
        self
    }

    pub fn changed_channel_id(&self) -> Option<teaql_core::Value> {
        self.root.get(&self.entity_key(), "channel_id")
    }

    pub fn eval_channel_id(&self) -> teaql_core::eval::EvalResult<u64> {
        if !self.is_loaded("channel_id") {
                    teaql_core::eval::EvalResult::NotLoaded { failed_node: "channel_id".to_string(), attempted_path: "channel_id".to_string() }
                } else {
                    teaql_core::eval::EvalResult::Value(self.channel_id())
                }}

    pub fn order_id(&self) -> u64 {
        self.changed_order_id().and_then(|value| value.try_u64()).unwrap_or(self.order_id)
    }

    pub fn update_order_id(&mut self, value: impl Into<teaql_core::Value>) -> &mut Self {
        let value = value.into();
        self.order_id = value.try_u64().unwrap_or(self.order_id.clone());
        self.root.set(self.entity_key(), "order_id", value);
        self
    }

    pub fn changed_order_id(&self) -> Option<teaql_core::Value> {
        self.root.get(&self.entity_key(), "order_id")
    }

    pub fn eval_order_id(&self) -> teaql_core::eval::EvalResult<u64> {
        if !self.is_loaded("order_id") {
                    teaql_core::eval::EvalResult::NotLoaded { failed_node: "order_id".to_string(), attempted_path: "order_id".to_string() }
                } else {
                    teaql_core::eval::EvalResult::Value(self.order_id())
                }}

    pub fn platform_id(&self) -> u64 {
        self.changed_platform_id().and_then(|value| value.try_u64()).unwrap_or(self.platform_id)
    }

    pub fn update_platform_id(&mut self, value: impl Into<teaql_core::Value>) -> &mut Self {
        let value = value.into();
        self.platform_id = value.try_u64().unwrap_or(self.platform_id.clone());
        self.root.set(self.entity_key(), "platform_id", value);
        self
    }

    pub fn changed_platform_id(&self) -> Option<teaql_core::Value> {
        self.root.get(&self.entity_key(), "platform_id")
    }

    pub fn eval_platform_id(&self) -> teaql_core::eval::EvalResult<u64> {
        if !self.is_loaded("platform_id") {
                    teaql_core::eval::EvalResult::NotLoaded { failed_node: "platform_id".to_string(), attempted_path: "platform_id".to_string() }
                } else {
                    teaql_core::eval::EvalResult::Value(self.platform_id())
                }}
    pub fn update_channel_to_alipay(&mut self) -> &mut Self {
        self.update_channel_id(1001_u64)
    }

    pub fn channel_is_alipay(&self) -> bool {
        self.channel_id() == 1001_u64
    }
    pub fn update_channel_to_wechat(&mut self) -> &mut Self {
        self.update_channel_id(1002_u64)
    }

    pub fn channel_is_wechat(&self) -> bool {
        self.channel_id() == 1002_u64
    }
    pub fn update_channel_to_stripe(&mut self) -> &mut Self {
        self.update_channel_id(1003_u64)
    }

    pub fn channel_is_stripe(&self) -> bool {
        self.channel_id() == 1003_u64
    }
    pub fn channel(&self) -> Option<&crate::PaymentChannelType> {
        self.channel.as_ref()
    }

    pub fn eval_channel(&self) -> teaql_core::eval::EvalResult<&crate::PaymentChannelType> {
        if !self.is_loaded("channel") {
            teaql_core::eval::EvalResult::NotLoaded { failed_node: "channel".to_string(), attempted_path: "channel".to_string() }
        } else {
            match &self.channel {
                Some(v) => teaql_core::eval::EvalResult::Value(v),
                None => teaql_core::eval::EvalResult::Null,
            }
        }
    }

    pub fn order(&self) -> Option<&crate::PaymentOrder> {
        self.order.as_ref()
    }

    pub fn eval_order(&self) -> teaql_core::eval::EvalResult<&crate::PaymentOrder> {
        if !self.is_loaded("order") {
            teaql_core::eval::EvalResult::NotLoaded { failed_node: "order".to_string(), attempted_path: "order".to_string() }
        } else {
            match &self.order {
                Some(v) => teaql_core::eval::EvalResult::Value(v),
                None => teaql_core::eval::EvalResult::Null,
            }
        }
    }

    pub fn platform(&self) -> Option<&crate::Platform> {
        self.platform.as_ref()
    }

    pub fn eval_platform(&self) -> teaql_core::eval::EvalResult<&crate::Platform> {
        if !self.is_loaded("platform") {
            teaql_core::eval::EvalResult::NotLoaded { failed_node: "platform".to_string(), attempted_path: "platform".to_string() }
        } else {
            match &self.platform {
                Some(v) => teaql_core::eval::EvalResult::Value(v),
                None => teaql_core::eval::EvalResult::Null,
            }
        }
    }

    pub fn mark_as_delete(&mut self) -> &mut Self {
        self.root.mark_as_delete(self.entity_key());
        self
    }

    pub fn set_comment(&mut self, comment: impl Into<String>) -> &mut Self {
        self.root.set_comment(comment);
        self
    }

    pub(crate) async fn save<'a, C>(
        &self,
        ctx: &'a C,
    ) -> Result<teaql_runtime::GraphNode, crate::TeaqlDataServiceError<C::PaymentRecordRepository<'a>>>
    where
        C: crate::TeaqlRepositoryProvider + ?Sized,
    {
        let root = ctx.user_context().entity_root();
        let key = self.entity_key();
        let has_ledger_change = (self.id != 0)
            && (root.current_change_set().changes().contains_key(&key)
                || root.is_marked_as_delete(&key)
                || root.is_new(&key));
        let repository = ctx
            .payment_record_repository()
            .map_err(|err| teaql_runtime::DataServiceError::Runtime(teaql_runtime::RuntimeError::Graph(err.to_string())))?;
        if has_ledger_change {
            crate::TeaqlEntityRepository::save_entity_ledger(&repository, root.clone()).await?;
            return Ok(teaql_runtime::GraphNode::new("PaymentRecord"));
        }
        crate::TeaqlEntityRepository::save_entity_graph(&repository, self.clone()).await
    }
}

