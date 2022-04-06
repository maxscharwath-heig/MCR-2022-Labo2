package status;

import airport.Client;

import java.awt.*;

public abstract class Status {

    protected final Client client;

    protected Status(Client client) {
        this.client = client;
    }

    public abstract Color getColor();

    public abstract boolean promote();

    public abstract boolean demote();

    public boolean checkAndUpdateState(){
        return promote()||demote();
    }
}
