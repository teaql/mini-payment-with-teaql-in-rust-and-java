package com.doublechaintech.merchantservice.outboxevent;

import com.doublechaintech.merchantservice.eventstatustype.EventStatusType;
import com.doublechaintech.merchantservice.eventstatustype.EventStatusTypeChecker;
import com.doublechaintech.merchantservice.merchant.Merchant;
import com.doublechaintech.merchantservice.merchant.MerchantChecker;
import io.teaql.core.UserContext;
import io.teaql.core.checker.Checker;
import io.teaql.core.checker.ObjectLocation;
import java.time.LocalDateTime;

public class OutboxEventChecker implements Checker<OutboxEvent>{

    public String type(){
        return OutboxEvent.INTERNAL_TYPE;
    }

    public void checkAndFix(UserContext _ctx, OutboxEvent outboxEvent, ObjectLocation _parentLocation){
        if(needCheck(_ctx, outboxEvent)){
            markAsChecked(_ctx, outboxEvent);
            doCheck(_ctx, outboxEvent, _parentLocation);
        }
    }

    public void doCheck(UserContext _ctx, OutboxEvent outboxEvent, ObjectLocation _parentLocation){
      if((outboxEvent == null)){
         return;
      }
      if(outboxEvent.newItem()){
        if(outboxEvent.getCreateTime() == null){
           outboxEvent.updateCreateTime(java.time.LocalDateTime.now());
        }if(outboxEvent.getUpdateTime() == null){
           outboxEvent.updateUpdateTime(java.time.LocalDateTime.now());
        }if(outboxEvent.getProcessedAt() == null){
           outboxEvent.updateProcessedAt(java.time.LocalDateTime.now());
        }
      }else if(outboxEvent.updateItem()){
        outboxEvent.updateUpdateTime(java.time.LocalDateTime.now());outboxEvent.updateProcessedAt(java.time.LocalDateTime.now());
      }
      checkEventType(_ctx, outboxEvent.getProperty(OutboxEvent.EVENT_TYPE_PROPERTY), newLocation(_parentLocation, OutboxEvent.EVENT_TYPE_PROPERTY));
      checkPayload(_ctx, outboxEvent.getProperty(OutboxEvent.PAYLOAD_PROPERTY), newLocation(_parentLocation, OutboxEvent.PAYLOAD_PROPERTY));
      checkStatus(_ctx, outboxEvent.getProperty(OutboxEvent.STATUS_PROPERTY), newLocation(_parentLocation, OutboxEvent.STATUS_PROPERTY));
      checkMerchant(_ctx, outboxEvent.getProperty(OutboxEvent.MERCHANT_PROPERTY), newLocation(_parentLocation, OutboxEvent.MERCHANT_PROPERTY));
      checkCreateTime(_ctx, outboxEvent.getProperty(OutboxEvent.CREATE_TIME_PROPERTY), newLocation(_parentLocation, OutboxEvent.CREATE_TIME_PROPERTY));
      checkUpdateTime(_ctx, outboxEvent.getProperty(OutboxEvent.UPDATE_TIME_PROPERTY), newLocation(_parentLocation, OutboxEvent.UPDATE_TIME_PROPERTY));
      checkProcessedAt(_ctx, outboxEvent.getProperty(OutboxEvent.PROCESSED_AT_PROPERTY), newLocation(_parentLocation, OutboxEvent.PROCESSED_AT_PROPERTY));
    }

    public void checkEventType(UserContext _ctx, String eventType, ObjectLocation _parentLocation){
    requiredCheck(_ctx, _parentLocation, eventType);
    if((eventType == null)){
        return;
    }
    maxStringCheck(_ctx, _parentLocation, 100, eventType);

    }
    public void checkPayload(UserContext _ctx, String payload, ObjectLocation _parentLocation){
    requiredCheck(_ctx, _parentLocation, payload);
    if((payload == null)){
        return;
    }
    maxStringCheck(_ctx, _parentLocation, 100, payload);

    }
    public void checkStatus(UserContext _ctx, EventStatusType status, ObjectLocation _parentLocation){
    requiredCheck(_ctx, _parentLocation, status);
    if((status == null)){
        return;
    }
    new EventStatusTypeChecker().checkAndFix(_ctx, status, _parentLocation);
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
    public void checkProcessedAt(UserContext _ctx, LocalDateTime processedAt, ObjectLocation _parentLocation){
    if((processedAt == null)){
        return;
    }
    }
}