import airport.Client;
import airport.Flight;
import gui.ClientManagerGUI;

import java.util.LinkedList;

public class Main {
    public static void main(String... args) {
        LinkedList<Client> clients = new LinkedList<>();
        LinkedList<Flight> flights = new LinkedList<>();

        clients.add(new Client("Crausaz", "Nicolas"));
        clients.add(new Client("Boucher", "Guy"));
        clients.add(new Client("Scharwath", "Maxime"));
        clients.add(new Client("Boucher", "Frederic"));
        clients.add(new Client("Lamarre", "Quendrique"));
        clients.add(new Client("Amidala", "Padenez"));
        clients.add(new Client("Mark", "Jador"));
        clients.add(new Client("Komsepief", "Elizabeth"));
        clients.add(new Client("Spring", "Buffy"));
        clients.add(new Client("Gjarbijkölector", "Viktor"));

        flights.add(new Flight("LX1", 1200, 300));
        flights.add(new Flight("TH2", 500, 200));
        flights.add(new Flight("HF3", 200, 100));

        new ClientManagerGUI(clients, flights);
    }
}
