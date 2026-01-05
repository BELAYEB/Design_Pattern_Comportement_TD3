package com.tekup.ex3_Observer;

public class CustomerObserver implements Observer {

    private String name;
    public CustomerObserver(String name) {
        this.name = name;
    }
    @Override
    public void update(Order order) {
        System.out.println("[CLIENT " + name + "] Commande " + order.getOrderId()
                + " -> " + order.getStatus());
    }
}
