package com.tekup.ex2_Command;

public class RemoveProducCommand implements  Command {
    private ShoppingCard shoppingCard;
    private String productName;

    public RemoveProducCommand(ShoppingCard shoppingCard, String product){
        this.shoppingCard = shoppingCard;
        this.productName = product;
    }
    @Override
    public void execute() {
        shoppingCard.removeProduct(productName);
    }
}
