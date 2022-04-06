package status;

import airport.Client;

public class BlockedPlatinium extends Platinium {

    public BlockedPlatinium(Client client) {
        super(client);
    }

    @Override
    public boolean promote() {
        return false;
    }

    @Override
    public boolean demote() {
        return false;
    }
}
