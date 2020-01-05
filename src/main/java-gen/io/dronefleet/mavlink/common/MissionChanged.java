package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import io.dronefleet.mavlink.util.EnumValue;
import java.lang.Deprecated;
import java.lang.Enum;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Collection;
import java.util.Objects;

/**
 * A broadcast message to notify any ground station or SDK if a mission, geofence or safe points 
 * have changed on the vehicle. 
 * @deprecated This message is a work in progress. It may be modified in a non backward-compatible 
 * way in a future release without any warning. This version of the message may not even work with 
 * autopilots that support this message due to discrepancies between dialect versions. Unless 
 * you completely understand the risks of doing so, don't use it. 
 */
@MavlinkMessageInfo(
        id = 52,
        crc = 132,
        description = "A broadcast message to notify any ground station or SDK if a mission, geofence or safe points have changed on the vehicle.",
        workInProgress = true
)
@Deprecated
public final class MissionChanged {
    private final int startIndex;

    private final int endIndex;

    private final int originSysid;

    private final EnumValue<MavComponent> originCompid;

    private final EnumValue<MavMissionType> missionType;

    private MissionChanged(int startIndex, int endIndex, int originSysid,
            EnumValue<MavComponent> originCompid, EnumValue<MavMissionType> missionType) {
        this.startIndex = startIndex;
        this.endIndex = endIndex;
        this.originSysid = originSysid;
        this.originCompid = originCompid;
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
     * Start index for partial mission change (-1 for all items). 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 2,
            signed = true,
            description = "Start index for partial mission change (-1 for all items)."
    )
    public final int startIndex() {
        return this.startIndex;
    }

    /**
     * End index of a partial mission change. -1 is a synonym for the last mission item (i.e. selects all 
     * items from start_index). Ignore field if start_index=-1. 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 2,
            signed = true,
            description = "End index of a partial mission change. -1 is a synonym for the last mission item (i.e. selects all items from start_index). Ignore field if start_index=-1."
    )
    public final int endIndex() {
        return this.endIndex;
    }

    /**
     * System ID of the author of the new mission. 
     */
    @MavlinkFieldInfo(
            position = 4,
            unitSize = 1,
            description = "System ID of the author of the new mission."
    )
    public final int originSysid() {
        return this.originSysid;
    }

    /**
     * Compnent ID of the author of the new mission. 
     */
    @MavlinkFieldInfo(
            position = 5,
            unitSize = 1,
            enumType = MavComponent.class,
            description = "Compnent ID of the author of the new mission."
    )
    public final EnumValue<MavComponent> originCompid() {
        return this.originCompid;
    }

    /**
     * Mission type. 
     */
    @MavlinkFieldInfo(
            position = 6,
            unitSize = 1,
            enumType = MavMissionType.class,
            description = "Mission type."
    )
    public final EnumValue<MavMissionType> missionType() {
        return this.missionType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !getClass().equals(o.getClass())) return false;
        MissionChanged other = (MissionChanged)o;
        if (!Objects.deepEquals(startIndex, other.startIndex)) return false;
        if (!Objects.deepEquals(endIndex, other.endIndex)) return false;
        if (!Objects.deepEquals(originSysid, other.originSysid)) return false;
        if (!Objects.deepEquals(originCompid, other.originCompid)) return false;
        if (!Objects.deepEquals(missionType, other.missionType)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + Objects.hashCode(startIndex);
        result = 31 * result + Objects.hashCode(endIndex);
        result = 31 * result + Objects.hashCode(originSysid);
        result = 31 * result + Objects.hashCode(originCompid);
        result = 31 * result + Objects.hashCode(missionType);
        return result;
    }

    @Override
    public String toString() {
        return "MissionChanged{startIndex=" + startIndex
                 + ", endIndex=" + endIndex
                 + ", originSysid=" + originSysid
                 + ", originCompid=" + originCompid
                 + ", missionType=" + missionType + "}";
    }

    public static final class Builder {
        private int startIndex;

        private int endIndex;

        private int originSysid;

        private EnumValue<MavComponent> originCompid;

        private EnumValue<MavMissionType> missionType;

        /**
         * Start index for partial mission change (-1 for all items). 
         */
        @MavlinkFieldInfo(
                position = 2,
                unitSize = 2,
                signed = true,
                description = "Start index for partial mission change (-1 for all items)."
        )
        public final Builder startIndex(int startIndex) {
            this.startIndex = startIndex;
            return this;
        }

        /**
         * End index of a partial mission change. -1 is a synonym for the last mission item (i.e. selects all 
         * items from start_index). Ignore field if start_index=-1. 
         */
        @MavlinkFieldInfo(
                position = 3,
                unitSize = 2,
                signed = true,
                description = "End index of a partial mission change. -1 is a synonym for the last mission item (i.e. selects all items from start_index). Ignore field if start_index=-1."
        )
        public final Builder endIndex(int endIndex) {
            this.endIndex = endIndex;
            return this;
        }

        /**
         * System ID of the author of the new mission. 
         */
        @MavlinkFieldInfo(
                position = 4,
                unitSize = 1,
                description = "System ID of the author of the new mission."
        )
        public final Builder originSysid(int originSysid) {
            this.originSysid = originSysid;
            return this;
        }

        /**
         * Compnent ID of the author of the new mission. 
         */
        @MavlinkFieldInfo(
                position = 5,
                unitSize = 1,
                enumType = MavComponent.class,
                description = "Compnent ID of the author of the new mission."
        )
        public final Builder originCompid(EnumValue<MavComponent> originCompid) {
            this.originCompid = originCompid;
            return this;
        }

        /**
         * Compnent ID of the author of the new mission. 
         */
        public final Builder originCompid(MavComponent entry) {
            return originCompid(EnumValue.of(entry));
        }

        /**
         * Compnent ID of the author of the new mission. 
         */
        public final Builder originCompid(Enum... flags) {
            return originCompid(EnumValue.create(flags));
        }

        /**
         * Compnent ID of the author of the new mission. 
         */
        public final Builder originCompid(Collection<Enum> flags) {
            return originCompid(EnumValue.create(flags));
        }

        /**
         * Mission type. 
         */
        @MavlinkFieldInfo(
                position = 6,
                unitSize = 1,
                enumType = MavMissionType.class,
                description = "Mission type."
        )
        public final Builder missionType(EnumValue<MavMissionType> missionType) {
            this.missionType = missionType;
            return this;
        }

        /**
         * Mission type. 
         */
        public final Builder missionType(MavMissionType entry) {
            return missionType(EnumValue.of(entry));
        }

        /**
         * Mission type. 
         */
        public final Builder missionType(Enum... flags) {
            return missionType(EnumValue.create(flags));
        }

        /**
         * Mission type. 
         */
        public final Builder missionType(Collection<Enum> flags) {
            return missionType(EnumValue.create(flags));
        }

        public final MissionChanged build() {
            return new MissionChanged(startIndex, endIndex, originSysid, originCompid, missionType);
        }
    }
}
