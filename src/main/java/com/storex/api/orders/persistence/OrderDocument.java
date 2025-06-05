package com.storex.api.orders.persistence;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "orders")
public class OrderDocument {
  @Id
  private String id;
  private String example;
}
