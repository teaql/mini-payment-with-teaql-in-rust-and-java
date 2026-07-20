package com.doublechaintech.merchantservice.eventstatustype;

import com.doublechaintech.merchantservice.outboxevent.OutboxEvent;
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
public class EventStatusType extends BaseEntity implements RemoteInput {
    public static String INTERNAL_TYPE = "EventStatusType";

    public static final String NAME_PROPERTY = "name";
    public static final String CODE_PROPERTY = "code";
    public static final String PLATFORM_PROPERTY = "platform";
    public static final String OUTBOX_EVENT_LIST_PROPERTY = "outboxEventList";
    private String name;
    private String code;
    private Platform platform;
    private SmartList<OutboxEvent> outboxEventList;

    public String getName(){
        return this.name;
    }
    public String getCode(){
        return this.code;
    }
    public Platform getPlatform(){
        return this.platform;
    }
    public SmartList<OutboxEvent> getOutboxEventList(){
        return this.outboxEventList;
    }
    public EventStatusType updateName(String name){
        name = (name == null ? null : name.trim());
        if(Objects.equals(this.name, name)){
            return this;
        }
        handleUpdate(NAME_PROPERTY, getName(), name);
        this.name = name;
        return this;
    }
    public EventStatusType updateCode(String code){
        code = (code == null ? null : code.trim());
        if(Objects.equals(this.code, code)){
            return this;
        }
        handleUpdate(CODE_PROPERTY, getCode(), code);
        this.code = code;
        return this;
    }
    public EventStatusType updatePlatform(Platform platform){
        if(Objects.equals(this.platform, platform)){
            return this;
        }
        handleUpdate(PLATFORM_PROPERTY, getPlatform(), platform);
        this.platform = platform;
        return this;
    }
    public EventStatusType addOutboxEvent(OutboxEvent outboxEvent){
        if (outboxEvent == null){
            return this;
        }

        if(null == this.outboxEventList){
            this.outboxEventList = new SmartList<>();
        }

        this.outboxEventList.add(outboxEvent);
        outboxEvent.cacheRelation(OutboxEvent.STATUS_PROPERTY, this);
        return this;
    }

    public static EventStatusType refer(Long id){
        EventStatusType refer = new EventStatusType();
        refer.__internalSet("id", id);
        refer.set$status(EntityStatus.REFER);
        return refer;
    }
    @Override
    public String typeName(){
        return INTERNAL_TYPE;
    }

    public EventStatusType comment(String comment){
        this.setComment(comment);
        return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public Audited<EventStatusType> auditAs(String action) {
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

            case "outboxEventList": this.outboxEventList = (SmartList<OutboxEvent>) value; break;
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
            case "outboxEventList": return this.outboxEventList;
            default: return super.__internalGet(property);
        }
    }

}