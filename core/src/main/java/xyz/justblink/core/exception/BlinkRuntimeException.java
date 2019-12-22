package xyz.justblink.core.exception;

public class BlinkRuntimeException extends RuntimeException {
    public BlinkRuntimeException(String message) {
        super(message);
    }

    public BlinkRuntimeException(String message, Throwable cause) {
        super(message, cause);
    }
}
