package ModeloJuego;

import Interfaces.ConstantesJuego;
import java.awt.Color;
import java.util.LinkedList;
import java.util.Random;
import java.util.Stack;
import javax.swing.JOptionPane;
import ModeloCartas.*;
import Interfaces.ConstantesJuego;
import Vista.CartaUno;

public class Juego implements ConstantesJuego {

    private Jugador[] jugadores;
    private boolean fin;
    private int modos;
    private AI pc;
    private Repartidor repart;
    private Stack<CartaUno> baraja;

    public Juego(int mode) {
        modos = mode;
        String name = (modos == manual) ? JOptionPane.showInputDialog("Player 1") : "PC";
        String name2 = JOptionPane.showInputDialog("Player 2");
        if (modos == vsPC) {
            pc = new AI();
        }
        Jugador player1 = (modos == vsPC) ? pc : new Jugador(name);
        Jugador player2 = new Jugador(name2);
        player2.toggleTurn();
        jugadores = new Jugador[]{player1, player2};
        repart = new Repartidor();
        baraja = repart.shuffle();
        repart.spreadOut(jugadores);
        fin = false;
    }

    public Jugador[] getPlayers() {
        return jugadores;
    }

    public CartaUno getCard() {
        return repart.getCard();
    }

    public void removePlayedCard(CartaUno playedCard) {
        for (Jugador p : jugadores) {
            if (p.hasCard(playedCard)) {
                p.removeCard(playedCard);
                if (p.getTotalCards() == 1 && !p.getSaidUNO()) {
                    infoPanel.setError(p.getName() + " Forgot to say UNO");
                    p.obtainCard(getCard());
                    p.obtainCard(getCard());
                } else if (p.getTotalCards() > 2) {
                    p.setSaidUNOFalse();
                }
            }
        }
    }

    public void drawCard(CartaUno topCard) {
        boolean canPlay = false;
        for (Jugador p : jugadores) {
            if (p.miturno()) {
                CartaUno newCard = getCard();
                p.obtainCard(newCard);
                canPlay = canPlay(topCard, newCard);
                break;
            }
        }
        if (!canPlay) {
            switchTurn();
        }
    }

    public void switchTurn() {
        for (Jugador p : jugadores) {
            p.toggleTurn();
        }
        whoseTurn();
    }

    public void drawPlus(int times) {
        for (Jugador p : jugadores) {
            if (!p.miturno()) {
                for (int i = 1; i <= times; i++) {
                    p.obtainCard(getCard());
                }
            }
        }
    }

    public void whoseTurn() {
        for (Jugador p : jugadores) {
            if (p.miturno()) {
                infoPanel.updateText(p.getName() + "'s Turn");
                System.out.println(p.getName() + "'s Turn");
            }
        }
        infoPanel.setDetail(playedCardsSize(), remainingCards());
        infoPanel.repaint();
    }

    public boolean fin() {
        if (baraja.isEmpty()) {
            fin = true;
            return fin;
        }
        for (Jugador p : jugadores) {
            if (!p.hasCards()) {
                fin = true;
                break;
            }
        }
        return fin;
    }

    public int remainingCards() {
        return baraja.size();
    }

    public int[] playedCardsSize() {
        int[] nr = new int[2];
        int i = 0;
        for (Jugador p : jugadores) {
            nr[i] = p.totalPlayedCards();
            i++;
        }
        return nr;
    }

    private boolean canPlay(CartaUno topCard, CartaUno newCard) {
        if (topCard.getColor().equals(newCard.getColor())
                || topCard.getValue().equals(newCard.getValue())) {
            return true;
        } else if (topCard.getType() == especiales) {
            return ((CartasEspeciales) topCard).getWildColor().equals(newCard.getColor());
        } else if (newCard.getType() == especiales) {
            return true;
        }
        return false;
    }

    public void checkUNO() {
        for (Jugador p : jugadores) {
            if (p.miturno()) {
                if (p.getTotalCards() == 1 && !p.getSaidUNO()) {
                    infoPanel.setError(p.getName() + " Forgot to say UNO");
                    p.obtainCard(getCard());
                    p.obtainCard(getCard());
                }
            }
        }
    }

    public void setSaidUNO() {
        for (Jugador p : jugadores) {
            if (p.miturno()) {
                if (p.getTotalCards() == 2) {
                    p.saysUNO();
                    infoPanel.setError(p.getName() + " said UNO");
                }
            }
        }
    }

    public boolean isPCsTurn() {
        if (pc.miturno()) {
            return true;
        }
        return false;
    }

    public void playPC(CartaUno topCard) {
        if (pc.miturno()) {
            boolean done = pc.play(topCard);
            if (!done) {
                drawCard(topCard);
            }
        }
    }
}
