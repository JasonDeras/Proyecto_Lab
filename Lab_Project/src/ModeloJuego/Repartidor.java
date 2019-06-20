package ModeloJuego;

import java.util.*;
import ModeloCartas.*;
import Interfaces.*;
import View.*;
import View.*;

public class Repartidor implements ConstantesJuego {

    private Baraja cardDeck;
    private Stack<UNOCard> CardStack;

    public Repartidor() {
        this.cardDeck = new Baraja();
    }

    public Stack<UNOCard> shuffle() {

        LinkedList<UNOCard> DeckOfCards = cardDeck.getCards();
        LinkedList<UNOCard> shuffledCards = new LinkedList<UNOCard>();

        while (!DeckOfCards.isEmpty()) {
            int totalCards = DeckOfCards.size();

            Random random = new Random();
            int pos = (Math.abs(random.nextInt())) % totalCards;

            UNOCard randomCard = DeckOfCards.get(pos);
            DeckOfCards.remove(pos);
            shuffledCards.add(randomCard);
        }

        CardStack = new Stack<UNOCard>();
        for (UNOCard card : shuffledCards) {
            CardStack.add(card);
        }

        return CardStack;
    }

    public void spreadOut(Jugador[] players) {

        for (int i = 1; i <= primera_mano; i++) {
            for (Jugador p : players) {
                p.obtainCard(CardStack.pop());
            }
        }
    }

    public UNOCard getCard() {
        return CardStack.pop();
    }
}
