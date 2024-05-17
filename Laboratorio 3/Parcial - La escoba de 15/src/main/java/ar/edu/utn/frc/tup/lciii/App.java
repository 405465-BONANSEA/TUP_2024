package ar.edu.utn.frc.tup.lciii;

import ar.edu.utn.frc.tup.lciii.round.EscobaMatchRound;

/**
 * Hello to Exam - ESCOBA DE 15
 *
 */
public class App 
{

    private static EscobaGame escobaGame = new EscobaGame();

    /**
     * This is the main program
     * IMPORTANTE: Este método no necesita ser modificado
     */
    public static void main( String[] args ) {
        LetterByLetterPrinter.println("Hello, Examen - Escoba de 15." + System.lineSeparator());
        escobaGame.welcomeMessage();
        User player = escobaGame.createHumanUser();
        User appPlayer = escobaGame.createAppUser();
        Boolean playAgain = true;
        // Bucle principal
        do {
            EscobaMatch escobaMatch = new EscobaMatch(player, appPlayer);
            boolean isPlayerDealer = false;
            LetterByLetterPrinter.println(System.lineSeparator() + "We are ready to play!!!");
            // Bucle de la partida
            do {
                EscobaMatchRound escobaMatchRound = new EscobaMatchRound(player, appPlayer);
                escobaMatchRound.startRound(isPlayerDealer);
                escobaMatchRound.playRound(isPlayerDealer);
                isPlayerDealer = !isPlayerDealer;
                escobaMatch.calculateScore(escobaMatchRound);
            } while (!escobaMatch.isFinish());
            playAgain = escobaGame.wantPlayAgain();
        } while (playAgain);
    }
}
