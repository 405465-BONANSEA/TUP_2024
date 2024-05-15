package BatallaNaval;

import java.util.Scanner;


public class Player1 extends Jugador {

    private static final int TAMANIO_TABLERO = 10;
    private static final int NUMERO_BARCOS = 5;
    private static final int[] TAMANIO_BARCOS = {5, 4, 3, 3, 2};
    private final String[][] tablero;


    public Player1() {
        tablero = new String[TAMANIO_TABLERO][TAMANIO_TABLERO];
        for (int i = 0; i < TAMANIO_TABLERO; i++) {
            for (int j = 0; j < TAMANIO_TABLERO; j++) {
                tablero[i][j] = " ";
            }
        }
    }

    public void colocarBarcos() {
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < NUMERO_BARCOS; i++) {
            int tamanioBarco = TAMANIO_BARCOS[i];
            System.out.println("Colocando barco de tamaño " + tamanioBarco);
            boolean barcoColocado = false;
            while (!barcoColocado) {
                System.out.print("Ingrese la fila inicial (0-9): ");
                int filaInicial = scanner.nextInt();
                System.out.print("Ingrese la columna inicial (0-9): ");
                int columnaInicial = scanner.nextInt();
                System.out.print("Ingrese la orientación (h para horizontal, v para vertical): ");
                String orientacion = scanner.next();
                if (orientacion.equals("h") && columnaInicial + tamanioBarco <= TAMANIO_TABLERO) {
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
                    } else {
                        System.out.println("Espacio ocupado, intenta de nuevo.");
                    }
                } else if (orientacion.equals("v") && filaInicial + tamanioBarco <= TAMANIO_TABLERO) {
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
                    } else {
                        System.out.println("Espacio ocupado, intenta de nuevo.");
                    }
                } else {
                    System.out.println("Posición inválida, intenta de nuevo.");
                }
            }
            mostrarTablero();
        }
    }

    public int[] atacar() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese la fila a atacar (0-9): ");
        int fila = scanner.nextInt();
        System.out.print("Ingrese la columna a atacar (0-9): ");
        int columna = scanner.nextInt();
        return new int[] {fila, columna};
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

}

