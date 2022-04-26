package airport.transaction;

import airport.Client;
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

    /**
     * Creates a new cash transaction
     *
     * @param client client buying the ticket
     * @param ticket ticket to buy
     * @throws RuntimeException if client or ticket is null
     */
    public CashTransaction(Client client, Ticket ticket) {
        super(client, ticket);
    }

    @Override
    public boolean make() {
        if (client.getCredits() < ticket.getPriceInCash()) {
            logTransaction(String.format("Not enough credit to buy %s, need %s$ got %s$", ticket.getFlight().getName(), ticket.getPriceInCash(), client.getCredits()));
            return false;
        }
        // Credit client of miles with coefficient
        client.addMiles(ticket.getFlight().getDistance() * client.getStatus().getCoefficient());
        // Remove price
        client.removeCredit(ticket.getPriceInCash());
        logTransaction(String.format("Booked flight %s for %s$", ticket.getFlight().getName(), ticket.getPriceInCash()));
        return true;
    }
}
