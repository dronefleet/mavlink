package io.dronefleet.mavlink.cubepilot;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;

/**
 * Information about video stream 
 */
@MavlinkMessageInfo(
        id = 50002,
        crc = 181,
        description = "Information about video stream"
)
public final class HerelinkVideoStreamInformation {
    private final int cameraId;

    private final int status;

    private final float framerate;

    private final int resolutionH;

    private final int resolutionV;

    private final long bitrate;

    private final int rotation;

    private final String uri;

    private HerelinkVideoStreamInformation(int cameraId, int status, float framerate,
            int resolutionH, int resolutionV, long bitrate, int rotation, String uri) {
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
     * Video Stream ID (1 for first, 2 for second, etc.) 
     */
    @MavlinkFieldInfo(
            position = 1,
            unitSize = 1,
            description = "Video Stream ID (1 for first, 2 for second, etc.)"
    )
    public final int cameraId() {
        return this.cameraId;
    }

    /**
     * Number of streams available. 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 1,
            description = "Number of streams available."
    )
    public final int status() {
        return this.status;
    }

    /**
     * Frame rate. 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 4,
            description = "Frame rate."
    )
    public final float framerate() {
        return this.framerate;
    }

    /**
     * Horizontal resolution. 
     */
    @MavlinkFieldInfo(
            position = 4,
            unitSize = 2,
            description = "Horizontal resolution."
    )
    public final int resolutionH() {
        return this.resolutionH;
    }

    /**
     * Vertical resolution. 
     */
    @MavlinkFieldInfo(
            position = 5,
            unitSize = 2,
            description = "Vertical resolution."
    )
    public final int resolutionV() {
        return this.resolutionV;
    }

    /**
     * Bit rate. 
     */
    @MavlinkFieldInfo(
            position = 6,
            unitSize = 4,
            description = "Bit rate."
    )
    public final long bitrate() {
        return this.bitrate;
    }

    /**
     * Video image rotation clockwise. 
     */
    @MavlinkFieldInfo(
            position = 7,
            unitSize = 2,
            description = "Video image rotation clockwise."
    )
    public final int rotation() {
        return this.rotation;
    }

    /**
     * Video stream URI (TCP or RTSP URI ground station should connect to) or port number (UDP port 
     * ground station should listen to). 
     */
    @MavlinkFieldInfo(
            position = 8,
            unitSize = 1,
            arraySize = 230,
            description = "Video stream URI (TCP or RTSP URI ground station should connect to) or port number (UDP port ground station should listen to)."
    )
    public final String uri() {
        return this.uri;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !getClass().equals(o.getClass())) return false;
        HerelinkVideoStreamInformation other = (HerelinkVideoStreamInformation)o;
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
        return "HerelinkVideoStreamInformation{cameraId=" + cameraId
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
         * Video Stream ID (1 for first, 2 for second, etc.) 
         */
        @MavlinkFieldInfo(
                position = 1,
                unitSize = 1,
                description = "Video Stream ID (1 for first, 2 for second, etc.)"
        )
        public final Builder cameraId(int cameraId) {
            this.cameraId = cameraId;
            return this;
        }

        /**
         * Number of streams available. 
         */
        @MavlinkFieldInfo(
                position = 2,
                unitSize = 1,
                description = "Number of streams available."
        )
        public final Builder status(int status) {
            this.status = status;
            return this;
        }

        /**
         * Frame rate. 
         */
        @MavlinkFieldInfo(
                position = 3,
                unitSize = 4,
                description = "Frame rate."
        )
        public final Builder framerate(float framerate) {
            this.framerate = framerate;
            return this;
        }

        /**
         * Horizontal resolution. 
         */
        @MavlinkFieldInfo(
                position = 4,
                unitSize = 2,
                description = "Horizontal resolution."
        )
        public final Builder resolutionH(int resolutionH) {
            this.resolutionH = resolutionH;
            return this;
        }

        /**
         * Vertical resolution. 
         */
        @MavlinkFieldInfo(
                position = 5,
                unitSize = 2,
                description = "Vertical resolution."
        )
        public final Builder resolutionV(int resolutionV) {
            this.resolutionV = resolutionV;
            return this;
        }

        /**
         * Bit rate. 
         */
        @MavlinkFieldInfo(
                position = 6,
                unitSize = 4,
                description = "Bit rate."
        )
        public final Builder bitrate(long bitrate) {
            this.bitrate = bitrate;
            return this;
        }

        /**
         * Video image rotation clockwise. 
         */
        @MavlinkFieldInfo(
                position = 7,
                unitSize = 2,
                description = "Video image rotation clockwise."
        )
        public final Builder rotation(int rotation) {
            this.rotation = rotation;
            return this;
        }

        /**
         * Video stream URI (TCP or RTSP URI ground station should connect to) or port number (UDP port 
         * ground station should listen to). 
         */
        @MavlinkFieldInfo(
                position = 8,
                unitSize = 1,
                arraySize = 230,
                description = "Video stream URI (TCP or RTSP URI ground station should connect to) or port number (UDP port ground station should listen to)."
        )
        public final Builder uri(String uri) {
            this.uri = uri;
            return this;
        }

        public final HerelinkVideoStreamInformation build() {
            return new HerelinkVideoStreamInformation(cameraId, status, framerate, resolutionH, resolutionV, bitrate, rotation, uri);
        }
    }
}
