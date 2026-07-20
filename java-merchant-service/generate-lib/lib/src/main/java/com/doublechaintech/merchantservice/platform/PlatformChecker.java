package com.doublechaintech.merchantservice.platform;

import com.doublechaintech.merchantservice.eventstatustype.EventStatusType;
import com.doublechaintech.merchantservice.eventstatustype.EventStatusTypeChecker;
import com.doublechaintech.merchantservice.merchant.Merchant;
import com.doublechaintech.merchantservice.merchant.MerchantChecker;
import com.doublechaintech.merchantservice.merchantstatustype.MerchantStatusType;
import com.doublechaintech.merchantservice.merchantstatustype.MerchantStatusTypeChecker;
import io.teaql.core.UserContext;
import io.teaql.core.checker.Checker;
import io.teaql.core.checker.ObjectLocation;
import java.time.LocalDateTime;

public class PlatformChecker implements Checker<Platform>{

    public String type(){
        return Platform.INTERNAL_TYPE;
    }

    public void checkAndFix(UserContext _ctx, Platform platform, ObjectLocation _parentLocation){
        if(needCheck(_ctx, platform)){
            markAsChecked(_ctx, platform);
            doCheck(_ctx, platform, _parentLocation);
        }
    }

    public void doCheck(UserContext _ctx, Platform platform, ObjectLocation _parentLocation){
      if((platform == null)){
         return;
      }
      if(platform.newItem()){
        if(platform.getCreateTime() == null){
           platform.updateCreateTime(java.time.LocalDateTime.now());
        }if(platform.getUpdateTime() == null){
           platform.updateUpdateTime(java.time.LocalDateTime.now());
        }
      }else if(platform.updateItem()){
        platform.updateUpdateTime(java.time.LocalDateTime.now());
      }
      checkName(_ctx, platform.getProperty(Platform.NAME_PROPERTY), newLocation(_parentLocation, Platform.NAME_PROPERTY));
      checkCreateTime(_ctx, platform.getProperty(Platform.CREATE_TIME_PROPERTY), newLocation(_parentLocation, Platform.CREATE_TIME_PROPERTY));
      checkUpdateTime(_ctx, platform.getProperty(Platform.UPDATE_TIME_PROPERTY), newLocation(_parentLocation, Platform.UPDATE_TIME_PROPERTY));
      for(int i = 0; platform.getMerchantList() != null && i < platform.getMerchantList().size(); i++){
         Merchant merchant = platform.getMerchantList().get(i);
         new MerchantChecker().checkAndFix(_ctx, merchant, newLocation(_parentLocation, Platform.MERCHANT_LIST_PROPERTY, i));
      }
      for(int i = 0; platform.getMerchantStatusTypeList() != null && i < platform.getMerchantStatusTypeList().size(); i++){
         MerchantStatusType merchantStatusType = platform.getMerchantStatusTypeList().get(i);
         new MerchantStatusTypeChecker().checkAndFix(_ctx, merchantStatusType, newLocation(_parentLocation, Platform.MERCHANT_STATUS_TYPE_LIST_PROPERTY, i));
      }
      for(int i = 0; platform.getEventStatusTypeList() != null && i < platform.getEventStatusTypeList().size(); i++){
         EventStatusType eventStatusType = platform.getEventStatusTypeList().get(i);
         new EventStatusTypeChecker().checkAndFix(_ctx, eventStatusType, newLocation(_parentLocation, Platform.EVENT_STATUS_TYPE_LIST_PROPERTY, i));
      }
    }

    public void checkName(UserContext _ctx, String name, ObjectLocation _parentLocation){
    requiredCheck(_ctx, _parentLocation, name);
    if((name == null)){
        return;
    }
    maxStringCheck(_ctx, _parentLocation, 100, name);

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