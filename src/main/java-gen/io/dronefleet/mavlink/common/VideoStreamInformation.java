package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import java.lang.Override;
import java.lang.String;

/**
 * WIP: Information about video stream 
 */
@MavlinkMessageInfo(
        id = 269,
        crc = 58
)
public final class VideoStreamInformation {
    /**
     * Frames per second 
     */
    private final float framerate;

    /**
     * Bit rate in bits per second 
     */
    private final long bitrate;

    /**
     * Resolution horizontal in pixels 
     */
    private final int resolutionH;

    /**
     * Resolution vertical in pixels 
     */
    private final int resolutionV;

    /**
     * Video image rotation clockwise 
     */
    private final int rotation;

    /**
     * Camera ID (1 for first, 2 for second, etc.) 
     */
    private final int cameraId;

    /**
     * Current status of video streaming (0: not running, 1: in progress) 
     */
    private final int status;

    /**
     * Video stream URI 
     */
    private final String uri;

    private VideoStreamInformation(float framerate, long bitrate, int resolutionH, int resolutionV,
            int rotation, int cameraId, int status, String uri) {
        this.framerate = framerate;
        this.bitrate = bitrate;
        this.resolutionH = resolutionH;
        this.resolutionV = resolutionV;
        this.rotation = rotation;
        this.cameraId = cameraId;
        this.status = status;
        this.uri = uri;
    }

    @MavlinkMessageBuilder
    public static Builder builder() {
        return new Builder();
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

    /**
     * Frames per second 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 4
    )
    public final float framerate() {
        return framerate;
    }

    /**
     * Bit rate in bits per second 
     */
    @MavlinkFieldInfo(
            position = 6,
            unitSize = 4
    )
    public final long bitrate() {
        return bitrate;
    }

    /**
     * Resolution horizontal in pixels 
     */
    @MavlinkFieldInfo(
            position = 4,
            unitSize = 2
    )
    public final int resolutionH() {
        return resolutionH;
    }

    /**
     * Resolution vertical in pixels 
     */
    @MavlinkFieldInfo(
            position = 5,
            unitSize = 2
    )
    public final int resolutionV() {
        return resolutionV;
    }

    /**
     * Video image rotation clockwise 
     */
    @MavlinkFieldInfo(
            position = 7,
            unitSize = 2
    )
    public final int rotation() {
        return rotation;
    }

    /**
     * Camera ID (1 for first, 2 for second, etc.) 
     */
    @MavlinkFieldInfo(
            position = 1,
            unitSize = 1
    )
    public final int cameraId() {
        return cameraId;
    }

    /**
     * Current status of video streaming (0: not running, 1: in progress) 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 1
    )
    public final int status() {
        return status;
    }

    /**
     * Video stream URI 
     */
    @MavlinkFieldInfo(
            position = 8,
            unitSize = 1,
            arraySize = 230
    )
    public final String uri() {
        return uri;
    }

    public static class Builder {
        private float framerate;

        private long bitrate;

        private int resolutionH;

        private int resolutionV;

        private int rotation;

        private int cameraId;

        private int status;

        private String uri;

        private Builder() {
        }

        /**
         * Frames per second 
         */
        @MavlinkFieldInfo(
                position = 3,
                unitSize = 4
        )
        public final Builder framerate(float framerate) {
            this.framerate = framerate;
            return this;
        }

        /**
         * Bit rate in bits per second 
         */
        @MavlinkFieldInfo(
                position = 6,
                unitSize = 4
        )
        public final Builder bitrate(long bitrate) {
            this.bitrate = bitrate;
            return this;
        }

        /**
         * Resolution horizontal in pixels 
         */
        @MavlinkFieldInfo(
                position = 4,
                unitSize = 2
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
                unitSize = 2
        )
        public final Builder resolutionV(int resolutionV) {
            this.resolutionV = resolutionV;
            return this;
        }

        /**
         * Video image rotation clockwise 
         */
        @MavlinkFieldInfo(
                position = 7,
                unitSize = 2
        )
        public final Builder rotation(int rotation) {
            this.rotation = rotation;
            return this;
        }

        /**
         * Camera ID (1 for first, 2 for second, etc.) 
         */
        @MavlinkFieldInfo(
                position = 1,
                unitSize = 1
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
                unitSize = 1
        )
        public final Builder status(int status) {
            this.status = status;
            return this;
        }

        /**
         * Video stream URI 
         */
        @MavlinkFieldInfo(
                position = 8,
                unitSize = 1,
                arraySize = 230
        )
        public final Builder uri(String uri) {
            this.uri = uri;
            return this;
        }

        public final VideoStreamInformation build() {
            return new VideoStreamInformation(framerate, bitrate, resolutionH, resolutionV, rotation, cameraId, status, uri);
        }
    }
}
