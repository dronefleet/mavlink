package io.dronefleet.mavlink.ardupilotmega;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;

/**
 * Rangefinder reporting 
 */
@MavlinkMessageInfo(
        id = 173,
        crc = 83
)
public final class Rangefinder {
    private final float distance;

    private final float voltage;

    private Rangefinder(float distance, float voltage) {
        this.distance = distance;
        this.voltage = voltage;
    }

    /**
     * Returns a builder instance for this message.
     */
    @MavlinkMessageBuilder
    public static Builder builder() {
        return new Builder();
    }

    /**
     * distance in meters 
     */
    @MavlinkFieldInfo(
            position = 1,
            unitSize = 4
    )
    public final float distance() {
        return this.distance;
    }

    /**
     * raw voltage if available, zero otherwise 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 4
    )
    public final float voltage() {
        return this.voltage;
    }

    public static final class Builder {
        private float distance;

        private float voltage;

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
