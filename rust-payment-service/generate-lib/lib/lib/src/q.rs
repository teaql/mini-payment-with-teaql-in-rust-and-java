use teaql_core::Expr;

use crate::*;

pub struct PurposedQuery<T> {
    pub inner: T,
    pub purpose: String,
}

impl<T> PurposedQuery<T> {
    pub fn new(inner: T, purpose: impl Into<String>) -> Self {
        Self { inner, purpose: purpose.into() }
    }
}

pub struct Q;

impl Q {
    pub fn platforms() -> PlatformRequest {
        PlatformRequest::new()
            .select_self()
            .and_filter(Expr::gt("version", 0_i64))
    }

    pub fn platforms_minimal() -> PlatformRequest {
        PlatformRequest::new()
            .and_filter(Expr::gt("version", 0_i64))
    }

    pub fn platforms_with_children() -> PlatformRequest {
        PlatformRequest::new()
            .unlimited()
            .select_self_fields()
            .enhance_children_if_needed()
    }

    pub fn cached_merchants() -> CachedMerchantRequest {
        CachedMerchantRequest::new()
            .select_self()
            .and_filter(Expr::gt("version", 0_i64))
    }

    pub fn cached_merchants_minimal() -> CachedMerchantRequest {
        CachedMerchantRequest::new()
            .and_filter(Expr::gt("version", 0_i64))
    }

    pub fn cached_merchants_with_children() -> CachedMerchantRequest {
        CachedMerchantRequest::new()
            .unlimited()
            .select_self_fields()
            .enhance_children_if_needed()
    }

    pub fn payment_orders() -> PaymentOrderRequest {
        PaymentOrderRequest::new()
            .select_self()
            .and_filter(Expr::gt("version", 0_i64))
    }

    pub fn payment_orders_minimal() -> PaymentOrderRequest {
        PaymentOrderRequest::new()
            .and_filter(Expr::gt("version", 0_i64))
    }

    pub fn payment_orders_with_children() -> PaymentOrderRequest {
        PaymentOrderRequest::new()
            .unlimited()
            .select_self_fields()
            .enhance_children_if_needed()
    }

    pub fn payment_records() -> PaymentRecordRequest {
        PaymentRecordRequest::new()
            .select_self()
            .and_filter(Expr::gt("version", 0_i64))
    }

    pub fn payment_records_minimal() -> PaymentRecordRequest {
        PaymentRecordRequest::new()
            .and_filter(Expr::gt("version", 0_i64))
    }

    pub fn payment_records_with_children() -> PaymentRecordRequest {
        PaymentRecordRequest::new()
            .unlimited()
            .select_self_fields()
            .enhance_children_if_needed()
    }

    pub fn payment_status_types() -> PaymentStatusTypeRequest {
        PaymentStatusTypeRequest::new()
            .select_self()
            .and_filter(Expr::gt("version", 0_i64))
    }

    pub fn payment_status_types_minimal() -> PaymentStatusTypeRequest {
        PaymentStatusTypeRequest::new()
            .and_filter(Expr::gt("version", 0_i64))
    }

    pub fn payment_status_types_with_children() -> PaymentStatusTypeRequest {
        PaymentStatusTypeRequest::new()
            .unlimited()
            .select_self_fields()
            .enhance_children_if_needed()
    }

    pub fn payment_channel_types() -> PaymentChannelTypeRequest {
        PaymentChannelTypeRequest::new()
            .select_self()
            .and_filter(Expr::gt("version", 0_i64))
    }

    pub fn payment_channel_types_minimal() -> PaymentChannelTypeRequest {
        PaymentChannelTypeRequest::new()
            .and_filter(Expr::gt("version", 0_i64))
    }

    pub fn payment_channel_types_with_children() -> PaymentChannelTypeRequest {
        PaymentChannelTypeRequest::new()
            .unlimited()
            .select_self_fields()
            .enhance_children_if_needed()
    }
}