package Vista;

import java.awt.*;
import javax.swing.*;
import ModeloCartas.*;
import Interfaces.*;

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
        if (playedCard.getType() == especiales) {
            background = ((CartasEspeciales) playedCard).getWildColor();
        } else {
            background = playedCard.getColor();
        }
        table.setBackground(background);
    }
}
