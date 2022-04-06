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
    public boolean promote() {
        if (client.getMiles() >= 10000) {
            client.setStatus(new Platinium(client));
            return true;
        }
        return false;
    }

    @Override
    public boolean demote() {
        if (client.getMiles() < 1000) {
            client.setStatus(new Silver(client));
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "GOLD";
    }
}
