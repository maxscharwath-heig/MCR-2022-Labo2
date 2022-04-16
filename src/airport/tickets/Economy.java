package airport.tickets;

/**
 * Represents a economy type of ticket
 */
public class Economy extends Ticket {
    public Economy(int basePrice) {
        super(1, 1, basePrice);
    }

    @Override
    public String toString() {
        return "Economy " + super.getPriceInCash() + "$";
    }
}
