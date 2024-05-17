package ar.edu.utn.frc.tup.lciii;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CardTest {

    @Test
    void testToString() {
        Card card = new Card(CardSuit.ESPADAS, 12, 10);
        assertEquals("12 de ESPADAS", card.toString());
    }

    @Test
    void testEquals() {
        Card card1 = new Card(CardSuit.ESPADAS, 12, 10);
        Card card2 = new Card(CardSuit.ESPADAS, 12, 10);
        assertEquals(card1, card2);
    }
}