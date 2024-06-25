package com.coffeeshop.parser;

import com.coffeeshop.model.extras.Extra;
import com.coffeeshop.model.extras.ExtraValues;
import com.coffeeshop.model.offering.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InputParser {
    private static final String COFFEE = "coffee";
    private static final String WITH = "with";
    private static final String ROLL = "roll";
    private static final String JUICE = "juice";
    private static final String SMALL = "small";
    private static final String MEDIUM = "medium";
    private static final String EXTRA = "extra";
    private static final String FOAMED = "foamed";
    protected static final String EMPTY_ORDER_MESSAGE = "Order cannot be empty!";
    protected static final String CANNOT_PARSE_ORDER_MESSAGE = "Cannot parse order!";

    public List<Offer> toOffers(String input) {
        if (input == null || input.isEmpty()) {
            throw new InputParserException(EMPTY_ORDER_MESSAGE);
        }

        return offers(splitOrder(input));
    }

    protected List<String> splitOrder(final String input) {
        String[] elements = input.split(",");
        if (elements.length < 1) {
            throw new InputParserException(EMPTY_ORDER_MESSAGE);
        }
        return Arrays.stream(elements).toList();
    }

    private List<Offer> offers(List<String> elements) {
        List<Offer> offers = new ArrayList<>();
        for (String orderStr : elements) {
            if (orderStr.contains(COFFEE)) {
                Coffee coffee = new Coffee();
                applySize(coffee, orderStr);
                if (orderStr.contains(WITH)) {
                    applyExtras(coffee, orderStr);
                }
                offers.add(coffee);
            } else if (orderStr.contains(ROLL)) {
                offers.add(new Roll());
            } else if (orderStr.contains(JUICE)) {
                offers.add(new Juice());
            }
        }

        if (offers.isEmpty()) {
            throw new InputParserException(CANNOT_PARSE_ORDER_MESSAGE);
        }
        return offers;
    }

    private void applySize(Coffee coffee, String orderStr) {
        if (orderStr.contains(SMALL)) {
            coffee.setSize(CoffeeSize.SMALL);
        } else if (orderStr.contains(MEDIUM)) {
            coffee.setSize(CoffeeSize.MEDIUM);
        } else {
            coffee.setSize(CoffeeSize.LARGE);
        }
    }

    private void applyExtras(Coffee coffee, String offerStr) {
        String[] split = offerStr.split(WITH);
        for (int i = 1; i < split.length; i++) {
            if (split[i].contains(EXTRA)) {
                Extra extra = new Extra(ExtraValues.EXTRA_MILK.id(), ExtraValues.EXTRA_MILK.prise());
                coffee.addExtra(extra);
            } else if (split[i].contains(FOAMED)) {
                Extra extra = new Extra(ExtraValues.FOAMED_MILK.id(), ExtraValues.FOAMED_MILK.prise());
                coffee.addExtra(extra);
            } else {
                Extra extra = new Extra(ExtraValues.SPECIAL_ROASTED.id(), ExtraValues.SPECIAL_ROASTED.prise());
                coffee.addExtra(extra);
            }
        }
    }
}
