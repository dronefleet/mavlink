package io.dronefleet.mavlink.serialization;

public class MavlinkSerializationException extends RuntimeException {
    public MavlinkSerializationException() {
    }

    public MavlinkSerializationException(String message) {
        super(message);
    }

    public MavlinkSerializationException(String message, Throwable cause) {
        super(message, cause);
    }

    public MavlinkSerializationException(Throwable cause) {
        super(cause);
    }

    public MavlinkSerializationException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
