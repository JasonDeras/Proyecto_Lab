package Interfaces;

import java.awt.*;

public interface ConstantesUno {

    public static Color rojo = new Color(192, 80, 77);
    public static Color azul = new Color(31, 73, 125);
    public static Color verde = new Color(0, 153, 0);
    public static Color amarillo = new Color(255, 204, 0);

    public static Color negro = new Color(0, 0, 0);

    public static int numeros = 1;
    public static int action = 2;
    public static int especiales = 3;

    Character charreverso = (char) 8634;
    Character charslato = (char) Integer.parseInt("2718", 16);
    
    String REVERSE = charreverso.toString();
    String SKIP = charslato.toString();
    String masdos = "2+";

    String cambiocolor = "W";
    String mascuatro = "4+";
}
