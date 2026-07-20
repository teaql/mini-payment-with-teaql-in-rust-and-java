package com.doublechaintech.merchantservice.merchantstatustype;

import io.teaql.core.SmartList;
import io.teaql.core.value.Expression;
import io.teaql.core.value.SmartListExpression;
import java.util.function.Function;

public class MerchantStatusTypeListExpression<T, E, U extends MerchantStatusType> extends SmartListExpression<T, E, U> {
    public MerchantStatusTypeListExpression(Expression<T, SmartList<U>> expression){
        super(expression);
    }

    public MerchantStatusTypeListExpression(Expression<T, E> expression, Function<E, SmartList<U>> function){
        super(expression, function);
    }

    public MerchantStatusTypeExpression<T, U, U> first() {
       return new MerchantStatusTypeExpression(super.first());
    }

    public MerchantStatusTypeExpression<T, U, U> get(int index) {
      return new MerchantStatusTypeExpression(super.get(index));
    }
}