package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import java.lang.Object;
import java.lang.Override;
import java.util.Objects;

/**
 * Information about a potential collision 
 */
@MavlinkMessageInfo(
        id = 247,
        crc = 81
)
public final class Collision {
    private final MavCollisionSrc src;

    private final long id;

    private final MavCollisionAction action;

    private final MavCollisionThreatLevel threatLevel;

    private final float timeToMinimumDelta;

    private final float altitudeMinimumDelta;

    private final float horizontalMinimumDelta;

    private Collision(MavCollisionSrc src, long id, MavCollisionAction action,
            MavCollisionThreatLevel threatLevel, float timeToMinimumDelta,
            float altitudeMinimumDelta, float horizontalMinimumDelta) {
        this.src = src;
        this.id = id;
        this.action = action;
        this.threatLevel = threatLevel;
        this.timeToMinimumDelta = timeToMinimumDelta;
        this.altitudeMinimumDelta = altitudeMinimumDelta;
        this.horizontalMinimumDelta = horizontalMinimumDelta;
    }

    /**
     * Returns a builder instance for this message.
     */
    @MavlinkMessageBuilder
    public static Builder builder() {
        return new Builder();
    }

    /**
     * Collision data source 
     */
    @MavlinkFieldInfo(
            position = 1,
            unitSize = 1
    )
    public final MavCollisionSrc src() {
        return this.src;
    }

    /**
     * Unique identifier, domain based on src field 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 4
    )
    public final long id() {
        return this.id;
    }

    /**
     * Action that is being taken to avoid this collision 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 1
    )
    public final MavCollisionAction action() {
        return this.action;
    }

    /**
     * How concerned the aircraft is about this collision 
     */
    @MavlinkFieldInfo(
            position = 4,
            unitSize = 1
    )
    public final MavCollisionThreatLevel threatLevel() {
        return this.threatLevel;
    }

    /**
     * Estimated time until collision occurs (seconds) 
     */
    @MavlinkFieldInfo(
            position = 5,
            unitSize = 4
    )
    public final float timeToMinimumDelta() {
        return this.timeToMinimumDelta;
    }

    /**
     * Closest vertical distance in meters between vehicle and object 
     */
    @MavlinkFieldInfo(
            position = 6,
            unitSize = 4
    )
    public final float altitudeMinimumDelta() {
        return this.altitudeMinimumDelta;
    }

    /**
     * Closest horizontal distance in meteres between vehicle and object 
     */
    @MavlinkFieldInfo(
            position = 7,
            unitSize = 4
    )
    public final float horizontalMinimumDelta() {
        return this.horizontalMinimumDelta;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !getClass().equals(o.getClass())) return false;
        Collision other = (Collision)o;
        if (!Objects.deepEquals(src, other.src)) return false;
        if (!Objects.deepEquals(id, other.id)) return false;
        if (!Objects.deepEquals(action, other.action)) return false;
        if (!Objects.deepEquals(threatLevel, other.threatLevel)) return false;
        if (!Objects.deepEquals(timeToMinimumDelta, other.timeToMinimumDelta)) return false;
        if (!Objects.deepEquals(altitudeMinimumDelta, other.altitudeMinimumDelta)) return false;
        if (!Objects.deepEquals(horizontalMinimumDelta, other.horizontalMinimumDelta)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + Objects.hashCode(src);
        result = 31 * result + Objects.hashCode(id);
        result = 31 * result + Objects.hashCode(action);
        result = 31 * result + Objects.hashCode(threatLevel);
        result = 31 * result + Objects.hashCode(timeToMinimumDelta);
        result = 31 * result + Objects.hashCode(altitudeMinimumDelta);
        result = 31 * result + Objects.hashCode(horizontalMinimumDelta);
        return result;
    }

    public static final class Builder {
        private MavCollisionSrc src;

        private long id;

        private MavCollisionAction action;

        private MavCollisionThreatLevel threatLevel;

        private float timeToMinimumDelta;

        private float altitudeMinimumDelta;

        private float horizontalMinimumDelta;

        /**
         * Collision data source 
         */
        @MavlinkFieldInfo(
                position = 1,
                unitSize = 1
        )
        public final Builder src(MavCollisionSrc src) {
            this.src = src;
            return this;
        }

        /**
         * Unique identifier, domain based on src field 
         */
        @MavlinkFieldInfo(
                position = 2,
                unitSize = 4
        )
        public final Builder id(long id) {
            this.id = id;
            return this;
        }

        /**
         * Action that is being taken to avoid this collision 
         */
        @MavlinkFieldInfo(
                position = 3,
                unitSize = 1
        )
        public final Builder action(MavCollisionAction action) {
            this.action = action;
            return this;
        }

        /**
         * How concerned the aircraft is about this collision 
         */
        @MavlinkFieldInfo(
                position = 4,
                unitSize = 1
        )
        public final Builder threatLevel(MavCollisionThreatLevel threatLevel) {
            this.threatLevel = threatLevel;
            return this;
        }

        /**
         * Estimated time until collision occurs (seconds) 
         */
        @MavlinkFieldInfo(
                position = 5,
                unitSize = 4
        )
        public final Builder timeToMinimumDelta(float timeToMinimumDelta) {
            this.timeToMinimumDelta = timeToMinimumDelta;
            return this;
        }

        /**
         * Closest vertical distance in meters between vehicle and object 
         */
        @MavlinkFieldInfo(
                position = 6,
                unitSize = 4
        )
        public final Builder altitudeMinimumDelta(float altitudeMinimumDelta) {
            this.altitudeMinimumDelta = altitudeMinimumDelta;
            return this;
        }

        /**
         * Closest horizontal distance in meteres between vehicle and object 
         */
        @MavlinkFieldInfo(
                position = 7,
                unitSize = 4
        )
        public final Builder horizontalMinimumDelta(float horizontalMinimumDelta) {
            this.horizontalMinimumDelta = horizontalMinimumDelta;
            return this;
        }

        public final Collision build() {
            return new Collision(src, id, action, threatLevel, timeToMinimumDelta, altitudeMinimumDelta, horizontalMinimumDelta);
        }
    }
}
