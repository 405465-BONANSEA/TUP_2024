package BatallaNaval;

import java.util.Random;

public class COM extends Jugador{

    public int[] atacar() {
        Random random = new Random();
        int fila = random.nextInt(10);
        int columna = random.nextInt(10);
        return new int[] {fila, columna};
    }
}
