package airport.tickets;

/**
 * Represent a flight ticket
 */
public abstract class Ticket {
    private final int priceInMiles;
    private final int coefficiant;
    private final int basePrice;
    protected Ticket(int coefficiant, int priceInMiles, int basePrice) {
        this.coefficiant = coefficiant;
        this.priceInMiles = priceInMiles;
        this.basePrice = basePrice;
    }

    /**
     * Get the price of ticket in cash ($)
     * @return Price in cash ($)
     */
    public int getPriceInCash() {
        return coefficiant * basePrice;
    }

    /**
     * Get the price of tickets in miles
     * @return Price in miles
     */
    public int getPriceInMiles() {
        return priceInMiles * basePrice;
    }
}
