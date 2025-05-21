package com.microservice.order.entity;

import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="orders_line")
public class OrderLineItems {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
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
	public OrderLineItems(Integer orderId, String skucode, BigDecimal price, Integer quantity) {
		super();
		this.orderId = orderId;
		this.skucode = skucode;
		this.price = price;
		this.quantity = quantity;
	}
	public OrderLineItems() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
}
