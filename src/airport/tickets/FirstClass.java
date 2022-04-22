package airport.tickets;

/**
 * Represents a first class type of ticket
 */
public class FirstClass extends Ticket {
    private static final double PRICE_IN_CASH_COEFFICIANT = 5;
    private static final double PRICE_IN_MILES_COEFFICIANT = 30;

    public FirstClass(double basePrice) {
        super(PRICE_IN_CASH_COEFFICIANT, PRICE_IN_MILES_COEFFICIANT, basePrice);
    }

    @Override
    public String toString() {
        return "First class " + super.getPriceInCash() + "$";
    }
}
