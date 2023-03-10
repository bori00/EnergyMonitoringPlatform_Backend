package ro.tuc.webapp.controllers.handlers.exceptions.model.authentication;

import org.springframework.http.HttpStatus;
import ro.tuc.webapp.controllers.handlers.exceptions.model.CustomException;

import java.util.ArrayList;

public class AccessRoleRequiredException extends CustomException {
    private static final String MESSAGE_FORMAT = "To access this resource/functionality, you must" +
            " be logged in as a %s.";
    private static final HttpStatus httpStatus = HttpStatus.UNAUTHORIZED;

    public AccessRoleRequiredException(String resource, String userType) {
        super(String.format(MESSAGE_FORMAT, userType), httpStatus, resource, new ArrayList<>());
    }
}
