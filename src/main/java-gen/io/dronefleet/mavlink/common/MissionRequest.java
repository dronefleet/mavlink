package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;

/**
 * Request the information of the mission item with the sequence number seq. The response of the 
 * system to this message should be a {@link io.dronefleet.mavlink.common.MissionItem MISSION_ITEM} message. 
 * https://mavlink.io/en/protocol/mission.html 
 */
@MavlinkMessageInfo(
        id = 40,
        crc = 177
)
public final class MissionRequest {
    private final int targetSystem;

    private final int targetComponent;

    private final int seq;

    private final MavMissionType missionType;

    private MissionRequest(int targetSystem, int targetComponent, int seq,
            MavMissionType missionType) {
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
     * Sequence 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 2
    )
    public final int seq() {
        return this.seq;
    }

    /**
     * Mission type, see {@link io.dronefleet.mavlink.common.MavMissionType MAV_MISSION_TYPE} 
     */
    @MavlinkFieldInfo(
            position = 5,
            unitSize = 1,
            extension = true
    )
    public final MavMissionType missionType() {
        return this.missionType;
    }

    public static final class Builder {
        private int targetSystem;

        private int targetComponent;

        private int seq;

        private MavMissionType missionType;

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
         * Sequence 
         */
        @MavlinkFieldInfo(
                position = 3,
                unitSize = 2
        )
        public final Builder seq(int seq) {
            this.seq = seq;
            return this;
        }

        /**
         * Mission type, see {@link io.dronefleet.mavlink.common.MavMissionType MAV_MISSION_TYPE} 
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

        public final MissionRequest build() {
            return new MissionRequest(targetSystem, targetComponent, seq, missionType);
        }
    }
}
