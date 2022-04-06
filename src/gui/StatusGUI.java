package gui;

import airport.Client;

import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;

public class StatusGUI extends JFrame {
    public StatusGUI(LinkedList<Client> clients) {
        setTitle("Status");
        var panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        {
            for (Client client: clients) {
                JLabel label = new JLabel(client.getFirstname() + " " + client.getLastname() + " ADD STATUS");
                label.setForeground(Color.orange); // TODO: get status color
                panel.add(label);

            }
        }
        add(panel);
        pack();
    }
}
