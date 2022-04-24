package airport.transaction;

import airport.Client;
import airport.Flight;
import airport.tickets.Ticket;

/**
 * Class representing a ticket paiement transaction in miles
 *
 * @author Nicolas Crausaz
 * @author Maxime Scharwath
 * @version 1.0
 * @date 2022-04-24
 */
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
        try {
            client.removeMiles(ticket.getPriceInMiles());
        } catch (Exception e) {
            logTransaction("Error while removing miles");
            return false;
        }
        logTransaction("Booked flight " + flight.getName() + " for " + ticket.getPriceInMiles() + " miles");
        return true;
    }
}
