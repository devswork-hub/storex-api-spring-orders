package com.storex.api.orders.core;

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

  private Order(
    final OrderStatus status,
    final Set<OrderItem> items,
    final String customerId,
    final BigDecimal shippingFee,
    final BigDecimal discount,
    final Currency currency
  ) {
    super(new OrderID("customorderid"));
    this.status = status;
    this.items = items;
    this.customerId = customerId;
    this.shippingFee = shippingFee;
    this.discount = discount;
    this.currency = currency;
  }

  public static Order factory(
    final OrderStatus status,
    final Set<OrderItem> items,
    final String customerId,
    final BigDecimal shippingFee,
    final BigDecimal discount,
    final Currency currency
  ) {
    final var order = new Order(
      status,
      items,
      customerId,
      shippingFee,
      discount,
      currency
    );
    final var calculatedSubTotal = items.stream()
      .map(item -> item.getPrice().multiply(BigDecimal.valueOf(item.getQuantity())))
      .reduce(BigDecimal.ZERO, BigDecimal::add);

    final var calculatedTotal = calculatedSubTotal
      .add(shippingFee)
      .subtract(discount);

    order.setSubTotal(calculatedSubTotal);
    order.setTotal(calculatedTotal);
    return order;
  }

  public OrderStatus getStatus() {
    return status;
  }

  public Set<OrderItem> getItems() {
    return items;
  }

  public String getCustomerId() {
    return customerId;
  }

  public BigDecimal getSubTotal() {
    calculateSubTotal();
    return subTotal;
  }

  public BigDecimal getShippingFee() {
    return shippingFee;
  }

  public BigDecimal getDiscount() {
    return discount;
  }

  public BigDecimal getTotal() {
    calculateTotal();
    return total;
  }

  public Currency getCurrency() {
    return this.currency;
  }

  public void setStatus(OrderStatus status) {
    this.status = status;
  }

  public void setItems(Set<OrderItem> items) {
    this.items = items;
    calculateSubTotal();
    calculateTotal();
  }

  public void setCustomerId(String customerId) {
    this.customerId = customerId;
  }

  public void setSubTotal(BigDecimal subTotal) {
    this.subTotal = subTotal;
  }

  public void setShippingFee(BigDecimal shippingFee) {
    this.shippingFee = shippingFee;
    calculateTotal();
  }

  public void setDiscount(BigDecimal discount) {
    this.discount = discount;
    calculateTotal();
  }

  public void setTotal(BigDecimal total) {
    this.total = total;
  }

  public void setCurrency(final Currency currency) {
    this.currency = currency;
  }

  public void calculateSubTotal() {
    this.subTotal = items.stream()
      .map(item -> item.getPrice().multiply(BigDecimal.valueOf(item.getQuantity())))
      .reduce(BigDecimal.ZERO, BigDecimal::add);
  }

  public void calculateTotal() {
    if (subTotal == null) {
      calculateSubTotal();
    }
    this.total = subTotal.add(shippingFee).subtract(discount);
  }
}
