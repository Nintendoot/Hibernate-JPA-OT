package by.nintendo.exception;

public class NotAllDataEnteredException extends RuntimeException{
    public NotAllDataEnteredException() {
        super();
    }

    public NotAllDataEnteredException(String message) {
        super(message);
    }

    public NotAllDataEnteredException(String message, Throwable cause) {
        super(message, cause);
    }

    public NotAllDataEnteredException(Throwable cause) {
        super(cause);
    }

    protected NotAllDataEnteredException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
