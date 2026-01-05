package com.tekup.ex4_ChainOfResponsibility;

public class Manager extends Handler{
    @Override
    public void handleRequest(Request request) {
        if (request.getType().equalsIgnoreCase("managerial")) {
            System.out.println("Manager is handling the request: " + request.getDescription());
        } else if (nextHandler != null) {
            nextHandler.handleRequest(request);
        } else {
            System.out.println("No handler available for the request: " + request.getDescription());
        }
    }
}
