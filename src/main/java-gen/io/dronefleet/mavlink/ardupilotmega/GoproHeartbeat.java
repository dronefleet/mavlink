package io.dronefleet.mavlink.ardupilotmega;

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
 * Heartbeat from a HeroBus attached GoPro 
 */
@MavlinkMessageInfo(
        id = 215,
        crc = 101
)
public final class GoproHeartbeat {
    private final EnumValue<GoproHeartbeatStatus> status;

    private final EnumValue<GoproCaptureMode> captureMode;

    private final EnumValue<GoproHeartbeatFlags> flags;

    private GoproHeartbeat(EnumValue<GoproHeartbeatStatus> status,
            EnumValue<GoproCaptureMode> captureMode, EnumValue<GoproHeartbeatFlags> flags) {
        this.status = status;
        this.captureMode = captureMode;
        this.flags = flags;
    }

    /**
     * Returns a builder instance for this message.
     */
    @MavlinkMessageBuilder
    public static Builder builder() {
        return new Builder();
    }

    /**
     * Status 
     */
    @MavlinkFieldInfo(
            position = 1,
            unitSize = 1,
            enumType = GoproHeartbeatStatus.class
    )
    public final EnumValue<GoproHeartbeatStatus> status() {
        return this.status;
    }

    /**
     * Current capture mode 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 1,
            enumType = GoproCaptureMode.class
    )
    public final EnumValue<GoproCaptureMode> captureMode() {
        return this.captureMode;
    }

    /**
     * additional status bits 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 1,
            enumType = GoproHeartbeatFlags.class
    )
    public final EnumValue<GoproHeartbeatFlags> flags() {
        return this.flags;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !getClass().equals(o.getClass())) return false;
        GoproHeartbeat other = (GoproHeartbeat)o;
        if (!Objects.deepEquals(status, other.status)) return false;
        if (!Objects.deepEquals(captureMode, other.captureMode)) return false;
        if (!Objects.deepEquals(flags, other.flags)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + Objects.hashCode(status);
        result = 31 * result + Objects.hashCode(captureMode);
        result = 31 * result + Objects.hashCode(flags);
        return result;
    }

    @Override
    public String toString() {
        return "GoproHeartbeat{status=" + status
                 + ", captureMode=" + captureMode
                 + ", flags=" + flags + "}";
    }

    public static final class Builder {
        private EnumValue<GoproHeartbeatStatus> status;

        private EnumValue<GoproCaptureMode> captureMode;

        private EnumValue<GoproHeartbeatFlags> flags;

        /**
         * Status 
         */
        @MavlinkFieldInfo(
                position = 1,
                unitSize = 1,
                enumType = GoproHeartbeatStatus.class
        )
        public final Builder status(EnumValue<GoproHeartbeatStatus> status) {
            this.status = status;
            return this;
        }

        /**
         * Status 
         */
        public final Builder status(GoproHeartbeatStatus entry) {
            return status(EnumValue.of(entry));
        }

        /**
         * Status 
         */
        public final Builder status(Enum... flags) {
            return status(EnumValue.create(flags));
        }

        /**
         * Status 
         */
        public final Builder status(Collection<Enum> flags) {
            return status(EnumValue.create(flags));
        }

        /**
         * Current capture mode 
         */
        @MavlinkFieldInfo(
                position = 2,
                unitSize = 1,
                enumType = GoproCaptureMode.class
        )
        public final Builder captureMode(EnumValue<GoproCaptureMode> captureMode) {
            this.captureMode = captureMode;
            return this;
        }

        /**
         * Current capture mode 
         */
        public final Builder captureMode(GoproCaptureMode entry) {
            return captureMode(EnumValue.of(entry));
        }

        /**
         * Current capture mode 
         */
        public final Builder captureMode(Enum... flags) {
            return captureMode(EnumValue.create(flags));
        }

        /**
         * Current capture mode 
         */
        public final Builder captureMode(Collection<Enum> flags) {
            return captureMode(EnumValue.create(flags));
        }

        /**
         * additional status bits 
         */
        @MavlinkFieldInfo(
                position = 3,
                unitSize = 1,
                enumType = GoproHeartbeatFlags.class
        )
        public final Builder flags(EnumValue<GoproHeartbeatFlags> flags) {
            this.flags = flags;
            return this;
        }

        /**
         * additional status bits 
         */
        public final Builder flags(GoproHeartbeatFlags entry) {
            return flags(EnumValue.of(entry));
        }

        /**
         * additional status bits 
         */
        public final Builder flags(Enum... flags) {
            return flags(EnumValue.create(flags));
        }

        /**
         * additional status bits 
         */
        public final Builder flags(Collection<Enum> flags) {
            return flags(EnumValue.create(flags));
        }

        public final GoproHeartbeat build() {
            return new GoproHeartbeat(status, captureMode, flags);
        }
    }
}
