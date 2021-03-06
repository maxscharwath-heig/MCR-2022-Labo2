package airport.tickets;

import airport.Flight;

/**
 * Represents a economy type of ticket
 *
 * @author Nicolas Crausaz
 * @author Maxime Scharwath
 * @version 1.0
 * @date 2022-04-22
 */
public class Economy extends Ticket {
    private static final double PRICE_IN_CASH_COEFFICIENT = 1;
    private static final double PRICE_IN_MILES_COEFFICIENT = 1;

    /**
     * Creates an economy type ticket
     *
     * @param flight ticket's flight
     */
    public Economy(Flight flight) {
        super(flight, PRICE_IN_CASH_COEFFICIENT, PRICE_IN_MILES_COEFFICIENT);
    }

    @Override
    public String toString() {
        return "Economy " + super.getPriceInCash() + "$";
    }
}
