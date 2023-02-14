package io.dronefleet.mavlink.avssuas;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;

/**
 * Drone position. 
 */
@MavlinkMessageInfo(
        id = 60051,
        crc = 245,
        description = "Drone position."
)
public final class AvssDronePosition {
    private final long timeBootMs;

    private final int lat;

    private final int lon;

    private final int alt;

    private final float groundAlt;

    private final float barometerAlt;

    private AvssDronePosition(long timeBootMs, int lat, int lon, int alt, float groundAlt,
            float barometerAlt) {
        this.timeBootMs = timeBootMs;
        this.lat = lat;
        this.lon = lon;
        this.alt = alt;
        this.groundAlt = groundAlt;
        this.barometerAlt = barometerAlt;
    }

    /**
     * Returns a builder instance for this message.
     */
    @MavlinkMessageBuilder
    public static Builder builder() {
        return new Builder();
    }

    /**
     * Timestamp (time since FC boot). 
     */
    @MavlinkFieldInfo(
            position = 1,
            unitSize = 4,
            description = "Timestamp (time since FC boot)."
    )
    public final long timeBootMs() {
        return this.timeBootMs;
    }

    /**
     * Latitude, expressed 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 4,
            signed = true,
            description = "Latitude, expressed"
    )
    public final int lat() {
        return this.lat;
    }

    /**
     * Longitude, expressed 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 4,
            signed = true,
            description = "Longitude, expressed"
    )
    public final int lon() {
        return this.lon;
    }

    /**
     * Altitude (MSL). Note that virtually all GPS modules provide both WGS84 and MSL. 
     */
    @MavlinkFieldInfo(
            position = 4,
            unitSize = 4,
            signed = true,
            description = "Altitude (MSL). Note that virtually all GPS modules provide both WGS84 and MSL."
    )
    public final int alt() {
        return this.alt;
    }

    /**
     * Altitude above ground, This altitude is measured by a ultrasound, Laser rangefinder or 
     * millimeter-wave radar 
     */
    @MavlinkFieldInfo(
            position = 5,
            unitSize = 4,
            description = "Altitude above ground, This altitude is measured by a ultrasound, Laser rangefinder or millimeter-wave radar"
    )
    public final float groundAlt() {
        return this.groundAlt;
    }

    /**
     * This altitude is measured by a barometer 
     */
    @MavlinkFieldInfo(
            position = 6,
            unitSize = 4,
            description = "This altitude is measured by a barometer"
    )
    public final float barometerAlt() {
        return this.barometerAlt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !getClass().equals(o.getClass())) return false;
        AvssDronePosition other = (AvssDronePosition)o;
        if (!Objects.deepEquals(timeBootMs, other.timeBootMs)) return false;
        if (!Objects.deepEquals(lat, other.lat)) return false;
        if (!Objects.deepEquals(lon, other.lon)) return false;
        if (!Objects.deepEquals(alt, other.alt)) return false;
        if (!Objects.deepEquals(groundAlt, other.groundAlt)) return false;
        if (!Objects.deepEquals(barometerAlt, other.barometerAlt)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + Objects.hashCode(timeBootMs);
        result = 31 * result + Objects.hashCode(lat);
        result = 31 * result + Objects.hashCode(lon);
        result = 31 * result + Objects.hashCode(alt);
        result = 31 * result + Objects.hashCode(groundAlt);
        result = 31 * result + Objects.hashCode(barometerAlt);
        return result;
    }

    @Override
    public String toString() {
        return "AvssDronePosition{timeBootMs=" + timeBootMs
                 + ", lat=" + lat
                 + ", lon=" + lon
                 + ", alt=" + alt
                 + ", groundAlt=" + groundAlt
                 + ", barometerAlt=" + barometerAlt + "}";
    }

    public static final class Builder {
        private long timeBootMs;

        private int lat;

        private int lon;

        private int alt;

        private float groundAlt;

        private float barometerAlt;

        /**
         * Timestamp (time since FC boot). 
         */
        @MavlinkFieldInfo(
                position = 1,
                unitSize = 4,
                description = "Timestamp (time since FC boot)."
        )
        public final Builder timeBootMs(long timeBootMs) {
            this.timeBootMs = timeBootMs;
            return this;
        }

        /**
         * Latitude, expressed 
         */
        @MavlinkFieldInfo(
                position = 2,
                unitSize = 4,
                signed = true,
                description = "Latitude, expressed"
        )
        public final Builder lat(int lat) {
            this.lat = lat;
            return this;
        }

        /**
         * Longitude, expressed 
         */
        @MavlinkFieldInfo(
                position = 3,
                unitSize = 4,
                signed = true,
                description = "Longitude, expressed"
        )
        public final Builder lon(int lon) {
            this.lon = lon;
            return this;
        }

        /**
         * Altitude (MSL). Note that virtually all GPS modules provide both WGS84 and MSL. 
         */
        @MavlinkFieldInfo(
                position = 4,
                unitSize = 4,
                signed = true,
                description = "Altitude (MSL). Note that virtually all GPS modules provide both WGS84 and MSL."
        )
        public final Builder alt(int alt) {
            this.alt = alt;
            return this;
        }

        /**
         * Altitude above ground, This altitude is measured by a ultrasound, Laser rangefinder or 
         * millimeter-wave radar 
         */
        @MavlinkFieldInfo(
                position = 5,
                unitSize = 4,
                description = "Altitude above ground, This altitude is measured by a ultrasound, Laser rangefinder or millimeter-wave radar"
        )
        public final Builder groundAlt(float groundAlt) {
            this.groundAlt = groundAlt;
            return this;
        }

        /**
         * This altitude is measured by a barometer 
         */
        @MavlinkFieldInfo(
                position = 6,
                unitSize = 4,
                description = "This altitude is measured by a barometer"
        )
        public final Builder barometerAlt(float barometerAlt) {
            this.barometerAlt = barometerAlt;
            return this;
        }

        public final AvssDronePosition build() {
            return new AvssDronePosition(timeBootMs, lat, lon, alt, groundAlt, barometerAlt);
        }
    }
}
