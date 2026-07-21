use axum::{
    routing::{post, get},
    Router, Json, extract::{State, Query}, http::StatusCode,
};
use serde::{Deserialize, Serialize};
use std::sync::Arc;
use teaql_cloud_starter::{
    CloudApp,
};
use payment_service_core::{
    Q, PaymentOrder, PaymentRecord, CachedMerchant,
    service_runtime_from_env, ServiceRuntime,
    teaql_core::Entity,
};
use teaql_runtime::AuditedSaveExt;
use rust_decimal::Decimal;

#[derive(Clone)]
struct AppState {
    ctx: Arc<ServiceRuntime>,
    processed_events: Arc<tokio::sync::RwLock<std::collections::HashSet<String>>>,
}

#[tokio::main]
async fn main() -> Result<(), Box<dyn std::error::Error>> {
    // 1. Initialize TeaQL Runtime from environment variables
    let mut runtime = service_runtime_from_env().await?;
    if let Some(executor) = runtime.get_resource::<payment_service_core::ServiceRuntimeExecutor>() {
        runtime.register_executor(executor.clone());
    }
    let state = AppState {
        ctx: Arc::new(runtime),
        processed_events: Arc::new(tokio::sync::RwLock::new(std::collections::HashSet::new())),
    };

    let business_routes = Router::new()
        .route("/api/pay/create", post(create_payment))
        .route("/api/pay/callback", post(payment_callback))
        .route("/api/pay/status", get(get_status))
        .route("/api/internal/sync-merchant", post(sync_merchant))
        .route("/health", get(|| async { Json(serde_json::json!({"status": "ok"})) }))
        .with_state(state);

    tokio::spawn(async {
        let client = reqwest::Client::new();
        let consul_host = std::env::var("CONSUL_HOST").unwrap_or_else(|_| "http://consul:8500".to_string());
        let ip = std::env::var("POD_IP").unwrap_or_else(|_| "axum-payment-service".to_string());
        let port = 8080;
        let url = format!("{}/v1/agent/service/register", consul_host);
        
        let payload = serde_json::json!({
            "Name": "axum-payment-service",
            "Address": ip,
            "Port": port,
            "Check": {
                "HTTP": format!("http://{}:{}/health", ip, port),
                "Interval": "10s",
                "Timeout": "3s"
            }
        });
        
        tokio::time::sleep(std::time::Duration::from_secs(3)).await;
        match client.put(&url).json(&payload).send().await {
            Ok(_) => println!("Successfully registered with Consul at {}", consul_host),
            Err(e) => eprintln!("Failed to register with Consul: {}", e),
        }
    });

    // 2. Start using the cloud starter (sets up actuator, and handles shutdown)
    CloudApp::new()
        .service_name("axum-payment-service")
        .port(8080)
        .routes(business_routes)
        .start()
        .await?;

    Ok(())
}

// --- DTOs ---

#[derive(Deserialize)]
struct CreateOrderDto {
    merchant_id: String,
    order_no: String,
    amount: Decimal,
    currency: String,
    channel: String, // ALIPAY, WECHAT, STRIPE
    client_ip: Option<String>,
}

#[derive(Serialize)]
struct CreateOrderVo {
    payment_id: u64,
    pay_url: String,
}

#[derive(Deserialize)]
struct CallbackDto {
    payment_id: u64,
    trade_no: String,
    success: bool,
    extra_params: Option<String>,
}

#[derive(Deserialize)]
struct StatusQuery {
    payment_id: u64,
}

#[derive(Serialize)]
struct StatusVo {
    payment_id: u64,
    status: String,
    paid_at: Option<String>,
}

#[derive(Deserialize)]
struct MerchantSyncDto {
    id: String,
    app_key: String,
    is_active: bool,
    event_id: String,
}

// --- Handlers ---

/// Creates a PaymentOrder and PaymentRecord locally in payment_db after validating merchant.
async fn create_payment(
    State(state): State<AppState>,
    Json(payload): Json<CreateOrderDto>
) -> Result<Json<CreateOrderVo>, (StatusCode, String)> {
    let merchant_id_num = payload.merchant_id.parse::<u64>().unwrap_or(0);

    // 1. Check merchant status locally
    let merchant = Q::cached_merchants()
        .with_id_is(merchant_id_num)
        .purpose("validate_merchant")
        .execute_for_list(state.ctx.as_ref())
        .await
        .map_err(|e| (StatusCode::INTERNAL_SERVER_ERROR, e.to_string()))?;

    if merchant.is_empty() {
        return Err((StatusCode::BAD_REQUEST, "Merchant not synced yet".to_string()));
    }

    if !merchant[0].is_active() {
        return Err((StatusCode::FORBIDDEN, "Merchant is suspended".to_string()));
    }

    // 2. Validate channel enum
    let channel_code = payload.channel.to_uppercase();
    let channel_db = Q::payment_channel_types()
        .with_code_is(channel_code.as_str())
        .purpose("validate_channel")
        .execute_for_list(state.ctx.as_ref())
        .await
        .map_err(|e| (StatusCode::INTERNAL_SERVER_ERROR, e.to_string()))?;

    if channel_db.is_empty() {
        return Err((StatusCode::BAD_REQUEST, "Invalid payment channel".to_string()));
    }

    // 3. Create and save order first to obtain auto-generated ID
    let mut order = Q::payment_orders().purpose("create_order").new_entity(state.ctx.as_ref());
    order
        .update_merchant_id(payload.merchant_id)
        .update_merchant_order_no(payload.order_no)
        .update_amount(payload.amount)
        .update_currency(payload.currency)
        .update_status_to_created();

    if let Some(ip) = payload.client_ip {
        order.update_client_ip(ip);
    }

    let saved_order = order
        .audit_as("Initiate Transaction Order")
        .save(state.ctx.as_ref())
        .await
        .map_err(|e| (StatusCode::INTERNAL_SERVER_ERROR, e.to_string()))?;

    let payment_id = saved_order.id().and_then(|v| v.try_u64()).unwrap_or(0);

    // 4. Create and save record linking to the order
    let mut record = Q::payment_records().purpose("create_record").new_entity(state.ctx.as_ref());
    record.update_order_id(payment_id);
    
    // Set channel using generated strong-typed helper methods
    match channel_code.as_str() {
        "ALIPAY" => record.update_channel_to_alipay(),
        "WECHAT" => record.update_channel_to_wechat(),
        "STRIPE" => record.update_channel_to_stripe(),
        _ => &mut record
    };

    record
        .audit_as("Initiate Transaction Record")
        .save(state.ctx.as_ref())
        .await
        .map_err(|e| (StatusCode::INTERNAL_SERVER_ERROR, e.to_string()))?;

    Ok(Json(CreateOrderVo {
        payment_id,
        pay_url: format!("https://gateway.pay/{}", payment_id),
    }))
}

/// Receives external webhook payment callback and transitions order status.
async fn payment_callback(
    State(state): State<AppState>,
    Json(payload): Json<CallbackDto>
) -> Result<StatusCode, (StatusCode, String)> {
    // 1. Fetch order
    let orders = Q::payment_orders()
        .with_id_is(payload.payment_id)
        .purpose("fetch_order_for_callback")
        .execute_for_list(state.ctx.as_ref())
        .await
        .map_err(|e| (StatusCode::INTERNAL_SERVER_ERROR, e.to_string()))?;

    if orders.is_empty() {
        return Err((StatusCode::NOT_FOUND, "Payment order not found".to_string()));
    }

    let mut order = orders[0].clone();

    // 2. Strong typed state machine transition validation
    if !order.status_is_created() && !order.status_is_paying() {
        return Err((StatusCode::BAD_REQUEST, "Payment order already in final state".to_string()));
    }

    if payload.success {
        order.update_status_to_success();
        order.update_paid_at(chrono::Utc::now());
    } else {
        order.update_status_to_failed();
    }

    // 3. Update records (add trade transaction number)
    let records = Q::payment_records()
        .with_order_matching(Q::payment_orders().with_id_is(payload.payment_id))
        .purpose("fetch_record_for_callback")
        .execute_for_list(state.ctx.as_ref())
        .await
        .map_err(|e| (StatusCode::INTERNAL_SERVER_ERROR, e.to_string()))?;

    if !records.is_empty() {
        let mut rec = records[0].clone();
        rec.update_channel_trade_no(payload.trade_no);
        if let Some(extra) = payload.extra_params {
            rec.update_extra_params(extra);
        }
        rec.clear_relations();
        rec.audit_as("Update transaction callback record")
            .save(state.ctx.as_ref())
            .await
            .map_err(|e| (StatusCode::INTERNAL_SERVER_ERROR, e.to_string()))?;
    }

    // Save order
    order.clear_relations();
    order.audit_as("Update transaction callback order")
        .save(state.ctx.as_ref())
        .await
        .map_err(|e| (StatusCode::INTERNAL_SERVER_ERROR, e.to_string()))?;

    Ok(StatusCode::OK)
}

/// Returns the current payment status.
async fn get_status(
    State(state): State<AppState>,
    Query(query): Query<StatusQuery>
) -> Result<Json<StatusVo>, (StatusCode, String)> {
    let orders = Q::payment_orders()
        .with_id_is(query.payment_id)
        .purpose("get_order_status")
        .execute_for_list(state.ctx.as_ref())
        .await
        .map_err(|e| (StatusCode::INTERNAL_SERVER_ERROR, e.to_string()))?;

    if orders.is_empty() {
        return Err((StatusCode::NOT_FOUND, "Payment order not found".to_string()));
    }

    let order = &orders[0];
    let status_str = if order.status_is_created() {
        "CREATED"
    } else if order.status_is_paying() {
        "PAYING"
    } else if order.status_is_success() {
        "SUCCESS"
    } else if order.status_is_failed() {
        "FAILED"
    } else {
        "REFUNDED"
    };

    Ok(Json(StatusVo {
        payment_id: order.id(),
        status: status_str.to_string(),
        paid_at: order.paid_at().map(|t| t.to_rfc3339()),
    }))
}

/// Sync endpoint called by Java Merchant Service.
async fn sync_merchant(
    State(state): State<AppState>,
    Json(payload): Json<MerchantSyncDto>
) -> Result<StatusCode, (StatusCode, String)> {
    let idempotency_key = format!("{}:{}", payload.id, payload.event_id);
    {
        let mut events = state.processed_events.write().await;
        if events.contains(&idempotency_key) {
            println!("Event {} already processed, skipping.", idempotency_key);
            return Ok(StatusCode::OK);
        }
        events.insert(idempotency_key.clone());
    }

    let merchant_id = payload.id.parse::<u64>().unwrap_or(0);

    // Check if merchant already exists to decide whether to update or create
    let existing = Q::cached_merchants()
        .with_id_is(merchant_id)
        .purpose("check_existing_merchant")
        .execute_for_list(state.ctx.as_ref())
        .await
        .map_err(|e| (StatusCode::INTERNAL_SERVER_ERROR, e.to_string()))?;

    let mut cached = if !existing.is_empty() {
        existing[0].clone()
    } else {
        let mut new_entity = Q::cached_merchants().purpose("sync_create").new_entity(state.ctx.as_ref());
        new_entity.update_id(merchant_id);
        new_entity
    };

    cached
        .update_app_key(payload.app_key)
        .update_is_active(payload.is_active)
        .update_update_time(chrono::Utc::now());

    cached
        .audit_as("Sync merchant data")
        .save(state.ctx.as_ref())
        .await
        .map_err(|e| (StatusCode::INTERNAL_SERVER_ERROR, e.to_string()))?;

    Ok(StatusCode::OK)
}
