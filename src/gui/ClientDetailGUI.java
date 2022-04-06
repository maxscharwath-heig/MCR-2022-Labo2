package gui;

import airport.Client;

import javax.swing.*;

public class ClientDetailGUI extends JFrame implements Observer {
    private final JLabel lastNameLabel = new JLabel();
    private final JLabel firstNameLabel = new JLabel();
    private final JLabel creditLabel = new JLabel();
    private final JLabel nbMilesLabel = new JLabel();
    private final JLabel lastActionLabel = new JLabel();
    private final Client client;


    public ClientDetailGUI(Client client) {
        super("Detail of client #" + client.getId());
        this.client = client;
        client.attach(this);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        var panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(lastNameLabel);
        panel.add(firstNameLabel);
        panel.add(creditLabel);
        panel.add(nbMilesLabel);
        panel.add(lastActionLabel);
        update();
        add(panel);
        pack();
    }

    @Override
    public void dispose() {
        super.dispose();
        client.detach(this);
    }

    @Override
    public void update() {
        this.lastNameLabel.setText("Last name: " + client.getLastname());
        this.firstNameLabel.setText("First name: " + client.getFirstname());
        this.creditLabel.setText("Credits: " + client.getCredits());
        this.nbMilesLabel.setText("Nb miles: " + client.getMiles());
        this.lastActionLabel.setText("Last action: ");
    }
}
