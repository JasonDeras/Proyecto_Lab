package ModeloCartas;

import java.awt.*;
import View.*;

public class CartasEspeciales extends UNOCard {

    private int Function = 0;
    private Color chosenColor;

    public CartasEspeciales() {
    }

    public CartasEspeciales(String cardValue) {
        super(BLACK, WILD, cardValue);
    }

    public void useWildColor(Color wildColor) {
        chosenColor = wildColor;
    }

    public Color getWildColor() {
        return chosenColor;
    }

}
