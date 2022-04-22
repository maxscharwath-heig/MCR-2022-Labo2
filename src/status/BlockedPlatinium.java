package status;

import airport.Client;

public class BlockedPlatinium extends Platinium {

    public BlockedPlatinium(Client client) {
        super(client);
    }

    @Override
    protected boolean promote() {
        return false;
    }

    @Override
    protected boolean demote() {
        return false;
    }

    @Override
    public String toString() {
        return super.toString() + " (Locked)";
    }
}
