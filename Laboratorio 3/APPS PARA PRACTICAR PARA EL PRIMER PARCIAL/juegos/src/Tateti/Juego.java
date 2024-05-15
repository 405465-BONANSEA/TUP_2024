package Tateti;

public class Juego {
    private Tablero tablero;
    private Jugador jugadorX;
    private Jugador jugadorO;

    public Juego() {
        tablero = new Tablero();
        jugadorX = new JugadorX();
        jugadorO = new JugadorO();
    }

    public void jugar() {
        Jugador jugadorActual = jugadorX;
        while (true) {
            tablero.mostrar();
            int[] jugada = jugadorActual.jugar(tablero);
            tablero.colocar(jugada[0], jugada[1], jugadorActual.simbolo);
            if (tablero.hayGanador(jugadorActual.simbolo)) {
                tablero.mostrar();
                System.out.println("¡" + jugadorActual.simbolo + " ha ganado!");
                break;
            } else if (tablero.estaLleno()) {
                tablero.mostrar();
                System.out.println("¡Empate!");
                break;
            }
            jugadorActual = (jugadorActual == jugadorX) ? jugadorO : jugadorX;
        }
    }
}
