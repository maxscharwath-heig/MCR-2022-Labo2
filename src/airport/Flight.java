<<<<<<<< HEAD:src/entity/Flight.java
package entity;
========
package airport;
>>>>>>>> origin/master:src/airport/Flight.java

public class Flight {
    private String name;
    private int distance;
    private int basePrice;

    public Flight(String name, int distance, int basePrice) {
        this.name = name;
        this.distance = distance;
        this.basePrice = basePrice;
    }
}
