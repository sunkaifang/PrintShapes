package exception;

public class BusinessException extends RuntimeException {
    public BusinessException() {
        super();
    }

    /**
     * We can also define some errorCode, to packet message into group.
     * Here we only use message for convenient.
     */
    public BusinessException(String message) {
        super(message);
    }

    public BusinessException(String message, Throwable cause) {
        super(message, cause);
    }
}
