package status;

import airport.Client;

import java.awt.*;

public class Platinium extends Status {

    public Platinium(Client client) {
        super(client);
    }

    @Override
    public Color getColor() {
        return Color.CYAN;
    }

    @Override
    public boolean promote() {
        if(client.getCredits() >= 100000) {
            client.setStatus(new BlockedPlatinium(client));
            return true;
        }
        return false;
    }

    @Override
    public boolean demote() {
        if (client.getMiles() < 10000) {
            client.setStatus(new Gold(client));
            return true;
        }
        return false;
    }

    @Override
    public double getCoefficiant() {
        return 1;
    }

    @Override
    public String toString() {
        return "PLATINIUM";
    }
}
