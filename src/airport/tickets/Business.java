package airport.tickets;

/**
 * Represents a business type of ticket
 */
public class Business extends Ticket {
    public Business(int basePrice) {
        super(2, 5, basePrice);
    }

    @Override
    public String toString() {
        return "Business " + super.getPriceInCash() + "$";
    }
}
