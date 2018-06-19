package io.dronefleet.mavlink.ardupilotmega;

import io.dronefleet.mavlink.annotations.MavlinkMessage;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageField;
import java.lang.Override;
import java.lang.String;

/**
 * Deprecated. Use MAV_CMD_PREFLIGHT_SET_SENSOR_OFFSETS instead. Set the magnetometer 
 * offsets 
 */
@MavlinkMessage(
    id = 151,
    crc = 219
)
public final class SetMagOffsets {
  /**
   * magnetometer X offset 
   */
  private final int magOfsX;

  /**
   * magnetometer Y offset 
   */
  private final int magOfsY;

  /**
   * magnetometer Z offset 
   */
  private final int magOfsZ;

  /**
   * System ID 
   */
  private final int targetSystem;

  /**
   * Component ID 
   */
  private final int targetComponent;

  private SetMagOffsets(int magOfsX, int magOfsY, int magOfsZ, int targetSystem,
      int targetComponent) {
    this.magOfsX = magOfsX;
    this.magOfsY = magOfsY;
    this.magOfsZ = magOfsZ;
    this.targetSystem = targetSystem;
    this.targetComponent = targetComponent;
  }

  @MavlinkMessageBuilder
  public static Builder builder() {
    return new Builder();
  }

  @Override
  public String toString() {
    return "SetMagOffsets{targetSystem=" + targetSystem
         + ", targetComponent=" + targetComponent
         + ", magOfsX=" + magOfsX
         + ", magOfsY=" + magOfsY
         + ", magOfsZ=" + magOfsZ + "}";
  }

  /**
   * magnetometer X offset 
   */
  @MavlinkMessageField(
      position = 3,
      unitSize = 2
  )
  public final int magOfsX() {
    return magOfsX;
  }

  /**
   * magnetometer Y offset 
   */
  @MavlinkMessageField(
      position = 4,
      unitSize = 2
  )
  public final int magOfsY() {
    return magOfsY;
  }

  /**
   * magnetometer Z offset 
   */
  @MavlinkMessageField(
      position = 5,
      unitSize = 2
  )
  public final int magOfsZ() {
    return magOfsZ;
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
    private int magOfsX;

    private int magOfsY;

    private int magOfsZ;

    private int targetSystem;

    private int targetComponent;

    private Builder() {
    }

    /**
     * magnetometer X offset 
     */
    @MavlinkMessageField(
        position = 3,
        unitSize = 2
    )
    public final Builder magOfsX(int magOfsX) {
      this.magOfsX = magOfsX;
      return this;
    }

    /**
     * magnetometer Y offset 
     */
    @MavlinkMessageField(
        position = 4,
        unitSize = 2
    )
    public final Builder magOfsY(int magOfsY) {
      this.magOfsY = magOfsY;
      return this;
    }

    /**
     * magnetometer Z offset 
     */
    @MavlinkMessageField(
        position = 5,
        unitSize = 2
    )
    public final Builder magOfsZ(int magOfsZ) {
      this.magOfsZ = magOfsZ;
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

    public final SetMagOffsets build() {
      return new SetMagOffsets(magOfsX, magOfsY, magOfsZ, targetSystem, targetComponent);
    }
  }
}
