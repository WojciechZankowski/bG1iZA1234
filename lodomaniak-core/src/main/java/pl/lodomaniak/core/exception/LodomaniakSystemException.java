package pl.lodomaniak.core.exception;

public class LodomaniakSystemException extends RuntimeException {

    public LodomaniakSystemException() {
    }

    public LodomaniakSystemException(final String message) {
        super(message);
    }

    public LodomaniakSystemException(final String message, final Throwable cause) {
        super(message, cause);
    }

}
