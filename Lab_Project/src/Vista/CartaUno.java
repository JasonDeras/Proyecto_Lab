package Vista;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.AffineTransform;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.Border;

import Interfaces.InterfazCarta;
import Interfaces.ConstantesUno;

public abstract class CartaUno extends JPanel implements InterfazCarta, ConstantesUno {

    private Color cartacolor = null;
    private String valor = null;
    private int tipo = 0;
    private Border defaultBorder = BorderFactory.createEtchedBorder(WHEN_FOCUSED, Color.white, Color.gray);
    private Border focusedBorder = BorderFactory.createEtchedBorder(WHEN_FOCUSED, Color.black, Color.gray);

    public CartaUno() {
    }

    public CartaUno(Color cartacolor, int tipo, String valor) {
        this.cartacolor = cartacolor;
        this.tipo = tipo;
        this.valor = valor;
        this.setPreferredSize(tamaño_cartas);
        this.setBorder(defaultBorder);
        this.addMouseListener(new MouseHandler());
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        int cardWidth = tamaño_cartas.width;
        int cardHeight = tamaño_cartas.height;
        g2.setColor(Color.WHITE);
        g2.fillRect(0, 0, cardWidth, cardHeight);
        int margin = 5;
        g2.setColor(cartacolor);
        g2.fillRect(margin, margin, cardWidth - 2 * margin, cardHeight - 2 * margin);
        g2.setColor(Color.white);
        AffineTransform org = g2.getTransform();
        g2.rotate(45, cardWidth * 3 / 4, cardHeight * 3 / 4);
        g2.fillOval(0, cardHeight * 1 / 4, cardWidth * 3 / 5, cardHeight);
        g2.setTransform(org);
        Font defaultFont = new Font("Helvetica", Font.BOLD, cardWidth / 2 + 5);
        FontMetrics fm = this.getFontMetrics(defaultFont);
        int StringWidth = fm.stringWidth(valor) / 2;
        int FontHeight = defaultFont.getSize() * 1 / 3;
        g2.setColor(cartacolor);
        g2.setFont(defaultFont);
        g2.drawString(valor, cardWidth / 2 - StringWidth, cardHeight / 2 + FontHeight);
        defaultFont = new Font("Helvetica", Font.ITALIC, cardWidth / 5);
        fm = this.getFontMetrics(defaultFont);
        StringWidth = fm.stringWidth(valor) / 2;
        FontHeight = defaultFont.getSize() * 1 / 3;
        g2.setColor(Color.white);
        g2.setFont(defaultFont);
        g2.drawString(valor, 2 * margin, 5 * margin);
    }

    class MouseHandler extends MouseAdapter {

        public void mouseEntered(MouseEvent e) {
            setBorder(focusedBorder);
        }

        public void mouseExited(MouseEvent e) {
            setBorder(defaultBorder);
        }
    }

    public void setCardSize(Dimension newSize) {
        this.setPreferredSize(newSize);
    }

    public void setColor(Color newColor) {
        this.cartacolor = newColor;
    }

    public Color getColor() {
        return cartacolor;
    }

    @Override
    public void setValue(String valor) {
        this.valor = valor;
    }

    @Override
    public String getValue() {
        return valor;
    }

    @Override
    public void setType(int tipo) {
        this.tipo = tipo;
    }

    @Override
    public int getType() {
        return tipo;
    }
}
