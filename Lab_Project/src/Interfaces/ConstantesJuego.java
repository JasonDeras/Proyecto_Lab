package Interfaces;

import java.awt.*;
import Controlador.*;
import Vista.*;

public interface ConstantesJuego extends ConstantesUno {

    int cartas_totales = 108;
    int primeramano = 8;

    Color[] colores_uno = {RED, BLUE, GREEN, YELLOW};
    Color cartas_especiales = BLACK;

    int[] cartas_numericas = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
    String[] tipos_acciones = {REVERSE, SKIP, DRAW2PLUS};
    String[] tipos_expeciales = {cambio_color, W_DRAW4PLUS};

    int vsPC = 1;
    int manual = 2;

    int[] GAMEMODES = {vsPC, manual};

    CartasListener CARDLISTENER = new CartasListener();
    ButtomListener BUTTONLISTENER = new ButtomListener();

    PanelInformatico infoPanel = new PanelInformatico();
}
