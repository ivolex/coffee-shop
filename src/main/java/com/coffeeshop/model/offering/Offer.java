package com.coffeeshop.model.offering;

public abstract class Offer {
    private String name;
    private ProductType type;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ProductType getType() {
        return type;
    }

    public void setType(ProductType type) {
        this.type = type;
    }
}
