package com.storex.api.orders.core;

import com.storex.api.orders.domain.Entity;

import java.math.BigDecimal;

public class OrderItem extends Entity<OrderItemID> {
  private final String productId;
  private final int quantity;
  private final BigDecimal price;

  public OrderItem(
    final String productId,
    final int quantity,
    final BigDecimal price
  ) {
    super(new OrderItemID("customorderitem"));
    this.productId = productId;
    this.quantity = quantity;
    this.price = price;
  }

  public String getProductId() {
    return productId;
  }

  public int getQuantity() {
    return quantity;
  }

  public BigDecimal getPrice() {
    return price;
  }
}
