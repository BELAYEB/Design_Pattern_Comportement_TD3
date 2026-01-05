package com.tekup.ex3_Observer;

public class Main_ex3_Observer {
    public static void main(String[] args) {
        // Créer une commande
        Order order = new Order("CMD-001");

        // Ajouter les observateurs
        order.addObserver(new CustomerObserver("Mahmoud"));
        order.addObserver(new ShippingTeamObserver());
        order.addObserver(new SupportTeamObserver());

        // Changer les états
        order.setStatus("CONFIRMÉE");
        order.setStatus("EXPÉDIÉE");
        order.setStatus("LIVRÉE");
    }
}
