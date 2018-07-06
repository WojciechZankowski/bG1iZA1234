package pl.lodomaniak.user.api.exception;

import pl.lodomaniak.core.exception.LodomaniakBusinessException;

public class UserNotFoundException extends LodomaniakBusinessException {

    private static final long serialVersionUID = -4029195569792530774L;

    public UserNotFoundException() {
    }

    public UserNotFoundException(final String message) {
        super(message);
    }

    public UserNotFoundException(final String message, final Throwable cause) {
        super(message, cause);
    }
}
