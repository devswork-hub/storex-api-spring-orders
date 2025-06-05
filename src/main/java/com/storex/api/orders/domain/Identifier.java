package com.storex.api.orders.domain;

import java.util.Objects;

public abstract class Identifier extends ValueObject {
  private final String value;

  protected Identifier(final String value) {
    this.value = value;
  }

  public String getValue() {
    return this.value;
  }

  @Override
  public boolean equals(Object o) {
    if (o == null || getClass() != o.getClass()) return false;
    Identifier that = (Identifier) o;
    return Objects.equals(value, that.value);
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(value);
  }
}
