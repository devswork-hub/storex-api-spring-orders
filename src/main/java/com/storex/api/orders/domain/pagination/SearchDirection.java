package com.storex.api.orders.domain.pagination;

public enum SearchDirection {
  ASC,
  DESC;

  public static SearchDirection from(String direction) {
    if (direction != null) {
      return switch (direction.toUpperCase()) {
        case "ASC", "ASCENDANT" -> ASC;
        case "DESC", "DESCENDANT" -> DESC;
        default -> throw new IllegalArgumentException("Invalid search direction: " + direction);
      };
    }
    throw new IllegalArgumentException("Search direction cannot be null");
  }
}
