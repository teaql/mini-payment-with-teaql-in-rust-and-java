package com.doublechaintech.merchantservice.merchantstatustype;

import com.doublechaintech.merchantservice.merchant.Merchant;
import com.doublechaintech.merchantservice.merchant.MerchantChecker;
import com.doublechaintech.merchantservice.platform.Platform;
import com.doublechaintech.merchantservice.platform.PlatformChecker;
import io.teaql.core.UserContext;
import io.teaql.core.checker.Checker;
import io.teaql.core.checker.ObjectLocation;

public class MerchantStatusTypeChecker implements Checker<MerchantStatusType>{

    public String type(){
        return MerchantStatusType.INTERNAL_TYPE;
    }

    public void checkAndFix(UserContext _ctx, MerchantStatusType merchantStatusType, ObjectLocation _parentLocation){
        if(needCheck(_ctx, merchantStatusType)){
            markAsChecked(_ctx, merchantStatusType);
            doCheck(_ctx, merchantStatusType, _parentLocation);
        }
    }

    public void doCheck(UserContext _ctx, MerchantStatusType merchantStatusType, ObjectLocation _parentLocation){
      if((merchantStatusType == null)){
         return;
      }
      if(merchantStatusType.newItem()){
      }else if(merchantStatusType.updateItem()){
      }
      checkName(_ctx, merchantStatusType.getProperty(MerchantStatusType.NAME_PROPERTY), newLocation(_parentLocation, MerchantStatusType.NAME_PROPERTY));
      checkCode(_ctx, merchantStatusType.getProperty(MerchantStatusType.CODE_PROPERTY), newLocation(_parentLocation, MerchantStatusType.CODE_PROPERTY));
      checkPlatform(_ctx, merchantStatusType.getProperty(MerchantStatusType.PLATFORM_PROPERTY), newLocation(_parentLocation, MerchantStatusType.PLATFORM_PROPERTY));
      for(int i = 0; merchantStatusType.getMerchantList() != null && i < merchantStatusType.getMerchantList().size(); i++){
         Merchant merchant = merchantStatusType.getMerchantList().get(i);
         new MerchantChecker().checkAndFix(_ctx, merchant, newLocation(_parentLocation, MerchantStatusType.MERCHANT_LIST_PROPERTY, i));
      }
    }

    public void checkName(UserContext _ctx, String name, ObjectLocation _parentLocation){
    requiredCheck(_ctx, _parentLocation, name);
    if((name == null)){
        return;
    }
    maxStringCheck(_ctx, _parentLocation, 100, name);

    }
    public void checkCode(UserContext _ctx, String code, ObjectLocation _parentLocation){
    requiredCheck(_ctx, _parentLocation, code);
    if((code == null)){
        return;
    }
    maxStringCheck(_ctx, _parentLocation, 100, code);

    }
    public void checkPlatform(UserContext _ctx, Platform platform, ObjectLocation _parentLocation){
    requiredCheck(_ctx, _parentLocation, platform);
    if((platform == null)){
        return;
    }
    new PlatformChecker().checkAndFix(_ctx, platform, _parentLocation);
    }
}