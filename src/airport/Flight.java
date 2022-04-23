package airport;

import airport.tickets.Business;
import airport.tickets.Economy;
import airport.tickets.FirstClass;
import airport.tickets.Ticket;

/**
 * Class representing an airplane flight
 *
 * @author Nicolas Crausaz
 * @author Maxime Scharwath
 * @version 1.0
 * @date 2022-04-22
 */
public class Flight implements Comparable<Flight> {
    private final String name;
    private final double distance;
    private final double basePrice;
    private final Ticket[] tickets;

    public Flight(String name, double distance, double basePrice) {

        if (distance <= 0 || basePrice <= 0) throw new RuntimeException("Invalid arguments for flight");

        this.name = name;
        this.distance = distance;
        this.basePrice = basePrice;
        this.tickets = new Ticket[]{
                new Business(basePrice),
                new Economy(basePrice),
                new FirstClass(basePrice)
        };
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

    /**
     * Get available tickets for the flight
     *
     * @return available tickets
     */
    public Ticket[] getTickets() {
        return tickets;
    }

    @Override
    public int compareTo(Flight o) {
        return name.compareTo(o.name);
    }

    @Override
    public String toString() {
        return name + " (" + distance + " miles)";
    }
}
