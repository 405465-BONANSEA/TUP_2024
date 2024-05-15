package PiedraPapelTijera;

import java.util.Random;

public class COM extends Jugador{

    public String jugar() {
        Random random = new Random();
        int jugada = random.nextInt(3);
        if (jugada == 0) {
            return "piedra";
        } else if (jugada == 1) {
            return "papel";
        } else {
            return "tijera";
        }
    }
}
