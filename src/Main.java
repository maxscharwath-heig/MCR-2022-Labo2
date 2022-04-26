import airport.Client;
import airport.Flight;
import gui.ClientManagerGUI;

import java.util.LinkedList;

/**
 * Main entry for the airport's clients manager
 *
 * @author Nicolas Crausaz
 * @author Maxime Scharwath
 * @version 1.0
 * @date 2022-04-22
 */
public class Main {
    public static void main(String... args) {
        LinkedList<Client> clients = new LinkedList<>();
        LinkedList<Flight> flights = new LinkedList<>();

        // Create clients
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

        // Create flights
        flights.add(new Flight("LX1", 1200, 300));
        flights.add(new Flight("TH2", 500, 200));
        flights.add(new Flight("HF3", 200, 100));

        // Initialize GUI
        new ClientManagerGUI(clients, flights);
    }
}
