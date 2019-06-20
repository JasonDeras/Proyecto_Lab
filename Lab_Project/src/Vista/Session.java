package Vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import ModeloJuego.Repartidor;
import ModeloJuego.Juego;
import ModeloJuego.Jugador;
import Controlador.CartasListener;

public class Session extends JPanel {

    private PanelJugador player1;
    private PanelJugador player2;
    private PanelTabla table;

    private Juego game;

    public Session(Juego newGame, CartaUno firstCard) {
        setPreferredSize(new Dimension(960, 720));
        setBackground(new Color(30, 36, 40));
        setLayout(new BorderLayout());
        game = newGame;
        setPlayers();
        table = new PanelTabla(firstCard);
        player1.setOpaque(false);
        player2.setOpaque(false);
        add(player1, BorderLayout.NORTH);
        add(table, BorderLayout.CENTER);
        add(player2, BorderLayout.SOUTH);
    }

    private void setPlayers() {
        player1 = new PanelJugador(game.getPlayers()[0]);
        player2 = new PanelJugador(game.getPlayers()[1]);
    }

    public void refreshPanel() {
        player1.setCards();
        player2.setCards();
        table.revalidate();
        revalidate();
    }

    public void updatePanel(CartaUno playedCard) {
        table.setPlayedCard(playedCard);
        refreshPanel();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
    }
}
