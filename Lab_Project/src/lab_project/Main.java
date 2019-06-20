package lab_project;

import javax.swing.*;
import View.*;

public class Main {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JFrame frame = new MainFrame();
                frame.setVisible(true);
                frame.setResizable(false);
                frame.setLocation(200, 100);
                frame.pack();
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            }
        });
    }
}
