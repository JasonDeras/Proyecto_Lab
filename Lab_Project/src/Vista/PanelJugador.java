package Vista;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import ModeloCartas.*;
import Interfaces.*;
import Controlador.*;
import ModeloJuego.*;
import Controlador.*;

public class PanelJugador extends JPanel implements ConstantesJuego {

    private Jugador player;
    private String name;

    private Box myLayout;
    private JLayeredPane cardHolder;
    private Box controlPanel;

    private JButton draw;
    private JButton sayUNO;
    private JLabel nameLbl;
    private MyButtonHandler handler;

    public PanelJugador(Jugador newPlayer) {
        setPlayer(newPlayer);

        myLayout = Box.createHorizontalBox();
        cardHolder = new JLayeredPane();
        cardHolder.setPreferredSize(new Dimension(600, 175));

        setCards();
        setControlPanel();

        myLayout.add(cardHolder);
        myLayout.add(Box.createHorizontalStrut(40));
        myLayout.add(controlPanel);
        add(myLayout);

        handler = new MyButtonHandler();
        draw.addActionListener(ButtomListener);
        draw.addActionListener(handler);

        sayUNO.addActionListener(ButtomListener);
        sayUNO.addActionListener(handler);
    }

    public void setCards() {
        cardHolder.removeAll();

        Point origin = getPoint(cardHolder.getWidth(), player.getTotalCards());
        int offset = calculateOffset(cardHolder.getWidth(),
                player.getTotalCards());

        int i = 0;
        for (CartaUno card : player.getAllCards()) {
            card.setBounds(origin.x, origin.y, card.tamaniocarta.width,
                    card.tamaniocarta.height);
            cardHolder.add(card, i++);
            cardHolder.moveToFront(card);
            origin.x += offset;
        }
        repaint();
    }

    public Jugador getPlayer() {
        return player;
    }

    public void setPlayer(Jugador player) {
        this.player = player;
        setPlayerName(player.getName());
    }

    public void setPlayerName(String playername) {
        this.name = playername;
    }

    private void setControlPanel() {
        draw = new JButton("Sacar");
        sayUNO = new JButton("Decir UNO");
        nameLbl = new JLabel(name);

        // style
        draw.setBackground(new Color(79, 129, 189));
        draw.setFont(new Font("Arial", Font.BOLD, 20));
        draw.setFocusable(false);

        sayUNO.setBackground(new Color(149, 55, 53));
        sayUNO.setFont(new Font("Arial", Font.BOLD, 20));
        sayUNO.setFocusable(false);

        nameLbl.setForeground(Color.WHITE);
        nameLbl.setFont(new Font("Arial", Font.BOLD, 15));

        controlPanel = Box.createVerticalBox();
        controlPanel.add(nameLbl);
        controlPanel.add(draw);
        controlPanel.add(Box.createVerticalStrut(15));
        controlPanel.add(sayUNO);
    }

    private int calculateOffset(int width, int totalCards) {
        int offset = 71;
        if (totalCards <= 8) {
            return offset;
        } else {
            double o = (width - 100) / (totalCards - 1);
            return (int) o;
        }
    }

    private Point getPoint(int width, int totalCards) {
        Point p = new Point(0, 20);
        if (totalCards >= 8) {
            return p;
        } else {
            p.x = (width - calculateOffset(width, totalCards) * totalCards) / 2;
            return p;
        }
    }

    class MyButtonHandler implements ActionListener {

        public void actionPerformed(ActionEvent e) {

            if (player.isMyTurn()) {

                if (e.getSource() == draw) {
                    ButtomListener.drawCard();
                } else if (e.getSource() == sayUNO) {
                    ButtomListener.sayUNO();
                }
            }
        }
    }
}
