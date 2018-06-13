package io.dronefleet.mavlink.ardupilotmega;

import io.dronefleet.mavlink.annotations.MavlinkMessage;
import io.dronefleet.mavlink.annotations.MavlinkMessageField;

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
   * System ID 
   */
  private final int targetSystem;

  /**
   * Component ID 
   */
  private final int targetComponent;

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

  private SetMagOffsets(int targetSystem, int targetComponent, int magOfsX, int magOfsY,
      int magOfsZ) {
    this.targetSystem = targetSystem;
    this.targetComponent = targetComponent;
    this.magOfsX = magOfsX;
    this.magOfsY = magOfsY;
    this.magOfsZ = magOfsZ;
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
   * magnetometer X offset 
   */
  @MavlinkMessageField(
      position = 3,
      length = 2
  )
  public final int magOfsX() {
    return magOfsX;
  }

  /**
   * magnetometer Y offset 
   */
  @MavlinkMessageField(
      position = 4,
      length = 2
  )
  public final int magOfsY() {
    return magOfsY;
  }

  /**
   * magnetometer Z offset 
   */
  @MavlinkMessageField(
      position = 5,
      length = 2
  )
  public final int magOfsZ() {
    return magOfsZ;
  }

  public static class Builder {
    private int targetSystem;

    private int targetComponent;

    private int magOfsX;

    private int magOfsY;

    private int magOfsZ;

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
     * magnetometer X offset 
     */
    @MavlinkMessageField(
        position = 3,
        length = 2
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
        length = 2
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
        length = 2
    )
    public final Builder magOfsZ(int magOfsZ) {
      this.magOfsZ = magOfsZ;
      return this;
    }

    public final SetMagOffsets build() {
      return new SetMagOffsets(targetSystem, targetComponent, magOfsX, magOfsY, magOfsZ);
    }
  }
}
