package Controlador;

import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import Vista.CartaUno;

public class CartasListener extends MouseAdapter {

    CartaUno carta;
    Servidor ser;

    public void setServer(Servidor server) {
        ser = server;
    }

    public void mousePressed(MouseEvent e) {
        carta = (CartaUno) e.getSource();
        try {
            if (ser.puedejugar) {
                ser.playThisCard(carta);
            }
        } catch (NullPointerException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        super.mouseEntered(e);

        carta = (CartaUno) e.getSource();
        Point p = carta.getLocation();
        p.y -= 20;
        carta.setLocation(p);
    }

    @Override
    public void mouseExited(MouseEvent e) {
        carta = (CartaUno) e.getSource();
        Point p = carta.getLocation();
        p.y += 20;
        carta.setLocation(p);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }
}
