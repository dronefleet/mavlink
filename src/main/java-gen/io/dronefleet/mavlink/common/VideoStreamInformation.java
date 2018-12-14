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
 * Information about video stream 
 */
@MavlinkMessageInfo(
        id = 269,
        crc = 18,
        description = "Information about video stream"
)
public final class VideoStreamInformation {
    private final int streamId;

    private final int count;

    private final EnumValue<VideoStreamStatusFlags> flags;

    private final float framerate;

    private final int resolutionH;

    private final int resolutionV;

    private final long bitrate;

    private final int rotation;

    private final int hfov;

    private final String uri;

    private VideoStreamInformation(int streamId, int count, EnumValue<VideoStreamStatusFlags> flags,
            float framerate, int resolutionH, int resolutionV, long bitrate, int rotation, int hfov,
            String uri) {
        this.streamId = streamId;
        this.count = count;
        this.flags = flags;
        this.framerate = framerate;
        this.resolutionH = resolutionH;
        this.resolutionV = resolutionV;
        this.bitrate = bitrate;
        this.rotation = rotation;
        this.hfov = hfov;
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
     * Stream ID (1 for first, 2 for second, etc.) 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 1,
            description = "Stream ID (1 for first, 2 for second, etc.)"
    )
    public final int streamId() {
        return this.streamId;
    }

    /**
     * Number of streams available 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 1,
            description = "Number of streams available"
    )
    public final int count() {
        return this.count;
    }

    /**
     * Bitmap of stream status flags 
     */
    @MavlinkFieldInfo(
            position = 4,
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
            position = 5,
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
            position = 6,
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
            position = 7,
            unitSize = 2,
            description = "Vertical resolution"
    )
    public final int resolutionV() {
        return this.resolutionV;
    }

    /**
     * Bit rate in bits per second 
     */
    @MavlinkFieldInfo(
            position = 8,
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
            position = 9,
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
            position = 10,
            unitSize = 2,
            description = "Horizontal Field of view"
    )
    public final int hfov() {
        return this.hfov;
    }

    /**
     * Video stream URI 
     */
    @MavlinkFieldInfo(
            position = 11,
            unitSize = 1,
            arraySize = 160,
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
        if (!Objects.deepEquals(streamId, other.streamId)) return false;
        if (!Objects.deepEquals(count, other.count)) return false;
        if (!Objects.deepEquals(flags, other.flags)) return false;
        if (!Objects.deepEquals(framerate, other.framerate)) return false;
        if (!Objects.deepEquals(resolutionH, other.resolutionH)) return false;
        if (!Objects.deepEquals(resolutionV, other.resolutionV)) return false;
        if (!Objects.deepEquals(bitrate, other.bitrate)) return false;
        if (!Objects.deepEquals(rotation, other.rotation)) return false;
        if (!Objects.deepEquals(hfov, other.hfov)) return false;
        if (!Objects.deepEquals(uri, other.uri)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + Objects.hashCode(streamId);
        result = 31 * result + Objects.hashCode(count);
        result = 31 * result + Objects.hashCode(flags);
        result = 31 * result + Objects.hashCode(framerate);
        result = 31 * result + Objects.hashCode(resolutionH);
        result = 31 * result + Objects.hashCode(resolutionV);
        result = 31 * result + Objects.hashCode(bitrate);
        result = 31 * result + Objects.hashCode(rotation);
        result = 31 * result + Objects.hashCode(hfov);
        result = 31 * result + Objects.hashCode(uri);
        return result;
    }

    @Override
    public String toString() {
        return "VideoStreamInformation{streamId=" + streamId
                 + ", count=" + count
                 + ", flags=" + flags
                 + ", framerate=" + framerate
                 + ", resolutionH=" + resolutionH
                 + ", resolutionV=" + resolutionV
                 + ", bitrate=" + bitrate
                 + ", rotation=" + rotation
                 + ", hfov=" + hfov
                 + ", uri=" + uri + "}";
    }

    public static final class Builder {
        private int streamId;

        private int count;

        private EnumValue<VideoStreamStatusFlags> flags;

        private float framerate;

        private int resolutionH;

        private int resolutionV;

        private long bitrate;

        private int rotation;

        private int hfov;

        private String uri;

        /**
         * Stream ID (1 for first, 2 for second, etc.) 
         */
        @MavlinkFieldInfo(
                position = 2,
                unitSize = 1,
                description = "Stream ID (1 for first, 2 for second, etc.)"
        )
        public final Builder streamId(int streamId) {
            this.streamId = streamId;
            return this;
        }

        /**
         * Number of streams available 
         */
        @MavlinkFieldInfo(
                position = 3,
                unitSize = 1,
                description = "Number of streams available"
        )
        public final Builder count(int count) {
            this.count = count;
            return this;
        }

        /**
         * Bitmap of stream status flags 
         */
        @MavlinkFieldInfo(
                position = 4,
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
                position = 5,
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
                position = 6,
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
                position = 7,
                unitSize = 2,
                description = "Vertical resolution"
        )
        public final Builder resolutionV(int resolutionV) {
            this.resolutionV = resolutionV;
            return this;
        }

        /**
         * Bit rate in bits per second 
         */
        @MavlinkFieldInfo(
                position = 8,
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
                position = 9,
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
                position = 10,
                unitSize = 2,
                description = "Horizontal Field of view"
        )
        public final Builder hfov(int hfov) {
            this.hfov = hfov;
            return this;
        }

        /**
         * Video stream URI 
         */
        @MavlinkFieldInfo(
                position = 11,
                unitSize = 1,
                arraySize = 160,
                description = "Video stream URI"
        )
        public final Builder uri(String uri) {
            this.uri = uri;
            return this;
        }

        public final VideoStreamInformation build() {
            return new VideoStreamInformation(streamId, count, flags, framerate, resolutionH, resolutionV, bitrate, rotation, hfov, uri);
        }
    }
}
