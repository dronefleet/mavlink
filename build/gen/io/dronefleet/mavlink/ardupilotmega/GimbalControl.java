package io.dronefleet.mavlink.ardupilotmega;

import io.dronefleet.mavlink.annotations.MavlinkMessage;
import io.dronefleet.mavlink.annotations.MavlinkMessageField;

/**
 * Control message for rate gimbal 
 */
@MavlinkMessage(
    id = 201,
    crc = 205
)
public final class GimbalControl {
  private final int targetSystem;

  private final int targetComponent;

  private final float demandedRateX;

  private final float demandedRateY;

  private final float demandedRateZ;

  private GimbalControl(int targetSystem, int targetComponent, float demandedRateX,
      float demandedRateY, float demandedRateZ) {
    this.targetSystem = targetSystem;
    this.targetComponent = targetComponent;
    this.demandedRateX = demandedRateX;
    this.demandedRateY = demandedRateY;
    this.demandedRateZ = demandedRateZ;
  }

  public static Builder builder() {
    return new Builder();
  }

  /**
   * System ID 
   */
  @MavlinkMessageField(
      position = 1,
      length = 1
  )
  public final int targetSystem() {
    return targetSystem;
  }

  /**
   * Component ID 
   */
  @MavlinkMessageField(
      position = 2,
      length = 1
  )
  public final int targetComponent() {
    return targetComponent;
  }

  /**
   * Demanded angular rate X (rad/s) 
   */
  @MavlinkMessageField(
      position = 3,
      length = 4
  )
  public final float demandedRateX() {
    return demandedRateX;
  }

  /**
   * Demanded angular rate Y (rad/s) 
   */
  @MavlinkMessageField(
      position = 4,
      length = 4
  )
  public final float demandedRateY() {
    return demandedRateY;
  }

  /**
   * Demanded angular rate Z (rad/s) 
   */
  @MavlinkMessageField(
      position = 5,
      length = 4
  )
  public final float demandedRateZ() {
    return demandedRateZ;
  }

  public class Builder {
    private int targetSystem;

    private int targetComponent;

    private float demandedRateX;

    private float demandedRateY;

    private float demandedRateZ;

    private Builder() {
    }

    /**
     * System ID 
     */
    @MavlinkMessageField(
        position = 1,
        length = 1
    )
    public final Builder targetSystem(int targetSystem) {
      this.targetSystem = targetSystem;
      return this;
    }

    /**
     * Component ID 
     */
    @MavlinkMessageField(
        position = 2,
        length = 1
    )
    public final Builder targetComponent(int targetComponent) {
      this.targetComponent = targetComponent;
      return this;
    }

    /**
     * Demanded angular rate X (rad/s) 
     */
    @MavlinkMessageField(
        position = 3,
        length = 4
    )
    public final Builder demandedRateX(float demandedRateX) {
      this.demandedRateX = demandedRateX;
      return this;
    }

    /**
     * Demanded angular rate Y (rad/s) 
     */
    @MavlinkMessageField(
        position = 4,
        length = 4
    )
    public final Builder demandedRateY(float demandedRateY) {
      this.demandedRateY = demandedRateY;
      return this;
    }

    /**
     * Demanded angular rate Z (rad/s) 
     */
    @MavlinkMessageField(
        position = 5,
        length = 4
    )
    public final Builder demandedRateZ(float demandedRateZ) {
      this.demandedRateZ = demandedRateZ;
      return this;
    }

    public final GimbalControl build() {
      return new GimbalControl(targetSystem, targetComponent, demandedRateX, demandedRateY, demandedRateZ);
    }
  }
}
