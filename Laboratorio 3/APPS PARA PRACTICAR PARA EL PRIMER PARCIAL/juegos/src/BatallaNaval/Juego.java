package BatallaNaval;

import java.util.Scanner;

public class Juego {

    private static final int TAMANIO_TABLERO = 10;
    private static final int NUMERO_BARCOS = 5;
    private static final int[] TAMANIO_BARCOS = {5, 4, 3, 3, 2};

    private String[][] tablero;
    private int barcosRestantes;
    private Jugador jugador1;
    private Jugador jugador2;

    public Juego() {
        tablero = new String[TAMANIO_TABLERO][TAMANIO_TABLERO];
        barcosRestantes = NUMERO_BARCOS;
        inicializarTablero();
        jugador1 = new Player1();
        jugador2 = new COM();
        ((Player1) jugador1).colocarBarcos();
    }

    private void inicializarTablero() {
        for (int i = 0; i < TAMANIO_TABLERO; i++) {
            for (int j = 0; j < TAMANIO_TABLERO; j++) {
                tablero[i][j] = " ";
            }
        }
        colocarBarcos();
    }

    private void colocarBarcos() {
        for (int i = 0; i < NUMERO_BARCOS; i++) {
            int tamanioBarco = TAMANIO_BARCOS[i];
            boolean barcoColocado = false;
            while (!barcoColocado) {
                int filaInicial = (int) (Math.random() * TAMANIO_TABLERO);
                int columnaInicial = (int) (Math.random() * TAMANIO_TABLERO);
                boolean horizontal = Math.random() < 0.5;
                if (horizontal && columnaInicial + tamanioBarco <= TAMANIO_TABLERO) {
                    boolean espacioLibre = true;
                    for (int j = 0; j < tamanioBarco; j++) {
                        if (!tablero[filaInicial][columnaInicial+j].equals(" ")) {
                            espacioLibre = false;
                            break;
                        }
                    }
                    if (espacioLibre) {
                        for (int j = 0; j < tamanioBarco; j++) {
                            tablero[filaInicial][columnaInicial+j] = "B";
                        }
                        barcoColocado = true;
                    }
                } else if (!horizontal && filaInicial + tamanioBarco <= TAMANIO_TABLERO) {
                    boolean espacioLibre = true;
                    for (int j = 0; j < tamanioBarco; j++) {
                        if (!tablero[filaInicial+j][columnaInicial].equals(" ")) {
                            espacioLibre = false;
                            break;
                        }
                    }
                    if (espacioLibre) {
                        for (int j = 0; j < tamanioBarco; j++) {
                            tablero[filaInicial+j][columnaInicial] = "B";
                        }
                        barcoColocado = true;
                    }
                }
            }
        }
    }

    public void mostrarTablero() {
        System.out.print("  ");
        for (int i = 0; i < TAMANIO_TABLERO; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i = 0; i < TAMANIO_TABLERO; i++) {
            System.out.print(i + " ");
            for (int j = 0; j < TAMANIO_TABLERO; j++) {
                System.out.print(tablero[i][j] + " ");
            }
            System.out.println();
        }
    }

    public boolean atacar(Jugador jugador) {
        int[] posicion = jugador.atacar();
        int fila = posicion[0];
        int columna = posicion[1];
        if (tablero[fila][columna].equals("B")) {
            tablero[fila][columna] = "X";
            barcosRestantes--;
            System.out.println("¡Le diste a un barco!");
            if (barcosRestantes == 0) {
                System.out.println("¡Ganaste la partida!");
                return true;
            }
        } else if (tablero[fila][columna].equals(" ")) {
            tablero[fila][columna] = "-";
            System.out.println("Agua...");
        } else {
            System.out.println("Ya atacaste esa posición, intenta con otra.");
        }
        return false;
    }

    public void jugar() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            mostrarTablero();
            System.out.println("Turno del jugador 1 (humano):");
            if (atacar(jugador1)) {
                break;
            }
            mostrarTablero();
            System.out.println("Turno del jugador 2 (computadora):");
            if (atacar(jugador2)) {
                break;
            }
        }
    }
}
