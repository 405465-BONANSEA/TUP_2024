package CuatroEnLinea;

abstract class Jugador {
    protected String ficha;

    public Jugador(String ficha) {
        this.ficha = ficha;
    }

    public abstract int[] jugar(String[][] tablero);
}