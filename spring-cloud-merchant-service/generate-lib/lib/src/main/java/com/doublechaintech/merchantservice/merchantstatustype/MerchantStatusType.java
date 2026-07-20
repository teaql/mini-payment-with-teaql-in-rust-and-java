package com.doublechaintech.merchantservice.merchantstatustype;

import com.doublechaintech.merchantservice.merchant.Merchant;
import com.doublechaintech.merchantservice.platform.Platform;
import io.teaql.core.Audited;
import io.teaql.core.BaseEntity;
import io.teaql.core.EntityStatus;
import io.teaql.core.FrameworkInternal;
import io.teaql.core.RemoteInput;
import io.teaql.core.SmartList;
import java.util.Objects;

/**
 * [TEAQL AI WARNING]
 * TeaQL was explicitly designed to PREVENT AI hallucinations and random guessing.
 * DO NOT GUESS METHOD NAMES!
 * The methods listed below are the ONLY valid ways to interact with this entity.
 * If you encounter compilation errors (e.g., method not found), DO NOT guess another method name.
 * Read the method signatures in this file before proceeding.
 */
public class MerchantStatusType extends BaseEntity implements RemoteInput {
    public static String INTERNAL_TYPE = "MerchantStatusType";

    public static final String NAME_PROPERTY = "name";
    public static final String CODE_PROPERTY = "code";
    public static final String PLATFORM_PROPERTY = "platform";
    public static final String MERCHANT_LIST_PROPERTY = "merchantList";
    private String name;
    private String code;
    private Platform platform;
    private SmartList<Merchant> merchantList;

    public String getName(){
        return this.name;
    }
    public String getCode(){
        return this.code;
    }
    public Platform getPlatform(){
        return this.platform;
    }
    public SmartList<Merchant> getMerchantList(){
        return this.merchantList;
    }
    public MerchantStatusType updateName(String name){
        name = (name == null ? null : name.trim());
        if(Objects.equals(this.name, name)){
            return this;
        }
        handleUpdate(NAME_PROPERTY, getName(), name);
        this.name = name;
        return this;
    }
    public MerchantStatusType updateCode(String code){
        code = (code == null ? null : code.trim());
        if(Objects.equals(this.code, code)){
            return this;
        }
        handleUpdate(CODE_PROPERTY, getCode(), code);
        this.code = code;
        return this;
    }
    public MerchantStatusType updatePlatform(Platform platform){
        if(Objects.equals(this.platform, platform)){
            return this;
        }
        handleUpdate(PLATFORM_PROPERTY, getPlatform(), platform);
        this.platform = platform;
        return this;
    }
    public MerchantStatusType addMerchant(Merchant merchant){
        if (merchant == null){
            return this;
        }

        if(null == this.merchantList){
            this.merchantList = new SmartList<>();
        }

        this.merchantList.add(merchant);
        merchant.cacheRelation(Merchant.STATUS_PROPERTY, this);
        return this;
    }

    public static MerchantStatusType refer(Long id){
        MerchantStatusType refer = new MerchantStatusType();
        refer.__internalSet("id", id);
        refer.set$status(EntityStatus.REFER);
        return refer;
    }
    @Override
    public String typeName(){
        return INTERNAL_TYPE;
    }

    public MerchantStatusType comment(String comment){
        this.setComment(comment);
        return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public Audited<MerchantStatusType> auditAs(String action) {
        return super.auditAs(action);
    }

    // ===== Framework Internal: generated switch dispatch =====
    @Override
    @FrameworkInternal
    public void __internalSet(String property, Object value) {
        switch (property) {
            case "name": this.name = (value == null ? null : ((String)value).trim()); break;

            case "code": this.code = (value == null ? null : ((String)value).trim()); break;

            case "platform": this.platform = (Platform) value; break;

            case "merchantList": this.merchantList = (SmartList<Merchant>) value; break;
            default: super.__internalSet(property, value);
        }
    }

    @Override
    @FrameworkInternal
    public Object __internalGet(String property) {
        switch (property) {
            case "name": return this.name;
            case "code": return this.code;
            case "platform": return this.platform;
            case "merchantList": return this.merchantList;
            default: return super.__internalGet(property);
        }
    }

}