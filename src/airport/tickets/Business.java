package airport.tickets;

/**
 * Represents a business type of ticket
 *
 * @author Nicolas Crausaz
 * @author Maxime Scharwath
 * @version 1.0
 * @date 2022-04-22
 */
public class Business extends Ticket {
    private static final double PRICE_IN_CASH_COEFFICIANT = 2;
    private static final double PRICE_IN_MILES_COEFFICIANT = 5;

    public Business(double basePrice) {
        super(PRICE_IN_CASH_COEFFICIANT, PRICE_IN_MILES_COEFFICIANT, basePrice);
    }

    @Override
    public String toString() {
        return "Business " + super.getPriceInCash() + "$";
    }
}
