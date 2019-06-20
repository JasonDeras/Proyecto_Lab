package Vista;

import javax.swing.JFrame;
import Interfaces.ConstantesJuego;
import Controlador.Servidor;

public class Principal extends JFrame implements ConstantesJuego {

    private Session mainPanel;
    private Servidor server;

    public Principal() {
        server = new Servidor();
        CARDLISTENER.setServer(server);
        BUTTONLISTENER.setServer(server);
        mainPanel = server.getSession();
        add(mainPanel);
    }
}
