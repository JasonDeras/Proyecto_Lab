package Vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.LayoutManager;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import ModeloCartas.CartasEspeciales;
import Interfaces.ConstantesJuego;
import Interfaces.ConstantesUno;

public class PanelTabla extends JPanel implements ConstantesJuego {

    private CartaUno topCard;
    private JPanel table;

    public PanelTabla(CartaUno firstCard) {
        setOpaque(false);
        setLayout(new GridBagLayout());
        topCard = firstCard;
        table = new JPanel();
        table.setBackground(new Color(64, 64, 64));
        setTable();
        setComponents();
    }

    private void setTable() {
        table.setPreferredSize(new Dimension(500, 200));
        table.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 0;
        table.add(topCard, c);
    }

    private void setComponents() {
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 0;
        c.insets = new Insets(0, 130, 0, 45);
        add(table, c);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.anchor = GridBagConstraints.LINE_END;
        c.gridwidth = GridBagConstraints.REMAINDER;
        c.gridx = 1;
        c.gridy = 0;
        c.insets = new Insets(0, 1, 0, 1);
        add(infoPanel, c);
    }

    public void setPlayedCard(CartaUno playedCard) {
        table.removeAll();
        topCard = playedCard;
        setTable();
        setBackgroundColor(playedCard);
    }

    public void setBackgroundColor(CartaUno playedCard) {
        Color background;
        if (playedCard.getType() == WILD) {
            background = ((CartasEspeciales) playedCard).getWildColor();
        } else {
            background = playedCard.getColor();
        }
        table.setBackground(background);
    }
}
