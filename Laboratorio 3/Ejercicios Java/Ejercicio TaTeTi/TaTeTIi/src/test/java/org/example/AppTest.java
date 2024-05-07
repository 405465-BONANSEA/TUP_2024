package org.example;
import junit.framework.TestCase;


public class AppTest extends TestCase {
    Juego juego;

    public void setUp() {
        juego= new Juego();
    }

    public void testMarcar() {
        System.out.println("Test uno: \n");
        juego.limpiar();
        System.out.println("\n");
        juego.marcar(0, 0, 'X');
        System.out.println("\n");
        assertEquals('X', juego.getTablero()[0][0]);
    }
    public void testVerificarPosicion() {
        System.out.println("Test dos: \n");
        juego.limpiar();
        System.out.println("\n");
        juego.marcar(0, 0, 'X');
        System.out.println("\n");
        assertEquals(false,juego.verificarPosicion(0, 0));
        System.out.println("\n");
    }
    public void testVerificarPosicion2() {
        System.out.println("Test tres: \n");
        juego.limpiar();
        System.out.println("\n");
        juego.marcar(0, 0, 'O');
        assertEquals(true,juego.verificarPosicion(1, 1));
        System.out.println("\n");
    }

    public void testVerificarGanador() {
        System.out.println("Test cuatro: \n");
        juego.marcar(0, 0, 'X');
        System.out.println("\n");
        juego.marcar(0, 1, 'X');
        System.out.println("\n");
        juego.marcar(0, 2, 'X');
        assertTrue(juego.verificarGanador());
        System.out.println("\n");
    }

    public void testApp() {
        assertTrue( true );
    }
}