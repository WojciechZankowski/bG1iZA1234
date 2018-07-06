package pl.lodomaniak.user.api.exception;

import pl.lodomaniak.core.exception.LodomaniakSystemException;

public class UserAlreadyExistsException extends LodomaniakSystemException {

    public UserAlreadyExistsException(final String message) {
        super(message);
    }

}
