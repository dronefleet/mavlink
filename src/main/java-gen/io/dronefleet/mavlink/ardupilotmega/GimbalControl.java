package io.dronefleet.mavlink.ardupilotmega;

import io.dronefleet.mavlink.annotations.MavlinkMessage;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageField;
import java.lang.Override;
import java.lang.String;

/**
 * Control message for rate gimbal 
 */
@MavlinkMessage(
    id = 201,
    crc = 205
)
public final class GimbalControl {
  /**
   * Demanded angular rate X (rad/s) 
   */
  private final float demandedRateX;

  /**
   * Demanded angular rate Y (rad/s) 
   */
  private final float demandedRateY;

  /**
   * Demanded angular rate Z (rad/s) 
   */
  private final float demandedRateZ;

  /**
   * System ID 
   */
  private final int targetSystem;

  /**
   * Component ID 
   */
  private final int targetComponent;

  private GimbalControl(float demandedRateX, float demandedRateY, float demandedRateZ,
      int targetSystem, int targetComponent) {
    this.demandedRateX = demandedRateX;
    this.demandedRateY = demandedRateY;
    this.demandedRateZ = demandedRateZ;
    this.targetSystem = targetSystem;
    this.targetComponent = targetComponent;
  }

  @MavlinkMessageBuilder
  public static Builder builder() {
    return new Builder();
  }

  @Override
  public String toString() {
    return "GimbalControl{targetSystem=" + targetSystem
         + ", targetComponent=" + targetComponent
         + ", demandedRateX=" + demandedRateX
         + ", demandedRateY=" + demandedRateY
         + ", demandedRateZ=" + demandedRateZ + "}";
  }

  /**
   * Demanded angular rate X (rad/s) 
   */
  @MavlinkMessageField(
      position = 3,
      unitSize = 4
  )
  public final float demandedRateX() {
    return demandedRateX;
  }

  /**
   * Demanded angular rate Y (rad/s) 
   */
  @MavlinkMessageField(
      position = 4,
      unitSize = 4
  )
  public final float demandedRateY() {
    return demandedRateY;
  }

  /**
   * Demanded angular rate Z (rad/s) 
   */
  @MavlinkMessageField(
      position = 5,
      unitSize = 4
  )
  public final float demandedRateZ() {
    return demandedRateZ;
  }

  /**
   * System ID 
   */
  @MavlinkMessageField(
      position = 1,
      unitSize = 1
  )
  public final int targetSystem() {
    return targetSystem;
  }

  /**
   * Component ID 
   */
  @MavlinkMessageField(
      position = 2,
      unitSize = 1
  )
  public final int targetComponent() {
    return targetComponent;
  }

  public static class Builder {
    private float demandedRateX;

    private float demandedRateY;

    private float demandedRateZ;

    private int targetSystem;

    private int targetComponent;

    private Builder() {
    }

    /**
     * Demanded angular rate X (rad/s) 
     */
    @MavlinkMessageField(
        position = 3,
        unitSize = 4
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
        unitSize = 4
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
        unitSize = 4
    )
    public final Builder demandedRateZ(float demandedRateZ) {
      this.demandedRateZ = demandedRateZ;
      return this;
    }

    /**
     * System ID 
     */
    @MavlinkMessageField(
        position = 1,
        unitSize = 1
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
        unitSize = 1
    )
    public final Builder targetComponent(int targetComponent) {
      this.targetComponent = targetComponent;
      return this;
    }

    public final GimbalControl build() {
      return new GimbalControl(demandedRateX, demandedRateY, demandedRateZ, targetSystem, targetComponent);
    }
  }
}
