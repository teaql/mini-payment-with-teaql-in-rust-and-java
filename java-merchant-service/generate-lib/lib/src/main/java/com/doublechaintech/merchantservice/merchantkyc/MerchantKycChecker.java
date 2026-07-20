package com.doublechaintech.merchantservice.merchantkyc;

import com.doublechaintech.merchantservice.merchant.Merchant;
import com.doublechaintech.merchantservice.merchant.MerchantChecker;
import io.teaql.core.UserContext;
import io.teaql.core.checker.Checker;
import io.teaql.core.checker.ObjectLocation;
import java.time.LocalDateTime;

public class MerchantKycChecker implements Checker<MerchantKyc>{

    public String type(){
        return MerchantKyc.INTERNAL_TYPE;
    }

    public void checkAndFix(UserContext _ctx, MerchantKyc merchantKyc, ObjectLocation _parentLocation){
        if(needCheck(_ctx, merchantKyc)){
            markAsChecked(_ctx, merchantKyc);
            doCheck(_ctx, merchantKyc, _parentLocation);
        }
    }

    public void doCheck(UserContext _ctx, MerchantKyc merchantKyc, ObjectLocation _parentLocation){
      if((merchantKyc == null)){
         return;
      }
      if(merchantKyc.newItem()){
        if(merchantKyc.getCreateTime() == null){
           merchantKyc.updateCreateTime(java.time.LocalDateTime.now());
        }if(merchantKyc.getUpdateTime() == null){
           merchantKyc.updateUpdateTime(java.time.LocalDateTime.now());
        }
      }else if(merchantKyc.updateItem()){
        merchantKyc.updateUpdateTime(java.time.LocalDateTime.now());
      }
      checkBusinessLicenseNo(_ctx, merchantKyc.getProperty(MerchantKyc.BUSINESS_LICENSE_NO_PROPERTY), newLocation(_parentLocation, MerchantKyc.BUSINESS_LICENSE_NO_PROPERTY));
      checkLegalPerson(_ctx, merchantKyc.getProperty(MerchantKyc.LEGAL_PERSON_PROPERTY), newLocation(_parentLocation, MerchantKyc.LEGAL_PERSON_PROPERTY));
      checkBankAccountNo(_ctx, merchantKyc.getProperty(MerchantKyc.BANK_ACCOUNT_NO_PROPERTY), newLocation(_parentLocation, MerchantKyc.BANK_ACCOUNT_NO_PROPERTY));
      checkMerchant(_ctx, merchantKyc.getProperty(MerchantKyc.MERCHANT_PROPERTY), newLocation(_parentLocation, MerchantKyc.MERCHANT_PROPERTY));
      checkCreateTime(_ctx, merchantKyc.getProperty(MerchantKyc.CREATE_TIME_PROPERTY), newLocation(_parentLocation, MerchantKyc.CREATE_TIME_PROPERTY));
      checkUpdateTime(_ctx, merchantKyc.getProperty(MerchantKyc.UPDATE_TIME_PROPERTY), newLocation(_parentLocation, MerchantKyc.UPDATE_TIME_PROPERTY));
    }

    public void checkBusinessLicenseNo(UserContext _ctx, String businessLicenseNo, ObjectLocation _parentLocation){
    requiredCheck(_ctx, _parentLocation, businessLicenseNo);
    if((businessLicenseNo == null)){
        return;
    }
    maxStringCheck(_ctx, _parentLocation, 100, businessLicenseNo);

    }
    public void checkLegalPerson(UserContext _ctx, String legalPerson, ObjectLocation _parentLocation){
    requiredCheck(_ctx, _parentLocation, legalPerson);
    if((legalPerson == null)){
        return;
    }
    maxStringCheck(_ctx, _parentLocation, 100, legalPerson);

    }
    public void checkBankAccountNo(UserContext _ctx, String bankAccountNo, ObjectLocation _parentLocation){
    requiredCheck(_ctx, _parentLocation, bankAccountNo);
    if((bankAccountNo == null)){
        return;
    }
    maxStringCheck(_ctx, _parentLocation, 100, bankAccountNo);

    }
    public void checkMerchant(UserContext _ctx, Merchant merchant, ObjectLocation _parentLocation){
    requiredCheck(_ctx, _parentLocation, merchant);
    if((merchant == null)){
        return;
    }
    new MerchantChecker().checkAndFix(_ctx, merchant, _parentLocation);
    }
    public void checkCreateTime(UserContext _ctx, LocalDateTime createTime, ObjectLocation _parentLocation){
    requiredCheck(_ctx, _parentLocation, createTime);
    if((createTime == null)){
        return;
    }
    }
    public void checkUpdateTime(UserContext _ctx, LocalDateTime updateTime, ObjectLocation _parentLocation){
    requiredCheck(_ctx, _parentLocation, updateTime);
    if((updateTime == null)){
        return;
    }
    }
}