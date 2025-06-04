package com.storex.api.orders.core;

public enum Currency {
  BRL("BRL"),
  EUR("EUR"),
  USD("USD");

  private final String value;

  Currency(String value) {
    this.value = value;
  }

  public String getValue() {
    return this.value;
  }
}
