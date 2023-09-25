package com.demo.springbootk8s.application.domain.service;

import com.demo.springbootk8s.application.domain.model.OrderRequest;
import com.demo.springbootk8s.application.domain.model.OrderResponse;
import com.demo.springbootk8s.application.port.in.OrderService;
import com.demo.springbootk8s.application.port.out.OrderCRUDOperationsPort;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderCRUDOperationsPort orderCRUDOperationsPort;

    private static final Logger log = LoggerFactory.getLogger(OrderServiceImpl.class);

    @Override
    public OrderResponse findById(Long id) {
        return orderCRUDOperationsPort.findById(id);
    }

    @Override
    public OrderResponse orderInsert(OrderRequest orderRequest) {
        return orderCRUDOperationsPort.orderInsert(orderRequest);
    }

    @Override
    public void insertAll(List<OrderRequest> orderRequests) {
        orderCRUDOperationsPort.insertAll(orderRequests);
    }

    @Override
    public boolean delete(Long id) {
        return orderCRUDOperationsPort.delete(id);
    }

    @Override
    public boolean update(OrderRequest orderRequest, Long id) {
        return orderCRUDOperationsPort.update(orderRequest, id);
    }
}