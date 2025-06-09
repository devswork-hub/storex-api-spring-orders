package com.storex.api.orders.domain.cqrs;

public interface CommandHandler<R, C> {
  R handle(C command);
}
