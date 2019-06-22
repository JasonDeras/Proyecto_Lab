package ModeloJuego;

import java.util.LinkedList;
import Vista.CartaUno;

public class Jugador {

    private String nombre = null;
    private boolean miturno = false;
    private boolean digouno = false;
    private LinkedList<CartaUno> miscartas;

    private int playedCards = 0;

    public Jugador() {
        miscartas = new LinkedList<CartaUno>();
    }

    public Jugador(String player) {
        setName(player);
        miscartas = new LinkedList<CartaUno>();
    }

    public void setName(String newName) {
        nombre = newName;
    }

    public String getName() {
        return this.nombre;
    }

    public void obtainCard(CartaUno card) {
        miscartas.add(card);
    }

    public LinkedList<CartaUno> getAllCards() {
        return miscartas;
    }

    public int getTotalCards() {
        return miscartas.size();
    }

    public boolean hasCard(CartaUno thisCard) {
        return miscartas.contains(thisCard);
    }

    public void removeCard(CartaUno thisCard) {
        miscartas.remove(thisCard);
        playedCards++;
    }

    public int totalPlayedCards() {
        return playedCards;
    }

    public void toggleTurn() {
        miturno = (miturno) ? false : true;
    }

    public boolean miturno() {
        return miturno;
    }

    public boolean hasCards() {
        return (miscartas.isEmpty()) ? false : true;
    }

    public boolean getSaidUNO() {
        return digouno;
    }

    public void saysUNO() {
        digouno = true;
    }

    public void setSaidUNOFalse() {
        digouno = false;
    }

    public void setCards() {
        miscartas = new LinkedList<CartaUno>();
    }
}
