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
 * Request the information of the mission item with the sequence number seq. The response of the 
 * system to this message should be a {@link io.dronefleet.mavlink.common.MissionItem MISSION_ITEM} message. 
 * https://mavlink.io/en/services/mission.html 
 * @deprecated Since 2020-06, replaced by {@link io.dronefleet.mavlink.common.MissionRequestInt MISSION_REQUEST_INT}. A system that gets this request 
 * should respond with {@link io.dronefleet.mavlink.common.MissionItemInt MISSION_ITEM_INT} (as though {@link io.dronefleet.mavlink.common.MissionRequestInt MISSION_REQUEST_INT} was received). 
 */
@MavlinkMessageInfo(
        id = 40,
        crc = 230,
        description = "Request the information of the mission item with the sequence number seq. The response of the system to this message should be a MISSION_ITEM message. https://mavlink.io/en/services/mission.html"
)
@Deprecated
public final class MissionRequest {
    private final int targetSystem;

    private final int targetComponent;

    private final int seq;

    private final EnumValue<MavMissionType> missionType;

    private MissionRequest(int targetSystem, int targetComponent, int seq,
            EnumValue<MavMissionType> missionType) {
        this.targetSystem = targetSystem;
        this.targetComponent = targetComponent;
        this.seq = seq;
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
            position = 2,
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
            position = 3,
            unitSize = 1,
            description = "Component ID"
    )
    public final int targetComponent() {
        return this.targetComponent;
    }

    /**
     * Sequence 
     */
    @MavlinkFieldInfo(
            position = 4,
            unitSize = 2,
            description = "Sequence"
    )
    public final int seq() {
        return this.seq;
    }

    /**
     * Mission type. 
     */
    @MavlinkFieldInfo(
            position = 6,
            unitSize = 1,
            enumType = MavMissionType.class,
            extension = true,
            description = "Mission type."
    )
    public final EnumValue<MavMissionType> missionType() {
        return this.missionType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !getClass().equals(o.getClass())) return false;
        MissionRequest other = (MissionRequest)o;
        if (!Objects.deepEquals(targetSystem, other.targetSystem)) return false;
        if (!Objects.deepEquals(targetComponent, other.targetComponent)) return false;
        if (!Objects.deepEquals(seq, other.seq)) return false;
        if (!Objects.deepEquals(missionType, other.missionType)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + Objects.hashCode(targetSystem);
        result = 31 * result + Objects.hashCode(targetComponent);
        result = 31 * result + Objects.hashCode(seq);
        result = 31 * result + Objects.hashCode(missionType);
        return result;
    }

    @Override
    public String toString() {
        return "MissionRequest{targetSystem=" + targetSystem
                 + ", targetComponent=" + targetComponent
                 + ", seq=" + seq
                 + ", missionType=" + missionType + "}";
    }

    public static final class Builder {
        private int targetSystem;

        private int targetComponent;

        private int seq;

        private EnumValue<MavMissionType> missionType;

        /**
         * System ID 
         */
        @MavlinkFieldInfo(
                position = 2,
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
                position = 3,
                unitSize = 1,
                description = "Component ID"
        )
        public final Builder targetComponent(int targetComponent) {
            this.targetComponent = targetComponent;
            return this;
        }

        /**
         * Sequence 
         */
        @MavlinkFieldInfo(
                position = 4,
                unitSize = 2,
                description = "Sequence"
        )
        public final Builder seq(int seq) {
            this.seq = seq;
            return this;
        }

        /**
         * Mission type. 
         */
        @MavlinkFieldInfo(
                position = 6,
                unitSize = 1,
                enumType = MavMissionType.class,
                extension = true,
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

        public final MissionRequest build() {
            return new MissionRequest(targetSystem, targetComponent, seq, missionType);
        }
    }
}
