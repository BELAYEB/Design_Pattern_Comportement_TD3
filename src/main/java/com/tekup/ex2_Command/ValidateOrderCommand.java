package com.tekup.ex2_Command;

public class ValidateOrderCommand implements Command {
    private ShoppingCard shoppingCard;

    public ValidateOrderCommand(ShoppingCard shoppingCard){
        this.shoppingCard = shoppingCard;
    }
    @Override
    public void execute() {
        shoppingCard.validateOrder();
    }
}
