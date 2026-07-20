package com.doublechaintech.merchantservice.merchant;

import com.doublechaintech.merchantservice.Constants;
import com.doublechaintech.merchantservice.merchantkyc.MerchantKyc;
import com.doublechaintech.merchantservice.merchantstatustype.MerchantStatusType;
import com.doublechaintech.merchantservice.outboxevent.OutboxEvent;
import com.doublechaintech.merchantservice.platform.Platform;
import io.teaql.core.Audited;
import io.teaql.core.BaseEntity;
import io.teaql.core.EntityStatus;
import io.teaql.core.FrameworkInternal;
import io.teaql.core.RemoteInput;
import io.teaql.core.SmartList;
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
public class Merchant extends BaseEntity implements RemoteInput {
    public static String INTERNAL_TYPE = "Merchant";

    public static final String COMPANY_NAME_PROPERTY = "companyName";
    public static final String CONTACT_EMAIL_PROPERTY = "contactEmail";
    public static final String APP_KEY_PROPERTY = "appKey";
    public static final String STATUS_PROPERTY = "status";
    public static final String PLATFORM_PROPERTY = "platform";
    public static final String CREATE_TIME_PROPERTY = "createTime";
    public static final String UPDATE_TIME_PROPERTY = "updateTime";
    public static final String MERCHANT_KYC_LIST_PROPERTY = "merchantKycList";
    public static final String OUTBOX_EVENT_LIST_PROPERTY = "outboxEventList";
    private String companyName;
    private String contactEmail;
    private String appKey;
    private MerchantStatusType status;
    private Platform platform;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
    private SmartList<MerchantKyc> merchantKycList;
    private SmartList<OutboxEvent> outboxEventList;

    public String getCompanyName(){
        return this.companyName;
    }
    public String getContactEmail(){
        return this.contactEmail;
    }
    public String getAppKey(){
        return this.appKey;
    }
    public MerchantStatusType getStatus(){
        return this.status;
    }
    public Platform getPlatform(){
        return this.platform;
    }
    public LocalDateTime getCreateTime(){
        return this.createTime;
    }
    public LocalDateTime getUpdateTime(){
        return this.updateTime;
    }
    public SmartList<MerchantKyc> getMerchantKycList(){
        return this.merchantKycList;
    }
    public SmartList<OutboxEvent> getOutboxEventList(){
        return this.outboxEventList;
    }
    public Merchant updateCompanyName(String companyName){
        companyName = (companyName == null ? null : companyName.trim());
        if(Objects.equals(this.companyName, companyName)){
            return this;
        }
        handleUpdate(COMPANY_NAME_PROPERTY, getCompanyName(), companyName);
        this.companyName = companyName;
        return this;
    }
    public Merchant updateContactEmail(String contactEmail){
        contactEmail = (contactEmail == null ? null : contactEmail.trim());
        if(Objects.equals(this.contactEmail, contactEmail)){
            return this;
        }
        handleUpdate(CONTACT_EMAIL_PROPERTY, getContactEmail(), contactEmail);
        this.contactEmail = contactEmail;
        return this;
    }
    public Merchant updateAppKey(String appKey){
        appKey = (appKey == null ? null : appKey.trim());
        if(Objects.equals(this.appKey, appKey)){
            return this;
        }
        handleUpdate(APP_KEY_PROPERTY, getAppKey(), appKey);
        this.appKey = appKey;
        return this;
    }
    protected Merchant updateStatus(MerchantStatusType status){
        if(Objects.equals(this.status, status)){
            return this;
        }
        handleUpdate(STATUS_PROPERTY, getStatus(), status);
        this.status = status;
        return this;
    }
    public Merchant updatePlatform(Platform platform){
        if(Objects.equals(this.platform, platform)){
            return this;
        }
        handleUpdate(PLATFORM_PROPERTY, getPlatform(), platform);
        this.platform = platform;
        return this;
    }
    public Merchant updateCreateTime(LocalDateTime createTime){
        if(Objects.equals(this.createTime, createTime)){
            return this;
        }
        handleUpdate(CREATE_TIME_PROPERTY, getCreateTime(), createTime);
        this.createTime = createTime;
        return this;
    }
    public Merchant updateUpdateTime(LocalDateTime updateTime){
        if(Objects.equals(this.updateTime, updateTime)){
            return this;
        }
        handleUpdate(UPDATE_TIME_PROPERTY, getUpdateTime(), updateTime);
        this.updateTime = updateTime;
        return this;
    }
    public Merchant addMerchantKyc(MerchantKyc merchantKyc){
        if (merchantKyc == null){
            return this;
        }

        if(null == this.merchantKycList){
            this.merchantKycList = new SmartList<>();
        }

        this.merchantKycList.add(merchantKyc);
        merchantKyc.cacheRelation(MerchantKyc.MERCHANT_PROPERTY, this);
        return this;
    }
    public Merchant addOutboxEvent(OutboxEvent outboxEvent){
        if (outboxEvent == null){
            return this;
        }

        if(null == this.outboxEventList){
            this.outboxEventList = new SmartList<>();
        }

        this.outboxEventList.add(outboxEvent);
        outboxEvent.cacheRelation(OutboxEvent.MERCHANT_PROPERTY, this);
        return this;
    }
    public boolean isStatusActive(){
        return Objects.equals(getStatus(), Constants.MERCHANT_STATUS_TYPE_ACTIVE);
    }

    public Merchant updateStatusToActive(){
        return updateStatus(Constants.MERCHANT_STATUS_TYPE_ACTIVE);
    }
    public boolean isStatusPendingVerification(){
        return Objects.equals(getStatus(), Constants.MERCHANT_STATUS_TYPE_PENDING_VERIFICATION);
    }

    public Merchant updateStatusToPendingVerification(){
        return updateStatus(Constants.MERCHANT_STATUS_TYPE_PENDING_VERIFICATION);
    }
    public boolean isStatusSuspended(){
        return Objects.equals(getStatus(), Constants.MERCHANT_STATUS_TYPE_SUSPENDED);
    }

    public Merchant updateStatusToSuspended(){
        return updateStatus(Constants.MERCHANT_STATUS_TYPE_SUSPENDED);
    }

    public static Merchant refer(Long id){
        Merchant refer = new Merchant();
        refer.__internalSet("id", id);
        refer.set$status(EntityStatus.REFER);
        return refer;
    }
    @Override
    public String typeName(){
        return INTERNAL_TYPE;
    }

    public Merchant comment(String comment){
        this.setComment(comment);
        return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public Audited<Merchant> auditAs(String action) {
        return super.auditAs(action);
    }

    // ===== Framework Internal: generated switch dispatch =====
    @Override
    @FrameworkInternal
    public void __internalSet(String property, Object value) {
        switch (property) {
            case "companyName": this.companyName = (value == null ? null : ((String)value).trim()); break;

            case "contactEmail": this.contactEmail = (value == null ? null : ((String)value).trim()); break;

            case "appKey": this.appKey = (value == null ? null : ((String)value).trim()); break;

            case "status": this.status = (MerchantStatusType) value; break;

            case "platform": this.platform = (Platform) value; break;

            case "createTime": this.createTime = (LocalDateTime) value; break;

            case "updateTime": this.updateTime = (LocalDateTime) value; break;

            case "merchantKycList": this.merchantKycList = (SmartList<MerchantKyc>) value; break;
            case "outboxEventList": this.outboxEventList = (SmartList<OutboxEvent>) value; break;
            default: super.__internalSet(property, value);
        }
    }

    @Override
    @FrameworkInternal
    public Object __internalGet(String property) {
        switch (property) {
            case "companyName": return this.companyName;
            case "contactEmail": return this.contactEmail;
            case "appKey": return this.appKey;
            case "status": return this.status;
            case "platform": return this.platform;
            case "createTime": return this.createTime;
            case "updateTime": return this.updateTime;
            case "merchantKycList": return this.merchantKycList;
            case "outboxEventList": return this.outboxEventList;
            default: return super.__internalGet(property);
        }
    }

}