package lab_project;

import javax.swing.*;
import Vista.Principal;

public class Main {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JFrame frame = new Principal();
                frame.setVisible(true);
                frame.setResizable(false);
                frame.setLocation(200, 100);
                frame.pack();
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            }
        });
    }
}
