package CuatroEnLinea;

import java.util.Scanner;

public class Player1 extends Jugador{

    public Player1(String ficha) {
        super(ficha);
    }

    public int[] jugar(String[][] tablero) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Ingrese la fila donde desea colocar su ficha (0-5): ");
            int fila = scanner.nextInt();
            System.out.print("Ingrese la columna donde desea colocar su ficha (0-6): ");
            int columna = scanner.nextInt();
            if (fila >= 0 && fila <= 5 && columna >= 0 && columna <= 6 && tablero[fila][columna].equals(" ")) {
                return new int[] {fila, columna};
            } else {
                System.out.println("Fila o columna inválida o llena, intenta de nuevo.");
            }
        }
    }
}
