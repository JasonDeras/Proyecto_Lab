package Interfaces;

import java.awt.*;

public interface InterfazCarta {

    int ancho = 50;
    int altura = 75;
    Dimension pequenio = new Dimension(ancho, altura);
    Dimension mediano = new Dimension(ancho * 2, altura * 2);
    Dimension grande = new Dimension(ancho * 3, altura * 3);

    Dimension tamaniocarta = mediano;

    int OFFSET = 71;

    void setColor(Color newColor);

    Color getColor();

    void setValue(String newValue);

    String getValue();

    void setType(int newType);

    int getType();
}
