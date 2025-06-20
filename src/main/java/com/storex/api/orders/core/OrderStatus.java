package com.storex.api.orders.core;

public enum OrderStatus {
  CREATED("CRIADO"),
  UPDATED("ATUALIZADO"),
  CANCELLED("CANCELADO"),
  SENT("ENVIADO"),
  DELIVERED("ENTREGUE");

  private final String value;

  OrderStatus(String value) {
    this.value = value;
  }

  public String getValue() {
    return this.value;
  }
}
