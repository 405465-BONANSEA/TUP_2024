package BlackJack;

import java.util.ArrayList;

public class Jugador
{
    private String nombre;
    private ArrayList<Carta> CartasEnMano; //lista dinamica
    private int ValorDeMano = 0;
    private int Exist_As = 0;
    private int puntuacion = 0;

    public Jugador(String nombre) {
        this.nombre = nombre;
        CartasEnMano = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public int getValorDeMano() {
        return ValorDeMano;
    }

    public int getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(int puntuacion) {
        this.puntuacion = puntuacion;
    }

    public void setValorDeMano(int valorDeMano) {
        ValorDeMano = valorDeMano;
    }

    public void AgregarCarta_aMano(Carta carta){
        if(carta != null) {
            CartasEnMano.add(carta);
        }
    }

    public int isExist_Ac() {
        return Exist_As;
    }

    public void PuntajeCartas(){ //Se calcula todo menos el AS osea el 1
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
            }
        }
        ValorDeMano = acumulador;
    }

    public int CheckAs(){
        int retorno=0;
        for (int i = 0; i < CartasEnMano.size(); i++) {
            if(CartasEnMano.get(i) != null && CartasEnMano.get(i).getNumero() == 1){
                retorno++;
            }
        }
        return retorno;
    }


    public String MostrarCartas(){
        String acumulador = "Cartas en Mano de " + nombre +": " + "\n";
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
