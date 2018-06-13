package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkMessage;
import io.dronefleet.mavlink.annotations.MavlinkMessageField;

/**
 * Send a debug value. The index is used to discriminate between values. These values show up in the 
 * plot of QGroundControl as DEBUG N. 
 */
@MavlinkMessage(
    id = 254,
    crc = 46
)
public final class Debug {
  /**
   * Timestamp (milliseconds since system boot) 
   */
  private final long timeBootMs;

  /**
   * index of debug variable 
   */
  private final int ind;

  /**
   * DEBUG value 
   */
  private final float value;

  private Debug(long timeBootMs, int ind, float value) {
    this.timeBootMs = timeBootMs;
    this.ind = ind;
    this.value = value;
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
   * index of debug variable 
   */
  @MavlinkMessageField(
      position = 2,
      length = 1
  )
  public final int ind() {
    return ind;
  }

  /**
   * DEBUG value 
   */
  @MavlinkMessageField(
      position = 3,
      length = 4
  )
  public final float value() {
    return value;
  }

  public static class Builder {
    private long timeBootMs;

    private int ind;

    private float value;

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
     * index of debug variable 
     */
    @MavlinkMessageField(
        position = 2,
        length = 1
    )
    public final Builder ind(int ind) {
      this.ind = ind;
      return this;
    }

    /**
     * DEBUG value 
     */
    @MavlinkMessageField(
        position = 3,
        length = 4
    )
    public final Builder value(float value) {
      this.value = value;
      return this;
    }

    public final Debug build() {
      return new Debug(timeBootMs, ind, value);
    }
  }
}
