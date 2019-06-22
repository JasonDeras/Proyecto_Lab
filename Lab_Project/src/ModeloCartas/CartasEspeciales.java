package ModeloCartas;

import java.awt.*;
import Vista.*;

public class CartasEspeciales extends CartaUno {

    private Color chosenColor;

    public CartasEspeciales() {
    }

    public CartasEspeciales(String cardValue) {
        super(BLACK, especiales, cardValue);
    }

    public void useWildColor(Color wildColor) {
        chosenColor = wildColor;
    }

    public Color getWildColor() {
        return chosenColor;
    }

}
