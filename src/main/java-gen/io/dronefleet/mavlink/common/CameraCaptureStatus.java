package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;

/**
 * Information about the status of a capture. Can be requested with a MAV_CMD_REQUEST_MESSAGE 
 * command. 
 */
@MavlinkMessageInfo(
        id = 262,
        crc = 12,
        description = "Information about the status of a capture. Can be requested with a MAV_CMD_REQUEST_MESSAGE command."
)
public final class CameraCaptureStatus {
    private final long timeBootMs;

    private final int imageStatus;

    private final int videoStatus;

    private final float imageInterval;

    private final long recordingTimeMs;

    private final float availableCapacity;

    private final int imageCount;

    private CameraCaptureStatus(long timeBootMs, int imageStatus, int videoStatus,
            float imageInterval, long recordingTimeMs, float availableCapacity, int imageCount) {
        this.timeBootMs = timeBootMs;
        this.imageStatus = imageStatus;
        this.videoStatus = videoStatus;
        this.imageInterval = imageInterval;
        this.recordingTimeMs = recordingTimeMs;
        this.availableCapacity = availableCapacity;
        this.imageCount = imageCount;
    }

    /**
     * Returns a builder instance for this message.
     */
    @MavlinkMessageBuilder
    public static Builder builder() {
        return new Builder();
    }

    /**
     * Timestamp (time since system boot). 
     */
    @MavlinkFieldInfo(
            position = 1,
            unitSize = 4,
            description = "Timestamp (time since system boot)."
    )
    public final long timeBootMs() {
        return this.timeBootMs;
    }

    /**
     * Current status of image capturing (0: idle, 1: capture in progress, 2: interval set but idle, 3: 
     * interval set and capture in progress) 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 1,
            description = "Current status of image capturing (0: idle, 1: capture in progress, 2: interval set but idle, 3: interval set and capture in progress)"
    )
    public final int imageStatus() {
        return this.imageStatus;
    }

    /**
     * Current status of video capturing (0: idle, 1: capture in progress) 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 1,
            description = "Current status of video capturing (0: idle, 1: capture in progress)"
    )
    public final int videoStatus() {
        return this.videoStatus;
    }

    /**
     * Image capture interval 
     */
    @MavlinkFieldInfo(
            position = 4,
            unitSize = 4,
            description = "Image capture interval"
    )
    public final float imageInterval() {
        return this.imageInterval;
    }

    /**
     * Elapsed time since recording started (0: Not supported/available). A GCS should compute 
     * recording time and use non-zero values of this field to correct any discrepancy. 
     */
    @MavlinkFieldInfo(
            position = 5,
            unitSize = 4,
            description = "Elapsed time since recording started (0: Not supported/available). A GCS should compute recording time and use non-zero values of this field to correct any discrepancy."
    )
    public final long recordingTimeMs() {
        return this.recordingTimeMs;
    }

    /**
     * Available storage capacity. 
     */
    @MavlinkFieldInfo(
            position = 6,
            unitSize = 4,
            description = "Available storage capacity."
    )
    public final float availableCapacity() {
        return this.availableCapacity;
    }

    /**
     * Total number of images captured ('forever', or until reset using MAV_CMD_STORAGE_FORMAT). 
     */
    @MavlinkFieldInfo(
            position = 8,
            unitSize = 4,
            signed = true,
            extension = true,
            description = "Total number of images captured ('forever', or until reset using MAV_CMD_STORAGE_FORMAT)."
    )
    public final int imageCount() {
        return this.imageCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !getClass().equals(o.getClass())) return false;
        CameraCaptureStatus other = (CameraCaptureStatus)o;
        if (!Objects.deepEquals(timeBootMs, other.timeBootMs)) return false;
        if (!Objects.deepEquals(imageStatus, other.imageStatus)) return false;
        if (!Objects.deepEquals(videoStatus, other.videoStatus)) return false;
        if (!Objects.deepEquals(imageInterval, other.imageInterval)) return false;
        if (!Objects.deepEquals(recordingTimeMs, other.recordingTimeMs)) return false;
        if (!Objects.deepEquals(availableCapacity, other.availableCapacity)) return false;
        if (!Objects.deepEquals(imageCount, other.imageCount)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + Objects.hashCode(timeBootMs);
        result = 31 * result + Objects.hashCode(imageStatus);
        result = 31 * result + Objects.hashCode(videoStatus);
        result = 31 * result + Objects.hashCode(imageInterval);
        result = 31 * result + Objects.hashCode(recordingTimeMs);
        result = 31 * result + Objects.hashCode(availableCapacity);
        result = 31 * result + Objects.hashCode(imageCount);
        return result;
    }

    @Override
    public String toString() {
        return "CameraCaptureStatus{timeBootMs=" + timeBootMs
                 + ", imageStatus=" + imageStatus
                 + ", videoStatus=" + videoStatus
                 + ", imageInterval=" + imageInterval
                 + ", recordingTimeMs=" + recordingTimeMs
                 + ", availableCapacity=" + availableCapacity
                 + ", imageCount=" + imageCount + "}";
    }

    public static final class Builder {
        private long timeBootMs;

        private int imageStatus;

        private int videoStatus;

        private float imageInterval;

        private long recordingTimeMs;

        private float availableCapacity;

        private int imageCount;

        /**
         * Timestamp (time since system boot). 
         */
        @MavlinkFieldInfo(
                position = 1,
                unitSize = 4,
                description = "Timestamp (time since system boot)."
        )
        public final Builder timeBootMs(long timeBootMs) {
            this.timeBootMs = timeBootMs;
            return this;
        }

        /**
         * Current status of image capturing (0: idle, 1: capture in progress, 2: interval set but idle, 3: 
         * interval set and capture in progress) 
         */
        @MavlinkFieldInfo(
                position = 2,
                unitSize = 1,
                description = "Current status of image capturing (0: idle, 1: capture in progress, 2: interval set but idle, 3: interval set and capture in progress)"
        )
        public final Builder imageStatus(int imageStatus) {
            this.imageStatus = imageStatus;
            return this;
        }

        /**
         * Current status of video capturing (0: idle, 1: capture in progress) 
         */
        @MavlinkFieldInfo(
                position = 3,
                unitSize = 1,
                description = "Current status of video capturing (0: idle, 1: capture in progress)"
        )
        public final Builder videoStatus(int videoStatus) {
            this.videoStatus = videoStatus;
            return this;
        }

        /**
         * Image capture interval 
         */
        @MavlinkFieldInfo(
                position = 4,
                unitSize = 4,
                description = "Image capture interval"
        )
        public final Builder imageInterval(float imageInterval) {
            this.imageInterval = imageInterval;
            return this;
        }

        /**
         * Elapsed time since recording started (0: Not supported/available). A GCS should compute 
         * recording time and use non-zero values of this field to correct any discrepancy. 
         */
        @MavlinkFieldInfo(
                position = 5,
                unitSize = 4,
                description = "Elapsed time since recording started (0: Not supported/available). A GCS should compute recording time and use non-zero values of this field to correct any discrepancy."
        )
        public final Builder recordingTimeMs(long recordingTimeMs) {
            this.recordingTimeMs = recordingTimeMs;
            return this;
        }

        /**
         * Available storage capacity. 
         */
        @MavlinkFieldInfo(
                position = 6,
                unitSize = 4,
                description = "Available storage capacity."
        )
        public final Builder availableCapacity(float availableCapacity) {
            this.availableCapacity = availableCapacity;
            return this;
        }

        /**
         * Total number of images captured ('forever', or until reset using MAV_CMD_STORAGE_FORMAT). 
         */
        @MavlinkFieldInfo(
                position = 8,
                unitSize = 4,
                signed = true,
                extension = true,
                description = "Total number of images captured ('forever', or until reset using MAV_CMD_STORAGE_FORMAT)."
        )
        public final Builder imageCount(int imageCount) {
            this.imageCount = imageCount;
            return this;
        }

        public final CameraCaptureStatus build() {
            return new CameraCaptureStatus(timeBootMs, imageStatus, videoStatus, imageInterval, recordingTimeMs, availableCapacity, imageCount);
        }
    }
}
