package gui;

import javax.swing.*;

public class ClientManagerGUI extends JFrame {
    public ClientManagerGUI() {
        super("Clients Manager");
        var panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        {
            var clientPanel = new JPanel();
            clientPanel.add(new JLabel("Client"));
            var comboBox = new JComboBox<>();
            comboBox.addItem("Client 1");
            comboBox.addItem("Client 2");
            comboBox.addItem("Client 3");
            clientPanel.add(comboBox);
            var button = new JButton("Details");
            clientPanel.add(button);
            panel.add(clientPanel);
        }
        {
            var creditPanel = new JPanel();
            creditPanel.add(new JLabel("Credit"));
            var numberField = new JTextField(10);
            creditPanel.add(numberField);
            var button = new JButton("Add");
            creditPanel.add(button);
            panel.add(creditPanel);
        }
        {
            var flightPanel = new JPanel();
            flightPanel.add(new JLabel("Flight"));
            var comboBox = new JComboBox<>();
            comboBox.addItem("Flight 1");
            comboBox.addItem("Flight 2");
            comboBox.addItem("Flight 3");
            flightPanel.add(comboBox);
            var bookCashButton = new JButton("Book (cash)");
            var bookMilesButton = new JButton("Book (miles)");
            flightPanel.add(bookCashButton);
            flightPanel.add(bookMilesButton);
            panel.add(flightPanel);
        }
        {
            var bottomPanel = new JPanel();
            var statusButton = new JButton("Statues");
            var exitButton = new JButton("Quit");
            bottomPanel.add(statusButton);
            bottomPanel.add(exitButton);
            panel.add(bottomPanel);
        }
        add(panel);
        pack();
    }
}
