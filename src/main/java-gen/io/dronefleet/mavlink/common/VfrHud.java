package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import java.lang.Object;
import java.lang.Override;
import java.util.Objects;

/**
 * Metrics typically displayed on a HUD for fixed wing aircraft 
 */
@MavlinkMessageInfo(
        id = 74,
        crc = 20
)
public final class VfrHud {
    private final float airspeed;

    private final float groundspeed;

    private final int heading;

    private final int throttle;

    private final float alt;

    private final float climb;

    private VfrHud(float airspeed, float groundspeed, int heading, int throttle, float alt,
            float climb) {
        this.airspeed = airspeed;
        this.groundspeed = groundspeed;
        this.heading = heading;
        this.throttle = throttle;
        this.alt = alt;
        this.climb = climb;
    }

    /**
     * Returns a builder instance for this message.
     */
    @MavlinkMessageBuilder
    public static Builder builder() {
        return new Builder();
    }

    /**
     * Current airspeed in m/s 
     */
    @MavlinkFieldInfo(
            position = 1,
            unitSize = 4
    )
    public final float airspeed() {
        return this.airspeed;
    }

    /**
     * Current ground speed in m/s 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 4
    )
    public final float groundspeed() {
        return this.groundspeed;
    }

    /**
     * Current heading in degrees, in compass units (0..360, 0=north) 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 2,
            signed = true
    )
    public final int heading() {
        return this.heading;
    }

    /**
     * Current throttle setting in integer percent, 0 to 100 
     */
    @MavlinkFieldInfo(
            position = 4,
            unitSize = 2
    )
    public final int throttle() {
        return this.throttle;
    }

    /**
     * Current altitude (MSL), in meters 
     */
    @MavlinkFieldInfo(
            position = 5,
            unitSize = 4
    )
    public final float alt() {
        return this.alt;
    }

    /**
     * Current climb rate in meters/second 
     */
    @MavlinkFieldInfo(
            position = 6,
            unitSize = 4
    )
    public final float climb() {
        return this.climb;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !getClass().equals(o.getClass())) return false;
        VfrHud other = (VfrHud)o;
        if (!Objects.deepEquals(airspeed, other.airspeed)) return false;
        if (!Objects.deepEquals(groundspeed, other.groundspeed)) return false;
        if (!Objects.deepEquals(heading, other.heading)) return false;
        if (!Objects.deepEquals(throttle, other.throttle)) return false;
        if (!Objects.deepEquals(alt, other.alt)) return false;
        if (!Objects.deepEquals(climb, other.climb)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + Objects.hashCode(airspeed);
        result = 31 * result + Objects.hashCode(groundspeed);
        result = 31 * result + Objects.hashCode(heading);
        result = 31 * result + Objects.hashCode(throttle);
        result = 31 * result + Objects.hashCode(alt);
        result = 31 * result + Objects.hashCode(climb);
        return result;
    }

    public static final class Builder {
        private float airspeed;

        private float groundspeed;

        private int heading;

        private int throttle;

        private float alt;

        private float climb;

        /**
         * Current airspeed in m/s 
         */
        @MavlinkFieldInfo(
                position = 1,
                unitSize = 4
        )
        public final Builder airspeed(float airspeed) {
            this.airspeed = airspeed;
            return this;
        }

        /**
         * Current ground speed in m/s 
         */
        @MavlinkFieldInfo(
                position = 2,
                unitSize = 4
        )
        public final Builder groundspeed(float groundspeed) {
            this.groundspeed = groundspeed;
            return this;
        }

        /**
         * Current heading in degrees, in compass units (0..360, 0=north) 
         */
        @MavlinkFieldInfo(
                position = 3,
                unitSize = 2,
                signed = true
        )
        public final Builder heading(int heading) {
            this.heading = heading;
            return this;
        }

        /**
         * Current throttle setting in integer percent, 0 to 100 
         */
        @MavlinkFieldInfo(
                position = 4,
                unitSize = 2
        )
        public final Builder throttle(int throttle) {
            this.throttle = throttle;
            return this;
        }

        /**
         * Current altitude (MSL), in meters 
         */
        @MavlinkFieldInfo(
                position = 5,
                unitSize = 4
        )
        public final Builder alt(float alt) {
            this.alt = alt;
            return this;
        }

        /**
         * Current climb rate in meters/second 
         */
        @MavlinkFieldInfo(
                position = 6,
                unitSize = 4
        )
        public final Builder climb(float climb) {
            this.climb = climb;
            return this;
        }

        public final VfrHud build() {
            return new VfrHud(airspeed, groundspeed, heading, throttle, alt, climb);
        }
    }
}
