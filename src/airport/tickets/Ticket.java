package airport.tickets;

import airport.Flight;

/**
 * Represent a flight ticket
 *
 * @author Nicolas Crausaz
 * @author Maxime Scharwath
 * @version 1.0
 * @date 2022-04-22
 */
public abstract class Ticket implements Comparable<Ticket> {

    private final Flight flight;
    private final double cashCoefficient;
    private final double milesCoefficient;

    protected Ticket(Flight flight, double cashCoefficient, double milesCoefficient) {
        this.flight = flight;
        this.cashCoefficient = cashCoefficient;
        this.milesCoefficient = milesCoefficient;
    }

    /**
     * Get the price of ticket in cash ($)
     *
     * @return Price in cash ($)
     */
    public double getPriceInCash() {
        return cashCoefficient * flight.getBasePrice();
    }

    /**
     * Get the price of tickets in miles
     *
     * @return Price in miles
     */
    public double getPriceInMiles() {
        return milesCoefficient * flight.getDistance();
    }

    @Override
    public int compareTo(Ticket o) {
        return Double.compare(getPriceInCash(), o.getPriceInCash());
    }
}
