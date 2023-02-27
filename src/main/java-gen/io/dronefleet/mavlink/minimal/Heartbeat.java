package io.dronefleet.mavlink.minimal;

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
 * The heartbeat message shows that a system or component is present and responding. The type and 
 * autopilot fields (along with the message component id), allow the receiving system to treat 
 * further messages from this system appropriately (e.g. by laying out the user interface based 
 * on the autopilot). This microservice is documented at 
 * https://mavlink.io/en/services/heartbeat.html 
 */
@MavlinkMessageInfo(
        id = 0,
        crc = 50,
        description = "The heartbeat message shows that a system or component is present and responding. The type and autopilot fields (along with the message component id), allow the receiving system to treat further messages from this system appropriately (e.g. by laying out the user interface based on the autopilot). This microservice is documented at https://mavlink.io/en/services/heartbeat.html"
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
     * Vehicle or component type. For a flight controller component the vehicle type (quadrotor, 
     * helicopter, etc.). For other components the component type (e.g. camera, gimbal, etc.). This 
     * should be used in preference to component id for identifying the component type. 
     */
    @MavlinkFieldInfo(
            position = 1,
            unitSize = 1,
            enumType = MavType.class,
            description = "Vehicle or component type. For a flight controller component the vehicle type (quadrotor, helicopter, etc.). For other components the component type (e.g. camera, gimbal, etc.). This should be used in preference to component id for identifying the component type."
    )
    public final EnumValue<MavType> type() {
        return this.type;
    }

    /**
     * Autopilot type / class. Use MAV_AUTOPILOT_INVALID for components that are not flight 
     * controllers. 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 1,
            enumType = MavAutopilot.class,
            description = "Autopilot type / class. Use MAV_AUTOPILOT_INVALID for components that are not flight controllers."
    )
    public final EnumValue<MavAutopilot> autopilot() {
        return this.autopilot;
    }

    /**
     * System mode bitmap. 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 1,
            enumType = MavModeFlag.class,
            description = "System mode bitmap."
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
     * System status flag. 
     */
    @MavlinkFieldInfo(
            position = 5,
            unitSize = 1,
            enumType = MavState.class,
            description = "System status flag."
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
         * Vehicle or component type. For a flight controller component the vehicle type (quadrotor, 
         * helicopter, etc.). For other components the component type (e.g. camera, gimbal, etc.). This 
         * should be used in preference to component id for identifying the component type. 
         */
        @MavlinkFieldInfo(
                position = 1,
                unitSize = 1,
                enumType = MavType.class,
                description = "Vehicle or component type. For a flight controller component the vehicle type (quadrotor, helicopter, etc.). For other components the component type (e.g. camera, gimbal, etc.). This should be used in preference to component id for identifying the component type."
        )
        public final Builder type(EnumValue<MavType> type) {
            this.type = type;
            return this;
        }

        /**
         * Vehicle or component type. For a flight controller component the vehicle type (quadrotor, 
         * helicopter, etc.). For other components the component type (e.g. camera, gimbal, etc.). This 
         * should be used in preference to component id for identifying the component type. 
         */
        public final Builder type(MavType entry) {
            return type(EnumValue.of(entry));
        }

        /**
         * Vehicle or component type. For a flight controller component the vehicle type (quadrotor, 
         * helicopter, etc.). For other components the component type (e.g. camera, gimbal, etc.). This 
         * should be used in preference to component id for identifying the component type. 
         */
        public final Builder type(Enum... flags) {
            return type(EnumValue.create(flags));
        }

        /**
         * Vehicle or component type. For a flight controller component the vehicle type (quadrotor, 
         * helicopter, etc.). For other components the component type (e.g. camera, gimbal, etc.). This 
         * should be used in preference to component id for identifying the component type. 
         */
        public final Builder type(Collection<Enum> flags) {
            return type(EnumValue.create(flags));
        }

        /**
         * Autopilot type / class. Use MAV_AUTOPILOT_INVALID for components that are not flight 
         * controllers. 
         */
        @MavlinkFieldInfo(
                position = 2,
                unitSize = 1,
                enumType = MavAutopilot.class,
                description = "Autopilot type / class. Use MAV_AUTOPILOT_INVALID for components that are not flight controllers."
        )
        public final Builder autopilot(EnumValue<MavAutopilot> autopilot) {
            this.autopilot = autopilot;
            return this;
        }

        /**
         * Autopilot type / class. Use MAV_AUTOPILOT_INVALID for components that are not flight 
         * controllers. 
         */
        public final Builder autopilot(MavAutopilot entry) {
            return autopilot(EnumValue.of(entry));
        }

        /**
         * Autopilot type / class. Use MAV_AUTOPILOT_INVALID for components that are not flight 
         * controllers. 
         */
        public final Builder autopilot(Enum... flags) {
            return autopilot(EnumValue.create(flags));
        }

        /**
         * Autopilot type / class. Use MAV_AUTOPILOT_INVALID for components that are not flight 
         * controllers. 
         */
        public final Builder autopilot(Collection<Enum> flags) {
            return autopilot(EnumValue.create(flags));
        }

        /**
         * System mode bitmap. 
         */
        @MavlinkFieldInfo(
                position = 3,
                unitSize = 1,
                enumType = MavModeFlag.class,
                description = "System mode bitmap."
        )
        public final Builder baseMode(EnumValue<MavModeFlag> baseMode) {
            this.baseMode = baseMode;
            return this;
        }

        /**
         * System mode bitmap. 
         */
        public final Builder baseMode(MavModeFlag entry) {
            return baseMode(EnumValue.of(entry));
        }

        /**
         * System mode bitmap. 
         */
        public final Builder baseMode(Enum... flags) {
            return baseMode(EnumValue.create(flags));
        }

        /**
         * System mode bitmap. 
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
         * System status flag. 
         */
        @MavlinkFieldInfo(
                position = 5,
                unitSize = 1,
                enumType = MavState.class,
                description = "System status flag."
        )
        public final Builder systemStatus(EnumValue<MavState> systemStatus) {
            this.systemStatus = systemStatus;
            return this;
        }

        /**
         * System status flag. 
         */
        public final Builder systemStatus(MavState entry) {
            return systemStatus(EnumValue.of(entry));
        }

        /**
         * System status flag. 
         */
        public final Builder systemStatus(Enum... flags) {
            return systemStatus(EnumValue.create(flags));
        }

        /**
         * System status flag. 
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
