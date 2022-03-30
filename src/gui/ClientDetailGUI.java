package gui;

import airport.Client;

import javax.swing.*;

public class ClientDetailGUI extends JFrame {
    public ClientDetailGUI(Client client) {
        super("Detail of client #" + client.getId());
        var panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(new JLabel("Last name: " + client.getLastname()));
        panel.add(new JLabel("First name: " + client.getFirstname()));
        panel.add(new JLabel("Credits: " + client.getCredits()));
        panel.add(new JLabel("Nb miles: " + client.getMiles()));
        panel.add(new JLabel("Status: NEED STATUS"));
        panel.add(new JLabel("Last action: "));
        add(panel);
        pack();
    }
}
