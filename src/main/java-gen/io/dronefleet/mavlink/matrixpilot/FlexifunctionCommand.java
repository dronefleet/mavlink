package io.dronefleet.mavlink.matrixpilot;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;

/**
 * Acknowldge sucess or failure of a flexifunction command 
 */
@MavlinkMessageInfo(
        id = 157,
        crc = 133
)
public final class FlexifunctionCommand {
    private final int targetSystem;

    private final int targetComponent;

    private final int commandType;

    private FlexifunctionCommand(int targetSystem, int targetComponent, int commandType) {
        this.targetSystem = targetSystem;
        this.targetComponent = targetComponent;
        this.commandType = commandType;
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
     * Flexifunction command type 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 1
    )
    public final int commandType() {
        return this.commandType;
    }

    public static final class Builder {
        private int targetSystem;

        private int targetComponent;

        private int commandType;

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
         * Flexifunction command type 
         */
        @MavlinkFieldInfo(
                position = 3,
                unitSize = 1
        )
        public final Builder commandType(int commandType) {
            this.commandType = commandType;
            return this;
        }

        public final FlexifunctionCommand build() {
            return new FlexifunctionCommand(targetSystem, targetComponent, commandType);
        }
    }
}
