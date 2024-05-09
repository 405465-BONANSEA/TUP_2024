package org.example;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class JuegoTest {

    private Juego juego;

    @BeforeEach
    public void setUp() {
        juego = new Juego();
    }

    @Test
    public void testGetPalabraEnJuego() {
        assertNotNull(juego.getPalabraEnJuego());
    }

    @Test
    public void testSetPalabraEnJuego() {
        String palabra = "test";
        juego.setPalabraEnJuego(palabra);
        assertEquals(palabra, juego.getPalabraEnJuego());
    }

    @Test
    public void testSetPalabraModoOculto() {
        String palabraModoOculto = "____";
        juego.setPalabraModoOculto(palabraModoOculto);
        assertEquals(palabraModoOculto, juego.getPalabraModoOculto());
    }

    @Test
    public void testGetLetrasElegidas() {
        assertNotNull(juego.getLetrasElegidas());
    }

    @Test
    public void testSetLetrasElegidas() {
        List<Character> letrasElegidas = new ArrayList<>();
        letrasElegidas.add('a');
        letrasElegidas.add('b');
        juego.setLetrasElegidas(letrasElegidas);
        assertEquals(letrasElegidas, juego.getLetrasElegidas());
    }

    @Test
    public void testGetVidasJugador() {
        assertNotNull(juego.getVidasJugador());
    }

    @Test
    public void testSetVidasJugador() {
        Integer vidasJugador = 3;
        juego.setVidasJugador(vidasJugador);
        assertEquals(vidasJugador, juego.getVidasJugador());
    }

    @Test
    public void testAddLetra() {
        juego.addLetra('a');
        assertTrue(juego.getLetrasElegidas().contains('a'));
    }

    @Test
    public void testCalcularEstadoDelJuego_Ganar() {
        juego.setPalabraEnJuego("test");
        juego.setPalabraModoOculto("test");
        assertTrue(juego.calcularEstadoDelJuego("t"));
    }

    @Test
    public void testCalcularEstadoDelJuego_Perder() {
        juego.setVidasJugador(1);
        assertTrue(juego.calcularEstadoDelJuego("x"));
    }

    @Test
    public void testGetPalabraModoOculto() {
        juego.setPalabraEnJuego("test");
        juego.setLetrasElegidas(List.of('t', 'e'));
        assertEquals("te__", juego.getPalabraModoOculto());
    }

    @Test
    public void testDibujar_Perder() {
        juego.setVidasJugador(0);
        juego.setPalabraEnJuego("test");
        juego.dibujar();
        // Assert console output
    }

    @Test
    public void testDibujar() {
        juego.setVidasJugador(2);
        juego.setPalabraEnJuego("test");
        juego.setLetrasElegidas(List.of('t', 'e'));
        juego.dibujar();
        // Assert console output
    }
}