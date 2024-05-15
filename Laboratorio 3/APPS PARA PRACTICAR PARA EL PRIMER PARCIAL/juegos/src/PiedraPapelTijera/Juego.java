package PiedraPapelTijera;

public class Juego {

    private Jugador jugador1;
    private Jugador jugador2;

    public Juego() {
        jugador1 = new Player1();
        jugador2 = new COM();
    }

    public void jugar() {
        String jugada1 = jugador1.jugar();
        String jugada2 = jugador2.jugar();
        System.out.println("Jugador 1: " + jugada1);
        System.out.println("Jugador 2: " + jugada2);
        if (jugada1.equals(jugada2)) {
            System.out.println("Empate!");
        } else if ((jugada1.equals("piedra") && jugada2.equals("tijera")) ||
                (jugada1.equals("papel") && jugada2.equals("piedra")) ||
                (jugada1.equals("tijera") && jugada2.equals("papel"))) {
            System.out.println("Jugador 1 gana!");
        } else {
            System.out.println("Jugador 2 gana!");
        }
    }
}
