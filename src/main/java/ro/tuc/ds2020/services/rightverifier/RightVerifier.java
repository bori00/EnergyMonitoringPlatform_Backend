package ro.tuc.ds2020.services.rightverifier;

import ro.tuc.ds2020.entities.Client;
import ro.tuc.ds2020.entities.Device;
import ro.tuc.ds2020.entities.User;

/**
 * Class responsible for verifying whether a user has the right to access or modify certain data.
 */
public class RightVerifier implements IRightVerifier {

    @Override
    public boolean hasAccessToTheDataOf(User user, Device device) {
        return RightVerifierFactory.getRightVerifier(user).hasAccessToTheDataOf(user, device);
    }

    @Override
    public boolean hasRightToModifyTheDataOf(User user, Device device) {
        return RightVerifierFactory.getRightVerifier(user).hasRightToModifyTheDataOf(user, device);
    }

    @Override
    public boolean hasAccessToTheDataOf(User user, User userOfData) {
        return RightVerifierFactory.getRightVerifier(user).hasAccessToTheDataOf(user, userOfData);
    }

    @Override
    public boolean hasRightToModifyTheDataOf(User user, User userOfData) {
        return RightVerifierFactory.getRightVerifier(user).hasRightToModifyTheDataOf(user, userOfData);
    }
}