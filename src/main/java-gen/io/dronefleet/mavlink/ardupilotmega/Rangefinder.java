package io.dronefleet.mavlink.ardupilotmega;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;

/**
 * Rangefinder reporting. 
 */
@MavlinkMessageInfo(
        id = 173,
        crc = 83,
        description = "Rangefinder reporting."
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
     * Distance. 
     */
    @MavlinkFieldInfo(
            position = 1,
            unitSize = 4,
            description = "Distance."
    )
    public final float distance() {
        return this.distance;
    }

    /**
     * Raw voltage if available, zero otherwise. 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 4,
            description = "Raw voltage if available, zero otherwise."
    )
    public final float voltage() {
        return this.voltage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !getClass().equals(o.getClass())) return false;
        Rangefinder other = (Rangefinder)o;
        if (!Objects.deepEquals(distance, other.distance)) return false;
        if (!Objects.deepEquals(voltage, other.voltage)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + Objects.hashCode(distance);
        result = 31 * result + Objects.hashCode(voltage);
        return result;
    }

    @Override
    public String toString() {
        return "Rangefinder{distance=" + distance
                 + ", voltage=" + voltage + "}";
    }

    public static final class Builder {
        private float distance;

        private float voltage;

        /**
         * Distance. 
         */
        @MavlinkFieldInfo(
                position = 1,
                unitSize = 4,
                description = "Distance."
        )
        public final Builder distance(float distance) {
            this.distance = distance;
            return this;
        }

        /**
         * Raw voltage if available, zero otherwise. 
         */
        @MavlinkFieldInfo(
                position = 2,
                unitSize = 4,
                description = "Raw voltage if available, zero otherwise."
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
