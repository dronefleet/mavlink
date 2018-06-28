package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;

/**
 * Delete all mission items at once. 
 */
@MavlinkMessageInfo(
        id = 45,
        crc = 25
)
public final class MissionClearAll {
    private final int targetSystem;

    private final int targetComponent;

    private final MavMissionType missionType;

    private MissionClearAll(int targetSystem, int targetComponent, MavMissionType missionType) {
        this.targetSystem = targetSystem;
        this.targetComponent = targetComponent;
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
     * Mission type, see {@link io.dronefleet.mavlink.common.MavMissionType MAV_MISSION_TYPE} 
     */
    @MavlinkFieldInfo(
            position = 4,
            unitSize = 1,
            extension = true
    )
    public final MavMissionType missionType() {
        return this.missionType;
    }

    public static final class Builder {
        private int targetSystem;

        private int targetComponent;

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
         * Mission type, see {@link io.dronefleet.mavlink.common.MavMissionType MAV_MISSION_TYPE} 
         */
        @MavlinkFieldInfo(
                position = 4,
                unitSize = 1,
                extension = true
        )
        public final Builder missionType(MavMissionType missionType) {
            this.missionType = missionType;
            return this;
        }

        public final MissionClearAll build() {
            return new MissionClearAll(targetSystem, targetComponent, missionType);
        }
    }
}
