package io.dronefleet.mavlink.ardupilotmega;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import io.dronefleet.mavlink.util.EnumFlagSet;
import java.lang.Object;
import java.lang.Override;
import java.util.Objects;

/**
 * A rally point. Used to set a point when from GCS -&gt; MAV. Also used to return a point from MAV -&gt; GCS 
 */
@MavlinkMessageInfo(
        id = 175,
        crc = 138
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

    private final EnumFlagSet<RallyFlags> flags;

    private RallyPoint(int targetSystem, int targetComponent, int idx, int count, int lat, int lng,
            int alt, int breakAlt, int landDir, EnumFlagSet<RallyFlags> flags) {
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
     * System ID 
     */
    @MavlinkFieldInfo(
            position = 1,
            unitSize = 1
    )
    public final int targetSystem() {
        return this.targetSystem;
    }

    /**
     * Component ID 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 1
    )
    public final int targetComponent() {
        return this.targetComponent;
    }

    /**
     * point index (first point is 0) 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 1
    )
    public final int idx() {
        return this.idx;
    }

    /**
     * total number of points (for sanity checking) 
     */
    @MavlinkFieldInfo(
            position = 4,
            unitSize = 1
    )
    public final int count() {
        return this.count;
    }

    /**
     * Latitude of point in degrees * 1E7 
     */
    @MavlinkFieldInfo(
            position = 5,
            unitSize = 4,
            signed = true
    )
    public final int lat() {
        return this.lat;
    }

    /**
     * Longitude of point in degrees * 1E7 
     */
    @MavlinkFieldInfo(
            position = 6,
            unitSize = 4,
            signed = true
    )
    public final int lng() {
        return this.lng;
    }

    /**
     * Transit / loiter altitude in meters relative to home 
     */
    @MavlinkFieldInfo(
            position = 7,
            unitSize = 2,
            signed = true
    )
    public final int alt() {
        return this.alt;
    }

    /**
     * Break altitude in meters relative to home 
     */
    @MavlinkFieldInfo(
            position = 8,
            unitSize = 2,
            signed = true
    )
    public final int breakAlt() {
        return this.breakAlt;
    }

    /**
     * Heading to aim for when landing. In centi-degrees. 
     */
    @MavlinkFieldInfo(
            position = 9,
            unitSize = 2
    )
    public final int landDir() {
        return this.landDir;
    }

    /**
     * See {@link io.dronefleet.mavlink.ardupilotmega.RallyFlags RALLY_FLAGS} enum for definition of the bitmask. 
     */
    @MavlinkFieldInfo(
            position = 10,
            unitSize = 1
    )
    public final EnumFlagSet<RallyFlags> flags() {
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

        private EnumFlagSet<RallyFlags> flags;

        /**
         * System ID 
         */
        @MavlinkFieldInfo(
                position = 1,
                unitSize = 1
        )
        public final Builder targetSystem(int targetSystem) {
            this.targetSystem = targetSystem;
            return this;
        }

        /**
         * Component ID 
         */
        @MavlinkFieldInfo(
                position = 2,
                unitSize = 1
        )
        public final Builder targetComponent(int targetComponent) {
            this.targetComponent = targetComponent;
            return this;
        }

        /**
         * point index (first point is 0) 
         */
        @MavlinkFieldInfo(
                position = 3,
                unitSize = 1
        )
        public final Builder idx(int idx) {
            this.idx = idx;
            return this;
        }

        /**
         * total number of points (for sanity checking) 
         */
        @MavlinkFieldInfo(
                position = 4,
                unitSize = 1
        )
        public final Builder count(int count) {
            this.count = count;
            return this;
        }

        /**
         * Latitude of point in degrees * 1E7 
         */
        @MavlinkFieldInfo(
                position = 5,
                unitSize = 4,
                signed = true
        )
        public final Builder lat(int lat) {
            this.lat = lat;
            return this;
        }

        /**
         * Longitude of point in degrees * 1E7 
         */
        @MavlinkFieldInfo(
                position = 6,
                unitSize = 4,
                signed = true
        )
        public final Builder lng(int lng) {
            this.lng = lng;
            return this;
        }

        /**
         * Transit / loiter altitude in meters relative to home 
         */
        @MavlinkFieldInfo(
                position = 7,
                unitSize = 2,
                signed = true
        )
        public final Builder alt(int alt) {
            this.alt = alt;
            return this;
        }

        /**
         * Break altitude in meters relative to home 
         */
        @MavlinkFieldInfo(
                position = 8,
                unitSize = 2,
                signed = true
        )
        public final Builder breakAlt(int breakAlt) {
            this.breakAlt = breakAlt;
            return this;
        }

        /**
         * Heading to aim for when landing. In centi-degrees. 
         */
        @MavlinkFieldInfo(
                position = 9,
                unitSize = 2
        )
        public final Builder landDir(int landDir) {
            this.landDir = landDir;
            return this;
        }

        /**
         * See {@link io.dronefleet.mavlink.ardupilotmega.RallyFlags RALLY_FLAGS} enum for definition of the bitmask. 
         */
        @MavlinkFieldInfo(
                position = 10,
                unitSize = 1
        )
        public final Builder flags(EnumFlagSet<RallyFlags> flags) {
            this.flags = flags;
            return this;
        }

        public final RallyPoint build() {
            return new RallyPoint(targetSystem, targetComponent, idx, count, lat, lng, alt, breakAlt, landDir, flags);
        }
    }
}
