package com.storex.api.orders.core;

import com.storex.api.orders.OrderID;
import com.storex.api.orders.domain.Aggregate;

import java.math.BigDecimal;
import java.util.Set;

public class Order extends Aggregate<OrderID> {
  private OrderStatus status;
  private Set<OrderItem> items;
  private String customerId;
  private BigDecimal shippingFee;
  private BigDecimal discount;
  private BigDecimal subTotal;
  private BigDecimal total;
  private Currency currency;

  private Order() {
    super(new OrderID("orderid"));
  }

  public static Order factory() {
    return new Order();
  }
}
