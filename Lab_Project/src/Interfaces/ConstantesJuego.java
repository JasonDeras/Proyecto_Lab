package Interfaces;

import java.awt.Color;
import javax.swing.*;
import Controlador.*;
import Vista.*;

public interface ConstantesJuego extends ConstantesUno {

    int total_cartas = 108;
    int primera_mano = 8;

    Color[] uno_colores = {rojo, azul, verde, amarillo};
    Color cartas_especiales_color = negro;

    int[] cartas_numericas = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
    String[] tiposaction = {REVERSE, SKIP, masdos};
    String[] tiposespeciales = {cambiocolor, mascuatro};

    int vsPC = 1;
    int manual = 2;

    int[] modosjuegos = {vsPC, manual};

    CartasListener CARDLISTENER = new CartasListener();
    ButtomListener BUTTONLISTENER = new ButtomListener();

    PanelInformatico infoPanel = new PanelInformatico();
}
