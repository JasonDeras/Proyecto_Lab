/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Elementos;

import java.util.ArrayList;

public class Jugador {

    private ArrayList<Carta> cartasEnMano;
    private static final int CARTAS_INICIALES = 7;
    private String nombre;
    private boolean jugadaRealizada;

    public Jugador(String nombre) {
        this.nombre = nombre;
        cartasEnMano = new ArrayList<Carta>();
    }

    public String getNombre() {
        return nombre;
    }

    public final int obtenerCARTAS_INICIALES() {
        return CARTAS_INICIALES;
    }

    public void robarCarta(Carta carta) {
        cartasEnMano.add(carta);

    }

    public int getCantidadDeCartas() {
        return this.cartasEnMano.size();
    }

    public Carta getCarta(int index) {
        return this.cartasEnMano.get(index);
    }

//	public Carta descartarse()
//	{
//		return Carta;
//	}
}
