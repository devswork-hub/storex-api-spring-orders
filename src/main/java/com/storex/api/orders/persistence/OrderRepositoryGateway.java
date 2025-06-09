package com.storex.api.orders.persistence;

import com.storex.api.orders.core.Order;
import com.storex.api.orders.core.OrderStatus;
import com.storex.api.orders.domain.pagination.Pagination;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

public interface OrderRepositoryGateway {
  void save(Order order);
  void saveAll(List<Order> orders);
  List<Order> findAll();
  Pagination<Order> findAll(OrderPaginationQuery query);
  void deleteById(String id);
  Optional<Order> findById(String id);
  void update(Order order);
  List<Order> findByCriteria(final OrderStatus status, final Instant createdAt);
}
