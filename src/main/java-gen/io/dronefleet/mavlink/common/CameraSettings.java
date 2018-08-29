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
 * Settings of a camera, can be requested using MAV_CMD_REQUEST_CAMERA_SETTINGS. 
 */
@MavlinkMessageInfo(
        id = 260,
        crc = 146
)
public final class CameraSettings {
    private final long timeBootMs;

    private final EnumValue<CameraMode> modeId;

    private CameraSettings(long timeBootMs, EnumValue<CameraMode> modeId) {
        this.timeBootMs = timeBootMs;
        this.modeId = modeId;
    }

    /**
     * Returns a builder instance for this message.
     */
    @MavlinkMessageBuilder
    public static Builder builder() {
        return new Builder();
    }

    /**
     * Timestamp (milliseconds since system boot) 
     */
    @MavlinkFieldInfo(
            position = 1,
            unitSize = 4
    )
    public final long timeBootMs() {
        return this.timeBootMs;
    }

    /**
     * Camera mode ({@link io.dronefleet.mavlink.common.CameraMode CAMERA_MODE}) 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 1,
            enumType = CameraMode.class
    )
    public final EnumValue<CameraMode> modeId() {
        return this.modeId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !getClass().equals(o.getClass())) return false;
        CameraSettings other = (CameraSettings)o;
        if (!Objects.deepEquals(timeBootMs, other.timeBootMs)) return false;
        if (!Objects.deepEquals(modeId, other.modeId)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + Objects.hashCode(timeBootMs);
        result = 31 * result + Objects.hashCode(modeId);
        return result;
    }

    @Override
    public String toString() {
        return "CameraSettings{timeBootMs=" + timeBootMs
                 + ", modeId=" + modeId + "}";
    }

    public static final class Builder {
        private long timeBootMs;

        private EnumValue<CameraMode> modeId;

        /**
         * Timestamp (milliseconds since system boot) 
         */
        @MavlinkFieldInfo(
                position = 1,
                unitSize = 4
        )
        public final Builder timeBootMs(long timeBootMs) {
            this.timeBootMs = timeBootMs;
            return this;
        }

        /**
         * Camera mode ({@link io.dronefleet.mavlink.common.CameraMode CAMERA_MODE}) 
         */
        @MavlinkFieldInfo(
                position = 2,
                unitSize = 1,
                enumType = CameraMode.class
        )
        public final Builder modeId(EnumValue<CameraMode> modeId) {
            this.modeId = modeId;
            return this;
        }

        /**
         * Camera mode ({@link io.dronefleet.mavlink.common.CameraMode CAMERA_MODE}) 
         */
        public final Builder modeId(CameraMode entry) {
            return modeId(EnumValue.of(entry));
        }

        /**
         * Camera mode ({@link io.dronefleet.mavlink.common.CameraMode CAMERA_MODE}) 
         */
        public final Builder modeId(Enum... flags) {
            return modeId(EnumValue.create(flags));
        }

        /**
         * Camera mode ({@link io.dronefleet.mavlink.common.CameraMode CAMERA_MODE}) 
         */
        public final Builder modeId(Collection<Enum> flags) {
            return modeId(EnumValue.create(flags));
        }

        public final CameraSettings build() {
            return new CameraSettings(timeBootMs, modeId);
        }
    }
}
