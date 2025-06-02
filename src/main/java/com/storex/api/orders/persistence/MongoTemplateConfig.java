package com.storex.api.orders.persistence;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoClientDatabaseFactory;

@Configuration
public class MongoTemplateConfig {
  @Bean
  public MongoDatabaseFactory mongoConfigure(){
    return new SimpleMongoClientDatabaseFactory("mongodb://admin:admin@localhost:27017/orders?authSource=admin");
  }

  @Bean
  public MongoTemplate mongoTemplate(){
    return new MongoTemplate(mongoConfigure());
  }
}
