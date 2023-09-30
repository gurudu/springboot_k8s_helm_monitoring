package com.demo.springbootk8s.adapter.in.rest;

import com.demo.springbootk8s.application.domain.model.OrderRequest;
import com.demo.springbootk8s.application.domain.model.OrderResponse;
import com.demo.springbootk8s.application.port.in.OrderService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1/order")
public class OrderRESTController {

    @Autowired
    private OrderService orderService;

    //http://localhost:8070//api/v1/order/create
    @PostMapping("/create")
    public ResponseEntity<OrderResponse> placeOrder(@RequestBody @Valid  OrderRequest req) {
        OrderResponse order = orderService.orderInsert(req);
        return new ResponseEntity<OrderResponse>(order, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderResponse> getOrder(@PathVariable Long id) {
        OrderResponse result = orderService.findById(id);
        return new ResponseEntity<OrderResponse>(result, HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<OrderResponse>> getAllOrders() {
        List<OrderResponse> result = orderService.findAll();
        return new ResponseEntity<List<OrderResponse>>(result, HttpStatus.OK);
    }

    @DeleteMapping("/cancel/{id}")
    public ResponseEntity<Void> cancelOrder(@PathVariable Long id) {
        if (id != null && orderService.delete(id)) {
            return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
        }
        return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/create/bulk")
    public ResponseEntity<Void> addBulkOrder(@RequestBody @Valid List<OrderRequest> order) {
        if (!CollectionUtils.isEmpty(order)) {
            orderService.insertAll(order);
            return new ResponseEntity<Void>(HttpStatus.OK);
        } else {
            return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Void> updateOrder(@RequestBody @Valid OrderRequest order, @PathVariable Long id) {
        if (id != null && orderService.update(order, id)) {
            return new ResponseEntity<Void>(HttpStatus.OK);
        } else {
            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        }
    }
}
