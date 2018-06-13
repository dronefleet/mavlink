package io.dronefleet.mavlink.ardupilotmega;

import io.dronefleet.mavlink.annotations.MavlinkMessage;
import io.dronefleet.mavlink.annotations.MavlinkMessageField;

/**
 * 100 Hz gimbal torque command telemetry 
 */
@MavlinkMessage(
    id = 214,
    crc = 69
)
public final class GimbalTorqueCmdReport {
  /**
   * System ID 
   */
  private final int targetSystem;

  /**
   * Component ID 
   */
  private final int targetComponent;

  /**
   * Roll Torque Command 
   */
  private final int rlTorqueCmd;

  /**
   * Elevation Torque Command 
   */
  private final int elTorqueCmd;

  /**
   * Azimuth Torque Command 
   */
  private final int azTorqueCmd;

  private GimbalTorqueCmdReport(int targetSystem, int targetComponent, int rlTorqueCmd,
      int elTorqueCmd, int azTorqueCmd) {
    this.targetSystem = targetSystem;
    this.targetComponent = targetComponent;
    this.rlTorqueCmd = rlTorqueCmd;
    this.elTorqueCmd = elTorqueCmd;
    this.azTorqueCmd = azTorqueCmd;
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
   * Roll Torque Command 
   */
  @MavlinkMessageField(
      position = 3,
      length = 2
  )
  public final int rlTorqueCmd() {
    return rlTorqueCmd;
  }

  /**
   * Elevation Torque Command 
   */
  @MavlinkMessageField(
      position = 4,
      length = 2
  )
  public final int elTorqueCmd() {
    return elTorqueCmd;
  }

  /**
   * Azimuth Torque Command 
   */
  @MavlinkMessageField(
      position = 5,
      length = 2
  )
  public final int azTorqueCmd() {
    return azTorqueCmd;
  }

  public static class Builder {
    private int targetSystem;

    private int targetComponent;

    private int rlTorqueCmd;

    private int elTorqueCmd;

    private int azTorqueCmd;

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
     * Roll Torque Command 
     */
    @MavlinkMessageField(
        position = 3,
        length = 2
    )
    public final Builder rlTorqueCmd(int rlTorqueCmd) {
      this.rlTorqueCmd = rlTorqueCmd;
      return this;
    }

    /**
     * Elevation Torque Command 
     */
    @MavlinkMessageField(
        position = 4,
        length = 2
    )
    public final Builder elTorqueCmd(int elTorqueCmd) {
      this.elTorqueCmd = elTorqueCmd;
      return this;
    }

    /**
     * Azimuth Torque Command 
     */
    @MavlinkMessageField(
        position = 5,
        length = 2
    )
    public final Builder azTorqueCmd(int azTorqueCmd) {
      this.azTorqueCmd = azTorqueCmd;
      return this;
    }

    public final GimbalTorqueCmdReport build() {
      return new GimbalTorqueCmdReport(targetSystem, targetComponent, rlTorqueCmd, elTorqueCmd, azTorqueCmd);
    }
  }
}
