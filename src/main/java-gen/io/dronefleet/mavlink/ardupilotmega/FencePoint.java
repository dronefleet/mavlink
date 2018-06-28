package io.dronefleet.mavlink.ardupilotmega;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;

/**
 * A fence point. Used to set a point when from GCS -> MAV. Also used to return a point from MAV -> GCS 
 */
@MavlinkMessageInfo(
        id = 160,
        crc = 78
)
public final class FencePoint {
    private final int targetSystem;

    private final int targetComponent;

    private final int idx;

    private final int count;

    private final float lat;

    private final float lng;

    private FencePoint(int targetSystem, int targetComponent, int idx, int count, float lat,
            float lng) {
        this.targetSystem = targetSystem;
        this.targetComponent = targetComponent;
        this.idx = idx;
        this.count = count;
        this.lat = lat;
        this.lng = lng;
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
     * point index (first point is 1, 0 is for return point) 
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
     * Latitude of point 
     */
    @MavlinkFieldInfo(
            position = 5,
            unitSize = 4
    )
    public final float lat() {
        return this.lat;
    }

    /**
     * Longitude of point 
     */
    @MavlinkFieldInfo(
            position = 6,
            unitSize = 4
    )
    public final float lng() {
        return this.lng;
    }

    public static final class Builder {
        private int targetSystem;

        private int targetComponent;

        private int idx;

        private int count;

        private float lat;

        private float lng;

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
         * point index (first point is 1, 0 is for return point) 
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
         * Latitude of point 
         */
        @MavlinkFieldInfo(
                position = 5,
                unitSize = 4
        )
        public final Builder lat(float lat) {
            this.lat = lat;
            return this;
        }

        /**
         * Longitude of point 
         */
        @MavlinkFieldInfo(
                position = 6,
                unitSize = 4
        )
        public final Builder lng(float lng) {
            this.lng = lng;
            return this;
        }

        public final FencePoint build() {
            return new FencePoint(targetSystem, targetComponent, idx, count, lat, lng);
        }
    }
}
