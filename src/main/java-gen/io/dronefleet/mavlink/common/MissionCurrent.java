package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import io.dronefleet.mavlink.util.EnumValue;
import java.lang.Enum;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Collection;
import java.util.Objects;

/**
 * Message that announces the sequence number of the current target mission item (that the system 
 * will fly towards/execute when the mission is running). This message should be streamed all the 
 * time (nominally at 1Hz). This message should be emitted following a call to 
 * MAV_CMD_DO_SET_MISSION_CURRENT or SET_MISSION_CURRENT. 
 */
@MavlinkMessageInfo(
        id = 42,
        crc = 28,
        description = "Message that announces the sequence number of the current target mission item (that the system will fly towards/execute when the mission is running).\n"
                        + "        This message should be streamed all the time (nominally at 1Hz).\n"
                        + "        This message should be emitted following a call to MAV_CMD_DO_SET_MISSION_CURRENT or SET_MISSION_CURRENT."
)
public final class MissionCurrent {
    private final int seq;

    private final int total;

    private final EnumValue<MissionState> missionState;

    private final int missionMode;

    private MissionCurrent(int seq, int total, EnumValue<MissionState> missionState,
            int missionMode) {
        this.seq = seq;
        this.total = total;
        this.missionState = missionState;
        this.missionMode = missionMode;
    }

    /**
     * Returns a builder instance for this message.
     */
    @MavlinkMessageBuilder
    public static Builder builder() {
        return new Builder();
    }

    /**
     * Sequence 
     */
    @MavlinkFieldInfo(
            position = 1,
            unitSize = 2,
            description = "Sequence"
    )
    public final int seq() {
        return this.seq;
    }

    /**
     * Total number of mission items. 0: Not supported, UINT16_MAX if no mission is present on the 
     * vehicle. 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 2,
            extension = true,
            description = "Total number of mission items. 0: Not supported, UINT16_MAX if no mission is present on the vehicle."
    )
    public final int total() {
        return this.total;
    }

    /**
     * Mission state machine state. MISSION_STATE_UNKNOWN if state reporting not supported. 
     */
    @MavlinkFieldInfo(
            position = 4,
            unitSize = 1,
            enumType = MissionState.class,
            extension = true,
            description = "Mission state machine state. MISSION_STATE_UNKNOWN if state reporting not supported."
    )
    public final EnumValue<MissionState> missionState() {
        return this.missionState;
    }

    /**
     * Vehicle is in a mode that can execute mission items or suspended. 0: Unknown, 1: In mission mode, 
     * 2: Suspended (not in mission mode). 
     */
    @MavlinkFieldInfo(
            position = 5,
            unitSize = 1,
            extension = true,
            description = "Vehicle is in a mode that can execute mission items or suspended. 0: Unknown, 1: In mission mode, 2: Suspended (not in mission mode)."
    )
    public final int missionMode() {
        return this.missionMode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !getClass().equals(o.getClass())) return false;
        MissionCurrent other = (MissionCurrent)o;
        if (!Objects.deepEquals(seq, other.seq)) return false;
        if (!Objects.deepEquals(total, other.total)) return false;
        if (!Objects.deepEquals(missionState, other.missionState)) return false;
        if (!Objects.deepEquals(missionMode, other.missionMode)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + Objects.hashCode(seq);
        result = 31 * result + Objects.hashCode(total);
        result = 31 * result + Objects.hashCode(missionState);
        result = 31 * result + Objects.hashCode(missionMode);
        return result;
    }

    @Override
    public String toString() {
        return "MissionCurrent{seq=" + seq
                 + ", total=" + total
                 + ", missionState=" + missionState
                 + ", missionMode=" + missionMode + "}";
    }

    public static final class Builder {
        private int seq;

        private int total;

        private EnumValue<MissionState> missionState;

        private int missionMode;

        /**
         * Sequence 
         */
        @MavlinkFieldInfo(
                position = 1,
                unitSize = 2,
                description = "Sequence"
        )
        public final Builder seq(int seq) {
            this.seq = seq;
            return this;
        }

        /**
         * Total number of mission items. 0: Not supported, UINT16_MAX if no mission is present on the 
         * vehicle. 
         */
        @MavlinkFieldInfo(
                position = 3,
                unitSize = 2,
                extension = true,
                description = "Total number of mission items. 0: Not supported, UINT16_MAX if no mission is present on the vehicle."
        )
        public final Builder total(int total) {
            this.total = total;
            return this;
        }

        /**
         * Mission state machine state. MISSION_STATE_UNKNOWN if state reporting not supported. 
         */
        @MavlinkFieldInfo(
                position = 4,
                unitSize = 1,
                enumType = MissionState.class,
                extension = true,
                description = "Mission state machine state. MISSION_STATE_UNKNOWN if state reporting not supported."
        )
        public final Builder missionState(EnumValue<MissionState> missionState) {
            this.missionState = missionState;
            return this;
        }

        /**
         * Mission state machine state. MISSION_STATE_UNKNOWN if state reporting not supported. 
         */
        public final Builder missionState(MissionState entry) {
            return missionState(EnumValue.of(entry));
        }

        /**
         * Mission state machine state. MISSION_STATE_UNKNOWN if state reporting not supported. 
         */
        public final Builder missionState(Enum... flags) {
            return missionState(EnumValue.create(flags));
        }

        /**
         * Mission state machine state. MISSION_STATE_UNKNOWN if state reporting not supported. 
         */
        public final Builder missionState(Collection<Enum> flags) {
            return missionState(EnumValue.create(flags));
        }

        /**
         * Vehicle is in a mode that can execute mission items or suspended. 0: Unknown, 1: In mission mode, 
         * 2: Suspended (not in mission mode). 
         */
        @MavlinkFieldInfo(
                position = 5,
                unitSize = 1,
                extension = true,
                description = "Vehicle is in a mode that can execute mission items or suspended. 0: Unknown, 1: In mission mode, 2: Suspended (not in mission mode)."
        )
        public final Builder missionMode(int missionMode) {
            this.missionMode = missionMode;
            return this;
        }

        public final MissionCurrent build() {
            return new MissionCurrent(seq, total, missionState, missionMode);
        }
    }
}
