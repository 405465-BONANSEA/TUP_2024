package Tateti;

public class Tablero {

    private String[][] casillas;

    public Tablero() {
        casillas = new String[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                casillas[i][j] = " ";
            }
        }
    }

    public void mostrar() {
        System.out.println("  1 2 3");
        for (int i = 0; i < 3; i++) {
            System.out.print((i+1) + " ");
            for (int j = 0; j < 3; j++) {
                System.out.print(casillas[i][j]);
                if (j < 2) {
                    System.out.print("|");
                }
            }
            System.out.println();
            if (i < 2) {
                System.out.println("  -----");
            }
        }
    }

    public boolean estaVacio(int fila, int columna) {
        return casillas[fila][columna].equals(" ");
    }

    public void colocar(int fila, int columna, String simbolo) {
        casillas[fila][columna] = simbolo;
    }

    public boolean hayGanador(String simbolo) {
        // Comprobar filas
        for (int i = 0; i < 3; i++) {
            if (casillas[i][0].equals(simbolo) && casillas[i][1].equals(simbolo) && casillas[i][2].equals(simbolo)) {
                return true;
            }
        }
        // Comprobar columnas
        for (int j = 0; j < 3; j++) {
            if (casillas[0][j].equals(simbolo) && casillas[1][j].equals(simbolo) && casillas[2][j].equals(simbolo)) {
                return true;
            }
        }
        // Comprobar diagonales
        if (casillas[0][0].equals(simbolo) && casillas[1][1].equals(simbolo) && casillas[2][2].equals(simbolo)) {
            return true;
        }
        if (casillas[0][2].equals(simbolo) && casillas[1][1].equals(simbolo) && casillas[2][0].equals(simbolo)) {
            return true;
        }
        return false;
    }

    public boolean estaLleno() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (casillas[i][j].equals(" ")) {
                    return false;
                }
            }
        }
        return true;
    }
}
