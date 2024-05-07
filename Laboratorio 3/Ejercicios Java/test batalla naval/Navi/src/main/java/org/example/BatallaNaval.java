package org.example;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
        public class BatallaNaval {
            public static void main(String[] args) {
                System.out.println("BATALLA NAVAL");
                char[][] grid = new char[5][5];
                initializeGrid(grid);

               
                placeShips(grid);

                
                playGame(grid);
            }

            public static void initializeGrid(char[][] grid) {
                for (int i = 0; i < grid.length; i++) {
                    for (int j = 0; j < grid[i].length; j++) {
                        grid[i][j] = '-';
                    }
                }
            }

            public static void placeShips(char[][] grid) {
                int numShips = 5;
                while (numShips > 0) {
                    int row = (int) (Math.random() * 5);
                    int col = (int) (Math.random() * 5);
            
                    if (grid[row][col] != 'S') {
                        grid[row][col] = 'S';
                        numShips--;
                    }
                }
            }

            public static void playGame(char[][] grid) {
                Scanner scanner = new Scanner(System.in);

                int numShips = 5;
                int numGuesses = 0;

                while (numShips > 0) {
                    // Display the grid
                    int row;
                    int col;
                    displayGrid(grid);

                    do{// Get user's guess
                    System.out.print("INGRESA UNA FILA (0-4): ");
                     row = scanner.nextInt();
                    System.out.print("INGRESA UNA COLUMNA (0-4): ");
                     col = scanner.nextInt();
                    if(row < 0 || row > 4 || col < 0 || col > 4) {
                        System.out.println("Por favor ingresa un valor entre 0 y 4");
                        
                    }}while ((row < 0 || row > 4 || col < 0 || col > 4));
                    // Check if the guess hits a ship
                    if (grid[row][col] == 'S') {
                        System.out.println("Acertaste");
                        grid[row][col] = 'X';
                        numShips--;
                    } else if (grid[row][col] == '-') {
                        System.out.println("Fallaste");
                        grid[row][col] = 'O';
                    } else {
                        System.out.println("Ya lo usaste");
                    }

                    numGuesses++;
                }

                System.out.println("GANASTE, tardaste " + numGuesses + " intentos");
                scanner.close();
            }

            public static void displayGrid(char[][] grid) {
                for (int i = 0; i < grid.length; i++) {
                    for (int j = 0; j < grid[i].length; j++) {
                        if (grid[i][j] == 'S') {
                            System.out.print('-' + " ");
                        } else {
                            System.out.print(grid[i][j] + " ");
                        }
                    }
                    System.out.println();
                    
                }
            }
        }
    
