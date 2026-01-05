package com.tekup.ex4_ChainOfResponsibility;

public class Request {
    private String type;
    private String description;

    public Request(String type, String description) {
        this.type = type;
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public String getDescription() {
        return description;
    }
}
