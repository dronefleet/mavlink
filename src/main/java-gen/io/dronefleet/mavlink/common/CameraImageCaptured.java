package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import java.lang.Float;
import java.lang.Override;
import java.lang.String;
import java.math.BigInteger;
import java.util.List;

/**
 * Information about a captured image 
 */
@MavlinkMessageInfo(
        id = 263,
        crc = 133
)
public final class CameraImageCaptured {
    /**
     * Timestamp (microseconds since UNIX epoch) in UTC. 0 for unknown. 
     */
    private final BigInteger timeUtc;

    /**
     * Timestamp (milliseconds since system boot) 
     */
    private final long timeBootMs;

    /**
     * Latitude, expressed as degrees * 1E7 where image was taken 
     */
    private final int lat;

    /**
     * Longitude, expressed as degrees * 1E7 where capture was taken 
     */
    private final int lon;

    /**
     * Altitude in meters, expressed as * 1E3 (AMSL, not WGS84) where image was taken 
     */
    private final int alt;

    /**
     * Altitude above ground in meters, expressed as * 1E3 where image was taken 
     */
    private final int relativeAlt;

    /**
     * Quaternion of camera orientation (w, x, y, z order, zero-rotation is 0, 0, 0, 0) 
     */
    private final List<Float> q;

    /**
     * Zero based index of this image (image count since armed -1) 
     */
    private final int imageIndex;

    /**
     * Camera ID (1 for first, 2 for second, etc.) 
     */
    private final int cameraId;

    /**
     * Boolean indicating success (1) or failure (0) while capturing this image. 
     */
    private final int captureResult;

    /**
     * URL of image taken. Either local storage or http://foo.jpg if camera provides an HTTP 
     * interface. 
     */
    private final String fileUrl;

    private CameraImageCaptured(BigInteger timeUtc, long timeBootMs, int lat, int lon, int alt,
            int relativeAlt, List<Float> q, int imageIndex, int cameraId, int captureResult,
            String fileUrl) {
        this.timeUtc = timeUtc;
        this.timeBootMs = timeBootMs;
        this.lat = lat;
        this.lon = lon;
        this.alt = alt;
        this.relativeAlt = relativeAlt;
        this.q = q;
        this.imageIndex = imageIndex;
        this.cameraId = cameraId;
        this.captureResult = captureResult;
        this.fileUrl = fileUrl;
    }

    @MavlinkMessageBuilder
    public static Builder builder() {
        return new Builder();
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

    /**
     * Timestamp (microseconds since UNIX epoch) in UTC. 0 for unknown. 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 8
    )
    public final BigInteger timeUtc() {
        return timeUtc;
    }

    /**
     * Timestamp (milliseconds since system boot) 
     */
    @MavlinkFieldInfo(
            position = 1,
            unitSize = 4
    )
    public final long timeBootMs() {
        return timeBootMs;
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
        return lat;
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
        return lon;
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
        return alt;
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
        return relativeAlt;
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
        return q;
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
        return imageIndex;
    }

    /**
     * Camera ID (1 for first, 2 for second, etc.) 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 1
    )
    public final int cameraId() {
        return cameraId;
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
        return captureResult;
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
        return fileUrl;
    }

    public static class Builder {
        private BigInteger timeUtc;

        private long timeBootMs;

        private int lat;

        private int lon;

        private int alt;

        private int relativeAlt;

        private List<Float> q;

        private int imageIndex;

        private int cameraId;

        private int captureResult;

        private String fileUrl;

        private Builder() {
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
            return new CameraImageCaptured(timeUtc, timeBootMs, lat, lon, alt, relativeAlt, q, imageIndex, cameraId, captureResult, fileUrl);
        }
    }
}
