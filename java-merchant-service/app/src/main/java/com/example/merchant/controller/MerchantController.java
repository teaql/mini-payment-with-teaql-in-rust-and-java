package com.example.merchant.controller;

import com.doublechaintech.merchantservice.Constants;
import com.doublechaintech.merchantservice.Q;
import com.doublechaintech.merchantservice.merchant.Merchant;
import com.doublechaintech.merchantservice.merchantkyc.MerchantKyc;
import com.doublechaintech.merchantservice.outboxevent.OutboxEvent;
import com.example.merchant.service.OutboxService;
import io.teaql.core.UserContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;

@RestController
@RequestMapping("/api/merchant")
public class MerchantController {

    @Autowired
    private UserContext userContext;

    @Autowired
    private OutboxService outboxService;

    @PostMapping("/register")
    @Transactional
    public ResponseEntity<?> register(@RequestBody RegisterDto payload) {
        // 1. Create Merchant
        Merchant merchant = new Merchant();
        merchant.updateCompanyName(payload.companyName);
        merchant.updateContactEmail(payload.contactEmail);
        merchant.updateAppKey(payload.appKey);
        merchant.updatePlatform(Constants.PLATFORM);
        merchant.updateStatusToPendingVerification();
        merchant.auditAs("Register merchant").save(userContext);

        // 2. Create KYC
        MerchantKyc kyc = new MerchantKyc();
        kyc.updateBusinessLicenseNo(payload.businessLicenseNo);
        kyc.updateLegalPerson(payload.legalPerson);
        kyc.updateBankAccountNo(payload.bankAccountNo);
        kyc.updateMerchant(merchant);
        kyc.auditAs("Create KYC profile").save(userContext);

        // 3. Create OutboxEvent (pending)
        OutboxEvent event = new OutboxEvent();
        event.updateEventType("MERCHANT_UPSERT");
        event.updatePayload("{}");
        event.updateStatusToPending();
        event.updateMerchant(merchant);
        event.auditAs("Enqueue registration outbox event").save(userContext);

        // Commit transaction, then trigger async sync
        outboxService.triggerSyncAsync(event.getId());

        return ResponseEntity.ok(merchant);
    }

    @PostMapping("/{id}/approve")
    @Transactional
    public ResponseEntity<?> approve(@PathVariable Long id) {
        Merchant merchant = Q.merchants()
                .withIdIs(id)
                .comment("Find merchant for approval")
                .purpose("Approve KYC details")
                .executeForOne(userContext);

        if (merchant == null) {
            return ResponseEntity.notFound().build();
        }

        if (merchant.isStatusActive()) {
            return ResponseEntity.badRequest().body("Merchant is already active");
        }

        // 1. Transition merchant status
        merchant.updateStatusToActive();
        merchant.auditAs("Approve merchant").save(userContext);

        // 2. Log Outbox Event
        OutboxEvent event = new OutboxEvent();
        event.updateEventType("MERCHANT_UPSERT");
        event.updatePayload("{}");
        event.updateStatusToPending();
        event.updateMerchant(merchant);
        event.auditAs("Enqueue approval outbox event").save(userContext);

        // Trigger immediate async sync
        outboxService.triggerSyncAsync(event.getId());

        return ResponseEntity.ok(merchant);
    }

    @PostMapping("/{id}/suspend")
    @Transactional
    public ResponseEntity<?> suspend(@PathVariable Long id) {
        Merchant merchant = Q.merchants()
                .withIdIs(id)
                .comment("Find merchant for suspension")
                .purpose("Suspend violating merchant")
                .executeForOne(userContext);

        if (merchant == null) {
            return ResponseEntity.notFound().build();
        }

        // 1. Transition merchant status
        merchant.updateStatusToSuspended();
        merchant.auditAs("Suspend merchant").save(userContext);

        // 2. Log Outbox Event
        OutboxEvent event = new OutboxEvent();
        event.updateEventType("MERCHANT_UPSERT");
        event.updatePayload("{}");
        event.updateStatusToPending();
        event.updateMerchant(merchant);
        event.auditAs("Enqueue suspension outbox event").save(userContext);

        // Trigger immediate async sync
        outboxService.triggerSyncAsync(event.getId());

        return ResponseEntity.ok(merchant);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> get(@PathVariable Long id) {
        Merchant merchant = Q.merchants()
                .withIdIs(id)
                .comment("Get merchant details")
                .purpose("Display profile")
                .executeForOne(userContext);

        if (merchant == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(merchant);
    }

    // --- Inner classes for request mapping ---
    public static class RegisterDto {
        public String companyName;
        public String contactEmail;
        public String appKey;
        public String businessLicenseNo;
        public String legalPerson;
        public String bankAccountNo;
    }

    // --- HTTP Client Configuration helper bean ---
    @Configuration
    static class RestConfig {
        @Bean
        @LoadBalanced
        public RestTemplate restTemplate() {
            return new RestTemplate();
        }
    }
}
