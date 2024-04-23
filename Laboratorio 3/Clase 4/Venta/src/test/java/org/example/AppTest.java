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
}


