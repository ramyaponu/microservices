package com.microservice.order.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.order.dto.OrderRequest;
import com.microservice.order.entity.Order;
import com.microservice.order.entity.OrderLineItems;
import com.microservice.order.service.OrderService;

@RestController
public class OrderController {

	@Autowired
	private OrderService orderService;
	
	@PostMapping("/placeOrder")
	public String add(@RequestBody OrderRequest order) {
		orderService.placeOrder(order);
		return "order placed successfully";
	}
	
	
}
