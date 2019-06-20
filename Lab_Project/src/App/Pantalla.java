package App;

import java.util.*;
import Elementos.*;

public class Pantalla {

    public static void mostrarMensajeInicial() {
        System.out.printf("\t\t\t%s\n", "Bienvenido al juego UNO");
        System.out.printf("\t\t\t\t%s\n", "1 - JUGAR ");
        System.out.printf("\t\t\t\t%s\n", "2 - SALIR ");
        System.out.println("Elija una opcion: ");
    }

    public static void mostrarInformacionDeJuego(Jugador jugador,
            PilaDescarte pilaDeDescarte) {
        System.out.println();
        System.out.printf("\t\tTurno de : %s\n", jugador.getNombre());
        System.out.println();
        System.out.println();
        System.out.printf("PilaDeDescarte: %s\n",
                pilaDeDescarte.getCartaDeDescarte());
        System.out.println();
        System.out.println("Cartas en la mano: ");
        mostrarCartasEnMano(jugador);
    }

    public static String obtenerNombreJugadorPersona() {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Introduzca su nombre");
        String nombre = entrada.next();
        entrada.close();
        return nombre;
    }

    private static void mostrarCartasEnMano(Jugador jugador) {
        for (int i = 1; i <= jugador.obtenerCARTAS_INICIALES(); i++) {
            System.out.printf("[%d] %s   ", i - 1, jugador.getCarta(i - 1));
            if (i % 4 == 0) {
                System.out.println();
            }
        }
        System.out.println();
        System.out.println();
        System.out.println();
    }

    public static void felicitarAlGanador() {
        System.out.println("FELICITACIONES!! ");
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("El Ganador es : ");
    }

}
