package io.dronefleet.mavlink.ardupilotmega;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;

/**
 * Wind estimation. 
 */
@MavlinkMessageInfo(
        id = 168,
        crc = 1,
        description = "Wind estimation."
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
     * Wind direction (that wind is coming from). 
     */
    @MavlinkFieldInfo(
            position = 1,
            unitSize = 4,
            description = "Wind direction (that wind is coming from)."
    )
    public final float direction() {
        return this.direction;
    }

    /**
     * Wind speed in ground plane. 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 4,
            description = "Wind speed in ground plane."
    )
    public final float speed() {
        return this.speed;
    }

    /**
     * Vertical wind speed. 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 4,
            description = "Vertical wind speed."
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
         * Wind direction (that wind is coming from). 
         */
        @MavlinkFieldInfo(
                position = 1,
                unitSize = 4,
                description = "Wind direction (that wind is coming from)."
        )
        public final Builder direction(float direction) {
            this.direction = direction;
            return this;
        }

        /**
         * Wind speed in ground plane. 
         */
        @MavlinkFieldInfo(
                position = 2,
                unitSize = 4,
                description = "Wind speed in ground plane."
        )
        public final Builder speed(float speed) {
            this.speed = speed;
            return this;
        }

        /**
         * Vertical wind speed. 
         */
        @MavlinkFieldInfo(
                position = 3,
                unitSize = 4,
                description = "Vertical wind speed."
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
