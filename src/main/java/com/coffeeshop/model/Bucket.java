package com.coffeeshop.model;

import com.coffeeshop.model.extras.Extra;
import com.coffeeshop.model.offering.Offer;

import java.util.HashMap;
import java.util.Map;

public class Bucket {
    Map<Offer, Short> offers;
    Map<Extra, Short> extras;

    public void addNew(Offer offer){

    }
    public void addNew(Extra extra){

    }

    public Map<Offer, Short> getOffers(){
        if (offers == null){
            offers = new HashMap<>();
        }
        return offers;
    }

    public Map<Extra, Short> getExtras(){
        if (extras == null){
            extras = new HashMap<>();
        }
        return extras;
    }
}
