package Tateti;

abstract class Jugador {
    protected String simbolo;

    public Jugador(String simbolo) {
        this.simbolo = simbolo;
    }

    public abstract int[] jugar(Tablero tablero);
}
