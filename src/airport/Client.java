package airport;

import status.Silver;
import status.Status;

public class Client {
    private static int counter = 0;
    private final String lastname;
    private final String firstname;
    private final int id;
    private final int credits;
    private final int miles;
    private Status status;

    public Client(String lastname, String firstname) {
        this.lastname = lastname;
        this.firstname = firstname;
        this.id = ++counter;
        this.credits = 0;
        this.miles = 0;
        this.status = new Silver(this);
    }

    public String getLastname() {
        return lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public int getCredits() {
        return credits;
    }

    public int getMiles() {
        return miles;
    }

    public int getId() {
        return id;
    }

    public Status getStatus () {
        return status;
    }

    @Override
    public String toString() {
        return lastname + " " + firstname;
    }
}
