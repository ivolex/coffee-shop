package com.coffeeshop;

import com.coffeeshop.model.Bucket;
import com.coffeeshop.model.offering.Offer;
import com.coffeeshop.model.offering.ProductType;

import java.util.List;

public class BucketService {
    private Bucket bucket;

    public Bucket formBucket(List<Offer> ordered){
        for (Offer offer : ordered){
            if (offer.getType().equals(ProductType.DRINK)){

            }
        }
        throw new RuntimeException("Not implemented yet!");
    }
}
