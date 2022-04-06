package gui;

import airport.Client;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

public class ClientManagerGUI extends JFrame {
    public ClientManagerGUI(LinkedList<Client> clients) {
        super("Clients Manager");
        var panel = new JPanel();
        panel.setBorder(new EmptyBorder(20, 20, 20, 20));
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        var clientComboBox = new JComboBox<>();
        {
            var clientPanel = new JPanel();
            clientPanel.add(new JLabel("Client"));
            for (Client c : clients) {
                clientComboBox.addItem(c);
            }
            clientPanel.add(clientComboBox);
            var button = new JButton("Details");
            clientPanel.add(button);
            panel.add(clientPanel);

            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (clientComboBox.getSelectedItem() != null) {
                        new ClientDetailGUI((Client) clientComboBox.getSelectedItem()).setVisible(true);
                    }
                }
            });
        }
        {
            var creditPanel = new JPanel();
            creditPanel.add(new JLabel("Credit"));
            var numberField = new JTextField(10);
            creditPanel.add(numberField);
            var button = new JButton("Add");
            creditPanel.add(button);
            panel.add(creditPanel);
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    var client = (Client) clientComboBox.getSelectedItem();
                    if (client != null) {
                        client.addCredit(Integer.parseInt(numberField.getText()));
                    }
                }
            });
        }
        {
            var flightPanel = new JPanel();
            flightPanel.add(new JLabel("Flight"));
            var flightComboBox = new JComboBox<>();
            flightComboBox.addItem("Flight 1");
            flightComboBox.addItem("Flight 2");
            flightComboBox.addItem("Flight 3");
            flightPanel.add(flightComboBox);
            var bookCashButton = new JButton("Book (cash)");
            var bookMilesButton = new JButton("Book (miles)");
            flightPanel.add(bookCashButton);
            flightPanel.add(bookMilesButton);
            panel.add(flightPanel);
        }
        {
            var bottomPanel = new JPanel();
            var statusButton = new JButton("Statuses");
            var exitButton = new JButton("Quit");
            bottomPanel.add(statusButton);
            bottomPanel.add(exitButton);
            panel.add(bottomPanel);

            statusButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent actionEvent) {
                    new StatusGUI(clients).setVisible(true);
                }
            });

            exitButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    System.exit(0);
                }
            });
        }
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        add(panel);
        pack();
    }
}
