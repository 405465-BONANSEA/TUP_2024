package ar.edu.utn.frc.tup.lciii;

import java.util.Objects;

/**
 * Esta clase representa una carta del Deck (mazo)
 * Las cartas están compuestas por un CardSuit (palo), un número (número de la carta)
 * y un valor (valor de la carta en el juego de la escoba). Por ejemplo, el 12 de Bastos
 * tendrá el cardSuit = BASTOS, número = 12, value = 10
 */
public class Card {

    /**
     * Palo de la carta
     */
    private CardSuit cardSuit;

    /**
     * Número de la carta
     */
    private Integer number;

    /**
     * Valor de la carta en el juego de la escoba
     */
    private Integer value;

    public CardSuit getCardSuit() {
        return cardSuit;
    }

    public void setCardSuit(CardSuit cardSuit) {
        this.cardSuit = cardSuit;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    /**
     * Constructor de una carta.
     *
     * @param cardSuit asignado a la carta
     * @param number número asignado a la carta
     * @param value valor asignado a la carta
     */
    public Card(CardSuit cardSuit, Integer number, Integer value) {
        this.cardSuit = cardSuit;
        this.number = number;
        this.value = value;
    }

    /**
     * Método para obtener la representación tipo String de una carta
     * @return String de la carta
     */
    @Override
    public String toString() {
        return number + " de " + cardSuit.toString();
    }

    /**
     * Método que compara dos objetos de tipo Card
     * @param obj objeto a comparar
     * @return true si los objetos son iguales, es decir si tienen el mismo palo, número y valor, false en caso contrario
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Card other = (Card) obj;
        if (this.cardSuit != other.cardSuit) {
            return false;
        }
        if (!Objects.equals(this.number, other.number)) {
            return false;
        }
        return Objects.equals(this.value, other.value);
    }
}
