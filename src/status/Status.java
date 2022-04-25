package status;

import airport.Client;

import java.awt.*;

/**
 * Class representing a client's status
 *
 * @author Nicolas Crausaz
 * @author Maxime Scharwath
 * @version 1.0
 * @date 2022-04-22
 */
public abstract class Status {

    protected final Client client;

    protected Status(Client client) {
        this.client = client;
    }

    /**
     * Color reprensentation of status
     *
     * @return color of status
     */
    public abstract Color getColor();

    /**
     * Check and apply promotion to a client to a higher status
     *
     * @return true if client has been promoted, else false
     */
    protected abstract boolean promote();

    /**
     * Check and apply demotion to a client to a lower status
     *
     * @return true if client has been demoted, else false
     */
    protected abstract boolean demote();

    /**
     * Get the applied coefficient on miles credit
     *
     * @return miles credit coefficient
     */
    public abstract double getCoefficient();

    /**
     * Check if client is subject to promotion or demotion
     *
     * @return true if promotion or demotion has been made, else false
     */
    public boolean checkAndUpdateState() {
        return promote() || demote();
    }

    @Override
    public abstract String toString();
}
