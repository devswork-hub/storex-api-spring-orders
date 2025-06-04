package com.storex.api.orders.persistence;

import com.storex.api.orders.OrderDocument;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface OrderRepository extends MongoRepository<OrderDocument, String> {
}
