package com.microservice.order.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.microservice.order.entity.Order;
import com.microservice.order.entity.OrderLineItems;

public interface OrderRepository extends JpaRepository<Order, Integer>{

}
