package io.dronefleet.mavlink.matrixpilot;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import java.lang.Integer;
import java.util.List;

/**
 * Flexifunction type and parameters for component at function index from buffer 
 */
@MavlinkMessageInfo(
        id = 152,
        crc = 101
)
public final class FlexifunctionBufferFunction {
    private final int targetSystem;

    private final int targetComponent;

    private final int funcIndex;

    private final int funcCount;

    private final int dataAddress;

    private final int dataSize;

    private final List<Integer> data;

    private FlexifunctionBufferFunction(int targetSystem, int targetComponent, int funcIndex,
            int funcCount, int dataAddress, int dataSize, List<Integer> data) {
        this.targetSystem = targetSystem;
        this.targetComponent = targetComponent;
        this.funcIndex = funcIndex;
        this.funcCount = funcCount;
        this.dataAddress = dataAddress;
        this.dataSize = dataSize;
        this.data = data;
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
     * Total count of functions 
     */
    @MavlinkFieldInfo(
            position = 4,
            unitSize = 2
    )
    public final int funcCount() {
        return this.funcCount;
    }

    /**
     * Address in the flexifunction data, Set to 0xFFFF to use address in target memory 
     */
    @MavlinkFieldInfo(
            position = 5,
            unitSize = 2
    )
    public final int dataAddress() {
        return this.dataAddress;
    }

    /**
     * Size of the 
     */
    @MavlinkFieldInfo(
            position = 6,
            unitSize = 2
    )
    public final int dataSize() {
        return this.dataSize;
    }

    /**
     * Settings data 
     */
    @MavlinkFieldInfo(
            position = 7,
            unitSize = 1,
            arraySize = 48,
            signed = true
    )
    public final List<Integer> data() {
        return this.data;
    }

    public static final class Builder {
        private int targetSystem;

        private int targetComponent;

        private int funcIndex;

        private int funcCount;

        private int dataAddress;

        private int dataSize;

        private List<Integer> data;

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
         * Total count of functions 
         */
        @MavlinkFieldInfo(
                position = 4,
                unitSize = 2
        )
        public final Builder funcCount(int funcCount) {
            this.funcCount = funcCount;
            return this;
        }

        /**
         * Address in the flexifunction data, Set to 0xFFFF to use address in target memory 
         */
        @MavlinkFieldInfo(
                position = 5,
                unitSize = 2
        )
        public final Builder dataAddress(int dataAddress) {
            this.dataAddress = dataAddress;
            return this;
        }

        /**
         * Size of the 
         */
        @MavlinkFieldInfo(
                position = 6,
                unitSize = 2
        )
        public final Builder dataSize(int dataSize) {
            this.dataSize = dataSize;
            return this;
        }

        /**
         * Settings data 
         */
        @MavlinkFieldInfo(
                position = 7,
                unitSize = 1,
                arraySize = 48,
                signed = true
        )
        public final Builder data(List<Integer> data) {
            this.data = data;
            return this;
        }

        public final FlexifunctionBufferFunction build() {
            return new FlexifunctionBufferFunction(targetSystem, targetComponent, funcIndex, funcCount, dataAddress, dataSize, data);
        }
    }
}
