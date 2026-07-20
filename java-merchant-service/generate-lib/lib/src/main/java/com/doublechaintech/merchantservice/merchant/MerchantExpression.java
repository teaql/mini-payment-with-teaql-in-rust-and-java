package com.doublechaintech.merchantservice.merchant;

import com.doublechaintech.merchantservice.merchantkyc.MerchantKyc;
import com.doublechaintech.merchantservice.merchantkyc.MerchantKycListExpression;
import com.doublechaintech.merchantservice.merchantstatustype.MerchantStatusType;
import com.doublechaintech.merchantservice.merchantstatustype.MerchantStatusTypeExpression;
import com.doublechaintech.merchantservice.outboxevent.OutboxEvent;
import com.doublechaintech.merchantservice.outboxevent.OutboxEventListExpression;
import com.doublechaintech.merchantservice.platform.Platform;
import com.doublechaintech.merchantservice.platform.PlatformExpression;
import io.teaql.core.UserContext;
import io.teaql.core.value.BaseEntityExpression;
import io.teaql.core.value.Expression;
import io.teaql.core.value.ExpressionAdaptor;
import java.time.LocalDateTime;
import java.util.function.Function;

public class MerchantExpression<T, E, U extends Merchant> extends ExpressionAdaptor<T, E, U> implements BaseEntityExpression<T, U> {
    public MerchantExpression(Expression<T, U> expression){
        super(expression);
    }

    public MerchantExpression(Expression<T, E> expression, Function<E, U> function){
        super(expression, function);
    }

     public MerchantExpression<T, U, U> updateId(Long id){
        return new MerchantExpression(this, $it -> {((Merchant)$it).__internalSet("id", id); return this;});
     }

     public MerchantExpression<T, U, U> save(UserContext userContext){
        return new MerchantExpression(this, $it -> ((Merchant)$it).auditAs("Saved by Expression").save(userContext));
     }

     public MerchantExpression<T, U, U> save(String intent, UserContext userContext){
        return new MerchantExpression(this, $it -> ((Merchant)$it).auditAs(intent).save(userContext));
     }

     public boolean isNull() {
        return resolve() == null;
     }


    public Expression<T, String> getCompanyName(){
       return apply(Merchant::getCompanyName);
    }
    public MerchantExpression<T, U, U> updateCompanyName(String companyName){
       return new MerchantExpression(this, $it ->  ((Merchant)$it).updateCompanyName(companyName));
    }

    public Expression<T, String> getContactEmail(){
       return apply(Merchant::getContactEmail);
    }
    public MerchantExpression<T, U, U> updateContactEmail(String contactEmail){
       return new MerchantExpression(this, $it ->  ((Merchant)$it).updateContactEmail(contactEmail));
    }

    public Expression<T, String> getAppKey(){
       return apply(Merchant::getAppKey);
    }
    public MerchantExpression<T, U, U> updateAppKey(String appKey){
       return new MerchantExpression(this, $it ->  ((Merchant)$it).updateAppKey(appKey));
    }

    public MerchantStatusTypeExpression<T, U, MerchantStatusType> getStatus(){
       return new MerchantStatusTypeExpression(this, $it ->  ((Merchant)$it).getStatus());
    }

    public MerchantExpression<T, U, U> updateStatusToActive(){
       return new MerchantExpression(this, $it ->  ((Merchant)$it).updateStatusToActive());
    }
    public MerchantExpression<T, U, U> updateStatusToPendingVerification(){
       return new MerchantExpression(this, $it ->  ((Merchant)$it).updateStatusToPendingVerification());
    }
    public MerchantExpression<T, U, U> updateStatusToSuspended(){
       return new MerchantExpression(this, $it ->  ((Merchant)$it).updateStatusToSuspended());
    }

    public PlatformExpression<T, U, Platform> getPlatform(){
       return new PlatformExpression(this, $it ->  ((Merchant)$it).getPlatform());
    }

    public MerchantExpression<T, U, U> updatePlatform(Platform platform){
       return new MerchantExpression(this, $it ->  ((Merchant)$it).updatePlatform(platform));
    }

    public Expression<T, LocalDateTime> getCreateTime(){
       return apply(Merchant::getCreateTime);
    }
    public MerchantExpression<T, U, U> updateCreateTime(LocalDateTime createTime){
       return new MerchantExpression(this, $it ->  ((Merchant)$it).updateCreateTime(createTime));
    }

    public Expression<T, LocalDateTime> getUpdateTime(){
       return apply(Merchant::getUpdateTime);
    }
    public MerchantExpression<T, U, U> updateUpdateTime(LocalDateTime updateTime){
       return new MerchantExpression(this, $it ->  ((Merchant)$it).updateUpdateTime(updateTime));
    }

    public MerchantKycListExpression<T, U, MerchantKyc> getMerchantKycList(){
        return new MerchantKycListExpression(this, $it ->  ((Merchant)$it).getMerchantKycList());
    }
    public OutboxEventListExpression<T, U, OutboxEvent> getOutboxEventList(){
        return new OutboxEventListExpression(this, $it ->  ((Merchant)$it).getOutboxEventList());
    }
    public MerchantExpression<T, U, U> addMerchantKyc(MerchantKyc merchantKyc){
       return new MerchantExpression(this, $it ->  ((Merchant)$it).addMerchantKyc(merchantKyc));
    }
    public MerchantExpression<T, U, U> addOutboxEvent(OutboxEvent outboxEvent){
       return new MerchantExpression(this, $it ->  ((Merchant)$it).addOutboxEvent(outboxEvent));
    }
}