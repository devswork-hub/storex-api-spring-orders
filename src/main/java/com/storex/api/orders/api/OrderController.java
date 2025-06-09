package com.storex.api.orders.api;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.storex.api.orders.core.Order;
import com.storex.api.orders.core.OrderStatus;
//import com.storex.api.orders.persistence.OrderRepository;
import com.storex.api.orders.usecases.SearchService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {
  //  private final OrderRepository orderRepository;
  private final SearchService searchService;

  //  public OrderController(OrderRepository orderRepository, SearchService searchService) {
  public OrderController(final SearchService searchService) {
//    this.orderRepository = orderRepository;
    this.searchService = searchService;
  }

  @GetMapping
  public String test() {
//    var order = new Order();
//    this.orderRepository.save(order);
    return "Finish";
  }

  // GET /orders/search?name=Alex&status=ACTIVE
  @GetMapping("search")
  public List<Order> searchOrders(
      @RequestParam(required = false) final String customerId,
      @RequestParam(required = false) final OrderStatus status,
      @RequestParam(required = false) final @JsonFormat(pattern = "yyyy-MM-dd") LocalDate createdAt,
      @RequestParam(required = false) final @JsonFormat(pattern = "yyyy-MM-dd") LocalDate updatedAt,
      @RequestParam(required = false) final BigDecimal minTotal,
      @RequestParam(required = false) final BigDecimal maxTotal
  ) {
    return searchService.execute(new SearchService.SearchFilter(customerId, status, createdAt, updatedAt, minTotal, maxTotal));
  }
}
