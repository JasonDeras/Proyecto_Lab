package Elementos;

import java.util.Random;
import java.util.Stack;
import java.util.ArrayList;

public class Mazo {

    private Stack<Carta> mazoDeCartas = new Stack<Carta>();

    private ArrayList<Carta> paquete = new ArrayList<Carta>();

    private static final int CARTAS_COLOR_CON_CERO = 40;

    private static final int CARTAS_COLOR_SIN_CERO = 36;

    private static final Random numerosAleatorios = new Random();

    public Mazo() {
        crearMazo();

    }

    private void crearMazo() {
        this.armarMazo();

        for (int i = 0; i < paquete.size(); i++) {
            Carta aniadir = paquete.get(i);
            mazoDeCartas.push(aniadir);
        }
    }

    private void armarMazo() {
        this.generarListaMazoCompleto();
        this.barajar();
    }

    private void generarListaMazoCompleto() {
        this.generarListaMazoSimple();
        String[] color = {"Rojo", "Amarillo", "Azul", "Verde"};
        int[] numero = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        String[] especialesCuadruples = {"ROBAR_DOS", "CAMBIO_DE_RONDA", "SALTEAR"};
        String[] especialesDobles = {"CAMBIO_COLOR", "ROBAR_CUATRO"};
        for (int cuenta = 0; cuenta < CARTAS_COLOR_SIN_CERO; cuenta++) {
            paquete.add(new Carta(color[cuenta / 9], numero[cuenta % 9]));
        }
        for (int i = 0; i < 12; i++) {
            paquete.add(new Carta(color[i / 3], especialesCuadruples[i % 3]));
        }
        for (int j = 0; j < 4; j++) {
            paquete.add(new Carta(especialesDobles[j % 2]));
        }
    }

    private void generarListaMazoSimple() {
        String[] color = {"Rojo", "Amarillo", "Azul", "Verde"};
        int[] numero = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        String[] especialesCuadruples = {"ROBAR_DOS", "CAMBIO_DE_RONDA", "SALTEAR"};
        String[] especialesDobles = {"CAMBIO_COLOR", "ROBAR_CUATRO"};
        for (int cuenta = 0; cuenta < CARTAS_COLOR_CON_CERO; cuenta++) {
            paquete.add(new Carta(color[cuenta / 10], numero[cuenta % 10]));
        }
        for (int i = 0; i < 12; i++) {
            paquete.add(new Carta(color[i / 3], especialesCuadruples[i % 3]));
        }
        for (int j = 0; j < 4; j++) {
            paquete.add(new Carta(especialesDobles[j % 2]));
        }
    }

    private void barajar() {
        for (int primera = 0; primera < paquete.size(); primera++) {
            int segunda = numerosAleatorios.nextInt(paquete.size());
            Carta temporal = paquete.get(primera);
            paquete.set(primera, paquete.get(segunda));
            paquete.set(segunda, temporal);
        }
    }

    public void mostrarMazo() {
        while (!mazoDeCartas.isEmpty()) {
            System.out.println(mazoDeCartas.pop());
        }
        System.out.println(paquete.size());
    }

    public Carta robarCartaDelMazo() {
        Carta alfa = mazoDeCartas.pop();
        return alfa;
    }

    public void repartirCartas(Jugador jugador) {
        int repartidas = 0;
        while (repartidas < jugador.obtenerCARTAS_INICIALES()) {
            jugador.robarCarta(this.robarCartaDelMazo());
            repartidas++;
        }
    }

    public int cartasQueQuedan() {
        return mazoDeCartas.size();
    }

}
