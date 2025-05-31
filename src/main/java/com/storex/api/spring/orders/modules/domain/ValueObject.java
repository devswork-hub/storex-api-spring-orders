package com.storex.api.spring.orders.modules.domain;

public abstract class ValueObject {
  @Override
  public abstract boolean equals(Object o);

  @Override
  public abstract int hashCode();
}
