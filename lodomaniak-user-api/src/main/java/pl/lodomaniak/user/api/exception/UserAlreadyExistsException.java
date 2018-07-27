package pl.lodomaniak.user.api.exception;

import pl.lodomaniak.core.exception.LodomaniakSystemException;

public class UserAlreadyExistsException extends LodomaniakSystemException {

    private static final long serialVersionUID = 3817183844741330445L;

    public UserAlreadyExistsException(final String message) {
        super(message);
    }

}
