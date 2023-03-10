package ro.tuc.webapp.controllers.handlers.exceptions.model.authentication;

import org.springframework.http.HttpStatus;
import ro.tuc.webapp.controllers.handlers.exceptions.model.CustomException;

import java.util.ArrayList;

public class SelfDeletionException extends CustomException {
    private static final String MESSAGE = "You can't delete your own user account.";
    private static final HttpStatus httpStatus = HttpStatus.UNAUTHORIZED;

    public SelfDeletionException(String resource) {
        super(MESSAGE, httpStatus, resource, new ArrayList<>());
    }
}
