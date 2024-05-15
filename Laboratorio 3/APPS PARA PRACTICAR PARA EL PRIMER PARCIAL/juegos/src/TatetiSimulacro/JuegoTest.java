package TatetiSimulacro;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class JuegoTest {

    @Test
    public void testHayGanador() {
        Juego juego = new Juego();
        juego.tablero = new int[][]{{1, 1, 1}, {0, 2, 0}, {0, 2, 0}};
        assertTrue(juego.hayGanador());
        juego.tablero = new int[][]{{1, 2, 0}, {0, 1, 2}, {2, 0, 1}};
        assertTrue(juego.hayGanador());
        juego.tablero = new int[][]{{0, 1, 0}, {0, 2, 0}, {0, 1, 0}};
        assertFalse(juego.hayGanador());
        juego.tablero = new int[][]{{0, 2, 1}, {1, 1, 2}, {2, 1, 2}};
        assertFalse(juego.hayGanador());
    }

    @Test
    public void testMovimientoValido() {
        Juego juego = new Juego();
        juego.tablero = new int[][]{{1, 0, 0}, {0, 2, 0}, {0, 0, 0}};
        assertTrue(juego.movimientoValido(1, 2));
        assertFalse(juego.movimientoValido(0, 0));
        assertFalse(juego.movimientoValido(1, 1));
        assertFalse(juego.movimientoValido(-1, 0));
        assertFalse(juego.movimientoValido(0, 3));
    }

//    @Test
//    public void testActualizarPuntaje() {
//        Juego juego = new Juego();
//        juego.jugadores = new ArrayList<>();
//        juego.jugadores.add(new Jugador("Jugador 1", 1));
//        juego.jugadores.add(new Jugador("Jugador 2", 2));
//        juego.actualizarPuntaje(juego.jugadores.get(0));
//        assertEquals(1, juego.puntajeJugador1);
//    }

}
