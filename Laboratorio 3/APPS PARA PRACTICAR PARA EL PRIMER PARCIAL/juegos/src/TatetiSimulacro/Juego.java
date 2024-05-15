package TatetiSimulacro;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Juego {
    private String nombreJugador1;
    private String nombreJugador2;
    ArrayList<Jugador> jugadores;
    private int turno;
    int[][] tablero;
    int puntajeJugador1;
    private int puntajeJugador2;
    private int ultimoPerdedor;
    private boolean primerPartida = true;

    boolean ganoNoInicio = false;

    private void actualizarPuntaje(Jugador ganador) {
        boolean empate = false;

        if (ganador != null) {
            if (ganador.getNumero() == 1) {
                puntajeJugador1 += 3;
                puntajeJugador2 += 1;
            } else {
                puntajeJugador2 += 3;
                puntajeJugador1 += 1;
            }
            if (ganador.getNumero() != turno && ganador.getNumero()!= 2) {
                ganoNoInicio = true;
               if (ganador.getNumero() == 1) {
                   puntajeJugador1 += 1;
               } else {
                   puntajeJugador2 += 1;
               }
            }
        } else {
            empate = true;
            if (turno == 0) {
                puntajeJugador2 += 2;
                puntajeJugador1 += 1;
            } else {
                puntajeJugador1 += 2;
                puntajeJugador2 += 1;
            }
            if (turno == 0) {
                puntajeJugador1 += 1;
                puntajeJugador2 += 2;
            } else {
                puntajeJugador2 += 1;
                puntajeJugador1 += 2;
            }
        }
        if (ganoNoInicio) {
            if (ganador.getNumero() == 1) {
                puntajeJugador1 += 1;
            } else {
                puntajeJugador2 += 1;
            }
        }
    }

    public void jugar() {
        Scanner scanner = new Scanner(System.in);
        boolean jugarOtraPartida = true;
        puntajeJugador1 = 0;
        puntajeJugador2 = 0;
        System.out.println("¡Bienvenidos al juego del TA TE TI!");
        while (jugarOtraPartida) {
            ganoNoInicio = false;
            if (nombreJugador1 == null || nombreJugador2 == null) {
                System.out.print("Ingrese el nombre del Jugador 1: ");
                nombreJugador1 = scanner.next();

                System.out.print("Ingrese el nombre del Jugador 2: ");
                nombreJugador2 = scanner.next();
            }

            jugadores = new ArrayList<>();
            jugadores.add(new Jugador(nombreJugador1, 1));
            jugadores.add(new Jugador(nombreJugador2, 2));
            if (primerPartida) {
                Random random = new Random();
                turno = random.nextInt(2);
            } else {
                turno = ultimoPerdedor;
            }
            tablero = new int[3][3];

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
                    ultimoPerdedor = (turno + 1) % 2;
                    juegoTerminado = true;
                } else if (tableroLleno()) {
                    mostrarTablero();
                    System.out.println("¡El juego ha terminado en empate!");
                    actualizarPuntaje(null);
                    ultimoPerdedor = turno;
                    juegoTerminado = true;
                } else {
                    turno = (turno + 1) % 2;
                }
            }

            System.out.println("Puntaje actual:");
            System.out.println(jugadores.get(0).getNombre() + ": " + puntajeJugador1);
            System.out.println(jugadores.get(1).getNombre() + ": " + puntajeJugador2);

            String respuesta;
            boolean respuestaValida = false;
            while (!respuestaValida) {
                System.out.print("¿Quieren jugar otra partida? (s/n): ");
                respuesta = scanner.next();
                if (respuesta.equalsIgnoreCase("n")) {
                    jugarOtraPartida = false;
                    respuestaValida = true;
                } else if (respuesta.equalsIgnoreCase("s")) {
                    primerPartida = false;
                    tablero = new int[3][3];
                    respuestaValida = true;
                } else {
                    System.out.println("Respuesta inválida. Por favor ingrese 's' o 'n'.");
                }
            }
            System.out.println("Puntaje final del juego:");
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



}
