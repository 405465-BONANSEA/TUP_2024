package BlackJack;

import java.util.ArrayList;

public class Croupier
{
    private static Croupier Instance = null;
    private ArrayList<Carta> CartasEnMano;
    private int ValorDeMano = 0;
    private int Exist_As = 0;
    private int puntuacion = 0;

    private Croupier(){
        CartasEnMano = new ArrayList<>();
    }

    public ArrayList<Carta> getCartasEnMano() {
        return CartasEnMano;
    }
    public int getValorDeMano() {
        return ValorDeMano;
    }

    public void setValorDeMano(int valorDeMano) {
        ValorDeMano = valorDeMano;
    }
    public int getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(int puntuacion) {
        this.puntuacion = puntuacion;
    }


    //Singleton
    public static Croupier getInstance(){
        if(Instance == null){
            Instance = new Croupier();
        }

        return Instance;
    }

    public void AgregarCarta_aMano(Carta carta){
        if(carta != null) {
            CartasEnMano.add(carta);
        }
    }

    public void PuntajeCartas(){
        int acumulador = 0;
        int ValorCarta = 0;
        for (int i = 0; i < CartasEnMano.size(); i++)
        {
            if(CartasEnMano.get(i) != null) {

                ValorCarta = CartasEnMano.get(i).getNumero();


                if(ValorCarta < 10 && ValorCarta > 1){
                    acumulador += ValorCarta;
                } else if (ValorCarta >= 10 && ValorCarta <= 13) {
                    acumulador +=10;
                }

                if(CartasEnMano.get(i).getNumero() == 1)
                {
                    while (true){
                        int tempSuma = 0;
                        tempSuma = getValorDeMano() + 11;
                        if(tempSuma < 21){
                            acumulador +=11;
                            break;
                        } else if (tempSuma >= 21) {
                            acumulador +=1;
                            break;
                        }
                    }
                }
            }
        }
        ValorDeMano = acumulador;
    }

    public String MostrarCartas(){
        String acumulador = "Cartas en Mano de Croupier: " + "\n";
        for (int i = 0; i < CartasEnMano.size(); i++) {
            acumulador += " " + CartasEnMano.get(i).toString() + "\n";
        }

        return acumulador;
    }

    public void LimpiarMano()
    {
        CartasEnMano.clear();
    }
}
