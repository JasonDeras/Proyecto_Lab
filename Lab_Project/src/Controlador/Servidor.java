package Controlador;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;
import java.util.Stack;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import ModeloCartas.CartasEspeciales;
import ModeloJuego.Juego;
import ModeloJuego.Jugador;
import Interfaces.ConstantesJuego;
import Vista.Session;
import Vista.CartaUno;

public class Servidor implements ConstantesJuego {

    private Juego game;
    private Session session;
    private Stack<CartaUno> playedCards;
    public boolean canPlay;
    private int mode;

    public Servidor() {
        mode = requestMode();
        game = new Juego(mode);
        playedCards = new Stack<CartaUno>();
        CartaUno firstCard = game.getCard();
        modifyFirstCard(firstCard);
        playedCards.add(firstCard);
        session = new Session(game, firstCard);
        game.whoseTurn();
        canPlay = true;
    }

    private int requestMode() {
        Object[] options = {"vs PC", "Manual", "Cancel"};
        int n = JOptionPane.showOptionDialog(null,
                "Seleccione un modo de juego", "Modo",
                JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE,
                null, options, options[0]);
        if (n == 2) {
            System.exit(1);
        }

        return GAMEMODES[n];
    }

    private void modifyFirstCard(CartaUno firstCard) {
        firstCard.removeMouseListener(CARDLISTENER);
        if (firstCard.getType() == WILD) {
            int random = new Random().nextInt() % 4;
            try {
                ((CartasEspeciales) firstCard).useWildColor(UNO_COLORS[Math.abs(random)]);
            } catch (Exception ex) {
                System.out.println("something wrong with modifyFirstcard");
            }
        }
    }

    public Session getSession() {
        return this.session;
    }

    public void playThisCard(CartaUno clickedCard) {

        if (!isHisTurn(clickedCard)) {
            infoPanel.setError("It's not your turn");
            infoPanel.repaint();
        } else {

            if (isValidMove(clickedCard)) {

                clickedCard.removeMouseListener(CARDLISTENER);
                playedCards.add(clickedCard);
                game.removePlayedCard(clickedCard);

                // function cards ??
                switch (clickedCard.getType()) {
                    case ACTION:
                        performAction(clickedCard);
                        break;
                    case WILD:
                        performWild((CartasEspeciales) clickedCard);
                        break;
                    default:
                        break;
                }
                game.switchTurn();
                session.updatePanel(clickedCard);
                checkResults();
            } else {
                infoPanel.setError("invalid move");
                infoPanel.repaint();

            }
            if (mode == vsPC && canPlay) {
                if (game.isPCsTurn()) {
                    game.playPC(peekTopCard());
                }
            }
        }
    }

    private void checkResults() {

        if (game.isOver()) {
            canPlay = false;
            infoPanel.updateText("GAME OVER");
        }
    }

    public boolean isHisTurn(CartaUno clickedCard) {
        for (Jugador p : game.getPlayers()) {
            if (p.hasCard(clickedCard) && p.isMyTurn()) {
                return true;
            }
        }
        return false;
    }

    public boolean isValidMove(CartaUno playedCard) {
        CartaUno topCard = peekTopCard();
        if (playedCard.getColor().equals(topCard.getColor())
                || playedCard.getValue().equals(topCard.getValue())) {
            return true;
        } else if (playedCard.getType() == WILD) {
            return true;
        } else if (topCard.getType() == WILD) {
            Color color = ((CartasEspeciales) topCard).getWildColor();
            if (color.equals(playedCard.getColor())) {
                return true;
            }
        }
        return false;
    }

    private void performAction(CartaUno actionCard) {
        if (actionCard.getValue().equals(DRAW2PLUS)) {
            game.drawPlus(2);
        } else if (actionCard.getValue().equals(REVERSE)) {
            game.switchTurn();
        } else if (actionCard.getValue().equals(SKIP)) {
            game.switchTurn();
        }
    }

    private void performWild(CartasEspeciales functionCard) {
        if (mode == 1 && game.isPCsTurn()) {
            int random = new Random().nextInt() % 4;
            functionCard.useWildColor(UNO_COLORS[Math.abs(random)]);
        } else {
            ArrayList<String> colors = new ArrayList<String>();
            colors.add("RED");
            colors.add("BLUE");
            colors.add("GREEN");
            colors.add("YELLOW");
            String chosenColor = (String) JOptionPane.showInputDialog(null,
                    "Elija un color", "Wild Card Color",
                    JOptionPane.DEFAULT_OPTION, null, colors.toArray(), null);

            functionCard.useWildColor(UNO_COLORS[colors.indexOf(chosenColor)]);
        }
        if (functionCard.getValue().equals(W_DRAW4PLUS)) {
            game.drawPlus(4);
        }
    }

    public void requestCard() {
        game.drawCard(peekTopCard());
        if (mode == vsPC && canPlay) {
            if (game.isPCsTurn()) {
                game.playPC(peekTopCard());
            }
        }
        session.refreshPanel();
    }

    public CartaUno peekTopCard() {
        return playedCards.peek();
    }

    public void submitSaidUNO() {
        game.setSaidUNO();
    }
}
