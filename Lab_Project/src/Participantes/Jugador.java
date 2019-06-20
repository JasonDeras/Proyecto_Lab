package Participantes;

import Elementos.*;

import java.util.*;

public class Jugador {

    private ArrayList<Carta> cartasEnMano = new ArrayList<Carta>();

    private static final int CARTAS_INICIALES = 7;

    private String nombre;

    public Jugador(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public final int obtenerCartasIniciales() {
        return CARTAS_INICIALES;
    }

    public void mostrarCartasEnMano() {
        for (int i = 0; i < cartasEnMano.size(); i++) {
            System.out.println(cartasEnMano.get(i));
        }
    }

    public void robarCarta(Carta carta) {
        cartasEnMano.add(carta);

    }

}
