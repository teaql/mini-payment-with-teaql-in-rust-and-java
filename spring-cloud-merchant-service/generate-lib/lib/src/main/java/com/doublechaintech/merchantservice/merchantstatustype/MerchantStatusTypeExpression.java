package com.doublechaintech.merchantservice.merchantstatustype;

import com.doublechaintech.merchantservice.merchant.Merchant;
import com.doublechaintech.merchantservice.merchant.MerchantListExpression;
import com.doublechaintech.merchantservice.platform.Platform;
import com.doublechaintech.merchantservice.platform.PlatformExpression;
import io.teaql.core.UserContext;
import io.teaql.core.value.BaseEntityExpression;
import io.teaql.core.value.Expression;
import io.teaql.core.value.ExpressionAdaptor;
import java.util.function.Function;

public class MerchantStatusTypeExpression<T, E, U extends MerchantStatusType> extends ExpressionAdaptor<T, E, U> implements BaseEntityExpression<T, U> {
    public MerchantStatusTypeExpression(Expression<T, U> expression){
        super(expression);
    }

    public MerchantStatusTypeExpression(Expression<T, E> expression, Function<E, U> function){
        super(expression, function);
    }

     public MerchantStatusTypeExpression<T, U, U> updateId(Long id){
        return new MerchantStatusTypeExpression(this, $it -> {((MerchantStatusType)$it).__internalSet("id", id); return this;});
     }

     public MerchantStatusTypeExpression<T, U, U> save(UserContext userContext){
        return new MerchantStatusTypeExpression(this, $it -> ((MerchantStatusType)$it).auditAs("Saved by Expression").save(userContext));
     }

     public MerchantStatusTypeExpression<T, U, U> save(String intent, UserContext userContext){
        return new MerchantStatusTypeExpression(this, $it -> ((MerchantStatusType)$it).auditAs(intent).save(userContext));
     }

     public boolean isNull() {
        return resolve() == null;
     }


    public Expression<T, String> getName(){
       return apply(MerchantStatusType::getName);
    }
    public MerchantStatusTypeExpression<T, U, U> updateName(String name){
       return new MerchantStatusTypeExpression(this, $it ->  ((MerchantStatusType)$it).updateName(name));
    }

    public Expression<T, String> getCode(){
       return apply(MerchantStatusType::getCode);
    }
    public MerchantStatusTypeExpression<T, U, U> updateCode(String code){
       return new MerchantStatusTypeExpression(this, $it ->  ((MerchantStatusType)$it).updateCode(code));
    }

    public PlatformExpression<T, U, Platform> getPlatform(){
       return new PlatformExpression(this, $it ->  ((MerchantStatusType)$it).getPlatform());
    }

    public MerchantStatusTypeExpression<T, U, U> updatePlatform(Platform platform){
       return new MerchantStatusTypeExpression(this, $it ->  ((MerchantStatusType)$it).updatePlatform(platform));
    }

    public MerchantListExpression<T, U, Merchant> getMerchantList(){
        return new MerchantListExpression(this, $it ->  ((MerchantStatusType)$it).getMerchantList());
    }
    public MerchantStatusTypeExpression<T, U, U> addMerchant(Merchant merchant){
       return new MerchantStatusTypeExpression(this, $it ->  ((MerchantStatusType)$it).addMerchant(merchant));
    }
}