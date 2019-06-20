package ModeloCartas;

import java.awt.*;
import java.util.*;

import Interfaces.*;
import ServerController.*;
import View.*;

public class Baraja implements GameConstants {

    private final ArrayList<CartasNumericas> numberCards;
    private final ArrayList<ActionCard> actionCards;
    private final ArrayList<CartasEspeciales> wildCards;

    private LinkedList<UNOCard> UNOcards;

    public Baraja() {

        numberCards = new ArrayList<CartasNumericas>();
        actionCards = new ArrayList<ActionCard>();
        wildCards = new ArrayList<CartasEspeciales>();

        UNOcards = new LinkedList<UNOCard>();

        addCards();
        addCardListener(CARDLISTENER);
    }

    private void addCards() {
        for (Color color : UNO_COLORS) {

            for (int num : UNO_NUMBERS) {
                int i = 0;
                do {
                    UNOcards.add(new NumberCard(color, Integer.toString(num)));
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
        for (UNOCard card : UNOcards) {
            card.addMouseListener(listener);
        }
    }

    public LinkedList<UNOCard> getCards() {
        return UNOcards;
    }
}
