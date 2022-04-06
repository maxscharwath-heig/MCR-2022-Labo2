import airport.Client;
import airport.Flight;
import gui.ClientManagerGUI;
import status.Gold;

import java.util.LinkedList;

public class Main {

    public static void main(String... args) {
        LinkedList<Client> clients = new LinkedList<>();
        LinkedList<Flight> flights = new LinkedList<>();

        clients.add(new Client("Crausaz", "Nicolas"));
        clients.add(new Client("Boucher", "Guy"));
        flights.add(new Flight("LX1", 1200, 300));
        flights.add(new Flight("TH2", 500, 200));
        flights.add(new Flight("HF3", 200, 100));


        clients.get(1).setStatus(new Gold(clients.get(1)));

        new ClientManagerGUI(clients).setVisible(true);
    }
}
