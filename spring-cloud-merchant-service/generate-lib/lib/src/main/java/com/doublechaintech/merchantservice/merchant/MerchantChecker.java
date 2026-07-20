package com.doublechaintech.merchantservice.merchant;

import com.doublechaintech.merchantservice.merchantkyc.MerchantKyc;
import com.doublechaintech.merchantservice.merchantkyc.MerchantKycChecker;
import com.doublechaintech.merchantservice.merchantstatustype.MerchantStatusType;
import com.doublechaintech.merchantservice.merchantstatustype.MerchantStatusTypeChecker;
import com.doublechaintech.merchantservice.outboxevent.OutboxEvent;
import com.doublechaintech.merchantservice.outboxevent.OutboxEventChecker;
import com.doublechaintech.merchantservice.platform.Platform;
import com.doublechaintech.merchantservice.platform.PlatformChecker;
import io.teaql.core.UserContext;
import io.teaql.core.checker.Checker;
import io.teaql.core.checker.ObjectLocation;
import java.time.LocalDateTime;

public class MerchantChecker implements Checker<Merchant>{

    public String type(){
        return Merchant.INTERNAL_TYPE;
    }

    public void checkAndFix(UserContext _ctx, Merchant merchant, ObjectLocation _parentLocation){
        if(needCheck(_ctx, merchant)){
            markAsChecked(_ctx, merchant);
            doCheck(_ctx, merchant, _parentLocation);
        }
    }

    public void doCheck(UserContext _ctx, Merchant merchant, ObjectLocation _parentLocation){
      if((merchant == null)){
         return;
      }
      if(merchant.newItem()){
        if(merchant.getCreateTime() == null){
           merchant.updateCreateTime(java.time.LocalDateTime.now());
        }if(merchant.getUpdateTime() == null){
           merchant.updateUpdateTime(java.time.LocalDateTime.now());
        }
      }else if(merchant.updateItem()){
        merchant.updateUpdateTime(java.time.LocalDateTime.now());
      }
      checkCompanyName(_ctx, merchant.getProperty(Merchant.COMPANY_NAME_PROPERTY), newLocation(_parentLocation, Merchant.COMPANY_NAME_PROPERTY));
      checkContactEmail(_ctx, merchant.getProperty(Merchant.CONTACT_EMAIL_PROPERTY), newLocation(_parentLocation, Merchant.CONTACT_EMAIL_PROPERTY));
      checkAppKey(_ctx, merchant.getProperty(Merchant.APP_KEY_PROPERTY), newLocation(_parentLocation, Merchant.APP_KEY_PROPERTY));
      checkStatus(_ctx, merchant.getProperty(Merchant.STATUS_PROPERTY), newLocation(_parentLocation, Merchant.STATUS_PROPERTY));
      checkPlatform(_ctx, merchant.getProperty(Merchant.PLATFORM_PROPERTY), newLocation(_parentLocation, Merchant.PLATFORM_PROPERTY));
      checkCreateTime(_ctx, merchant.getProperty(Merchant.CREATE_TIME_PROPERTY), newLocation(_parentLocation, Merchant.CREATE_TIME_PROPERTY));
      checkUpdateTime(_ctx, merchant.getProperty(Merchant.UPDATE_TIME_PROPERTY), newLocation(_parentLocation, Merchant.UPDATE_TIME_PROPERTY));
      for(int i = 0; merchant.getMerchantKycList() != null && i < merchant.getMerchantKycList().size(); i++){
         MerchantKyc merchantKyc = merchant.getMerchantKycList().get(i);
         new MerchantKycChecker().checkAndFix(_ctx, merchantKyc, newLocation(_parentLocation, Merchant.MERCHANT_KYC_LIST_PROPERTY, i));
      }
      for(int i = 0; merchant.getOutboxEventList() != null && i < merchant.getOutboxEventList().size(); i++){
         OutboxEvent outboxEvent = merchant.getOutboxEventList().get(i);
         new OutboxEventChecker().checkAndFix(_ctx, outboxEvent, newLocation(_parentLocation, Merchant.OUTBOX_EVENT_LIST_PROPERTY, i));
      }
    }

    public void checkCompanyName(UserContext _ctx, String companyName, ObjectLocation _parentLocation){
    requiredCheck(_ctx, _parentLocation, companyName);
    if((companyName == null)){
        return;
    }
    maxStringCheck(_ctx, _parentLocation, 100, companyName);

    }
    public void checkContactEmail(UserContext _ctx, String contactEmail, ObjectLocation _parentLocation){
    requiredCheck(_ctx, _parentLocation, contactEmail);
    if((contactEmail == null)){
        return;
    }
    maxStringCheck(_ctx, _parentLocation, 100, contactEmail);

    }
    public void checkAppKey(UserContext _ctx, String appKey, ObjectLocation _parentLocation){
    requiredCheck(_ctx, _parentLocation, appKey);
    if((appKey == null)){
        return;
    }
    maxStringCheck(_ctx, _parentLocation, 100, appKey);

    }
    public void checkStatus(UserContext _ctx, MerchantStatusType status, ObjectLocation _parentLocation){
    requiredCheck(_ctx, _parentLocation, status);
    if((status == null)){
        return;
    }
    new MerchantStatusTypeChecker().checkAndFix(_ctx, status, _parentLocation);
    }
    public void checkPlatform(UserContext _ctx, Platform platform, ObjectLocation _parentLocation){
    requiredCheck(_ctx, _parentLocation, platform);
    if((platform == null)){
        return;
    }
    new PlatformChecker().checkAndFix(_ctx, platform, _parentLocation);
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