package CuatroEnLinea;

import java.util.Random;

public class COM extends Jugador{

    private int FILAS;
    private int COLUMNAS;

    public COM(String ficha){
        super(ficha);
    }

    public COM(String ficha, int filas, int columnas) {
        super(ficha);
        this.FILAS = filas;
        this.COLUMNAS = columnas;
    }

    public int[] jugar(String[][] tablero) {
        Random rand = new Random();
        int fila, columna;
        do {
            fila = rand.nextInt(FILAS);
            columna = rand.nextInt(COLUMNAS);
        } while (!tablero[fila][columna].equals(" "));
        return new int[] {fila, columna};
    }
}
