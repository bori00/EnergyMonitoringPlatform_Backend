package ro.tuc.webapp.services.rightverifier.strategies;

import ro.tuc.webapp.entities.Device;
import ro.tuc.webapp.entities.User;
import ro.tuc.webapp.services.rightverifier.IRightVerifier;

public class AdminRightVerifierStrategy implements IRightVerifier {
    @Override
    public boolean hasAccessToTheDataOf(User user, Device device) {
        return true;
    }

    @Override
    public boolean hasRightToModifyTheDataOf(User user, Device device) {
        return true;
    }

    @Override
    public boolean hasAccessToTheDataOf(User user, User userOfData) {
        return true;
    }

    @Override
    public boolean hasRightToModifyTheDataOf(User user, User userOfData) {
        return true;
    }
}