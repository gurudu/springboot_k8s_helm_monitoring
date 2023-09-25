package com.demo.springbootk8s.adapter.out.persistence.entity;

import jakarta.persistence.*;
import lombok.*;


import java.math.BigDecimal;

@Entity
@Builder
@Data
@Table(name = "ORDER_DETAILS")
@AllArgsConstructor
@NoArgsConstructor
public class Order {

    @Id
    @SequenceGenerator(
            name = "order_id_sequence",
            sequenceName = "order_id_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "order_id_sequence"
    )
    private Long id;

    private String orderCategory;
    private String orderName;
    private BigDecimal orderPrice;

    @Column(name = "order_status")
    private String status;

    @Column(name = "shipping_charge")
    private BigDecimal shippingCharge;

    @Column(name = "customer_id")
    private String customerId;
}
