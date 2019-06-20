package ModeloCartas;

import java.awt.*;
import Vista.CartaUno;

public class ActionCarta extends CartaUno {

    private int Function = 0;

    public ActionCarta() {
    }

    public ActionCarta(Color cardColor, String cardValue) {
        super(cardColor, ACTION, cardValue);
    }
}
