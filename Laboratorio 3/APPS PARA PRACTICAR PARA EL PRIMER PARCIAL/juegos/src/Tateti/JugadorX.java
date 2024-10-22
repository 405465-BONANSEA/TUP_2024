package Tateti;

import java.util.Scanner;

public class JugadorX extends Jugador{

    public JugadorX() {
        super("X");
    }

    public int[] jugar(Tablero tablero) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Jugador X, ingrese la fila (1-3): ");
            int fila = scanner.nextInt() - 1;
            System.out.print("Jugador X, ingrese la columna (1-3): ");
            int columna = scanner.nextInt() - 1;
            if (tablero.estaVacio(fila, columna)) {
                return new int[] {fila, columna};
            } else {
                System.out.println("La casilla ya está ocupada, por favor ingrese otra jugada.");
            }
        }
    }
}

