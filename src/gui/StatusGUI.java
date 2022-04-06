package gui;

import airport.Client;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.util.ArrayList;
import java.util.Comparator;
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
        this.updateGUI();
        pack();
    }

    private void updateGUI(){
        panel.removeAll();
        var sortedClients = new LinkedList<>(clients); //copy array
        sortedClients.sort(new Comparator<Client>() {
            @Override
            public int compare(Client c1, Client c2) {
                var c1Name = c1.getLastname() + " " + c1.getFirstname();
                var c2Name = c2.getLastname() + " " + c2.getFirstname();
                return c1Name.compareTo(c2Name);
            }
        });
        for (Client client: sortedClients) {
            JLabel label = new JLabel(client.getFirstname() + " " + client.getLastname() + " " + client.getStatus());
            label.setForeground(client.getStatus().getColor());
            panel.add(label);
        }
        add(panel);
    }

    @Override
    public void update(Subject subject) {
        System.out.println(subject.getClass());
        updateGUI();
    }
}
