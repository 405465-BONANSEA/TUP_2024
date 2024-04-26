package org.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class AppTest {

    @Test
    public void testCalculatePriceWithVat() {
        double price = 100;
        double expectedValue = 121;
        double result = App.getPrice(price);
        assertEquals(expectedValue, result);
    }

    @Test
    public void testCalculatePriceWithVat_ZeroPrice() {
        double price = 0;
        double expectedValue = 0;
        double result = App.getPrice(price);
        assertEquals(expectedValue, result);
    }

    @Test
    public void testCalculatePriceWithVat_NegativePrice() {
        double price = -100;
        double expectedValue = -121;
        double result = App.getPrice(price);
        assertEquals(expectedValue, result);
    }
}