import airport.Client;
import airport.Flight;
import gui.ClientManagerGUI;
import gui.StatusGUI;

import java.util.LinkedList;

public class Main {

    public static void main(String... args) {
        LinkedList<Client> clients = new LinkedList<>();
        LinkedList<Flight> flights = new LinkedList<>();

        clients.add(new Client("Boucher", "Guy"));
        clients.add(new Client("Crausaz", "Nicolas"));
        flights.add(new Flight("LX1", 1200, 300));
        new ClientManagerGUI(clients).setVisible(true);
    }
}
