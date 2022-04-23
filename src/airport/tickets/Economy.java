package airport.tickets;

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
    public Economy(double basePrice) {
        super(PRICE_IN_CASH_COEFFICIENT, PRICE_IN_MILES_COEFFICIENT, basePrice);
    }

    @Override
    public String toString() {
        return "Economy " + super.getPriceInCash() + "$";
    }
}
