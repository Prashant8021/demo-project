package com.sboot.orderservice.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;


public class OrderResponse {

    private Long id;
    private String customerName;
    private String productName;
    private int quantity;
    private BigDecimal price;
    private BigDecimal totalAmount;
    private String status;
    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;
    private String message;

    public OrderResponse() {
    }

    public OrderResponse(Long id, String customerName, String productName, Integer quantity,
                         BigDecimal price, BigDecimal totalAmount, String status,
                         LocalDateTime createdDate, LocalDateTime updatedDate, String message) {
        this.id = id;
        this.customerName = customerName;
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
        this.totalAmount = totalAmount;
        this.status = status;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
        this.message = message;
    }

    public Long getId() {
        return id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getProductName() {
        return productName;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public String getStatus() {
        return status;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public LocalDateTime getUpdatedDate() {
        return updatedDate;
    }

    public String getMessage() {
        return message;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public void setUpdatedDate(LocalDateTime updatedDate) {
        this.updatedDate = updatedDate;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}