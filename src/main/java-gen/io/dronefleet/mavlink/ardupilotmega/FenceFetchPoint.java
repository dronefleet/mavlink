package io.dronefleet.mavlink.ardupilotmega;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;

/**
 * Request a current fence point from MAV 
 */
@MavlinkMessageInfo(
        id = 161,
        crc = 68,
        description = "Request a current fence point from MAV"
)
public final class FenceFetchPoint {
    private final int targetSystem;

    private final int targetComponent;

    private final int idx;

    private FenceFetchPoint(int targetSystem, int targetComponent, int idx) {
        this.targetSystem = targetSystem;
        this.targetComponent = targetComponent;
        this.idx = idx;
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
            unitSize = 1,
            description = "System ID"
    )
    public final int targetSystem() {
        return this.targetSystem;
    }

    /**
     * Component ID 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 1,
            description = "Component ID"
    )
    public final int targetComponent() {
        return this.targetComponent;
    }

    /**
     * point index (first point is 1, 0 is for return point) 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 1,
            description = "point index (first point is 1, 0 is for return point)"
    )
    public final int idx() {
        return this.idx;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !getClass().equals(o.getClass())) return false;
        FenceFetchPoint other = (FenceFetchPoint)o;
        if (!Objects.deepEquals(targetSystem, other.targetSystem)) return false;
        if (!Objects.deepEquals(targetComponent, other.targetComponent)) return false;
        if (!Objects.deepEquals(idx, other.idx)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + Objects.hashCode(targetSystem);
        result = 31 * result + Objects.hashCode(targetComponent);
        result = 31 * result + Objects.hashCode(idx);
        return result;
    }

    @Override
    public String toString() {
        return "FenceFetchPoint{targetSystem=" + targetSystem
                 + ", targetComponent=" + targetComponent
                 + ", idx=" + idx + "}";
    }

    public static final class Builder {
        private int targetSystem;

        private int targetComponent;

        private int idx;

        /**
         * System ID 
         */
        @MavlinkFieldInfo(
                position = 1,
                unitSize = 1,
                description = "System ID"
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
                unitSize = 1,
                description = "Component ID"
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
                unitSize = 1,
                description = "point index (first point is 1, 0 is for return point)"
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
