package ar.edu.utn.frc.tup.lciii;

/**
 * Clase usada para imprimir por pantalla mensajes letra a letra
 */
public class LetterByLetterPrinter {

    /**
     * Método que imprime los mensajes por pantalla letra a letra dejando 10 ms entre cada letra
     * De esta manera da la sensación que el juego se va desarrollando como un chat entre el jugador
     * y el sistema. Esto mejora la experiencia de usuario.
     *
     * @param text texto a imprimir por pantalla
     */
    public static void println(String text) {
        try {
            for (int i = 0; i < text.length(); i++) {
                System.out.print(text.charAt(i));
                Thread.sleep(8); // Ajusta el tiempo de espera según lo deseado
            }
            System.out.println();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
