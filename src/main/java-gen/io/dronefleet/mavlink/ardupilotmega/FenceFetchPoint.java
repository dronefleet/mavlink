package io.dronefleet.mavlink.ardupilotmega;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import java.lang.Override;
import java.lang.String;

/**
 * Request a current fence point from MAV 
 */
@MavlinkMessageInfo(
        id = 161,
        crc = 68
)
public final class FenceFetchPoint {
    /**
     * System ID 
     */
    private final int targetSystem;

    /**
     * Component ID 
     */
    private final int targetComponent;

    /**
     * point index (first point is 1, 0 is for return point) 
     */
    private final int idx;

    private FenceFetchPoint(int targetSystem, int targetComponent, int idx) {
        this.targetSystem = targetSystem;
        this.targetComponent = targetComponent;
        this.idx = idx;
    }

    @MavlinkMessageBuilder
    public static Builder builder() {
        return new Builder();
    }

    @Override
    public String toString() {
        return "FenceFetchPoint{targetSystem=" + targetSystem
                 + ", targetComponent=" + targetComponent
                 + ", idx=" + idx + "}";
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
     * point index (first point is 1, 0 is for return point) 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 1
    )
    public final int idx() {
        return idx;
    }

    public static class Builder {
        private int targetSystem;

        private int targetComponent;

        private int idx;

        private Builder() {
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

        public final FenceFetchPoint build() {
            return new FenceFetchPoint(targetSystem, targetComponent, idx);
        }
    }
}
