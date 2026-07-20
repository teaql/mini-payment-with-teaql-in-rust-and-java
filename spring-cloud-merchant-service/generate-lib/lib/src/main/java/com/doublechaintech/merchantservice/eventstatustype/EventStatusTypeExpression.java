package com.doublechaintech.merchantservice.eventstatustype;

import com.doublechaintech.merchantservice.outboxevent.OutboxEvent;
import com.doublechaintech.merchantservice.outboxevent.OutboxEventListExpression;
import com.doublechaintech.merchantservice.platform.Platform;
import com.doublechaintech.merchantservice.platform.PlatformExpression;
import io.teaql.core.UserContext;
import io.teaql.core.value.BaseEntityExpression;
import io.teaql.core.value.Expression;
import io.teaql.core.value.ExpressionAdaptor;
import java.util.function.Function;

public class EventStatusTypeExpression<T, E, U extends EventStatusType> extends ExpressionAdaptor<T, E, U> implements BaseEntityExpression<T, U> {
    public EventStatusTypeExpression(Expression<T, U> expression){
        super(expression);
    }

    public EventStatusTypeExpression(Expression<T, E> expression, Function<E, U> function){
        super(expression, function);
    }

     public EventStatusTypeExpression<T, U, U> updateId(Long id){
        return new EventStatusTypeExpression(this, $it -> {((EventStatusType)$it).__internalSet("id", id); return this;});
     }

     public EventStatusTypeExpression<T, U, U> save(UserContext userContext){
        return new EventStatusTypeExpression(this, $it -> ((EventStatusType)$it).auditAs("Saved by Expression").save(userContext));
     }

     public EventStatusTypeExpression<T, U, U> save(String intent, UserContext userContext){
        return new EventStatusTypeExpression(this, $it -> ((EventStatusType)$it).auditAs(intent).save(userContext));
     }

     public boolean isNull() {
        return resolve() == null;
     }


    public Expression<T, String> getName(){
       return apply(EventStatusType::getName);
    }
    public EventStatusTypeExpression<T, U, U> updateName(String name){
       return new EventStatusTypeExpression(this, $it ->  ((EventStatusType)$it).updateName(name));
    }

    public Expression<T, String> getCode(){
       return apply(EventStatusType::getCode);
    }
    public EventStatusTypeExpression<T, U, U> updateCode(String code){
       return new EventStatusTypeExpression(this, $it ->  ((EventStatusType)$it).updateCode(code));
    }

    public PlatformExpression<T, U, Platform> getPlatform(){
       return new PlatformExpression(this, $it ->  ((EventStatusType)$it).getPlatform());
    }

    public EventStatusTypeExpression<T, U, U> updatePlatform(Platform platform){
       return new EventStatusTypeExpression(this, $it ->  ((EventStatusType)$it).updatePlatform(platform));
    }

    public OutboxEventListExpression<T, U, OutboxEvent> getOutboxEventList(){
        return new OutboxEventListExpression(this, $it ->  ((EventStatusType)$it).getOutboxEventList());
    }
    public EventStatusTypeExpression<T, U, U> addOutboxEvent(OutboxEvent outboxEvent){
       return new EventStatusTypeExpression(this, $it ->  ((EventStatusType)$it).addOutboxEvent(outboxEvent));
    }
}