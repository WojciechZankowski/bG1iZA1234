package pl.zankowski.lmbd.core.exception;

public class LmbdBusinessException extends Exception {

    public LmbdBusinessException() {
    }

    public LmbdBusinessException(final String message) {
        super(message);
    }

    public LmbdBusinessException(final String message, final Throwable cause) {
        super(message, cause);
    }

}
