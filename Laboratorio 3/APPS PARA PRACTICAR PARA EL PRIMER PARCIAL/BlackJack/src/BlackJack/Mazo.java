package BlackJack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Mazo
{
    private List<Carta> cartas;
    public List<Carta> getCartas() {
        return cartas;
    }

    public Mazo() {
        cartas=new ArrayList<>(52);
        inicializarMazo();
    }

    //Mezclar mazo
    public void MezlarCartas()
    {
        Collections.shuffle(cartas);
    }

    private List<Carta> inicializarMazo()
    {
        for (Palo palo : Palo.values())
        {
            for (int j = 1; j < 14; j++)
            {
                cartas.add(new Carta(j, palo));
            }
        }

        System.out.println(cartas.toString());//borrar

        return cartas;
    }

    public Carta TomarCarta_delMazo(){
        Carta SigCarta = null;
        for (int i = 0; i < cartas.size(); i++)
        {
            if(cartas.get(i) != null)
            {
                SigCarta=cartas.get(i);
                cartas.remove(i);
                break;
            }
        }

        return SigCarta;
    }

    public void ReiniciarMazo()
    {
        for (int i = 0; i < cartas.size(); i++)
        {
            cartas.remove(i);
        }

        inicializarMazo();

        MezlarCartas();
    }

    public int CartasRestantes(){
        int contador = 0;

        for (int i = 0; i < cartas.size(); i++) {
            if(cartas.get(i) != null){
                contador++;
            }
        }

        return contador;
    }
}
