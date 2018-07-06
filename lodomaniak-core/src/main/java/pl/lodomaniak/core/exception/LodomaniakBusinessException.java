package pl.lodomaniak.core.exception;

public class LodomaniakBusinessException extends Exception {

    public LodomaniakBusinessException() {
    }

    public LodomaniakBusinessException(final String message) {
        super(message);
    }

    public LodomaniakBusinessException(final String message, final Throwable cause) {
        super(message, cause);
    }

}
