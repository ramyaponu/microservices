package com.microservice.order.dto;

import java.math.BigDecimal;

public class OrderLineItemsRequest {

	private Integer orderId;
	private String skucode;
	private BigDecimal price;
	private Integer quantity;
	
	
	public Integer getOrderId() {
		return orderId;
	}
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}
	public String getSkucode() {
		return skucode;
	}
	public void setSkucode(String skucode) {
		this.skucode = skucode;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public OrderLineItemsRequest(Integer orderId, String skucode, BigDecimal price, Integer quantity) {
		super();
		this.orderId = orderId;
		this.skucode = skucode;
		this.price = price;
		this.quantity = quantity;
	}
	public OrderLineItemsRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
