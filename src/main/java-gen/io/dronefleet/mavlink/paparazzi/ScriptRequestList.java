package io.dronefleet.mavlink.paparazzi;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;

/**
 * Request the overall list of mission items from the system/component. 
 */
@MavlinkMessageInfo(
        id = 182,
        crc = 115
)
public final class ScriptRequestList {
    private final int targetSystem;

    private final int targetComponent;

    private ScriptRequestList(int targetSystem, int targetComponent) {
        this.targetSystem = targetSystem;
        this.targetComponent = targetComponent;
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

    public static final class Builder {
        private int targetSystem;

        private int targetComponent;

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

        public final ScriptRequestList build() {
            return new ScriptRequestList(targetSystem, targetComponent);
        }
    }
}
