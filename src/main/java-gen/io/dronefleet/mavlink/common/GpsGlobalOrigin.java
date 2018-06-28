package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import java.math.BigInteger;

/**
 * Once the MAV sets a new GPS-Local correspondence, this message announces the origin (0,0,0) 
 * position 
 */
@MavlinkMessageInfo(
        id = 49,
        crc = 23
)
public final class GpsGlobalOrigin {
    private final int latitude;

    private final int longitude;

    private final int altitude;

    private final BigInteger timeUsec;

    private GpsGlobalOrigin(int latitude, int longitude, int altitude, BigInteger timeUsec) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.altitude = altitude;
        this.timeUsec = timeUsec;
    }

    /**
     * Returns a builder instance for this message.
     */
    @MavlinkMessageBuilder
    public static Builder builder() {
        return new Builder();
    }

    /**
     * Latitude (WGS84), in degrees * 1E7 
     */
    @MavlinkFieldInfo(
            position = 1,
            unitSize = 4,
            signed = true
    )
    public final int latitude() {
        return this.latitude;
    }

    /**
     * Longitude (WGS84), in degrees * 1E7 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 4,
            signed = true
    )
    public final int longitude() {
        return this.longitude;
    }

    /**
     * Altitude (AMSL), in meters * 1000 (positive for up) 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 4,
            signed = true
    )
    public final int altitude() {
        return this.altitude;
    }

    /**
     * Timestamp (microseconds since UNIX epoch or microseconds since system boot) 
     */
    @MavlinkFieldInfo(
            position = 5,
            unitSize = 8,
            extension = true
    )
    public final BigInteger timeUsec() {
        return this.timeUsec;
    }

    public static final class Builder {
        private int latitude;

        private int longitude;

        private int altitude;

        private BigInteger timeUsec;

        /**
         * Latitude (WGS84), in degrees * 1E7 
         */
        @MavlinkFieldInfo(
                position = 1,
                unitSize = 4,
                signed = true
        )
        public final Builder latitude(int latitude) {
            this.latitude = latitude;
            return this;
        }

        /**
         * Longitude (WGS84), in degrees * 1E7 
         */
        @MavlinkFieldInfo(
                position = 2,
                unitSize = 4,
                signed = true
        )
        public final Builder longitude(int longitude) {
            this.longitude = longitude;
            return this;
        }

        /**
         * Altitude (AMSL), in meters * 1000 (positive for up) 
         */
        @MavlinkFieldInfo(
                position = 3,
                unitSize = 4,
                signed = true
        )
        public final Builder altitude(int altitude) {
            this.altitude = altitude;
            return this;
        }

        /**
         * Timestamp (microseconds since UNIX epoch or microseconds since system boot) 
         */
        @MavlinkFieldInfo(
                position = 5,
                unitSize = 8,
                extension = true
        )
        public final Builder timeUsec(BigInteger timeUsec) {
            this.timeUsec = timeUsec;
            return this;
        }

        public final GpsGlobalOrigin build() {
            return new GpsGlobalOrigin(latitude, longitude, altitude, timeUsec);
        }
    }
}
