package io.dronefleet.mavlink.matrixpilot;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import java.lang.Integer;
import java.util.List;

/**
 * Acknowldge sucess or failure of a flexifunction command 
 */
@MavlinkMessageInfo(
        id = 155,
        crc = 12
)
public final class FlexifunctionDirectory {
    private final int targetSystem;

    private final int targetComponent;

    private final int directoryType;

    private final int startIndex;

    private final int count;

    private final List<Integer> directoryData;

    private FlexifunctionDirectory(int targetSystem, int targetComponent, int directoryType,
            int startIndex, int count, List<Integer> directoryData) {
        this.targetSystem = targetSystem;
        this.targetComponent = targetComponent;
        this.directoryType = directoryType;
        this.startIndex = startIndex;
        this.count = count;
        this.directoryData = directoryData;
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
     * 0=inputs, 1=outputs 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 1
    )
    public final int directoryType() {
        return this.directoryType;
    }

    /**
     * index of first directory entry to write 
     */
    @MavlinkFieldInfo(
            position = 4,
            unitSize = 1
    )
    public final int startIndex() {
        return this.startIndex;
    }

    /**
     * count of directory entries to write 
     */
    @MavlinkFieldInfo(
            position = 5,
            unitSize = 1
    )
    public final int count() {
        return this.count;
    }

    /**
     * Settings data 
     */
    @MavlinkFieldInfo(
            position = 6,
            unitSize = 1,
            arraySize = 48,
            signed = true
    )
    public final List<Integer> directoryData() {
        return this.directoryData;
    }

    public static final class Builder {
        private int targetSystem;

        private int targetComponent;

        private int directoryType;

        private int startIndex;

        private int count;

        private List<Integer> directoryData;

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
         * 0=inputs, 1=outputs 
         */
        @MavlinkFieldInfo(
                position = 3,
                unitSize = 1
        )
        public final Builder directoryType(int directoryType) {
            this.directoryType = directoryType;
            return this;
        }

        /**
         * index of first directory entry to write 
         */
        @MavlinkFieldInfo(
                position = 4,
                unitSize = 1
        )
        public final Builder startIndex(int startIndex) {
            this.startIndex = startIndex;
            return this;
        }

        /**
         * count of directory entries to write 
         */
        @MavlinkFieldInfo(
                position = 5,
                unitSize = 1
        )
        public final Builder count(int count) {
            this.count = count;
            return this;
        }

        /**
         * Settings data 
         */
        @MavlinkFieldInfo(
                position = 6,
                unitSize = 1,
                arraySize = 48,
                signed = true
        )
        public final Builder directoryData(List<Integer> directoryData) {
            this.directoryData = directoryData;
            return this;
        }

        public final FlexifunctionDirectory build() {
            return new FlexifunctionDirectory(targetSystem, targetComponent, directoryType, startIndex, count, directoryData);
        }
    }
}
