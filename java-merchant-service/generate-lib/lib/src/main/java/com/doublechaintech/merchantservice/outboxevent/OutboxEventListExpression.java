package com.doublechaintech.merchantservice.outboxevent;

import io.teaql.core.SmartList;
import io.teaql.core.value.Expression;
import io.teaql.core.value.SmartListExpression;
import java.util.function.Function;

public class OutboxEventListExpression<T, E, U extends OutboxEvent> extends SmartListExpression<T, E, U> {
    public OutboxEventListExpression(Expression<T, SmartList<U>> expression){
        super(expression);
    }

    public OutboxEventListExpression(Expression<T, E> expression, Function<E, SmartList<U>> function){
        super(expression, function);
    }

    public OutboxEventExpression<T, U, U> first() {
       return new OutboxEventExpression(super.first());
    }

    public OutboxEventExpression<T, U, U> get(int index) {
      return new OutboxEventExpression(super.get(index));
    }
}