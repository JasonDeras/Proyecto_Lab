package Logic;

import Elementos.*;

import java.util.ArrayList;

public class Jugadas {

    private ArrayList<Integer> cartasDescarte;
    private Carta topeDescarte;
    private Jugador jugador;

    public Jugadas(Jugador jugador, Carta topeDescarte) {
        this.cartasDescarte = new ArrayList<Integer>();
        this.jugador = jugador;
    }

    public void asignarJugadasPosibles() {
        for (int cartaActual = 0; cartaActual < jugador.getCantidadDeCartas();
                cartaActual++) {
            cartasDescarte.add(indexCartaJugable(cartaActual));

        }

    }

    private Integer indexCartaJugable(int cartaActual) {
        String especialidadActual = jugador.getCarta(cartaActual).getEspecialidad();
        String colorActual = jugador.getCarta(cartaActual).getColor();
        int numeroActual = jugador.getCarta(cartaActual).getNumero();
        Integer cartaJugable = 0;
        if (especialidadActual == Carta.NO_ESPECIAL) {
            if (colorActual == topeDescarte.getColor()
                    || numeroActual == topeDescarte.getNumero()) {
                cartaJugable = cartaActual;
            }
        }
        if (numeroActual == Carta.NO_NUMERICA) {
            if (colorActual == Carta.NO_COLOR) {
                cartaJugable = cartaActual;
            } else if (colorActual == topeDescarte.getColor()) {
                cartaJugable = cartaActual;
            }

        }
        return cartaJugable;
    }

}
