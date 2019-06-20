package ModeloCartas;

import java.awt.*;
import Vista.*;

public class CartasNumericas extends CartaUno {

    public CartasNumericas() {
    }

    public CartasNumericas(Color cardColor, String cardValue) {
        super(cardColor, NUMBERS, cardValue);
    }

}
