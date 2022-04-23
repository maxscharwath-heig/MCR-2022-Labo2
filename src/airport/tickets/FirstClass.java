package airport.tickets;

/**
 * Represents a first class type of ticket
 *
 * @author Nicolas Crausaz
 * @author Maxime Scharwath
 * @version 1.0
 * @date 2022-04-22
 */
public class FirstClass extends Ticket {
    private static final double PRICE_IN_CASH_COEFFICIENT = 5;
    private static final double PRICE_IN_MILES_COEFFICIENT = 30;

    public FirstClass(double basePrice) {
        super(PRICE_IN_CASH_COEFFICIENT, PRICE_IN_MILES_COEFFICIENT, basePrice);
    }

    @Override
    public String toString() {
        return "First class " + super.getPriceInCash() + "$";
    }
}
