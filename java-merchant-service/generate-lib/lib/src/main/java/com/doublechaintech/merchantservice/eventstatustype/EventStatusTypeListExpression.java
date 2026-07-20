package com.doublechaintech.merchantservice.eventstatustype;

import io.teaql.core.SmartList;
import io.teaql.core.value.Expression;
import io.teaql.core.value.SmartListExpression;
import java.util.function.Function;

public class EventStatusTypeListExpression<T, E, U extends EventStatusType> extends SmartListExpression<T, E, U> {
    public EventStatusTypeListExpression(Expression<T, SmartList<U>> expression){
        super(expression);
    }

    public EventStatusTypeListExpression(Expression<T, E> expression, Function<E, SmartList<U>> function){
        super(expression, function);
    }

    public EventStatusTypeExpression<T, U, U> first() {
       return new EventStatusTypeExpression(super.first());
    }

    public EventStatusTypeExpression<T, U, U> get(int index) {
      return new EventStatusTypeExpression(super.get(index));
    }
}