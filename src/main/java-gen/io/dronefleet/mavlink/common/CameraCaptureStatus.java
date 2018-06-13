package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkMessage;
import io.dronefleet.mavlink.annotations.MavlinkMessageField;

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
   * Current status of image capturing (0: idle, 1: capture in progress, 2: interval set but idle, 3: 
   * interval set and capture in progress) 
   */
  private final int imageStatus;

  /**
   * Current status of video capturing (0: idle, 1: capture in progress) 
   */
  private final int videoStatus;

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

  private CameraCaptureStatus(long timeBootMs, int imageStatus, int videoStatus,
      float imageInterval, long recordingTimeMs, float availableCapacity) {
    this.timeBootMs = timeBootMs;
    this.imageStatus = imageStatus;
    this.videoStatus = videoStatus;
    this.imageInterval = imageInterval;
    this.recordingTimeMs = recordingTimeMs;
    this.availableCapacity = availableCapacity;
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
   * Current status of image capturing (0: idle, 1: capture in progress, 2: interval set but idle, 3: 
   * interval set and capture in progress) 
   */
  @MavlinkMessageField(
      position = 2,
      length = 1
  )
  public final int imageStatus() {
    return imageStatus;
  }

  /**
   * Current status of video capturing (0: idle, 1: capture in progress) 
   */
  @MavlinkMessageField(
      position = 3,
      length = 1
  )
  public final int videoStatus() {
    return videoStatus;
  }

  /**
   * Image capture interval in seconds 
   */
  @MavlinkMessageField(
      position = 4,
      length = 4
  )
  public final float imageInterval() {
    return imageInterval;
  }

  /**
   * Time in milliseconds since recording started 
   */
  @MavlinkMessageField(
      position = 5,
      length = 4
  )
  public final long recordingTimeMs() {
    return recordingTimeMs;
  }

  /**
   * Available storage capacity in MiB 
   */
  @MavlinkMessageField(
      position = 6,
      length = 4
  )
  public final float availableCapacity() {
    return availableCapacity;
  }

  public static class Builder {
    private long timeBootMs;

    private int imageStatus;

    private int videoStatus;

    private float imageInterval;

    private long recordingTimeMs;

    private float availableCapacity;

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
     * Current status of image capturing (0: idle, 1: capture in progress, 2: interval set but idle, 3: 
     * interval set and capture in progress) 
     */
    @MavlinkMessageField(
        position = 2,
        length = 1
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
        length = 1
    )
    public final Builder videoStatus(int videoStatus) {
      this.videoStatus = videoStatus;
      return this;
    }

    /**
     * Image capture interval in seconds 
     */
    @MavlinkMessageField(
        position = 4,
        length = 4
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
        length = 4
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
        length = 4
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
