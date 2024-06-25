package com.coffeeshop.model.extras;

public enum ExtraValues {
    FOAMED_MILK("Foamed milk", 0.51),
    EXTRA_MILK("Extra milk", 0.32),
    SPECIAL_ROASTED("Special roast", 0.95);

    private final String id;
    private final double price;

    ExtraValues(String id, double price) {
        this.id = id;
        this.price = price;
    }
    public String id(){
        return id;
    }
    public double prise(){
        return price;
    }
}
