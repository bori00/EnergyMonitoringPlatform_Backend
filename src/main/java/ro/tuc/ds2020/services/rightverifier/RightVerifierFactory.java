package ro.tuc.ds2020.services.rightverifier;

import ro.tuc.ds2020.entities.Admin;
import ro.tuc.ds2020.entities.Client;
import ro.tuc.ds2020.entities.User;
import ro.tuc.ds2020.services.rightverifier.strategies.AdminRightVerifierStrategy;
import ro.tuc.ds2020.services.rightverifier.strategies.ClientRightVerifierStrategy;

/**
 * Constructs the RightVerifier corresponding to the type of a user.
 */
public class RightVerifierFactory {

    /**
     * Constructs the RightVerifier corresponding to the type of a user.
     * @param user is the user to whose type the verifier is adjusted.
     * @return the constructed RightVerifier.
     */
    public static IRightVerifier getRightVerifier(User user) {
        if (user instanceof Admin) {
            return new AdminRightVerifierStrategy();
        }
        if (user instanceof Client) {
            return new ClientRightVerifierStrategy();
        }
        throw new IllegalArgumentException("Unknown user type");
    }
}
