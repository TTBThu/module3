package com.ra.entity;

public class OrderDetail {
    private int id;
    private String productId;
    private int orderId;
    private float price;
    private int quantity;

    public OrderDetail() {
    }

    public OrderDetail(int id, String productId, int orderId, float price, int quantity) {
        this.id = id;
        this.productId = productId;
        this.orderId = orderId;
        this.price = price;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}