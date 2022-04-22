package gui;

import airport.Client;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class ClientDetailGUI extends JFrame implements Observer {
    private final JLabel lastNameLabel = new JLabel();
    private final JLabel firstNameLabel = new JLabel();
    private final JLabel creditLabel = new JLabel();
    private final JLabel nbMilesLabel = new JLabel();
    private final JLabel statusLabel = new JLabel();
    private final JLabel lastActionLabel = new JLabel();
    private final Client client;

    public ClientDetailGUI(Client client) {
        super("Detail of client #" + client.getId());
        this.client = client;
        client.attach(this);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        var panel = new JPanel();
        panel.setBorder(new EmptyBorder(20, 20, 20, 20));
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
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
    public void dispose() {
        super.dispose();
        client.detach(this);
    }

    @Override
    public void update(Subject subject) {
        this.lastNameLabel.setText("Last name: " + client.getLastname());
        this.firstNameLabel.setText("First name: " + client.getFirstname());
        this.creditLabel.setText("Credits: " + client.getCredits());
        this.nbMilesLabel.setText("Nb miles: " + client.getMiles());
        this.statusLabel.setText("Status: " + client.getStatus());
        this.lastActionLabel.setText("Last action: " + client.getLastAction());
    }
}
