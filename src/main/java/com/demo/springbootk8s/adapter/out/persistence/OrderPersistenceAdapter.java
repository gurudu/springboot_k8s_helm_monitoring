package com.demo.springbootk8s.adapter.out.persistence;

import com.demo.springbootk8s.adapter.out.persistence.entity.Order;
import com.demo.springbootk8s.application.domain.model.OrderRequest;
import com.demo.springbootk8s.application.domain.model.OrderResponse;
import com.demo.springbootk8s.application.port.out.OrderCRUDOperationsPort;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderPersistenceAdapter implements OrderCRUDOperationsPort {

    @Autowired
    private OrderRepository orderRepository;

    private final OrderMapper orderMapper = OrderMapper.INSTANCE;

    @Override
    public OrderResponse findById(Long id) {
        return orderMapper.orderToOrderResponse(orderRepository.findById(id).orElse(null));
    }

    @Override
    @Modifying
    public OrderResponse orderInsert( OrderRequest orderRequest) {
        Order order = orderRepository.save(orderMapper.orderRequestToOrder(orderRequest));
        return orderMapper.orderToOrderResponse(order);
    }

    @Override
    @Transactional
    @Modifying
    public void insertAll(List<OrderRequest> orderRequests) {
        List<Order> orders = orderMapper.orderRequestToOrder(orderRequests);
        orderRepository.saveAll(orders);
    }

    @Override
    @Modifying
    public boolean delete(Long id) {
        Optional<Order> order = orderRepository.findById(id);
        if (order.isPresent()) {
            orderRepository.delete(order.get());
            return true;
        } else {
            return false;
        }
    }

    @Override
    @Modifying
    public boolean update(OrderRequest orderRequest, Long id) {
        Optional<Order> existingOrder = orderRepository.findById(id);
        if (existingOrder.isPresent()) {
            Order order = orderMapper.orderRequestToOrder(orderRequest);
            order.setId(existingOrder.get().getId());
            orderRepository.save(order);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public List<OrderResponse> findAll() {
        return orderMapper.orderToOrderResponse(orderRepository.findAll());
    }
}
