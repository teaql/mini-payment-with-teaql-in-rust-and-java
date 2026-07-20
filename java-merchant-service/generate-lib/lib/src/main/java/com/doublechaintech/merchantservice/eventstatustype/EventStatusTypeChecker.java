package com.doublechaintech.merchantservice.eventstatustype;

import com.doublechaintech.merchantservice.outboxevent.OutboxEvent;
import com.doublechaintech.merchantservice.outboxevent.OutboxEventChecker;
import com.doublechaintech.merchantservice.platform.Platform;
import com.doublechaintech.merchantservice.platform.PlatformChecker;
import io.teaql.core.UserContext;
import io.teaql.core.checker.Checker;
import io.teaql.core.checker.ObjectLocation;

public class EventStatusTypeChecker implements Checker<EventStatusType>{

    public String type(){
        return EventStatusType.INTERNAL_TYPE;
    }

    public void checkAndFix(UserContext _ctx, EventStatusType eventStatusType, ObjectLocation _parentLocation){
        if(needCheck(_ctx, eventStatusType)){
            markAsChecked(_ctx, eventStatusType);
            doCheck(_ctx, eventStatusType, _parentLocation);
        }
    }

    public void doCheck(UserContext _ctx, EventStatusType eventStatusType, ObjectLocation _parentLocation){
      if((eventStatusType == null)){
         return;
      }
      if(eventStatusType.newItem()){
      }else if(eventStatusType.updateItem()){
      }
      checkName(_ctx, eventStatusType.getProperty(EventStatusType.NAME_PROPERTY), newLocation(_parentLocation, EventStatusType.NAME_PROPERTY));
      checkCode(_ctx, eventStatusType.getProperty(EventStatusType.CODE_PROPERTY), newLocation(_parentLocation, EventStatusType.CODE_PROPERTY));
      checkPlatform(_ctx, eventStatusType.getProperty(EventStatusType.PLATFORM_PROPERTY), newLocation(_parentLocation, EventStatusType.PLATFORM_PROPERTY));
      for(int i = 0; eventStatusType.getOutboxEventList() != null && i < eventStatusType.getOutboxEventList().size(); i++){
         OutboxEvent outboxEvent = eventStatusType.getOutboxEventList().get(i);
         new OutboxEventChecker().checkAndFix(_ctx, outboxEvent, newLocation(_parentLocation, EventStatusType.OUTBOX_EVENT_LIST_PROPERTY, i));
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