package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkMessage;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageField;
import java.lang.Override;
import java.lang.String;

/**
 * Information about the status of a capture 
 */
@MavlinkMessage(
    id = 262,
    crc = 12
)
public final class CameraCaptureStatus {
  /**
   * Timestamp (milliseconds since system boot) 
   */
  private final long timeBootMs;

  /**
   * Image capture interval in seconds 
   */
  private final float imageInterval;

  /**
   * Time in milliseconds since recording started 
   */
  private final long recordingTimeMs;

  /**
   * Available storage capacity in MiB 
   */
  private final float availableCapacity;

  /**
   * Current status of image capturing (0: idle, 1: capture in progress, 2: interval set but idle, 3: 
   * interval set and capture in progress) 
   */
  private final int imageStatus;

  /**
   * Current status of video capturing (0: idle, 1: capture in progress) 
   */
  private final int videoStatus;

  private CameraCaptureStatus(long timeBootMs, float imageInterval, long recordingTimeMs,
      float availableCapacity, int imageStatus, int videoStatus) {
    this.timeBootMs = timeBootMs;
    this.imageInterval = imageInterval;
    this.recordingTimeMs = recordingTimeMs;
    this.availableCapacity = availableCapacity;
    this.imageStatus = imageStatus;
    this.videoStatus = videoStatus;
  }

  @MavlinkMessageBuilder
  public static Builder builder() {
    return new Builder();
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

  /**
   * Timestamp (milliseconds since system boot) 
   */
  @MavlinkMessageField(
      position = 1,
      unitSize = 4
  )
  public final long timeBootMs() {
    return timeBootMs;
  }

  /**
   * Image capture interval in seconds 
   */
  @MavlinkMessageField(
      position = 4,
      unitSize = 4
  )
  public final float imageInterval() {
    return imageInterval;
  }

  /**
   * Time in milliseconds since recording started 
   */
  @MavlinkMessageField(
      position = 5,
      unitSize = 4
  )
  public final long recordingTimeMs() {
    return recordingTimeMs;
  }

  /**
   * Available storage capacity in MiB 
   */
  @MavlinkMessageField(
      position = 6,
      unitSize = 4
  )
  public final float availableCapacity() {
    return availableCapacity;
  }

  /**
   * Current status of image capturing (0: idle, 1: capture in progress, 2: interval set but idle, 3: 
   * interval set and capture in progress) 
   */
  @MavlinkMessageField(
      position = 2,
      unitSize = 1
  )
  public final int imageStatus() {
    return imageStatus;
  }

  /**
   * Current status of video capturing (0: idle, 1: capture in progress) 
   */
  @MavlinkMessageField(
      position = 3,
      unitSize = 1
  )
  public final int videoStatus() {
    return videoStatus;
  }

  public static class Builder {
    private long timeBootMs;

    private float imageInterval;

    private long recordingTimeMs;

    private float availableCapacity;

    private int imageStatus;

    private int videoStatus;

    private Builder() {
    }

    /**
     * Timestamp (milliseconds since system boot) 
     */
    @MavlinkMessageField(
        position = 1,
        unitSize = 4
    )
    public final Builder timeBootMs(long timeBootMs) {
      this.timeBootMs = timeBootMs;
      return this;
    }

    /**
     * Image capture interval in seconds 
     */
    @MavlinkMessageField(
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
    @MavlinkMessageField(
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
    @MavlinkMessageField(
        position = 6,
        unitSize = 4
    )
    public final Builder availableCapacity(float availableCapacity) {
      this.availableCapacity = availableCapacity;
      return this;
    }

    /**
     * Current status of image capturing (0: idle, 1: capture in progress, 2: interval set but idle, 3: 
     * interval set and capture in progress) 
     */
    @MavlinkMessageField(
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
    @MavlinkMessageField(
        position = 3,
        unitSize = 1
    )
    public final Builder videoStatus(int videoStatus) {
      this.videoStatus = videoStatus;
      return this;
    }

    public final CameraCaptureStatus build() {
      return new CameraCaptureStatus(timeBootMs, imageInterval, recordingTimeMs, availableCapacity, imageStatus, videoStatus);
    }
  }
}
