package com.storex.api.orders.usecases;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.storex.api.orders.core.Order;
import com.storex.api.orders.core.OrderStatus;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

// findOrderByCriteria
@Service
public class SearchService {
  public record SearchFilter(
      String customerId,
      OrderStatus status,
      @JsonFormat(pattern = "yyyy-MM-dd") LocalDate createdAt,
      @JsonFormat(pattern = "yyyy-MM-dd") LocalDate updatedAt,
      BigDecimal minTotal,
      BigDecimal maxTotal
  ) {
  }

  private final MongoTemplate template;

  public SearchService(MongoTemplate template) {
    this.template = template;
  }

  public List<Order> execute(final SearchFilter filters) {
    Criteria criteria = new Criteria();

    if (filters.customerId() != null && !filters.customerId().isEmpty()) {
      criteria.and("customerId").is(filters.customerId());
    }
    if (filters.status() != null) {
      criteria.and("status").is(filters.status());
    }
    if (filters.createdAt() != null) {
      criteria.and("createdAt").gte(filters.createdAt());
    }
    if (filters.updatedAt() != null) {
      criteria.and("updatedAt").lte(filters.updatedAt());
    }
    if (filters.minTotal() != null) {
      criteria.and("total").gte(filters.minTotal());
    }
    if (filters.maxTotal() != null) {
      criteria.and("total").lte(filters.maxTotal());
    }

    Query query = new Query(criteria);
    return template.find(query, Order.class);
  }
}
