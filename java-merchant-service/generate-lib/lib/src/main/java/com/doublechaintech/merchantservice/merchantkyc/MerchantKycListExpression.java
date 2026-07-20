package com.doublechaintech.merchantservice.merchantkyc;

import io.teaql.core.SmartList;
import io.teaql.core.value.Expression;
import io.teaql.core.value.SmartListExpression;
import java.util.function.Function;

public class MerchantKycListExpression<T, E, U extends MerchantKyc> extends SmartListExpression<T, E, U> {
    public MerchantKycListExpression(Expression<T, SmartList<U>> expression){
        super(expression);
    }

    public MerchantKycListExpression(Expression<T, E> expression, Function<E, SmartList<U>> function){
        super(expression, function);
    }

    public MerchantKycExpression<T, U, U> first() {
       return new MerchantKycExpression(super.first());
    }

    public MerchantKycExpression<T, U, U> get(int index) {
      return new MerchantKycExpression(super.get(index));
    }
}