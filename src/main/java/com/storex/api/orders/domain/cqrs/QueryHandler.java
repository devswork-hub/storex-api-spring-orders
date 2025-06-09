package com.storex.api.orders.domain.cqrs;

public interface QueryHandler<R, Q> {
  R handle(Q query);
}
