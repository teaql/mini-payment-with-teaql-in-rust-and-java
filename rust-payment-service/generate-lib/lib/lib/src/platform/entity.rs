// ⛔ AI agents: DO NOT read this file for API discovery. Instead run: cargo teaql --input modeling/MODEL.xml rust-assist-query/platform
use std::collections::BTreeMap;

use teaql_core::SmartList;
use teaql_macros::TeaqlEntity;

/// [TEAQL AI WARNING]
/// TeaQL was explicitly designed to PREVENT AI hallucinations and random guessing.
/// DO NOT GUESS METHOD NAMES!
/// The methods listed below are the ONLY valid ways to interact with this entity.
/// If you encounter compilation errors (e.g., method not found), DO NOT guess another method name.
/// Read the method signatures in this file before proceeding.
#[derive(Clone, Debug, PartialEq, TeaqlEntity)]
#[teaql(entity = "Platform", table = "platform_data", data_service = "postgres")]
pub struct Platform {
#[teaql(id)]
    id: u64,

// @source payment_model.xml:17
    name: String,

// @source payment_model.xml:17
    create_time: chrono::DateTime<chrono::Utc>,

// @source payment_model.xml:17
    update_time: chrono::DateTime<chrono::Utc>,
#[teaql(version)]
    version: i64,
#[teaql(relation(target = "CachedMerchant", local_key = "id", foreign_key = "platform_id", many))]
    cached_merchant_list: SmartList<crate::CachedMerchant>,
#[teaql(relation(target = "PaymentOrder", local_key = "id", foreign_key = "platform_id", many))]
    payment_order_list: SmartList<crate::PaymentOrder>,
#[teaql(relation(target = "PaymentRecord", local_key = "id", foreign_key = "platform_id", many))]
    payment_record_list: SmartList<crate::PaymentRecord>,
#[teaql(relation(target = "PaymentStatusType", local_key = "id", foreign_key = "platform_id", many))]
    payment_status_type_list: SmartList<crate::PaymentStatusType>,
#[teaql(relation(target = "PaymentChannelType", local_key = "id", foreign_key = "platform_id", many))]
    payment_channel_type_list: SmartList<crate::PaymentChannelType>,
    #[teaql(dynamic)]
    dynamic: BTreeMap<String, teaql_core::Value>,
    #[teaql(skip)]
    root: teaql_runtime::EntityRoot,
    #[teaql(skip)]
    pub __load_state: teaql_core::eval::LoadState,
}

impl Platform {
    pub fn with_id(id: u64) -> teaql_core::Value {
        teaql_core::Value::U64(id)
    }

    pub(crate) fn runtime_new(root: teaql_runtime::EntityRoot) -> Self {
        Self {
            id: 0_u64,
            name: String::new(),
            create_time: chrono::Utc::now(),
            update_time: chrono::Utc::now(),
            version: 0_i64,
            cached_merchant_list: Default::default(),
            payment_order_list: Default::default(),
            payment_record_list: Default::default(),
            payment_status_type_list: Default::default(),
            payment_channel_type_list: Default::default(),
            dynamic: BTreeMap::new(),
            root,
            __load_state: teaql_core::eval::LoadState::FullyLoaded,
        }
    }

    pub fn entity_key(&self) -> teaql_runtime::EntityKey {
        teaql_runtime::EntityKey::new("Platform", self.id)
    }

    pub fn attach_root_recursive(&mut self, root: teaql_runtime::EntityRoot) {
        self.root = root.clone();
        for entity in &mut self.cached_merchant_list {
            entity.attach_root_recursive(root.clone());
        }
        for entity in &mut self.payment_order_list {
            entity.attach_root_recursive(root.clone());
        }
        for entity in &mut self.payment_record_list {
            entity.attach_root_recursive(root.clone());
        }
        for entity in &mut self.payment_status_type_list {
            entity.attach_root_recursive(root.clone());
        }
        for entity in &mut self.payment_channel_type_list {
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

    pub fn name(&self) -> String {
        self.changed_name().and_then(|value| value.try_text().map(|value| value.to_owned())).unwrap_or_else(|| self.name.clone())
    }

    pub fn update_name(&mut self, value: impl Into<teaql_core::Value>) -> &mut Self {
        let value = value.into();
        self.name = value.try_text().map(|value| value.trim().to_owned()).unwrap_or_else(|| self.name.clone());
        self.root.set(self.entity_key(), "name", value);
        self
    }

    pub fn changed_name(&self) -> Option<teaql_core::Value> {
        self.root.get(&self.entity_key(), "name")
    }

    pub fn eval_name(&self) -> teaql_core::eval::EvalResult<String> {
        if !self.is_loaded("name") {
                    teaql_core::eval::EvalResult::NotLoaded { failed_node: "name".to_string(), attempted_path: "name".to_string() }
                } else {
                    teaql_core::eval::EvalResult::Value(self.name())
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
    pub fn cached_merchant_list(&self) -> &SmartList<crate::CachedMerchant> {
        &self.cached_merchant_list
    }

    pub fn cached_merchant_list_mut(&mut self) -> &mut SmartList<crate::CachedMerchant> {
        &mut self.cached_merchant_list
    }

    pub fn eval_cached_merchant_list(&self) -> teaql_core::eval::EvalResult<&SmartList<crate::CachedMerchant>> {
        if !self.is_loaded("cached_merchant_list") {
            teaql_core::eval::EvalResult::NotLoaded { failed_node: "cached_merchant_list".to_string(), attempted_path: "cached_merchant_list".to_string() }
        } else {
            teaql_core::eval::EvalResult::Value(&self.cached_merchant_list)
        }
    }

    pub fn payment_order_list(&self) -> &SmartList<crate::PaymentOrder> {
        &self.payment_order_list
    }

    pub fn payment_order_list_mut(&mut self) -> &mut SmartList<crate::PaymentOrder> {
        &mut self.payment_order_list
    }

    pub fn eval_payment_order_list(&self) -> teaql_core::eval::EvalResult<&SmartList<crate::PaymentOrder>> {
        if !self.is_loaded("payment_order_list") {
            teaql_core::eval::EvalResult::NotLoaded { failed_node: "payment_order_list".to_string(), attempted_path: "payment_order_list".to_string() }
        } else {
            teaql_core::eval::EvalResult::Value(&self.payment_order_list)
        }
    }

    pub fn payment_record_list(&self) -> &SmartList<crate::PaymentRecord> {
        &self.payment_record_list
    }

    pub fn payment_record_list_mut(&mut self) -> &mut SmartList<crate::PaymentRecord> {
        &mut self.payment_record_list
    }

    pub fn eval_payment_record_list(&self) -> teaql_core::eval::EvalResult<&SmartList<crate::PaymentRecord>> {
        if !self.is_loaded("payment_record_list") {
            teaql_core::eval::EvalResult::NotLoaded { failed_node: "payment_record_list".to_string(), attempted_path: "payment_record_list".to_string() }
        } else {
            teaql_core::eval::EvalResult::Value(&self.payment_record_list)
        }
    }

    pub fn payment_status_type_list(&self) -> &SmartList<crate::PaymentStatusType> {
        &self.payment_status_type_list
    }

    pub fn payment_status_type_list_mut(&mut self) -> &mut SmartList<crate::PaymentStatusType> {
        &mut self.payment_status_type_list
    }

    pub fn eval_payment_status_type_list(&self) -> teaql_core::eval::EvalResult<&SmartList<crate::PaymentStatusType>> {
        if !self.is_loaded("payment_status_type_list") {
            teaql_core::eval::EvalResult::NotLoaded { failed_node: "payment_status_type_list".to_string(), attempted_path: "payment_status_type_list".to_string() }
        } else {
            teaql_core::eval::EvalResult::Value(&self.payment_status_type_list)
        }
    }

    pub fn payment_channel_type_list(&self) -> &SmartList<crate::PaymentChannelType> {
        &self.payment_channel_type_list
    }

    pub fn payment_channel_type_list_mut(&mut self) -> &mut SmartList<crate::PaymentChannelType> {
        &mut self.payment_channel_type_list
    }

    pub fn eval_payment_channel_type_list(&self) -> teaql_core::eval::EvalResult<&SmartList<crate::PaymentChannelType>> {
        if !self.is_loaded("payment_channel_type_list") {
            teaql_core::eval::EvalResult::NotLoaded { failed_node: "payment_channel_type_list".to_string(), attempted_path: "payment_channel_type_list".to_string() }
        } else {
            teaql_core::eval::EvalResult::Value(&self.payment_channel_type_list)
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
    ) -> Result<teaql_runtime::GraphNode, crate::TeaqlDataServiceError<C::PlatformRepository<'a>>>
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
            .platform_repository()
            .map_err(|err| teaql_runtime::DataServiceError::Runtime(teaql_runtime::RuntimeError::Graph(err.to_string())))?;
        if has_ledger_change {
            crate::TeaqlEntityRepository::save_entity_ledger(&repository, root.clone()).await?;
            return Ok(teaql_runtime::GraphNode::new("Platform"));
        }
        crate::TeaqlEntityRepository::save_entity_graph(&repository, self.clone()).await
    }
}

