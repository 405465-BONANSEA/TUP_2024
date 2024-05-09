package org.example;

import java.util.*;

public class Juego {
    private String palabraEnJuego;
    private String palabraModoOculto;
    private List<Character> letrasElegidas;
    private Integer vidasJugador = 5;
    private Scanner scanner;
    private Jugador jugador;
    private final List<String> palabras = Arrays.asList("abrir", "acero", "acto", "agua", "aire", "alma", "alta",
            "amigo", "amor", "angel", "animal", "ansia", "apoyo", "arena", "arte", "asado", "asistir", "atajo", "atlas",
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

    public void bienvenida() {

        System.out.println("Bienvenido al juego del AHORCADO!!!!!!!!!");
    }

    public void cargarJugador() {

        System.out.println("Ingrese nombre del jugador por favor");
        String nombre = scanner.nextLine();
        jugador = new Jugador(nombre);
    }

    public String getPalabraModoOculto() {
        /*
         * EXPLICACION
         * El objeto StringBuilder:
         * StringBuilder es una clase en Java que se utiliza para crear y manipular
         * cadenas de caracteres
         * que pueden ambiar (por ejemplo, cuando estás añadiendo, eliminando o
         * cambiando caracteres en una cadena).
         * Es especialmente útil cuando necesitas realizar muchas modificaciones en una
         * cadena de texto,
         * ya que es más eficiente en términos de rendimiento que manipular cadenas con
         * la clase String de Java.
         */
        StringBuilder palabraOculta = new StringBuilder(palabraEnJuego.length());
        // se mapea la palabra en juego y se compara con las letras elegidas
        for (int i = 0; i < palabraEnJuego.length(); i++) {
            // se obtiene el caracter en la posicion i
            Character l = palabraEnJuego.charAt(i);
            // si la letra elegida (l) contiene la letra en la posicion i se agrega la letra
            // a
            // la palabra oculta
            // si no, se agrega un guion bajo, quiere decir que sigue oculta
            // todos estos comentarios lo hice a mano para entender el codigo
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


        System.out.println("Palabra: " + palabraOculta);
        System.out.println("Vidas restantes: " + vidasJugador);
    }

    private Boolean validarInputLetra(String input) {
        return input.length() == 1;
    }

    private Character getCharacterFromInput(String input) {

        char caracter;
        if (input.length() == 1) {
            caracter = input.charAt(0);
        } else
            return null;
        return caracter;
    }

    public Character pedirLetra() {
        Character letra = null;
        do {
            System.out.println("Ingrese una letra");
            String input = scanner.nextLine();

            if (validarInputLetra(input)) {
                if (palabraModoOculto.contains(input)){
                    System.out.println("Ya ingresaste esa letra, por favor ingrese otra");
                } else {
                    letra = getCharacterFromInput(input);
                }
            } else {
                System.out.println("Error...Ingrese una letra valida");
            }
        } while (letra == null);
        return letra;
    }

    public Boolean getPlayAgain() {
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

    public void addLetra(Character letra) {
        if (!this.letrasElegidas.contains(letra)) {
            this.letrasElegidas.add(letra);
            this.palabraModoOculto = this.getPalabraModoOculto();
        }
    }

    public Boolean calcularEstadoDelJuego(String letra) {

        if (palabraEnJuego.contains(letra)) {
            if (palabraModoOculto.equals(palabraEnJuego)) {
                System.out.println("¡Felicidades, ganaste el juego!, La palabra correcta era: " + palabraEnJuego);;
                return true;
            }
            return false;
        } else {
            vidasJugador--;
            if (vidasJugador <= 0) {
                System.out.println("¡Perdiste! La palabra correcta era: " + palabraEnJuego);
                return true;
            }
            return false;
        }
    }

    public void setPalabraModoOculto(String palabraModoOculto) {
        this.palabraModoOculto = palabraModoOculto;
    }

    public Juego() {
        this.palabraEnJuego = getPalabra();
        this.letrasElegidas = new ArrayList<>();
        this.vidasJugador = 5;
        this.scanner = new Scanner(System.in);
    }

}
