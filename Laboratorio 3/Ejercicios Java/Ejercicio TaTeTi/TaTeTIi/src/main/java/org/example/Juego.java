package org.example;

public class Juego {
    private char[][] tablero = new char[3][3];

    public char[][] getTablero() {
        return tablero;
    }
    public void limpiar() {

        for(int i = 0; i < 3; i++) {
            System.out.println();
            for (int j = 0; j < 3; j++) {
                tablero[i][j] = '-';
                System.out.print(tablero[i][j]+ " ");
            }
        }
    }
    public void marcar(int col, int fil, char simbolo){
        tablero[col][fil] = simbolo;
        for(int i = 0; i < 3; i++) {
            System.out.println();
            for (int j = 0; j < 3; j++) {
                System.out.print(tablero[i][j]+ " ");
            }
        }
    }

    public boolean verificarGanador() {

        for (int i = 0; i < 3; i++) {
            if (tablero[i][0] == tablero[i][1] && tablero[i][1] == tablero[i][2] && tablero[i][0] != '-') {
                return true;
            }
        }


        for (int i = 0; i < 3; i++) {
            if (tablero[0][i] == tablero[1][i] && tablero[1][i] == tablero[2][i] && tablero[0][i] != '-') {
                return true;
            }
        }


        if (tablero[0][0] == tablero[1][1] && tablero[1][1] == tablero[2][2] && tablero[0][0] != '-') {
            return true;
        }
        if (tablero[0][2] == tablero[1][1] && tablero[1][1] == tablero[2][0] && tablero[0][2] != '-') {
            return true;
        }


        return false;
    }

    public boolean verificarPosicion(int col, int fil) {
        if (tablero[col][fil] == '-') {
            return true;
        } else {
            System.out.println("Posicion ocupada");
            return false;
        }
    }
}
