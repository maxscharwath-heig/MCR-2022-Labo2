package gui;

import airport.Client;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.util.LinkedList;

public class StatusGUI extends JFrame implements Observer {

    private final JPanel panel;
    private final LinkedList<Client> clients;

    public StatusGUI(LinkedList<Client> clients) {
        super("Status");

        panel = new JPanel();
        panel.setBorder(new EmptyBorder(20, 20, 20, 20));
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        this.clients = clients;
        this.update();
        pack();
    }

    @Override
    public void update() {
        panel.removeAll();
        for (Client client: clients) {
            JLabel label = new JLabel(client.getFirstname() + " " + client.getLastname() + " " + client.getStatus());
            label.setForeground(client.getStatus().getColor());
            panel.add(label);
        }
        add(panel);
    }
}
