package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;

/**
 * Message that sets video stream settings 
 */
@MavlinkMessageInfo(
        id = 270,
        crc = 253,
        description = "Message that sets video stream settings"
)
public final class SetVideoStreamSettings {
    private final int targetSystem;

    private final int targetComponent;

    private final int cameraId;

    private final float framerate;

    private final int resolutionH;

    private final int resolutionV;

    private final long bitrate;

    private final int rotation;

    private final String uri;

    private SetVideoStreamSettings(int targetSystem, int targetComponent, int cameraId,
            float framerate, int resolutionH, int resolutionV, long bitrate, int rotation,
            String uri) {
        this.targetSystem = targetSystem;
        this.targetComponent = targetComponent;
        this.cameraId = cameraId;
        this.framerate = framerate;
        this.resolutionH = resolutionH;
        this.resolutionV = resolutionV;
        this.bitrate = bitrate;
        this.rotation = rotation;
        this.uri = uri;
    }

    /**
     * Returns a builder instance for this message.
     */
    @MavlinkMessageBuilder
    public static Builder builder() {
        return new Builder();
    }

    /**
     * system ID of the target 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 1,
            description = "system ID of the target"
    )
    public final int targetSystem() {
        return this.targetSystem;
    }

    /**
     * component ID of the target 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 1,
            description = "component ID of the target"
    )
    public final int targetComponent() {
        return this.targetComponent;
    }

    /**
     * Stream ID (1 for first, 2 for second, etc.) 
     */
    @MavlinkFieldInfo(
            position = 4,
            unitSize = 1,
            description = "Stream ID (1 for first, 2 for second, etc.)"
    )
    public final int cameraId() {
        return this.cameraId;
    }

    /**
     * Frame rate (set to -1 for highest framerate possible) 
     */
    @MavlinkFieldInfo(
            position = 5,
            unitSize = 4,
            description = "Frame rate (set to -1 for highest framerate possible)"
    )
    public final float framerate() {
        return this.framerate;
    }

    /**
     * Horizontal resolution (set to -1 for highest resolution possible) 
     */
    @MavlinkFieldInfo(
            position = 6,
            unitSize = 2,
            description = "Horizontal resolution (set to -1 for highest resolution possible)"
    )
    public final int resolutionH() {
        return this.resolutionH;
    }

    /**
     * Vertical resolution (set to -1 for highest resolution possible) 
     */
    @MavlinkFieldInfo(
            position = 7,
            unitSize = 2,
            description = "Vertical resolution (set to -1 for highest resolution possible)"
    )
    public final int resolutionV() {
        return this.resolutionV;
    }

    /**
     * Bit rate (set to -1 for auto) 
     */
    @MavlinkFieldInfo(
            position = 8,
            unitSize = 4,
            description = "Bit rate (set to -1 for auto)"
    )
    public final long bitrate() {
        return this.bitrate;
    }

    /**
     * Video image rotation clockwise (0-359 degrees) 
     */
    @MavlinkFieldInfo(
            position = 9,
            unitSize = 2,
            description = "Video image rotation clockwise (0-359 degrees)"
    )
    public final int rotation() {
        return this.rotation;
    }

    /**
     * Video stream URI (mostly for UDP/RTP) 
     */
    @MavlinkFieldInfo(
            position = 10,
            unitSize = 1,
            arraySize = 160,
            description = "Video stream URI (mostly for UDP/RTP)"
    )
    public final String uri() {
        return this.uri;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !getClass().equals(o.getClass())) return false;
        SetVideoStreamSettings other = (SetVideoStreamSettings)o;
        if (!Objects.deepEquals(targetSystem, other.targetSystem)) return false;
        if (!Objects.deepEquals(targetComponent, other.targetComponent)) return false;
        if (!Objects.deepEquals(cameraId, other.cameraId)) return false;
        if (!Objects.deepEquals(framerate, other.framerate)) return false;
        if (!Objects.deepEquals(resolutionH, other.resolutionH)) return false;
        if (!Objects.deepEquals(resolutionV, other.resolutionV)) return false;
        if (!Objects.deepEquals(bitrate, other.bitrate)) return false;
        if (!Objects.deepEquals(rotation, other.rotation)) return false;
        if (!Objects.deepEquals(uri, other.uri)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + Objects.hashCode(targetSystem);
        result = 31 * result + Objects.hashCode(targetComponent);
        result = 31 * result + Objects.hashCode(cameraId);
        result = 31 * result + Objects.hashCode(framerate);
        result = 31 * result + Objects.hashCode(resolutionH);
        result = 31 * result + Objects.hashCode(resolutionV);
        result = 31 * result + Objects.hashCode(bitrate);
        result = 31 * result + Objects.hashCode(rotation);
        result = 31 * result + Objects.hashCode(uri);
        return result;
    }

    @Override
    public String toString() {
        return "SetVideoStreamSettings{targetSystem=" + targetSystem
                 + ", targetComponent=" + targetComponent
                 + ", cameraId=" + cameraId
                 + ", framerate=" + framerate
                 + ", resolutionH=" + resolutionH
                 + ", resolutionV=" + resolutionV
                 + ", bitrate=" + bitrate
                 + ", rotation=" + rotation
                 + ", uri=" + uri + "}";
    }

    public static final class Builder {
        private int targetSystem;

        private int targetComponent;

        private int cameraId;

        private float framerate;

        private int resolutionH;

        private int resolutionV;

        private long bitrate;

        private int rotation;

        private String uri;

        /**
         * system ID of the target 
         */
        @MavlinkFieldInfo(
                position = 2,
                unitSize = 1,
                description = "system ID of the target"
        )
        public final Builder targetSystem(int targetSystem) {
            this.targetSystem = targetSystem;
            return this;
        }

        /**
         * component ID of the target 
         */
        @MavlinkFieldInfo(
                position = 3,
                unitSize = 1,
                description = "component ID of the target"
        )
        public final Builder targetComponent(int targetComponent) {
            this.targetComponent = targetComponent;
            return this;
        }

        /**
         * Stream ID (1 for first, 2 for second, etc.) 
         */
        @MavlinkFieldInfo(
                position = 4,
                unitSize = 1,
                description = "Stream ID (1 for first, 2 for second, etc.)"
        )
        public final Builder cameraId(int cameraId) {
            this.cameraId = cameraId;
            return this;
        }

        /**
         * Frame rate (set to -1 for highest framerate possible) 
         */
        @MavlinkFieldInfo(
                position = 5,
                unitSize = 4,
                description = "Frame rate (set to -1 for highest framerate possible)"
        )
        public final Builder framerate(float framerate) {
            this.framerate = framerate;
            return this;
        }

        /**
         * Horizontal resolution (set to -1 for highest resolution possible) 
         */
        @MavlinkFieldInfo(
                position = 6,
                unitSize = 2,
                description = "Horizontal resolution (set to -1 for highest resolution possible)"
        )
        public final Builder resolutionH(int resolutionH) {
            this.resolutionH = resolutionH;
            return this;
        }

        /**
         * Vertical resolution (set to -1 for highest resolution possible) 
         */
        @MavlinkFieldInfo(
                position = 7,
                unitSize = 2,
                description = "Vertical resolution (set to -1 for highest resolution possible)"
        )
        public final Builder resolutionV(int resolutionV) {
            this.resolutionV = resolutionV;
            return this;
        }

        /**
         * Bit rate (set to -1 for auto) 
         */
        @MavlinkFieldInfo(
                position = 8,
                unitSize = 4,
                description = "Bit rate (set to -1 for auto)"
        )
        public final Builder bitrate(long bitrate) {
            this.bitrate = bitrate;
            return this;
        }

        /**
         * Video image rotation clockwise (0-359 degrees) 
         */
        @MavlinkFieldInfo(
                position = 9,
                unitSize = 2,
                description = "Video image rotation clockwise (0-359 degrees)"
        )
        public final Builder rotation(int rotation) {
            this.rotation = rotation;
            return this;
        }

        /**
         * Video stream URI (mostly for UDP/RTP) 
         */
        @MavlinkFieldInfo(
                position = 10,
                unitSize = 1,
                arraySize = 160,
                description = "Video stream URI (mostly for UDP/RTP)"
        )
        public final Builder uri(String uri) {
            this.uri = uri;
            return this;
        }

        public final SetVideoStreamSettings build() {
            return new SetVideoStreamSettings(targetSystem, targetComponent, cameraId, framerate, resolutionH, resolutionV, bitrate, rotation, uri);
        }
    }
}
