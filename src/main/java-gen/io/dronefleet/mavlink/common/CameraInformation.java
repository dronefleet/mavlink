package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import java.lang.String;

/**
 * Information about a camera 
 */
@MavlinkMessageInfo(
        id = 259,
        crc = 92
)
public final class CameraInformation {
    private final long timeBootMs;

    private final byte[] vendorName;

    private final byte[] modelName;

    private final long firmwareVersion;

    private final float focalLength;

    private final float sensorSizeH;

    private final float sensorSizeV;

    private final int resolutionH;

    private final int resolutionV;

    private final int lensId;

    private final CameraCapFlags flags;

    private final int camDefinitionVersion;

    private final String camDefinitionUri;

    private CameraInformation(long timeBootMs, byte[] vendorName, byte[] modelName,
            long firmwareVersion, float focalLength, float sensorSizeH, float sensorSizeV,
            int resolutionH, int resolutionV, int lensId, CameraCapFlags flags,
            int camDefinitionVersion, String camDefinitionUri) {
        this.timeBootMs = timeBootMs;
        this.vendorName = vendorName;
        this.modelName = modelName;
        this.firmwareVersion = firmwareVersion;
        this.focalLength = focalLength;
        this.sensorSizeH = sensorSizeH;
        this.sensorSizeV = sensorSizeV;
        this.resolutionH = resolutionH;
        this.resolutionV = resolutionV;
        this.lensId = lensId;
        this.flags = flags;
        this.camDefinitionVersion = camDefinitionVersion;
        this.camDefinitionUri = camDefinitionUri;
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
     * Name of the camera vendor 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 1,
            arraySize = 32
    )
    public final byte[] vendorName() {
        return this.vendorName;
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
        return this.modelName;
    }

    /**
     * Version of the camera firmware (v &lt;&lt; 24 &amp; 0xff = Dev, v &lt;&lt; 16 &amp; 0xff = Patch, v &lt;&lt; 8 &amp; 0xff = Minor, v &amp; 
     * 0xff = Major) 
     */
    @MavlinkFieldInfo(
            position = 4,
            unitSize = 4
    )
    public final long firmwareVersion() {
        return this.firmwareVersion;
    }

    /**
     * Focal length in mm 
     */
    @MavlinkFieldInfo(
            position = 5,
            unitSize = 4
    )
    public final float focalLength() {
        return this.focalLength;
    }

    /**
     * Image sensor size horizontal in mm 
     */
    @MavlinkFieldInfo(
            position = 6,
            unitSize = 4
    )
    public final float sensorSizeH() {
        return this.sensorSizeH;
    }

    /**
     * Image sensor size vertical in mm 
     */
    @MavlinkFieldInfo(
            position = 7,
            unitSize = 4
    )
    public final float sensorSizeV() {
        return this.sensorSizeV;
    }

    /**
     * Image resolution in pixels horizontal 
     */
    @MavlinkFieldInfo(
            position = 8,
            unitSize = 2
    )
    public final int resolutionH() {
        return this.resolutionH;
    }

    /**
     * Image resolution in pixels vertical 
     */
    @MavlinkFieldInfo(
            position = 9,
            unitSize = 2
    )
    public final int resolutionV() {
        return this.resolutionV;
    }

    /**
     * Reserved for a lens ID 
     */
    @MavlinkFieldInfo(
            position = 10,
            unitSize = 1
    )
    public final int lensId() {
        return this.lensId;
    }

    /**
     * {@link io.dronefleet.mavlink.common.CameraCapFlags CAMERA_CAP_FLAGS} enum flags (bitmap) describing camera capabilities. 
     */
    @MavlinkFieldInfo(
            position = 11,
            unitSize = 4
    )
    public final CameraCapFlags flags() {
        return this.flags;
    }

    /**
     * Camera definition version (iteration) 
     */
    @MavlinkFieldInfo(
            position = 12,
            unitSize = 2
    )
    public final int camDefinitionVersion() {
        return this.camDefinitionVersion;
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
        return this.camDefinitionUri;
    }

    public static final class Builder {
        private long timeBootMs;

        private byte[] vendorName;

        private byte[] modelName;

        private long firmwareVersion;

        private float focalLength;

        private float sensorSizeH;

        private float sensorSizeV;

        private int resolutionH;

        private int resolutionV;

        private int lensId;

        private CameraCapFlags flags;

        private int camDefinitionVersion;

        private String camDefinitionUri;

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
         * Version of the camera firmware (v &lt;&lt; 24 &amp; 0xff = Dev, v &lt;&lt; 16 &amp; 0xff = Patch, v &lt;&lt; 8 &amp; 0xff = Minor, v &amp; 
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
         * {@link io.dronefleet.mavlink.common.CameraCapFlags CAMERA_CAP_FLAGS} enum flags (bitmap) describing camera capabilities. 
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
            return new CameraInformation(timeBootMs, vendorName, modelName, firmwareVersion, focalLength, sensorSizeH, sensorSizeV, resolutionH, resolutionV, lensId, flags, camDefinitionVersion, camDefinitionUri);
        }
    }
}
