package App;

import Logic.Juego;

import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {
        Pantalla.mostrarMensajeInicial();
        Scanner entrada = new Scanner(System.in);
        int opcionIngresada = entrada.nextInt();
        if (opcionIngresada == 1) {
            Juego nuevaPartida = new Juego();
            nuevaPartida.jugar();
            if (nuevaPartida.hayGanador()) {
                Pantalla.felicitarAlGanador();
            }
        } else ;
        entrada.close();
    }
}
