package BlackJack;

public class Carta {
    private int valor;
    private Palo palo;

    public int getNumero() {
        return valor;
    }

    public Palo getPalo() {
        return palo;
    }

    public Carta(int valor, Palo palo) {
        this.valor = valor;
        this.palo = palo;
    }

    @Override
    public String toString(){
        return valor + " de " +palo.toString();
    }
}
