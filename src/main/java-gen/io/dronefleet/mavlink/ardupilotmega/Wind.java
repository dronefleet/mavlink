package io.dronefleet.mavlink.ardupilotmega;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;

/**
 * Wind estimation 
 */
@MavlinkMessageInfo(
        id = 168,
        crc = 1,
        description = "Wind estimation"
)
public final class Wind {
    private final float direction;

    private final float speed;

    private final float speedZ;

    private Wind(float direction, float speed, float speedZ) {
        this.direction = direction;
        this.speed = speed;
        this.speedZ = speedZ;
    }

    /**
     * Returns a builder instance for this message.
     */
    @MavlinkMessageBuilder
    public static Builder builder() {
        return new Builder();
    }

    /**
     * wind direction that wind is coming from (degrees) 
     */
    @MavlinkFieldInfo(
            position = 1,
            unitSize = 4,
            description = "wind direction that wind is coming from (degrees)"
    )
    public final float direction() {
        return this.direction;
    }

    /**
     * wind speed in ground plane (m/s) 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 4,
            description = "wind speed in ground plane (m/s)"
    )
    public final float speed() {
        return this.speed;
    }

    /**
     * vertical wind speed (m/s) 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 4,
            description = "vertical wind speed (m/s)"
    )
    public final float speedZ() {
        return this.speedZ;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !getClass().equals(o.getClass())) return false;
        Wind other = (Wind)o;
        if (!Objects.deepEquals(direction, other.direction)) return false;
        if (!Objects.deepEquals(speed, other.speed)) return false;
        if (!Objects.deepEquals(speedZ, other.speedZ)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + Objects.hashCode(direction);
        result = 31 * result + Objects.hashCode(speed);
        result = 31 * result + Objects.hashCode(speedZ);
        return result;
    }

    @Override
    public String toString() {
        return "Wind{direction=" + direction
                 + ", speed=" + speed
                 + ", speedZ=" + speedZ + "}";
    }

    public static final class Builder {
        private float direction;

        private float speed;

        private float speedZ;

        /**
         * wind direction that wind is coming from (degrees) 
         */
        @MavlinkFieldInfo(
                position = 1,
                unitSize = 4,
                description = "wind direction that wind is coming from (degrees)"
        )
        public final Builder direction(float direction) {
            this.direction = direction;
            return this;
        }

        /**
         * wind speed in ground plane (m/s) 
         */
        @MavlinkFieldInfo(
                position = 2,
                unitSize = 4,
                description = "wind speed in ground plane (m/s)"
        )
        public final Builder speed(float speed) {
            this.speed = speed;
            return this;
        }

        /**
         * vertical wind speed (m/s) 
         */
        @MavlinkFieldInfo(
                position = 3,
                unitSize = 4,
                description = "vertical wind speed (m/s)"
        )
        public final Builder speedZ(float speedZ) {
            this.speedZ = speedZ;
            return this;
        }

        public final Wind build() {
            return new Wind(direction, speed, speedZ);
        }
    }
}
