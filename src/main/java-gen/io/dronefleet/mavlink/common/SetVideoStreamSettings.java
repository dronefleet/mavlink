package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import java.lang.String;

/**
 * WIP: Message that sets video stream settings 
 */
@MavlinkMessageInfo(
        id = 270,
        crc = 232
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
            position = 1,
            unitSize = 1
    )
    public final int targetSystem() {
        return this.targetSystem;
    }

    /**
     * component ID of the target 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 1
    )
    public final int targetComponent() {
        return this.targetComponent;
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
     * Frames per second (set to -1 for highest framerate possible) 
     */
    @MavlinkFieldInfo(
            position = 4,
            unitSize = 4
    )
    public final float framerate() {
        return this.framerate;
    }

    /**
     * Resolution horizontal in pixels (set to -1 for highest resolution possible) 
     */
    @MavlinkFieldInfo(
            position = 5,
            unitSize = 2
    )
    public final int resolutionH() {
        return this.resolutionH;
    }

    /**
     * Resolution vertical in pixels (set to -1 for highest resolution possible) 
     */
    @MavlinkFieldInfo(
            position = 6,
            unitSize = 2
    )
    public final int resolutionV() {
        return this.resolutionV;
    }

    /**
     * Bit rate in bits per second (set to -1 for auto) 
     */
    @MavlinkFieldInfo(
            position = 7,
            unitSize = 4
    )
    public final long bitrate() {
        return this.bitrate;
    }

    /**
     * Video image rotation clockwise (0-359 degrees) 
     */
    @MavlinkFieldInfo(
            position = 8,
            unitSize = 2
    )
    public final int rotation() {
        return this.rotation;
    }

    /**
     * Video stream URI 
     */
    @MavlinkFieldInfo(
            position = 9,
            unitSize = 1,
            arraySize = 230
    )
    public final String uri() {
        return this.uri;
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
                position = 1,
                unitSize = 1
        )
        public final Builder targetSystem(int targetSystem) {
            this.targetSystem = targetSystem;
            return this;
        }

        /**
         * component ID of the target 
         */
        @MavlinkFieldInfo(
                position = 2,
                unitSize = 1
        )
        public final Builder targetComponent(int targetComponent) {
            this.targetComponent = targetComponent;
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
         * Frames per second (set to -1 for highest framerate possible) 
         */
        @MavlinkFieldInfo(
                position = 4,
                unitSize = 4
        )
        public final Builder framerate(float framerate) {
            this.framerate = framerate;
            return this;
        }

        /**
         * Resolution horizontal in pixels (set to -1 for highest resolution possible) 
         */
        @MavlinkFieldInfo(
                position = 5,
                unitSize = 2
        )
        public final Builder resolutionH(int resolutionH) {
            this.resolutionH = resolutionH;
            return this;
        }

        /**
         * Resolution vertical in pixels (set to -1 for highest resolution possible) 
         */
        @MavlinkFieldInfo(
                position = 6,
                unitSize = 2
        )
        public final Builder resolutionV(int resolutionV) {
            this.resolutionV = resolutionV;
            return this;
        }

        /**
         * Bit rate in bits per second (set to -1 for auto) 
         */
        @MavlinkFieldInfo(
                position = 7,
                unitSize = 4
        )
        public final Builder bitrate(long bitrate) {
            this.bitrate = bitrate;
            return this;
        }

        /**
         * Video image rotation clockwise (0-359 degrees) 
         */
        @MavlinkFieldInfo(
                position = 8,
                unitSize = 2
        )
        public final Builder rotation(int rotation) {
            this.rotation = rotation;
            return this;
        }

        /**
         * Video stream URI 
         */
        @MavlinkFieldInfo(
                position = 9,
                unitSize = 1,
                arraySize = 230
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
