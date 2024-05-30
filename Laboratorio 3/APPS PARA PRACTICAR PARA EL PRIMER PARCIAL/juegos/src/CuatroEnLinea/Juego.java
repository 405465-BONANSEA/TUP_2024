package CuatroEnLinea;

public class Juego {

    private static final int FILAS = 6;
    private static final int COLUMNAS = 7;
    private static final int CONECTA = 4;

    private String[][] tablero;
    private Jugador jugador1;
    private Jugador jugador2;

    public Juego() {
        tablero = new String[FILAS][COLUMNAS];
        for (int i = 0; i < FILAS; i++) {
            for (int j = 0; j < COLUMNAS; j++) {
                tablero[i][j] = " ";
            }
        }
        jugador1 = new Player1("X");
        jugador2 = new COM("O");
    }

    public void mostrarTablero() {
        for (int i = FILAS-1; i >= 0; i--) {
            System.out.print("|");
            for (int j = 0; j < COLUMNAS; j++) {
                System.out.print(tablero[i][j] + "|");
            }
            System.out.println();
        }
        System.out.println("---------------");
    }

    public boolean hayGanador(String ficha) {
        // Verificar filas
        for (int i = 0; i < FILAS; i++) {
            for (int j = 0; j <= COLUMNAS - CONECTA; j++) {
                boolean ganador = true;
                for (int k = 0; k < CONECTA; k++) {
                    if (!tablero[i][j+k].equals(ficha)) {
                        ganador = false;
                        break;
                    }
                }
                if (ganador) {
                    return true;
                }
            }
        }

        // Verificar columnas
        for (int i = 0; i <= FILAS - CONECTA; i++) {
            for (int j = 0; j < COLUMNAS; j++) {
                boolean ganador = true;
                for (int k = 0; k < CONECTA; k++) {
                    if (!tablero[i+k][j].equals(ficha)) {
                        ganador = false;
                        break;
                    }
                }
                if (ganador) {
                    return true;
                }
            }
        }

        // Verificar diagonales hacia arriba
        for (int i = 0; i <= FILAS - CONECTA; i++) {
            for (int j = 0; j <= COLUMNAS - CONECTA; j++) {
                boolean ganador = true;
                for (int k = 0; k < CONECTA; k++) {
                    if (!tablero[i+k][j+k].equals(ficha)) {
                        ganador = false;
                        break;
                    }
                }
                if (ganador) {
                    return true;
                }
            }
        }

        // Verificar diagonales hacia abajo
        for (int i = CONECTA-1; i < FILAS; i++) {
            for (int j = 0; j <= COLUMNAS - CONECTA; j++) {
                boolean ganador = true;
                for (int k = 0; k < CONECTA; k++) {
                    if (!tablero[i-k][j+k].equals(ficha)) {
                        ganador = false;
                        break;
                    }
                }
                if (ganador) {
                    return true;
                }
            }
        }

        return false;
    }

    public boolean tableroLleno() {
        for (int i = 0; i < FILAS; i++) {
            for (int j = 0; j < COLUMNAS; j++) {
                if (tablero[i][j].equals(" ")) {
                    return false;
                }
            }
        }
        return true;
    }

    public void jugar() {
        Jugador jugadorActual = jugador1;
        while (true) {
            mostrarTablero();
            int[] jugada = jugadorActual.jugar(tablero);
            int fila = jugada[0];
            int columna = jugada[1];
            if (fila >= 0 && fila < FILAS && columna >= 0 && columna < COLUMNAS && tablero[fila][columna].equals(" ")) {
                tablero[fila][columna] = jugadorActual.ficha;
                if (hayGanador(jugadorActual.ficha)) {
                    mostrarTablero();
                    System.out.println("¡" + jugadorActual.ficha + " ha ganado!");
                    break;
                } else if (tableroLleno()) {
                    mostrarTablero();
                    System.out.println("¡Empate!");
                    break;
                }
                jugadorActual = (jugadorActual == jugador1) ? jugador2 : jugador1;
            } else {
                System.out.println("Fila o columna inválida o llena, intenta de nuevo.");
            }
        }
    }
}
