package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkMessage;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageField;
import java.lang.Override;
import java.lang.String;

/**
 * Orientation of a mount 
 */
@MavlinkMessage(
    id = 265,
    crc = 26
)
public final class MountOrientation {
  /**
   * Timestamp (milliseconds since system boot) 
   */
  private final long timeBootMs;

  /**
   * Roll in global frame in degrees (set to NaN for invalid). 
   */
  private final float roll;

  /**
   * Pitch in global frame in degrees (set to NaN for invalid). 
   */
  private final float pitch;

  /**
   * Yaw relative to vehicle in degrees (set to NaN for invalid). 
   */
  private final float yaw;

  /**
   * Yaw in absolute frame in degrees, North is 0 (set to NaN for invalid). 
   */
  private final float yawAbsolute;

  private MountOrientation(long timeBootMs, float roll, float pitch, float yaw, float yawAbsolute) {
    this.timeBootMs = timeBootMs;
    this.roll = roll;
    this.pitch = pitch;
    this.yaw = yaw;
    this.yawAbsolute = yawAbsolute;
  }

  @MavlinkMessageBuilder
  public static Builder builder() {
    return new Builder();
  }

  @Override
  public String toString() {
    return "MountOrientation{timeBootMs=" + timeBootMs
         + ", roll=" + roll
         + ", pitch=" + pitch
         + ", yaw=" + yaw
         + ", yawAbsolute=" + yawAbsolute + "}";
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
   * Roll in global frame in degrees (set to NaN for invalid). 
   */
  @MavlinkMessageField(
      position = 2,
      unitSize = 4
  )
  public final float roll() {
    return roll;
  }

  /**
   * Pitch in global frame in degrees (set to NaN for invalid). 
   */
  @MavlinkMessageField(
      position = 3,
      unitSize = 4
  )
  public final float pitch() {
    return pitch;
  }

  /**
   * Yaw relative to vehicle in degrees (set to NaN for invalid). 
   */
  @MavlinkMessageField(
      position = 4,
      unitSize = 4
  )
  public final float yaw() {
    return yaw;
  }

  /**
   * Yaw in absolute frame in degrees, North is 0 (set to NaN for invalid). 
   */
  @MavlinkMessageField(
      position = 6,
      unitSize = 4,
      extension = true
  )
  public final float yawAbsolute() {
    return yawAbsolute;
  }

  public static class Builder {
    private long timeBootMs;

    private float roll;

    private float pitch;

    private float yaw;

    private float yawAbsolute;

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
     * Roll in global frame in degrees (set to NaN for invalid). 
     */
    @MavlinkMessageField(
        position = 2,
        unitSize = 4
    )
    public final Builder roll(float roll) {
      this.roll = roll;
      return this;
    }

    /**
     * Pitch in global frame in degrees (set to NaN for invalid). 
     */
    @MavlinkMessageField(
        position = 3,
        unitSize = 4
    )
    public final Builder pitch(float pitch) {
      this.pitch = pitch;
      return this;
    }

    /**
     * Yaw relative to vehicle in degrees (set to NaN for invalid). 
     */
    @MavlinkMessageField(
        position = 4,
        unitSize = 4
    )
    public final Builder yaw(float yaw) {
      this.yaw = yaw;
      return this;
    }

    /**
     * Yaw in absolute frame in degrees, North is 0 (set to NaN for invalid). 
     */
    @MavlinkMessageField(
        position = 6,
        unitSize = 4,
        extension = true
    )
    public final Builder yawAbsolute(float yawAbsolute) {
      this.yawAbsolute = yawAbsolute;
      return this;
    }

    public final MountOrientation build() {
      return new MountOrientation(timeBootMs, roll, pitch, yaw, yawAbsolute);
    }
  }
}
