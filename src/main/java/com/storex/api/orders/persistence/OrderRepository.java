package com.storex.api.orders.persistence;

import com.storex.api.orders.Order;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface OrderRepository extends MongoRepository<Order, String> {
}
