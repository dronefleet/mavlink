package io.dronefleet.mavlink.paparazzi;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;

/**
 * This message is emitted as response to {@link io.dronefleet.mavlink.paparazzi.ScriptRequestList SCRIPT_REQUEST_LIST} by the MAV to get the number of 
 * mission scripts. 
 */
@MavlinkMessageInfo(
        id = 183,
        crc = 186
)
public final class ScriptCount {
    private final int targetSystem;

    private final int targetComponent;

    private final int count;

    private ScriptCount(int targetSystem, int targetComponent, int count) {
        this.targetSystem = targetSystem;
        this.targetComponent = targetComponent;
        this.count = count;
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
     * Number of script items in the sequence 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 2
    )
    public final int count() {
        return this.count;
    }

    public static final class Builder {
        private int targetSystem;

        private int targetComponent;

        private int count;

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
         * Number of script items in the sequence 
         */
        @MavlinkFieldInfo(
                position = 3,
                unitSize = 2
        )
        public final Builder count(int count) {
            this.count = count;
            return this;
        }

        public final ScriptCount build() {
            return new ScriptCount(targetSystem, targetComponent, count);
        }
    }
}
