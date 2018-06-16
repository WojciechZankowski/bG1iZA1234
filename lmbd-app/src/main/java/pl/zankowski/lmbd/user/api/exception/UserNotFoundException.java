package pl.zankowski.lmbd.user.api.exception;

import pl.zankowski.lmbd.core.exception.LmbdBusinessException;

public class UserNotFoundException extends LmbdBusinessException {

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
