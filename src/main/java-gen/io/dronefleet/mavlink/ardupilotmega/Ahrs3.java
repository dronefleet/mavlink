package io.dronefleet.mavlink.ardupilotmega;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import java.lang.Object;
import java.lang.Override;
import java.util.Objects;

/**
 * Status of third {@link io.dronefleet.mavlink.ardupilotmega.Ahrs AHRS} filter if available. This is for ANU research group (Ali and Sean) 
 */
@MavlinkMessageInfo(
        id = 182,
        crc = 229
)
public final class Ahrs3 {
    private final float roll;

    private final float pitch;

    private final float yaw;

    private final float altitude;

    private final int lat;

    private final int lng;

    private final float v1;

    private final float v2;

    private final float v3;

    private final float v4;

    private Ahrs3(float roll, float pitch, float yaw, float altitude, int lat, int lng, float v1,
            float v2, float v3, float v4) {
        this.roll = roll;
        this.pitch = pitch;
        this.yaw = yaw;
        this.altitude = altitude;
        this.lat = lat;
        this.lng = lng;
        this.v1 = v1;
        this.v2 = v2;
        this.v3 = v3;
        this.v4 = v4;
    }

    /**
     * Returns a builder instance for this message.
     */
    @MavlinkMessageBuilder
    public static Builder builder() {
        return new Builder();
    }

    /**
     * Roll angle (rad) 
     */
    @MavlinkFieldInfo(
            position = 1,
            unitSize = 4
    )
    public final float roll() {
        return this.roll;
    }

    /**
     * Pitch angle (rad) 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 4
    )
    public final float pitch() {
        return this.pitch;
    }

    /**
     * Yaw angle (rad) 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 4
    )
    public final float yaw() {
        return this.yaw;
    }

    /**
     * Altitude (MSL) 
     */
    @MavlinkFieldInfo(
            position = 4,
            unitSize = 4
    )
    public final float altitude() {
        return this.altitude;
    }

    /**
     * Latitude in degrees * 1E7 
     */
    @MavlinkFieldInfo(
            position = 5,
            unitSize = 4,
            signed = true
    )
    public final int lat() {
        return this.lat;
    }

    /**
     * Longitude in degrees * 1E7 
     */
    @MavlinkFieldInfo(
            position = 6,
            unitSize = 4,
            signed = true
    )
    public final int lng() {
        return this.lng;
    }

    /**
     * test variable1 
     */
    @MavlinkFieldInfo(
            position = 7,
            unitSize = 4
    )
    public final float v1() {
        return this.v1;
    }

    /**
     * test variable2 
     */
    @MavlinkFieldInfo(
            position = 8,
            unitSize = 4
    )
    public final float v2() {
        return this.v2;
    }

    /**
     * test variable3 
     */
    @MavlinkFieldInfo(
            position = 9,
            unitSize = 4
    )
    public final float v3() {
        return this.v3;
    }

    /**
     * test variable4 
     */
    @MavlinkFieldInfo(
            position = 10,
            unitSize = 4
    )
    public final float v4() {
        return this.v4;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !getClass().equals(o.getClass())) return false;
        Ahrs3 other = (Ahrs3)o;
        if (!Objects.deepEquals(roll, other.roll)) return false;
        if (!Objects.deepEquals(pitch, other.pitch)) return false;
        if (!Objects.deepEquals(yaw, other.yaw)) return false;
        if (!Objects.deepEquals(altitude, other.altitude)) return false;
        if (!Objects.deepEquals(lat, other.lat)) return false;
        if (!Objects.deepEquals(lng, other.lng)) return false;
        if (!Objects.deepEquals(v1, other.v1)) return false;
        if (!Objects.deepEquals(v2, other.v2)) return false;
        if (!Objects.deepEquals(v3, other.v3)) return false;
        if (!Objects.deepEquals(v4, other.v4)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + Objects.hashCode(roll);
        result = 31 * result + Objects.hashCode(pitch);
        result = 31 * result + Objects.hashCode(yaw);
        result = 31 * result + Objects.hashCode(altitude);
        result = 31 * result + Objects.hashCode(lat);
        result = 31 * result + Objects.hashCode(lng);
        result = 31 * result + Objects.hashCode(v1);
        result = 31 * result + Objects.hashCode(v2);
        result = 31 * result + Objects.hashCode(v3);
        result = 31 * result + Objects.hashCode(v4);
        return result;
    }

    public static final class Builder {
        private float roll;

        private float pitch;

        private float yaw;

        private float altitude;

        private int lat;

        private int lng;

        private float v1;

        private float v2;

        private float v3;

        private float v4;

        /**
         * Roll angle (rad) 
         */
        @MavlinkFieldInfo(
                position = 1,
                unitSize = 4
        )
        public final Builder roll(float roll) {
            this.roll = roll;
            return this;
        }

        /**
         * Pitch angle (rad) 
         */
        @MavlinkFieldInfo(
                position = 2,
                unitSize = 4
        )
        public final Builder pitch(float pitch) {
            this.pitch = pitch;
            return this;
        }

        /**
         * Yaw angle (rad) 
         */
        @MavlinkFieldInfo(
                position = 3,
                unitSize = 4
        )
        public final Builder yaw(float yaw) {
            this.yaw = yaw;
            return this;
        }

        /**
         * Altitude (MSL) 
         */
        @MavlinkFieldInfo(
                position = 4,
                unitSize = 4
        )
        public final Builder altitude(float altitude) {
            this.altitude = altitude;
            return this;
        }

        /**
         * Latitude in degrees * 1E7 
         */
        @MavlinkFieldInfo(
                position = 5,
                unitSize = 4,
                signed = true
        )
        public final Builder lat(int lat) {
            this.lat = lat;
            return this;
        }

        /**
         * Longitude in degrees * 1E7 
         */
        @MavlinkFieldInfo(
                position = 6,
                unitSize = 4,
                signed = true
        )
        public final Builder lng(int lng) {
            this.lng = lng;
            return this;
        }

        /**
         * test variable1 
         */
        @MavlinkFieldInfo(
                position = 7,
                unitSize = 4
        )
        public final Builder v1(float v1) {
            this.v1 = v1;
            return this;
        }

        /**
         * test variable2 
         */
        @MavlinkFieldInfo(
                position = 8,
                unitSize = 4
        )
        public final Builder v2(float v2) {
            this.v2 = v2;
            return this;
        }

        /**
         * test variable3 
         */
        @MavlinkFieldInfo(
                position = 9,
                unitSize = 4
        )
        public final Builder v3(float v3) {
            this.v3 = v3;
            return this;
        }

        /**
         * test variable4 
         */
        @MavlinkFieldInfo(
                position = 10,
                unitSize = 4
        )
        public final Builder v4(float v4) {
            this.v4 = v4;
            return this;
        }

        public final Ahrs3 build() {
            return new Ahrs3(roll, pitch, yaw, altitude, lat, lng, v1, v2, v3, v4);
        }
    }
}
