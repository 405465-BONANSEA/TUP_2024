package BlackJack;

import java.util.Scanner;

public class Main {
    private static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        Jugador jugador = null;

        while(true)
        {
            System.out.println("Bienvenido al juego BlackJack");
            System.out.println("Ingrese su nombre:");
            String nombre = sc.nextLine();

            if(!nombre.equalsIgnoreCase("")){
                jugador= new Jugador(nombre);
                break;
            }
            else{
                System.out.println("No ingrese un nombre vacio");
            }
        }

        if(jugador.getNombre() != null && !jugador.getNombre().equalsIgnoreCase(""))
        {
            Juego_BlackJack juego = Juego_BlackJack.getInstance(jugador);
        }
    }
}