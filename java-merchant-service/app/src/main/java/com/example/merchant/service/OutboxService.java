package com.example.merchant.service;

import com.doublechaintech.merchantservice.Constants;
import com.doublechaintech.merchantservice.Q;
import com.doublechaintech.merchantservice.merchant.Merchant;
import com.doublechaintech.merchantservice.outboxevent.OutboxEvent;
import io.teaql.core.SmartList;
import io.teaql.core.UserContext;
import io.teaql.runtime.DefaultUserContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@Service
public class OutboxService {
    private static final Logger log = LoggerFactory.getLogger(OutboxService.class);

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private io.teaql.runtime.TeaQLRuntime teaqlRuntime;

    @Value("${payment.service.rust.url}")
    private String rustServiceUrl;

    /**
     * Immediate async delivery trigger.
     */
    @Async
    public void triggerSyncAsync(Long eventId) {
        log.info("Triggering immediate outbox sync async for event: {}", eventId);
        try {
            processEvent(eventId);
        } catch (Exception e) {
            log.error("Immediate outbox sync failed for event: " + eventId, e);
        }
    }

    /**
     * Scheduled fallback retry delivery. Runs every 5 seconds.
     */
    @Scheduled(fixedDelay = 5000)
    public void pollAndSync() {
        try {
            UserContext systemCtx = createSystemContext();

            // Poll pending events using generated strong-typed helper method
            SmartList<OutboxEvent> pendingEvents = Q.outboxEvents()
                    .withStatusIsPending()
                    .comment("Poll pending outbox events")
                    .purpose("Retry sync to Rust")
                    .executeForList(systemCtx);

            // Poll failed events using generated strong-typed helper method
            SmartList<OutboxEvent> failedEvents = Q.outboxEvents()
                    .withStatusIsFailed()
                    .comment("Poll failed outbox events")
                    .purpose("Retry sync to Rust")
                    .executeForList(systemCtx);

            for (OutboxEvent event : pendingEvents) {
                syncEvent(event, systemCtx);
            }

            for (OutboxEvent event : failedEvents) {
                syncEvent(event, systemCtx);
            }
        } catch (Exception e) {
            log.error("Outbox poll and sync failed", e);
        }
    }

    private UserContext createSystemContext() {
        return new DefaultUserContext(teaqlRuntime);
    }

    private void processEvent(Long eventId) {
        UserContext systemCtx = createSystemContext();
        OutboxEvent event = Q.outboxEvents()
                .withIdIs(eventId)
                .comment("Find outbox event for sync")
                .purpose("Immediate async delivery")
                .executeForOne(systemCtx);
        if (event != null) {
            syncEvent(event, systemCtx);
        }
    }

    private void syncEvent(OutboxEvent event, UserContext ctx) {
        log.info("Syncing outbox event: id={}, merchant_id={}", event.getId(), event.getMerchant().getId());
        
        try {
            // Load associated merchant
            Merchant merchant = Q.merchants()
                    .withIdIs(event.getMerchant().getId())
                    .comment("Load merchant for sync")
                    .purpose("Get status and app_key for outbox payload")
                    .executeForOne(ctx);

            if (merchant == null) {
                log.warn("Merchant not found for outbox event: {}", event.getId());
                event.updateStatusToFailed();
                event.auditAs("Merchant not found").save(ctx);
                return;
            }

            // Build payload
            Map<String, Object> payload = new HashMap<>();
            payload.put("id", String.valueOf(merchant.getId()));
            payload.put("app_key", merchant.getAppKey());
            payload.put("is_active", merchant.isStatusActive());

            // POST to Rust
            restTemplate.postForEntity(rustServiceUrl, payload, String.class);

            // Update status to PROCESSED
            event.updateStatusToProcessed();
            event.updateProcessedAt(LocalDateTime.now());
            event.auditAs("Successfully synced to Rust payment service").save(ctx);
            log.info("Successfully synced merchant {} to Rust", merchant.getId());

        } catch (Exception e) {
            log.error("Failed to sync outbox event " + event.getId() + " to Rust", e);
            event.updateStatusToFailed();
            event.auditAs("Sync failed: " + e.getMessage()).save(ctx);
        }
    }
}
