package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import java.math.BigInteger;

/**
 * WIP: Information about flight since last arming 
 */
@MavlinkMessageInfo(
        id = 264,
        crc = 49
)
public final class FlightInformation {
    private final long timeBootMs;

    private final BigInteger armingTimeUtc;

    private final BigInteger takeoffTimeUtc;

    private final BigInteger flightUuid;

    private FlightInformation(long timeBootMs, BigInteger armingTimeUtc, BigInteger takeoffTimeUtc,
            BigInteger flightUuid) {
        this.timeBootMs = timeBootMs;
        this.armingTimeUtc = armingTimeUtc;
        this.takeoffTimeUtc = takeoffTimeUtc;
        this.flightUuid = flightUuid;
    }

    /**
     * Returns a builder instance for this message.
     */
    @MavlinkMessageBuilder
    public static Builder builder() {
        return new Builder();
    }

    /**
     * Timestamp (milliseconds since system boot) 
     */
    @MavlinkFieldInfo(
            position = 1,
            unitSize = 4
    )
    public final long timeBootMs() {
        return this.timeBootMs;
    }

    /**
     * Timestamp at arming (microseconds since UNIX epoch) in UTC, 0 for unknown 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 8
    )
    public final BigInteger armingTimeUtc() {
        return this.armingTimeUtc;
    }

    /**
     * Timestamp at takeoff (microseconds since UNIX epoch) in UTC, 0 for unknown 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 8
    )
    public final BigInteger takeoffTimeUtc() {
        return this.takeoffTimeUtc;
    }

    /**
     * Universally unique identifier (UUID) of flight, should correspond to name of logfiles 
     */
    @MavlinkFieldInfo(
            position = 4,
            unitSize = 8
    )
    public final BigInteger flightUuid() {
        return this.flightUuid;
    }

    public static final class Builder {
        private long timeBootMs;

        private BigInteger armingTimeUtc;

        private BigInteger takeoffTimeUtc;

        private BigInteger flightUuid;

        /**
         * Timestamp (milliseconds since system boot) 
         */
        @MavlinkFieldInfo(
                position = 1,
                unitSize = 4
        )
        public final Builder timeBootMs(long timeBootMs) {
            this.timeBootMs = timeBootMs;
            return this;
        }

        /**
         * Timestamp at arming (microseconds since UNIX epoch) in UTC, 0 for unknown 
         */
        @MavlinkFieldInfo(
                position = 2,
                unitSize = 8
        )
        public final Builder armingTimeUtc(BigInteger armingTimeUtc) {
            this.armingTimeUtc = armingTimeUtc;
            return this;
        }

        /**
         * Timestamp at takeoff (microseconds since UNIX epoch) in UTC, 0 for unknown 
         */
        @MavlinkFieldInfo(
                position = 3,
                unitSize = 8
        )
        public final Builder takeoffTimeUtc(BigInteger takeoffTimeUtc) {
            this.takeoffTimeUtc = takeoffTimeUtc;
            return this;
        }

        /**
         * Universally unique identifier (UUID) of flight, should correspond to name of logfiles 
         */
        @MavlinkFieldInfo(
                position = 4,
                unitSize = 8
        )
        public final Builder flightUuid(BigInteger flightUuid) {
            this.flightUuid = flightUuid;
            return this;
        }

        public final FlightInformation build() {
            return new FlightInformation(timeBootMs, armingTimeUtc, takeoffTimeUtc, flightUuid);
        }
    }
}
