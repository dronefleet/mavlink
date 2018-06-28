package io.dronefleet.mavlink.ardupilotmega;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;

/**
 * Request a current rally point from MAV. MAV should respond with a {@link io.dronefleet.mavlink.ardupilotmega.RallyPoint RALLY_POINT} message. MAV 
 * should not respond if the request is invalid. 
 */
@MavlinkMessageInfo(
        id = 176,
        crc = 234
)
public final class RallyFetchPoint {
    private final int targetSystem;

    private final int targetComponent;

    private final int idx;

    private RallyFetchPoint(int targetSystem, int targetComponent, int idx) {
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

    public static final class Builder {
        private int targetSystem;

        private int targetComponent;

        private int idx;

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

        public final RallyFetchPoint build() {
            return new RallyFetchPoint(targetSystem, targetComponent, idx);
        }
    }
}
