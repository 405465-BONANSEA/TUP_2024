package TatetiSimulacro;
import org.junit.Test;
import static org.junit.Assert.*;

public class JuegoTest2 {

    @Test
    public void testMovimientoValido() {
        Juego2 juego = new Juego2("Jugador 1", "Jugador 2");
        // Test invalid move outside board boundaries
        assertFalse(juego.movimientoValido(-1, 0));
        assertFalse(juego.movimientoValido(0, -1));
        assertFalse(juego.movimientoValido(3, 0));
        assertFalse(juego.movimientoValido(0, 3));
        // Test invalid move on occupied square
        juego.tablero[0][0] = 1;
        assertFalse(juego.movimientoValido(0, 0));
        // Test valid move
        assertTrue(juego.movimientoValido(0, 1));
    }

    @Test
    public void testHayGanador() {
        Juego2 juego = new Juego2("Jugador 1", "Jugador 2");
        // Test no winner yet
        assertFalse(juego.hayGanador());
        // Test horizontal winner
        juego.tablero[0][0] = 1;
        juego.tablero[0][1] = 1;
        juego.tablero[0][2] = 1;
        assertTrue(juego.hayGanador());
        // Test vertical winner
        juego.tablero[0][0] = 2;
        juego.tablero[1][0] = 2;
        juego.tablero[2][0] = 2;
        assertTrue(juego.hayGanador());
        // Test diagonal winner
        juego.tablero[0][0] = 1;
        juego.tablero[1][1] = 1;
        juego.tablero[2][2] = 1;
        assertTrue(juego.hayGanador());
    }

    @Test
    public void testTableroLleno() {
        Juego2 juego = new Juego2("Jugador 1", "Jugador 2");
        // Test empty board
        assertFalse(juego.tableroLleno());
        // Test partially filled board
        juego.tablero[0][0] = 1;
        juego.tablero[1][1] = 2;
        juego.tablero[2][2] = 1;
        assertFalse(juego.tableroLleno());
        // Test full board
        juego.tablero[0][1] = 1;
        juego.tablero[0][2] = 2;
        juego.tablero[1][0] = 1;
        juego.tablero[1][2] = 2;
        juego.tablero[2][0] = 2;
        juego.tablero[2][1] = 1;
        juego.tablero[2][2] = 2;
        assertTrue(juego.tableroLleno());
    }
}
