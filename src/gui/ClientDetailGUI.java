package gui;

import airport.Client;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class ClientDetailGUI extends ObserverWindow {
    private final JLabel lastNameLabel = new JLabel();
    private final JLabel firstNameLabel = new JLabel();
    private final JLabel creditLabel = new JLabel();
    private final JLabel nbMilesLabel = new JLabel();
    private final JLabel statusLabel = new JLabel();
    private final JLabel lastActionLabel = new JLabel();

    public ClientDetailGUI(Client client) {
        super("Detail of client #" + client.getId());
        setPreferredSize(new Dimension(350, 200));
        setResizable(false);

        attach(client);

        JPanel panel = new JPanel();
        panel.setBorder(new EmptyBorder(20, 20, 20, 20));
        panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
        panel.add(lastNameLabel);
        panel.add(firstNameLabel);
        panel.add(creditLabel);
        panel.add(nbMilesLabel);
        panel.add(statusLabel);
        panel.add(lastActionLabel);
        update(client);
        add(panel);
        pack();
    }

    @Override
    public void update(Subject subject) {
        Client client = (Client) subject;

        this.lastNameLabel.setText(String.format("Last name: %s", client.getLastname()));
        this.firstNameLabel.setText(String.format("First name: %s", client.getFirstname()));
        this.creditLabel.setText(String.format("Credits: %.2f$", client.getCredits()));
        this.nbMilesLabel.setText(String.format("Nb miles: %.1f miles", client.getMiles()));
        this.statusLabel.setText(String.format("Status: %s", client.getStatus()));
        this.statusLabel.setForeground(client.getStatus().getColor());
        //add html for line breakings
        this.lastActionLabel.setText(String.format("<html>Last action: %s</html>", client.getLastAction()));
    }
}
