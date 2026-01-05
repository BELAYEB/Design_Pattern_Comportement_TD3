package com.tekup.ex4_ChainOfResponsibility;

public class Main_ex4_ChainOfResponsibility {
    public static void main(String[] args) {
        // Créer la chaîne
        Handler tech = new Technician();
        Handler sup = new Supervisor();
        Handler mgr = new Manager();

        tech.setNextHandler(sup);
        sup.setNextHandler(mgr);

        // Tester
        tech.handleRequest(new Request("technical", "Problème réseau"));
        tech.handleRequest(new Request("managerial", "Demande congé"));
        tech.handleRequest(new Request("supervisory", "Nouveau projet"));
        tech.handleRequest(new Request("other", "Demande inconnue"));
    }
}
