package status;

import airport.Client;

import java.awt.*;

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
    public double getCoefficiant() {
        return 0.1;
    }

    @Override
    public String toString() {
        return "SILVER";
    }
}
