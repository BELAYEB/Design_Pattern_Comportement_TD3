package com.tekup.ex2_Command;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCard {
    private List<String> products = new ArrayList<String>();

    public void addProduct(String product){
        products.add(product);
        System.out.println("Added product " + product);
    }
    public void removeProduct(String product) {
        products.remove(product);
        System.out.println("Removed product " + product);
    }
    public void validateOrder() {
        System.out.println("Validating order");
    }
}
