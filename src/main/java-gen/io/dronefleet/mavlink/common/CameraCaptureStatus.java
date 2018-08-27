package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;

/**
 * Information about the status of a capture 
 */
@MavlinkMessageInfo(
        id = 262,
        crc = 12
)
public final class CameraCaptureStatus {
    private final long timeBootMs;

    private final int imageStatus;

    private final int videoStatus;

    private final float imageInterval;

    private final long recordingTimeMs;

    private final float availableCapacity;

    private CameraCaptureStatus(long timeBootMs, int imageStatus, int videoStatus,
            float imageInterval, long recordingTimeMs, float availableCapacity) {
        this.timeBootMs = timeBootMs;
        this.imageStatus = imageStatus;
        this.videoStatus = videoStatus;
        this.imageInterval = imageInterval;
        this.recordingTimeMs = recordingTimeMs;
        this.availableCapacity = availableCapacity;
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
     * Current status of image capturing (0: idle, 1: capture in progress, 2: interval set but idle, 3: 
     * interval set and capture in progress) 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 1
    )
    public final int imageStatus() {
        return this.imageStatus;
    }

    /**
     * Current status of video capturing (0: idle, 1: capture in progress) 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 1
    )
    public final int videoStatus() {
        return this.videoStatus;
    }

    /**
     * Image capture interval in seconds 
     */
    @MavlinkFieldInfo(
            position = 4,
            unitSize = 4
    )
    public final float imageInterval() {
        return this.imageInterval;
    }

    /**
     * Time in milliseconds since recording started 
     */
    @MavlinkFieldInfo(
            position = 5,
            unitSize = 4
    )
    public final long recordingTimeMs() {
        return this.recordingTimeMs;
    }

    /**
     * Available storage capacity in MiB 
     */
    @MavlinkFieldInfo(
            position = 6,
            unitSize = 4
    )
    public final float availableCapacity() {
        return this.availableCapacity;
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
        return result;
    }

    @Override
    public String toString() {
        return "CameraCaptureStatus{timeBootMs=" + timeBootMs
                 + ", imageStatus=" + imageStatus
                 + ", videoStatus=" + videoStatus
                 + ", imageInterval=" + imageInterval
                 + ", recordingTimeMs=" + recordingTimeMs
                 + ", availableCapacity=" + availableCapacity + "}";
    }

    public static final class Builder {
        private long timeBootMs;

        private int imageStatus;

        private int videoStatus;

        private float imageInterval;

        private long recordingTimeMs;

        private float availableCapacity;

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
         * Current status of image capturing (0: idle, 1: capture in progress, 2: interval set but idle, 3: 
         * interval set and capture in progress) 
         */
        @MavlinkFieldInfo(
                position = 2,
                unitSize = 1
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
                unitSize = 1
        )
        public final Builder videoStatus(int videoStatus) {
            this.videoStatus = videoStatus;
            return this;
        }

        /**
         * Image capture interval in seconds 
         */
        @MavlinkFieldInfo(
                position = 4,
                unitSize = 4
        )
        public final Builder imageInterval(float imageInterval) {
            this.imageInterval = imageInterval;
            return this;
        }

        /**
         * Time in milliseconds since recording started 
         */
        @MavlinkFieldInfo(
                position = 5,
                unitSize = 4
        )
        public final Builder recordingTimeMs(long recordingTimeMs) {
            this.recordingTimeMs = recordingTimeMs;
            return this;
        }

        /**
         * Available storage capacity in MiB 
         */
        @MavlinkFieldInfo(
                position = 6,
                unitSize = 4
        )
        public final Builder availableCapacity(float availableCapacity) {
            this.availableCapacity = availableCapacity;
            return this;
        }

        public final CameraCaptureStatus build() {
            return new CameraCaptureStatus(timeBootMs, imageStatus, videoStatus, imageInterval, recordingTimeMs, availableCapacity);
        }
    }
}
