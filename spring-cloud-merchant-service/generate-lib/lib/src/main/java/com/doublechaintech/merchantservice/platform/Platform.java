package com.doublechaintech.merchantservice.platform;

import com.doublechaintech.merchantservice.eventstatustype.EventStatusType;
import com.doublechaintech.merchantservice.merchant.Merchant;
import com.doublechaintech.merchantservice.merchantstatustype.MerchantStatusType;
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
public class Platform extends BaseEntity implements RemoteInput {
    public static String INTERNAL_TYPE = "Platform";

    public static final String NAME_PROPERTY = "name";
    public static final String CREATE_TIME_PROPERTY = "createTime";
    public static final String UPDATE_TIME_PROPERTY = "updateTime";
    public static final String MERCHANT_LIST_PROPERTY = "merchantList";
    public static final String MERCHANT_STATUS_TYPE_LIST_PROPERTY = "merchantStatusTypeList";
    public static final String EVENT_STATUS_TYPE_LIST_PROPERTY = "eventStatusTypeList";
    private String name;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
    private SmartList<Merchant> merchantList;
    private SmartList<MerchantStatusType> merchantStatusTypeList;
    private SmartList<EventStatusType> eventStatusTypeList;

    public String getName(){
        return this.name;
    }
    public LocalDateTime getCreateTime(){
        return this.createTime;
    }
    public LocalDateTime getUpdateTime(){
        return this.updateTime;
    }
    public SmartList<Merchant> getMerchantList(){
        return this.merchantList;
    }
    public SmartList<MerchantStatusType> getMerchantStatusTypeList(){
        return this.merchantStatusTypeList;
    }
    public SmartList<EventStatusType> getEventStatusTypeList(){
        return this.eventStatusTypeList;
    }
    public Platform updateName(String name){
        name = (name == null ? null : name.trim());
        if(Objects.equals(this.name, name)){
            return this;
        }
        handleUpdate(NAME_PROPERTY, getName(), name);
        this.name = name;
        return this;
    }
    public Platform updateCreateTime(LocalDateTime createTime){
        if(Objects.equals(this.createTime, createTime)){
            return this;
        }
        handleUpdate(CREATE_TIME_PROPERTY, getCreateTime(), createTime);
        this.createTime = createTime;
        return this;
    }
    public Platform updateUpdateTime(LocalDateTime updateTime){
        if(Objects.equals(this.updateTime, updateTime)){
            return this;
        }
        handleUpdate(UPDATE_TIME_PROPERTY, getUpdateTime(), updateTime);
        this.updateTime = updateTime;
        return this;
    }
    public Platform addMerchant(Merchant merchant){
        if (merchant == null){
            return this;
        }

        if(null == this.merchantList){
            this.merchantList = new SmartList<>();
        }

        this.merchantList.add(merchant);
        merchant.cacheRelation(Merchant.PLATFORM_PROPERTY, this);
        return this;
    }
    public Platform addMerchantStatusType(MerchantStatusType merchantStatusType){
        if (merchantStatusType == null){
            return this;
        }

        if(null == this.merchantStatusTypeList){
            this.merchantStatusTypeList = new SmartList<>();
        }

        this.merchantStatusTypeList.add(merchantStatusType);
        merchantStatusType.cacheRelation(MerchantStatusType.PLATFORM_PROPERTY, this);
        return this;
    }
    public Platform addEventStatusType(EventStatusType eventStatusType){
        if (eventStatusType == null){
            return this;
        }

        if(null == this.eventStatusTypeList){
            this.eventStatusTypeList = new SmartList<>();
        }

        this.eventStatusTypeList.add(eventStatusType);
        eventStatusType.cacheRelation(EventStatusType.PLATFORM_PROPERTY, this);
        return this;
    }

    public static Platform refer(Long id){
        Platform refer = new Platform();
        refer.__internalSet("id", id);
        refer.set$status(EntityStatus.REFER);
        return refer;
    }
    @Override
    public String typeName(){
        return INTERNAL_TYPE;
    }

    public Platform comment(String comment){
        this.setComment(comment);
        return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public Audited<Platform> auditAs(String action) {
        return super.auditAs(action);
    }

    // ===== Framework Internal: generated switch dispatch =====
    @Override
    @FrameworkInternal
    public void __internalSet(String property, Object value) {
        switch (property) {
            case "name": this.name = (value == null ? null : ((String)value).trim()); break;

            case "createTime": this.createTime = (LocalDateTime) value; break;

            case "updateTime": this.updateTime = (LocalDateTime) value; break;

            case "merchantList": this.merchantList = (SmartList<Merchant>) value; break;
            case "merchantStatusTypeList": this.merchantStatusTypeList = (SmartList<MerchantStatusType>) value; break;
            case "eventStatusTypeList": this.eventStatusTypeList = (SmartList<EventStatusType>) value; break;
            default: super.__internalSet(property, value);
        }
    }

    @Override
    @FrameworkInternal
    public Object __internalGet(String property) {
        switch (property) {
            case "name": return this.name;
            case "createTime": return this.createTime;
            case "updateTime": return this.updateTime;
            case "merchantList": return this.merchantList;
            case "merchantStatusTypeList": return this.merchantStatusTypeList;
            case "eventStatusTypeList": return this.eventStatusTypeList;
            default: return super.__internalGet(property);
        }
    }

}