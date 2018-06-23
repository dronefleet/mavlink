package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import java.lang.Override;
import java.lang.String;

/**
 * Set the mission item with sequence number seq as current item. This means that the MAV will 
 * continue to this mission item on the shortest path (not following the mission items 
 * in-between). 
 */
@MavlinkMessageInfo(
        id = 41,
        crc = 28
)
public final class MissionSetCurrent {
    /**
     * Sequence 
     */
    private final int seq;

    /**
     * System ID 
     */
    private final int targetSystem;

    /**
     * Component ID 
     */
    private final int targetComponent;

    private MissionSetCurrent(int seq, int targetSystem, int targetComponent) {
        this.seq = seq;
        this.targetSystem = targetSystem;
        this.targetComponent = targetComponent;
    }

    @MavlinkMessageBuilder
    public static Builder builder() {
        return new Builder();
    }

    @Override
    public String toString() {
        return "MissionSetCurrent{targetSystem=" + targetSystem
                 + ", targetComponent=" + targetComponent
                 + ", seq=" + seq + "}";
    }

    /**
     * Sequence 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 2
    )
    public final int seq() {
        return seq;
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

    public static class Builder {
        private int seq;

        private int targetSystem;

        private int targetComponent;

        private Builder() {
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

        public final MissionSetCurrent build() {
            return new MissionSetCurrent(seq, targetSystem, targetComponent);
        }
    }
}
