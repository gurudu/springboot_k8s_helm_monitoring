package com.demo.springbootk8s.adapter.out.persistence;

import com.demo.springbootk8s.adapter.out.persistence.entity.Order;
import com.demo.springbootk8s.application.domain.model.OrderRequest;
import com.demo.springbootk8s.application.domain.model.OrderResponse;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface OrderMapper {

    OrderMapper INSTANCE = Mappers.getMapper(OrderMapper.class);

    Order orderRequestToOrder(OrderRequest orderRequest);

    List<Order> orderRequestToOrder(List<OrderRequest> orderRequests);

    OrderResponse orderToOrderResponse(Order order);

    List<OrderResponse> orderToOrderResponse(List<Order> orders);

}
