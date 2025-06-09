package com.storex.api.orders.core;

import java.math.BigDecimal;

public class MoneyVO {
  private BigDecimal amount;
  private String currency;

  public MoneyVO() {}

  public MoneyVO(final BigDecimal amount, final String currency) {
    this.amount = amount;
    this.currency = currency;
  }

  public BigDecimal getAmount() {
    return amount;
  }

  public String getCurrency() {
    return currency;
  }

  public MoneyVO add(MoneyVO money) {
    if (!this.currency.equals(money.currency))
      throw new IllegalArgumentException("Moedas diferentes não podem ser somadas.");

    final var newAmount = this.amount.add(money.amount);
    return new MoneyVO(newAmount, this.currency);
  }

  public MoneyVO subtract(MoneyVO money) {
    if (!this.currency.equals(money.currency))
      throw new IllegalArgumentException("Moedas diferentes não podem ser subtraídas.");

    final var newAmount = this.amount.subtract(money.amount);
    return new MoneyVO(newAmount, this.currency);
  }

  public String toString() {
    return amount + " " + currency;
  }
}
