package ModeloJuego;

import java.awt.*;
import java.util.*;
import javax.swing.*;
import ModeloCartas.*;
import Interfaces.*;
import View.*;

public class Juego implements ConstantesUno {

    private Jugador[] players;
    private boolean isOver;
    private int GAMEMODE;

    private AI pc;
    private Repartidor dealer;
    private Stack<UNOCard> cardStack;

    public Juego(int mode) {

        GAMEMODE = mode;

        String name = (GAMEMODE == manual) ? JOptionPane.showInputDialog("Jugador 1") : "PC";
        String name2 = JOptionPane.showInputDialog("Jugador 2");

        if (GAMEMODE == vsPC) {
            pc = new AI();
        }

        Jugador player1 = (GAMEMODE == vsPC) ? pc : new Jugador(name);
        Jugador player2 = new Jugador(name2);

        players = new Jugador[]{player1, player2};

        dealer = new Repartidor();
        cardStack = dealer.shuffle();
        dealer.spreadOut(players);

        isOver = false;
    }

    public Jugador[] getPlayers() {
        return players;
    }

    public UNOCard getCard() {
        return dealer.getCard();
    }

    public void removePlayedCard(UNOCard playedCard) {

        for (Jugador p : players) {
            if (p.hasCard(playedCard)) {
                p.removeCard(playedCard);

                if (p.getTotalCards() == 1 && !p.getSaidUNO()) {
                    infoPanel.setError(p.getName() + " OLVIDO DECIR UNO");
                    p.obtainCard(getCard());
                    p.obtainCard(getCard());
                } else if (p.getTotalCards() > 2) {
                    p.setSaidUNOFalse();
                }
            }
        }
    }

    public void drawCard(UNOCard topCard) {

        boolean canPlay = false;

        for (Jugador p : players) {
            if (p.isMyTurn()) {
                UNOCard newCard = getCard();
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
        for (Jugador p : players) {
            p.toggleTurn();
        }
        whoseTurn();
    }

    public void drawPlus(int times) {
        for (Jugador p : players) {
            if (!p.isMyTurn()) {
                for (int i = 1; i <= times; i++) {
                    p.obtainCard(getCard());
                }
            }
        }
    }

    public void whoseTurn() {

        for (Jugador p : players) {
            if (p.isMyTurn()) {
                infoPanel.updateText(p.getName() + "'s Turn");
                System.out.println(p.getName() + "'s Turn");
            }
        }
        infoPanel.setDetail(playedCardsSize(), remainingCards());
        infoPanel.repaint();
    }

    public boolean isOver() {

        if (cardStack.isEmpty()) {
            isOver = true;
            return isOver;
        }

        for (Jugador p : players) {
            if (!p.hasCards()) {
                isOver = true;
                break;
            }
        }

        return isOver;
    }

    public int remainingCards() {
        return cardStack.size();
    }

    public int[] playedCardsSize() {
        int[] nr = new int[2];
        int i = 0;
        for (Jugador p : players) {
            nr[i] = p.totalPlayedCards();
            i++;
        }
        return nr;
    }

    private boolean canPlay(UNOCard topCard, UNOCard newCard) {

        if (topCard.getColor().equals(newCard.getColor())
                || topCard.getValue().equals(newCard.getValue())) {
            return true;
        } else if (topCard.getType() == WILD) {
            return ((CartasEspeciales) topCard).getWildColor().equals(newCard.getColor());
        } else if (newCard.getType() == WILD) {
            return true;
        }
        return false;
    }

    public void checkUNO() {
        for (Jugador p : players) {
            if (p.isMyTurn()) {
                if (p.getTotalCards() == 1 && !p.getSaidUNO()) {
                    infoPanel.setError(p.getName() + " OLVIDO DECIR UNO");
                    p.obtainCard(getCard());
                    p.obtainCard(getCard());
                }
            }
        }
    }

    public void setSaidUNO() {
        for (Jugador p : players) {
            if (p.isMyTurn()) {
                if (p.getTotalCards() == 2) {
                    p.saysUNO();
                    infoPanel.setError(p.getName() + " DIJO UNO");
                }
            }
        }
    }

    public boolean isPCsTurn() {
        if (pc.isMyTurn()) {
            return true;
        }
        return false;
    }

    public void playPC(UNOCard topCard) {

        if (pc.isMyTurn()) {
            boolean done = pc.play(topCard);

            if (!done) {
                drawCard(topCard);
            }
        }
    }
}
