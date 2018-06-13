package io.dronefleet.mavlink.protocol;

public class MavlinkException extends RuntimeException {
    public MavlinkException() {
    }

    public MavlinkException(String message) {
        super(message);
    }

    public MavlinkException(String message, Throwable cause) {
        super(message, cause);
    }

    public MavlinkException(Throwable cause) {
        super(cause);
    }

    public MavlinkException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
