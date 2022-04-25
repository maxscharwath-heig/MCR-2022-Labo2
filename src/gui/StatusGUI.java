package gui;

import airport.Client;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.*;

public class StatusGUI extends ObserverWindow {
    private final Map<Integer, JLabel> labels;

    public StatusGUI(LinkedList<Client> clients) {
        super("Statuses");
        setPreferredSize(new Dimension(350, 200));
        setResizable(false);

        this.labels = new HashMap<>();

        // Attach clients
        Collections.sort(clients);
        super.attach(clients);

        // Build panel
        JPanel panel = new JPanel();
        panel.setBorder(new EmptyBorder(20, 20, 20, 20));
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        for (Client client : clients) {
            JLabel label = new JLabel(client + " " + client.getStatus());
            label.setForeground(client.getStatus().getColor());
            panel.add(label);
            labels.put(client.getId(), label);
        }

        JScrollPane pane = new JScrollPane(panel);
        add(pane);
        pack();
    }

    @Override
    public void update(Subject subject) {
        // Refresh the label of the updated client
        Client client = (Client) subject;
        JLabel label = labels.get(client.getId());
        label.setText(client + " " + client.getStatus());
        label.setForeground(client.getStatus().getColor());
    }
}
