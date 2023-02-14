package io.dronefleet.mavlink.matrixpilot;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import java.lang.Integer;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.List;
import java.util.Objects;

/**
 * Acknowldge success or failure of a flexifunction command 
 */
@MavlinkMessageInfo(
        id = 155,
        crc = 12,
        description = "Acknowldge success or failure of a flexifunction command"
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
     * 0=inputs, 1=outputs 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 1,
            description = "0=inputs, 1=outputs"
    )
    public final int directoryType() {
        return this.directoryType;
    }

    /**
     * index of first directory entry to write 
     */
    @MavlinkFieldInfo(
            position = 4,
            unitSize = 1,
            description = "index of first directory entry to write"
    )
    public final int startIndex() {
        return this.startIndex;
    }

    /**
     * count of directory entries to write 
     */
    @MavlinkFieldInfo(
            position = 5,
            unitSize = 1,
            description = "count of directory entries to write"
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
            signed = true,
            description = "Settings data"
    )
    public final List<Integer> directoryData() {
        return this.directoryData;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !getClass().equals(o.getClass())) return false;
        FlexifunctionDirectory other = (FlexifunctionDirectory)o;
        if (!Objects.deepEquals(targetSystem, other.targetSystem)) return false;
        if (!Objects.deepEquals(targetComponent, other.targetComponent)) return false;
        if (!Objects.deepEquals(directoryType, other.directoryType)) return false;
        if (!Objects.deepEquals(startIndex, other.startIndex)) return false;
        if (!Objects.deepEquals(count, other.count)) return false;
        if (!Objects.deepEquals(directoryData, other.directoryData)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + Objects.hashCode(targetSystem);
        result = 31 * result + Objects.hashCode(targetComponent);
        result = 31 * result + Objects.hashCode(directoryType);
        result = 31 * result + Objects.hashCode(startIndex);
        result = 31 * result + Objects.hashCode(count);
        result = 31 * result + Objects.hashCode(directoryData);
        return result;
    }

    @Override
    public String toString() {
        return "FlexifunctionDirectory{targetSystem=" + targetSystem
                 + ", targetComponent=" + targetComponent
                 + ", directoryType=" + directoryType
                 + ", startIndex=" + startIndex
                 + ", count=" + count
                 + ", directoryData=" + directoryData + "}";
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
         * 0=inputs, 1=outputs 
         */
        @MavlinkFieldInfo(
                position = 3,
                unitSize = 1,
                description = "0=inputs, 1=outputs"
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
                unitSize = 1,
                description = "index of first directory entry to write"
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
                unitSize = 1,
                description = "count of directory entries to write"
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
                signed = true,
                description = "Settings data"
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
