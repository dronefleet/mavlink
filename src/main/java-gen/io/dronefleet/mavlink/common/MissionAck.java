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
 * Ack message during waypoint handling. The type field states if this message is a positive ack 
 * (type=0) or if an error happened (type=non-zero). 
 */
@MavlinkMessageInfo(
        id = 47,
        crc = 153
)
public final class MissionAck {
    private final int targetSystem;

    private final int targetComponent;

    private final EnumValue<MavMissionResult> type;

    private final EnumValue<MavMissionType> missionType;

    private MissionAck(int targetSystem, int targetComponent, EnumValue<MavMissionResult> type,
            EnumValue<MavMissionType> missionType) {
        this.targetSystem = targetSystem;
        this.targetComponent = targetComponent;
        this.type = type;
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
     * See {@link io.dronefleet.mavlink.common.MavMissionResult MAV_MISSION_RESULT} enum 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 1,
            enumType = MavMissionResult.class
    )
    public final EnumValue<MavMissionResult> type() {
        return this.type;
    }

    /**
     * Mission type, see {@link io.dronefleet.mavlink.common.MavMissionType MAV_MISSION_TYPE} 
     */
    @MavlinkFieldInfo(
            position = 5,
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
        MissionAck other = (MissionAck)o;
        if (!Objects.deepEquals(targetSystem, other.targetSystem)) return false;
        if (!Objects.deepEquals(targetComponent, other.targetComponent)) return false;
        if (!Objects.deepEquals(type, other.type)) return false;
        if (!Objects.deepEquals(missionType, other.missionType)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + Objects.hashCode(targetSystem);
        result = 31 * result + Objects.hashCode(targetComponent);
        result = 31 * result + Objects.hashCode(type);
        result = 31 * result + Objects.hashCode(missionType);
        return result;
    }

    public static final class Builder {
        private int targetSystem;

        private int targetComponent;

        private EnumValue<MavMissionResult> type;

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
         * See {@link io.dronefleet.mavlink.common.MavMissionResult MAV_MISSION_RESULT} enum 
         */
        @MavlinkFieldInfo(
                position = 3,
                unitSize = 1,
                enumType = MavMissionResult.class
        )
        public final Builder type(EnumValue<MavMissionResult> type) {
            this.type = type;
            return this;
        }

        /**
         * See {@link io.dronefleet.mavlink.common.MavMissionResult MAV_MISSION_RESULT} enum 
         */
        public final Builder type(MavMissionResult entry) {
            this.type = EnumValue.of(entry);
            return this;
        }

        /**
         * See {@link io.dronefleet.mavlink.common.MavMissionResult MAV_MISSION_RESULT} enum 
         */
        public final Builder type(Enum... flags) {
            this.type = EnumValue.create(flags);
            return this;
        }

        /**
         * Mission type, see {@link io.dronefleet.mavlink.common.MavMissionType MAV_MISSION_TYPE} 
         */
        @MavlinkFieldInfo(
                position = 5,
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

        public final MissionAck build() {
            return new MissionAck(targetSystem, targetComponent, type, missionType);
        }
    }
}
