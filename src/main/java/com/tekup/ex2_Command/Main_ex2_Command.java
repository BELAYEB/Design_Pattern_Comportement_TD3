package com.tekup.ex2_Command;

public class Main_ex2_Command {
    public static void main(String[] args) {
        ShoppingCard shoppingCard = new ShoppingCard();

        Command addProduct1 = new AddProductCommand(shoppingCard, "Laptop");
        Command addProduct2 = new AddProductCommand(shoppingCard, "Smartphone");
        Command removeProduct = new RemoveProducCommand(shoppingCard, "Laptop");
        Command validateOrder = new ValidateOrderCommand(shoppingCard);

        addProduct1.execute();
        addProduct2.execute();
        removeProduct.execute();
        validateOrder.execute();
    }
}
