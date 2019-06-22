package Controlador;

import java.awt.event.*;

public class ButtomListener implements ActionListener {

    Servidor ser;

    public void setServer(Servidor server) {
        ser = server;
    }

    public void drawCard() {
        if (ser.puedejugar) {
            ser.requestCard();
        }
    }

    public void sayUNO() {
        if (ser.puedejugar) {
            ser.submitSaidUNO();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }

}
