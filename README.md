# TeaQL Mini Payment Platform

**Java for business complexity. Rust for runtime-critical services.
TeaQL for a consistent engineering experience.**

This repository demonstrates how Java and Rust can coexist in a
microservice-based payment platform without forcing services to share
one domain model or one codebase.

The Java service handles merchant onboarding, KYC, approvals and
integration-heavy workflows. The Rust service handles client-facing
payment execution, callbacks and high-concurrency workloads.

Each service owns its domain model, database and deployment lifecycle.
TeaQL provides a consistent way to model, query, audit, test and evolve
both services.

## Architecture Overview

The system is split into two microservices, following the **Database-per-Service** design principle:

```
                  +-----------------------------------------+
                  |         Java Merchant Service           |
                  |  (Merchant Registry, KYC, Approvals)    |
                  +--------------------+--------------------+
                                       |
                   (1) Writes Merchant & OutboxEvent
                                       v
                                +------+------+
                                | merchant_db |
                                +------+------+
                                       |
                   (2) Fetches Target IP from Consul
                                       |
                   +-------------------v-------------------+
                   |          Consul Registry              |
                   |  (Service Discovery & Load Balancing) |
                   +-------------------+-------------------+
                                       |
                   (3) HTTP Sync Event (Load Balanced)
                                       v
                  +--------------------+--------------------+
                  |         Rust Payment Service            |
                  |  (High-Concurrency Orders & webhooks)   |
                  +--------------------+--------------------+
                                       |
                   (4) Writes Orders & Cached Merchants
                                       v
                                +------+------+
                                | payment_db  |
                                +------+------+
```

1. **Spring Cloud Merchant Service** (`spring-cloud-merchant-service/`):
   - Handles merchant registration, KYC document verification, and status updates (Pending -> Active -> Suspended).
   - Uses the **Transactional Outbox Pattern** via TeaQL. Status updates and outbox events are persisted in `merchant_db` in a single local transaction.
   - An asynchronous task triggers immediate sync post-commit. It queries **Consul** to discover available instances of the Rust Payment Service and sends the sync payload using a LoadBalanced `RestTemplate`.

2. **Axum Payment Service** (`axum-payment-service/`):
   - High-concurrency client-facing checkout service built with **Axum** and **TeaQL Cloud Starter**.
   - Upon startup, it automatically registers itself with the **Consul Registry**, enabling Java services to discover and route traffic to it.
   - Maintains a local `CachedMerchant` table to authenticate incoming checkout calls instantly without making gRPC/HTTP round-trips to the Java service.
   - Exposes internal sync endpoints for Java to propagate merchant status changes, and webhook callback endpoints for payment gateways.

---

## Technical Features

- **Typed Constants & States**: System states (e.g., payment status `CREATED`, `SUCCESS`, `FAILED`) are modeled as typed entities, automatically populated during schema migration. Helper methods like `.status_is_success()` and `.update_status_to_success()` prevent invalid state updates.
- **Micro-Audit Trails & Purposes**: Every DB read or write requires specifying a business purpose (e.g., `Q.merchants().purpose("validate_merchant")` or `order.audit_as("Initiate Transaction").save()`). This guarantees that SQL logs and telemetry capture the intent of every action.
- **Spring Boot & Axum Integration**: Seamlessly integrates with Spring Boot's dependency injection / transactional management on the Java side, and Axum's routing and state management on the Rust side.

---

## FAQ: Addressing Engineering Concerns

Engineers often question if a unified data model can truly bridge the cognitive gaps in memory management and concurrency control across different programming languages. Here is how this architecture addresses those concerns:

### 1. Local Introduction, Zero Global Intrusion (Perfect Bounded Context)
This is a microservice-level local introduction, not a global binding. This offers the biggest reassurance for technical decision-makers, as payment systems are highly sensitive to systemic risks. Since different microservices can adopt different technology stacks, organizations can pilot this in high-traffic C-end services (like "core transaction routing" or "payment gateway") while keeping legacy accounting and clearing systems completely untouched. This Evolutionary Architecture perfectly meets the stability requirements of financial institutions.
* **Evidence in code**: The project physically isolates the domain models into two distinct, non-intrusive schemas within the `models/` folder (`merchant_model.xml` and `payment_model.xml`).

### 2. From Black Box to "White Box + Intent Audit"
The DSL semantics are close to natural language, meaning architects, business experts, and compliance teams can directly review the models. Coupled with detailed intent logs and audit trails, this is not an unsettling "black box code generator", but an engine with built-in auditability and observability. For payment systems frequently facing external regulations and internal troubleshooting, this white-box nature and intent tracking are massive advantages.
* **Evidence in code**: Both Java and Rust code mandate the declaration of business intent on database interactions. In either language, reads require a `.purpose("...")` (e.g., "Get status for payload"), and writes/state changes require an `.audit_as("...")` (e.g., "Initiate Transaction Order"), ensuring a complete semantic evidence chain across the entire hybrid architecture.

### 3. Cognitive Decoupling
This is a pragmatic engineering management approach. Forcing a unified mental model is often a disaster for cross-language team collaboration. By using the DSL as a mandatory contract:
* **Java engineers** can stay in their Spring Cloud comfort zone to handle complex business logic, approval flows, and outbox patterns.
* **Rust engineers** can focus on maximizing performance, memory layouts, and high-concurrency async runtimes (Axum) for checkout APIs.
Both sides perform their respective duties without interference, completely smoothing out the cognitive overhead of cross-language data assembly and state synchronization.

These points demonstrate that this design is not a theoretical invention, but a pragmatic solution born from a deep understanding of real commercial engineering pain points.

---

## Configuration & Getting Started

### 1. Database Setup

Ensure PostgreSQL is running and create the databases:

```sql
CREATE DATABASE merchant_db;
CREATE DATABASE payment_db;
```

> **Note**: TeaQL automatically executes schema migrations on startup. All tables, foreign keys, and indexes will be generated automatically when the services boot.

### 2. Run Java Merchant Service

Navigate to the directory:
```bash
cd spring-cloud-merchant-service
```

First, compile and install the generated TeaQL domain library:
```bash
cd generate-lib/lib
mvn clean install -DskipTests
cd ../../
```

Now run the Spring Boot application:
```bash
cd app
mvn spring-boot:run
```
The service will start on port `8081` (or as configured in `application.properties`), and automatically register with the local Consul server.

### 3. Run Rust Payment Service

Navigate to the directory:
```bash
cd axum-payment-service
```

Set the database environment variables:
```bash
export PAYMENT_SERVICE_CORE_DATABASE_URL="host=127.0.0.1 dbname=payment_db user=postgres password=postgres"
export PAYMENT_SERVICE_CORE_DATABASE_USER="postgres"
export PAYMENT_SERVICE_CORE_DATABASE_PASSWORD="postgres"
export SCHEMA_MODE="execute"
```

Compile and run the Axum server:
```bash
cargo run
```
The payment service registers with Consul, exposes health metrics, and listens on port `8080`.

---

## API Endpoints

### Java Merchant Service:
- `POST /api/merchant/register`: Registers a new merchant with KYC details.
- `POST /api/merchant/{id}/approve`: Approves a merchant (transitions to `ACTIVE` and pushes sync event).
- `POST /api/merchant/{id}/suspend`: Suspends a merchant (transitions to `SUSPENDED` and pushes sync event).
- `GET /api/merchant/{id}`: Retrieves merchant profile.

### Rust Payment Service:
- `POST /api/pay/create`: Initiates a checkout transaction.
- `POST /api/pay/callback`: Simulates payment gateway status callback.
- `GET /api/pay/status`: Checks payment transaction status.
- `POST /api/internal/sync-merchant`: Internal endpoint called by Java to synchronize merchant state.
