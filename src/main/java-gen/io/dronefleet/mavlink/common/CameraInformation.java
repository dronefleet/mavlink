package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import java.lang.Override;
import java.lang.String;

/**
 * Information about a camera 
 */
@MavlinkMessageInfo(
        id = 259,
        crc = 92
)
public final class CameraInformation {
    /**
     * Timestamp (milliseconds since system boot) 
     */
    private final long timeBootMs;

    /**
     * Version of the camera firmware (v << 24 & 0xff = Dev, v << 16 & 0xff = Patch, v << 8 & 0xff = Minor, v & 
     * 0xff = Major) 
     */
    private final long firmwareVersion;

    /**
     * Focal length in mm 
     */
    private final float focalLength;

    /**
     * Image sensor size horizontal in mm 
     */
    private final float sensorSizeH;

    /**
     * Image sensor size vertical in mm 
     */
    private final float sensorSizeV;

    /**
     * {@link io.dronefleet.mavlink.common.CameraCapFlags CameraCapFlags} enum flags (bitmap) describing camera capabilities. 
     */
    private final CameraCapFlags flags;

    /**
     * Image resolution in pixels horizontal 
     */
    private final int resolutionH;

    /**
     * Image resolution in pixels vertical 
     */
    private final int resolutionV;

    /**
     * Camera definition version (iteration) 
     */
    private final int camDefinitionVersion;

    /**
     * Name of the camera vendor 
     */
    private final byte[] vendorName;

    /**
     * Name of the camera model 
     */
    private final byte[] modelName;

    /**
     * Reserved for a lens ID 
     */
    private final int lensId;

    /**
     * Camera definition URI (if any, otherwise only basic functions will be available). 
     */
    private final String camDefinitionUri;

    private CameraInformation(long timeBootMs, long firmwareVersion, float focalLength,
            float sensorSizeH, float sensorSizeV, CameraCapFlags flags, int resolutionH,
            int resolutionV, int camDefinitionVersion, byte[] vendorName, byte[] modelName,
            int lensId, String camDefinitionUri) {
        this.timeBootMs = timeBootMs;
        this.firmwareVersion = firmwareVersion;
        this.focalLength = focalLength;
        this.sensorSizeH = sensorSizeH;
        this.sensorSizeV = sensorSizeV;
        this.flags = flags;
        this.resolutionH = resolutionH;
        this.resolutionV = resolutionV;
        this.camDefinitionVersion = camDefinitionVersion;
        this.vendorName = vendorName;
        this.modelName = modelName;
        this.lensId = lensId;
        this.camDefinitionUri = camDefinitionUri;
    }

    @MavlinkMessageBuilder
    public static Builder builder() {
        return new Builder();
    }

    @Override
    public String toString() {
        return "CameraInformation{timeBootMs=" + timeBootMs
                 + ", vendorName=" + vendorName
                 + ", modelName=" + modelName
                 + ", firmwareVersion=" + firmwareVersion
                 + ", focalLength=" + focalLength
                 + ", sensorSizeH=" + sensorSizeH
                 + ", sensorSizeV=" + sensorSizeV
                 + ", resolutionH=" + resolutionH
                 + ", resolutionV=" + resolutionV
                 + ", lensId=" + lensId
                 + ", flags=" + flags
                 + ", camDefinitionVersion=" + camDefinitionVersion
                 + ", camDefinitionUri=" + camDefinitionUri + "}";
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
     * Version of the camera firmware (v << 24 & 0xff = Dev, v << 16 & 0xff = Patch, v << 8 & 0xff = Minor, v & 
     * 0xff = Major) 
     */
    @MavlinkFieldInfo(
            position = 4,
            unitSize = 4
    )
    public final long firmwareVersion() {
        return firmwareVersion;
    }

    /**
     * Focal length in mm 
     */
    @MavlinkFieldInfo(
            position = 5,
            unitSize = 4
    )
    public final float focalLength() {
        return focalLength;
    }

    /**
     * Image sensor size horizontal in mm 
     */
    @MavlinkFieldInfo(
            position = 6,
            unitSize = 4
    )
    public final float sensorSizeH() {
        return sensorSizeH;
    }

    /**
     * Image sensor size vertical in mm 
     */
    @MavlinkFieldInfo(
            position = 7,
            unitSize = 4
    )
    public final float sensorSizeV() {
        return sensorSizeV;
    }

    /**
     * {@link io.dronefleet.mavlink.common.CameraCapFlags CameraCapFlags} enum flags (bitmap) describing camera capabilities. 
     */
    @MavlinkFieldInfo(
            position = 11,
            unitSize = 4
    )
    public final CameraCapFlags flags() {
        return flags;
    }

    /**
     * Image resolution in pixels horizontal 
     */
    @MavlinkFieldInfo(
            position = 8,
            unitSize = 2
    )
    public final int resolutionH() {
        return resolutionH;
    }

    /**
     * Image resolution in pixels vertical 
     */
    @MavlinkFieldInfo(
            position = 9,
            unitSize = 2
    )
    public final int resolutionV() {
        return resolutionV;
    }

    /**
     * Camera definition version (iteration) 
     */
    @MavlinkFieldInfo(
            position = 12,
            unitSize = 2
    )
    public final int camDefinitionVersion() {
        return camDefinitionVersion;
    }

    /**
     * Name of the camera vendor 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 1,
            arraySize = 32
    )
    public final byte[] vendorName() {
        return vendorName;
    }

    /**
     * Name of the camera model 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 1,
            arraySize = 32
    )
    public final byte[] modelName() {
        return modelName;
    }

    /**
     * Reserved for a lens ID 
     */
    @MavlinkFieldInfo(
            position = 10,
            unitSize = 1
    )
    public final int lensId() {
        return lensId;
    }

    /**
     * Camera definition URI (if any, otherwise only basic functions will be available). 
     */
    @MavlinkFieldInfo(
            position = 13,
            unitSize = 1,
            arraySize = 140
    )
    public final String camDefinitionUri() {
        return camDefinitionUri;
    }

    public static class Builder {
        private long timeBootMs;

        private long firmwareVersion;

        private float focalLength;

        private float sensorSizeH;

        private float sensorSizeV;

        private CameraCapFlags flags;

        private int resolutionH;

        private int resolutionV;

        private int camDefinitionVersion;

        private byte[] vendorName;

        private byte[] modelName;

        private int lensId;

        private String camDefinitionUri;

        private Builder() {
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
         * Version of the camera firmware (v << 24 & 0xff = Dev, v << 16 & 0xff = Patch, v << 8 & 0xff = Minor, v & 
         * 0xff = Major) 
         */
        @MavlinkFieldInfo(
                position = 4,
                unitSize = 4
        )
        public final Builder firmwareVersion(long firmwareVersion) {
            this.firmwareVersion = firmwareVersion;
            return this;
        }

        /**
         * Focal length in mm 
         */
        @MavlinkFieldInfo(
                position = 5,
                unitSize = 4
        )
        public final Builder focalLength(float focalLength) {
            this.focalLength = focalLength;
            return this;
        }

        /**
         * Image sensor size horizontal in mm 
         */
        @MavlinkFieldInfo(
                position = 6,
                unitSize = 4
        )
        public final Builder sensorSizeH(float sensorSizeH) {
            this.sensorSizeH = sensorSizeH;
            return this;
        }

        /**
         * Image sensor size vertical in mm 
         */
        @MavlinkFieldInfo(
                position = 7,
                unitSize = 4
        )
        public final Builder sensorSizeV(float sensorSizeV) {
            this.sensorSizeV = sensorSizeV;
            return this;
        }

        /**
         * {@link io.dronefleet.mavlink.common.CameraCapFlags CameraCapFlags} enum flags (bitmap) describing camera capabilities. 
         */
        @MavlinkFieldInfo(
                position = 11,
                unitSize = 4
        )
        public final Builder flags(CameraCapFlags flags) {
            this.flags = flags;
            return this;
        }

        /**
         * Image resolution in pixels horizontal 
         */
        @MavlinkFieldInfo(
                position = 8,
                unitSize = 2
        )
        public final Builder resolutionH(int resolutionH) {
            this.resolutionH = resolutionH;
            return this;
        }

        /**
         * Image resolution in pixels vertical 
         */
        @MavlinkFieldInfo(
                position = 9,
                unitSize = 2
        )
        public final Builder resolutionV(int resolutionV) {
            this.resolutionV = resolutionV;
            return this;
        }

        /**
         * Camera definition version (iteration) 
         */
        @MavlinkFieldInfo(
                position = 12,
                unitSize = 2
        )
        public final Builder camDefinitionVersion(int camDefinitionVersion) {
            this.camDefinitionVersion = camDefinitionVersion;
            return this;
        }

        /**
         * Name of the camera vendor 
         */
        @MavlinkFieldInfo(
                position = 2,
                unitSize = 1,
                arraySize = 32
        )
        public final Builder vendorName(byte[] vendorName) {
            this.vendorName = vendorName;
            return this;
        }

        /**
         * Name of the camera model 
         */
        @MavlinkFieldInfo(
                position = 3,
                unitSize = 1,
                arraySize = 32
        )
        public final Builder modelName(byte[] modelName) {
            this.modelName = modelName;
            return this;
        }

        /**
         * Reserved for a lens ID 
         */
        @MavlinkFieldInfo(
                position = 10,
                unitSize = 1
        )
        public final Builder lensId(int lensId) {
            this.lensId = lensId;
            return this;
        }

        /**
         * Camera definition URI (if any, otherwise only basic functions will be available). 
         */
        @MavlinkFieldInfo(
                position = 13,
                unitSize = 1,
                arraySize = 140
        )
        public final Builder camDefinitionUri(String camDefinitionUri) {
            this.camDefinitionUri = camDefinitionUri;
            return this;
        }

        public final CameraInformation build() {
            return new CameraInformation(timeBootMs, firmwareVersion, focalLength, sensorSizeH, sensorSizeV, flags, resolutionH, resolutionV, camDefinitionVersion, vendorName, modelName, lensId, camDefinitionUri);
        }
    }
}
