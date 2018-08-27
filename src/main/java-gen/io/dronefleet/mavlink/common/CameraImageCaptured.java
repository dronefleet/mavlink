package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import java.lang.Float;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.math.BigInteger;
import java.util.List;
import java.util.Objects;

/**
 * Information about a captured image 
 */
@MavlinkMessageInfo(
        id = 263,
        crc = 133
)
public final class CameraImageCaptured {
    private final long timeBootMs;

    private final BigInteger timeUtc;

    private final int cameraId;

    private final int lat;

    private final int lon;

    private final int alt;

    private final int relativeAlt;

    private final List<Float> q;

    private final int imageIndex;

    private final int captureResult;

    private final String fileUrl;

    private CameraImageCaptured(long timeBootMs, BigInteger timeUtc, int cameraId, int lat, int lon,
            int alt, int relativeAlt, List<Float> q, int imageIndex, int captureResult,
            String fileUrl) {
        this.timeBootMs = timeBootMs;
        this.timeUtc = timeUtc;
        this.cameraId = cameraId;
        this.lat = lat;
        this.lon = lon;
        this.alt = alt;
        this.relativeAlt = relativeAlt;
        this.q = q;
        this.imageIndex = imageIndex;
        this.captureResult = captureResult;
        this.fileUrl = fileUrl;
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
     * Timestamp (microseconds since UNIX epoch) in UTC. 0 for unknown. 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 8
    )
    public final BigInteger timeUtc() {
        return this.timeUtc;
    }

    /**
     * Camera ID (1 for first, 2 for second, etc.) 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 1
    )
    public final int cameraId() {
        return this.cameraId;
    }

    /**
     * Latitude, expressed as degrees * 1E7 where image was taken 
     */
    @MavlinkFieldInfo(
            position = 4,
            unitSize = 4,
            signed = true
    )
    public final int lat() {
        return this.lat;
    }

    /**
     * Longitude, expressed as degrees * 1E7 where capture was taken 
     */
    @MavlinkFieldInfo(
            position = 5,
            unitSize = 4,
            signed = true
    )
    public final int lon() {
        return this.lon;
    }

    /**
     * Altitude in meters, expressed as * 1E3 (AMSL, not WGS84) where image was taken 
     */
    @MavlinkFieldInfo(
            position = 6,
            unitSize = 4,
            signed = true
    )
    public final int alt() {
        return this.alt;
    }

    /**
     * Altitude above ground in meters, expressed as * 1E3 where image was taken 
     */
    @MavlinkFieldInfo(
            position = 7,
            unitSize = 4,
            signed = true
    )
    public final int relativeAlt() {
        return this.relativeAlt;
    }

    /**
     * Quaternion of camera orientation (w, x, y, z order, zero-rotation is 0, 0, 0, 0) 
     */
    @MavlinkFieldInfo(
            position = 8,
            unitSize = 4,
            arraySize = 4
    )
    public final List<Float> q() {
        return this.q;
    }

    /**
     * Zero based index of this image (image count since armed -1) 
     */
    @MavlinkFieldInfo(
            position = 9,
            unitSize = 4,
            signed = true
    )
    public final int imageIndex() {
        return this.imageIndex;
    }

    /**
     * Boolean indicating success (1) or failure (0) while capturing this image. 
     */
    @MavlinkFieldInfo(
            position = 10,
            unitSize = 1,
            signed = true
    )
    public final int captureResult() {
        return this.captureResult;
    }

    /**
     * URL of image taken. Either local storage or http://foo.jpg if camera provides an HTTP 
     * interface. 
     */
    @MavlinkFieldInfo(
            position = 11,
            unitSize = 1,
            arraySize = 205
    )
    public final String fileUrl() {
        return this.fileUrl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !getClass().equals(o.getClass())) return false;
        CameraImageCaptured other = (CameraImageCaptured)o;
        if (!Objects.deepEquals(timeBootMs, other.timeBootMs)) return false;
        if (!Objects.deepEquals(timeUtc, other.timeUtc)) return false;
        if (!Objects.deepEquals(cameraId, other.cameraId)) return false;
        if (!Objects.deepEquals(lat, other.lat)) return false;
        if (!Objects.deepEquals(lon, other.lon)) return false;
        if (!Objects.deepEquals(alt, other.alt)) return false;
        if (!Objects.deepEquals(relativeAlt, other.relativeAlt)) return false;
        if (!Objects.deepEquals(q, other.q)) return false;
        if (!Objects.deepEquals(imageIndex, other.imageIndex)) return false;
        if (!Objects.deepEquals(captureResult, other.captureResult)) return false;
        if (!Objects.deepEquals(fileUrl, other.fileUrl)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + Objects.hashCode(timeBootMs);
        result = 31 * result + Objects.hashCode(timeUtc);
        result = 31 * result + Objects.hashCode(cameraId);
        result = 31 * result + Objects.hashCode(lat);
        result = 31 * result + Objects.hashCode(lon);
        result = 31 * result + Objects.hashCode(alt);
        result = 31 * result + Objects.hashCode(relativeAlt);
        result = 31 * result + Objects.hashCode(q);
        result = 31 * result + Objects.hashCode(imageIndex);
        result = 31 * result + Objects.hashCode(captureResult);
        result = 31 * result + Objects.hashCode(fileUrl);
        return result;
    }

    @Override
    public String toString() {
        return "CameraImageCaptured{timeBootMs=" + timeBootMs
                 + ", timeUtc=" + timeUtc
                 + ", cameraId=" + cameraId
                 + ", lat=" + lat
                 + ", lon=" + lon
                 + ", alt=" + alt
                 + ", relativeAlt=" + relativeAlt
                 + ", q=" + q
                 + ", imageIndex=" + imageIndex
                 + ", captureResult=" + captureResult
                 + ", fileUrl=" + fileUrl + "}";
    }

    public static final class Builder {
        private long timeBootMs;

        private BigInteger timeUtc;

        private int cameraId;

        private int lat;

        private int lon;

        private int alt;

        private int relativeAlt;

        private List<Float> q;

        private int imageIndex;

        private int captureResult;

        private String fileUrl;

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
         * Timestamp (microseconds since UNIX epoch) in UTC. 0 for unknown. 
         */
        @MavlinkFieldInfo(
                position = 2,
                unitSize = 8
        )
        public final Builder timeUtc(BigInteger timeUtc) {
            this.timeUtc = timeUtc;
            return this;
        }

        /**
         * Camera ID (1 for first, 2 for second, etc.) 
         */
        @MavlinkFieldInfo(
                position = 3,
                unitSize = 1
        )
        public final Builder cameraId(int cameraId) {
            this.cameraId = cameraId;
            return this;
        }

        /**
         * Latitude, expressed as degrees * 1E7 where image was taken 
         */
        @MavlinkFieldInfo(
                position = 4,
                unitSize = 4,
                signed = true
        )
        public final Builder lat(int lat) {
            this.lat = lat;
            return this;
        }

        /**
         * Longitude, expressed as degrees * 1E7 where capture was taken 
         */
        @MavlinkFieldInfo(
                position = 5,
                unitSize = 4,
                signed = true
        )
        public final Builder lon(int lon) {
            this.lon = lon;
            return this;
        }

        /**
         * Altitude in meters, expressed as * 1E3 (AMSL, not WGS84) where image was taken 
         */
        @MavlinkFieldInfo(
                position = 6,
                unitSize = 4,
                signed = true
        )
        public final Builder alt(int alt) {
            this.alt = alt;
            return this;
        }

        /**
         * Altitude above ground in meters, expressed as * 1E3 where image was taken 
         */
        @MavlinkFieldInfo(
                position = 7,
                unitSize = 4,
                signed = true
        )
        public final Builder relativeAlt(int relativeAlt) {
            this.relativeAlt = relativeAlt;
            return this;
        }

        /**
         * Quaternion of camera orientation (w, x, y, z order, zero-rotation is 0, 0, 0, 0) 
         */
        @MavlinkFieldInfo(
                position = 8,
                unitSize = 4,
                arraySize = 4
        )
        public final Builder q(List<Float> q) {
            this.q = q;
            return this;
        }

        /**
         * Zero based index of this image (image count since armed -1) 
         */
        @MavlinkFieldInfo(
                position = 9,
                unitSize = 4,
                signed = true
        )
        public final Builder imageIndex(int imageIndex) {
            this.imageIndex = imageIndex;
            return this;
        }

        /**
         * Boolean indicating success (1) or failure (0) while capturing this image. 
         */
        @MavlinkFieldInfo(
                position = 10,
                unitSize = 1,
                signed = true
        )
        public final Builder captureResult(int captureResult) {
            this.captureResult = captureResult;
            return this;
        }

        /**
         * URL of image taken. Either local storage or http://foo.jpg if camera provides an HTTP 
         * interface. 
         */
        @MavlinkFieldInfo(
                position = 11,
                unitSize = 1,
                arraySize = 205
        )
        public final Builder fileUrl(String fileUrl) {
            this.fileUrl = fileUrl;
            return this;
        }

        public final CameraImageCaptured build() {
            return new CameraImageCaptured(timeBootMs, timeUtc, cameraId, lat, lon, alt, relativeAlt, q, imageIndex, captureResult, fileUrl);
        }
    }
}
