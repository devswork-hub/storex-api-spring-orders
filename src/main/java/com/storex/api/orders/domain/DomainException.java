package com.storex.api.orders.domain;

import java.util.List;
import java.util.Map;

public class DomainException extends RuntimeException{
  private final Map<String, List<String>> errors;

  public DomainException(Map<String, List<String>> errors) {
    super(DomainException.class.getName());
    this.errors = errors;
  }

  public Map<String, List<String>> getErrors() {
    return errors;
  }
}
