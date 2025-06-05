package com.storex.api.orders.core;

import com.storex.api.orders.persistence.OrderRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.HashSet;

@ExtendWith(MockitoExtension.class)
public class OrderTest {
  @Mock
  private OrderRepository repository;

  @BeforeEach
  void setup() {
    final var order = Order.factory(
      OrderStatus.CREATED,
      new HashSet<>(),
        "customerid",
      new BigDecimal("20.0"),
      new BigDecimal("10.00"),
      Currency.BRL
    );
    System.out.println(order);
  }
}
