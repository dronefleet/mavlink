package io.dronefleet.mavlink.ardupilotmega;

import io.dronefleet.mavlink.annotations.MavlinkMessage;
import io.dronefleet.mavlink.annotations.MavlinkMessageField;

/**
 * Message to control a camera mount, directional antenna, etc. 
 */
@MavlinkMessage(
    id = 157,
    crc = 21
)
public final class MountControl {
  private final int targetSystem;

  private final int targetComponent;

  private final int inputA;

  private final int inputB;

  private final int inputC;

  private final int savePosition;

  private MountControl(int targetSystem, int targetComponent, int inputA, int inputB, int inputC,
      int savePosition) {
    this.targetSystem = targetSystem;
    this.targetComponent = targetComponent;
    this.inputA = inputA;
    this.inputB = inputB;
    this.inputC = inputC;
    this.savePosition = savePosition;
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
   * pitch(deg*100) or lat, depending on mount mode 
   */
  @MavlinkMessageField(
      position = 3,
      length = 4
  )
  public final int inputA() {
    return inputA;
  }

  /**
   * roll(deg*100) or lon depending on mount mode 
   */
  @MavlinkMessageField(
      position = 4,
      length = 4
  )
  public final int inputB() {
    return inputB;
  }

  /**
   * yaw(deg*100) or alt (in cm) depending on mount mode 
   */
  @MavlinkMessageField(
      position = 5,
      length = 4
  )
  public final int inputC() {
    return inputC;
  }

  /**
   * if "1" it will save current trimmed position on EEPROM (just valid for NEUTRAL and LANDING) 
   */
  @MavlinkMessageField(
      position = 6,
      length = 1
  )
  public final int savePosition() {
    return savePosition;
  }

  public class Builder {
    private int targetSystem;

    private int targetComponent;

    private int inputA;

    private int inputB;

    private int inputC;

    private int savePosition;

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
     * pitch(deg*100) or lat, depending on mount mode 
     */
    @MavlinkMessageField(
        position = 3,
        length = 4
    )
    public final Builder inputA(int inputA) {
      this.inputA = inputA;
      return this;
    }

    /**
     * roll(deg*100) or lon depending on mount mode 
     */
    @MavlinkMessageField(
        position = 4,
        length = 4
    )
    public final Builder inputB(int inputB) {
      this.inputB = inputB;
      return this;
    }

    /**
     * yaw(deg*100) or alt (in cm) depending on mount mode 
     */
    @MavlinkMessageField(
        position = 5,
        length = 4
    )
    public final Builder inputC(int inputC) {
      this.inputC = inputC;
      return this;
    }

    /**
     * if "1" it will save current trimmed position on EEPROM (just valid for NEUTRAL and LANDING) 
     */
    @MavlinkMessageField(
        position = 6,
        length = 1
    )
    public final Builder savePosition(int savePosition) {
      this.savePosition = savePosition;
      return this;
    }

    public final MountControl build() {
      return new MountControl(targetSystem, targetComponent, inputA, inputB, inputC, savePosition);
    }
  }
}
