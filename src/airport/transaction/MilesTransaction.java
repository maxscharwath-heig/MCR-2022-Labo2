package airport.transaction;

import airport.Client;
import airport.Flight;
import airport.tickets.Ticket;

public class MilesTransaction extends Transaction {
    public MilesTransaction(Client client, Flight flight, Ticket ticket) {
        super(client, flight, ticket);
    }

    @Override
    public boolean make() {
        if (client.getMiles() < ticket.getPriceInMiles()) {
            logTransaction("Not enough miles to buy " + flight.getName());
            return false;
        }

        client.removeMiles(ticket.getPriceInMiles());
        logTransaction("Booked flight " + flight.getName() + " for " + ticket.getPriceInMiles() + " miles");
        return true;
    }
}
