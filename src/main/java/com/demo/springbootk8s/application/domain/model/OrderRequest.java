package com.demo.springbootk8s.application.domain.model;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;

public record OrderRequest(
        @NotBlank(message = "Order Category must not be blank")
        String orderCategory,
        @NotBlank(message = "OrderName must not be blank")
        @Size(min = 3, max = 30, message = "Order Name must has min 3 and max 30 characters")
        String orderName,
        BigDecimal orderPrice, String status, BigDecimal shippingCharge,
        @NotBlank(message = "CustomerID must not be blank")
        String customerId) {
}
