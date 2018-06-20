package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import java.lang.Override;
import java.lang.String;

/**
 * Send a debug value. The index is used to discriminate between values. These values show up in the 
 * plot of QGroundControl as DEBUG N. 
 */
@MavlinkMessageInfo(
    id = 254,
    crc = 46
)
public final class Debug {
  /**
   * Timestamp (milliseconds since system boot) 
   */
  private final long timeBootMs;

  /**
   * DEBUG value 
   */
  private final float value;

  /**
   * index of debug variable 
   */
  private final int ind;

  private Debug(long timeBootMs, float value, int ind) {
    this.timeBootMs = timeBootMs;
    this.value = value;
    this.ind = ind;
  }

  @MavlinkMessageBuilder
  public static Builder builder() {
    return new Builder();
  }

  @Override
  public String toString() {
    return "Debug{timeBootMs=" + timeBootMs
         + ", ind=" + ind
         + ", value=" + value + "}";
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
   * DEBUG value 
   */
  @MavlinkFieldInfo(
      position = 3,
      unitSize = 4
  )
  public final float value() {
    return value;
  }

  /**
   * index of debug variable 
   */
  @MavlinkFieldInfo(
      position = 2,
      unitSize = 1
  )
  public final int ind() {
    return ind;
  }

  public static class Builder {
    private long timeBootMs;

    private float value;

    private int ind;

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
     * DEBUG value 
     */
    @MavlinkFieldInfo(
        position = 3,
        unitSize = 4
    )
    public final Builder value(float value) {
      this.value = value;
      return this;
    }

    /**
     * index of debug variable 
     */
    @MavlinkFieldInfo(
        position = 2,
        unitSize = 1
    )
    public final Builder ind(int ind) {
      this.ind = ind;
      return this;
    }

    public final Debug build() {
      return new Debug(timeBootMs, value, ind);
    }
  }
}
