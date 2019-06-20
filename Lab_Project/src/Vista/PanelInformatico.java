package Vista;

import java.awt.*;

import javax.swing.JPanel;

public class PanelInformatico extends JPanel {

    private String error;
    private String text;
    private int panelCenter;

    private int you = 0;
    private int pc = 0;
    private int rest = 0;

    public PanelInformatico() {
        setPreferredSize(new Dimension(275, 200));
        setOpaque(false);
        error = "";
        text = "Game Started";

        updateText(text);
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        panelCenter = getWidth() / 2;

        printMessage(g);
        printError(g);
        printDetail(g);
    }

    private void printError(Graphics g) {
        if (!error.isEmpty()) {
            Font adjustedFont = new Font("Calibri", Font.PLAIN, 25);

            FontMetrics fm = this.getFontMetrics(adjustedFont);
            int xPos = panelCenter - fm.stringWidth(error) / 2;

            g.setFont(adjustedFont);
            g.setColor(Color.red);
            g.drawString(error, xPos, 35);

            error = "";
        }
    }

    private void printMessage(Graphics g) {
        Font adjustedFont = new Font("Calibri", Font.BOLD, 25);

        FontMetrics fm = this.getFontMetrics(adjustedFont);
        int xPos = panelCenter - fm.stringWidth(text) / 2;

        g.setFont(adjustedFont);
        g.setColor(new Color(228, 108, 10));
        g.drawString(text, xPos, 75);
    }

    private void printDetail(Graphics g) {
        Font adjustedFont = new Font("Calibri", Font.BOLD, 25);
        FontMetrics fm = this.getFontMetrics(adjustedFont);
        g.setColor(new Color(127, 127, 127));

        String text = "Played Cards";
        int xPos = panelCenter - fm.stringWidth(text) / 2;

        g.setFont(adjustedFont);
        g.drawString(text, xPos, 120);

        text = "Remaining: " + rest;
        xPos = panelCenter - fm.stringWidth(text) / 2;
        g.drawString(text, xPos, 180);

        adjustedFont = new Font("Calibri", Font.PLAIN, 20);
        g.setFont(adjustedFont);
        fm = this.getFontMetrics(adjustedFont);

        text = "You : " + you + "  PC : " + pc;
        xPos = panelCenter - fm.stringWidth(text) / 2;
        g.drawString(text, xPos, 140);

        text = String.valueOf(rest);
        xPos = panelCenter - fm.stringWidth(text) / 2;
    }

    public void updateText(String newText) {
        text = newText;
    }

    public void setError(String errorMgs) {
        error = errorMgs;
    }

    public void setDetail(int[] playedCards, int remaining) {
        you = playedCards[1];
        pc = playedCards[0];
        rest = remaining;
    }
}
