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
    public void promote() {
        if (client.getMiles() >= 1000) {
            client.setStatus(new Gold(client));
        }
    }

    @Override
    public void demote() {
    }
}
