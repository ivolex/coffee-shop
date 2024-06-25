package com.coffeeshop.parser;

import com.coffeeshop.model.extras.Extra;
import com.coffeeshop.model.offering.Coffee;
import com.coffeeshop.model.offering.Juice;
import org.junit.jupiter.api.Test;

import java.util.List;

import static com.coffeeshop.parser.InputParser.CANNOT_PARSE_ORDER_MESSAGE;
import static com.coffeeshop.parser.InputParser.EMPTY_ORDER_MESSAGE;
import static org.junit.jupiter.api.Assertions.*;

class InputParserTest {

    private final String INPUT_STR = "large coffee with extra milk, small coffee with special roast, bacon roll, orange juice";

    @Test
    void shouldSplitInputLine(){
        InputParser parser = new InputParser();

        int expectedSize = 4;

        assertEquals(expectedSize, parser.splitOrder(INPUT_STR).size());
    }

    @Test
    void shouldParseToOffers(){
        InputParser parser = new InputParser();

        int expectedSize = 4;

        assertEquals(expectedSize, parser.toOffers(INPUT_STR).size());
        assertEquals(Coffee.class,
                parser.toOffers(INPUT_STR).get(0).getClass());
        assertEquals(Juice.class,
                parser.toOffers(INPUT_STR).get(3).getClass());
    }

    @Test
    void shouldParseOneOfferingWithExtras(){
        InputParser parser = new InputParser();
        String input = "large coffee with extra milk with special roast";

        int expectedCoffeeNumberInOrder = 1;
        int expectedExtrasNumber = 2;

        assertEquals(expectedCoffeeNumberInOrder, parser.splitOrder(input).size());

        Coffee coffee = (Coffee) parser.toOffers(input).get(0);
        assertEquals(expectedExtrasNumber, coffee.getExtras().size());

        List<Extra> extras = coffee.getExtras();

        assertEquals("Extra milk", extras.get(0).getName());
        assertEquals("Special roast", extras.get(1).getName());
    }

    @Test
    void shouldThrowInputParserExceptionOnEmptyInput(){
        InputParser parser = new InputParser();

        Exception exception = assertThrows(InputParserException.class, () -> parser.toOffers(""));

        assertEquals(EMPTY_ORDER_MESSAGE, exception.getMessage());
    }

    @Test
    void shouldThrowInputParserExceptionOnUnparsableInput(){
        InputParser parser = new InputParser();

        String unparsableInput = "some, random, values, separated by coma";

        Exception exception = assertThrows(InputParserException.class, () -> parser.toOffers(unparsableInput));

        assertEquals(CANNOT_PARSE_ORDER_MESSAGE, exception.getMessage());
    }

}