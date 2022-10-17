package ro.tuc.ds2020.services.rightverifier;

import ro.tuc.ds2020.entities.Client;
import ro.tuc.ds2020.entities.Device;
import ro.tuc.ds2020.entities.User;

public interface IRightVerifier {

    boolean hasAccessToTheDataOf(User user, Device device);

    boolean hasRightToModifyTheDataOf(User user, Device device);

    boolean hasAccessToTheDataOf(User user, User userOfData);

    boolean hasRightToModifyTheDataOf(User user, User userOfData);
}