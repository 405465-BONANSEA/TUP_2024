package org.example;



import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

        System.out.println( "Enter a price" );
        Scanner scann = new Scanner(System.in);
        double price = scann.nextDouble();
        getPrice(price);
        scann.close();
    }
    

    public static double getPrice(double price ) {
        
        double priceWithVat= price * 1.21 ;
        System.out.println("Price with vat: "+priceWithVat);
        return priceWithVat;

    }
    }

