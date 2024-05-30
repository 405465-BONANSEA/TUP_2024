package TatetiSimulacro;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Juego2 {

    private List<Jugador> jugadores;
    private int turno;
    int[][] tablero;
    private int puntajeJugador1;
    private int puntajeJugador2;

    public Juego2(String nombreJugador1, String nombreJugador2) {
        jugadores = new ArrayList<>();
        jugadores.add(new Jugador(nombreJugador1, 1));
        jugadores.add(new Jugador(nombreJugador2, 2));
        turno = 0;
        tablero = new int[3][3];
        puntajeJugador1 = 0;
        puntajeJugador2 = 0;
    }

    public void jugar() {
        Scanner scanner = new Scanner(System.in);
        boolean jugarOtraPartida = true;
        while (jugarOtraPartida) {
            System.out.println("¡Bienvenidos al juego del TA TE TI!");
            System.out.println("Jugador 1: " + jugadores.get(0).getNombre());
            System.out.println("Jugador 2: " + jugadores.get(1).getNombre());
            System.out.println("El jugador que inicia la partida es: " + jugadores.get(turno).getNombre());

            boolean juegoTerminado = false;
            while (!juegoTerminado) {
                mostrarTablero();
                int fila, columna;
                do {
                    System.out.print("Jugador " + jugadores.get(turno).getNombre() + ", ingrese la fila (1-3): ");
                    fila = scanner.nextInt() - 1;
                    System.out.print("Jugador " + jugadores.get(turno).getNombre() + ", ingrese la columna (1-3): ");
                    columna = scanner.nextInt() - 1;
                } while (!movimientoValido(fila, columna));

                tablero[fila][columna] = jugadores.get(turno).getNumero();
                if (hayGanador()) {
                    mostrarTablero();
                    System.out.println("¡Felicidades, " + jugadores.get(turno).getNombre() + ", has ganado la partida!");
                    actualizarPuntaje(jugadores.get(turno));
                    juegoTerminado = true;
                } else if (tableroLleno()) {
                    mostrarTablero();
                    System.out.println("¡El juego ha terminado en empate!");
                    actualizarPuntaje(null);
                    juegoTerminado = true;
                } else {
                    turno = (turno + 1) % 2;
                }
            }

            System.out.println("Puntaje actual:");
            System.out.println(jugadores.get(0).getNombre() + ": " + puntajeJugador1);
            System.out.println(jugadores.get(1).getNombre() + ": " + puntajeJugador2);

            System.out.print("¿Quieren jugar otra partida? (s/n): ");
            String respuesta = scanner.next();
            if (respuesta.equalsIgnoreCase("n")) {
                jugarOtraPartida = false;
            } else {
                turno = (turno + 1) % 2;
                tablero = new int[3][3];
            }
        }

        System.out.println("Puntaje final:");
        System.out.println(jugadores.get(0).getNombre() + ": " + puntajeJugador1);
        System.out.println(jugadores.get(1).getNombre() + ": " + puntajeJugador2);
        if (puntajeJugador1 > puntajeJugador2) {
            System.out.println("¡Felicidades, " + jugadores.get(0).getNombre() + ", has ganado el juego!");
        } else if (puntajeJugador2 > puntajeJugador1) {
            System.out.println("¡Felicidades, " + jugadores.get(1).getNombre() + ", has ganado el juego!");
        } else {
            System.out.println("¡El juego ha terminado en empate!");
        }
    }

    private void mostrarTablero() {
        System.out.println("  1 2 3");
        for (int i = 0; i < 3; i++) {
            System.out.print((i+1) + " ");
            for (int j = 0; j < 3; j++) {
                if (tablero[i][j] == 0) {
                    System.out.print("- ");
                } else if (tablero[i][j] == 1) {
                    System.out.print("X ");
                } else {
                    System.out.print("O ");
                }
            }
            System.out.println();
        }
    }

    boolean movimientoValido(int fila, int columna) {
        if (fila < 0 || fila > 2 || columna < 0 || columna > 2) {
            System.out.println("La fila y la columna deben estar entre 1 y 3.");
            return false;
        } else if (tablero[fila][columna] != 0) {
            System.out.println("La casilla ya está ocupada.");
            return false;
        } else {
            return true;
        }
    }

    boolean hayGanador() {
        // Verificar filas
        for (int i = 0; i < 3; i++) {
            if (tablero[i][0] != 0 && tablero[i][0] == tablero[i][1] && tablero[i][1] == tablero[i][2]) {
                return true;
            }
        }

        // Verificar columnas
        for (int j = 0; j < 3; j++) {
            if (tablero[0][j] != 0 && tablero[0][j] == tablero[1][j] && tablero[1][j] == tablero[2][j]) {
                return true;
            }
        }

        // Verificar diagonales
        if (tablero[0][0] != 0 && tablero[0][0] == tablero[1][1] && tablero[1][1] == tablero[2][2]) {
            return true;
        } else if (tablero[0][2] != 0 && tablero[0][2] == tablero[1][1] && tablero[1][1] == tablero[2][0]) {
            return true;
        }

        return false;
    }

    boolean tableroLleno() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (tablero[i][j] == 0) {
                    return false;
                }
            }
        }
        return true;
    }

    private void actualizarPuntaje(Jugador ganador) {
        if (ganador == null) {
            jugadores.get(0).sumarPuntos(1);
            jugadores.get(1).sumarPuntos(2);
        } else {
            if (ganador.getNumero() == 1) {
                puntajeJugador1 += 3;
                puntajeJugador2 += 1;
            } else {
                puntajeJugador1 += 1;
                puntajeJugador2 += 3;
            }
            ganador.sumarPuntos(3);
        }
    }
}
