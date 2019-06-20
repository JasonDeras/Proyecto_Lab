package Controlador;

import java.awt.Point;
import java.awt.event.*;
import Vista.*;

public class CartasListener extends MouseAdapter {

    CartaUno sourceCard;
    Servidor myServer;

    public void setServer(Servidor server) {
        myServer = server;
    }

    public void mousePressed(MouseEvent e) {
        sourceCard = (CartaUno) e.getSource();

        try {
            if (myServer.canPlay) {
                myServer.playThisCard(sourceCard);
            }

        } catch (NullPointerException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        super.mouseEntered(e);

        sourceCard = (CartaUno) e.getSource();
        Point p = sourceCard.getLocation();
        p.y -= 20;
        sourceCard.setLocation(p);
    }

    @Override
    public void mouseExited(MouseEvent e) {
        sourceCard = (CartaUno) e.getSource();
        Point p = sourceCard.getLocation();
        p.y += 20;
        sourceCard.setLocation(p);
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

}
