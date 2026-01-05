package com.tekup.ex2_Command;

public class AddProductCommand implements Command {
    private ShoppingCard shoppingCard;
    private String productName;

    public AddProductCommand(ShoppingCard shoppingCard, String product){
        this.shoppingCard = shoppingCard;
        this.productName = product;
    }
    @Override
    public void execute() {
        shoppingCard.addProduct(productName);
    }
}
