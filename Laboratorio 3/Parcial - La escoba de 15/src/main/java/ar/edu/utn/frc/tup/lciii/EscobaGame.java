package ar.edu.utn.frc.tup.lciii;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Esta clase ofrece los métodos para controlar la ejecución de multiples partidas.
 * Un Game es el resultado de la ejecución de la aplicación y de
 * haber jugado multiples partidas (Match) por parte del usuario.
 *
 */
public class EscobaGame {

    /**
     * Expresión regular para validar respuestas yes/no
     */
    private static final String YES_NO_REGEX = "[yYnN]";

    /**
     * Scanner para capturar las entradas del usuario
     */
    private Scanner scanner = new Scanner(System.in);

    /**
     * Este método retorna el Scanner del Game
     * @return el Scanner del Game
     */
    public Scanner getScanner() {
        return scanner;
    }

    /**
     * Este método setea el Scanner del Game
     *
     * @param scanner el Scanner a setear
     */
    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }

    /**
     * Este método muestra por pantalla un mensaje de bienvenida al juego de la Escoba de 15
     *
     * @see System#out
     */
    public void welcomeMessage() {
        LetterByLetterPrinter.println("Welcome to the 'Escoba de 15' game!");
    }

    /**
     * Este método gestiona la creación del usuario.
     * Pide por pantalla los datos requeridos para la creación del usuario
     * y captura las entradas del usuario.
     * Como resultado retorna el usuario creado
     *
     * @see User#User()
     * @see User#setName(String)
     *
     * @return un nuevo User con nombre ingresado por el usuario y 0 puntos
     */
    public User createHumanUser() {
        User user = new User();
        LetterByLetterPrinter.println("Enter your name to start playing");
        user.setName(scanner.nextLine());
        return user;
    }

    /**
     * Este método gestiona la creación del jugador app.
     * Como resultado retorna el usuario APP creado
     *
     * @return un nuevo User con nombre "APP" y 0 puntos
     */
    public User createAppUser() {
        return new User("APP", 0);
    }

    /**
     * Este método controla si el usuario quiere volver a jugar o no.
     * Pide por pantalla los datos requeridos para consultar al usuario si quiere volver a jugar
     * y captura las entradas del usuario.
     * Como resultado retorna la respuesta del usuario como un Boolean
     *
     * @return true si el usuario quiere volver a jugar, false si el usuario NO quiere volver a jugar
     */
    public Boolean wantPlayAgain() {
        Boolean answer = null;
        do {
            LetterByLetterPrinter.println("Do you want to play again? (y/n)");
            String input = scanner.nextLine();
            answer = getYesNoAnswer(input);
        } while (answer == null);
        return answer;
    }


    /**
     * Este método valída que el parámetro de entrada input contenga y, Y, n o N.
     * Si el valor es alguno de esos datos, retorna el valor en forma de Boolean,
     * sino, imprime un error por pantalla y retorna null.
     *
     * @see Pattern#compile(String)
     * @see Pattern#matcher(CharSequence)
     * @see Matcher#matches()
     *
     * @param input el String a validar
     * @return true si input contiene y o Y, false si input contiene n o N, null para lo demas.
     */
    public static Boolean getYesNoAnswer(String input) {
        Pattern pattern = Pattern.compile(YES_NO_REGEX);
        Boolean answer = null;
        if (pattern.matcher(input).matches()) {
            answer = input.equalsIgnoreCase("y");
        } else {
            LetterByLetterPrinter.println("Invalid answer. Please enter 'y' or 'n'");
        }
        return answer;
    }
}
