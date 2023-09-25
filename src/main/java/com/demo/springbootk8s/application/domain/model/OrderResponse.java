package com.demo.springbootk8s.application.domain.model;

import java.math.BigDecimal;

public record OrderResponse(String orderCategory, String orderName, BigDecimal orderPrice, String status, BigDecimal shippingCharge) {
}
