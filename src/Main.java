import entity.Client;
import entity.Flight;
import gui.ClientDetailGUI;
import gui.ClientManagerGUI;
import gui.StatusGUI;

import java.util.LinkedList;

public class Main {

    public static void main(String... args) {
        LinkedList<Client> clients = new LinkedList<>();
        LinkedList<Flight> flights = new LinkedList<>();

        clients.add(new Client("Boucher", "Guy"));
        flights.add(new Flight("LX1", 1200, 300));
        new ClientManagerGUI().setVisible(true);
        new ClientDetailGUI(clients.get(0)).setVisible(true);
        new StatusGUI().setVisible(true);
    }
}
