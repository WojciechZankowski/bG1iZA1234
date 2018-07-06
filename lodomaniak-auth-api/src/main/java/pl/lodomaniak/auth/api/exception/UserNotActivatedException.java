package pl.lodomaniak.auth.api.exception;

import org.springframework.security.core.AuthenticationException;

public class UserNotActivatedException extends AuthenticationException {

    private static final long serialVersionUID = 667263396466809041L;

    public UserNotActivatedException(final String msg) {
        super(msg);
    }

    public UserNotActivatedException(final String msg, final Throwable t) {
        super(msg, t);
    }
}
