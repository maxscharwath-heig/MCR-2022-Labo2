package airport.transaction;

import airport.Client;
import airport.Flight;
import airport.tickets.Ticket;

public abstract class Transaction {
    protected Client client;
    protected Flight flight;
    protected Ticket ticket;

    protected Transaction(Client client, Flight flight, Ticket ticket) {
        if (client == null || flight == null || ticket == null)
            throw new RuntimeException("Transaction parameter cannot be null");

        this.client = client;
        this.flight = flight;
        this.ticket = ticket;
    }

    protected void logTransaction (String log) {
        this.client.setLastAction(log);
    }

    public abstract boolean make();
}
