package ModeloCartas;

import java.awt.*;
import java.util.*;

import Interfaces.*;
import Controlador.*;
import Vista.*;

public class Baraja implements ConstantesJuego {

    private final ArrayList<CartasNumericas> numberCards;
    private final ArrayList<ActionCarta> actionCards;
    private final ArrayList<CartasEspeciales> wildCards;

    private LinkedList<CartaUno> UNOcards;

    public Baraja() {

        numberCards = new ArrayList<CartasNumericas>();
        actionCards = new ArrayList<ActionCarta>();
        wildCards = new ArrayList<CartasEspeciales>();

        UNOcards = new LinkedList<CartaUno>();

        addCards();
        addCardListener(CartasListener);
    }

    private void addCards() {
        for (Color color : UNO_COLORS) {

            for (int num : UNO_NUMBERS) {
                int i = 0;
                do {
                    UNOcards.add(new CartasNumericas(color, Integer.toString(num)));
                    i++;
                } while (num != 0 && i < 2);
            }

            //Create 24 ActionCards --> everything twice
            for (String type : ActionTypes) {
                for (int i = 0; i < 2; i++) {
                    UNOcards.add(new ActionCard(color, type));
                }
            }
        }

        for (String type : WildTypes) {
            for (int i = 0; i < 4; i++) {
                UNOcards.add(new WildCard(type));
            }
        }

    }

    public void addCardListener(MyCardListener listener) {
        for (CartaUno card : UNOcards) {
            card.addMouseListener(listener);
        }
    }

    public LinkedList<CartaUno> getCards() {
        return UNOcards;
    }
}
