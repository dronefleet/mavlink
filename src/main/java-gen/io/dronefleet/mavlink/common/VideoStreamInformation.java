package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;

/**
 * WIP: Information about video stream 
 */
@MavlinkMessageInfo(
        id = 269,
        crc = 58,
        description = "WIP: Information about video stream"
)
public final class VideoStreamInformation {
    private final int cameraId;

    private final int status;

    private final float framerate;

    private final int resolutionH;

    private final int resolutionV;

    private final long bitrate;

    private final int rotation;

    private final String uri;

    private VideoStreamInformation(int cameraId, int status, float framerate, int resolutionH,
            int resolutionV, long bitrate, int rotation, String uri) {
        this.cameraId = cameraId;
        this.status = status;
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
     * Camera ID (1 for first, 2 for second, etc.) 
     */
    @MavlinkFieldInfo(
            position = 1,
            unitSize = 1,
            description = "Camera ID (1 for first, 2 for second, etc.)"
    )
    public final int cameraId() {
        return this.cameraId;
    }

    /**
     * Current status of video streaming (0: not running, 1: in progress) 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 1,
            description = "Current status of video streaming (0: not running, 1: in progress)"
    )
    public final int status() {
        return this.status;
    }

    /**
     * Frames per second 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 4,
            description = "Frames per second"
    )
    public final float framerate() {
        return this.framerate;
    }

    /**
     * Resolution horizontal in pixels 
     */
    @MavlinkFieldInfo(
            position = 4,
            unitSize = 2,
            description = "Resolution horizontal in pixels"
    )
    public final int resolutionH() {
        return this.resolutionH;
    }

    /**
     * Resolution vertical in pixels 
     */
    @MavlinkFieldInfo(
            position = 5,
            unitSize = 2,
            description = "Resolution vertical in pixels"
    )
    public final int resolutionV() {
        return this.resolutionV;
    }

    /**
     * Bit rate in bits per second 
     */
    @MavlinkFieldInfo(
            position = 6,
            unitSize = 4,
            description = "Bit rate in bits per second"
    )
    public final long bitrate() {
        return this.bitrate;
    }

    /**
     * Video image rotation clockwise 
     */
    @MavlinkFieldInfo(
            position = 7,
            unitSize = 2,
            description = "Video image rotation clockwise"
    )
    public final int rotation() {
        return this.rotation;
    }

    /**
     * Video stream URI 
     */
    @MavlinkFieldInfo(
            position = 8,
            unitSize = 1,
            arraySize = 230,
            description = "Video stream URI"
    )
    public final String uri() {
        return this.uri;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !getClass().equals(o.getClass())) return false;
        VideoStreamInformation other = (VideoStreamInformation)o;
        if (!Objects.deepEquals(cameraId, other.cameraId)) return false;
        if (!Objects.deepEquals(status, other.status)) return false;
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
        result = 31 * result + Objects.hashCode(cameraId);
        result = 31 * result + Objects.hashCode(status);
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
        return "VideoStreamInformation{cameraId=" + cameraId
                 + ", status=" + status
                 + ", framerate=" + framerate
                 + ", resolutionH=" + resolutionH
                 + ", resolutionV=" + resolutionV
                 + ", bitrate=" + bitrate
                 + ", rotation=" + rotation
                 + ", uri=" + uri + "}";
    }

    public static final class Builder {
        private int cameraId;

        private int status;

        private float framerate;

        private int resolutionH;

        private int resolutionV;

        private long bitrate;

        private int rotation;

        private String uri;

        /**
         * Camera ID (1 for first, 2 for second, etc.) 
         */
        @MavlinkFieldInfo(
                position = 1,
                unitSize = 1,
                description = "Camera ID (1 for first, 2 for second, etc.)"
        )
        public final Builder cameraId(int cameraId) {
            this.cameraId = cameraId;
            return this;
        }

        /**
         * Current status of video streaming (0: not running, 1: in progress) 
         */
        @MavlinkFieldInfo(
                position = 2,
                unitSize = 1,
                description = "Current status of video streaming (0: not running, 1: in progress)"
        )
        public final Builder status(int status) {
            this.status = status;
            return this;
        }

        /**
         * Frames per second 
         */
        @MavlinkFieldInfo(
                position = 3,
                unitSize = 4,
                description = "Frames per second"
        )
        public final Builder framerate(float framerate) {
            this.framerate = framerate;
            return this;
        }

        /**
         * Resolution horizontal in pixels 
         */
        @MavlinkFieldInfo(
                position = 4,
                unitSize = 2,
                description = "Resolution horizontal in pixels"
        )
        public final Builder resolutionH(int resolutionH) {
            this.resolutionH = resolutionH;
            return this;
        }

        /**
         * Resolution vertical in pixels 
         */
        @MavlinkFieldInfo(
                position = 5,
                unitSize = 2,
                description = "Resolution vertical in pixels"
        )
        public final Builder resolutionV(int resolutionV) {
            this.resolutionV = resolutionV;
            return this;
        }

        /**
         * Bit rate in bits per second 
         */
        @MavlinkFieldInfo(
                position = 6,
                unitSize = 4,
                description = "Bit rate in bits per second"
        )
        public final Builder bitrate(long bitrate) {
            this.bitrate = bitrate;
            return this;
        }

        /**
         * Video image rotation clockwise 
         */
        @MavlinkFieldInfo(
                position = 7,
                unitSize = 2,
                description = "Video image rotation clockwise"
        )
        public final Builder rotation(int rotation) {
            this.rotation = rotation;
            return this;
        }

        /**
         * Video stream URI 
         */
        @MavlinkFieldInfo(
                position = 8,
                unitSize = 1,
                arraySize = 230,
                description = "Video stream URI"
        )
        public final Builder uri(String uri) {
            this.uri = uri;
            return this;
        }

        public final VideoStreamInformation build() {
            return new VideoStreamInformation(cameraId, status, framerate, resolutionH, resolutionV, bitrate, rotation, uri);
        }
    }
}
