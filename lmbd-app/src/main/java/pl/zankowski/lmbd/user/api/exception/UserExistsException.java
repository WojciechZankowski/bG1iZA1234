package pl.zankowski.lmbd.user.api.exception;

import pl.zankowski.lmbd.core.exception.LmbdSystemException;

public class UserExistsException extends LmbdSystemException {

    public UserExistsException(final String message) {
        super(message);
    }

}
