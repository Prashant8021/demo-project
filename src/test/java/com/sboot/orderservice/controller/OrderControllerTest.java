package com.sboot.orderservice.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sboot.orderservice.dto.OrderRequest;
import com.sboot.orderservice.dto.OrderResponse;
import com.sboot.orderservice.service.OrderService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

class OrderControllerTest {

    @Test
    void createOrder_shouldReturn200() throws Exception {
        OrderService orderService = Mockito.mock(OrderService.class);
        OrderController controller = new OrderController(orderService);
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(controller).build();

        // include price in request (required)
        OrderRequest request = new OrderRequest("Prashant", "Laptop", 2, BigDecimal.valueOf(1000));
        // construct response that matches the new OrderResponse signature
        OrderResponse response = new OrderResponse(
                1L,
                "Prashant",
                "Laptop",
                2,
                BigDecimal.valueOf(1000),            // price
                BigDecimal.valueOf(2000),            // totalAmount
                "PENDING",                           // status
                LocalDateTime.now(),                 // createdDate
                null,                                // updatedDate
                "Order created successfully"         // message
        );

        Mockito.when(orderService.createOrder(Mockito.any(OrderRequest.class))).thenReturn(response);

        mockMvc.perform(post("/api/orders")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(request)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.customerName").value("Prashant"))
                .andExpect(jsonPath("$.productName").value("Laptop"))
                .andExpect(jsonPath("$.quantity").value(2))
                .andExpect(jsonPath("$.message").value("Order created successfully"));
    }

    @Test
    void getAllOrders_shouldReturn200() throws Exception {
        OrderService orderService = Mockito.mock(OrderService.class);
        OrderController controller = new OrderController(orderService);
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(controller).build();

        Mockito.when(orderService.getAllOrders()).thenReturn(java.util.List.of());

        mockMvc.perform(get("/api/orders"))
                .andExpect(status().isOk());
    }
}