package pl.zankowski.lmbd.user.api.exception;

import pl.zankowski.lmbd.core.exception.LmbdSystemException;

public class UserAlreadyExistsException extends LmbdSystemException {

    public UserAlreadyExistsException(final String message) {
        super(message);
    }

}
