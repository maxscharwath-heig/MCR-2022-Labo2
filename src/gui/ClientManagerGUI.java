package gui;

import airport.Client;
import airport.Flight;
import airport.tickets.Ticket;
import airport.transaction.CashTransaction;
import airport.transaction.MilesTransaction;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Objects;

/**
 * Main window of the airport's clients manager
 */
public class ClientManagerGUI extends JFrame {
    public ClientManagerGUI(LinkedList<Client> clients, LinkedList<Flight> flights) {
        super("Clients Manager");
        setPreferredSize(new Dimension(800, 300));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        var mainPanel = new JPanel();
        mainPanel.setBorder(new EmptyBorder(20, 20, 20, 20));
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        // Clients panel
        Collections.sort(clients);
        var clientComboBox = new JComboBox<Client>();
        var clientPanel = new JPanel();
        clientPanel.add(new JLabel("Client"));

        for (Client c : clients) {
            clientComboBox.addItem(c);
        }

        clientPanel.add(clientComboBox);
        var showClientbutton = new JButton("Details");
        clientPanel.add(showClientbutton);

        showClientbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (clientComboBox.getSelectedItem() != null) {
                    new ClientDetailGUI((Client) clientComboBox.getSelectedItem());
                }
            }
        });

        // Credits panel
        var creditPanel = new JPanel();
        creditPanel.add(new JLabel("Credit"));
        var numberField = new JTextField(10);
        creditPanel.add(numberField);
        var addCreditButton = new JButton("Add");
        creditPanel.add(addCreditButton);
        addCreditButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                var client = (Client) clientComboBox.getSelectedItem();
                if (client != null) {
                    if (!Objects.equals(numberField.getText(), "")) {
                        try {
                            int credits = Integer.parseInt(numberField.getText());
                            client.addCredit(credits);
                        } catch (RuntimeException n) {
                            client.setLastAction("Invalid credit provided");
                        }

                    }
                }
            }
        });

        // Flight panel
        Collections.sort(flights);
        var flightPanel = new JPanel();
        flightPanel.add(new JLabel("Flight"));
        var comboBoxFlight = new JComboBox<Flight>();

        for (Flight flight : flights) {
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
        mainPanel.add(flightPanel);

        bookCashButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Client selectedClient = (Client) clientComboBox.getSelectedItem();
                Flight selectedFlight = (Flight) comboBoxFlight.getSelectedItem();
                Ticket selectedTicket = (Ticket) comboBoxTickets.getSelectedItem();

                CashTransaction transact = new CashTransaction(selectedClient, selectedFlight, selectedTicket);
                transact.make();
            }
        });

        bookMilesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Client selectedClient = (Client) clientComboBox.getSelectedItem();
                Flight selectedFlight = (Flight) comboBoxFlight.getSelectedItem();
                Ticket selectedTicket = (Ticket) comboBoxTickets.getSelectedItem();

                MilesTransaction transact = new MilesTransaction(selectedClient, selectedFlight, selectedTicket);
                transact.make();
            }
        });

        // Statuses & quit panel
        var bottomPanel = new JPanel();
        var statusButton = new JButton("Statuses");
        var exitButton = new JButton("Quit");
        bottomPanel.add(statusButton);
        bottomPanel.add(exitButton);

        statusButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                new StatusGUI(clients);
            }
        });

        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });


        // Add every sub panels to panel
        mainPanel.add(clientPanel);
        mainPanel.add(creditPanel);
        mainPanel.add(flightPanel);
        mainPanel.add(bottomPanel);

        add(mainPanel);
        pack();
        setVisible(true);
    }

    /**
     * Update the JComboBox of tickets from flight
     * @param flight the wanted flight
     * @param comboBoxTickets JComboBox to update
     */
    private void updateTickets(Flight flight, JComboBox<Ticket> comboBoxTickets) {
        comboBoxTickets.removeAllItems();

        if (flight != null) {
            Ticket[] tickets = flight.getTickets();
            java.util.Arrays.sort(tickets);

            for (Ticket ticket : tickets) {
                comboBoxTickets.addItem(ticket);
            }
        }
    }
}
