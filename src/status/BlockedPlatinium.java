package status;

import airport.Client;

/**
 * Class representing a client's status type platinum (lifetime)
 *
 * @author Nicolas Crausaz
 * @author Maxime Scharwath
 * @version 1.0
 * @date 2022-04-22
 */
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
