package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import java.lang.Override;
import java.lang.String;

/**
 * Request the overall list of mission items from the system/component. 
 */
@MavlinkMessageInfo(
        id = 43,
        crc = 132
)
public final class MissionRequestList {
    /**
     * System ID 
     */
    private final int targetSystem;

    /**
     * Component ID 
     */
    private final int targetComponent;

    /**
     * Mission type, see {@link io.dronefleet.mavlink.common.MavMissionType MavMissionType} 
     */
    private final MavMissionType missionType;

    private MissionRequestList(int targetSystem, int targetComponent, MavMissionType missionType) {
        this.targetSystem = targetSystem;
        this.targetComponent = targetComponent;
        this.missionType = missionType;
    }

    @MavlinkMessageBuilder
    public static Builder builder() {
        return new Builder();
    }

    @Override
    public String toString() {
        return "MissionRequestList{targetSystem=" + targetSystem
                 + ", targetComponent=" + targetComponent
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
     * Mission type, see {@link io.dronefleet.mavlink.common.MavMissionType MavMissionType} 
     */
    @MavlinkFieldInfo(
            position = 4,
            unitSize = 1,
            extension = true
    )
    public final MavMissionType missionType() {
        return missionType;
    }

    public static class Builder {
        private int targetSystem;

        private int targetComponent;

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
         * Mission type, see {@link io.dronefleet.mavlink.common.MavMissionType MavMissionType} 
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

        public final MissionRequestList build() {
            return new MissionRequestList(targetSystem, targetComponent, missionType);
        }
    }
}
