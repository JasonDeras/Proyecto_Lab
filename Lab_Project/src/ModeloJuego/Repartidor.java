package ModeloJuego;

import java.util.*;
import ModeloCartas.*;
import Interfaces.*;
import Vista.*;

public class Repartidor implements ConstantesJuego {

    private Baraja baraja;
    private Stack<CartaUno> barajar;

    public Repartidor() {
        this.baraja = new Baraja();
    }

    public Stack<CartaUno> shuffle() {
        LinkedList<CartaUno> DeckOfCards = baraja.getCards();
        LinkedList<CartaUno> shuffledCards = new LinkedList<CartaUno>();
        while (!DeckOfCards.isEmpty()) {
            int totalCards = DeckOfCards.size();
            Random random = new Random();
            int pos = (Math.abs(random.nextInt())) % totalCards;
            CartaUno randomCard = DeckOfCards.get(pos);
            DeckOfCards.remove(pos);
            shuffledCards.add(randomCard);
        }
        barajar = new Stack<CartaUno>();
        for (CartaUno card : shuffledCards) {
            barajar.add(card);
        }
        return barajar;
    }

    public void spreadOut(Jugador[] players) {
        for (Jugador p : players) {
            p.obtainCard(barajar.pop());
        }
    }

    public CartaUno getCard() {
        return barajar.pop();
    }
}
