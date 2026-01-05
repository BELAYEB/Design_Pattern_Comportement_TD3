package com.tekup.ex3_Observer;

public class SupportTeamObserver implements Observer{
    @Override
    public void update(Order order) {
        System.out.println("[SUPPORT] Commande " + order.getOrderId()
                + " -> " + order.getStatus());
    }
}
