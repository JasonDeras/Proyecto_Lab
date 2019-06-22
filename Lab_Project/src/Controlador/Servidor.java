package Controlador;

import java.awt.*;
import java.util.*;
import javax.swing.*;
import ModeloCartas.*;
import ModeloJuego.*;
import Interfaces.*;
import Vista.*;

public class Servidor implements ConstantesJuego {

    private Juego juego;
    private Session ses;
    private Stack<CartaUno> cartasjugadas;
    public boolean puedejugar;
    private int mode;

    public Servidor() {
        mode = requestMode();
        juego = new Juego(mode);
        cartasjugadas = new Stack<CartaUno>();
        CartaUno firstCard = juego.getCard();
        modifyFirstCard(firstCard);
        cartasjugadas.add(firstCard);
        ses = new Session(juego, firstCard);
        juego.whoseTurn();
        puedejugar = true;
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
        if (firstCard.getType() == especiales) {
            int random = new Random().nextInt() % 4;
            try {
                ((CartasEspeciales) firstCard).useWildColor(colores_uno[Math.abs(random)]);
            } catch (Exception ex) {
                System.out.println("something wrong with modifyFirstcard");
            }
        }
    }

    public Session getSession() {
        return this.ses;
    }

    public void playThisCard(CartaUno clickedCard) {
        if (!isHisTurn(clickedCard)) {
            infoPanel.setError("It's not your turn");
            infoPanel.repaint();
        } else {
            if (isValidMove(clickedCard)) {
                clickedCard.removeMouseListener(CARDLISTENER);
                cartasjugadas.add(clickedCard);
                juego.removePlayedCard(clickedCard);
                switch (clickedCard.getType()) {
                    case accion:
                        performAction(clickedCard);
                        break;
                    case especiales:
                        performWild((CartasEspeciales) clickedCard);
                        break;
                    default:
                        break;
                }
                juego.switchTurn();
                ses.updatePanel(clickedCard);
                checkResults();
            } else {
                infoPanel.setError("invalid move");
                infoPanel.repaint();

            }
            if (mode == vsPC && puedejugar) {
                if (juego.isPCsTurn()) {
                    juego.playPC(peekTopCard());
                }
            }
        }
    }

    private void checkResults() {
        if (juego.fin()) {
            puedejugar = false;
            infoPanel.updateText("GAME OVER");
        }
    }

    public boolean isHisTurn(CartaUno clickedCard) {
        for (Jugador p : juego.getPlayers()) {
            if (p.hasCard(clickedCard) && p.miturno()) {
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
        } else if (playedCard.getType() == especiales) {
            return true;
        } else if (topCard.getType() == especiales) {
            Color color = ((CartasEspeciales) topCard).getWildColor();
            if (color.equals(playedCard.getColor())) {
                return true;
            }
        }
        return false;
    }

    private void performAction(CartaUno actionCard) {
        if (actionCard.getValue().equals(DRAW2PLUS)) {
            juego.drawPlus(2);
        } else if (actionCard.getValue().equals(REVERSE)) {
            juego.switchTurn();
        } else if (actionCard.getValue().equals(SKIP)) {
            juego.switchTurn();
        }
    }

    private void performWild(CartasEspeciales functionCard) {
        if (mode == 1 && juego.isPCsTurn()) {
            int random = new Random().nextInt() % 4;
            functionCard.useWildColor(colores_uno[Math.abs(random)]);
        } else {
            ArrayList<String> colors = new ArrayList<String>();
            colors.add("RED");
            colors.add("BLUE");
            colors.add("GREEN");
            colors.add("YELLOW");
            String chosenColor = (String) JOptionPane.showInputDialog(null,
                    "Elija un color", "Wild Card Color",
                    JOptionPane.DEFAULT_OPTION, null, colors.toArray(), null);

            functionCard.useWildColor(colores_uno[colors.indexOf(chosenColor)]);
        }
        if (functionCard.getValue().equals(W_DRAW4PLUS)) {
            juego.drawPlus(4);
        }
    }

    public void requestCard() {
        juego.drawCard(peekTopCard());
        if (mode == vsPC && puedejugar) {
            if (juego.isPCsTurn()) {
                juego.playPC(peekTopCard());
            }
        }
        ses.refreshPanel();
    }

    public CartaUno peekTopCard() {
        return cartasjugadas.peek();
    }

    public void submitSaidUNO() {
        juego.setSaidUNO();
    }
}
