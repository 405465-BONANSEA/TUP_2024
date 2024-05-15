package ar.edu.utn.frc.tup.lciii.round;

import ar.edu.utn.frc.tup.lciii.Card;
import ar.edu.utn.frc.tup.lciii.LetterByLetterPrinter;
import ar.edu.utn.frc.tup.lciii.User;

import java.util.*;

/**
 * Clase que representa al jugador en la instancia de una ronda puntual.
 * Un RoundPlayer NO es lo mismo que un jugador. Un RoundPlayer es un jugador en el contexto de una ronda.
 */
public abstract class RoundPlayer {

    /**
     * Scanner para capturar las entradas del usuario
     */
    protected Scanner scanner = new Scanner(System.in);

    private User player;
    private List<Card> handCards;
    private List<Card> personalDeck;
    private Integer escobasQuantity;
    private Integer roundPoints;

    public Scanner getScanner() {
        return scanner;
    }

    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }

    public User getPlayer() {
        return player;
    }

    public void setPlayer(User player) {
        this.player = player;
    }

    public List<Card> getHandCards() {
        return handCards;
    }

    public void setHandCards(List<Card> handCards) {
        this.handCards = handCards;
    }

    public List<Card> getPersonalDeck() {
        return personalDeck;
    }

    public void setPersonalDeck(List<Card> personalDeck) {
        this.personalDeck = personalDeck;
    }

    public Integer getEscobasQuantity() {
        return escobasQuantity;
    }

    public void setEscobasQuantity(Integer escobasQuantity) {
        this.escobasQuantity = escobasQuantity;
    }

    public Integer getRoundPoints() {
        return roundPoints;
    }

    public void setRoundPoints(Integer roundPoints) {
        this.roundPoints = roundPoints;
    }

    public RoundPlayer(User player) {
        this.player = player;
        this.handCards = new ArrayList<>();
        this.personalDeck = new ArrayList<>();
        this.escobasQuantity = 0;
        this.roundPoints = 0;
    }

    public RoundPlayer() {
    }

    public abstract void playTurn(List<Card> tableCards);

    /**
     * Método para barrer cartas en la mesa.
     *
     * @param tableCards cartas en la mesa.
     * @param selectedCards cartas seleccionadas a barrer. Incluye la carta que el jugador jugó.
     */
    protected void takingCardsFromTable(List<Card> tableCards, List<Card> selectedCards) {
        LetterByLetterPrinter.println(player.getName() + " take cards. The cards were added to the personal deck.");
        personalDeck.addAll(selectedCards);
        tableCards.removeIf(selectedCards::contains);
        handCards.removeIf(selectedCards::contains);
        if(tableCards.isEmpty()) {
            escobasQuantity++;
            LetterByLetterPrinter.println(player.getName() + " made escoba!!!");
            
        }
    }

    /**
     * Método para imprimir las cartas en la mesa.
     * Cada carta se imprime con un índice.
     *
     * @param tableCards cartas en la mesa.
     */
    protected void showCardsOnTheTable(List<Card> tableCards) {
        LetterByLetterPrinter.println("This are the cards in the table:");
        for(int i = 0; i < tableCards.size(); i++) {
            LetterByLetterPrinter.println(i + " - " + tableCards.get(i).toString());
        }
    }


    /**
     * Método que obtiene todos los subconjuntos posibles de un conjunto de cartas.
     *
     * @param conjunto conjunto de cartas.
     * @return lista de subconjuntos.
     */
    protected List<List<Card>> obtenerSubconjuntos(List<Card> conjunto) {
        List<List<Card>> subconjuntos = new ArrayList<>();
        obtenerSubconjuntos(conjunto, 0, new ArrayList<>(), subconjuntos);
        return subconjuntos;
    }

    /**
     * Método recursivo que obtiene todos los subconjuntos posibles de un conjunto de cartas.
     *
     * @param conjunto conjunto de cartas.
     * @param indice índice del conjunto.
     * @param subconjuntoParcial subconjunto parcial.
     * @param subconjuntos lista de subconjuntos.
     */
    private void obtenerSubconjuntos(List<Card> conjunto, int indice, List<Card> subconjuntoParcial, List<List<Card>> subconjuntos) {
        subconjuntos.add(new ArrayList<>(subconjuntoParcial));
        for (int i = indice; i < conjunto.size(); i++) {
            subconjuntoParcial.add(conjunto.get(i));
            obtenerSubconjuntos(conjunto, i + 1, subconjuntoParcial, subconjuntos);
            subconjuntoParcial.remove(subconjuntoParcial.size() - 1);
        }
    }
}
