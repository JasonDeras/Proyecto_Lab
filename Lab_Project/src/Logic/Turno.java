package Logic;

import Elementos.*;

public class Turno {

    private final int MAXIMOSJUGADORES = 2;
    private Jugador[] jugadores;
    private int turnoActual;

    public Turno(Jugador jugadorPersona, Jugador jugadorPC) {
        turnoActual = 0;
        jugadores = new Jugador[MAXIMOSJUGADORES];
        jugadores[turnoActual] = jugadorPersona;
        jugadores[turnoActual + 1] = jugadorPC;
    }

    public void cambiarTurno() {
        turnoActual++;
        if (turnoActual == (MAXIMOSJUGADORES)) {
            turnoActual = 0;
        }
    }

    public Jugador obtenerTurno() {
        return jugadores[turnoActual];
    }
}
