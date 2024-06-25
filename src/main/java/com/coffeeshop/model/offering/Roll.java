package com.coffeeshop.model.offering;

public class Roll extends Offer {
    private static final String ROLL_NAME = "Bacon Roll";

    public Roll() {
        this.setType(ProductType.FOOD);
        this.setName(ROLL_NAME);
    }
}
