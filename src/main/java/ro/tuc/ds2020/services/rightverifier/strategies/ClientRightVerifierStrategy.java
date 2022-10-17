package ro.tuc.ds2020.services.rightverifier.strategies;

import ro.tuc.ds2020.entities.Client;
import ro.tuc.ds2020.entities.Device;
import ro.tuc.ds2020.entities.User;
import ro.tuc.ds2020.services.rightverifier.IRightVerifier;

public class ClientRightVerifierStrategy implements IRightVerifier {
    @Override
    public boolean hasAccessToTheDataOf(User user, Device device) {
        return device.getClient().equals(user);
    }

    @Override
    public boolean hasRightToModifyTheDataOf(User user, Device device) {
        return false;
    }

    @Override
    public boolean hasAccessToTheDataOf(User user, User userOfData) {
        return user.equals(userOfData);
    }

    @Override
    public boolean hasRightToModifyTheDataOf(User user, User userOfData) {
        return user.equals(userOfData);
    }
}
