package org.example;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Estanciero Test" );

        Bank bank = new Bank();
        Player player = new HumanPlayer("Player 1", 1000);
        Player bot = new BotPlayer("Bot 1", 1000, PlayStyle.AGGRESSIVE);

        System.out.println("Player 1 money: " + player.getMoney());
        System.out.println("Bot 1 money: " + bot.getMoney());
    }
}
