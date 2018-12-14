package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import io.dronefleet.mavlink.util.EnumValue;
import java.lang.Enum;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Collection;
import java.util.Objects;

/**
 * Information about a potential collision 
 */
@MavlinkMessageInfo(
        id = 247,
        crc = 81,
        description = "Information about a potential collision"
)
public final class Collision {
    private final EnumValue<MavCollisionSrc> src;

    private final long id;

    private final EnumValue<MavCollisionAction> action;

    private final EnumValue<MavCollisionThreatLevel> threatLevel;

    private final float timeToMinimumDelta;

    private final float altitudeMinimumDelta;

    private final float horizontalMinimumDelta;

    private Collision(EnumValue<MavCollisionSrc> src, long id, EnumValue<MavCollisionAction> action,
            EnumValue<MavCollisionThreatLevel> threatLevel, float timeToMinimumDelta,
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
            unitSize = 1,
            enumType = MavCollisionSrc.class,
            description = "Collision data source"
    )
    public final EnumValue<MavCollisionSrc> src() {
        return this.src;
    }

    /**
     * Unique identifier, domain based on src field 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 4,
            description = "Unique identifier, domain based on src field"
    )
    public final long id() {
        return this.id;
    }

    /**
     * Action that is being taken to avoid this collision 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 1,
            enumType = MavCollisionAction.class,
            description = "Action that is being taken to avoid this collision"
    )
    public final EnumValue<MavCollisionAction> action() {
        return this.action;
    }

    /**
     * How concerned the aircraft is about this collision 
     */
    @MavlinkFieldInfo(
            position = 4,
            unitSize = 1,
            enumType = MavCollisionThreatLevel.class,
            description = "How concerned the aircraft is about this collision"
    )
    public final EnumValue<MavCollisionThreatLevel> threatLevel() {
        return this.threatLevel;
    }

    /**
     * Estimated time until collision occurs 
     */
    @MavlinkFieldInfo(
            position = 5,
            unitSize = 4,
            description = "Estimated time until collision occurs"
    )
    public final float timeToMinimumDelta() {
        return this.timeToMinimumDelta;
    }

    /**
     * Closest vertical distance between vehicle and object 
     */
    @MavlinkFieldInfo(
            position = 6,
            unitSize = 4,
            description = "Closest vertical distance between vehicle and object"
    )
    public final float altitudeMinimumDelta() {
        return this.altitudeMinimumDelta;
    }

    /**
     * Closest horizontal distance between vehicle and object 
     */
    @MavlinkFieldInfo(
            position = 7,
            unitSize = 4,
            description = "Closest horizontal distance between vehicle and object"
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

    @Override
    public String toString() {
        return "Collision{src=" + src
                 + ", id=" + id
                 + ", action=" + action
                 + ", threatLevel=" + threatLevel
                 + ", timeToMinimumDelta=" + timeToMinimumDelta
                 + ", altitudeMinimumDelta=" + altitudeMinimumDelta
                 + ", horizontalMinimumDelta=" + horizontalMinimumDelta + "}";
    }

    public static final class Builder {
        private EnumValue<MavCollisionSrc> src;

        private long id;

        private EnumValue<MavCollisionAction> action;

        private EnumValue<MavCollisionThreatLevel> threatLevel;

        private float timeToMinimumDelta;

        private float altitudeMinimumDelta;

        private float horizontalMinimumDelta;

        /**
         * Collision data source 
         */
        @MavlinkFieldInfo(
                position = 1,
                unitSize = 1,
                enumType = MavCollisionSrc.class,
                description = "Collision data source"
        )
        public final Builder src(EnumValue<MavCollisionSrc> src) {
            this.src = src;
            return this;
        }

        /**
         * Collision data source 
         */
        public final Builder src(MavCollisionSrc entry) {
            return src(EnumValue.of(entry));
        }

        /**
         * Collision data source 
         */
        public final Builder src(Enum... flags) {
            return src(EnumValue.create(flags));
        }

        /**
         * Collision data source 
         */
        public final Builder src(Collection<Enum> flags) {
            return src(EnumValue.create(flags));
        }

        /**
         * Unique identifier, domain based on src field 
         */
        @MavlinkFieldInfo(
                position = 2,
                unitSize = 4,
                description = "Unique identifier, domain based on src field"
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
                unitSize = 1,
                enumType = MavCollisionAction.class,
                description = "Action that is being taken to avoid this collision"
        )
        public final Builder action(EnumValue<MavCollisionAction> action) {
            this.action = action;
            return this;
        }

        /**
         * Action that is being taken to avoid this collision 
         */
        public final Builder action(MavCollisionAction entry) {
            return action(EnumValue.of(entry));
        }

        /**
         * Action that is being taken to avoid this collision 
         */
        public final Builder action(Enum... flags) {
            return action(EnumValue.create(flags));
        }

        /**
         * Action that is being taken to avoid this collision 
         */
        public final Builder action(Collection<Enum> flags) {
            return action(EnumValue.create(flags));
        }

        /**
         * How concerned the aircraft is about this collision 
         */
        @MavlinkFieldInfo(
                position = 4,
                unitSize = 1,
                enumType = MavCollisionThreatLevel.class,
                description = "How concerned the aircraft is about this collision"
        )
        public final Builder threatLevel(EnumValue<MavCollisionThreatLevel> threatLevel) {
            this.threatLevel = threatLevel;
            return this;
        }

        /**
         * How concerned the aircraft is about this collision 
         */
        public final Builder threatLevel(MavCollisionThreatLevel entry) {
            return threatLevel(EnumValue.of(entry));
        }

        /**
         * How concerned the aircraft is about this collision 
         */
        public final Builder threatLevel(Enum... flags) {
            return threatLevel(EnumValue.create(flags));
        }

        /**
         * How concerned the aircraft is about this collision 
         */
        public final Builder threatLevel(Collection<Enum> flags) {
            return threatLevel(EnumValue.create(flags));
        }

        /**
         * Estimated time until collision occurs 
         */
        @MavlinkFieldInfo(
                position = 5,
                unitSize = 4,
                description = "Estimated time until collision occurs"
        )
        public final Builder timeToMinimumDelta(float timeToMinimumDelta) {
            this.timeToMinimumDelta = timeToMinimumDelta;
            return this;
        }

        /**
         * Closest vertical distance between vehicle and object 
         */
        @MavlinkFieldInfo(
                position = 6,
                unitSize = 4,
                description = "Closest vertical distance between vehicle and object"
        )
        public final Builder altitudeMinimumDelta(float altitudeMinimumDelta) {
            this.altitudeMinimumDelta = altitudeMinimumDelta;
            return this;
        }

        /**
         * Closest horizontal distance between vehicle and object 
         */
        @MavlinkFieldInfo(
                position = 7,
                unitSize = 4,
                description = "Closest horizontal distance between vehicle and object"
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
