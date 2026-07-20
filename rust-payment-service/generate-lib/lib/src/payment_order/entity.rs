// ⛔ AI agents: DO NOT read this file for API discovery. Instead run: cargo teaql --input modeling/MODEL.xml rust-assist-query/payment_order
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
#[teaql(entity = "PaymentOrder", table = "payment_order_data", data_service = "postgres")]
pub struct PaymentOrder {
#[teaql(id)]
    id: u64,

// @source payment_model.xml:44
    merchant_id: String,

// @source payment_model.xml:44
    merchant_order_no: String,

// @source payment_model.xml:44
    amount: rust_decimal::Decimal,

// @source payment_model.xml:44
    currency: String,

// @source payment_model.xml:44
    client_ip: String,

// @source payment_model.xml:44
    create_time: chrono::DateTime<chrono::Utc>,

// @source payment_model.xml:44
    update_time: chrono::DateTime<chrono::Utc>,

// @source payment_model.xml:44
    paid_at: Option<chrono::DateTime<chrono::Utc>>,
#[teaql(version)]
    version: i64,
// @source payment_model.xml:44
#[teaql(column = "status")]
    status_id: u64,

// @source payment_model.xml:44
#[teaql(column = "platform")]
    platform_id: u64,
// @source payment_model.xml:44
#[teaql(relation(target = "PaymentStatusType", local_key = "status_id", foreign_key = "id"))]
    status: Option<crate::PaymentStatusType>,

// @source payment_model.xml:44
#[teaql(relation(target = "Platform", local_key = "platform_id", foreign_key = "id"))]
    platform: Option<crate::Platform>,
#[teaql(relation(target = "PaymentRecord", local_key = "id", foreign_key = "order_id", many))]
    payment_record_list: SmartList<crate::PaymentRecord>,
    #[teaql(dynamic)]
    dynamic: BTreeMap<String, teaql_core::Value>,
    #[teaql(skip)]
    root: teaql_runtime::EntityRoot,
    #[teaql(skip)]
    pub __load_state: teaql_core::eval::LoadState,
}

impl PaymentOrder {
    pub fn clear_relations(&mut self) {
        self.status = None;
        self.platform = None;
    }

    pub fn with_id(id: u64) -> teaql_core::Value {
        teaql_core::Value::U64(id)
    }

    pub(crate) fn runtime_new(root: teaql_runtime::EntityRoot) -> Self {
        Self {
            id: 0_u64,
            merchant_id: String::new(),
            merchant_order_no: String::new(),
            amount: rust_decimal::Decimal::ZERO,
            currency: String::new(),
            client_ip: String::new(),
            create_time: chrono::Utc::now(),
            update_time: chrono::Utc::now(),
            paid_at: None,
            version: 0_i64,
            status_id: 0_u64,
            platform_id: 0_u64,
            status: None,
            platform: None,
            payment_record_list: Default::default(),
            dynamic: BTreeMap::new(),
            root,
            __load_state: teaql_core::eval::LoadState::FullyLoaded,
        }
    }

    pub fn entity_key(&self) -> teaql_runtime::EntityKey {
        teaql_runtime::EntityKey::new("PaymentOrder", self.id)
    }

    pub fn attach_root_recursive(&mut self, root: teaql_runtime::EntityRoot) {
        self.root = root.clone();
        if let Some(entity) = &mut self.status {
            entity.attach_root_recursive(root.clone());
        }
        if let Some(entity) = &mut self.platform {
            entity.attach_root_recursive(root.clone());
        }
        for entity in &mut self.payment_record_list {
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

    pub fn merchant_id(&self) -> String {
        self.changed_merchant_id().and_then(|value| value.try_text().map(|value| value.to_owned())).unwrap_or_else(|| self.merchant_id.clone())
    }

    pub fn update_merchant_id(&mut self, value: impl Into<teaql_core::Value>) -> &mut Self {
        let value = value.into();
        self.merchant_id = value.try_text().map(|value| value.trim().to_owned()).unwrap_or_else(|| self.merchant_id.clone());
        self.root.set(self.entity_key(), "merchant_id", value);
        self
    }

    pub fn changed_merchant_id(&self) -> Option<teaql_core::Value> {
        self.root.get(&self.entity_key(), "merchant_id")
    }

    pub fn eval_merchant_id(&self) -> teaql_core::eval::EvalResult<String> {
        if !self.is_loaded("merchant_id") {
                    teaql_core::eval::EvalResult::NotLoaded { failed_node: "merchant_id".to_string(), attempted_path: "merchant_id".to_string() }
                } else {
                    teaql_core::eval::EvalResult::Value(self.merchant_id())
                }}

    pub fn merchant_order_no(&self) -> String {
        self.changed_merchant_order_no().and_then(|value| value.try_text().map(|value| value.to_owned())).unwrap_or_else(|| self.merchant_order_no.clone())
    }

    pub fn update_merchant_order_no(&mut self, value: impl Into<teaql_core::Value>) -> &mut Self {
        let value = value.into();
        self.merchant_order_no = value.try_text().map(|value| value.trim().to_owned()).unwrap_or_else(|| self.merchant_order_no.clone());
        self.root.set(self.entity_key(), "merchant_order_no", value);
        self
    }

    pub fn changed_merchant_order_no(&self) -> Option<teaql_core::Value> {
        self.root.get(&self.entity_key(), "merchant_order_no")
    }

    pub fn eval_merchant_order_no(&self) -> teaql_core::eval::EvalResult<String> {
        if !self.is_loaded("merchant_order_no") {
                    teaql_core::eval::EvalResult::NotLoaded { failed_node: "merchant_order_no".to_string(), attempted_path: "merchant_order_no".to_string() }
                } else {
                    teaql_core::eval::EvalResult::Value(self.merchant_order_no())
                }}

    pub fn amount(&self) -> rust_decimal::Decimal {
        self.changed_amount().and_then(|value| value.try_decimal()).unwrap_or(self.amount)
    }

    pub fn update_amount(&mut self, value: impl Into<teaql_core::Value>) -> &mut Self {
        let value = value.into();
        self.amount = value.try_decimal().unwrap_or(self.amount.clone());
        self.root.set(self.entity_key(), "amount", value);
        self
    }

    pub fn changed_amount(&self) -> Option<teaql_core::Value> {
        self.root.get(&self.entity_key(), "amount")
    }

    pub fn eval_amount(&self) -> teaql_core::eval::EvalResult<rust_decimal::Decimal> {
        if !self.is_loaded("amount") {
                    teaql_core::eval::EvalResult::NotLoaded { failed_node: "amount".to_string(), attempted_path: "amount".to_string() }
                } else {
                    teaql_core::eval::EvalResult::Value(self.amount())
                }}

    pub fn currency(&self) -> String {
        self.changed_currency().and_then(|value| value.try_text().map(|value| value.to_owned())).unwrap_or_else(|| self.currency.clone())
    }

    pub fn update_currency(&mut self, value: impl Into<teaql_core::Value>) -> &mut Self {
        let value = value.into();
        self.currency = value.try_text().map(|value| value.trim().to_owned()).unwrap_or_else(|| self.currency.clone());
        self.root.set(self.entity_key(), "currency", value);
        self
    }

    pub fn changed_currency(&self) -> Option<teaql_core::Value> {
        self.root.get(&self.entity_key(), "currency")
    }

    pub fn eval_currency(&self) -> teaql_core::eval::EvalResult<String> {
        if !self.is_loaded("currency") {
                    teaql_core::eval::EvalResult::NotLoaded { failed_node: "currency".to_string(), attempted_path: "currency".to_string() }
                } else {
                    teaql_core::eval::EvalResult::Value(self.currency())
                }}

    pub fn client_ip(&self) -> String {
        self.changed_client_ip().and_then(|value| value.try_text().map(|value| value.to_owned())).unwrap_or_else(|| self.client_ip.clone())
    }

    pub fn update_client_ip(&mut self, value: impl Into<teaql_core::Value>) -> &mut Self {
        let value = value.into();
        self.client_ip = value.try_text().map(|value| value.trim().to_owned()).unwrap_or_else(|| self.client_ip.clone());
        self.root.set(self.entity_key(), "client_ip", value);
        self
    }

    pub fn changed_client_ip(&self) -> Option<teaql_core::Value> {
        self.root.get(&self.entity_key(), "client_ip")
    }

    pub fn eval_client_ip(&self) -> teaql_core::eval::EvalResult<String> {
        if !self.is_loaded("client_ip") {
                    teaql_core::eval::EvalResult::NotLoaded { failed_node: "client_ip".to_string(), attempted_path: "client_ip".to_string() }
                } else {
                    teaql_core::eval::EvalResult::Value(self.client_ip())
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

    pub fn paid_at(&self) -> Option<chrono::DateTime<chrono::Utc>> {
        self.paid_at.clone()
    }

    pub fn update_paid_at(&mut self, value: impl Into<teaql_core::Value>) -> &mut Self {
        let value = value.into();
        self.paid_at = if matches!(value, teaql_core::Value::Null) { None } else { value.try_timestamp().map(Some).unwrap_or_else(|| self.paid_at.clone()) };
        self.root.set(self.entity_key(), "paid_at", value);
        self
    }

    pub fn changed_paid_at(&self) -> Option<teaql_core::Value> {
        self.root.get(&self.entity_key(), "paid_at")
    }

    pub fn eval_paid_at(&self) -> teaql_core::eval::EvalResult<Option<chrono::DateTime<chrono::Utc>>> {
        if !self.is_loaded("paid_at") {
                    teaql_core::eval::EvalResult::NotLoaded { failed_node: "paid_at".to_string(), attempted_path: "paid_at".to_string() }
                } else {
                    match &self.paid_at {
                        Some(v) => teaql_core::eval::EvalResult::Value(Some(v.clone())),
                        None => teaql_core::eval::EvalResult::Null,
                    }
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
    pub fn status_id(&self) -> u64 {
        self.changed_status_id().and_then(|value| value.try_u64()).unwrap_or(self.status_id)
    }

    pub(crate) fn update_status_id(&mut self, value: impl Into<teaql_core::Value>) -> &mut Self {
        let value = value.into();
        self.status_id = value.try_u64().unwrap_or(self.status_id.clone());
        self.root.set(self.entity_key(), "status_id", value);
        self
    }

    pub fn changed_status_id(&self) -> Option<teaql_core::Value> {
        self.root.get(&self.entity_key(), "status_id")
    }

    pub fn eval_status_id(&self) -> teaql_core::eval::EvalResult<u64> {
        if !self.is_loaded("status_id") {
                    teaql_core::eval::EvalResult::NotLoaded { failed_node: "status_id".to_string(), attempted_path: "status_id".to_string() }
                } else {
                    teaql_core::eval::EvalResult::Value(self.status_id())
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
    pub fn update_status_to_created(&mut self) -> &mut Self {
        self.update_status_id(1001_u64)
    }

    pub fn status_is_created(&self) -> bool {
        self.status_id() == 1001_u64
    }
    pub fn update_status_to_paying(&mut self) -> &mut Self {
        self.update_status_id(1002_u64)
    }

    pub fn status_is_paying(&self) -> bool {
        self.status_id() == 1002_u64
    }
    pub fn update_status_to_success(&mut self) -> &mut Self {
        self.update_status_id(1003_u64)
    }

    pub fn status_is_success(&self) -> bool {
        self.status_id() == 1003_u64
    }
    pub fn update_status_to_failed(&mut self) -> &mut Self {
        self.update_status_id(1004_u64)
    }

    pub fn status_is_failed(&self) -> bool {
        self.status_id() == 1004_u64
    }
    pub fn update_status_to_refunded(&mut self) -> &mut Self {
        self.update_status_id(1005_u64)
    }

    pub fn status_is_refunded(&self) -> bool {
        self.status_id() == 1005_u64
    }
    pub fn status(&self) -> Option<&crate::PaymentStatusType> {
        self.status.as_ref()
    }

    pub fn eval_status(&self) -> teaql_core::eval::EvalResult<&crate::PaymentStatusType> {
        if !self.is_loaded("status") {
            teaql_core::eval::EvalResult::NotLoaded { failed_node: "status".to_string(), attempted_path: "status".to_string() }
        } else {
            match &self.status {
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
    ) -> Result<teaql_runtime::GraphNode, crate::TeaqlDataServiceError<C::PaymentOrderRepository<'a>>>
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
            .payment_order_repository()
            .map_err(|err| teaql_runtime::DataServiceError::Runtime(teaql_runtime::RuntimeError::Graph(err.to_string())))?;
        if has_ledger_change {
            crate::TeaqlEntityRepository::save_entity_ledger(&repository, root.clone()).await?;
            return Ok(teaql_runtime::GraphNode::new("PaymentOrder"));
        }
        crate::TeaqlEntityRepository::save_entity_graph(&repository, self.clone()).await
    }
}

