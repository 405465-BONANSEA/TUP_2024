package BlackJack;

import java.util.Scanner;

public class Juego_BlackJack {
    private static Juego_BlackJack Instance = null;
    private Jugador _Jugador;
    private Croupier _Croupier;
    private Mazo _Mazo;
    private Scanner sc = new Scanner(System.in);
    private String Ganador = "";
    private int tempValorAs = 0;
    private int tempValorManoJugador = 0;

    private Juego_BlackJack(Jugador _jugador) {
        this._Jugador = _jugador;
        _Mazo = new Mazo();
        _Mazo.MezlarCartas();
        _Croupier = Croupier.getInstance();

        System.out.println("-------------------Comienzo de Juego-----------------------");
        boolean ronda = true;

        /*
        Repartición de cartas, el croupier/dealer, reparte 2 cartas a el jugador.
        luego el se repartira la primera carta boca arriba y segunda boca abajo.

        El jugador puede tomar decisiones:  1-Plantarse -> se queda con las cartas que tiene
                                            2-Pedir carta->el croupier le da otra carta
        -----Cuando el jugador se plante-----
        el croupier revelara la carta boca abajo: Croupier gana si tiene puntuación cercana a 21
                                                  Croupier pierde si se pasa de 21
                                                  Si el Croupier tiene menos puntuación que el jugador, sacara una o más cartas hasta superar al jugador o pasarse de 21

        Las reglas del blackjack más y con mas variantes
        */
        while (true) {
            System.out.println("Repartiendo . . .");

            //Cartas para el jugador
            _Jugador.AgregarCarta_aMano(_Mazo.TomarCarta_delMazo());
            _Jugador.AgregarCarta_aMano(_Mazo.TomarCarta_delMazo());

            //Cartas para el Croupier
            Carta carta;

            _Croupier.AgregarCarta_aMano(carta = _Mazo.TomarCarta_delMazo());
            _Croupier.AgregarCarta_aMano(_Mazo.TomarCarta_delMazo());

            //Fin de Repartición

            while (ronda) {
                _Croupier.PuntajeCartas();
                _Jugador.PuntajeCartas();

                System.out.println("--------------------------------------------" + "\n"
                        + "Carta que el crupier muestra: " + "\n"
                        + carta.toString());
                System.out.println("Puntuación: " + carta.getNumero() + "/21");
                System.out.println("--------------------------------------------");

                System.out.println(_Jugador.MostrarCartas());

                CheckAStemp();

                tempValorManoJugador = _Jugador.getValorDeMano() + tempValorAs;

                System.out.println("Puntuación: " + tempValorManoJugador + "/21");


                if (tempValorManoJugador <= 21) {
                    while (true) {
                        System.out.println("Pedir o Plantarse");
                        String decision = sc.nextLine();

                        if (decision.equalsIgnoreCase("Pedir")) {
                            _Jugador.AgregarCarta_aMano(_Mazo.TomarCarta_delMazo());
                            break;
                        } else if (decision.equalsIgnoreCase("Plantarse")) {
                            //Turno Crupier y verificar quien gana
                            _Jugador.setValorDeMano(tempValorManoJugador);
                            Plantarse();
                            ronda = false;
                            break;
                        } else {
                            System.out.println("Decisión invalida");
                        }
                    }
                } else if (_Jugador.getValorDeMano() > 21) {
                    System.out.println("--------------------------------------------" + "\n" +
                            _Croupier.MostrarCartas());
                    System.out.println("Puntuación: " + _Croupier.getValorDeMano() + "/21");
                    System.out.println("--------------------------------------------");
                    WinConditionFinal();
                    MensajeGanador();
                    ronda = false;
                }
            }

            while (true) {
                System.out.println("¿Desea jugar otra ronda? Si/No");
                String respuesta = sc.nextLine();
                if (respuesta.equalsIgnoreCase("No")) {

                    System.out.println("Partidas ganadas: " + _Jugador.getPuntuacion() + "\n"
                            + "Partidas perdidas: " + _Croupier.getPuntuacion());
                    Despedida();
                    break;

                } else if (respuesta.equalsIgnoreCase("Si")) {

                    Reiniciar();
                    ronda = true;
                    break;

                } else {

                    System.out.println("Su respuesta fue invalida");

                }
            }
        }
    }

    private void Despedida() {
        System.out.println("JUEGO FINALIZADO");
        System.exit(0);
    }


    public void MensajeGanador() {
        if (Ganador.equalsIgnoreCase("Casa")) {
            System.out.println("Gano la Casa");
        } else if (Ganador.equalsIgnoreCase("Jugador")) {
            System.out.println("Gano el Jugador");
        }
    }

    private void WinConditionFinal() {

        if (_Jugador.getValorDeMano() > 21) {
            Ganador = "Casa";
            _Croupier.setPuntuacion(+1);
        } else if (_Croupier.getValorDeMano() > 21) {
            Ganador = "Jugador";
            _Jugador.setPuntuacion(+1);
        } else if (_Jugador.getValorDeMano() == _Croupier.getValorDeMano()) { //En caso de empate gana la casa
            Ganador = "Casa";
            _Croupier.setPuntuacion(+1);
        } else if (_Jugador.getValorDeMano() <= 21 && _Jugador.getValorDeMano() > _Croupier.getValorDeMano()) {
            Ganador = "Jugador";
            _Jugador.setPuntuacion(+1);
        } else if (_Croupier.getValorDeMano() <= 21 && _Croupier.getValorDeMano() > _Jugador.getValorDeMano()) {
            Ganador = "Casa";
            _Croupier.setPuntuacion(+1);
        }
    }

    private void Plantarse() {
        while (true) {
            //Turno Croupier
            System.out.println("-----------------------------------");
            System.out.println(_Croupier.MostrarCartas());
            System.out.println("Puntuación: " + _Croupier.getValorDeMano() + "/21");
            System.out.println("-----------------------------------");

            if (_Croupier.getValorDeMano() > 21) {//Gano jugador
                WinConditionFinal();
                MensajeGanador();
                break;
            } else if (_Croupier.getValorDeMano() == 21) { //Gana Croupier
                WinConditionFinal();
                MensajeGanador();
                break;
            } else if (_Croupier.getValorDeMano() < 21 && _Croupier.getValorDeMano() >= _Jugador.getValorDeMano()) { //Gana Croupier
                WinConditionFinal();
                MensajeGanador();
                break;
            } else if (_Croupier.getValorDeMano() < 21 && _Croupier.getValorDeMano() <= _Jugador.getValorDeMano()) { //Croupier Saca carta
                _Croupier.AgregarCarta_aMano(_Mazo.TomarCarta_delMazo());
                _Croupier.PuntajeCartas();
            }
        }
    }

    private void CheckAStemp() { //Se calculara el puntaje temporal de todos los As en mano, pero no seran enviado al puntaje del jugador
        int As = _Jugador.CheckAs();
        tempValorAs = 0;

        for (int i = 1; i <= As; i++) {
            boolean valorAsValido = false;

            while (!valorAsValido) {
                System.out.println("Tiene " + i + " As en su mano.");
                System.out.println("¿Qué valor desea darle a As " + i + "?: 1 u 11");
                String valorAsStr = sc.nextLine();

                try {
                    int ValorAsInt = Integer.parseInt(valorAsStr);

                    if (ValorAsInt == 1 || ValorAsInt == 11) {
                        int tempSuma = _Jugador.getValorDeMano() + ValorAsInt;
                        if (tempSuma <= 21) {
                            tempValorAs = ValorAsInt;
                            valorAsValido = true;
                        } else {
                            System.out.println("No puede darle el valor " + ValorAsInt + " al As, ya que superaría 21.");
                        }
                    } else {
                        System.out.println("El valor " + ValorAsInt + " no es válido para un As.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Ingrese un valor numérico válido.");
                }
            }
        }
    }

    private void Reiniciar()
    {
        _Croupier.LimpiarMano();
        _Jugador.LimpiarMano();
        _Jugador.setValorDeMano(0);
        _Croupier.setValorDeMano(0);
        tempValorManoJugador =0;
        Ganador = "";
        _Mazo.ReiniciarMazo();
    }


    //singleton
    public static Juego_BlackJack getInstance(Jugador _jugador){
        if(Instance == null){
            Instance = new Juego_BlackJack(_jugador);
        }

        return Instance;
    }
}
