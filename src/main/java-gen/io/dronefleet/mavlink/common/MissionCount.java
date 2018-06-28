package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;

/**
 * This message is emitted as response to {@link io.dronefleet.mavlink.common.MissionRequestList MISSION_REQUEST_LIST} by the MAV and to initiate a write 
 * transaction. The GCS can then request the individual mission item based on the knowledge of the 
 * total number of waypoints. 
 */
@MavlinkMessageInfo(
        id = 44,
        crc = 52
)
public final class MissionCount {
    private final int targetSystem;

    private final int targetComponent;

    private final int count;

    private final MavMissionType missionType;

    private MissionCount(int targetSystem, int targetComponent, int count,
            MavMissionType missionType) {
        this.targetSystem = targetSystem;
        this.targetComponent = targetComponent;
        this.count = count;
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
     * Number of mission items in the sequence 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 2
    )
    public final int count() {
        return this.count;
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

        private int count;

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
         * Number of mission items in the sequence 
         */
        @MavlinkFieldInfo(
                position = 3,
                unitSize = 2
        )
        public final Builder count(int count) {
            this.count = count;
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

        public final MissionCount build() {
            return new MissionCount(targetSystem, targetComponent, count, missionType);
        }
    }
}
