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
    }

    @Override
    public void demote() {
        // Si le compte a au moins 100000 crédits, il reste indéfiniment dans le statut PLATINIUM (même si par la
        //suite il n’a plus les 100000 crédits/10000 miles nécessaires).
    }
}
