package airport.transaction;

import airport.Client;
import airport.tickets.Ticket;

/**
 * Class representing a ticket paiement transaction
 *
 * @author Nicolas Crausaz
 * @author Maxime Scharwath
 * @version 1.0
 * @date 2022-04-24
 */
public abstract class Transaction {
    protected Client client;
    protected Ticket ticket;

    /**
     * Creates a new transaction
     *
     * @param client client buying the ticket
     * @param ticket ticket to buy
     * @throws RuntimeException if client or ticket is null
     */
    protected Transaction(Client client, Ticket ticket) {
        if (client == null || ticket == null) {
            throw new RuntimeException("Transaction parameter cannot be null");
        }
        this.client = client;
        this.ticket = ticket;
    }

    /**
     * Log an action in the user account
     *
     * @param log information to log
     */
    protected void logTransaction(String log) {
        this.client.setLastAction(log);
    }

    /**
     * Apply the transaction
     *
     * @return true if transaction was successfully made, else false
     */
    public abstract boolean make();
}
