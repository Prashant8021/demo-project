package com.sboot.orderservice.service;

import com.sboot.orderservice.dto.OrderRequest;
import com.sboot.orderservice.dto.OrderResponse;

import java.util.List;

public interface OrderService {
    OrderResponse createOrder(OrderRequest request);
    List<OrderResponse> getAllOrders();
    OrderResponse getOrderById(Long id);
}
