package io.dronefleet.mavlink.storm32;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import io.dronefleet.mavlink.common.GimbalDeviceFlags;
import io.dronefleet.mavlink.util.EnumValue;
import java.lang.Enum;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Collection;
import java.util.Objects;

/**
 * Message reporting the current status of a gimbal manager. This message should be broadcast at a 
 * low regular rate (e.g. 1 Hz, may be increase momentarily to e.g. 5 Hz for a period of 1 sec after a 
 * change). 
 */
@MavlinkMessageInfo(
        id = 60011,
        crc = 183,
        description = "Message reporting the current status of a gimbal manager. This message should be broadcast at a low regular rate (e.g. 1 Hz, may be increase momentarily to e.g. 5 Hz for a period of 1 sec after a change)."
)
public final class Storm32GimbalManagerStatus {
    private final int gimbalId;

    private final EnumValue<MavStorm32GimbalManagerClient> supervisor;

    private final EnumValue<GimbalDeviceFlags> deviceFlags;

    private final EnumValue<MavStorm32GimbalManagerFlags> managerFlags;

    private final EnumValue<MavStorm32GimbalManagerProfile> profile;

    private Storm32GimbalManagerStatus(int gimbalId,
            EnumValue<MavStorm32GimbalManagerClient> supervisor,
            EnumValue<GimbalDeviceFlags> deviceFlags,
            EnumValue<MavStorm32GimbalManagerFlags> managerFlags,
            EnumValue<MavStorm32GimbalManagerProfile> profile) {
        this.gimbalId = gimbalId;
        this.supervisor = supervisor;
        this.deviceFlags = deviceFlags;
        this.managerFlags = managerFlags;
        this.profile = profile;
    }

    /**
     * Returns a builder instance for this message.
     */
    @MavlinkMessageBuilder
    public static Builder builder() {
        return new Builder();
    }

    /**
     * Gimbal ID (component ID or 1-6 for non-MAVLink gimbal) that this gimbal manager is responsible 
     * for. 
     */
    @MavlinkFieldInfo(
            position = 1,
            unitSize = 1,
            description = "Gimbal ID (component ID or 1-6 for non-MAVLink gimbal) that this gimbal manager is responsible for."
    )
    public final int gimbalId() {
        return this.gimbalId;
    }

    /**
     * Client who is currently supervisor (0 = none). 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 1,
            enumType = MavStorm32GimbalManagerClient.class,
            description = "Client who is currently supervisor (0 = none)."
    )
    public final EnumValue<MavStorm32GimbalManagerClient> supervisor() {
        return this.supervisor;
    }

    /**
     * Gimbal device flags currently applied. Same flags as reported by 
     * GIMBAL_DEVICE_ATTITUDE_STATUS. 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 2,
            enumType = GimbalDeviceFlags.class,
            description = "Gimbal device flags currently applied. Same flags as reported by GIMBAL_DEVICE_ATTITUDE_STATUS."
    )
    public final EnumValue<GimbalDeviceFlags> deviceFlags() {
        return this.deviceFlags;
    }

    /**
     * Gimbal manager flags currently applied. 
     */
    @MavlinkFieldInfo(
            position = 4,
            unitSize = 2,
            enumType = MavStorm32GimbalManagerFlags.class,
            description = "Gimbal manager flags currently applied."
    )
    public final EnumValue<MavStorm32GimbalManagerFlags> managerFlags() {
        return this.managerFlags;
    }

    /**
     * Profile currently applied (0 = default). 
     */
    @MavlinkFieldInfo(
            position = 5,
            unitSize = 1,
            enumType = MavStorm32GimbalManagerProfile.class,
            description = "Profile currently applied (0 = default)."
    )
    public final EnumValue<MavStorm32GimbalManagerProfile> profile() {
        return this.profile;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !getClass().equals(o.getClass())) return false;
        Storm32GimbalManagerStatus other = (Storm32GimbalManagerStatus)o;
        if (!Objects.deepEquals(gimbalId, other.gimbalId)) return false;
        if (!Objects.deepEquals(supervisor, other.supervisor)) return false;
        if (!Objects.deepEquals(deviceFlags, other.deviceFlags)) return false;
        if (!Objects.deepEquals(managerFlags, other.managerFlags)) return false;
        if (!Objects.deepEquals(profile, other.profile)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + Objects.hashCode(gimbalId);
        result = 31 * result + Objects.hashCode(supervisor);
        result = 31 * result + Objects.hashCode(deviceFlags);
        result = 31 * result + Objects.hashCode(managerFlags);
        result = 31 * result + Objects.hashCode(profile);
        return result;
    }

    @Override
    public String toString() {
        return "Storm32GimbalManagerStatus{gimbalId=" + gimbalId
                 + ", supervisor=" + supervisor
                 + ", deviceFlags=" + deviceFlags
                 + ", managerFlags=" + managerFlags
                 + ", profile=" + profile + "}";
    }

    public static final class Builder {
        private int gimbalId;

        private EnumValue<MavStorm32GimbalManagerClient> supervisor;

        private EnumValue<GimbalDeviceFlags> deviceFlags;

        private EnumValue<MavStorm32GimbalManagerFlags> managerFlags;

        private EnumValue<MavStorm32GimbalManagerProfile> profile;

        /**
         * Gimbal ID (component ID or 1-6 for non-MAVLink gimbal) that this gimbal manager is responsible 
         * for. 
         */
        @MavlinkFieldInfo(
                position = 1,
                unitSize = 1,
                description = "Gimbal ID (component ID or 1-6 for non-MAVLink gimbal) that this gimbal manager is responsible for."
        )
        public final Builder gimbalId(int gimbalId) {
            this.gimbalId = gimbalId;
            return this;
        }

        /**
         * Client who is currently supervisor (0 = none). 
         */
        @MavlinkFieldInfo(
                position = 2,
                unitSize = 1,
                enumType = MavStorm32GimbalManagerClient.class,
                description = "Client who is currently supervisor (0 = none)."
        )
        public final Builder supervisor(EnumValue<MavStorm32GimbalManagerClient> supervisor) {
            this.supervisor = supervisor;
            return this;
        }

        /**
         * Client who is currently supervisor (0 = none). 
         */
        public final Builder supervisor(MavStorm32GimbalManagerClient entry) {
            return supervisor(EnumValue.of(entry));
        }

        /**
         * Client who is currently supervisor (0 = none). 
         */
        public final Builder supervisor(Enum... flags) {
            return supervisor(EnumValue.create(flags));
        }

        /**
         * Client who is currently supervisor (0 = none). 
         */
        public final Builder supervisor(Collection<Enum> flags) {
            return supervisor(EnumValue.create(flags));
        }

        /**
         * Gimbal device flags currently applied. Same flags as reported by 
         * GIMBAL_DEVICE_ATTITUDE_STATUS. 
         */
        @MavlinkFieldInfo(
                position = 3,
                unitSize = 2,
                enumType = GimbalDeviceFlags.class,
                description = "Gimbal device flags currently applied. Same flags as reported by GIMBAL_DEVICE_ATTITUDE_STATUS."
        )
        public final Builder deviceFlags(EnumValue<GimbalDeviceFlags> deviceFlags) {
            this.deviceFlags = deviceFlags;
            return this;
        }

        /**
         * Gimbal device flags currently applied. Same flags as reported by 
         * GIMBAL_DEVICE_ATTITUDE_STATUS. 
         */
        public final Builder deviceFlags(GimbalDeviceFlags entry) {
            return deviceFlags(EnumValue.of(entry));
        }

        /**
         * Gimbal device flags currently applied. Same flags as reported by 
         * GIMBAL_DEVICE_ATTITUDE_STATUS. 
         */
        public final Builder deviceFlags(Enum... flags) {
            return deviceFlags(EnumValue.create(flags));
        }

        /**
         * Gimbal device flags currently applied. Same flags as reported by 
         * GIMBAL_DEVICE_ATTITUDE_STATUS. 
         */
        public final Builder deviceFlags(Collection<Enum> flags) {
            return deviceFlags(EnumValue.create(flags));
        }

        /**
         * Gimbal manager flags currently applied. 
         */
        @MavlinkFieldInfo(
                position = 4,
                unitSize = 2,
                enumType = MavStorm32GimbalManagerFlags.class,
                description = "Gimbal manager flags currently applied."
        )
        public final Builder managerFlags(EnumValue<MavStorm32GimbalManagerFlags> managerFlags) {
            this.managerFlags = managerFlags;
            return this;
        }

        /**
         * Gimbal manager flags currently applied. 
         */
        public final Builder managerFlags(MavStorm32GimbalManagerFlags entry) {
            return managerFlags(EnumValue.of(entry));
        }

        /**
         * Gimbal manager flags currently applied. 
         */
        public final Builder managerFlags(Enum... flags) {
            return managerFlags(EnumValue.create(flags));
        }

        /**
         * Gimbal manager flags currently applied. 
         */
        public final Builder managerFlags(Collection<Enum> flags) {
            return managerFlags(EnumValue.create(flags));
        }

        /**
         * Profile currently applied (0 = default). 
         */
        @MavlinkFieldInfo(
                position = 5,
                unitSize = 1,
                enumType = MavStorm32GimbalManagerProfile.class,
                description = "Profile currently applied (0 = default)."
        )
        public final Builder profile(EnumValue<MavStorm32GimbalManagerProfile> profile) {
            this.profile = profile;
            return this;
        }

        /**
         * Profile currently applied (0 = default). 
         */
        public final Builder profile(MavStorm32GimbalManagerProfile entry) {
            return profile(EnumValue.of(entry));
        }

        /**
         * Profile currently applied (0 = default). 
         */
        public final Builder profile(Enum... flags) {
            return profile(EnumValue.create(flags));
        }

        /**
         * Profile currently applied (0 = default). 
         */
        public final Builder profile(Collection<Enum> flags) {
            return profile(EnumValue.create(flags));
        }

        public final Storm32GimbalManagerStatus build() {
            return new Storm32GimbalManagerStatus(gimbalId, supervisor, deviceFlags, managerFlags, profile);
        }
    }
}
