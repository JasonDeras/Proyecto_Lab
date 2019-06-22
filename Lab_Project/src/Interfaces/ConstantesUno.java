package Interfaces;

import java.awt.Color;

public interface ConstantesUno {

    //Colores
    public static Color RED = new Color(192, 80, 77);
    public static Color BLUE = new Color(31, 73, 125);
    public static Color GREEN = new Color(0, 153, 0);
    public static Color YELLOW = new Color(255, 204, 0);
    public static Color BLACK = new Color(0, 0, 0);

    //Tipos
    public static int numeros = 1;
    public static int accion = 2;
    public static int especiales = 3;

    //Cartas Acciones 
    Character reverso = (char) 8634;
    Character salto = (char) Integer.parseInt("2718", 16);

    //Cartas Funciones
    String REVERSE = reverso.toString();
    String SKIP = salto.toString();
    String DRAW2PLUS = "2+";

    //Especiales Funciones
    String cambio_color = "W";
    String W_DRAW4PLUS = "4+";
}
