package com.tekup.ex3_Observer;

public class Order extends Subject {
    private String orderId;
    private String status;

    public Order(String orderId) {
        this.orderId = orderId;
        this.status = "Created";
    }

    public String getOrderId() {
        return orderId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
        notifyObservers((Order)this);
    }
}
