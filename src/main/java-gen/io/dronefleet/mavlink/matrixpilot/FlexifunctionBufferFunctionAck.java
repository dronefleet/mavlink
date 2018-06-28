package io.dronefleet.mavlink.matrixpilot;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;

/**
 * Flexifunction type and parameters for component at function index from buffer 
 */
@MavlinkMessageInfo(
        id = 153,
        crc = 109
)
public final class FlexifunctionBufferFunctionAck {
    private final int targetSystem;

    private final int targetComponent;

    private final int funcIndex;

    private final int result;

    private FlexifunctionBufferFunctionAck(int targetSystem, int targetComponent, int funcIndex,
            int result) {
        this.targetSystem = targetSystem;
        this.targetComponent = targetComponent;
        this.funcIndex = funcIndex;
        this.result = result;
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
     * Function index 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 2
    )
    public final int funcIndex() {
        return this.funcIndex;
    }

    /**
     * result of acknowledge, 0=fail, 1=good 
     */
    @MavlinkFieldInfo(
            position = 4,
            unitSize = 2
    )
    public final int result() {
        return this.result;
    }

    public static final class Builder {
        private int targetSystem;

        private int targetComponent;

        private int funcIndex;

        private int result;

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
         * Function index 
         */
        @MavlinkFieldInfo(
                position = 3,
                unitSize = 2
        )
        public final Builder funcIndex(int funcIndex) {
            this.funcIndex = funcIndex;
            return this;
        }

        /**
         * result of acknowledge, 0=fail, 1=good 
         */
        @MavlinkFieldInfo(
                position = 4,
                unitSize = 2
        )
        public final Builder result(int result) {
            this.result = result;
            return this;
        }

        public final FlexifunctionBufferFunctionAck build() {
            return new FlexifunctionBufferFunctionAck(targetSystem, targetComponent, funcIndex, result);
        }
    }
}
