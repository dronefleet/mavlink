package io.dronefleet.mavlink.ardupilotmega;

import io.dronefleet.mavlink.annotations.MavlinkMessage;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageField;
import java.lang.Override;
import java.lang.String;

/**
 * Wind estimation 
 */
@MavlinkMessage(
    id = 168,
    crc = 1
)
public final class Wind {
  /**
   * wind direction that wind is coming from (degrees) 
   */
  private final float direction;

  /**
   * wind speed in ground plane (m/s) 
   */
  private final float speed;

  /**
   * vertical wind speed (m/s) 
   */
  private final float speedZ;

  private Wind(float direction, float speed, float speedZ) {
    this.direction = direction;
    this.speed = speed;
    this.speedZ = speedZ;
  }

  @MavlinkMessageBuilder
  public static Builder builder() {
    return new Builder();
  }

  @Override
  public String toString() {
    return "Wind{direction=" + direction
         + ", speed=" + speed
         + ", speedZ=" + speedZ + "}";
  }

  /**
   * wind direction that wind is coming from (degrees) 
   */
  @MavlinkMessageField(
      position = 1,
      unitSize = 4
  )
  public final float direction() {
    return direction;
  }

  /**
   * wind speed in ground plane (m/s) 
   */
  @MavlinkMessageField(
      position = 2,
      unitSize = 4
  )
  public final float speed() {
    return speed;
  }

  /**
   * vertical wind speed (m/s) 
   */
  @MavlinkMessageField(
      position = 3,
      unitSize = 4
  )
  public final float speedZ() {
    return speedZ;
  }

  public static class Builder {
    private float direction;

    private float speed;

    private float speedZ;

    private Builder() {
    }

    /**
     * wind direction that wind is coming from (degrees) 
     */
    @MavlinkMessageField(
        position = 1,
        unitSize = 4
    )
    public final Builder direction(float direction) {
      this.direction = direction;
      return this;
    }

    /**
     * wind speed in ground plane (m/s) 
     */
    @MavlinkMessageField(
        position = 2,
        unitSize = 4
    )
    public final Builder speed(float speed) {
      this.speed = speed;
      return this;
    }

    /**
     * vertical wind speed (m/s) 
     */
    @MavlinkMessageField(
        position = 3,
        unitSize = 4
    )
    public final Builder speedZ(float speedZ) {
      this.speedZ = speedZ;
      return this;
    }

    public final Wind build() {
      return new Wind(direction, speed, speedZ);
    }
  }
}
