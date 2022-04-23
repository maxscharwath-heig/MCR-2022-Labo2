package airport.tickets;

/**
 * Represent a flight ticket
 *
 * @author Nicolas Crausaz
 * @author Maxime Scharwath
 * @version 1.0
 * @date 2022-04-22
 */
public abstract class Ticket implements Comparable<Ticket> {
    private final double cashCoefficient;
    private final double milesCoefficient;
    private final double basePrice;

    protected Ticket(double cashCoefficient, double milesCoefficient, double basePrice) {
        this.cashCoefficient = cashCoefficient;
        this.milesCoefficient = milesCoefficient;
        this.basePrice = basePrice;
    }

    /**
     * Get the price of ticket in cash ($)
     *
     * @return Price in cash ($)
     */
    public double getPriceInCash() {
        return cashCoefficient * basePrice;
    }

    /**
     * Get the price of tickets in miles
     *
     * @return Price in miles
     */
    public double getPriceInMiles() {
        return milesCoefficient * basePrice;
    }

    @Override
    public int compareTo(Ticket o) {
        return Double.compare(getPriceInCash(), o.getPriceInCash());
    }
}
