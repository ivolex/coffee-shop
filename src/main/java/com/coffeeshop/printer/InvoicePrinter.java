package com.coffeeshop.printer;

import com.coffeeshop.model.Bucket;
import com.coffeeshop.model.extras.Extra;
import com.coffeeshop.model.offering.Offer;

public class InvoicePrinter {
    public void print(Bucket bucket) {
        System.out.println("#################################################################");
        System.out.println("#################################################################");
        System.out.println("Offerings:");
//        todo:print offers
        for (Offer offer : bucket.getOffers().keySet()) {
            System.out.println(offer.getName() + " - ");
        }
        System.out.println("#################################################################");
//        todo:print extras
        for (Extra extra : bucket.getExtras().keySet()) {

        }
        System.out.println("#################################################################");
        System.out.println("#################################################################");
    }
}
