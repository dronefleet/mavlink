package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import java.lang.Override;
import java.lang.String;

/**
 * WIP: Information about a storage medium. 
 */
@MavlinkMessageInfo(
    id = 261,
    crc = 179
)
public final class StorageInformation {
  /**
   * Timestamp (milliseconds since system boot) 
   */
  private final long timeBootMs;

  /**
   * Total capacity in MiB 
   */
  private final float totalCapacity;

  /**
   * Used capacity in MiB 
   */
  private final float usedCapacity;

  /**
   * Available capacity in MiB 
   */
  private final float availableCapacity;

  /**
   * Read speed in MiB/s 
   */
  private final float readSpeed;

  /**
   * Write speed in MiB/s 
   */
  private final float writeSpeed;

  /**
   * Storage ID (1 for first, 2 for second, etc.) 
   */
  private final int storageId;

  /**
   * Number of storage devices 
   */
  private final int storageCount;

  /**
   * Status of storage (0 not available, 1 unformatted, 2 formatted) 
   */
  private final int status;

  private StorageInformation(long timeBootMs, float totalCapacity, float usedCapacity,
      float availableCapacity, float readSpeed, float writeSpeed, int storageId, int storageCount,
      int status) {
    this.timeBootMs = timeBootMs;
    this.totalCapacity = totalCapacity;
    this.usedCapacity = usedCapacity;
    this.availableCapacity = availableCapacity;
    this.readSpeed = readSpeed;
    this.writeSpeed = writeSpeed;
    this.storageId = storageId;
    this.storageCount = storageCount;
    this.status = status;
  }

  @MavlinkMessageBuilder
  public static Builder builder() {
    return new Builder();
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
   * Total capacity in MiB 
   */
  @MavlinkFieldInfo(
      position = 5,
      unitSize = 4
  )
  public final float totalCapacity() {
    return totalCapacity;
  }

  /**
   * Used capacity in MiB 
   */
  @MavlinkFieldInfo(
      position = 6,
      unitSize = 4
  )
  public final float usedCapacity() {
    return usedCapacity;
  }

  /**
   * Available capacity in MiB 
   */
  @MavlinkFieldInfo(
      position = 7,
      unitSize = 4
  )
  public final float availableCapacity() {
    return availableCapacity;
  }

  /**
   * Read speed in MiB/s 
   */
  @MavlinkFieldInfo(
      position = 8,
      unitSize = 4
  )
  public final float readSpeed() {
    return readSpeed;
  }

  /**
   * Write speed in MiB/s 
   */
  @MavlinkFieldInfo(
      position = 9,
      unitSize = 4
  )
  public final float writeSpeed() {
    return writeSpeed;
  }

  /**
   * Storage ID (1 for first, 2 for second, etc.) 
   */
  @MavlinkFieldInfo(
      position = 2,
      unitSize = 1
  )
  public final int storageId() {
    return storageId;
  }

  /**
   * Number of storage devices 
   */
  @MavlinkFieldInfo(
      position = 3,
      unitSize = 1
  )
  public final int storageCount() {
    return storageCount;
  }

  /**
   * Status of storage (0 not available, 1 unformatted, 2 formatted) 
   */
  @MavlinkFieldInfo(
      position = 4,
      unitSize = 1
  )
  public final int status() {
    return status;
  }

  public static class Builder {
    private long timeBootMs;

    private float totalCapacity;

    private float usedCapacity;

    private float availableCapacity;

    private float readSpeed;

    private float writeSpeed;

    private int storageId;

    private int storageCount;

    private int status;

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
     * Total capacity in MiB 
     */
    @MavlinkFieldInfo(
        position = 5,
        unitSize = 4
    )
    public final Builder totalCapacity(float totalCapacity) {
      this.totalCapacity = totalCapacity;
      return this;
    }

    /**
     * Used capacity in MiB 
     */
    @MavlinkFieldInfo(
        position = 6,
        unitSize = 4
    )
    public final Builder usedCapacity(float usedCapacity) {
      this.usedCapacity = usedCapacity;
      return this;
    }

    /**
     * Available capacity in MiB 
     */
    @MavlinkFieldInfo(
        position = 7,
        unitSize = 4
    )
    public final Builder availableCapacity(float availableCapacity) {
      this.availableCapacity = availableCapacity;
      return this;
    }

    /**
     * Read speed in MiB/s 
     */
    @MavlinkFieldInfo(
        position = 8,
        unitSize = 4
    )
    public final Builder readSpeed(float readSpeed) {
      this.readSpeed = readSpeed;
      return this;
    }

    /**
     * Write speed in MiB/s 
     */
    @MavlinkFieldInfo(
        position = 9,
        unitSize = 4
    )
    public final Builder writeSpeed(float writeSpeed) {
      this.writeSpeed = writeSpeed;
      return this;
    }

    /**
     * Storage ID (1 for first, 2 for second, etc.) 
     */
    @MavlinkFieldInfo(
        position = 2,
        unitSize = 1
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
        unitSize = 1
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
        unitSize = 1
    )
    public final Builder status(int status) {
      this.status = status;
      return this;
    }

    public final StorageInformation build() {
      return new StorageInformation(timeBootMs, totalCapacity, usedCapacity, availableCapacity, readSpeed, writeSpeed, storageId, storageCount, status);
    }
  }
}
