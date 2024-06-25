package com.coffeeshop.model.offering;

public class Juice extends Offer{
    private static final String JUICE = "Juice";

    public Juice(){
        this.setName(JUICE);
        this.setType(ProductType.DRINK);
    }
}
