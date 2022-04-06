package status;

import airport.Client;

import java.awt.*;

public class Gold extends Status {

    public Gold(Client client) {
        super(client);
    }

    @Override
    public Color getColor() {
        return Color.ORANGE;
    }

    @Override
    public void promote() {
        if (client.getMiles() >= 10000) {
            client.setStatus(new Platinium(client));
        }
    }

    @Override
    public void demote() {
        if (client.getMiles() < 1000) {
            client.setStatus(new Silver(client));
        }
    }

    @Override
    public String toString() {
        return "GOLD";
    }
}
