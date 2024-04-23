package org.example;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter two numbers:");
        int var1 = scanner.nextInt();
        int var2 = scanner.nextInt();
        scanner.close();

        Operations(var1, var2);
    }

    public static void Operations(int var1, int var2) {
        
        System.out.println("Suma:" + (var1 + var2) + "\n");
        System.out.println("Resta:" + (var1 - var2) + "\n");
        System.out.println("Multiplicacion:" + (var1 * var2) + "\n");
        System.out.println("Division:" + (var1 / var2) + "\n");
        
    }
}