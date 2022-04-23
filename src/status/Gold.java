package status;

import airport.Client;

import java.awt.*;

/**
 * Class representing a client's status type gold
 *
 * @author Nicolas Crausaz
 * @author Maxime Scharwath
 * @version 1.0
 * @date 2022-04-22
 */
public class Gold extends Status {
    public Gold(Client client) {
        super(client);
    }

    @Override
    public Color getColor() {
        return Color.ORANGE;
    }

    @Override
    protected boolean promote() {
        if (client.getMiles() >= 10000) {
            client.setStatus(new Platinium(client));
            return true;
        }
        return false;
    }

    @Override
    protected boolean demote() {
        if (client.getMiles() < 1000) {
            client.setStatus(new Silver(client));
            return true;
        }
        return false;
    }

    @Override
    public double getCoefficient() {
        return 0.5;
    }

    @Override
    public String toString() {
        return "GOLD";
    }
}
