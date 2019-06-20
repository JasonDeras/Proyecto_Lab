package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtomListener implements ActionListener {

    Servidor myServer;

    public void setServer(Servidor server) {
        myServer = server;
    }

    public void drawCard() {
        if (myServer.canPlay) {
            myServer.requestCard();
        }
    }

    public void sayUNO() {
        if (myServer.canPlay) {
            myServer.submitSaidUNO();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }

}
