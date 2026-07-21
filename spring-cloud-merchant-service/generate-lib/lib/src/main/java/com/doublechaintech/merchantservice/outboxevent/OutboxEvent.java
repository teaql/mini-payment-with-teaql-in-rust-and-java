package com.doublechaintech.merchantservice.outboxevent;

import com.doublechaintech.merchantservice.Constants;
import com.doublechaintech.merchantservice.eventstatustype.EventStatusType;
import com.doublechaintech.merchantservice.merchant.Merchant;
import io.teaql.core.Audited;
import io.teaql.core.BaseEntity;
import io.teaql.core.EntityStatus;
import io.teaql.core.FrameworkInternal;
import io.teaql.core.RemoteInput;
import java.time.LocalDateTime;
import java.util.Objects;

/**
 * [TEAQL AI WARNING]
 * TeaQL was explicitly designed to PREVENT AI hallucinations and random guessing.
 * DO NOT GUESS METHOD NAMES!
 * The methods listed below are the ONLY valid ways to interact with this entity.
 * If you encounter compilation errors (e.g., method not found), DO NOT guess another method name.
 * Read the method signatures in this file before proceeding.
 */
public class OutboxEvent extends BaseEntity implements RemoteInput {
    public static String INTERNAL_TYPE = "OutboxEvent";

    public static final String EVENT_TYPE_PROPERTY = "eventType";
    public static final String PAYLOAD_PROPERTY = "payload";
    public static final String STATUS_PROPERTY = "status";
    public static final String MERCHANT_PROPERTY = "merchant";
    public static final String CREATE_TIME_PROPERTY = "createTime";
    public static final String UPDATE_TIME_PROPERTY = "updateTime";
    public static final String PROCESSED_AT_PROPERTY = "processedAt";
    private String eventType;
    private String payload;
    private EventStatusType status;
    private Merchant merchant;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
    private LocalDateTime processedAt;
    public static final String RETRY_COUNT_PROPERTY = "retryCount";
    public static final String LAST_ERROR_PROPERTY = "lastError";
    private Integer retryCount;
    private String lastError;

    public String getEventType(){
        return this.eventType;
    }
    public String getPayload(){
        return this.payload;
    }
    public EventStatusType getStatus(){
        return this.status;
    }
    public Merchant getMerchant(){
        return this.merchant;
    }
    public LocalDateTime getCreateTime(){
        return this.createTime;
    }
    public LocalDateTime getUpdateTime(){
        return this.updateTime;
    }
    public LocalDateTime getProcessedAt(){
        return this.processedAt;
    }
    public Integer getRetryCount(){
        return this.retryCount;
    }
    public String getLastError(){
        return this.lastError;
    }
    public OutboxEvent updateEventType(String eventType){
        eventType = (eventType == null ? null : eventType.trim());
        if(Objects.equals(this.eventType, eventType)){
            return this;
        }
        handleUpdate(EVENT_TYPE_PROPERTY, getEventType(), eventType);
        this.eventType = eventType;
        return this;
    }
    public OutboxEvent updatePayload(String payload){
        payload = (payload == null ? null : payload.trim());
        if(Objects.equals(this.payload, payload)){
            return this;
        }
        handleUpdate(PAYLOAD_PROPERTY, getPayload(), payload);
        this.payload = payload;
        return this;
    }
    protected OutboxEvent updateStatus(EventStatusType status){
        if(Objects.equals(this.status, status)){
            return this;
        }
        handleUpdate(STATUS_PROPERTY, getStatus(), status);
        this.status = status;
        return this;
    }
    public OutboxEvent updateMerchant(Merchant merchant){
        if(Objects.equals(this.merchant, merchant)){
            return this;
        }
        handleUpdate(MERCHANT_PROPERTY, getMerchant(), merchant);
        this.merchant = merchant;
        return this;
    }
    public OutboxEvent updateCreateTime(LocalDateTime createTime){
        if(Objects.equals(this.createTime, createTime)){
            return this;
        }
        handleUpdate(CREATE_TIME_PROPERTY, getCreateTime(), createTime);
        this.createTime = createTime;
        return this;
    }
    public OutboxEvent updateUpdateTime(LocalDateTime updateTime){
        if(Objects.equals(this.updateTime, updateTime)){
            return this;
        }
        handleUpdate(UPDATE_TIME_PROPERTY, getUpdateTime(), updateTime);
        this.updateTime = updateTime;
        return this;
    }
    public OutboxEvent updateProcessedAt(LocalDateTime processedAt){
        if(Objects.equals(this.processedAt, processedAt)){
            return this;
        }
        handleUpdate(PROCESSED_AT_PROPERTY, getProcessedAt(), processedAt);
        this.processedAt = processedAt;
        return this;
    }
    public OutboxEvent updateRetryCount(Integer retryCount){
        if(Objects.equals(this.retryCount, retryCount)){
            return this;
        }
        handleUpdate(RETRY_COUNT_PROPERTY, getRetryCount(), retryCount);
        this.retryCount = retryCount;
        return this;
    }
    public OutboxEvent updateLastError(String lastError){
        lastError = (lastError == null ? null : lastError.trim());
        if(Objects.equals(this.lastError, lastError)){
            return this;
        }
        handleUpdate(LAST_ERROR_PROPERTY, getLastError(), lastError);
        this.lastError = lastError;
        return this;
    }
    public boolean isStatusPending(){
        return Objects.equals(getStatus(), Constants.EVENT_STATUS_TYPE_PENDING);
    }

    public OutboxEvent updateStatusToPending(){
        return updateStatus(Constants.EVENT_STATUS_TYPE_PENDING);
    }
    public boolean isStatusProcessed(){
        return Objects.equals(getStatus(), Constants.EVENT_STATUS_TYPE_PROCESSED);
    }

    public OutboxEvent updateStatusToProcessed(){
        return updateStatus(Constants.EVENT_STATUS_TYPE_PROCESSED);
    }
    public boolean isStatusFailed(){
        return Objects.equals(getStatus(), Constants.EVENT_STATUS_TYPE_FAILED);
    }

    public OutboxEvent updateStatusToFailed(){
        return updateStatus(Constants.EVENT_STATUS_TYPE_FAILED);
    }
    public OutboxEvent updateStatusToDeadLetter(){
        return updateStatus(Constants.EVENT_STATUS_TYPE_DEAD_LETTER);
    }

    public static OutboxEvent refer(Long id){
        OutboxEvent refer = new OutboxEvent();
        refer.__internalSet("id", id);
        refer.set$status(EntityStatus.REFER);
        return refer;
    }
    @Override
    public String typeName(){
        return INTERNAL_TYPE;
    }

    public OutboxEvent comment(String comment){
        this.setComment(comment);
        return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public Audited<OutboxEvent> auditAs(String action) {
        return super.auditAs(action);
    }

    // ===== Framework Internal: generated switch dispatch =====
    @Override
    @FrameworkInternal
    public void __internalSet(String property, Object value) {
        switch (property) {
            case "eventType": this.eventType = (value == null ? null : ((String)value).trim()); break;

            case "payload": this.payload = (value == null ? null : ((String)value).trim()); break;

            case "status": this.status = (EventStatusType) value; break;

            case "merchant": this.merchant = (Merchant) value; break;

            case "createTime": this.createTime = (LocalDateTime) value; break;

            case "updateTime": this.updateTime = (LocalDateTime) value; break;

            case "processedAt": this.processedAt = (LocalDateTime) value; break;

            case "retryCount": this.retryCount = value instanceof Number ? ((Number)value).intValue() : (Integer) value; break;

            case "lastError": this.lastError = (value == null ? null : ((String)value).trim()); break;

            default: super.__internalSet(property, value);
        }
    }

    @Override
    @FrameworkInternal
    public Object __internalGet(String property) {
        switch (property) {
            case "eventType": return this.eventType;
            case "payload": return this.payload;
            case "status": return this.status;
            case "merchant": return this.merchant;
            case "createTime": return this.createTime;
            case "updateTime": return this.updateTime;
            case "processedAt": return this.processedAt;
            case "retryCount": return this.retryCount;
            case "lastError": return this.lastError;
            default: return super.__internalGet(property);
        }
    }

}