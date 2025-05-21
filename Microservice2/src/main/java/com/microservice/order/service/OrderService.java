package com.microservice.order.service;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.reactive.function.client.WebClient;

import com.microservice.order.dto.InventoryResponse;
import com.microservice.order.dto.OrderLineItemsRequest;
import com.microservice.order.dto.OrderRequest;
import com.microservice.order.entity.Order;
import com.microservice.order.entity.OrderLineItems;
import com.microservice.order.repo.OrderRepository;

import jakarta.transaction.Transactional;

@Service

public class OrderService {

	@Autowired
	private OrderRepository orderRepo;
	
	@Autowired
	private WebClient webClient;
	
	public void placeOrder(OrderRequest request) {
	    Order order = new Order();
	    order.setOrderNumber(UUID.randomUUID().toString());

	    List<OrderLineItems> orderLineItems = request.getOrderLineItems()
	        .stream()
	        .map(this::mapToDto)
	        .toList();

	    order.setOrderLineItems(orderLineItems);
	    
	    List<String> skuCodes = order.getOrderLineItems().stream()
	    		.map(item -> item.getSkucode())
	    	    .toList();

	    InventoryResponse[] inventoryResponseArray=webClient.get()
	    .uri("http://localhost/8082/inventory",uriBuilder->uriBuilder.queryParam("skucode",skuCodes).build())
	    .retrieve()
	    .bodyToMono(InventoryResponse[].class)
	    .block();
	    
//	   boolean result= webClient.get().uri("http://localhost/8082/inventory").retrieve()
//	    .bodyToMono(boolean.class)
//	    .block();
	    
	   boolean allproducts= Arrays.stream(inventoryResponseArray).allMatch(InventoryResponse::isInStock);
	    if(allproducts) {

	    orderRepo.save(order); // <- persist the order
	}else {
		throw new IllegalArgumentException("product is not in stock");
	}
	}

public OrderLineItems mapToDto(OrderLineItemsRequest orderLineItemsrequest) {
	
	OrderLineItems items=new OrderLineItems();
	items.setPrice(orderLineItemsrequest.getPrice());
	items.setSkucode(orderLineItemsrequest.getSkucode());
	items.setQuantity(orderLineItemsrequest.getQuantity());
	
	return items;
	
	
}








}
