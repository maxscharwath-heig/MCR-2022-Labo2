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
            logTransaction(String.format("Not enough miles to buy %s, need %s miles but only have %s miles",flight.getName(), ticket.getPriceInMiles(), client.getMiles()));
            return false;
        }
        client.removeMiles(ticket.getPriceInMiles());
        logTransaction(String.format("Booked flight %s for %s miles",flight.getName(), ticket.getPriceInMiles()));
        return true;
    }
}
