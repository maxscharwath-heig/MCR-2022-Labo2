package airport.transaction;

import airport.Client;
import airport.Flight;
import airport.tickets.Ticket;

/**
 * Class representing a ticket paiement transaction in cash
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
            logTransaction("Not enough credit to buy " + flight.getName());
            return false;
        }

        // Credit client of miles with coefficiant
        client.addMiles(flight.getDistance() * client.getStatus().getCoefficient());

        // Remove price
        client.removeCredit(ticket.getPriceInCash());
        logTransaction("Booked flight " + flight.getName() + " for " + ticket.getPriceInCash() + "$");
        return true;
    }
}
