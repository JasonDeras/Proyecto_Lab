package ModeloJuego;

import java.util.LinkedList;
import Vista.CartaUno;

public class Jugador {

    private String name = null;
    private boolean isMyTurn = false;
    private boolean saidUNO = false;
    private LinkedList<CartaUno> myCards;

    private int playedCards = 0;

    public Jugador() {
        myCards = new LinkedList<CartaUno>();
    }

    public Jugador(String player) {
        setName(player);
        myCards = new LinkedList<CartaUno>();
    }

    public void setName(String newName) {
        name = newName;
    }

    public String getName() {
        return this.name;
    }

    public void obtainCard(CartaUno card) {
        myCards.add(card);
    }

    public LinkedList<CartaUno> getAllCards() {
        return myCards;
    }

    public int getTotalCards() {
        return myCards.size();
    }

    public boolean hasCard(CartaUno thisCard) {
        return myCards.contains(thisCard);
    }

    public void removeCard(CartaUno thisCard) {
        myCards.remove(thisCard);
        playedCards++;
    }

    public int totalPlayedCards() {
        return playedCards;
    }

    public void toggleTurn() {
        isMyTurn = (isMyTurn) ? false : true;
    }

    public boolean isMyTurn() {
        return isMyTurn;
    }

    public boolean hasCards() {
        return (myCards.isEmpty()) ? false : true;
    }

    public boolean getSaidUNO() {
        return saidUNO;
    }

    public void saysUNO() {
        saidUNO = true;
    }

    public void setSaidUNOFalse() {
        saidUNO = false;
    }

    public void setCards() {
        myCards = new LinkedList<CartaUno>();
    }
}
