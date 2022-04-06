package airport;

import airport.tickets.Business;
import airport.tickets.Economy;
import airport.tickets.FirstClass;
import airport.tickets.Ticket;

public class Flight {
    private final String name;
    private final int distance;
    private final int basePrice;

    public Flight(String name, int distance, int basePrice) {
        this.name = name;
        this.distance = distance;
        this.basePrice = basePrice;
    }

    public String getName() {
        return name;
    }

    public int getBasePrice() {
        return basePrice;
    }

    public int getDistance() {
        return distance;
    }

    @Override
    public String toString() {
        return name + " (" + distance + " miles)";
    }

    public Ticket[] getTickets() {
        return new Ticket[] {
                new Economy(basePrice),
                new Business(basePrice),
                new FirstClass(basePrice)
        };
    }
}
