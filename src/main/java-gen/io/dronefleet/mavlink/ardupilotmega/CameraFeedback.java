package io.dronefleet.mavlink.ardupilotmega;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import java.lang.Override;
import java.lang.String;
import java.math.BigInteger;

/**
 * Camera Capture Feedback 
 */
@MavlinkMessageInfo(
        id = 180,
        crc = 52
)
public final class CameraFeedback {
    /**
     * Image timestamp (microseconds since UNIX epoch), as passed in by {@link io.dronefleet.mavlink.ardupilotmega.CameraStatus CameraStatus} message (or 
     * autopilot if no CCB) 
     */
    private final BigInteger timeUsec;

    /**
     * Latitude in (deg * 1E7) 
     */
    private final int lat;

    /**
     * Longitude in (deg * 1E7) 
     */
    private final int lng;

    /**
     * Altitude Absolute (meters AMSL) 
     */
    private final float altMsl;

    /**
     * Altitude Relative (meters above HOME location) 
     */
    private final float altRel;

    /**
     * Camera Roll angle (earth frame, degrees, +-180) 
     */
    private final float roll;

    /**
     * Camera Pitch angle (earth frame, degrees, +-180) 
     */
    private final float pitch;

    /**
     * Camera Yaw (earth frame, degrees, 0-360, true) 
     */
    private final float yaw;

    /**
     * Focal Length (mm) 
     */
    private final float focLen;

    /**
     * Image index 
     */
    private final int imgIdx;

    /**
     * System ID 
     */
    private final int targetSystem;

    /**
     * Camera ID 
     */
    private final int camIdx;

    /**
     * See {@link io.dronefleet.mavlink.ardupilotmega.CameraFeedbackFlags CameraFeedbackFlags} enum for definition of the bitmask 
     */
    private final CameraFeedbackFlags flags;

    /**
     * Completed image captures 
     */
    private final int completedCaptures;

    private CameraFeedback(BigInteger timeUsec, int lat, int lng, float altMsl, float altRel,
            float roll, float pitch, float yaw, float focLen, int imgIdx, int targetSystem,
            int camIdx, CameraFeedbackFlags flags, int completedCaptures) {
        this.timeUsec = timeUsec;
        this.lat = lat;
        this.lng = lng;
        this.altMsl = altMsl;
        this.altRel = altRel;
        this.roll = roll;
        this.pitch = pitch;
        this.yaw = yaw;
        this.focLen = focLen;
        this.imgIdx = imgIdx;
        this.targetSystem = targetSystem;
        this.camIdx = camIdx;
        this.flags = flags;
        this.completedCaptures = completedCaptures;
    }

    @MavlinkMessageBuilder
    public static Builder builder() {
        return new Builder();
    }

    @Override
    public String toString() {
        return "CameraFeedback{timeUsec=" + timeUsec
                 + ", targetSystem=" + targetSystem
                 + ", camIdx=" + camIdx
                 + ", imgIdx=" + imgIdx
                 + ", lat=" + lat
                 + ", lng=" + lng
                 + ", altMsl=" + altMsl
                 + ", altRel=" + altRel
                 + ", roll=" + roll
                 + ", pitch=" + pitch
                 + ", yaw=" + yaw
                 + ", focLen=" + focLen
                 + ", flags=" + flags
                 + ", completedCaptures=" + completedCaptures + "}";
    }

    /**
     * Image timestamp (microseconds since UNIX epoch), as passed in by {@link io.dronefleet.mavlink.ardupilotmega.CameraStatus CameraStatus} message (or 
     * autopilot if no CCB) 
     */
    @MavlinkFieldInfo(
            position = 1,
            unitSize = 8
    )
    public final BigInteger timeUsec() {
        return timeUsec;
    }

    /**
     * Latitude in (deg * 1E7) 
     */
    @MavlinkFieldInfo(
            position = 5,
            unitSize = 4,
            signed = true
    )
    public final int lat() {
        return lat;
    }

    /**
     * Longitude in (deg * 1E7) 
     */
    @MavlinkFieldInfo(
            position = 6,
            unitSize = 4,
            signed = true
    )
    public final int lng() {
        return lng;
    }

    /**
     * Altitude Absolute (meters AMSL) 
     */
    @MavlinkFieldInfo(
            position = 7,
            unitSize = 4
    )
    public final float altMsl() {
        return altMsl;
    }

    /**
     * Altitude Relative (meters above HOME location) 
     */
    @MavlinkFieldInfo(
            position = 8,
            unitSize = 4
    )
    public final float altRel() {
        return altRel;
    }

    /**
     * Camera Roll angle (earth frame, degrees, +-180) 
     */
    @MavlinkFieldInfo(
            position = 9,
            unitSize = 4
    )
    public final float roll() {
        return roll;
    }

    /**
     * Camera Pitch angle (earth frame, degrees, +-180) 
     */
    @MavlinkFieldInfo(
            position = 10,
            unitSize = 4
    )
    public final float pitch() {
        return pitch;
    }

    /**
     * Camera Yaw (earth frame, degrees, 0-360, true) 
     */
    @MavlinkFieldInfo(
            position = 11,
            unitSize = 4
    )
    public final float yaw() {
        return yaw;
    }

    /**
     * Focal Length (mm) 
     */
    @MavlinkFieldInfo(
            position = 12,
            unitSize = 4
    )
    public final float focLen() {
        return focLen;
    }

    /**
     * Image index 
     */
    @MavlinkFieldInfo(
            position = 4,
            unitSize = 2
    )
    public final int imgIdx() {
        return imgIdx;
    }

    /**
     * System ID 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 1
    )
    public final int targetSystem() {
        return targetSystem;
    }

    /**
     * Camera ID 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 1
    )
    public final int camIdx() {
        return camIdx;
    }

    /**
     * See {@link io.dronefleet.mavlink.ardupilotmega.CameraFeedbackFlags CameraFeedbackFlags} enum for definition of the bitmask 
     */
    @MavlinkFieldInfo(
            position = 13,
            unitSize = 1
    )
    public final CameraFeedbackFlags flags() {
        return flags;
    }

    /**
     * Completed image captures 
     */
    @MavlinkFieldInfo(
            position = 15,
            unitSize = 2,
            extension = true
    )
    public final int completedCaptures() {
        return completedCaptures;
    }

    public static class Builder {
        private BigInteger timeUsec;

        private int lat;

        private int lng;

        private float altMsl;

        private float altRel;

        private float roll;

        private float pitch;

        private float yaw;

        private float focLen;

        private int imgIdx;

        private int targetSystem;

        private int camIdx;

        private CameraFeedbackFlags flags;

        private int completedCaptures;

        private Builder() {
        }

        /**
         * Image timestamp (microseconds since UNIX epoch), as passed in by {@link io.dronefleet.mavlink.ardupilotmega.CameraStatus CameraStatus} message (or 
         * autopilot if no CCB) 
         */
        @MavlinkFieldInfo(
                position = 1,
                unitSize = 8
        )
        public final Builder timeUsec(BigInteger timeUsec) {
            this.timeUsec = timeUsec;
            return this;
        }

        /**
         * Latitude in (deg * 1E7) 
         */
        @MavlinkFieldInfo(
                position = 5,
                unitSize = 4,
                signed = true
        )
        public final Builder lat(int lat) {
            this.lat = lat;
            return this;
        }

        /**
         * Longitude in (deg * 1E7) 
         */
        @MavlinkFieldInfo(
                position = 6,
                unitSize = 4,
                signed = true
        )
        public final Builder lng(int lng) {
            this.lng = lng;
            return this;
        }

        /**
         * Altitude Absolute (meters AMSL) 
         */
        @MavlinkFieldInfo(
                position = 7,
                unitSize = 4
        )
        public final Builder altMsl(float altMsl) {
            this.altMsl = altMsl;
            return this;
        }

        /**
         * Altitude Relative (meters above HOME location) 
         */
        @MavlinkFieldInfo(
                position = 8,
                unitSize = 4
        )
        public final Builder altRel(float altRel) {
            this.altRel = altRel;
            return this;
        }

        /**
         * Camera Roll angle (earth frame, degrees, +-180) 
         */
        @MavlinkFieldInfo(
                position = 9,
                unitSize = 4
        )
        public final Builder roll(float roll) {
            this.roll = roll;
            return this;
        }

        /**
         * Camera Pitch angle (earth frame, degrees, +-180) 
         */
        @MavlinkFieldInfo(
                position = 10,
                unitSize = 4
        )
        public final Builder pitch(float pitch) {
            this.pitch = pitch;
            return this;
        }

        /**
         * Camera Yaw (earth frame, degrees, 0-360, true) 
         */
        @MavlinkFieldInfo(
                position = 11,
                unitSize = 4
        )
        public final Builder yaw(float yaw) {
            this.yaw = yaw;
            return this;
        }

        /**
         * Focal Length (mm) 
         */
        @MavlinkFieldInfo(
                position = 12,
                unitSize = 4
        )
        public final Builder focLen(float focLen) {
            this.focLen = focLen;
            return this;
        }

        /**
         * Image index 
         */
        @MavlinkFieldInfo(
                position = 4,
                unitSize = 2
        )
        public final Builder imgIdx(int imgIdx) {
            this.imgIdx = imgIdx;
            return this;
        }

        /**
         * System ID 
         */
        @MavlinkFieldInfo(
                position = 2,
                unitSize = 1
        )
        public final Builder targetSystem(int targetSystem) {
            this.targetSystem = targetSystem;
            return this;
        }

        /**
         * Camera ID 
         */
        @MavlinkFieldInfo(
                position = 3,
                unitSize = 1
        )
        public final Builder camIdx(int camIdx) {
            this.camIdx = camIdx;
            return this;
        }

        /**
         * See {@link io.dronefleet.mavlink.ardupilotmega.CameraFeedbackFlags CameraFeedbackFlags} enum for definition of the bitmask 
         */
        @MavlinkFieldInfo(
                position = 13,
                unitSize = 1
        )
        public final Builder flags(CameraFeedbackFlags flags) {
            this.flags = flags;
            return this;
        }

        /**
         * Completed image captures 
         */
        @MavlinkFieldInfo(
                position = 15,
                unitSize = 2,
                extension = true
        )
        public final Builder completedCaptures(int completedCaptures) {
            this.completedCaptures = completedCaptures;
            return this;
        }

        public final CameraFeedback build() {
            return new CameraFeedback(timeUsec, lat, lng, altMsl, altRel, roll, pitch, yaw, focLen, imgIdx, targetSystem, camIdx, flags, completedCaptures);
        }
    }
}
