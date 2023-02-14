package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import java.lang.Deprecated;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;

/**
 * Set the mission item with sequence number seq as the current item and emit {@link io.dronefleet.mavlink.common.MissionCurrent MISSION_CURRENT} 
 * (whether or not the mission number changed). If a mission is currently being executed, the 
 * system will continue to this new mission item on the shortest path, skipping any intermediate 
 * mission items. Note that mission jump repeat counters are not reset (see MAV_CMD_DO_JUMP 
 * param2). This message may trigger a mission state-machine change on some systems: for example 
 * from MISSION_STATE_NOT_STARTED or MISSION_STATE_PAUSED to MISSION_STATE_ACTIVE. If the 
 * system is in mission mode, on those systems this command might therefore start, restart or 
 * resume the mission. If the system is not in mission mode this message must not trigger a switch to 
 * mission mode. 
 * @deprecated Since 2022-08, replaced by MAV_CMD_DO_SET_MISSION_CURRENT. 
 */
@MavlinkMessageInfo(
        id = 41,
        crc = 28,
        description = "Set the mission item with sequence number seq as the current item and emit MISSION_CURRENT (whether or not the mission number changed).\n"
                        + "        If a mission is currently being executed, the system will continue to this new mission item on the shortest path, skipping any intermediate mission items.\n"
                        + "        Note that mission jump repeat counters are not reset (see MAV_CMD_DO_JUMP param2).\n"
                        + "\n"
                        + "        This message may trigger a mission state-machine change on some systems: for example from MISSION_STATE_NOT_STARTED or MISSION_STATE_PAUSED to MISSION_STATE_ACTIVE.\n"
                        + "        If the system is in mission mode, on those systems this command might therefore start, restart or resume the mission.\n"
                        + "        If the system is not in mission mode this message must not trigger a switch to mission mode."
)
@Deprecated
public final class MissionSetCurrent {
    private final int targetSystem;

    private final int targetComponent;

    private final int seq;

    private MissionSetCurrent(int targetSystem, int targetComponent, int seq) {
        this.targetSystem = targetSystem;
        this.targetComponent = targetComponent;
        this.seq = seq;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !getClass().equals(o.getClass())) return false;
        MissionSetCurrent other = (MissionSetCurrent)o;
        if (!Objects.deepEquals(targetSystem, other.targetSystem)) return false;
        if (!Objects.deepEquals(targetComponent, other.targetComponent)) return false;
        if (!Objects.deepEquals(seq, other.seq)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + Objects.hashCode(targetSystem);
        result = 31 * result + Objects.hashCode(targetComponent);
        result = 31 * result + Objects.hashCode(seq);
        return result;
    }

    @Override
    public String toString() {
        return "MissionSetCurrent{targetSystem=" + targetSystem
                 + ", targetComponent=" + targetComponent
                 + ", seq=" + seq + "}";
    }

    public static final class Builder {
        private int targetSystem;

        private int targetComponent;

        private int seq;

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

        public final MissionSetCurrent build() {
            return new MissionSetCurrent(targetSystem, targetComponent, seq);
        }
    }
}
