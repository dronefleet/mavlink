package io.dronefleet.mavlink.ardupilotmega;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import java.lang.Override;
import java.lang.String;

/**
 * Rangefinder reporting 
 */
@MavlinkMessageInfo(
        id = 173,
        crc = 83
)
public final class Rangefinder {
    /**
     * distance in meters 
     */
    private final float distance;

    /**
     * raw voltage if available, zero otherwise 
     */
    private final float voltage;

    private Rangefinder(float distance, float voltage) {
        this.distance = distance;
        this.voltage = voltage;
    }

    @MavlinkMessageBuilder
    public static Builder builder() {
        return new Builder();
    }

    @Override
    public String toString() {
        return "Rangefinder{distance=" + distance
                 + ", voltage=" + voltage + "}";
    }

    /**
     * distance in meters 
     */
    @MavlinkFieldInfo(
            position = 1,
            unitSize = 4
    )
    public final float distance() {
        return distance;
    }

    /**
     * raw voltage if available, zero otherwise 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 4
    )
    public final float voltage() {
        return voltage;
    }

    public static class Builder {
        private float distance;

        private float voltage;

        private Builder() {
        }

        /**
         * distance in meters 
         */
        @MavlinkFieldInfo(
                position = 1,
                unitSize = 4
        )
        public final Builder distance(float distance) {
            this.distance = distance;
            return this;
        }

        /**
         * raw voltage if available, zero otherwise 
         */
        @MavlinkFieldInfo(
                position = 2,
                unitSize = 4
        )
        public final Builder voltage(float voltage) {
            this.voltage = voltage;
            return this;
        }

        public final Rangefinder build() {
            return new Rangefinder(distance, voltage);
        }
    }
}
