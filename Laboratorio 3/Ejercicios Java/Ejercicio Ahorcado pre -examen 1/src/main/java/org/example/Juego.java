package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Juego {
    private String palabraEnJuego;
    private String palabraModoOculto;
    private List<Character> letrasElegidas;
    private Integer vidasJugador;
 private Scanner scanner;
    private Jugador jugador;


    public Scanner getScanner() {
        return scanner;
    }

    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }

    public Jugador getJugador() {
        return jugador;
    }

    public void setJugador(Jugador jugador) {
        this.jugador = jugador;
    }

    public void bienvenida() {
        
        System.out.println("Bienvenido al juego del AHORCADO!!!!!!!!!");
    }

    public void cargarJugador() {
    
        System.out.println("Ingrese nombre del jugador por favor");
        String nombre=scanner.nextLine();
        jugador=new Jugador(nombre);
    }


    public Character pedirLetra() {

        Character letra = null;
        do {
            System.out.println("Ingrese una letra");
            String input = scanner.nextLine();
            
            if(validarInputLetra(input)) {
                letra = getCharacterFromInput(input);
            } else {
                System.out.println("Error...Ingrese una letra valida");
            }
        } while (letra == null);
        return letra;
    }

    private Character getCharacterFromInput(String input) {
    

        char caracter;
        if(input.length() == 1){
            caracter = input.charAt(0);
        }
        else return null;
        return caracter;
    }

    private Boolean validarInputLetra(String input) {
        if(input.length()==1)
        {
            return true;
        }
        else {
            return false;
        }
    }
    public Boolean getPlayAgain() {
        Scanner scanner = new Scanner(System.in);
        boolean confirm = false;
        
        while (true) {
            System.out.println("Desea seguir jugando?: (y/n) ");
            
            String rta = scanner.nextLine();
            if (rta.toLowerCase().equals("y")) {
                confirm = true;
                break;
            } else if (rta.toLowerCase().equals("n")) {
                confirm = false;
                break;
            } else {
                System.out.println("Error...Ingrese una respuesta valida");
            }
        }
        
        
        return confirm;
    }
    public void despedida() {
        scanner.close();
    }
    public String getPalabraEnJuego() {
        return palabraEnJuego;
    }

    public void setPalabraEnJuego(String palabraEnJuego) {
        this.palabraEnJuego = palabraEnJuego;
    }

    public void setPalabraModoOculto(String palabraModoOculto) {
        this.palabraModoOculto = palabraModoOculto;
    }

    public List<Character> getLetrasElegidas() {
        return letrasElegidas;
    }

    public void setLetrasElegidas(List<Character> letrasElegidas) {
        this.letrasElegidas = letrasElegidas;
    }

    public Integer getVidasJugador() {
        return vidasJugador;
    }

    public void setVidasJugador(Integer vidasJugador) {
        this.vidasJugador = vidasJugador;
    }

    public Juego() {
        this.palabraEnJuego = getPalabra();
        this.letrasElegidas = new ArrayList<>();
        this.vidasJugador = 6;
        this.scanner = new Scanner(System.in);
    }

    public void addLetra(Character letra) {
        if (!this.letrasElegidas.contains(letra)) {
            this.letrasElegidas.add(letra);
            this.palabraModoOculto = this.getPalabraModoOculto();
        }
    }
public Boolean calcularEstadoDelJuego(String letra) {
    
    if (palabraEnJuego.contains(letra.toString())) {
        if (palabraModoOculto.equals(palabraEnJuego)) {
            System.out.println("¡Felicidades, ganaste el juego!");
            return true;
        }
        return false;
    } else {
        vidasJugador--;
        if (vidasJugador <= 0) {
            System.out.println("El juego terminó, perdiste");
            return true;
        }
        return false;
    }
}
    
    public String getPalabraModoOculto() {
        StringBuilder palabraOculta = new StringBuilder(palabraEnJuego.length());
        for (int i = 0; i < palabraEnJuego.length(); i++) {
            Character l = palabraEnJuego.charAt(i);
            if (letrasElegidas.contains(l)) {
                palabraOculta.append(l);
            } else { 
                palabraOculta.append("_");
            }
        }
        setPalabraModoOculto(palabraOculta.toString());
        return palabraOculta.toString();
    }


    public void dibujar() {
        String palabraOculta = getPalabraModoOculto();

        if (vidasJugador<=0) {
            System.out.println("¡Perdiste! La palabra correcta era: " + palabraEnJuego);
            return;
        }

        System.out.println("Palabra: " + palabraOculta);
        System.out.println("Vidas restantes: " + vidasJugador);
    }

      private List<String> palabras = Arrays.asList("abrir", "acero", "acto", "agua", "aire", "alma", "alta", "amigo",
            "amor", "angel", "animal", "ansia", "apoyo", "arena", "arte", "asado", "asistir", "atajo", "atlas",
            "juego", "jugoso", "julio", "junio", "juntar", "justo", "juzgar", "labio", "lado", "ladron", "laguna",
            "lagrima", "lamentar", "lapiz", "largo", "leal", "leccion", "leche", "lector", "legumbre",
            "lejos", "lengua", "leon", "letra", "levantar", "leyenda", "libertad", "libro", "licor", "lider", "lienzo",
            "ligeramente", "limon", "lindo", "liquido", "listo", "llama", "llanto", "llegar", "lleno", "llevar",
            "lluvia", "lobo", "locura", "lomo", "lote", "luchar", "luego", "lujo", "luna", "lunes", "lupa", "lustro",
            "luz", "maceta", "madera", "maestro", "mafia", "magia", "mago", "maiz", "maldad", "maleta", "malla", "malo",
             "mandar", "manejar", "manga", "mano", "mansion", "manta", "mapa", "maravilla", "marcar",
            "marcha", "marfil", "marmol", "marron", "martes", "marzo", "masa", "mascara", "masivo", "matar", "maximo",
            "mayo", "mayor", "mecha", "medalla", "medir", "meditar", "medula");


    public String getPalabra() {
        Random random = new Random();
        int indexRandom = random.nextInt(palabras.size());
        return palabras.get(indexRandom);
    }
}
