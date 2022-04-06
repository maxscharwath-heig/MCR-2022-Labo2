package status;

import airport.Client;

import java.awt.*;

public class Platinium extends Status {

    public Platinium(Client client) {
        super(client);
    }

    @Override
    public Color getColor() {
        return Color.LIGHT_GRAY;
    }

    @Override
    public void promote() {
        if(client.getCredits() >= 100000) {
            client.setStatus(new BlockedPlatinium(client));
        }
    }

    @Override
    public void demote() {
        if (client.getMiles() < 10000) {
            client.setStatus(new Gold(client));
        }
    }

    @Override
    public String toString() {
        return "PLATINIUM";
    }
}
