package org.example;

import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int turno;
        String respuesta;
        boolean r;
        do{
        boolean terminado = false;
        Juego juego = new Juego();
         turno= 0;
        System.out.println("TA TE TI");
        juego.limpiar();
        do {


            System.out.println("\n");
            boolean confirm = false;
            while (!confirm) {
                {
                    System.out.print("Ingrese la columna y fila donde desea marcar" + "\n");
                    int col = scanner.nextInt();
                    int fil = scanner.nextInt();
                    scanner.nextLine();
                    if (col > 2 || fil > 2) {
                        System.out.println("Ingrese una columna y fila valida");
                        break;
                    } else{
                        if(juego.verificarPosicion(col, fil)){
                            confirm = true;
                            turno++;
                            if(turno % 2 == 0) {

                                juego.marcar(col, fil, 'X');}
                            else {
                                juego.marcar(col, fil, 'O');
                            }
                            terminado=juego.verificarGanador();

                        }
                        }

                    }


            }


        }while (!terminado);
            System.out.println("Juego terminado");
            if(turno % 2 == 0) {
                System.out.println("Gano el jugador X");
            } else {
                System.out.println("Gano el jugador O");
            }
        System.out.println("Desea jugar de nuevo? (s/n)");
            respuesta = scanner.nextLine();
        if(respuesta.equals("s")){
            r = true;
        }else{

        r = false;}
        }while (r);
        scanner.close();
    }
}