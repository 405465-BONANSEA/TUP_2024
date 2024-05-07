package ar.edu.utn.frc.tup.lciii;
public class App 
{

    private static Juego juego = new Juego();

    
    public static void main( String[] args ) {
        System.out.println("Hello, Practica Parcial 1 - Ahorcado.");
        juego.bienvenida();
        juego.cargarJugador();
        Boolean playAgain = true;
        do {
            Juego juego = new Juego();
            Boolean terminado = false;
            do {
                juego.dibujar();
                if (!terminado) {
                    Character letra = juego.pedirLetra();
                    String l = letra.toString();
                    juego.addLetra(letra);  
                    terminado = juego.calcularEstadoDelJuego(l);
                }
            } while (!terminado);
            playAgain = juego.getPlayAgain();
        } while (playAgain);
        juego.despedida();
    }
}