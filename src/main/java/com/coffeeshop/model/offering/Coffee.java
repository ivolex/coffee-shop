package com.coffeeshop.model.offering;

import com.coffeeshop.model.extras.Extra;

import java.util.ArrayList;
import java.util.List;

public class Coffee extends Offer{
    private static final String COFFEE = "Coffee";
    private CoffeeSize size;

    private List<Extra> extras;

    public Coffee(){
        this.setName(COFFEE);
        this.setType(ProductType.DRINK);
    }

    public void addExtra(Extra extra){
        getExtras().add(extra);
    }

    public List<Extra> getExtras(){
        if (extras == null){
            extras = new ArrayList<>(5);
        }
        return extras;
    }

    public CoffeeSize getSize() {
        return size;
    }

    public void setSize(CoffeeSize size) {
        this.size = size;
    }
}
