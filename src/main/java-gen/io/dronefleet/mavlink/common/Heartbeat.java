package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import io.dronefleet.mavlink.util.EnumFlagSet;
import java.lang.Object;
import java.lang.Override;
import java.util.Objects;

/**
 * The heartbeat message shows that a system is present and responding. The type of the MAV and 
 * Autopilot hardware allow the receiving system to treat further messages from this system 
 * appropriate (e.g. by laying out the user interface based on the autopilot). 
 */
@MavlinkMessageInfo(
        id = 0,
        crc = 50
)
public final class Heartbeat {
    private final MavType type;

    private final MavAutopilot autopilot;

    private final EnumFlagSet<MavModeFlag> baseMode;

    private final long customMode;

    private final MavState systemStatus;

    private final int mavlinkVersion;

    private Heartbeat(MavType type, MavAutopilot autopilot, EnumFlagSet<MavModeFlag> baseMode,
            long customMode, MavState systemStatus, int mavlinkVersion) {
        this.type = type;
        this.autopilot = autopilot;
        this.baseMode = baseMode;
        this.customMode = customMode;
        this.systemStatus = systemStatus;
        this.mavlinkVersion = mavlinkVersion;
    }

    /**
     * Returns a builder instance for this message.
     */
    @MavlinkMessageBuilder
    public static Builder builder() {
        return new Builder();
    }

    /**
     * Type of the MAV (quadrotor, helicopter, etc., up to 15 types, defined in {@link io.dronefleet.mavlink.common.MavType MAV_TYPE} ENUM) 
     */
    @MavlinkFieldInfo(
            position = 1,
            unitSize = 1
    )
    public final MavType type() {
        return this.type;
    }

    /**
     * Autopilot type / class. defined in {@link io.dronefleet.mavlink.common.MavAutopilot MAV_AUTOPILOT} ENUM 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 1
    )
    public final MavAutopilot autopilot() {
        return this.autopilot;
    }

    /**
     * System mode bitfield, as defined by {@link io.dronefleet.mavlink.common.MavModeFlag MAV_MODE_FLAG} enum 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 1
    )
    public final EnumFlagSet<MavModeFlag> baseMode() {
        return this.baseMode;
    }

    /**
     * A bitfield for use for autopilot-specific flags 
     */
    @MavlinkFieldInfo(
            position = 4,
            unitSize = 4
    )
    public final long customMode() {
        return this.customMode;
    }

    /**
     * System status flag, as defined by {@link io.dronefleet.mavlink.common.MavState MAV_STATE} enum 
     */
    @MavlinkFieldInfo(
            position = 5,
            unitSize = 1
    )
    public final MavState systemStatus() {
        return this.systemStatus;
    }

    /**
     * MAVLink version, not writable by user, gets added by protocol because of magic data type: 
     * uint8_t_mavlink_version 
     */
    @MavlinkFieldInfo(
            position = 6,
            unitSize = 1
    )
    public final int mavlinkVersion() {
        return this.mavlinkVersion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !getClass().equals(o.getClass())) return false;
        Heartbeat other = (Heartbeat)o;
        if (!Objects.deepEquals(type, other.type)) return false;
        if (!Objects.deepEquals(autopilot, other.autopilot)) return false;
        if (!Objects.deepEquals(baseMode, other.baseMode)) return false;
        if (!Objects.deepEquals(customMode, other.customMode)) return false;
        if (!Objects.deepEquals(systemStatus, other.systemStatus)) return false;
        if (!Objects.deepEquals(mavlinkVersion, other.mavlinkVersion)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + Objects.hashCode(type);
        result = 31 * result + Objects.hashCode(autopilot);
        result = 31 * result + Objects.hashCode(baseMode);
        result = 31 * result + Objects.hashCode(customMode);
        result = 31 * result + Objects.hashCode(systemStatus);
        result = 31 * result + Objects.hashCode(mavlinkVersion);
        return result;
    }

    public static final class Builder {
        private MavType type;

        private MavAutopilot autopilot;

        private EnumFlagSet<MavModeFlag> baseMode;

        private long customMode;

        private MavState systemStatus;

        private int mavlinkVersion;

        /**
         * Type of the MAV (quadrotor, helicopter, etc., up to 15 types, defined in {@link io.dronefleet.mavlink.common.MavType MAV_TYPE} ENUM) 
         */
        @MavlinkFieldInfo(
                position = 1,
                unitSize = 1
        )
        public final Builder type(MavType type) {
            this.type = type;
            return this;
        }

        /**
         * Autopilot type / class. defined in {@link io.dronefleet.mavlink.common.MavAutopilot MAV_AUTOPILOT} ENUM 
         */
        @MavlinkFieldInfo(
                position = 2,
                unitSize = 1
        )
        public final Builder autopilot(MavAutopilot autopilot) {
            this.autopilot = autopilot;
            return this;
        }

        /**
         * System mode bitfield, as defined by {@link io.dronefleet.mavlink.common.MavModeFlag MAV_MODE_FLAG} enum 
         */
        @MavlinkFieldInfo(
                position = 3,
                unitSize = 1
        )
        public final Builder baseMode(EnumFlagSet<MavModeFlag> baseMode) {
            this.baseMode = baseMode;
            return this;
        }

        /**
         * A bitfield for use for autopilot-specific flags 
         */
        @MavlinkFieldInfo(
                position = 4,
                unitSize = 4
        )
        public final Builder customMode(long customMode) {
            this.customMode = customMode;
            return this;
        }

        /**
         * System status flag, as defined by {@link io.dronefleet.mavlink.common.MavState MAV_STATE} enum 
         */
        @MavlinkFieldInfo(
                position = 5,
                unitSize = 1
        )
        public final Builder systemStatus(MavState systemStatus) {
            this.systemStatus = systemStatus;
            return this;
        }

        /**
         * MAVLink version, not writable by user, gets added by protocol because of magic data type: 
         * uint8_t_mavlink_version 
         */
        @MavlinkFieldInfo(
                position = 6,
                unitSize = 1
        )
        public final Builder mavlinkVersion(int mavlinkVersion) {
            this.mavlinkVersion = mavlinkVersion;
            return this;
        }

        public final Heartbeat build() {
            return new Heartbeat(type, autopilot, baseMode, customMode, systemStatus, mavlinkVersion);
        }
    }
}
