package io.dronefleet.mavlink.ardupilotmega;

import io.dronefleet.mavlink.annotations.MavlinkMessage;
import io.dronefleet.mavlink.annotations.MavlinkMessageField;

/**
 * Wind estimation 
 */
@MavlinkMessage(
    id = 168,
    crc = 1
)
public final class Wind {
  private final float direction;

  private final float speed;

  private final float speedZ;

  private Wind(float direction, float speed, float speedZ) {
    this.direction = direction;
    this.speed = speed;
    this.speedZ = speedZ;
  }

  public static Builder builder() {
    return new Builder();
  }

  /**
   * wind direction that wind is coming from (degrees) 
   */
  @MavlinkMessageField(
      position = 1,
      length = 4
  )
  public final float direction() {
    return direction;
  }

  /**
   * wind speed in ground plane (m/s) 
   */
  @MavlinkMessageField(
      position = 2,
      length = 4
  )
  public final float speed() {
    return speed;
  }

  /**
   * vertical wind speed (m/s) 
   */
  @MavlinkMessageField(
      position = 3,
      length = 4
  )
  public final float speedZ() {
    return speedZ;
  }

  public class Builder {
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
        length = 4
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
        length = 4
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
        length = 4
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
