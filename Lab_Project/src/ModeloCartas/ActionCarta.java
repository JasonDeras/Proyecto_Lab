package ModeloCartas;

import java.awt.*;

import View.UNOCard;

public class ActionCarta extends UNOCard {

    private int Function = 0;

    public ActionCarta() {
    }

    public ActionCarta(Color cardColor, String cardValue) {
        super(cardColor, ACTION, cardValue);
    }
}
