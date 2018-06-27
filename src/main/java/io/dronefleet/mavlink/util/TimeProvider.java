package io.dronefleet.mavlink.util;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;

/**
 * Provides time
 */
public interface TimeProvider {

    /**
     * A time provider that uses the system's clock to calculate durations.
     */
    TimeProvider SYSTEM_CLOCK = () -> {
        Duration elapsed = Duration.between(
                LocalDateTime.of(2015, 1, 1, 0, 0),
                Instant.now());
        return elapsed.getSeconds() * 1000000 + elapsed.getNano() / 1000;
    };

    /**
     * Returns the amount of microseconds since January 1st of 2015 GMT.
     */
    long microsSince1stJan2015GMT();
}
