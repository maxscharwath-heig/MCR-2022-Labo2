package gui;

import entity.Client;

import javax.swing.*;

public class ClientDetailGUI extends JFrame {
    public ClientDetailGUI(Client client) {
        super("Detail of client #");
        var panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(new JLabel("Last name: " + "Scharwath"));
        panel.add(new JLabel("First name: " + "Maxime"));
        panel.add(new JLabel("Credits: 0"));
        panel.add(new JLabel("Nb miles: 0"));
        panel.add(new JLabel("Status: SILVER"));
        panel.add(new JLabel("Last action: "));
        add(panel);
        pack();
    }
}
