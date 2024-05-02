package Pruebas.src.main.java.org.example;
public class App 
{
    public static void main( String[] args )
    {   
        
            
                String[] meses = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};
        
                // Array de nombres de alumnos
                String[] alumnos = {"Juan", "María", "Pedro", "Ana"};
        
                // Matriz para almacenar las faltas de los alumnos por mes
                int[][] faltas = {
                    // Juan, María, Pedro, Ana
                    {2, 3, 1, 0},  // Enero
                    {1, 0, 2, 1},  // Febrero
                    {0, 2, 1, 3},  // Marzo
                    {3, 1, 0, 2},  
                    {0, 0, 1, 1},  
                    {1, 2, 0, 2},  
                    {0, 1, 2, 1},  
                    {1, 0, 3, 0},  
                    {2, 3, 1, 2}, 
                    {0, 1, 2, 0},  
                    {3, 2, 1, 1}   
                };
        
                for (int i = 0; i < meses.length; i++) {
                    System.out.println("Mes: " + meses[i]);
                    for (int j = 0; j < alumnos.length; j++) {
                        System.out.println(alumnos[j] + ": " + faltas[i][j] + " faltas");
                    }
                    System.out.println();
                }
            }
        }
