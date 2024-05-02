
package org.example;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
        public class App {
            public static void main(String[] args) {
                System.out.println("BATALLA NAVAL");
                char[][] grid = new char[10][10];
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
                    int row = (int) (Math.random() * 10);
                    int col = (int) (Math.random() * 10);

                    if (grid[row][col] != 'S') {
                        grid[row][col] = '-';
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
                    displayGrid(grid);

                    // Get user's guess
                    System.out.print("INGRESA UNA FILA (0-9): ");
                    int row = scanner.nextInt();
                    System.out.print("INGRESA UNA COLUMNA (0-9): ");
                    int col = scanner.nextInt();

                    // Check if the guess hits a ship
                    if (grid[row][col] == 'S') {
                        System.out.println("Acertaste");
                        grid[row][col] = 'X';
                        numShips--;
                    } else if (grid[row][col] == '-') {
                        System.out.println("Fallaste!");
                        grid[row][col] = 'O';
                    } else {
                        System.out.println("Ya lo usaste!");
                    }

                    numGuesses++;
                }

                System.out.println("GANASTE, tardaste " + numGuesses + " intentos");
                scanner.close();
            }

            public static void displayGrid(char[][] grid) {
                for (int i = 0; i < grid.length; i++) {
                    for (int j = 0; j < grid[i].length; j++) {
                        System.out.print(grid[i][j] + " ");
                    }
                    System.out.println();
                }
            }
        
    }

