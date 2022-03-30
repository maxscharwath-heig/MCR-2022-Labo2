import status.Status;

public class Client {
    private static int counter = 0;
    private String lastname;
    private String firstname;
    private final int id; // auto gen
    private int credits;
    private int miles;
    private Status status;

    public Client (String lastname, String firstname) {
        this.lastname = lastname;
        this.firstname = firstname;
        this.id = ++counter;
        this.credits = 0;
        this.miles = 0;
    }

}
