package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import io.dronefleet.mavlink.util.EnumValue;
import java.lang.Deprecated;
import java.lang.Enum;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Collection;
import java.util.Objects;

/**
 * Current status about a high level gimbal manager. This message should be broadcast at a low 
 * regular rate (e.g. 5Hz). 
 * @deprecated This message is a work in progress. It may be modified in a non backward-compatible 
 * way in a future release without any warning. This version of the message may not even work with 
 * autopilots that support this message due to discrepancies between dialect versions. Unless 
 * you completely understand the risks of doing so, don't use it. 
 */
@MavlinkMessageInfo(
        id = 281,
        crc = 48,
        description = "Current status about a high level gimbal manager. This message should be broadcast at a low regular rate (e.g. 5Hz).",
        workInProgress = true
)
@Deprecated
public final class GimbalManagerStatus {
    private final long timeBootMs;

    private final EnumValue<GimbalManagerFlags> flags;

    private final int gimbalDeviceId;

    private final int primaryControlSysid;

    private final int primaryControlCompid;

    private final int secondaryControlSysid;

    private final int secondaryControlCompid;

    private GimbalManagerStatus(long timeBootMs, EnumValue<GimbalManagerFlags> flags,
            int gimbalDeviceId, int primaryControlSysid, int primaryControlCompid,
            int secondaryControlSysid, int secondaryControlCompid) {
        this.timeBootMs = timeBootMs;
        this.flags = flags;
        this.gimbalDeviceId = gimbalDeviceId;
        this.primaryControlSysid = primaryControlSysid;
        this.primaryControlCompid = primaryControlCompid;
        this.secondaryControlSysid = secondaryControlSysid;
        this.secondaryControlCompid = secondaryControlCompid;
    }

    /**
     * Returns a builder instance for this message.
     */
    @MavlinkMessageBuilder
    public static Builder builder() {
        return new Builder();
    }

    /**
     * Timestamp (time since system boot). 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 4,
            description = "Timestamp (time since system boot)."
    )
    public final long timeBootMs() {
        return this.timeBootMs;
    }

    /**
     * High level gimbal manager flags currently applied. 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 4,
            enumType = GimbalManagerFlags.class,
            description = "High level gimbal manager flags currently applied."
    )
    public final EnumValue<GimbalManagerFlags> flags() {
        return this.flags;
    }

    /**
     * Gimbal device ID that this gimbal manager is responsible for. 
     */
    @MavlinkFieldInfo(
            position = 4,
            unitSize = 1,
            description = "Gimbal device ID that this gimbal manager is responsible for."
    )
    public final int gimbalDeviceId() {
        return this.gimbalDeviceId;
    }

    /**
     * System ID of MAVLink component with primary control, 0 for none. 
     */
    @MavlinkFieldInfo(
            position = 5,
            unitSize = 1,
            description = "System ID of MAVLink component with primary control, 0 for none."
    )
    public final int primaryControlSysid() {
        return this.primaryControlSysid;
    }

    /**
     * Component ID of MAVLink component with primary control, 0 for none. 
     */
    @MavlinkFieldInfo(
            position = 6,
            unitSize = 1,
            description = "Component ID of MAVLink component with primary control, 0 for none."
    )
    public final int primaryControlCompid() {
        return this.primaryControlCompid;
    }

    /**
     * System ID of MAVLink component with secondary control, 0 for none. 
     */
    @MavlinkFieldInfo(
            position = 7,
            unitSize = 1,
            description = "System ID of MAVLink component with secondary control, 0 for none."
    )
    public final int secondaryControlSysid() {
        return this.secondaryControlSysid;
    }

    /**
     * Component ID of MAVLink component with secondary control, 0 for none. 
     */
    @MavlinkFieldInfo(
            position = 8,
            unitSize = 1,
            description = "Component ID of MAVLink component with secondary control, 0 for none."
    )
    public final int secondaryControlCompid() {
        return this.secondaryControlCompid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !getClass().equals(o.getClass())) return false;
        GimbalManagerStatus other = (GimbalManagerStatus)o;
        if (!Objects.deepEquals(timeBootMs, other.timeBootMs)) return false;
        if (!Objects.deepEquals(flags, other.flags)) return false;
        if (!Objects.deepEquals(gimbalDeviceId, other.gimbalDeviceId)) return false;
        if (!Objects.deepEquals(primaryControlSysid, other.primaryControlSysid)) return false;
        if (!Objects.deepEquals(primaryControlCompid, other.primaryControlCompid)) return false;
        if (!Objects.deepEquals(secondaryControlSysid, other.secondaryControlSysid)) return false;
        if (!Objects.deepEquals(secondaryControlCompid, other.secondaryControlCompid)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + Objects.hashCode(timeBootMs);
        result = 31 * result + Objects.hashCode(flags);
        result = 31 * result + Objects.hashCode(gimbalDeviceId);
        result = 31 * result + Objects.hashCode(primaryControlSysid);
        result = 31 * result + Objects.hashCode(primaryControlCompid);
        result = 31 * result + Objects.hashCode(secondaryControlSysid);
        result = 31 * result + Objects.hashCode(secondaryControlCompid);
        return result;
    }

    @Override
    public String toString() {
        return "GimbalManagerStatus{timeBootMs=" + timeBootMs
                 + ", flags=" + flags
                 + ", gimbalDeviceId=" + gimbalDeviceId
                 + ", primaryControlSysid=" + primaryControlSysid
                 + ", primaryControlCompid=" + primaryControlCompid
                 + ", secondaryControlSysid=" + secondaryControlSysid
                 + ", secondaryControlCompid=" + secondaryControlCompid + "}";
    }

    public static final class Builder {
        private long timeBootMs;

        private EnumValue<GimbalManagerFlags> flags;

        private int gimbalDeviceId;

        private int primaryControlSysid;

        private int primaryControlCompid;

        private int secondaryControlSysid;

        private int secondaryControlCompid;

        /**
         * Timestamp (time since system boot). 
         */
        @MavlinkFieldInfo(
                position = 2,
                unitSize = 4,
                description = "Timestamp (time since system boot)."
        )
        public final Builder timeBootMs(long timeBootMs) {
            this.timeBootMs = timeBootMs;
            return this;
        }

        /**
         * High level gimbal manager flags currently applied. 
         */
        @MavlinkFieldInfo(
                position = 3,
                unitSize = 4,
                enumType = GimbalManagerFlags.class,
                description = "High level gimbal manager flags currently applied."
        )
        public final Builder flags(EnumValue<GimbalManagerFlags> flags) {
            this.flags = flags;
            return this;
        }

        /**
         * High level gimbal manager flags currently applied. 
         */
        public final Builder flags(GimbalManagerFlags entry) {
            return flags(EnumValue.of(entry));
        }

        /**
         * High level gimbal manager flags currently applied. 
         */
        public final Builder flags(Enum... flags) {
            return flags(EnumValue.create(flags));
        }

        /**
         * High level gimbal manager flags currently applied. 
         */
        public final Builder flags(Collection<Enum> flags) {
            return flags(EnumValue.create(flags));
        }

        /**
         * Gimbal device ID that this gimbal manager is responsible for. 
         */
        @MavlinkFieldInfo(
                position = 4,
                unitSize = 1,
                description = "Gimbal device ID that this gimbal manager is responsible for."
        )
        public final Builder gimbalDeviceId(int gimbalDeviceId) {
            this.gimbalDeviceId = gimbalDeviceId;
            return this;
        }

        /**
         * System ID of MAVLink component with primary control, 0 for none. 
         */
        @MavlinkFieldInfo(
                position = 5,
                unitSize = 1,
                description = "System ID of MAVLink component with primary control, 0 for none."
        )
        public final Builder primaryControlSysid(int primaryControlSysid) {
            this.primaryControlSysid = primaryControlSysid;
            return this;
        }

        /**
         * Component ID of MAVLink component with primary control, 0 for none. 
         */
        @MavlinkFieldInfo(
                position = 6,
                unitSize = 1,
                description = "Component ID of MAVLink component with primary control, 0 for none."
        )
        public final Builder primaryControlCompid(int primaryControlCompid) {
            this.primaryControlCompid = primaryControlCompid;
            return this;
        }

        /**
         * System ID of MAVLink component with secondary control, 0 for none. 
         */
        @MavlinkFieldInfo(
                position = 7,
                unitSize = 1,
                description = "System ID of MAVLink component with secondary control, 0 for none."
        )
        public final Builder secondaryControlSysid(int secondaryControlSysid) {
            this.secondaryControlSysid = secondaryControlSysid;
            return this;
        }

        /**
         * Component ID of MAVLink component with secondary control, 0 for none. 
         */
        @MavlinkFieldInfo(
                position = 8,
                unitSize = 1,
                description = "Component ID of MAVLink component with secondary control, 0 for none."
        )
        public final Builder secondaryControlCompid(int secondaryControlCompid) {
            this.secondaryControlCompid = secondaryControlCompid;
            return this;
        }

        public final GimbalManagerStatus build() {
            return new GimbalManagerStatus(timeBootMs, flags, gimbalDeviceId, primaryControlSysid, primaryControlCompid, secondaryControlSysid, secondaryControlCompid);
        }
    }
}
