package com.sboot.orderservice.service.impl;

import com.sboot.orderservice.dto.OrderRequest;
import com.sboot.orderservice.dto.OrderResponse;
import com.sboot.orderservice.entity.Order;
import com.sboot.orderservice.repository.OrderRepository;
import com.sboot.orderservice.service.OrderService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public OrderResponse createOrder(OrderRequest request) {
        Order order = new Order();
        order.setCustomerName(request.getCustomerName());
        order.setProductName(request.getProductName());
        order.setQuantity(request.getQuantity());

        Order saved = orderRepository.save(order);

        return new OrderResponse(
                saved.getId(),
                saved.getCustomerName(),
                saved.getProductName(),
                saved.getQuantity(),
                "Order created successfully"
        );
    }

    @Override
    public List<OrderResponse> getAllOrders() {
        return orderRepository.findAll()
                .stream()
                .map(order -> new OrderResponse(
                        order.getId(),
                        order.getCustomerName(),
                        order.getProductName(),
                        order.getQuantity(),
                        "Order fetched successfully"
                ))
                .collect(Collectors.toList());
    }

    @Override
    public OrderResponse getOrderById(Long id) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Order not found with id: " + id));

        return new OrderResponse(
                order.getId(),
                order.getCustomerName(),
                order.getProductName(),
                order.getQuantity(),
                "Order fetched successfully"
        );
    }
}
