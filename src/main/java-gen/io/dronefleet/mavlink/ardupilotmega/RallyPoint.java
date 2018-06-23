package io.dronefleet.mavlink.ardupilotmega;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import io.dronefleet.mavlink.util.EnumFlagSet;
import java.lang.Override;
import java.lang.String;

/**
 * A rally point. Used to set a point when from GCS -> MAV. Also used to return a point from MAV -> GCS 
 */
@MavlinkMessageInfo(
        id = 175,
        crc = 138
)
public final class RallyPoint {
    /**
     * Latitude of point in degrees * 1E7 
     */
    private final int lat;

    /**
     * Longitude of point in degrees * 1E7 
     */
    private final int lng;

    /**
     * Transit / loiter altitude in meters relative to home 
     */
    private final int alt;

    /**
     * Break altitude in meters relative to home 
     */
    private final int breakAlt;

    /**
     * Heading to aim for when landing. In centi-degrees. 
     */
    private final int landDir;

    /**
     * System ID 
     */
    private final int targetSystem;

    /**
     * Component ID 
     */
    private final int targetComponent;

    /**
     * point index (first point is 0) 
     */
    private final int idx;

    /**
     * total number of points (for sanity checking) 
     */
    private final int count;

    /**
     * See {@link io.dronefleet.mavlink.ardupilotmega.RallyFlags RallyFlags} enum for definition of the bitmask. 
     */
    private final EnumFlagSet<RallyFlags> flags;

    private RallyPoint(int lat, int lng, int alt, int breakAlt, int landDir, int targetSystem,
            int targetComponent, int idx, int count, EnumFlagSet<RallyFlags> flags) {
        this.lat = lat;
        this.lng = lng;
        this.alt = alt;
        this.breakAlt = breakAlt;
        this.landDir = landDir;
        this.targetSystem = targetSystem;
        this.targetComponent = targetComponent;
        this.idx = idx;
        this.count = count;
        this.flags = flags;
    }

    @MavlinkMessageBuilder
    public static Builder builder() {
        return new Builder();
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

    /**
     * Latitude of point in degrees * 1E7 
     */
    @MavlinkFieldInfo(
            position = 5,
            unitSize = 4,
            signed = true
    )
    public final int lat() {
        return lat;
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
        return lng;
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
        return alt;
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
        return breakAlt;
    }

    /**
     * Heading to aim for when landing. In centi-degrees. 
     */
    @MavlinkFieldInfo(
            position = 9,
            unitSize = 2
    )
    public final int landDir() {
        return landDir;
    }

    /**
     * System ID 
     */
    @MavlinkFieldInfo(
            position = 1,
            unitSize = 1
    )
    public final int targetSystem() {
        return targetSystem;
    }

    /**
     * Component ID 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 1
    )
    public final int targetComponent() {
        return targetComponent;
    }

    /**
     * point index (first point is 0) 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 1
    )
    public final int idx() {
        return idx;
    }

    /**
     * total number of points (for sanity checking) 
     */
    @MavlinkFieldInfo(
            position = 4,
            unitSize = 1
    )
    public final int count() {
        return count;
    }

    /**
     * See {@link io.dronefleet.mavlink.ardupilotmega.RallyFlags RallyFlags} enum for definition of the bitmask. 
     */
    @MavlinkFieldInfo(
            position = 10,
            unitSize = 1
    )
    public final EnumFlagSet<RallyFlags> flags() {
        return flags;
    }

    public static class Builder {
        private int lat;

        private int lng;

        private int alt;

        private int breakAlt;

        private int landDir;

        private int targetSystem;

        private int targetComponent;

        private int idx;

        private int count;

        private EnumFlagSet<RallyFlags> flags;

        private Builder() {
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
         * See {@link io.dronefleet.mavlink.ardupilotmega.RallyFlags RallyFlags} enum for definition of the bitmask. 
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
            return new RallyPoint(lat, lng, alt, breakAlt, landDir, targetSystem, targetComponent, idx, count, flags);
        }
    }
}
