package io.dronefleet.mavlink.matrixpilot;

import io.dronefleet.mavlink.annotations.MavlinkMessage;
import io.dronefleet.mavlink.annotations.MavlinkMessageField;

/**
 * Backwards compatible version of SERIAL_UDB_EXTRA F18 format 
 */
@MavlinkMessage(
    id = 184,
    crc = 41
)
public final class SerialUdbExtraF18 {
  private final float angleOfAttackNormal;

  private final float angleOfAttackInverted;

  private final float elevatorTrimNormal;

  private final float elevatorTrimInverted;

  private final float referenceSpeed;

  private SerialUdbExtraF18(float angleOfAttackNormal, float angleOfAttackInverted,
      float elevatorTrimNormal, float elevatorTrimInverted, float referenceSpeed) {
    this.angleOfAttackNormal = angleOfAttackNormal;
    this.angleOfAttackInverted = angleOfAttackInverted;
    this.elevatorTrimNormal = elevatorTrimNormal;
    this.elevatorTrimInverted = elevatorTrimInverted;
    this.referenceSpeed = referenceSpeed;
  }

  public static Builder builder() {
    return new Builder();
  }

  /**
   * SUE Angle of Attack Normal 
   */
  @MavlinkMessageField(
      position = 1,
      length = 4
  )
  public final float angleOfAttackNormal() {
    return angleOfAttackNormal;
  }

  /**
   * SUE Angle of Attack Inverted 
   */
  @MavlinkMessageField(
      position = 2,
      length = 4
  )
  public final float angleOfAttackInverted() {
    return angleOfAttackInverted;
  }

  /**
   * SUE Elevator Trim Normal 
   */
  @MavlinkMessageField(
      position = 3,
      length = 4
  )
  public final float elevatorTrimNormal() {
    return elevatorTrimNormal;
  }

  /**
   * SUE Elevator Trim Inverted 
   */
  @MavlinkMessageField(
      position = 4,
      length = 4
  )
  public final float elevatorTrimInverted() {
    return elevatorTrimInverted;
  }

  /**
   * SUE reference_speed 
   */
  @MavlinkMessageField(
      position = 5,
      length = 4
  )
  public final float referenceSpeed() {
    return referenceSpeed;
  }

  public class Builder {
    private float angleOfAttackNormal;

    private float angleOfAttackInverted;

    private float elevatorTrimNormal;

    private float elevatorTrimInverted;

    private float referenceSpeed;

    private Builder() {
    }

    /**
     * SUE Angle of Attack Normal 
     */
    @MavlinkMessageField(
        position = 1,
        length = 4
    )
    public final Builder angleOfAttackNormal(float angleOfAttackNormal) {
      this.angleOfAttackNormal = angleOfAttackNormal;
      return this;
    }

    /**
     * SUE Angle of Attack Inverted 
     */
    @MavlinkMessageField(
        position = 2,
        length = 4
    )
    public final Builder angleOfAttackInverted(float angleOfAttackInverted) {
      this.angleOfAttackInverted = angleOfAttackInverted;
      return this;
    }

    /**
     * SUE Elevator Trim Normal 
     */
    @MavlinkMessageField(
        position = 3,
        length = 4
    )
    public final Builder elevatorTrimNormal(float elevatorTrimNormal) {
      this.elevatorTrimNormal = elevatorTrimNormal;
      return this;
    }

    /**
     * SUE Elevator Trim Inverted 
     */
    @MavlinkMessageField(
        position = 4,
        length = 4
    )
    public final Builder elevatorTrimInverted(float elevatorTrimInverted) {
      this.elevatorTrimInverted = elevatorTrimInverted;
      return this;
    }

    /**
     * SUE reference_speed 
     */
    @MavlinkMessageField(
        position = 5,
        length = 4
    )
    public final Builder referenceSpeed(float referenceSpeed) {
      this.referenceSpeed = referenceSpeed;
      return this;
    }

    public final SerialUdbExtraF18 build() {
      return new SerialUdbExtraF18(angleOfAttackNormal, angleOfAttackInverted, elevatorTrimNormal, elevatorTrimInverted, referenceSpeed);
    }
  }
}
