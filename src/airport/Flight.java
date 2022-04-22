package airport;

import airport.tickets.Business;
import airport.tickets.Economy;
import airport.tickets.FirstClass;
import airport.tickets.Ticket;

public class Flight implements Comparable<Flight> {
    private final String name;
    private final double distance;
    private final double basePrice;

    public Flight(String name, double distance, double basePrice) {
        this.name = name;
        this.distance = distance;
        this.basePrice = basePrice;
    }

    /**
     * Get the name of the flight
     *
     * @return name of the flight
     */
    public String getName() {
        return name;
    }

    /**
     * Get the total distance of the flight
     *
     * @return distance of the flight
     */
    public double getDistance() {
        return distance;
    }

    @Override
    public String toString() {
        return name + " (" + distance + " miles)";
    }

    /**
     * Get available tickets for the flight
     *
     * @return available tickets
     */
    public Ticket[] getTickets() {
        return new Ticket[]{
                new Economy(basePrice),
                new Business(basePrice),
                new FirstClass(basePrice)
        };
    }

    @Override
    public int compareTo(Flight o) {
        return name.compareTo(o.name);
    }
}
