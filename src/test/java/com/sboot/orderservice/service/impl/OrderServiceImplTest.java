package com.sboot.orderservice.service.impl;

import com.sboot.orderservice.dto.OrderRequest;
import com.sboot.orderservice.dto.OrderResponse;
import com.sboot.orderservice.entity.Order;
import com.sboot.orderservice.repository.OrderRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

class OrderServiceImplTest {

    @Test
    void createOrder_shouldReturnSavedOrderDetails() {
        OrderRepository orderRepository = Mockito.mock(OrderRepository.class);
        OrderServiceImpl orderService = new OrderServiceImpl(orderRepository);

        OrderRequest request = new OrderRequest("Prashant", "Laptop", 2);

        Order savedOrder = new Order();
        savedOrder.setId(1L);
        savedOrder.setCustomerName("Prashant");
        savedOrder.setProductName("Laptop");
        savedOrder.setQuantity(2);

        Mockito.when(orderRepository.save(Mockito.any(Order.class))).thenReturn(savedOrder);

        OrderResponse response = orderService.createOrder(request);

        assertNotNull(response);
        assertEquals(1L, response.getId());
        assertEquals("Prashant", response.getCustomerName());
        assertEquals("Laptop", response.getProductName());
        assertEquals(2, response.getQuantity());
        assertEquals("Order created successfully", response.getMessage());
    }
}
