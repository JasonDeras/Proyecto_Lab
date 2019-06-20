package Logic;

import App.*;
import Elementos.*;

public class Juego {

    private enum Estado {
        CONTINUA, GANO, PERDIO
    };

    private Mazo mazo;
    private PilaDescarte pilaDeDescarte;
    private Jugador jugadorPersona;
    private Jugador jugadorPC;
    private Turno turnador;
    private String nombreGanador;
    private Estado estadoJuego;

    public Juego() {
        mazo = new Mazo();
        estadoJuego = Estado.CONTINUA;

        String nombrePersona = Pantalla.obtenerNombreJugadorPersona();

        jugadorPC = new Jugador("USER");
        jugadorPersona = new Jugador(nombrePersona);

        turnador = new Turno(jugadorPersona, jugadorPC);

        mazo.repartirCartas(jugadorPersona);
        mazo.repartirCartas(jugadorPC);

        pilaDeDescarte = new PilaDescarte(mazo.robarCartaDelMazo());
    }

    public void jugar() {
        while (estadoJuego == Estado.CONTINUA) {

            if (turnador.obtenerTurno().equals(jugadorPersona)) {
                Pantalla.mostrarInformacionDeJuego(jugadorPersona, pilaDeDescarte);

                turnador.cambiarTurno();
            } else {
                Pantalla.mostrarInformacionDeJuego(jugadorPC, pilaDeDescarte);
                turnador.cambiarTurno();
            }
        }
    }

    public String getGanador() {
        return this.nombreGanador;
    }

    public boolean hayGanador() {
        if (estadoJuego == Estado.CONTINUA) {
            return false;
        } else {
            return true;
        }
    }
}
