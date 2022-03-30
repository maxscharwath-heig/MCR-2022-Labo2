package airport;

public class Flight {
    private final String name;
    private final int distance;
    private final int basePrice;

    public Flight(String name, int distance, int basePrice) {
        this.name = name;
        this.distance = distance;
        this.basePrice = basePrice;
    }
}
