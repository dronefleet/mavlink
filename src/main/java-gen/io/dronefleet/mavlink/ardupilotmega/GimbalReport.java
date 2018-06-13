package io.dronefleet.mavlink.ardupilotmega;

import io.dronefleet.mavlink.annotations.MavlinkMessage;
import io.dronefleet.mavlink.annotations.MavlinkMessageField;

/**
 * 3 axis gimbal mesuraments 
 */
@MavlinkMessage(
    id = 200,
    crc = 134
)
public final class GimbalReport {
  /**
   * System ID 
   */
  private final int targetSystem;

  /**
   * Component ID 
   */
  private final int targetComponent;

  /**
   * Time since last update (seconds) 
   */
  private final float deltaTime;

  /**
   * Delta angle X (radians) 
   */
  private final float deltaAngleX;

  /**
   * Delta angle Y (radians) 
   */
  private final float deltaAngleY;

  /**
   * Delta angle X (radians) 
   */
  private final float deltaAngleZ;

  /**
   * Delta velocity X (m/s) 
   */
  private final float deltaVelocityX;

  /**
   * Delta velocity Y (m/s) 
   */
  private final float deltaVelocityY;

  /**
   * Delta velocity Z (m/s) 
   */
  private final float deltaVelocityZ;

  /**
   * Joint ROLL (radians) 
   */
  private final float jointRoll;

  /**
   * Joint EL (radians) 
   */
  private final float jointEl;

  /**
   * Joint AZ (radians) 
   */
  private final float jointAz;

  private GimbalReport(int targetSystem, int targetComponent, float deltaTime, float deltaAngleX,
      float deltaAngleY, float deltaAngleZ, float deltaVelocityX, float deltaVelocityY,
      float deltaVelocityZ, float jointRoll, float jointEl, float jointAz) {
    this.targetSystem = targetSystem;
    this.targetComponent = targetComponent;
    this.deltaTime = deltaTime;
    this.deltaAngleX = deltaAngleX;
    this.deltaAngleY = deltaAngleY;
    this.deltaAngleZ = deltaAngleZ;
    this.deltaVelocityX = deltaVelocityX;
    this.deltaVelocityY = deltaVelocityY;
    this.deltaVelocityZ = deltaVelocityZ;
    this.jointRoll = jointRoll;
    this.jointEl = jointEl;
    this.jointAz = jointAz;
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
   * Time since last update (seconds) 
   */
  @MavlinkMessageField(
      position = 3,
      length = 4
  )
  public final float deltaTime() {
    return deltaTime;
  }

  /**
   * Delta angle X (radians) 
   */
  @MavlinkMessageField(
      position = 4,
      length = 4
  )
  public final float deltaAngleX() {
    return deltaAngleX;
  }

  /**
   * Delta angle Y (radians) 
   */
  @MavlinkMessageField(
      position = 5,
      length = 4
  )
  public final float deltaAngleY() {
    return deltaAngleY;
  }

  /**
   * Delta angle X (radians) 
   */
  @MavlinkMessageField(
      position = 6,
      length = 4
  )
  public final float deltaAngleZ() {
    return deltaAngleZ;
  }

  /**
   * Delta velocity X (m/s) 
   */
  @MavlinkMessageField(
      position = 7,
      length = 4
  )
  public final float deltaVelocityX() {
    return deltaVelocityX;
  }

  /**
   * Delta velocity Y (m/s) 
   */
  @MavlinkMessageField(
      position = 8,
      length = 4
  )
  public final float deltaVelocityY() {
    return deltaVelocityY;
  }

  /**
   * Delta velocity Z (m/s) 
   */
  @MavlinkMessageField(
      position = 9,
      length = 4
  )
  public final float deltaVelocityZ() {
    return deltaVelocityZ;
  }

  /**
   * Joint ROLL (radians) 
   */
  @MavlinkMessageField(
      position = 10,
      length = 4
  )
  public final float jointRoll() {
    return jointRoll;
  }

  /**
   * Joint EL (radians) 
   */
  @MavlinkMessageField(
      position = 11,
      length = 4
  )
  public final float jointEl() {
    return jointEl;
  }

  /**
   * Joint AZ (radians) 
   */
  @MavlinkMessageField(
      position = 12,
      length = 4
  )
  public final float jointAz() {
    return jointAz;
  }

  public static class Builder {
    private int targetSystem;

    private int targetComponent;

    private float deltaTime;

    private float deltaAngleX;

    private float deltaAngleY;

    private float deltaAngleZ;

    private float deltaVelocityX;

    private float deltaVelocityY;

    private float deltaVelocityZ;

    private float jointRoll;

    private float jointEl;

    private float jointAz;

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
     * Time since last update (seconds) 
     */
    @MavlinkMessageField(
        position = 3,
        length = 4
    )
    public final Builder deltaTime(float deltaTime) {
      this.deltaTime = deltaTime;
      return this;
    }

    /**
     * Delta angle X (radians) 
     */
    @MavlinkMessageField(
        position = 4,
        length = 4
    )
    public final Builder deltaAngleX(float deltaAngleX) {
      this.deltaAngleX = deltaAngleX;
      return this;
    }

    /**
     * Delta angle Y (radians) 
     */
    @MavlinkMessageField(
        position = 5,
        length = 4
    )
    public final Builder deltaAngleY(float deltaAngleY) {
      this.deltaAngleY = deltaAngleY;
      return this;
    }

    /**
     * Delta angle X (radians) 
     */
    @MavlinkMessageField(
        position = 6,
        length = 4
    )
    public final Builder deltaAngleZ(float deltaAngleZ) {
      this.deltaAngleZ = deltaAngleZ;
      return this;
    }

    /**
     * Delta velocity X (m/s) 
     */
    @MavlinkMessageField(
        position = 7,
        length = 4
    )
    public final Builder deltaVelocityX(float deltaVelocityX) {
      this.deltaVelocityX = deltaVelocityX;
      return this;
    }

    /**
     * Delta velocity Y (m/s) 
     */
    @MavlinkMessageField(
        position = 8,
        length = 4
    )
    public final Builder deltaVelocityY(float deltaVelocityY) {
      this.deltaVelocityY = deltaVelocityY;
      return this;
    }

    /**
     * Delta velocity Z (m/s) 
     */
    @MavlinkMessageField(
        position = 9,
        length = 4
    )
    public final Builder deltaVelocityZ(float deltaVelocityZ) {
      this.deltaVelocityZ = deltaVelocityZ;
      return this;
    }

    /**
     * Joint ROLL (radians) 
     */
    @MavlinkMessageField(
        position = 10,
        length = 4
    )
    public final Builder jointRoll(float jointRoll) {
      this.jointRoll = jointRoll;
      return this;
    }

    /**
     * Joint EL (radians) 
     */
    @MavlinkMessageField(
        position = 11,
        length = 4
    )
    public final Builder jointEl(float jointEl) {
      this.jointEl = jointEl;
      return this;
    }

    /**
     * Joint AZ (radians) 
     */
    @MavlinkMessageField(
        position = 12,
        length = 4
    )
    public final Builder jointAz(float jointAz) {
      this.jointAz = jointAz;
      return this;
    }

    public final GimbalReport build() {
      return new GimbalReport(targetSystem, targetComponent, deltaTime, deltaAngleX, deltaAngleY, deltaAngleZ, deltaVelocityX, deltaVelocityY, deltaVelocityZ, jointRoll, jointEl, jointAz);
    }
  }
}
