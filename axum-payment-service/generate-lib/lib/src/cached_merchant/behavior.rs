use teaql_runtime::EntityDataServiceBehavior;

#[derive(Clone, Debug, Default)]
pub struct CachedMerchantBehavior;

impl EntityDataServiceBehavior for CachedMerchantBehavior {}