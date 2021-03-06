package airport.tickets;

import airport.Flight;

/**
 * Represents a business type of ticket
 *
 * @author Nicolas Crausaz
 * @author Maxime Scharwath
 * @version 1.0
 * @date 2022-04-22
 */
public class Business extends Ticket {
    private static final double PRICE_IN_CASH_COEFFICIENT = 2;
    private static final double PRICE_IN_MILES_COEFFICIENT = 5;

    /**
     * Creates a business type ticket
     *
     * @param flight ticket's flight
     */
    public Business(Flight flight) {
        super(flight, PRICE_IN_CASH_COEFFICIENT, PRICE_IN_MILES_COEFFICIENT);
    }

    @Override
    public String toString() {
        return "Business " + super.getPriceInCash() + "$";
    }
}
