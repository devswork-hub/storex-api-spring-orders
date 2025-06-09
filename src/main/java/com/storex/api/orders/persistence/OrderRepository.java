package com.storex.api.orders.persistence;

import com.storex.api.orders.core.Order;
import com.storex.api.orders.core.OrderStatus;
//import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.MongoRepository;
//import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import java.time.LocalDate;
import java.util.List;

public interface OrderRepository extends MongoRepository<OrderDocument, String>, QuerydslPredicateExecutor<Order> {
//public interface OrderRepository extends OrderRepositoryGateway {
//  public default List<Order> findByCriteria(String name, String email, String status) {
//    Query query = new Query();
//    if (name != null) {
//      query.addCriteria(Criteria.where("name").regex(name, "i"));
//    }
//    if (email != null) {
//      query.addCriteria(Criteria.where("email").regex(email, "i"));
//    }
//    if (status != null) {
//      query.addCriteria(Criteria.where("status").is(status));
//    }
//    return mongoTemplate.find(query, User.class);
//  }
  List<Order> findByClienteId(String clienteId);
  List<Order> findByStatus(final OrderStatus status);
  List<Order> findByDataPedidoBetween(LocalDate dataInicio, LocalDate dataFim);
}
