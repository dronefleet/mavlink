package io.dronefleet.mavlink.ardupilotmega;

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
 * A rally point. Used to set a point when from GCS -&gt; MAV. Also used to return a point from MAV -&gt; GCS. 
 */
@MavlinkMessageInfo(
        id = 175,
        crc = 138,
        description = "A rally point. Used to set a point when from GCS -> MAV. Also used to return a point from MAV -> GCS."
)
public final class RallyPoint {
    private final int targetSystem;

    private final int targetComponent;

    private final int idx;

    private final int count;

    private final int lat;

    private final int lng;

    private final int alt;

    private final int breakAlt;

    private final int landDir;

    private final EnumValue<RallyFlags> flags;

    private RallyPoint(int targetSystem, int targetComponent, int idx, int count, int lat, int lng,
            int alt, int breakAlt, int landDir, EnumValue<RallyFlags> flags) {
        this.targetSystem = targetSystem;
        this.targetComponent = targetComponent;
        this.idx = idx;
        this.count = count;
        this.lat = lat;
        this.lng = lng;
        this.alt = alt;
        this.breakAlt = breakAlt;
        this.landDir = landDir;
        this.flags = flags;
    }

    /**
     * Returns a builder instance for this message.
     */
    @MavlinkMessageBuilder
    public static Builder builder() {
        return new Builder();
    }

    /**
     * System ID. 
     */
    @MavlinkFieldInfo(
            position = 1,
            unitSize = 1,
            description = "System ID."
    )
    public final int targetSystem() {
        return this.targetSystem;
    }

    /**
     * Component ID. 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 1,
            description = "Component ID."
    )
    public final int targetComponent() {
        return this.targetComponent;
    }

    /**
     * Point index (first point is 0). 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 1,
            description = "Point index (first point is 0)."
    )
    public final int idx() {
        return this.idx;
    }

    /**
     * Total number of points (for sanity checking). 
     */
    @MavlinkFieldInfo(
            position = 4,
            unitSize = 1,
            description = "Total number of points (for sanity checking)."
    )
    public final int count() {
        return this.count;
    }

    /**
     * Latitude of point. 
     */
    @MavlinkFieldInfo(
            position = 5,
            unitSize = 4,
            signed = true,
            description = "Latitude of point."
    )
    public final int lat() {
        return this.lat;
    }

    /**
     * Longitude of point. 
     */
    @MavlinkFieldInfo(
            position = 6,
            unitSize = 4,
            signed = true,
            description = "Longitude of point."
    )
    public final int lng() {
        return this.lng;
    }

    /**
     * Transit / loiter altitude relative to home. 
     */
    @MavlinkFieldInfo(
            position = 7,
            unitSize = 2,
            signed = true,
            description = "Transit / loiter altitude relative to home."
    )
    public final int alt() {
        return this.alt;
    }

    /**
     * Break altitude relative to home. 
     */
    @MavlinkFieldInfo(
            position = 8,
            unitSize = 2,
            signed = true,
            description = "Break altitude relative to home."
    )
    public final int breakAlt() {
        return this.breakAlt;
    }

    /**
     * Heading to aim for when landing. 
     */
    @MavlinkFieldInfo(
            position = 9,
            unitSize = 2,
            description = "Heading to aim for when landing."
    )
    public final int landDir() {
        return this.landDir;
    }

    /**
     * Configuration flags. 
     */
    @MavlinkFieldInfo(
            position = 10,
            unitSize = 1,
            enumType = RallyFlags.class,
            description = "Configuration flags."
    )
    public final EnumValue<RallyFlags> flags() {
        return this.flags;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !getClass().equals(o.getClass())) return false;
        RallyPoint other = (RallyPoint)o;
        if (!Objects.deepEquals(targetSystem, other.targetSystem)) return false;
        if (!Objects.deepEquals(targetComponent, other.targetComponent)) return false;
        if (!Objects.deepEquals(idx, other.idx)) return false;
        if (!Objects.deepEquals(count, other.count)) return false;
        if (!Objects.deepEquals(lat, other.lat)) return false;
        if (!Objects.deepEquals(lng, other.lng)) return false;
        if (!Objects.deepEquals(alt, other.alt)) return false;
        if (!Objects.deepEquals(breakAlt, other.breakAlt)) return false;
        if (!Objects.deepEquals(landDir, other.landDir)) return false;
        if (!Objects.deepEquals(flags, other.flags)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + Objects.hashCode(targetSystem);
        result = 31 * result + Objects.hashCode(targetComponent);
        result = 31 * result + Objects.hashCode(idx);
        result = 31 * result + Objects.hashCode(count);
        result = 31 * result + Objects.hashCode(lat);
        result = 31 * result + Objects.hashCode(lng);
        result = 31 * result + Objects.hashCode(alt);
        result = 31 * result + Objects.hashCode(breakAlt);
        result = 31 * result + Objects.hashCode(landDir);
        result = 31 * result + Objects.hashCode(flags);
        return result;
    }

    @Override
    public String toString() {
        return "RallyPoint{targetSystem=" + targetSystem
                 + ", targetComponent=" + targetComponent
                 + ", idx=" + idx
                 + ", count=" + count
                 + ", lat=" + lat
                 + ", lng=" + lng
                 + ", alt=" + alt
                 + ", breakAlt=" + breakAlt
                 + ", landDir=" + landDir
                 + ", flags=" + flags + "}";
    }

    public static final class Builder {
        private int targetSystem;

        private int targetComponent;

        private int idx;

        private int count;

        private int lat;

        private int lng;

        private int alt;

        private int breakAlt;

        private int landDir;

        private EnumValue<RallyFlags> flags;

        /**
         * System ID. 
         */
        @MavlinkFieldInfo(
                position = 1,
                unitSize = 1,
                description = "System ID."
        )
        public final Builder targetSystem(int targetSystem) {
            this.targetSystem = targetSystem;
            return this;
        }

        /**
         * Component ID. 
         */
        @MavlinkFieldInfo(
                position = 2,
                unitSize = 1,
                description = "Component ID."
        )
        public final Builder targetComponent(int targetComponent) {
            this.targetComponent = targetComponent;
            return this;
        }

        /**
         * Point index (first point is 0). 
         */
        @MavlinkFieldInfo(
                position = 3,
                unitSize = 1,
                description = "Point index (first point is 0)."
        )
        public final Builder idx(int idx) {
            this.idx = idx;
            return this;
        }

        /**
         * Total number of points (for sanity checking). 
         */
        @MavlinkFieldInfo(
                position = 4,
                unitSize = 1,
                description = "Total number of points (for sanity checking)."
        )
        public final Builder count(int count) {
            this.count = count;
            return this;
        }

        /**
         * Latitude of point. 
         */
        @MavlinkFieldInfo(
                position = 5,
                unitSize = 4,
                signed = true,
                description = "Latitude of point."
        )
        public final Builder lat(int lat) {
            this.lat = lat;
            return this;
        }

        /**
         * Longitude of point. 
         */
        @MavlinkFieldInfo(
                position = 6,
                unitSize = 4,
                signed = true,
                description = "Longitude of point."
        )
        public final Builder lng(int lng) {
            this.lng = lng;
            return this;
        }

        /**
         * Transit / loiter altitude relative to home. 
         */
        @MavlinkFieldInfo(
                position = 7,
                unitSize = 2,
                signed = true,
                description = "Transit / loiter altitude relative to home."
        )
        public final Builder alt(int alt) {
            this.alt = alt;
            return this;
        }

        /**
         * Break altitude relative to home. 
         */
        @MavlinkFieldInfo(
                position = 8,
                unitSize = 2,
                signed = true,
                description = "Break altitude relative to home."
        )
        public final Builder breakAlt(int breakAlt) {
            this.breakAlt = breakAlt;
            return this;
        }

        /**
         * Heading to aim for when landing. 
         */
        @MavlinkFieldInfo(
                position = 9,
                unitSize = 2,
                description = "Heading to aim for when landing."
        )
        public final Builder landDir(int landDir) {
            this.landDir = landDir;
            return this;
        }

        /**
         * Configuration flags. 
         */
        @MavlinkFieldInfo(
                position = 10,
                unitSize = 1,
                enumType = RallyFlags.class,
                description = "Configuration flags."
        )
        public final Builder flags(EnumValue<RallyFlags> flags) {
            this.flags = flags;
            return this;
        }

        /**
         * Configuration flags. 
         */
        public final Builder flags(RallyFlags entry) {
            return flags(EnumValue.of(entry));
        }

        /**
         * Configuration flags. 
         */
        public final Builder flags(Enum... flags) {
            return flags(EnumValue.create(flags));
        }

        /**
         * Configuration flags. 
         */
        public final Builder flags(Collection<Enum> flags) {
            return flags(EnumValue.create(flags));
        }

        public final RallyPoint build() {
            return new RallyPoint(targetSystem, targetComponent, idx, count, lat, lng, alt, breakAlt, landDir, flags);
        }
    }
}
