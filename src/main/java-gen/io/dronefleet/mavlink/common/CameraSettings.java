package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;

/**
 * Settings of a camera, can be requested using MAV_CMD_REQUEST_CAMERA_SETTINGS. 
 */
@MavlinkMessageInfo(
        id = 260,
        crc = 146
)
public final class CameraSettings {
    private final long timeBootMs;

    private final CameraMode modeId;

    private CameraSettings(long timeBootMs, CameraMode modeId) {
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
            unitSize = 1
    )
    public final CameraMode modeId() {
        return this.modeId;
    }

    public static final class Builder {
        private long timeBootMs;

        private CameraMode modeId;

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
                unitSize = 1
        )
        public final Builder modeId(CameraMode modeId) {
            this.modeId = modeId;
            return this;
        }

        public final CameraSettings build() {
            return new CameraSettings(timeBootMs, modeId);
        }
    }
}
