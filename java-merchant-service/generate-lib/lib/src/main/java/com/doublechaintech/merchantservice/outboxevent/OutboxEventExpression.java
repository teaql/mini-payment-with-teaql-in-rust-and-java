package com.doublechaintech.merchantservice.outboxevent;

import com.doublechaintech.merchantservice.eventstatustype.EventStatusType;
import com.doublechaintech.merchantservice.eventstatustype.EventStatusTypeExpression;
import com.doublechaintech.merchantservice.merchant.Merchant;
import com.doublechaintech.merchantservice.merchant.MerchantExpression;
import io.teaql.core.UserContext;
import io.teaql.core.value.BaseEntityExpression;
import io.teaql.core.value.Expression;
import io.teaql.core.value.ExpressionAdaptor;
import java.time.LocalDateTime;
import java.util.function.Function;

public class OutboxEventExpression<T, E, U extends OutboxEvent> extends ExpressionAdaptor<T, E, U> implements BaseEntityExpression<T, U> {
    public OutboxEventExpression(Expression<T, U> expression){
        super(expression);
    }

    public OutboxEventExpression(Expression<T, E> expression, Function<E, U> function){
        super(expression, function);
    }

     public OutboxEventExpression<T, U, U> updateId(Long id){
        return new OutboxEventExpression(this, $it -> {((OutboxEvent)$it).__internalSet("id", id); return this;});
     }

     public OutboxEventExpression<T, U, U> save(UserContext userContext){
        return new OutboxEventExpression(this, $it -> ((OutboxEvent)$it).auditAs("Saved by Expression").save(userContext));
     }

     public OutboxEventExpression<T, U, U> save(String intent, UserContext userContext){
        return new OutboxEventExpression(this, $it -> ((OutboxEvent)$it).auditAs(intent).save(userContext));
     }

     public boolean isNull() {
        return resolve() == null;
     }


    public Expression<T, String> getEventType(){
       return apply(OutboxEvent::getEventType);
    }
    public OutboxEventExpression<T, U, U> updateEventType(String eventType){
       return new OutboxEventExpression(this, $it ->  ((OutboxEvent)$it).updateEventType(eventType));
    }

    public Expression<T, String> getPayload(){
       return apply(OutboxEvent::getPayload);
    }
    public OutboxEventExpression<T, U, U> updatePayload(String payload){
       return new OutboxEventExpression(this, $it ->  ((OutboxEvent)$it).updatePayload(payload));
    }

    public EventStatusTypeExpression<T, U, EventStatusType> getStatus(){
       return new EventStatusTypeExpression(this, $it ->  ((OutboxEvent)$it).getStatus());
    }

    public OutboxEventExpression<T, U, U> updateStatusToPending(){
       return new OutboxEventExpression(this, $it ->  ((OutboxEvent)$it).updateStatusToPending());
    }
    public OutboxEventExpression<T, U, U> updateStatusToProcessed(){
       return new OutboxEventExpression(this, $it ->  ((OutboxEvent)$it).updateStatusToProcessed());
    }
    public OutboxEventExpression<T, U, U> updateStatusToFailed(){
       return new OutboxEventExpression(this, $it ->  ((OutboxEvent)$it).updateStatusToFailed());
    }

    public MerchantExpression<T, U, Merchant> getMerchant(){
       return new MerchantExpression(this, $it ->  ((OutboxEvent)$it).getMerchant());
    }

    public OutboxEventExpression<T, U, U> updateMerchant(Merchant merchant){
       return new OutboxEventExpression(this, $it ->  ((OutboxEvent)$it).updateMerchant(merchant));
    }

    public Expression<T, LocalDateTime> getCreateTime(){
       return apply(OutboxEvent::getCreateTime);
    }
    public OutboxEventExpression<T, U, U> updateCreateTime(LocalDateTime createTime){
       return new OutboxEventExpression(this, $it ->  ((OutboxEvent)$it).updateCreateTime(createTime));
    }

    public Expression<T, LocalDateTime> getUpdateTime(){
       return apply(OutboxEvent::getUpdateTime);
    }
    public OutboxEventExpression<T, U, U> updateUpdateTime(LocalDateTime updateTime){
       return new OutboxEventExpression(this, $it ->  ((OutboxEvent)$it).updateUpdateTime(updateTime));
    }

    public Expression<T, LocalDateTime> getProcessedAt(){
       return apply(OutboxEvent::getProcessedAt);
    }
    public OutboxEventExpression<T, U, U> updateProcessedAt(LocalDateTime processedAt){
       return new OutboxEventExpression(this, $it ->  ((OutboxEvent)$it).updateProcessedAt(processedAt));
    }

}