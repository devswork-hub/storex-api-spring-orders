package com.storex.api.orders;

import com.storex.api.orders.persistence.OrderRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class OrderController {
  private final OrderRepository orderRepository;

  public OrderController(OrderRepository orderRepository) {
    this.orderRepository = orderRepository;
  }

  @GetMapping
  public String test() {
    var order = new OrderDocument();
    this.orderRepository.save(order);
    return "Finish";
  }
}
