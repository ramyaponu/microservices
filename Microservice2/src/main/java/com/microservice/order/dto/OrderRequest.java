package com.microservice.order.dto;

import java.util.List;

public class OrderRequest {

    private List<OrderLineItemsRequest> orderLineItems;

    public List<OrderLineItemsRequest> getOrderLineItems() {
        return orderLineItems;
    }

    public void setOrderLineItems(List<OrderLineItemsRequest> orderLineItems) {
        this.orderLineItems = orderLineItems;
    }

    public OrderRequest() {
        super();
    }

    public OrderRequest(List<OrderLineItemsRequest> orderLineItems) {
        this.orderLineItems = orderLineItems;
    }
}
