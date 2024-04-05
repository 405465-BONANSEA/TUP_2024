package org.example;
import java.util.Scanner;
public class App {
    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese un texto");
        String string = scanner.nextLine();
        System.out.println("Ingrese un numero");
        int miint = scanner.nextInt();
        int ej;
        do{
            System.out.println("Ingrese ejercicio:");
            ej = scanner.nextInt();
            switch(ej){

                case 1:
                    System.out.println("Primer ejercicio:");
                    System.out.println("Hello, World.");
                    System.out.println("Hello, Java."); break;

                case 2:
                    System.out.println("Texto(String): " + string + "\n"+"Numero(Int): " + miint);
                    break;

                case 3:
                    System.out.println("Tercer ejercicio:"+ "\n"+"Ingrese tres numeros...");

                    System.out.println("Ingrese el primer numero...");
                    int int1 = scanner.nextInt();
                    System.out.println("Ingrese el segundo numero...");
                    int int2 = scanner.nextInt();
                    System.out.println("Ingrese el tercer numero...");
                    int int3 = scanner.nextInt();
                    System.out.println("Los numeros son...");
                    System.out.println(int1 + "\n" + int2 + "\n" + int3);
                    break;

                case 4:
                    System.out.println("Cuarto ejercicio:");


                    if(string.contains("s")){
                        System.out.println("Verdadero");

                    }else {

                        System.out.println("Falso");
                    }
                    break;
                case 5:
                    System.out.println("Quinto ejercicio:");
                    System.out.println("La cadena tiene: "+string.length()+ " Caracteres");
                    String c= string.toUpperCase();
                    System.out.println(c);
                    break;

                case 6:
                    System.out.println("Sexto ejercicio:");
                    int n=0;
                    while (n<=5){

                        System.out.println(n);
                        n++;
                    }
                    break;

                case 7:
                    System.out.println("Septimo ejercicio: (Cinco en el classroom)");
                    int num;
                    do {
                        System.out.println("Ingrese un número entre 2 y 20:");
                        num = scanner.nextInt();
                        
                        if (num < 2 || num > 20) {
                            System.out.println("Número no válido. Por favor, ingrese un número entre 2 y 20.");
                        }
                    } while (num < 2 || num > 20);
            
                    System.out.println("Tabla de multiplicación de " + num + ":");
            
                    for (int cont = 1; cont <= 10; cont++) {
                        int res = num * cont;
                        System.out.println(num + " x " + cont + " = " + res);
                    }
                
                    break;
                default:
                    if (ej >8)
                        System.out.println("Ejercicio no válido.");
                    break;
            }


        } while (ej != 8);

        scanner.close();
    }
}
