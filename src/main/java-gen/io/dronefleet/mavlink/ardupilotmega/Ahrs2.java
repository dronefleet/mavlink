package io.dronefleet.mavlink.ardupilotmega;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;

/**
 * Status of secondary {@link io.dronefleet.mavlink.ardupilotmega.Ahrs AHRS} filter if available 
 */
@MavlinkMessageInfo(
        id = 178,
        crc = 47
)
public final class Ahrs2 {
    private final float roll;

    private final float pitch;

    private final float yaw;

    private final float altitude;

    private final int lat;

    private final int lng;

    private Ahrs2(float roll, float pitch, float yaw, float altitude, int lat, int lng) {
        this.roll = roll;
        this.pitch = pitch;
        this.yaw = yaw;
        this.altitude = altitude;
        this.lat = lat;
        this.lng = lng;
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

    public static final class Builder {
        private float roll;

        private float pitch;

        private float yaw;

        private float altitude;

        private int lat;

        private int lng;

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

        public final Ahrs2 build() {
            return new Ahrs2(roll, pitch, yaw, altitude, lat, lng);
        }
    }
}
