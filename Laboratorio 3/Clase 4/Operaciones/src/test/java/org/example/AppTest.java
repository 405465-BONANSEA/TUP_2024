package org.example;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class AppTest {
    
    @Test
    public void testOperations() {
        String expected = "Suma:5\nResta:1\nMultiplicacion:6\nDivision:1\n";
        assertEquals(expected, App.Operations(3, 2));
    }
}