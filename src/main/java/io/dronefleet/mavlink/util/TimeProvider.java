package io.dronefleet.mavlink.util;

import java.time.*;

/**
 * Provides time
 */
public interface TimeProvider {

    /**
     * A time provider that uses the system's clock to get the time.
     */
    TimeProvider SYSTEM_CLOCK = () -> {
        Duration since1stJan2015GMT = Duration.between(
                OffsetDateTime.of(2015, 1, 1, 0, 0, 0, 0, ZoneOffset.UTC),
                OffsetDateTime.now(ZoneOffset.UTC));
        return since1stJan2015GMT.getSeconds() * 1000000 + since1stJan2015GMT.getNano() / 1000;
    };

    /**
     * Returns the amount of microseconds since January 1st of 2015 GMT.
     */
    long microsSince1stJan2015GMT();
}
