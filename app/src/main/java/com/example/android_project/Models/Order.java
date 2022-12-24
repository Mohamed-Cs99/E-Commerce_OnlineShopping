package com.example.android_project.Models;

import java.util.Date;

public class Order {
    private int orderId ,customerId ;
    private String  orderDate;
    private String address ;

    public Order() {
    }

    public Order(int customerId, String orderDate, String address) {
        this.customerId = customerId;
        this.orderDate = orderDate;
        this.address = address;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
