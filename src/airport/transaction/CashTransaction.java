package airport.transaction;

import airport.Client;
import airport.Flight;
import airport.tickets.Ticket;

/**
 * Class representing a ticket payment transaction in cash
 *
 * @author Nicolas Crausaz
 * @author Maxime Scharwath
 * @version 1.0
 * @date 2022-04-24
 */
public class CashTransaction extends Transaction {
    public CashTransaction(Client client, Flight flight, Ticket ticket) {
        super(client, flight, ticket);
    }

    @Override
    public boolean make() {
        if (client.getCredits() < ticket.getPriceInCash()) {
            logTransaction(String.format("Not enough credit to buy %s, need %s$ got %s$", flight.getName(), ticket.getPriceInCash(), client.getCredits()));
            return false;
        }
        // Credit client of miles with coefficient
        client.addMiles(flight.getDistance() * client.getStatus().getCoefficient());
        // Remove price
        client.removeCredit(ticket.getPriceInCash());
        logTransaction(String.format("Booked flight %s for %s$", flight.getName(), ticket.getPriceInCash()));
        return true;
    }
}
