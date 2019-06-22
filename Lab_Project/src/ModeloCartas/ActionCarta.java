package ModeloCartas;

import java.awt.*;
import Vista.CartaUno;

public class ActionCarta extends CartaUno {

    public ActionCarta() {
    }

    public ActionCarta(Color cardColor, String cardValue) {
        super(cardColor, accion, cardValue);
    }
}
