package Vista;

import Controlador.*;
import Interfaces.*;
import javax.swing.JFrame;
import Interfaces.*;
import ServerController.Server;

public class Principal extends JFrame implements ConstantesJuego {

    private Session mainPanel;
    private Server server;

    public Principal() {
        server = new Server();
        CartasListener.setServer(server);
        .setServer(server);

        mainPanel = server.getSession();
        add(mainPanel);
    }
}

