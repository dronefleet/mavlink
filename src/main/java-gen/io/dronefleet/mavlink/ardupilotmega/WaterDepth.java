package io.dronefleet.mavlink.ardupilotmega;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;

/**
 * Water depth 
 */
@MavlinkMessageInfo(
        id = 11038,
        crc = 47,
        description = "Water depth"
)
public final class WaterDepth {
    private final long timeBootMs;

    private final int id;

    private final int healthy;

    private final int lat;

    private final int lng;

    private final float alt;

    private final float roll;

    private final float pitch;

    private final float yaw;

    private final float distance;

    private final float temperature;

    private WaterDepth(long timeBootMs, int id, int healthy, int lat, int lng, float alt,
            float roll, float pitch, float yaw, float distance, float temperature) {
        this.timeBootMs = timeBootMs;
        this.id = id;
        this.healthy = healthy;
        this.lat = lat;
        this.lng = lng;
        this.alt = alt;
        this.roll = roll;
        this.pitch = pitch;
        this.yaw = yaw;
        this.distance = distance;
        this.temperature = temperature;
    }

    /**
     * Returns a builder instance for this message.
     */
    @MavlinkMessageBuilder
    public static Builder builder() {
        return new Builder();
    }

    /**
     * Timestamp (time since system boot) 
     */
    @MavlinkFieldInfo(
            position = 1,
            unitSize = 4,
            description = "Timestamp (time since system boot)"
    )
    public final long timeBootMs() {
        return this.timeBootMs;
    }

    /**
     * Onboard ID of the sensor 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 1,
            description = "Onboard ID of the sensor"
    )
    public final int id() {
        return this.id;
    }

    /**
     * Sensor data healthy (0=unhealthy, 1=healthy) 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 1,
            description = "Sensor data healthy (0=unhealthy, 1=healthy)"
    )
    public final int healthy() {
        return this.healthy;
    }

    /**
     * Latitude 
     */
    @MavlinkFieldInfo(
            position = 4,
            unitSize = 4,
            signed = true,
            description = "Latitude"
    )
    public final int lat() {
        return this.lat;
    }

    /**
     * Longitude 
     */
    @MavlinkFieldInfo(
            position = 5,
            unitSize = 4,
            signed = true,
            description = "Longitude"
    )
    public final int lng() {
        return this.lng;
    }

    /**
     * Altitude (MSL) of vehicle 
     */
    @MavlinkFieldInfo(
            position = 6,
            unitSize = 4,
            description = "Altitude (MSL) of vehicle"
    )
    public final float alt() {
        return this.alt;
    }

    /**
     * Roll angle 
     */
    @MavlinkFieldInfo(
            position = 7,
            unitSize = 4,
            description = "Roll angle"
    )
    public final float roll() {
        return this.roll;
    }

    /**
     * Pitch angle 
     */
    @MavlinkFieldInfo(
            position = 8,
            unitSize = 4,
            description = "Pitch angle"
    )
    public final float pitch() {
        return this.pitch;
    }

    /**
     * Yaw angle 
     */
    @MavlinkFieldInfo(
            position = 9,
            unitSize = 4,
            description = "Yaw angle"
    )
    public final float yaw() {
        return this.yaw;
    }

    /**
     * Distance (uncorrected) 
     */
    @MavlinkFieldInfo(
            position = 10,
            unitSize = 4,
            description = "Distance (uncorrected)"
    )
    public final float distance() {
        return this.distance;
    }

    /**
     * Water temperature 
     */
    @MavlinkFieldInfo(
            position = 11,
            unitSize = 4,
            description = "Water temperature"
    )
    public final float temperature() {
        return this.temperature;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !getClass().equals(o.getClass())) return false;
        WaterDepth other = (WaterDepth)o;
        if (!Objects.deepEquals(timeBootMs, other.timeBootMs)) return false;
        if (!Objects.deepEquals(id, other.id)) return false;
        if (!Objects.deepEquals(healthy, other.healthy)) return false;
        if (!Objects.deepEquals(lat, other.lat)) return false;
        if (!Objects.deepEquals(lng, other.lng)) return false;
        if (!Objects.deepEquals(alt, other.alt)) return false;
        if (!Objects.deepEquals(roll, other.roll)) return false;
        if (!Objects.deepEquals(pitch, other.pitch)) return false;
        if (!Objects.deepEquals(yaw, other.yaw)) return false;
        if (!Objects.deepEquals(distance, other.distance)) return false;
        if (!Objects.deepEquals(temperature, other.temperature)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + Objects.hashCode(timeBootMs);
        result = 31 * result + Objects.hashCode(id);
        result = 31 * result + Objects.hashCode(healthy);
        result = 31 * result + Objects.hashCode(lat);
        result = 31 * result + Objects.hashCode(lng);
        result = 31 * result + Objects.hashCode(alt);
        result = 31 * result + Objects.hashCode(roll);
        result = 31 * result + Objects.hashCode(pitch);
        result = 31 * result + Objects.hashCode(yaw);
        result = 31 * result + Objects.hashCode(distance);
        result = 31 * result + Objects.hashCode(temperature);
        return result;
    }

    @Override
    public String toString() {
        return "WaterDepth{timeBootMs=" + timeBootMs
                 + ", id=" + id
                 + ", healthy=" + healthy
                 + ", lat=" + lat
                 + ", lng=" + lng
                 + ", alt=" + alt
                 + ", roll=" + roll
                 + ", pitch=" + pitch
                 + ", yaw=" + yaw
                 + ", distance=" + distance
                 + ", temperature=" + temperature + "}";
    }

    public static final class Builder {
        private long timeBootMs;

        private int id;

        private int healthy;

        private int lat;

        private int lng;

        private float alt;

        private float roll;

        private float pitch;

        private float yaw;

        private float distance;

        private float temperature;

        /**
         * Timestamp (time since system boot) 
         */
        @MavlinkFieldInfo(
                position = 1,
                unitSize = 4,
                description = "Timestamp (time since system boot)"
        )
        public final Builder timeBootMs(long timeBootMs) {
            this.timeBootMs = timeBootMs;
            return this;
        }

        /**
         * Onboard ID of the sensor 
         */
        @MavlinkFieldInfo(
                position = 2,
                unitSize = 1,
                description = "Onboard ID of the sensor"
        )
        public final Builder id(int id) {
            this.id = id;
            return this;
        }

        /**
         * Sensor data healthy (0=unhealthy, 1=healthy) 
         */
        @MavlinkFieldInfo(
                position = 3,
                unitSize = 1,
                description = "Sensor data healthy (0=unhealthy, 1=healthy)"
        )
        public final Builder healthy(int healthy) {
            this.healthy = healthy;
            return this;
        }

        /**
         * Latitude 
         */
        @MavlinkFieldInfo(
                position = 4,
                unitSize = 4,
                signed = true,
                description = "Latitude"
        )
        public final Builder lat(int lat) {
            this.lat = lat;
            return this;
        }

        /**
         * Longitude 
         */
        @MavlinkFieldInfo(
                position = 5,
                unitSize = 4,
                signed = true,
                description = "Longitude"
        )
        public final Builder lng(int lng) {
            this.lng = lng;
            return this;
        }

        /**
         * Altitude (MSL) of vehicle 
         */
        @MavlinkFieldInfo(
                position = 6,
                unitSize = 4,
                description = "Altitude (MSL) of vehicle"
        )
        public final Builder alt(float alt) {
            this.alt = alt;
            return this;
        }

        /**
         * Roll angle 
         */
        @MavlinkFieldInfo(
                position = 7,
                unitSize = 4,
                description = "Roll angle"
        )
        public final Builder roll(float roll) {
            this.roll = roll;
            return this;
        }

        /**
         * Pitch angle 
         */
        @MavlinkFieldInfo(
                position = 8,
                unitSize = 4,
                description = "Pitch angle"
        )
        public final Builder pitch(float pitch) {
            this.pitch = pitch;
            return this;
        }

        /**
         * Yaw angle 
         */
        @MavlinkFieldInfo(
                position = 9,
                unitSize = 4,
                description = "Yaw angle"
        )
        public final Builder yaw(float yaw) {
            this.yaw = yaw;
            return this;
        }

        /**
         * Distance (uncorrected) 
         */
        @MavlinkFieldInfo(
                position = 10,
                unitSize = 4,
                description = "Distance (uncorrected)"
        )
        public final Builder distance(float distance) {
            this.distance = distance;
            return this;
        }

        /**
         * Water temperature 
         */
        @MavlinkFieldInfo(
                position = 11,
                unitSize = 4,
                description = "Water temperature"
        )
        public final Builder temperature(float temperature) {
            this.temperature = temperature;
            return this;
        }

        public final WaterDepth build() {
            return new WaterDepth(timeBootMs, id, healthy, lat, lng, alt, roll, pitch, yaw, distance, temperature);
        }
    }
}
