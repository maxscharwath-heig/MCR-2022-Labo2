package gui;

import airport.Client;
import airport.Flight;
import airport.tickets.Business;
import airport.tickets.Economy;
import airport.tickets.FirstClass;
import airport.tickets.Ticket;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.LinkedList;

public class ClientManagerGUI extends JFrame {
    public ClientManagerGUI(LinkedList<Client> clients, LinkedList<Flight> flights) {
        super("Clients Manager");
        var panel = new JPanel();
        panel.setBorder(new EmptyBorder(20, 20, 20, 20));
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        var clientComboBox = new JComboBox<Client>();
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
            var comboBoxFlight = new JComboBox<Flight>();
            for (Flight flight: flights) {
                comboBoxFlight.addItem(flight);
            }
            flightPanel.add(comboBoxFlight);

            var comboBoxTickets = new JComboBox<Ticket>();

            updateTickets(flights.get(0), comboBoxTickets);

            comboBoxFlight.addItemListener(new ItemListener() {
                @Override
                public void itemStateChanged(ItemEvent e) {
                    Flight selectedFlight = (Flight) comboBoxFlight.getSelectedItem();
                    updateTickets(selectedFlight, comboBoxTickets);
                }
            });

            flightPanel.add(comboBoxTickets);

            var bookCashButton = new JButton("Book (cash)");
            var bookMilesButton = new JButton("Book (miles)");
            flightPanel.add(bookCashButton);
            flightPanel.add(bookMilesButton);
            panel.add(flightPanel);

            bookCashButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent actionEvent) {

                }
            });

            bookMilesButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent actionEvent) {

                }
            });
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

    private void updateTickets (Flight flight, JComboBox<Ticket> comboBoxTickets) {
        comboBoxTickets.removeAllItems();

        if (flight != null) {
            Ticket[] tickets = flight.getTickets();

            for (Ticket ticket: tickets) {
                comboBoxTickets.addItem(ticket);
            }
        }
    }
}
