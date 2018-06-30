package io.dronefleet.mavlink.slugs;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import java.lang.Object;
import java.lang.Override;
import java.util.Objects;

/**
 * Transmits the actual status values UAV in flight 
 */
@MavlinkMessageInfo(
        id = 193,
        crc = 160
)
public final class UavStatus {
    private final int target;

    private final float latitude;

    private final float longitude;

    private final float altitude;

    private final float speed;

    private final float course;

    private UavStatus(int target, float latitude, float longitude, float altitude, float speed,
            float course) {
        this.target = target;
        this.latitude = latitude;
        this.longitude = longitude;
        this.altitude = altitude;
        this.speed = speed;
        this.course = course;
    }

    /**
     * Returns a builder instance for this message.
     */
    @MavlinkMessageBuilder
    public static Builder builder() {
        return new Builder();
    }

    /**
     * The ID system reporting the action 
     */
    @MavlinkFieldInfo(
            position = 1,
            unitSize = 1
    )
    public final int target() {
        return this.target;
    }

    /**
     * Latitude UAV 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 4
    )
    public final float latitude() {
        return this.latitude;
    }

    /**
     * Longitude UAV 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 4
    )
    public final float longitude() {
        return this.longitude;
    }

    /**
     * Altitude UAV 
     */
    @MavlinkFieldInfo(
            position = 4,
            unitSize = 4
    )
    public final float altitude() {
        return this.altitude;
    }

    /**
     * Speed UAV 
     */
    @MavlinkFieldInfo(
            position = 5,
            unitSize = 4
    )
    public final float speed() {
        return this.speed;
    }

    /**
     * Course UAV 
     */
    @MavlinkFieldInfo(
            position = 6,
            unitSize = 4
    )
    public final float course() {
        return this.course;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !getClass().equals(o.getClass())) return false;
        UavStatus other = (UavStatus)o;
        if (!Objects.deepEquals(target, other.target)) return false;
        if (!Objects.deepEquals(latitude, other.latitude)) return false;
        if (!Objects.deepEquals(longitude, other.longitude)) return false;
        if (!Objects.deepEquals(altitude, other.altitude)) return false;
        if (!Objects.deepEquals(speed, other.speed)) return false;
        if (!Objects.deepEquals(course, other.course)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + Objects.hashCode(target);
        result = 31 * result + Objects.hashCode(latitude);
        result = 31 * result + Objects.hashCode(longitude);
        result = 31 * result + Objects.hashCode(altitude);
        result = 31 * result + Objects.hashCode(speed);
        result = 31 * result + Objects.hashCode(course);
        return result;
    }

    public static final class Builder {
        private int target;

        private float latitude;

        private float longitude;

        private float altitude;

        private float speed;

        private float course;

        /**
         * The ID system reporting the action 
         */
        @MavlinkFieldInfo(
                position = 1,
                unitSize = 1
        )
        public final Builder target(int target) {
            this.target = target;
            return this;
        }

        /**
         * Latitude UAV 
         */
        @MavlinkFieldInfo(
                position = 2,
                unitSize = 4
        )
        public final Builder latitude(float latitude) {
            this.latitude = latitude;
            return this;
        }

        /**
         * Longitude UAV 
         */
        @MavlinkFieldInfo(
                position = 3,
                unitSize = 4
        )
        public final Builder longitude(float longitude) {
            this.longitude = longitude;
            return this;
        }

        /**
         * Altitude UAV 
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
         * Speed UAV 
         */
        @MavlinkFieldInfo(
                position = 5,
                unitSize = 4
        )
        public final Builder speed(float speed) {
            this.speed = speed;
            return this;
        }

        /**
         * Course UAV 
         */
        @MavlinkFieldInfo(
                position = 6,
                unitSize = 4
        )
        public final Builder course(float course) {
            this.course = course;
            return this;
        }

        public final UavStatus build() {
            return new UavStatus(target, latitude, longitude, altitude, speed, course);
        }
    }
}
