package ModeloJuego;

import java.awt.Color;
import java.awt.event.MouseEvent;
import ModeloCartas.CartasEspeciales;
import Interfaces.ConstantesJuego;
import Vista.CartaUno;

public class AI extends Jugador implements ConstantesJuego {

    public AI() {
        setName("PC");
        super.setCards();
    }

    public AI(Jugador player) {
    }

    public boolean play(CartaUno topCard) {
        boolean done = false;
        Color color = topCard.getColor();
        String value = topCard.getValue();
        
        if (topCard.getType() == especiales) {
            color = ((CartasEspeciales) topCard).getWildColor();
        }
        
        for (CartaUno card : getAllCards()) {
            
            if (card.getColor().equals(color) || card.getValue().equals(value)) {
                MouseEvent doPress = new MouseEvent(card, MouseEvent.MOUSE_PRESSED,
                        System.currentTimeMillis(),
                        (int) MouseEvent.MOUSE_EVENT_MASK, 5, 5, 1, true);
                card.dispatchEvent(doPress);

                MouseEvent doRelease = new MouseEvent(card, MouseEvent.MOUSE_RELEASED,
                        System.currentTimeMillis(),
                        (int) MouseEvent.MOUSE_EVENT_MASK, 5, 5, 1, true);
                card.dispatchEvent(doRelease);

                done = true;
                break;
            }
        }
        
        if (!done) {
            
            for (CartaUno card : getAllCards()) {
                if (card.getType() == especiales) {
                    MouseEvent doPress = new MouseEvent(card,
                            MouseEvent.MOUSE_PRESSED,
                            System.currentTimeMillis(),
                            (int) MouseEvent.MOUSE_EVENT_MASK, 5, 5, 1, true);
                    card.dispatchEvent(doPress);

                    MouseEvent doRelease = new MouseEvent(card, MouseEvent.MOUSE_RELEASED,
                            System.currentTimeMillis(),
                            (int) MouseEvent.MOUSE_EVENT_MASK, 5, 5, 1, true);
                    card.dispatchEvent(doRelease);

                    done = true;
                    break;
                }
            }
        }

        if (getTotalCards() == 1 || getTotalCards() == 2) {
            saysUNO();
        }

        return done;
    }
}
