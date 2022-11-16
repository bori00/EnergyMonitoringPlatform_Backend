package ro.tuc.webapp.services.rightverifier;

import ro.tuc.common.entities.Device;
import ro.tuc.common.entities.User;

public interface IRightVerifier {

    boolean hasAccessToTheDataOf(User user, Device device);

    boolean hasRightToModifyTheDataOf(User user, Device device);

    boolean hasAccessToTheDataOf(User user, User userOfData);

    boolean hasRightToModifyTheDataOf(User user, User userOfData);
}