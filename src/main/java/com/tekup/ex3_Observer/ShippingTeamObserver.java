package com.tekup.ex3_Observer;

public class ShippingTeamObserver implements Observer{


    @Override
    public void update(Order order) {
        System.out.println("[EXPEDITION] Commande " + order.getOrderId()
                + " -> " + order.getStatus());
    }
}
