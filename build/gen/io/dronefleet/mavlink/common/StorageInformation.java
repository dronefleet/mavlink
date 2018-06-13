package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkMessage;
import io.dronefleet.mavlink.annotations.MavlinkMessageField;

/**
 * WIP: Information about a storage medium. 
 */
@MavlinkMessage(
    id = 261,
    crc = 179
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

  public static Builder builder() {
    return new Builder();
  }

  /**
   * Timestamp (milliseconds since system boot) 
   */
  @MavlinkMessageField(
      position = 1,
      length = 4
  )
  public final long timeBootMs() {
    return timeBootMs;
  }

  /**
   * Storage ID (1 for first, 2 for second, etc.) 
   */
  @MavlinkMessageField(
      position = 2,
      length = 1
  )
  public final int storageId() {
    return storageId;
  }

  /**
   * Number of storage devices 
   */
  @MavlinkMessageField(
      position = 3,
      length = 1
  )
  public final int storageCount() {
    return storageCount;
  }

  /**
   * Status of storage (0 not available, 1 unformatted, 2 formatted) 
   */
  @MavlinkMessageField(
      position = 4,
      length = 1
  )
  public final int status() {
    return status;
  }

  /**
   * Total capacity in MiB 
   */
  @MavlinkMessageField(
      position = 5,
      length = 4
  )
  public final float totalCapacity() {
    return totalCapacity;
  }

  /**
   * Used capacity in MiB 
   */
  @MavlinkMessageField(
      position = 6,
      length = 4
  )
  public final float usedCapacity() {
    return usedCapacity;
  }

  /**
   * Available capacity in MiB 
   */
  @MavlinkMessageField(
      position = 7,
      length = 4
  )
  public final float availableCapacity() {
    return availableCapacity;
  }

  /**
   * Read speed in MiB/s 
   */
  @MavlinkMessageField(
      position = 8,
      length = 4
  )
  public final float readSpeed() {
    return readSpeed;
  }

  /**
   * Write speed in MiB/s 
   */
  @MavlinkMessageField(
      position = 9,
      length = 4
  )
  public final float writeSpeed() {
    return writeSpeed;
  }

  public class Builder {
    private long timeBootMs;

    private int storageId;

    private int storageCount;

    private int status;

    private float totalCapacity;

    private float usedCapacity;

    private float availableCapacity;

    private float readSpeed;

    private float writeSpeed;

    private Builder() {
    }

    /**
     * Timestamp (milliseconds since system boot) 
     */
    @MavlinkMessageField(
        position = 1,
        length = 4
    )
    public final Builder timeBootMs(long timeBootMs) {
      this.timeBootMs = timeBootMs;
      return this;
    }

    /**
     * Storage ID (1 for first, 2 for second, etc.) 
     */
    @MavlinkMessageField(
        position = 2,
        length = 1
    )
    public final Builder storageId(int storageId) {
      this.storageId = storageId;
      return this;
    }

    /**
     * Number of storage devices 
     */
    @MavlinkMessageField(
        position = 3,
        length = 1
    )
    public final Builder storageCount(int storageCount) {
      this.storageCount = storageCount;
      return this;
    }

    /**
     * Status of storage (0 not available, 1 unformatted, 2 formatted) 
     */
    @MavlinkMessageField(
        position = 4,
        length = 1
    )
    public final Builder status(int status) {
      this.status = status;
      return this;
    }

    /**
     * Total capacity in MiB 
     */
    @MavlinkMessageField(
        position = 5,
        length = 4
    )
    public final Builder totalCapacity(float totalCapacity) {
      this.totalCapacity = totalCapacity;
      return this;
    }

    /**
     * Used capacity in MiB 
     */
    @MavlinkMessageField(
        position = 6,
        length = 4
    )
    public final Builder usedCapacity(float usedCapacity) {
      this.usedCapacity = usedCapacity;
      return this;
    }

    /**
     * Available capacity in MiB 
     */
    @MavlinkMessageField(
        position = 7,
        length = 4
    )
    public final Builder availableCapacity(float availableCapacity) {
      this.availableCapacity = availableCapacity;
      return this;
    }

    /**
     * Read speed in MiB/s 
     */
    @MavlinkMessageField(
        position = 8,
        length = 4
    )
    public final Builder readSpeed(float readSpeed) {
      this.readSpeed = readSpeed;
      return this;
    }

    /**
     * Write speed in MiB/s 
     */
    @MavlinkMessageField(
        position = 9,
        length = 4
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
