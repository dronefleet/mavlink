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
 * Information about the status of a video stream. It may be requested using 
 * MAV_CMD_REQUEST_MESSAGE. 
 */
@MavlinkMessageInfo(
        id = 270,
        crc = 59,
        description = "Information about the status of a video stream. It may be requested using MAV_CMD_REQUEST_MESSAGE."
)
public final class VideoStreamStatus {
    private final int streamId;

    private final EnumValue<VideoStreamStatusFlags> flags;

    private final float framerate;

    private final int resolutionH;

    private final int resolutionV;

    private final long bitrate;

    private final int rotation;

    private final int hfov;

    private VideoStreamStatus(int streamId, EnumValue<VideoStreamStatusFlags> flags,
            float framerate, int resolutionH, int resolutionV, long bitrate, int rotation,
            int hfov) {
        this.streamId = streamId;
        this.flags = flags;
        this.framerate = framerate;
        this.resolutionH = resolutionH;
        this.resolutionV = resolutionV;
        this.bitrate = bitrate;
        this.rotation = rotation;
        this.hfov = hfov;
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
    public final int streamId() {
        return this.streamId;
    }

    /**
     * Bitmap of stream status flags 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 2,
            enumType = VideoStreamStatusFlags.class,
            description = "Bitmap of stream status flags"
    )
    public final EnumValue<VideoStreamStatusFlags> flags() {
        return this.flags;
    }

    /**
     * Frame rate 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 4,
            description = "Frame rate"
    )
    public final float framerate() {
        return this.framerate;
    }

    /**
     * Horizontal resolution 
     */
    @MavlinkFieldInfo(
            position = 4,
            unitSize = 2,
            description = "Horizontal resolution"
    )
    public final int resolutionH() {
        return this.resolutionH;
    }

    /**
     * Vertical resolution 
     */
    @MavlinkFieldInfo(
            position = 5,
            unitSize = 2,
            description = "Vertical resolution"
    )
    public final int resolutionV() {
        return this.resolutionV;
    }

    /**
     * Bit rate 
     */
    @MavlinkFieldInfo(
            position = 6,
            unitSize = 4,
            description = "Bit rate"
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
     * Horizontal Field of view 
     */
    @MavlinkFieldInfo(
            position = 8,
            unitSize = 2,
            description = "Horizontal Field of view"
    )
    public final int hfov() {
        return this.hfov;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !getClass().equals(o.getClass())) return false;
        VideoStreamStatus other = (VideoStreamStatus)o;
        if (!Objects.deepEquals(streamId, other.streamId)) return false;
        if (!Objects.deepEquals(flags, other.flags)) return false;
        if (!Objects.deepEquals(framerate, other.framerate)) return false;
        if (!Objects.deepEquals(resolutionH, other.resolutionH)) return false;
        if (!Objects.deepEquals(resolutionV, other.resolutionV)) return false;
        if (!Objects.deepEquals(bitrate, other.bitrate)) return false;
        if (!Objects.deepEquals(rotation, other.rotation)) return false;
        if (!Objects.deepEquals(hfov, other.hfov)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + Objects.hashCode(streamId);
        result = 31 * result + Objects.hashCode(flags);
        result = 31 * result + Objects.hashCode(framerate);
        result = 31 * result + Objects.hashCode(resolutionH);
        result = 31 * result + Objects.hashCode(resolutionV);
        result = 31 * result + Objects.hashCode(bitrate);
        result = 31 * result + Objects.hashCode(rotation);
        result = 31 * result + Objects.hashCode(hfov);
        return result;
    }

    @Override
    public String toString() {
        return "VideoStreamStatus{streamId=" + streamId
                 + ", flags=" + flags
                 + ", framerate=" + framerate
                 + ", resolutionH=" + resolutionH
                 + ", resolutionV=" + resolutionV
                 + ", bitrate=" + bitrate
                 + ", rotation=" + rotation
                 + ", hfov=" + hfov + "}";
    }

    public static final class Builder {
        private int streamId;

        private EnumValue<VideoStreamStatusFlags> flags;

        private float framerate;

        private int resolutionH;

        private int resolutionV;

        private long bitrate;

        private int rotation;

        private int hfov;

        /**
         * Video Stream ID (1 for first, 2 for second, etc.) 
         */
        @MavlinkFieldInfo(
                position = 1,
                unitSize = 1,
                description = "Video Stream ID (1 for first, 2 for second, etc.)"
        )
        public final Builder streamId(int streamId) {
            this.streamId = streamId;
            return this;
        }

        /**
         * Bitmap of stream status flags 
         */
        @MavlinkFieldInfo(
                position = 2,
                unitSize = 2,
                enumType = VideoStreamStatusFlags.class,
                description = "Bitmap of stream status flags"
        )
        public final Builder flags(EnumValue<VideoStreamStatusFlags> flags) {
            this.flags = flags;
            return this;
        }

        /**
         * Bitmap of stream status flags 
         */
        public final Builder flags(VideoStreamStatusFlags entry) {
            return flags(EnumValue.of(entry));
        }

        /**
         * Bitmap of stream status flags 
         */
        public final Builder flags(Enum... flags) {
            return flags(EnumValue.create(flags));
        }

        /**
         * Bitmap of stream status flags 
         */
        public final Builder flags(Collection<Enum> flags) {
            return flags(EnumValue.create(flags));
        }

        /**
         * Frame rate 
         */
        @MavlinkFieldInfo(
                position = 3,
                unitSize = 4,
                description = "Frame rate"
        )
        public final Builder framerate(float framerate) {
            this.framerate = framerate;
            return this;
        }

        /**
         * Horizontal resolution 
         */
        @MavlinkFieldInfo(
                position = 4,
                unitSize = 2,
                description = "Horizontal resolution"
        )
        public final Builder resolutionH(int resolutionH) {
            this.resolutionH = resolutionH;
            return this;
        }

        /**
         * Vertical resolution 
         */
        @MavlinkFieldInfo(
                position = 5,
                unitSize = 2,
                description = "Vertical resolution"
        )
        public final Builder resolutionV(int resolutionV) {
            this.resolutionV = resolutionV;
            return this;
        }

        /**
         * Bit rate 
         */
        @MavlinkFieldInfo(
                position = 6,
                unitSize = 4,
                description = "Bit rate"
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
         * Horizontal Field of view 
         */
        @MavlinkFieldInfo(
                position = 8,
                unitSize = 2,
                description = "Horizontal Field of view"
        )
        public final Builder hfov(int hfov) {
            this.hfov = hfov;
            return this;
        }

        public final VideoStreamStatus build() {
            return new VideoStreamStatus(streamId, flags, framerate, resolutionH, resolutionV, bitrate, rotation, hfov);
        }
    }
}
