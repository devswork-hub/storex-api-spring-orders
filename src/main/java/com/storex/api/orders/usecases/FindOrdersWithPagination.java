package com.storex.api.orders.usecases;

import com.storex.api.orders.core.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FindOrdersWithPagination {
  public record PaginationEntry(String name, int page, int size) {}
  private final MongoTemplate mongoTemplate;

  public FindOrdersWithPagination(MongoTemplate mongoTemplate) {
    this.mongoTemplate = mongoTemplate;
  }

  public Page<Order> execute(final PaginationEntry entry) {
    Query query = new Query();
    if (entry.name != null) {
      query.addCriteria(Criteria.where("name").regex(entry.name, "i"));
    }
    long total = mongoTemplate.count(query, Order.class);
    query.with(PageRequest.of(entry.page, entry.size));

    List<Order> users = mongoTemplate.find(query, Order.class);
    return new PageImpl<>(users, PageRequest.of(entry.page, entry.size), total);
  }
}
