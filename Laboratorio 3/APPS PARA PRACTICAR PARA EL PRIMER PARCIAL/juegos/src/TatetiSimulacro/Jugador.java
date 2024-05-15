package TatetiSimulacro;

public class Jugador {
    private String nombre;
    private int numero;
    private int puntaje;

    public Jugador(String nombre, int numero) {
        this.nombre = nombre;
        this.numero = numero;
        this.puntaje = 0;
    }

    public String getNombre() {
        return nombre;
    }

    public int getNumero() {
        return numero;
    }

    public int getPuntaje() {
        return puntaje;
    }

    public void sumarPuntos(int puntos) {
        puntaje += puntos;
    }
}
