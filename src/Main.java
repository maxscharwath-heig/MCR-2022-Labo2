import java.util.LinkedList;

public class Main {

    public static void main(String... args) {
        LinkedList<Client> clients = new LinkedList<>();
        LinkedList<Flight> flights = new LinkedList<>();

        clients.add(new Client("Boucher", "Guy"));
        flights.add(new Flight("LX1", 1200, 300));
    }
}
