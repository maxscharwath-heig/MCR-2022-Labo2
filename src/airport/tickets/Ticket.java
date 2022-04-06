package airport.tickets;

public abstract class Ticket {
    private final int priceInMiles;
    private final int coefficiant;
    private final int basePrice;

    protected Ticket(int coefficiant, int priceInMiles, int basePrice) {
        this.coefficiant = coefficiant;
        this.priceInMiles = priceInMiles;
        this.basePrice = basePrice;
    }

    public int getPrice () {
        return coefficiant * basePrice;
    }
}
