package com.storex.api.orders.core;

import java.math.BigDecimal;

public record MoneyDTO(BigDecimal amount, String currency) { }
