package com.storex.api.orders.persistence;

import com.storex.api.orders.domain.pagination.SearchDirection;

public record OrderPaginationQuery(
    int page,
    int perPage,
    String sort,
    SearchDirection direction
//    OrderFilter filter
) {}