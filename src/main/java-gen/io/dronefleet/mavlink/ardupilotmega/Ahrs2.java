package io.dronefleet.mavlink.ardupilotmega;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;

/**
 * Status of secondary {@link io.dronefleet.mavlink.ardupilotmega.Ahrs AHRS} filter if available. 
 */
@MavlinkMessageInfo(
        id = 178,
        crc = 47,
        description = "Status of secondary AHRS filter if available."
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
     * Roll angle. 
     */
    @MavlinkFieldInfo(
            position = 1,
            unitSize = 4,
            description = "Roll angle."
    )
    public final float roll() {
        return this.roll;
    }

    /**
     * Pitch angle. 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 4,
            description = "Pitch angle."
    )
    public final float pitch() {
        return this.pitch;
    }

    /**
     * Yaw angle. 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 4,
            description = "Yaw angle."
    )
    public final float yaw() {
        return this.yaw;
    }

    /**
     * Altitude (MSL). 
     */
    @MavlinkFieldInfo(
            position = 4,
            unitSize = 4,
            description = "Altitude (MSL)."
    )
    public final float altitude() {
        return this.altitude;
    }

    /**
     * Latitude. 
     */
    @MavlinkFieldInfo(
            position = 5,
            unitSize = 4,
            signed = true,
            description = "Latitude."
    )
    public final int lat() {
        return this.lat;
    }

    /**
     * Longitude. 
     */
    @MavlinkFieldInfo(
            position = 6,
            unitSize = 4,
            signed = true,
            description = "Longitude."
    )
    public final int lng() {
        return this.lng;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !getClass().equals(o.getClass())) return false;
        Ahrs2 other = (Ahrs2)o;
        if (!Objects.deepEquals(roll, other.roll)) return false;
        if (!Objects.deepEquals(pitch, other.pitch)) return false;
        if (!Objects.deepEquals(yaw, other.yaw)) return false;
        if (!Objects.deepEquals(altitude, other.altitude)) return false;
        if (!Objects.deepEquals(lat, other.lat)) return false;
        if (!Objects.deepEquals(lng, other.lng)) return false;
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
        return result;
    }

    @Override
    public String toString() {
        return "Ahrs2{roll=" + roll
                 + ", pitch=" + pitch
                 + ", yaw=" + yaw
                 + ", altitude=" + altitude
                 + ", lat=" + lat
                 + ", lng=" + lng + "}";
    }

    public static final class Builder {
        private float roll;

        private float pitch;

        private float yaw;

        private float altitude;

        private int lat;

        private int lng;

        /**
         * Roll angle. 
         */
        @MavlinkFieldInfo(
                position = 1,
                unitSize = 4,
                description = "Roll angle."
        )
        public final Builder roll(float roll) {
            this.roll = roll;
            return this;
        }

        /**
         * Pitch angle. 
         */
        @MavlinkFieldInfo(
                position = 2,
                unitSize = 4,
                description = "Pitch angle."
        )
        public final Builder pitch(float pitch) {
            this.pitch = pitch;
            return this;
        }

        /**
         * Yaw angle. 
         */
        @MavlinkFieldInfo(
                position = 3,
                unitSize = 4,
                description = "Yaw angle."
        )
        public final Builder yaw(float yaw) {
            this.yaw = yaw;
            return this;
        }

        /**
         * Altitude (MSL). 
         */
        @MavlinkFieldInfo(
                position = 4,
                unitSize = 4,
                description = "Altitude (MSL)."
        )
        public final Builder altitude(float altitude) {
            this.altitude = altitude;
            return this;
        }

        /**
         * Latitude. 
         */
        @MavlinkFieldInfo(
                position = 5,
                unitSize = 4,
                signed = true,
                description = "Latitude."
        )
        public final Builder lat(int lat) {
            this.lat = lat;
            return this;
        }

        /**
         * Longitude. 
         */
        @MavlinkFieldInfo(
                position = 6,
                unitSize = 4,
                signed = true,
                description = "Longitude."
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
