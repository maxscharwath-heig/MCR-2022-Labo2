package airport.tickets;

/**
 * Represent a flight ticket
 */
public abstract class Ticket {
    private final double cashCoefficiant;
    private final double milesCoefficiant;
    private final double basePrice;

    protected Ticket(double inCashCoefficiant, double priceInMiles, double basePrice) {
        this.cashCoefficiant = inCashCoefficiant;
        this.milesCoefficiant = priceInMiles;
        this.basePrice = basePrice;
    }

    /**
     * Get the price of ticket in cash ($)
     *
     * @return Price in cash ($)
     */
    public double getPriceInCash() {
        return cashCoefficiant * basePrice;
    }

    /**
     * Get the price of tickets in miles
     *
     * @return Price in miles
     */
    public double getPriceInMiles() {
        return milesCoefficiant * basePrice;
    }
}
