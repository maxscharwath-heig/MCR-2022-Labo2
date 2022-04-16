package gui;

import airport.Client;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.util.Collections;
import java.util.LinkedList;

public class StatusGUI extends JFrame implements Observer {

    private final JPanel panel;
    private final LinkedList<Client> clients;

    public StatusGUI(LinkedList<Client> clients) {
        super("Statuses");

        panel = new JPanel();
        panel.setBorder(new EmptyBorder(20, 20, 20, 20));
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        this.clients = clients;
        for (Client c : clients) {
            c.attach(this);
        }
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        updateGUI();
    }

    private void updateGUI() {
        panel.removeAll();

        Collections.sort(clients);

        for (Client client : clients) {
            JLabel label = new JLabel(client.toString() + " " + client.getStatus());
            label.setForeground(client.getStatus().getColor());
            panel.add(label);
        }
        add(panel);
        pack();
    }

    @Override
    public void dispose() {
        super.dispose();
        for (Client c : clients) {
            c.detach(this);
        }
    }

    @Override
    public void update(Subject subject) {
        updateGUI();
    }
}
