package status;

import airport.Client;

import java.awt.*;

/**
 * Class representing a client's status type platinum
 *
 * @author Nicolas Crausaz
 * @author Maxime Scharwath
 * @version 1.0
 * @date 2022-04-22
 */
public class Platinium extends Status {
    public Platinium(Client client) {
        super(client);
    }

    @Override
    public Color getColor() {
        return Color.CYAN;
    }

    @Override
    protected boolean promote() {
        if (client.getCredits() >= 100000) {
            client.setStatus(new BlockedPlatinium(client));
            return true;
        }
        return false;
    }

    @Override
    protected boolean demote() {
        if (client.getMiles() < 10000) {
            client.setStatus(new Gold(client));
            return true;
        }
        return false;
    }

    @Override
    public double getCoefficient() {
        return 1;
    }

    @Override
    public String toString() {
        return "PLATINIUM";
    }
}
