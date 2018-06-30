package io.dronefleet.mavlink.ardupilotmega;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import io.dronefleet.mavlink.util.EnumFlagSet;
import java.lang.Object;
import java.lang.Override;
import java.util.Objects;

/**
 * Heartbeat from a HeroBus attached GoPro 
 */
@MavlinkMessageInfo(
        id = 215,
        crc = 101
)
public final class GoproHeartbeat {
    private final GoproHeartbeatStatus status;

    private final GoproCaptureMode captureMode;

    private final EnumFlagSet<GoproHeartbeatFlags> flags;

    private GoproHeartbeat(GoproHeartbeatStatus status, GoproCaptureMode captureMode,
            EnumFlagSet<GoproHeartbeatFlags> flags) {
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
            unitSize = 1
    )
    public final GoproHeartbeatStatus status() {
        return this.status;
    }

    /**
     * Current capture mode 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 1
    )
    public final GoproCaptureMode captureMode() {
        return this.captureMode;
    }

    /**
     * additional status bits 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 1
    )
    public final EnumFlagSet<GoproHeartbeatFlags> flags() {
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

    public static final class Builder {
        private GoproHeartbeatStatus status;

        private GoproCaptureMode captureMode;

        private EnumFlagSet<GoproHeartbeatFlags> flags;

        /**
         * Status 
         */
        @MavlinkFieldInfo(
                position = 1,
                unitSize = 1
        )
        public final Builder status(GoproHeartbeatStatus status) {
            this.status = status;
            return this;
        }

        /**
         * Current capture mode 
         */
        @MavlinkFieldInfo(
                position = 2,
                unitSize = 1
        )
        public final Builder captureMode(GoproCaptureMode captureMode) {
            this.captureMode = captureMode;
            return this;
        }

        /**
         * additional status bits 
         */
        @MavlinkFieldInfo(
                position = 3,
                unitSize = 1
        )
        public final Builder flags(EnumFlagSet<GoproHeartbeatFlags> flags) {
            this.flags = flags;
            return this;
        }

        public final GoproHeartbeat build() {
            return new GoproHeartbeat(status, captureMode, flags);
        }
    }
}
