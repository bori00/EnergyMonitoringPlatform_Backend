package ro.tuc.webapp.services.rightverifier;

import ro.tuc.webapp.entities.Admin;
import ro.tuc.webapp.entities.Client;
import ro.tuc.webapp.entities.User;
import ro.tuc.webapp.services.rightverifier.strategies.AdminRightVerifierStrategy;
import ro.tuc.webapp.services.rightverifier.strategies.ClientRightVerifierStrategy;

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
