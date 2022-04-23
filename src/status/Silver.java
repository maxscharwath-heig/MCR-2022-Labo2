package status;

import airport.Client;

import java.awt.*;

/**
 * Class representing a client's status type silver
 *
 * @author Nicolas Crausaz
 * @author Maxime Scharwath
 * @version 1.0
 * @date 2022-04-22
 */
public class Silver extends Status {
    public Silver(Client client) {
        super(client);
    }

    @Override
    public Color getColor() {
        return Color.GRAY;
    }

    @Override
    protected boolean promote() {
        if (client.getMiles() >= 1000) {
            client.setStatus(new Gold(client));
            return true;
        }
        return false;
    }

    @Override
    protected boolean demote() {
        return false;
    }

    @Override
    public double getCoefficient() {
        return 0.1;
    }

    @Override
    public String toString() {
        return "SILVER";
    }
}
