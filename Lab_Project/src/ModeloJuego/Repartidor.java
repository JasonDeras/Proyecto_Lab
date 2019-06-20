package ModeloJuego;

import java.awt.event.MouseEvent;
import java.util.LinkedList;
import java.util.Random;
import java.util.Stack;
import ModeloCartas.Baraja;
import Interfaces.ConstantesJuego;
import Vista.PanelJugador;
import Vista.CartaUno;

public class Repartidor implements ConstantesJuego {

    private Baraja cardDeck;
    private Stack<CartaUno> CardStack;

    public Repartidor() {
        this.cardDeck = new Baraja();
    }

    public Stack<CartaUno> shuffle() {
        LinkedList<CartaUno> DeckOfCards = cardDeck.getCards();
        LinkedList<CartaUno> shuffledCards = new LinkedList<CartaUno>();
        while (!DeckOfCards.isEmpty()) {
            int totalCards = DeckOfCards.size();
            Random random = new Random();
            int pos = (Math.abs(random.nextInt())) % totalCards;
            CartaUno randomCard = DeckOfCards.get(pos);
            DeckOfCards.remove(pos);
            shuffledCards.add(randomCard);
        }
        CardStack = new Stack<CartaUno>();
        for (CartaUno card : shuffledCards) {
            CardStack.add(card);
        }
        return CardStack;
    }

    public void spreadOut(Jugador[] players) {
        for (Jugador p : players) {
            p.obtainCard(CardStack.pop());
        }
    }

    public CartaUno getCard() {
        return CardStack.pop();
    }
}
