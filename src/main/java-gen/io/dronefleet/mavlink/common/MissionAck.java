package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import java.lang.Override;
import java.lang.String;

/**
 * Ack message during waypoint handling. The type field states if this message is a positive ack 
 * (type=0) or if an error happened (type=non-zero). 
 */
@MavlinkMessageInfo(
        id = 47,
        crc = 153
)
public final class MissionAck {
    /**
     * System ID 
     */
    private final int targetSystem;

    /**
     * Component ID 
     */
    private final int targetComponent;

    /**
     * See {@link io.dronefleet.mavlink.common.MavMissionResult MavMissionResult} enum 
     */
    private final MavMissionResult type;

    /**
     * Mission type, see {@link io.dronefleet.mavlink.common.MavMissionType MavMissionType} 
     */
    private final MavMissionType missionType;

    private MissionAck(int targetSystem, int targetComponent, MavMissionResult type,
            MavMissionType missionType) {
        this.targetSystem = targetSystem;
        this.targetComponent = targetComponent;
        this.type = type;
        this.missionType = missionType;
    }

    @MavlinkMessageBuilder
    public static Builder builder() {
        return new Builder();
    }

    @Override
    public String toString() {
        return "MissionAck{targetSystem=" + targetSystem
                 + ", targetComponent=" + targetComponent
                 + ", type=" + type
                 + ", missionType=" + missionType + "}";
    }

    /**
     * System ID 
     */
    @MavlinkFieldInfo(
            position = 1,
            unitSize = 1
    )
    public final int targetSystem() {
        return targetSystem;
    }

    /**
     * Component ID 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 1
    )
    public final int targetComponent() {
        return targetComponent;
    }

    /**
     * See {@link io.dronefleet.mavlink.common.MavMissionResult MavMissionResult} enum 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 1
    )
    public final MavMissionResult type() {
        return type;
    }

    /**
     * Mission type, see {@link io.dronefleet.mavlink.common.MavMissionType MavMissionType} 
     */
    @MavlinkFieldInfo(
            position = 5,
            unitSize = 1,
            extension = true
    )
    public final MavMissionType missionType() {
        return missionType;
    }

    public static class Builder {
        private int targetSystem;

        private int targetComponent;

        private MavMissionResult type;

        private MavMissionType missionType;

        private Builder() {
        }

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
         * See {@link io.dronefleet.mavlink.common.MavMissionResult MavMissionResult} enum 
         */
        @MavlinkFieldInfo(
                position = 3,
                unitSize = 1
        )
        public final Builder type(MavMissionResult type) {
            this.type = type;
            return this;
        }

        /**
         * Mission type, see {@link io.dronefleet.mavlink.common.MavMissionType MavMissionType} 
         */
        @MavlinkFieldInfo(
                position = 5,
                unitSize = 1,
                extension = true
        )
        public final Builder missionType(MavMissionType missionType) {
            this.missionType = missionType;
            return this;
        }

        public final MissionAck build() {
            return new MissionAck(targetSystem, targetComponent, type, missionType);
        }
    }
}
