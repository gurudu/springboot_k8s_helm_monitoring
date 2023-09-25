package com.demo.springbootk8s.adapter.out.persistence;

import com.demo.springbootk8s.adapter.out.persistence.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

}
