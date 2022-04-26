package airport.transaction;

import airport.Client;
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

    /**
     * Creates a new miles transaction
     *
     * @param client client buying the ticket
     * @param ticket ticket to buy
     * @throws RuntimeException if client or ticket is null
     */
    public MilesTransaction(Client client, Ticket ticket) {
        super(client, ticket);
    }

    @Override
    public boolean make() {
        if (client.getMiles() < ticket.getPriceInMiles()) {
            logTransaction(String.format("Not enough miles to buy %s, need %s miles but only have %s miles", ticket.getFlight().getName(), ticket.getPriceInMiles(), client.getMiles()));
            return false;
        }
        // Remove miles from client
        client.removeMiles(ticket.getPriceInMiles());
        logTransaction(String.format("Booked flight %s for %s miles", ticket.getFlight().getName(), ticket.getPriceInMiles()));
        return true;
    }
}
