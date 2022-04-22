package airport;

import gui.Subject;
import status.Silver;
import status.Status;

public class Client extends Subject implements Comparable<Client> {
    private static int counter = 0;
    private final String lastname;
    private final String firstname;
    private final int id;
    private double credits;
    private double miles;
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

    /**
     * Get last name of client
     * @return Last name of client
     */
    public String getLastname() {
        return lastname;
    }

    /**
     * Get first name of client
     * @return first name of client
     */
    public String getFirstname() {
        return firstname;
    }

    /**
     * Get unique identifier of client
     * @return unique identifier of client
     */
    public int getId() {
        return id;
    }

    /**
     * Get status of client
     * @return status of client
     */
    public Status getStatus() {
        return status;
    }

    /**
     * Set the status of client
     * @param status client new status
     */
    public void setStatus(Status status) {
        this.status = status;
        notifyObservers();
    }

    /**
     * Get current credits of client
     * @return credits number
     */
    public double getCredits() {
        return credits;
    }

    /**
     * Get current miles of client
     * @return miles number
     */
    public double getMiles() {
        return miles;
    }

    /**
     * Add miles to client
     * @param miles number of miles to add
     */
    public void addMiles(double miles) {
        if (miles < 0) throw new RuntimeException("Invalid miles");
        this.miles += miles;
        notifyObservers();
    }

    /**
     * Remove miles from client
     * @param miles number of miles to remove
     */
    public void removeMiles(double miles) {
        if (miles < 0) throw new RuntimeException("Invalid miles");
        this.miles -= miles;
        notifyObservers();
    }

    /**
     * Add credits to client
     * @param credits number of credits to add
     */
    public void addCredit(double credits) {
        if (credits < 0) throw new RuntimeException("Invalid credit");
        this.setCredits(this.credits + credits);
    }

    /**
     * Remove credit from client
     * @param credits number of credits to remove
     */
    public void removeCredit(double credits) {
        if (credits < 0) throw new RuntimeException("Invalid credit");
        this.setCredits(this.credits - credits);
    }

    /**
     * Notifiy observers that client's data has changed
     */
    @Override
    public void notifyObservers() {
        status.checkAndUpdateState();
        super.notifyObservers();
    }

    /**
     * Get last operation of client
     * @return Last operation of client
     */
    public String getLastAction() {
        return lastAction;
    }

    /**
     * Get last action of client
     * @param lastAction last action of client
     */
    public void setLastAction(String lastAction) {
        this.lastAction = lastAction;
        notifyObservers();
    }

    @Override
    public int compareTo(Client o) {
        int i = lastname.compareTo(o.lastname);
        return i != 0 ? i : firstname.compareTo(o.firstname);
    }

    /**
     * Set credit of client
     * @param credits Number of credits to set
     */
    private void setCredits(double credits) {
        if (credits < 0) throw new RuntimeException("Invalid credit");
        this.credits = credits;
        notifyObservers();
    }

    @Override
    public String toString() {
        return lastname + " " + firstname;
    }
}
