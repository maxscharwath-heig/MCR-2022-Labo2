package airport.tickets;

public abstract class Ticket {
    private final int priceInMiles;
    private final int coefficiant;

    protected Ticket (int coefficiant, int priceInMiles) {
        this.coefficiant = coefficiant;
        this.priceInMiles = priceInMiles;
    }
}
