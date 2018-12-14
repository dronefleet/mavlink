package io.dronefleet.mavlink.ardupilotmega;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import io.dronefleet.mavlink.util.EnumValue;
import java.lang.Enum;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.math.BigInteger;
import java.util.Collection;
import java.util.Objects;

/**
 * Camera Capture Feedback. 
 */
@MavlinkMessageInfo(
        id = 180,
        crc = 52,
        description = "Camera Capture Feedback."
)
public final class CameraFeedback {
    private final BigInteger timeUsec;

    private final int targetSystem;

    private final int camIdx;

    private final int imgIdx;

    private final int lat;

    private final int lng;

    private final float altMsl;

    private final float altRel;

    private final float roll;

    private final float pitch;

    private final float yaw;

    private final float focLen;

    private final EnumValue<CameraFeedbackFlags> flags;

    private final int completedCaptures;

    private CameraFeedback(BigInteger timeUsec, int targetSystem, int camIdx, int imgIdx, int lat,
            int lng, float altMsl, float altRel, float roll, float pitch, float yaw, float focLen,
            EnumValue<CameraFeedbackFlags> flags, int completedCaptures) {
        this.timeUsec = timeUsec;
        this.targetSystem = targetSystem;
        this.camIdx = camIdx;
        this.imgIdx = imgIdx;
        this.lat = lat;
        this.lng = lng;
        this.altMsl = altMsl;
        this.altRel = altRel;
        this.roll = roll;
        this.pitch = pitch;
        this.yaw = yaw;
        this.focLen = focLen;
        this.flags = flags;
        this.completedCaptures = completedCaptures;
    }

    /**
     * Returns a builder instance for this message.
     */
    @MavlinkMessageBuilder
    public static Builder builder() {
        return new Builder();
    }

    /**
     * Image timestamp (since UNIX epoch), as passed in by {@link io.dronefleet.mavlink.ardupilotmega.CameraStatus CAMERA_STATUS} message (or autopilot if no 
     * CCB). 
     */
    @MavlinkFieldInfo(
            position = 1,
            unitSize = 8,
            description = "Image timestamp (since UNIX epoch), as passed in by CAMERA_STATUS message (or autopilot if no CCB)."
    )
    public final BigInteger timeUsec() {
        return this.timeUsec;
    }

    /**
     * System ID. 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 1,
            description = "System ID."
    )
    public final int targetSystem() {
        return this.targetSystem;
    }

    /**
     * Camera ID. 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 1,
            description = "Camera ID."
    )
    public final int camIdx() {
        return this.camIdx;
    }

    /**
     * Image index. 
     */
    @MavlinkFieldInfo(
            position = 4,
            unitSize = 2,
            description = "Image index."
    )
    public final int imgIdx() {
        return this.imgIdx;
    }

    /**
     * Latitude. 
     */
    @MavlinkFieldInfo(
            position = 5,
            unitSize = 4,
            signed = true,
            description = "Latitude."
    )
    public final int lat() {
        return this.lat;
    }

    /**
     * Longitude. 
     */
    @MavlinkFieldInfo(
            position = 6,
            unitSize = 4,
            signed = true,
            description = "Longitude."
    )
    public final int lng() {
        return this.lng;
    }

    /**
     * Altitude (MSL). 
     */
    @MavlinkFieldInfo(
            position = 7,
            unitSize = 4,
            description = "Altitude (MSL)."
    )
    public final float altMsl() {
        return this.altMsl;
    }

    /**
     * Altitude (Relative to HOME location). 
     */
    @MavlinkFieldInfo(
            position = 8,
            unitSize = 4,
            description = "Altitude (Relative to HOME location)."
    )
    public final float altRel() {
        return this.altRel;
    }

    /**
     * Camera Roll angle (earth frame, +-180). 
     */
    @MavlinkFieldInfo(
            position = 9,
            unitSize = 4,
            description = "Camera Roll angle (earth frame, +-180)."
    )
    public final float roll() {
        return this.roll;
    }

    /**
     * Camera Pitch angle (earth frame, +-180). 
     */
    @MavlinkFieldInfo(
            position = 10,
            unitSize = 4,
            description = "Camera Pitch angle (earth frame, +-180)."
    )
    public final float pitch() {
        return this.pitch;
    }

    /**
     * Camera Yaw (earth frame, 0-360, true). 
     */
    @MavlinkFieldInfo(
            position = 11,
            unitSize = 4,
            description = "Camera Yaw (earth frame, 0-360, true)."
    )
    public final float yaw() {
        return this.yaw;
    }

    /**
     * Focal Length. 
     */
    @MavlinkFieldInfo(
            position = 12,
            unitSize = 4,
            description = "Focal Length."
    )
    public final float focLen() {
        return this.focLen;
    }

    /**
     * Feedback flags. 
     */
    @MavlinkFieldInfo(
            position = 13,
            unitSize = 1,
            enumType = CameraFeedbackFlags.class,
            description = "Feedback flags."
    )
    public final EnumValue<CameraFeedbackFlags> flags() {
        return this.flags;
    }

    /**
     * Completed image captures. 
     */
    @MavlinkFieldInfo(
            position = 15,
            unitSize = 2,
            extension = true,
            description = "Completed image captures."
    )
    public final int completedCaptures() {
        return this.completedCaptures;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !getClass().equals(o.getClass())) return false;
        CameraFeedback other = (CameraFeedback)o;
        if (!Objects.deepEquals(timeUsec, other.timeUsec)) return false;
        if (!Objects.deepEquals(targetSystem, other.targetSystem)) return false;
        if (!Objects.deepEquals(camIdx, other.camIdx)) return false;
        if (!Objects.deepEquals(imgIdx, other.imgIdx)) return false;
        if (!Objects.deepEquals(lat, other.lat)) return false;
        if (!Objects.deepEquals(lng, other.lng)) return false;
        if (!Objects.deepEquals(altMsl, other.altMsl)) return false;
        if (!Objects.deepEquals(altRel, other.altRel)) return false;
        if (!Objects.deepEquals(roll, other.roll)) return false;
        if (!Objects.deepEquals(pitch, other.pitch)) return false;
        if (!Objects.deepEquals(yaw, other.yaw)) return false;
        if (!Objects.deepEquals(focLen, other.focLen)) return false;
        if (!Objects.deepEquals(flags, other.flags)) return false;
        if (!Objects.deepEquals(completedCaptures, other.completedCaptures)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + Objects.hashCode(timeUsec);
        result = 31 * result + Objects.hashCode(targetSystem);
        result = 31 * result + Objects.hashCode(camIdx);
        result = 31 * result + Objects.hashCode(imgIdx);
        result = 31 * result + Objects.hashCode(lat);
        result = 31 * result + Objects.hashCode(lng);
        result = 31 * result + Objects.hashCode(altMsl);
        result = 31 * result + Objects.hashCode(altRel);
        result = 31 * result + Objects.hashCode(roll);
        result = 31 * result + Objects.hashCode(pitch);
        result = 31 * result + Objects.hashCode(yaw);
        result = 31 * result + Objects.hashCode(focLen);
        result = 31 * result + Objects.hashCode(flags);
        result = 31 * result + Objects.hashCode(completedCaptures);
        return result;
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

    public static final class Builder {
        private BigInteger timeUsec;

        private int targetSystem;

        private int camIdx;

        private int imgIdx;

        private int lat;

        private int lng;

        private float altMsl;

        private float altRel;

        private float roll;

        private float pitch;

        private float yaw;

        private float focLen;

        private EnumValue<CameraFeedbackFlags> flags;

        private int completedCaptures;

        /**
         * Image timestamp (since UNIX epoch), as passed in by {@link io.dronefleet.mavlink.ardupilotmega.CameraStatus CAMERA_STATUS} message (or autopilot if no 
         * CCB). 
         */
        @MavlinkFieldInfo(
                position = 1,
                unitSize = 8,
                description = "Image timestamp (since UNIX epoch), as passed in by CAMERA_STATUS message (or autopilot if no CCB)."
        )
        public final Builder timeUsec(BigInteger timeUsec) {
            this.timeUsec = timeUsec;
            return this;
        }

        /**
         * System ID. 
         */
        @MavlinkFieldInfo(
                position = 2,
                unitSize = 1,
                description = "System ID."
        )
        public final Builder targetSystem(int targetSystem) {
            this.targetSystem = targetSystem;
            return this;
        }

        /**
         * Camera ID. 
         */
        @MavlinkFieldInfo(
                position = 3,
                unitSize = 1,
                description = "Camera ID."
        )
        public final Builder camIdx(int camIdx) {
            this.camIdx = camIdx;
            return this;
        }

        /**
         * Image index. 
         */
        @MavlinkFieldInfo(
                position = 4,
                unitSize = 2,
                description = "Image index."
        )
        public final Builder imgIdx(int imgIdx) {
            this.imgIdx = imgIdx;
            return this;
        }

        /**
         * Latitude. 
         */
        @MavlinkFieldInfo(
                position = 5,
                unitSize = 4,
                signed = true,
                description = "Latitude."
        )
        public final Builder lat(int lat) {
            this.lat = lat;
            return this;
        }

        /**
         * Longitude. 
         */
        @MavlinkFieldInfo(
                position = 6,
                unitSize = 4,
                signed = true,
                description = "Longitude."
        )
        public final Builder lng(int lng) {
            this.lng = lng;
            return this;
        }

        /**
         * Altitude (MSL). 
         */
        @MavlinkFieldInfo(
                position = 7,
                unitSize = 4,
                description = "Altitude (MSL)."
        )
        public final Builder altMsl(float altMsl) {
            this.altMsl = altMsl;
            return this;
        }

        /**
         * Altitude (Relative to HOME location). 
         */
        @MavlinkFieldInfo(
                position = 8,
                unitSize = 4,
                description = "Altitude (Relative to HOME location)."
        )
        public final Builder altRel(float altRel) {
            this.altRel = altRel;
            return this;
        }

        /**
         * Camera Roll angle (earth frame, +-180). 
         */
        @MavlinkFieldInfo(
                position = 9,
                unitSize = 4,
                description = "Camera Roll angle (earth frame, +-180)."
        )
        public final Builder roll(float roll) {
            this.roll = roll;
            return this;
        }

        /**
         * Camera Pitch angle (earth frame, +-180). 
         */
        @MavlinkFieldInfo(
                position = 10,
                unitSize = 4,
                description = "Camera Pitch angle (earth frame, +-180)."
        )
        public final Builder pitch(float pitch) {
            this.pitch = pitch;
            return this;
        }

        /**
         * Camera Yaw (earth frame, 0-360, true). 
         */
        @MavlinkFieldInfo(
                position = 11,
                unitSize = 4,
                description = "Camera Yaw (earth frame, 0-360, true)."
        )
        public final Builder yaw(float yaw) {
            this.yaw = yaw;
            return this;
        }

        /**
         * Focal Length. 
         */
        @MavlinkFieldInfo(
                position = 12,
                unitSize = 4,
                description = "Focal Length."
        )
        public final Builder focLen(float focLen) {
            this.focLen = focLen;
            return this;
        }

        /**
         * Feedback flags. 
         */
        @MavlinkFieldInfo(
                position = 13,
                unitSize = 1,
                enumType = CameraFeedbackFlags.class,
                description = "Feedback flags."
        )
        public final Builder flags(EnumValue<CameraFeedbackFlags> flags) {
            this.flags = flags;
            return this;
        }

        /**
         * Feedback flags. 
         */
        public final Builder flags(CameraFeedbackFlags entry) {
            return flags(EnumValue.of(entry));
        }

        /**
         * Feedback flags. 
         */
        public final Builder flags(Enum... flags) {
            return flags(EnumValue.create(flags));
        }

        /**
         * Feedback flags. 
         */
        public final Builder flags(Collection<Enum> flags) {
            return flags(EnumValue.create(flags));
        }

        /**
         * Completed image captures. 
         */
        @MavlinkFieldInfo(
                position = 15,
                unitSize = 2,
                extension = true,
                description = "Completed image captures."
        )
        public final Builder completedCaptures(int completedCaptures) {
            this.completedCaptures = completedCaptures;
            return this;
        }

        public final CameraFeedback build() {
            return new CameraFeedback(timeUsec, targetSystem, camIdx, imgIdx, lat, lng, altMsl, altRel, roll, pitch, yaw, focLen, flags, completedCaptures);
        }
    }
}
