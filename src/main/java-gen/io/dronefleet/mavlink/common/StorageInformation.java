package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;

/**
 * Information about a storage medium. 
 */
@MavlinkMessageInfo(
        id = 261,
        crc = 179,
        description = "Information about a storage medium."
)
public final class StorageInformation {
    private final long timeBootMs;

    private final int storageId;

    private final int storageCount;

    private final int status;

    private final float totalCapacity;

    private final float usedCapacity;

    private final float availableCapacity;

    private final float readSpeed;

    private final float writeSpeed;

    private StorageInformation(long timeBootMs, int storageId, int storageCount, int status,
            float totalCapacity, float usedCapacity, float availableCapacity, float readSpeed,
            float writeSpeed) {
        this.timeBootMs = timeBootMs;
        this.storageId = storageId;
        this.storageCount = storageCount;
        this.status = status;
        this.totalCapacity = totalCapacity;
        this.usedCapacity = usedCapacity;
        this.availableCapacity = availableCapacity;
        this.readSpeed = readSpeed;
        this.writeSpeed = writeSpeed;
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
     * Storage ID (1 for first, 2 for second, etc.) 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 1,
            description = "Storage ID (1 for first, 2 for second, etc.)"
    )
    public final int storageId() {
        return this.storageId;
    }

    /**
     * Number of storage devices 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 1,
            description = "Number of storage devices"
    )
    public final int storageCount() {
        return this.storageCount;
    }

    /**
     * Status of storage (0 not available, 1 unformatted, 2 formatted) 
     */
    @MavlinkFieldInfo(
            position = 4,
            unitSize = 1,
            description = "Status of storage (0 not available, 1 unformatted, 2 formatted)"
    )
    public final int status() {
        return this.status;
    }

    /**
     * Total capacity. 
     */
    @MavlinkFieldInfo(
            position = 5,
            unitSize = 4,
            description = "Total capacity."
    )
    public final float totalCapacity() {
        return this.totalCapacity;
    }

    /**
     * Used capacity. 
     */
    @MavlinkFieldInfo(
            position = 6,
            unitSize = 4,
            description = "Used capacity."
    )
    public final float usedCapacity() {
        return this.usedCapacity;
    }

    /**
     * Available storage capacity. 
     */
    @MavlinkFieldInfo(
            position = 7,
            unitSize = 4,
            description = "Available storage capacity."
    )
    public final float availableCapacity() {
        return this.availableCapacity;
    }

    /**
     * Read speed. 
     */
    @MavlinkFieldInfo(
            position = 8,
            unitSize = 4,
            description = "Read speed."
    )
    public final float readSpeed() {
        return this.readSpeed;
    }

    /**
     * Write speed. 
     */
    @MavlinkFieldInfo(
            position = 9,
            unitSize = 4,
            description = "Write speed."
    )
    public final float writeSpeed() {
        return this.writeSpeed;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !getClass().equals(o.getClass())) return false;
        StorageInformation other = (StorageInformation)o;
        if (!Objects.deepEquals(timeBootMs, other.timeBootMs)) return false;
        if (!Objects.deepEquals(storageId, other.storageId)) return false;
        if (!Objects.deepEquals(storageCount, other.storageCount)) return false;
        if (!Objects.deepEquals(status, other.status)) return false;
        if (!Objects.deepEquals(totalCapacity, other.totalCapacity)) return false;
        if (!Objects.deepEquals(usedCapacity, other.usedCapacity)) return false;
        if (!Objects.deepEquals(availableCapacity, other.availableCapacity)) return false;
        if (!Objects.deepEquals(readSpeed, other.readSpeed)) return false;
        if (!Objects.deepEquals(writeSpeed, other.writeSpeed)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + Objects.hashCode(timeBootMs);
        result = 31 * result + Objects.hashCode(storageId);
        result = 31 * result + Objects.hashCode(storageCount);
        result = 31 * result + Objects.hashCode(status);
        result = 31 * result + Objects.hashCode(totalCapacity);
        result = 31 * result + Objects.hashCode(usedCapacity);
        result = 31 * result + Objects.hashCode(availableCapacity);
        result = 31 * result + Objects.hashCode(readSpeed);
        result = 31 * result + Objects.hashCode(writeSpeed);
        return result;
    }

    @Override
    public String toString() {
        return "StorageInformation{timeBootMs=" + timeBootMs
                 + ", storageId=" + storageId
                 + ", storageCount=" + storageCount
                 + ", status=" + status
                 + ", totalCapacity=" + totalCapacity
                 + ", usedCapacity=" + usedCapacity
                 + ", availableCapacity=" + availableCapacity
                 + ", readSpeed=" + readSpeed
                 + ", writeSpeed=" + writeSpeed + "}";
    }

    public static final class Builder {
        private long timeBootMs;

        private int storageId;

        private int storageCount;

        private int status;

        private float totalCapacity;

        private float usedCapacity;

        private float availableCapacity;

        private float readSpeed;

        private float writeSpeed;

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
         * Storage ID (1 for first, 2 for second, etc.) 
         */
        @MavlinkFieldInfo(
                position = 2,
                unitSize = 1,
                description = "Storage ID (1 for first, 2 for second, etc.)"
        )
        public final Builder storageId(int storageId) {
            this.storageId = storageId;
            return this;
        }

        /**
         * Number of storage devices 
         */
        @MavlinkFieldInfo(
                position = 3,
                unitSize = 1,
                description = "Number of storage devices"
        )
        public final Builder storageCount(int storageCount) {
            this.storageCount = storageCount;
            return this;
        }

        /**
         * Status of storage (0 not available, 1 unformatted, 2 formatted) 
         */
        @MavlinkFieldInfo(
                position = 4,
                unitSize = 1,
                description = "Status of storage (0 not available, 1 unformatted, 2 formatted)"
        )
        public final Builder status(int status) {
            this.status = status;
            return this;
        }

        /**
         * Total capacity. 
         */
        @MavlinkFieldInfo(
                position = 5,
                unitSize = 4,
                description = "Total capacity."
        )
        public final Builder totalCapacity(float totalCapacity) {
            this.totalCapacity = totalCapacity;
            return this;
        }

        /**
         * Used capacity. 
         */
        @MavlinkFieldInfo(
                position = 6,
                unitSize = 4,
                description = "Used capacity."
        )
        public final Builder usedCapacity(float usedCapacity) {
            this.usedCapacity = usedCapacity;
            return this;
        }

        /**
         * Available storage capacity. 
         */
        @MavlinkFieldInfo(
                position = 7,
                unitSize = 4,
                description = "Available storage capacity."
        )
        public final Builder availableCapacity(float availableCapacity) {
            this.availableCapacity = availableCapacity;
            return this;
        }

        /**
         * Read speed. 
         */
        @MavlinkFieldInfo(
                position = 8,
                unitSize = 4,
                description = "Read speed."
        )
        public final Builder readSpeed(float readSpeed) {
            this.readSpeed = readSpeed;
            return this;
        }

        /**
         * Write speed. 
         */
        @MavlinkFieldInfo(
                position = 9,
                unitSize = 4,
                description = "Write speed."
        )
        public final Builder writeSpeed(float writeSpeed) {
            this.writeSpeed = writeSpeed;
            return this;
        }

        public final StorageInformation build() {
            return new StorageInformation(timeBootMs, storageId, storageCount, status, totalCapacity, usedCapacity, availableCapacity, readSpeed, writeSpeed);
        }
    }
}
