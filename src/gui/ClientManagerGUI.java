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
        JPanel mainPanel = new JPanel();
        mainPanel.setBorder(new EmptyBorder(20, 20, 20, 20));
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        // Clients panel
        Collections.sort(clients);
        JComboBox<Client> clientComboBox = new JComboBox<>();
        JPanel clientPanel = new JPanel();
        clientPanel.add(new JLabel("Client"));

        for (Client c : clients) {
            clientComboBox.addItem(c);
        }

        clientPanel.add(clientComboBox);
        JButton showClientButton = new JButton("Details");
        clientPanel.add(showClientButton);

        showClientButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (clientComboBox.getSelectedItem() != null) {
                    new ClientDetailGUI((Client) clientComboBox.getSelectedItem());
                }
            }
        });

        // Credits panel
        JPanel creditPanel = new JPanel();
        creditPanel.add(new JLabel("Credit"));
        JTextField numberField = new JTextField(10);
        creditPanel.add(numberField);
        JButton addCreditButton = new JButton("Add");
        creditPanel.add(addCreditButton);
        addCreditButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Client client = (Client) clientComboBox.getSelectedItem();
                if (client != null && !Objects.equals(numberField.getText(), "")) {
                    try {
                        int credits = Integer.parseInt(numberField.getText());
                        client.addCredit(credits);
                    } catch (RuntimeException n) {
                        client.setLastAction("Invalid credit provided");
                    }
                }
            }
        });

        // Flight panel
        Collections.sort(flights);
        JPanel flightPanel = new JPanel();
        flightPanel.add(new JLabel("Flight"));
        JComboBox<Flight> comboBoxFlight = new JComboBox<>();

        for (Flight flight : flights) {
            comboBoxFlight.addItem(flight);
        }
        flightPanel.add(comboBoxFlight);

        JComboBox<Ticket> comboBoxTickets = new JComboBox<>();
        updateTickets(flights.get(0), comboBoxTickets);

        comboBoxFlight.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                Flight selectedFlight = (Flight) comboBoxFlight.getSelectedItem();
                updateTickets(selectedFlight, comboBoxTickets);
            }
        });

        flightPanel.add(comboBoxTickets);

        JButton bookCashButton = new JButton("Book (cash)");
        JButton bookMilesButton = new JButton("Book (miles)");
        flightPanel.add(bookCashButton);
        flightPanel.add(bookMilesButton);
        mainPanel.add(flightPanel);

        bookCashButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Client selectedClient = (Client) clientComboBox.getSelectedItem();
                Flight selectedFlight = (Flight) comboBoxFlight.getSelectedItem();
                Ticket selectedTicket = (Ticket) comboBoxTickets.getSelectedItem();
                try {
                    CashTransaction transact = new CashTransaction(selectedClient, selectedFlight, selectedTicket);
                    transact.make();
                } catch (RuntimeException e) {
                    System.out.println("An error occurred while trying to book the ticket");
                }
            }
        });

        bookMilesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Client selectedClient = (Client) clientComboBox.getSelectedItem();
                Flight selectedFlight = (Flight) comboBoxFlight.getSelectedItem();
                Ticket selectedTicket = (Ticket) comboBoxTickets.getSelectedItem();
                try {
                    MilesTransaction transact = new MilesTransaction(selectedClient, selectedFlight, selectedTicket);
                    transact.make();
                } catch (RuntimeException e) {
                    System.out.println("An error occurred while trying to book the ticket");
                }
            }
        });

        // Statuses & quit panel
        JPanel bottomPanel = new JPanel();
        JButton statusButton = new JButton("Statuses");
        JButton exitButton = new JButton("Quit");
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
     *
     * @param flight          the wanted flight
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
