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

        try {
            // Credit client of miles with coefficient
            client.addMiles(flight.getDistance() * client.getStatus().getCoefficient());
        } catch (Exception e) {
            logTransaction("Error while adding miles to client");
            return false;
        }

        try {
            // Remove price
            client.removeCredit(ticket.getPriceInCash());
        } catch (Exception e) {
            logTransaction("Error while removing credit from client");
            return false;
        }

        logTransaction("Booked flight " + flight.getName() + " for " + ticket.getPriceInCash() + "$");
        return true;
    }
}
