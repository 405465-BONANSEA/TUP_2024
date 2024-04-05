import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello, World.");
        System.out.println("Hello, Java.");

        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese un texto");
        String string = scanner.next();
        System.out.println("Ingrese un numero");
        int miint = scanner.nextInt();
        System.out.println("Texto(String): " + string + "\n"+"Numero(Int): " + miint);

        System.out.println("Ingrese tres numeros...");

        System.out.println("Ingrese el primer numero...");
        int int1 = scanner.nextInt();
        System.out.println("Ingrese el segundo numero...");
        int int2 = scanner.nextInt();
        System.out.println("Ingrese el tercer numero...");
        int int3 = scanner.nextInt();
        System.out.println("Los numeros son...");
        System.out.println(int1 + "\n" + int2 + "\n" + int3);



        scanner.close();
    }
}
