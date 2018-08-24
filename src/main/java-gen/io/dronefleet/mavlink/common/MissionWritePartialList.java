package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import io.dronefleet.mavlink.util.EnumValue;
import java.lang.Enum;
import java.lang.Object;
import java.lang.Override;
import java.util.Objects;

/**
 * This message is sent to the MAV to write a partial list. If start index == end index, only one item 
 * will be transmitted / updated. If the start index is NOT 0 and above the current list size, this 
 * request should be REJECTED! 
 */
@MavlinkMessageInfo(
        id = 38,
        crc = 9
)
public final class MissionWritePartialList {
    private final int targetSystem;

    private final int targetComponent;

    private final int startIndex;

    private final int endIndex;

    private final EnumValue<MavMissionType> missionType;

    private MissionWritePartialList(int targetSystem, int targetComponent, int startIndex,
            int endIndex, EnumValue<MavMissionType> missionType) {
        this.targetSystem = targetSystem;
        this.targetComponent = targetComponent;
        this.startIndex = startIndex;
        this.endIndex = endIndex;
        this.missionType = missionType;
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
     * Start index, 0 by default and smaller / equal to the largest index of the current onboard list. 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 2,
            signed = true
    )
    public final int startIndex() {
        return this.startIndex;
    }

    /**
     * End index, equal or greater than start index. 
     */
    @MavlinkFieldInfo(
            position = 4,
            unitSize = 2,
            signed = true
    )
    public final int endIndex() {
        return this.endIndex;
    }

    /**
     * Mission type, see {@link io.dronefleet.mavlink.common.MavMissionType MAV_MISSION_TYPE} 
     */
    @MavlinkFieldInfo(
            position = 6,
            unitSize = 1,
            enumType = MavMissionType.class,
            extension = true
    )
    public final EnumValue<MavMissionType> missionType() {
        return this.missionType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !getClass().equals(o.getClass())) return false;
        MissionWritePartialList other = (MissionWritePartialList)o;
        if (!Objects.deepEquals(targetSystem, other.targetSystem)) return false;
        if (!Objects.deepEquals(targetComponent, other.targetComponent)) return false;
        if (!Objects.deepEquals(startIndex, other.startIndex)) return false;
        if (!Objects.deepEquals(endIndex, other.endIndex)) return false;
        if (!Objects.deepEquals(missionType, other.missionType)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + Objects.hashCode(targetSystem);
        result = 31 * result + Objects.hashCode(targetComponent);
        result = 31 * result + Objects.hashCode(startIndex);
        result = 31 * result + Objects.hashCode(endIndex);
        result = 31 * result + Objects.hashCode(missionType);
        return result;
    }

    public static final class Builder {
        private int targetSystem;

        private int targetComponent;

        private int startIndex;

        private int endIndex;

        private EnumValue<MavMissionType> missionType;

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
         * Start index, 0 by default and smaller / equal to the largest index of the current onboard list. 
         */
        @MavlinkFieldInfo(
                position = 3,
                unitSize = 2,
                signed = true
        )
        public final Builder startIndex(int startIndex) {
            this.startIndex = startIndex;
            return this;
        }

        /**
         * End index, equal or greater than start index. 
         */
        @MavlinkFieldInfo(
                position = 4,
                unitSize = 2,
                signed = true
        )
        public final Builder endIndex(int endIndex) {
            this.endIndex = endIndex;
            return this;
        }

        /**
         * Mission type, see {@link io.dronefleet.mavlink.common.MavMissionType MAV_MISSION_TYPE} 
         */
        @MavlinkFieldInfo(
                position = 6,
                unitSize = 1,
                enumType = MavMissionType.class,
                extension = true
        )
        public final Builder missionType(EnumValue<MavMissionType> missionType) {
            this.missionType = missionType;
            return this;
        }

        /**
         * Mission type, see {@link io.dronefleet.mavlink.common.MavMissionType MAV_MISSION_TYPE} 
         */
        public final Builder missionType(MavMissionType entry) {
            this.missionType = EnumValue.of(entry);
            return this;
        }

        /**
         * Mission type, see {@link io.dronefleet.mavlink.common.MavMissionType MAV_MISSION_TYPE} 
         */
        public final Builder missionType(Enum... flags) {
            this.missionType = EnumValue.create(flags);
            return this;
        }

        public final MissionWritePartialList build() {
            return new MissionWritePartialList(targetSystem, targetComponent, startIndex, endIndex, missionType);
        }
    }
}
