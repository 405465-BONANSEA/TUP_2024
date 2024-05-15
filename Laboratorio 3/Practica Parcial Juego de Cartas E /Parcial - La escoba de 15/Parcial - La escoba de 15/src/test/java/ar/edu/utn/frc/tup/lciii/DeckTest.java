package ar.edu.utn.frc.tup.lciii;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DeckTest {

    private Deck deck = new Deck();

    @BeforeEach
    void setUp() {
        deck=new Deck();
    }
    @Test
    void createDeckTest() {
        // TODO: Crear un test que valide que el mazo se crea con 40 cartas,
        //  que no se incluyen los 8 y 9.
        //  Validar que todas las cartas de un mazo de 40 cartas estén presentes.
        deck.getCards().forEach(card -> {
            assertEquals(40, deck.getCards().size());
            assertNotEquals(8, card.getNumber());
            assertNotEquals(9, card.getNumber());
        });

    }

    @Test
    void takeCardTest() {
        // TODO: Crear un test que valide que al tomar una carta del mazo,
        //  la cantidad de cartas en el mazo disminuye en 1 y que la carta tomada
        //  es la que se esperaba; es decir la que está al tope de la pila.

            int initialSize = deck.getCards().size();
            Card expectedCard = deck.getCards().peek();
            Card actualCard = deck.takeCard();
            assertEquals(initialSize - 1, deck.getCards().size());
            assertEquals(expectedCard, actualCard);
        }



    @Test
    void isEmptyTest() {
        // TODO: Crear un test que valide que el mazo está vacío cuando no tiene cartas
        //  y que no está vacío cuando tiene al menos una carta.
        int initialSize = deck.getCards().size();
        for (int i = 0; i < initialSize; i++) {
            assertFalse(deck.isEmpty());
            deck.takeCard();
        }
    }

    @Test
    void shuffleDeckTest() {
        // TODO: Crear un test que valide que al mezclar el mazo, las cartas no están en el mismo orden
        //  que al crear el mazo.
        Deck shuffledDeck = new Deck();
        shuffledDeck.shuffleDeck();
        assertNotEquals(deck.getCards(), shuffledDeck.getCards());
    }
}