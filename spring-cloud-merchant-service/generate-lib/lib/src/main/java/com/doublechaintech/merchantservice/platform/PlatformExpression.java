package com.doublechaintech.merchantservice.platform;

import com.doublechaintech.merchantservice.eventstatustype.EventStatusType;
import com.doublechaintech.merchantservice.eventstatustype.EventStatusTypeListExpression;
import com.doublechaintech.merchantservice.merchant.Merchant;
import com.doublechaintech.merchantservice.merchant.MerchantListExpression;
import com.doublechaintech.merchantservice.merchantstatustype.MerchantStatusType;
import com.doublechaintech.merchantservice.merchantstatustype.MerchantStatusTypeListExpression;
import io.teaql.core.UserContext;
import io.teaql.core.value.BaseEntityExpression;
import io.teaql.core.value.Expression;
import io.teaql.core.value.ExpressionAdaptor;
import java.time.LocalDateTime;
import java.util.function.Function;

public class PlatformExpression<T, E, U extends Platform> extends ExpressionAdaptor<T, E, U> implements BaseEntityExpression<T, U> {
    public PlatformExpression(Expression<T, U> expression){
        super(expression);
    }

    public PlatformExpression(Expression<T, E> expression, Function<E, U> function){
        super(expression, function);
    }

     public PlatformExpression<T, U, U> updateId(Long id){
        return new PlatformExpression(this, $it -> {((Platform)$it).__internalSet("id", id); return this;});
     }

     public PlatformExpression<T, U, U> save(UserContext userContext){
        return new PlatformExpression(this, $it -> ((Platform)$it).auditAs("Saved by Expression").save(userContext));
     }

     public PlatformExpression<T, U, U> save(String intent, UserContext userContext){
        return new PlatformExpression(this, $it -> ((Platform)$it).auditAs(intent).save(userContext));
     }

     public boolean isNull() {
        return resolve() == null;
     }


    public Expression<T, String> getName(){
       return apply(Platform::getName);
    }
    public PlatformExpression<T, U, U> updateName(String name){
       return new PlatformExpression(this, $it ->  ((Platform)$it).updateName(name));
    }

    public Expression<T, LocalDateTime> getCreateTime(){
       return apply(Platform::getCreateTime);
    }
    public PlatformExpression<T, U, U> updateCreateTime(LocalDateTime createTime){
       return new PlatformExpression(this, $it ->  ((Platform)$it).updateCreateTime(createTime));
    }

    public Expression<T, LocalDateTime> getUpdateTime(){
       return apply(Platform::getUpdateTime);
    }
    public PlatformExpression<T, U, U> updateUpdateTime(LocalDateTime updateTime){
       return new PlatformExpression(this, $it ->  ((Platform)$it).updateUpdateTime(updateTime));
    }

    public MerchantListExpression<T, U, Merchant> getMerchantList(){
        return new MerchantListExpression(this, $it ->  ((Platform)$it).getMerchantList());
    }
    public MerchantStatusTypeListExpression<T, U, MerchantStatusType> getMerchantStatusTypeList(){
        return new MerchantStatusTypeListExpression(this, $it ->  ((Platform)$it).getMerchantStatusTypeList());
    }
    public EventStatusTypeListExpression<T, U, EventStatusType> getEventStatusTypeList(){
        return new EventStatusTypeListExpression(this, $it ->  ((Platform)$it).getEventStatusTypeList());
    }
    public PlatformExpression<T, U, U> addMerchant(Merchant merchant){
       return new PlatformExpression(this, $it ->  ((Platform)$it).addMerchant(merchant));
    }
    public PlatformExpression<T, U, U> addMerchantStatusType(MerchantStatusType merchantStatusType){
       return new PlatformExpression(this, $it ->  ((Platform)$it).addMerchantStatusType(merchantStatusType));
    }
    public PlatformExpression<T, U, U> addEventStatusType(EventStatusType eventStatusType){
       return new PlatformExpression(this, $it ->  ((Platform)$it).addEventStatusType(eventStatusType));
    }
}