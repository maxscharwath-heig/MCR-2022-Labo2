package airport.tickets;

/**
 * Represents a first class type of ticket
 */
public class FirstClass extends Ticket {
    public FirstClass(int basePrice) {
        super(5, 30, basePrice);
    }

    @Override
    public String toString() {
        return "First class " + super.getPriceInCash() + "$";
    }
}
