package ModeloJuego;

import java.util.LinkedList;
import View.*;

public class Jugador {

    private String name = null;
    private boolean isMyTurn = false;
    private boolean saidUNO = false;
    private LinkedList<UNOCard> myCards;

    private int playedCards = 0;

    public Jugador() {
        myCards = new LinkedList<UNOCard>();
    }

    public Jugador(String player) {
        setName(player);
        myCards = new LinkedList<UNOCard>();
    }

    public void setName(String newName) {
        name = newName;
    }

    public String getName() {
        return this.name;
    }

    public void obtainCard(UNOCard card) {
        myCards.add(card);
    }

    public LinkedList<UNOCard> getAllCards() {
        return myCards;
    }

    public int getTotalCards() {
        return myCards.size();
    }

    public boolean hasCard(UNOCard thisCard) {
        return myCards.contains(thisCard);
    }

    public void removeCard(UNOCard thisCard) {
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
        myCards = new LinkedList<UNOCard>();
    }
}
