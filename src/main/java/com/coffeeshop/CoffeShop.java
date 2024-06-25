package com.coffeeshop;

import com.coffeeshop.model.offering.Offer;
import com.coffeeshop.parser.InputParser;

import java.util.List;
import java.util.Scanner;

public class CoffeShop {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        printStart();

        InputParser parser = new InputParser();
        List<Offer> offers = parser.toOffers(scanner.nextLine());
    }

    private static void printStart() {
        String formatMenu = "Offering:\n%s\n%s\n%s\nExtras:\n%s\n%s\n%s";
        System.out.println("Welcome to Coffee Shop! Please choose your order.");
        System.out.printf((formatMenu) + "%n",
                "Coffee small/medium/large - 2.55/3.05/3.55 CHF",
                "Bacon Roll - 4.53 CHF",
                "Freshly squeezed orange juice (0.25l) - 3.95 CHF",
                "Extra milk - 0.32 CHF",
                "Foamed milk - 0.51 CHF",
                "Special roast coffee - 0.95 CHF");
    }
}
