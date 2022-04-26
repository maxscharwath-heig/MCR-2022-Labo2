package gui;

import airport.Client;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.*;

/**
 * Window showing clients statuses
 *
 * @author Nicolas Crausaz
 * @author Maxime Scharwath
 * @version 1.0
 * @date 2022-04-22
 */
public class StatusGUI extends ObserverWindow {
    private final Map<Integer, JLabel> labels;

    public StatusGUI(LinkedList<Client> clients) {
        super("Statuses");
        setPreferredSize(new Dimension(350, 200));
        setResizable(false);
        this.labels = new HashMap<>();

        // Attach clients
        Collections.sort(clients);
        attach(clients);

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

        // Make panel scrollable if too many clients
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
