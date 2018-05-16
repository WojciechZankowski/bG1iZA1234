package pl.zankowski.lmbd.core.exception;

public class LmbdSystemException extends RuntimeException {

    public LmbdSystemException() {
    }

    public LmbdSystemException(final String message) {
        super(message);
    }

    public LmbdSystemException(final String message, final Throwable cause) {
        super(message, cause);
    }

}
