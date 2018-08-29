package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import io.dronefleet.mavlink.util.EnumValue;
import java.lang.Enum;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Collection;
import java.util.Objects;

/**
 * Request a partial list of mission items from the system/component. 
 * https://mavlink.io/en/protocol/mission.html. If start and end index are the same, just 
 * send one waypoint. 
 */
@MavlinkMessageInfo(
        id = 37,
        crc = 212
)
public final class MissionRequestPartialList {
    private final int targetSystem;

    private final int targetComponent;

    private final int startIndex;

    private final int endIndex;

    private final EnumValue<MavMissionType> missionType;

    private MissionRequestPartialList(int targetSystem, int targetComponent, int startIndex,
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
     * Start index, 0 by default 
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
     * End index, -1 by default (-1: send list to end). Else a valid index of the list 
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
        MissionRequestPartialList other = (MissionRequestPartialList)o;
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

    @Override
    public String toString() {
        return "MissionRequestPartialList{targetSystem=" + targetSystem
                 + ", targetComponent=" + targetComponent
                 + ", startIndex=" + startIndex
                 + ", endIndex=" + endIndex
                 + ", missionType=" + missionType + "}";
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
         * Start index, 0 by default 
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
         * End index, -1 by default (-1: send list to end). Else a valid index of the list 
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
            return missionType(EnumValue.of(entry));
        }

        /**
         * Mission type, see {@link io.dronefleet.mavlink.common.MavMissionType MAV_MISSION_TYPE} 
         */
        public final Builder missionType(Enum... flags) {
            return missionType(EnumValue.create(flags));
        }

        /**
         * Mission type, see {@link io.dronefleet.mavlink.common.MavMissionType MAV_MISSION_TYPE} 
         */
        public final Builder missionType(Collection<Enum> flags) {
            return missionType(EnumValue.create(flags));
        }

        public final MissionRequestPartialList build() {
            return new MissionRequestPartialList(targetSystem, targetComponent, startIndex, endIndex, missionType);
        }
    }
}
