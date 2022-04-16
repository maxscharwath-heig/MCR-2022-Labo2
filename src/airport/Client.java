package airport;

import gui.Subject;
import status.Silver;
import status.Status;

public class Client extends Subject implements Comparable<Client> {
    private static int counter = 0;
    private final String lastname;
    private final String firstname;
    private final int id;
    private int credits;
    private int miles;
    private Status status;
    private String lastAction;

    public Client(String lastname, String firstname) {
        this.lastname = lastname;
        this.firstname = firstname;
        this.id = ++counter;
        this.credits = 0;
        this.miles = 0;
        this.status = new Silver(this);
        this.lastAction = "";
    }

    public String getLastname() {
        return lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setStatus(Status status) {
        this.status = status;
        notifyObservers();
    }

    public int getCredits() {
        return credits;
    }

    public int getMiles() {
        return miles;
    }

    public void addMiles(int miles) {
        if (miles < 0) throw new RuntimeException("Invalid miles");
        this.miles += miles;
        notifyObservers();
    }

    public void removeMiles (int miles) {
        if (miles < 0) throw new RuntimeException("Invalid miles");
        this.miles -= miles;
        notifyObservers();
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

    public void addCredit(int credits) {
        if (credits < 0) throw new RuntimeException("Invalid credit");
        this.setCredits(this.credits + credits);
    }

    public void removeCredit(int credits) {
        if (credits < 0) throw new RuntimeException("Invalid credit");
        this.setCredits(this.credits - credits);
    }

    public void setCredits(int credits) {
        if (credits < 0) throw new RuntimeException("Invalid credit");
        this.credits = credits;
        notifyObservers();
    }

    @Override
    public void notifyObservers() {
        status.checkAndUpdateState();
        super.notifyObservers();
    }

    public String getLastAction() {
        return lastAction;
    }

    public void setLastAction(String lastAction) {
        this.lastAction = lastAction;
        notifyObservers();
    }

    @Override
    public int compareTo(Client o) {
        int i = lastname.compareTo(o.lastname);
        return i != 0 ? i : firstname.compareTo(o.firstname);
    }
}
