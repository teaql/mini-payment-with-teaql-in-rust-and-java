package com.doublechaintech.merchantservice.merchantkyc;

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
public class MerchantKyc extends BaseEntity implements RemoteInput {
    public static String INTERNAL_TYPE = "MerchantKyc";

    public static final String BUSINESS_LICENSE_NO_PROPERTY = "businessLicenseNo";
    public static final String LEGAL_PERSON_PROPERTY = "legalPerson";
    public static final String BANK_ACCOUNT_NO_PROPERTY = "bankAccountNo";
    public static final String MERCHANT_PROPERTY = "merchant";
    public static final String CREATE_TIME_PROPERTY = "createTime";
    public static final String UPDATE_TIME_PROPERTY = "updateTime";
    private String businessLicenseNo;
    private String legalPerson;
    private String bankAccountNo;
    private Merchant merchant;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;

    public String getBusinessLicenseNo(){
        return this.businessLicenseNo;
    }
    public String getLegalPerson(){
        return this.legalPerson;
    }
    public String getBankAccountNo(){
        return this.bankAccountNo;
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
    public MerchantKyc updateBusinessLicenseNo(String businessLicenseNo){
        businessLicenseNo = (businessLicenseNo == null ? null : businessLicenseNo.trim());
        if(Objects.equals(this.businessLicenseNo, businessLicenseNo)){
            return this;
        }
        handleUpdate(BUSINESS_LICENSE_NO_PROPERTY, getBusinessLicenseNo(), businessLicenseNo);
        this.businessLicenseNo = businessLicenseNo;
        return this;
    }
    public MerchantKyc updateLegalPerson(String legalPerson){
        legalPerson = (legalPerson == null ? null : legalPerson.trim());
        if(Objects.equals(this.legalPerson, legalPerson)){
            return this;
        }
        handleUpdate(LEGAL_PERSON_PROPERTY, getLegalPerson(), legalPerson);
        this.legalPerson = legalPerson;
        return this;
    }
    public MerchantKyc updateBankAccountNo(String bankAccountNo){
        bankAccountNo = (bankAccountNo == null ? null : bankAccountNo.trim());
        if(Objects.equals(this.bankAccountNo, bankAccountNo)){
            return this;
        }
        handleUpdate(BANK_ACCOUNT_NO_PROPERTY, getBankAccountNo(), bankAccountNo);
        this.bankAccountNo = bankAccountNo;
        return this;
    }
    public MerchantKyc updateMerchant(Merchant merchant){
        if(Objects.equals(this.merchant, merchant)){
            return this;
        }
        handleUpdate(MERCHANT_PROPERTY, getMerchant(), merchant);
        this.merchant = merchant;
        return this;
    }
    public MerchantKyc updateCreateTime(LocalDateTime createTime){
        if(Objects.equals(this.createTime, createTime)){
            return this;
        }
        handleUpdate(CREATE_TIME_PROPERTY, getCreateTime(), createTime);
        this.createTime = createTime;
        return this;
    }
    public MerchantKyc updateUpdateTime(LocalDateTime updateTime){
        if(Objects.equals(this.updateTime, updateTime)){
            return this;
        }
        handleUpdate(UPDATE_TIME_PROPERTY, getUpdateTime(), updateTime);
        this.updateTime = updateTime;
        return this;
    }

    public static MerchantKyc refer(Long id){
        MerchantKyc refer = new MerchantKyc();
        refer.__internalSet("id", id);
        refer.set$status(EntityStatus.REFER);
        return refer;
    }
    @Override
    public String typeName(){
        return INTERNAL_TYPE;
    }

    public MerchantKyc comment(String comment){
        this.setComment(comment);
        return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public Audited<MerchantKyc> auditAs(String action) {
        return super.auditAs(action);
    }

    // ===== Framework Internal: generated switch dispatch =====
    @Override
    @FrameworkInternal
    public void __internalSet(String property, Object value) {
        switch (property) {
            case "businessLicenseNo": this.businessLicenseNo = (value == null ? null : ((String)value).trim()); break;

            case "legalPerson": this.legalPerson = (value == null ? null : ((String)value).trim()); break;

            case "bankAccountNo": this.bankAccountNo = (value == null ? null : ((String)value).trim()); break;

            case "merchant": this.merchant = (Merchant) value; break;

            case "createTime": this.createTime = (LocalDateTime) value; break;

            case "updateTime": this.updateTime = (LocalDateTime) value; break;

            default: super.__internalSet(property, value);
        }
    }

    @Override
    @FrameworkInternal
    public Object __internalGet(String property) {
        switch (property) {
            case "businessLicenseNo": return this.businessLicenseNo;
            case "legalPerson": return this.legalPerson;
            case "bankAccountNo": return this.bankAccountNo;
            case "merchant": return this.merchant;
            case "createTime": return this.createTime;
            case "updateTime": return this.updateTime;
            default: return super.__internalGet(property);
        }
    }

}