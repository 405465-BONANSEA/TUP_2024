package PiedraPapelTijera;

import java.util.Scanner;

public class Player1 extends Jugador {
    public String jugar() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Ingrese su jugada (piedra, papel o tijera): ");
            String jugada = scanner.nextLine().toLowerCase();
            if (jugada.equals("piedra") || jugada.equals("papel") || jugada.equals("tijera")) {
                return jugada;
            } else {
                System.out.println("Jugada inválida, por favor ingrese piedra, papel o tijera.");
            }
        }
    }
}
