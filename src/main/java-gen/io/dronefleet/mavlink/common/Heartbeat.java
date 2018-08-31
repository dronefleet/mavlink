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
 * The heartbeat message shows that a system is present and responding. The type of the MAV and 
 * Autopilot hardware allow the receiving system to treat further messages from this system 
 * appropriate (e.g. by laying out the user interface based on the autopilot). 
 */
@MavlinkMessageInfo(
        id = 0,
        crc = 50,
        description = "The heartbeat message shows that a system is present and responding. The type of the MAV and Autopilot hardware allow the receiving system to treat further messages from this system appropriate (e.g. by laying out the user interface based on the autopilot)."
)
public final class Heartbeat {
    private final EnumValue<MavType> type;

    private final EnumValue<MavAutopilot> autopilot;

    private final EnumValue<MavModeFlag> baseMode;

    private final long customMode;

    private final EnumValue<MavState> systemStatus;

    private final int mavlinkVersion;

    private Heartbeat(EnumValue<MavType> type, EnumValue<MavAutopilot> autopilot,
            EnumValue<MavModeFlag> baseMode, long customMode, EnumValue<MavState> systemStatus,
            int mavlinkVersion) {
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
            unitSize = 1,
            enumType = MavType.class,
            description = "Type of the MAV (quadrotor, helicopter, etc., up to 15 types, defined in MAV_TYPE ENUM)"
    )
    public final EnumValue<MavType> type() {
        return this.type;
    }

    /**
     * Autopilot type / class. defined in {@link io.dronefleet.mavlink.common.MavAutopilot MAV_AUTOPILOT} ENUM 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 1,
            enumType = MavAutopilot.class,
            description = "Autopilot type / class. defined in MAV_AUTOPILOT ENUM"
    )
    public final EnumValue<MavAutopilot> autopilot() {
        return this.autopilot;
    }

    /**
     * System mode bitfield, as defined by {@link io.dronefleet.mavlink.common.MavModeFlag MAV_MODE_FLAG} enum 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 1,
            enumType = MavModeFlag.class,
            description = "System mode bitfield, as defined by MAV_MODE_FLAG enum"
    )
    public final EnumValue<MavModeFlag> baseMode() {
        return this.baseMode;
    }

    /**
     * A bitfield for use for autopilot-specific flags 
     */
    @MavlinkFieldInfo(
            position = 4,
            unitSize = 4,
            description = "A bitfield for use for autopilot-specific flags"
    )
    public final long customMode() {
        return this.customMode;
    }

    /**
     * System status flag, as defined by {@link io.dronefleet.mavlink.common.MavState MAV_STATE} enum 
     */
    @MavlinkFieldInfo(
            position = 5,
            unitSize = 1,
            enumType = MavState.class,
            description = "System status flag, as defined by MAV_STATE enum"
    )
    public final EnumValue<MavState> systemStatus() {
        return this.systemStatus;
    }

    /**
     * MAVLink version, not writable by user, gets added by protocol because of magic data type: 
     * uint8_t_mavlink_version 
     */
    @MavlinkFieldInfo(
            position = 6,
            unitSize = 1,
            description = "MAVLink version, not writable by user, gets added by protocol because of magic data type: uint8_t_mavlink_version"
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

    @Override
    public String toString() {
        return "Heartbeat{type=" + type
                 + ", autopilot=" + autopilot
                 + ", baseMode=" + baseMode
                 + ", customMode=" + customMode
                 + ", systemStatus=" + systemStatus
                 + ", mavlinkVersion=" + mavlinkVersion + "}";
    }

    public static final class Builder {
        private EnumValue<MavType> type;

        private EnumValue<MavAutopilot> autopilot;

        private EnumValue<MavModeFlag> baseMode;

        private long customMode;

        private EnumValue<MavState> systemStatus;

        private int mavlinkVersion;

        /**
         * Type of the MAV (quadrotor, helicopter, etc., up to 15 types, defined in {@link io.dronefleet.mavlink.common.MavType MAV_TYPE} ENUM) 
         */
        @MavlinkFieldInfo(
                position = 1,
                unitSize = 1,
                enumType = MavType.class,
                description = "Type of the MAV (quadrotor, helicopter, etc., up to 15 types, defined in MAV_TYPE ENUM)"
        )
        public final Builder type(EnumValue<MavType> type) {
            this.type = type;
            return this;
        }

        /**
         * Type of the MAV (quadrotor, helicopter, etc., up to 15 types, defined in {@link io.dronefleet.mavlink.common.MavType MAV_TYPE} ENUM) 
         */
        public final Builder type(MavType entry) {
            return type(EnumValue.of(entry));
        }

        /**
         * Type of the MAV (quadrotor, helicopter, etc., up to 15 types, defined in {@link io.dronefleet.mavlink.common.MavType MAV_TYPE} ENUM) 
         */
        public final Builder type(Enum... flags) {
            return type(EnumValue.create(flags));
        }

        /**
         * Type of the MAV (quadrotor, helicopter, etc., up to 15 types, defined in {@link io.dronefleet.mavlink.common.MavType MAV_TYPE} ENUM) 
         */
        public final Builder type(Collection<Enum> flags) {
            return type(EnumValue.create(flags));
        }

        /**
         * Autopilot type / class. defined in {@link io.dronefleet.mavlink.common.MavAutopilot MAV_AUTOPILOT} ENUM 
         */
        @MavlinkFieldInfo(
                position = 2,
                unitSize = 1,
                enumType = MavAutopilot.class,
                description = "Autopilot type / class. defined in MAV_AUTOPILOT ENUM"
        )
        public final Builder autopilot(EnumValue<MavAutopilot> autopilot) {
            this.autopilot = autopilot;
            return this;
        }

        /**
         * Autopilot type / class. defined in {@link io.dronefleet.mavlink.common.MavAutopilot MAV_AUTOPILOT} ENUM 
         */
        public final Builder autopilot(MavAutopilot entry) {
            return autopilot(EnumValue.of(entry));
        }

        /**
         * Autopilot type / class. defined in {@link io.dronefleet.mavlink.common.MavAutopilot MAV_AUTOPILOT} ENUM 
         */
        public final Builder autopilot(Enum... flags) {
            return autopilot(EnumValue.create(flags));
        }

        /**
         * Autopilot type / class. defined in {@link io.dronefleet.mavlink.common.MavAutopilot MAV_AUTOPILOT} ENUM 
         */
        public final Builder autopilot(Collection<Enum> flags) {
            return autopilot(EnumValue.create(flags));
        }

        /**
         * System mode bitfield, as defined by {@link io.dronefleet.mavlink.common.MavModeFlag MAV_MODE_FLAG} enum 
         */
        @MavlinkFieldInfo(
                position = 3,
                unitSize = 1,
                enumType = MavModeFlag.class,
                description = "System mode bitfield, as defined by MAV_MODE_FLAG enum"
        )
        public final Builder baseMode(EnumValue<MavModeFlag> baseMode) {
            this.baseMode = baseMode;
            return this;
        }

        /**
         * System mode bitfield, as defined by {@link io.dronefleet.mavlink.common.MavModeFlag MAV_MODE_FLAG} enum 
         */
        public final Builder baseMode(MavModeFlag entry) {
            return baseMode(EnumValue.of(entry));
        }

        /**
         * System mode bitfield, as defined by {@link io.dronefleet.mavlink.common.MavModeFlag MAV_MODE_FLAG} enum 
         */
        public final Builder baseMode(Enum... flags) {
            return baseMode(EnumValue.create(flags));
        }

        /**
         * System mode bitfield, as defined by {@link io.dronefleet.mavlink.common.MavModeFlag MAV_MODE_FLAG} enum 
         */
        public final Builder baseMode(Collection<Enum> flags) {
            return baseMode(EnumValue.create(flags));
        }

        /**
         * A bitfield for use for autopilot-specific flags 
         */
        @MavlinkFieldInfo(
                position = 4,
                unitSize = 4,
                description = "A bitfield for use for autopilot-specific flags"
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
                unitSize = 1,
                enumType = MavState.class,
                description = "System status flag, as defined by MAV_STATE enum"
        )
        public final Builder systemStatus(EnumValue<MavState> systemStatus) {
            this.systemStatus = systemStatus;
            return this;
        }

        /**
         * System status flag, as defined by {@link io.dronefleet.mavlink.common.MavState MAV_STATE} enum 
         */
        public final Builder systemStatus(MavState entry) {
            return systemStatus(EnumValue.of(entry));
        }

        /**
         * System status flag, as defined by {@link io.dronefleet.mavlink.common.MavState MAV_STATE} enum 
         */
        public final Builder systemStatus(Enum... flags) {
            return systemStatus(EnumValue.create(flags));
        }

        /**
         * System status flag, as defined by {@link io.dronefleet.mavlink.common.MavState MAV_STATE} enum 
         */
        public final Builder systemStatus(Collection<Enum> flags) {
            return systemStatus(EnumValue.create(flags));
        }

        /**
         * MAVLink version, not writable by user, gets added by protocol because of magic data type: 
         * uint8_t_mavlink_version 
         */
        @MavlinkFieldInfo(
                position = 6,
                unitSize = 1,
                description = "MAVLink version, not writable by user, gets added by protocol because of magic data type: uint8_t_mavlink_version"
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
