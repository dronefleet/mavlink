package io.dronefleet.mavlink.ardupilotmega;

import io.dronefleet.mavlink.annotations.MavlinkMessage;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageField;
import java.lang.Override;
import java.lang.String;

/**
 * 100 Hz gimbal torque command telemetry 
 */
@MavlinkMessage(
    id = 214,
    crc = 69
)
public final class GimbalTorqueCmdReport {
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

  /**
   * System ID 
   */
  private final int targetSystem;

  /**
   * Component ID 
   */
  private final int targetComponent;

  private GimbalTorqueCmdReport(int rlTorqueCmd, int elTorqueCmd, int azTorqueCmd, int targetSystem,
      int targetComponent) {
    this.rlTorqueCmd = rlTorqueCmd;
    this.elTorqueCmd = elTorqueCmd;
    this.azTorqueCmd = azTorqueCmd;
    this.targetSystem = targetSystem;
    this.targetComponent = targetComponent;
  }

  @MavlinkMessageBuilder
  public static Builder builder() {
    return new Builder();
  }

  @Override
  public String toString() {
    return "GimbalTorqueCmdReport{targetSystem=" + targetSystem
         + ", targetComponent=" + targetComponent
         + ", rlTorqueCmd=" + rlTorqueCmd
         + ", elTorqueCmd=" + elTorqueCmd
         + ", azTorqueCmd=" + azTorqueCmd + "}";
  }

  /**
   * Roll Torque Command 
   */
  @MavlinkMessageField(
      position = 3,
      unitSize = 2
  )
  public final int rlTorqueCmd() {
    return rlTorqueCmd;
  }

  /**
   * Elevation Torque Command 
   */
  @MavlinkMessageField(
      position = 4,
      unitSize = 2
  )
  public final int elTorqueCmd() {
    return elTorqueCmd;
  }

  /**
   * Azimuth Torque Command 
   */
  @MavlinkMessageField(
      position = 5,
      unitSize = 2
  )
  public final int azTorqueCmd() {
    return azTorqueCmd;
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
    private int rlTorqueCmd;

    private int elTorqueCmd;

    private int azTorqueCmd;

    private int targetSystem;

    private int targetComponent;

    private Builder() {
    }

    /**
     * Roll Torque Command 
     */
    @MavlinkMessageField(
        position = 3,
        unitSize = 2
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
        unitSize = 2
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
        unitSize = 2
    )
    public final Builder azTorqueCmd(int azTorqueCmd) {
      this.azTorqueCmd = azTorqueCmd;
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

    public final GimbalTorqueCmdReport build() {
      return new GimbalTorqueCmdReport(rlTorqueCmd, elTorqueCmd, azTorqueCmd, targetSystem, targetComponent);
    }
  }
}
