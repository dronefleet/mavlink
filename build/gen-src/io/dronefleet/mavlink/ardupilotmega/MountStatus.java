package io.dronefleet.mavlink.ardupilotmega;

import io.dronefleet.mavlink.annotations.MavlinkMessage;
import io.dronefleet.mavlink.annotations.MavlinkMessageField;

/**
 * Message with some status from APM to GCS about camera or antenna mount 
 */
@MavlinkMessage(
    id = 158,
    crc = 134
)
public final class MountStatus {
  private final int targetSystem;

  private final int targetComponent;

  private final int pointingA;

  private final int pointingB;

  private final int pointingC;

  private MountStatus(int targetSystem, int targetComponent, int pointingA, int pointingB,
      int pointingC) {
    this.targetSystem = targetSystem;
    this.targetComponent = targetComponent;
    this.pointingA = pointingA;
    this.pointingB = pointingB;
    this.pointingC = pointingC;
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
   * pitch(deg*100) 
   */
  @MavlinkMessageField(
      position = 3,
      length = 4
  )
  public final int pointingA() {
    return pointingA;
  }

  /**
   * roll(deg*100) 
   */
  @MavlinkMessageField(
      position = 4,
      length = 4
  )
  public final int pointingB() {
    return pointingB;
  }

  /**
   * yaw(deg*100) 
   */
  @MavlinkMessageField(
      position = 5,
      length = 4
  )
  public final int pointingC() {
    return pointingC;
  }

  public class Builder {
    private int targetSystem;

    private int targetComponent;

    private int pointingA;

    private int pointingB;

    private int pointingC;

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
     * pitch(deg*100) 
     */
    @MavlinkMessageField(
        position = 3,
        length = 4
    )
    public final Builder pointingA(int pointingA) {
      this.pointingA = pointingA;
      return this;
    }

    /**
     * roll(deg*100) 
     */
    @MavlinkMessageField(
        position = 4,
        length = 4
    )
    public final Builder pointingB(int pointingB) {
      this.pointingB = pointingB;
      return this;
    }

    /**
     * yaw(deg*100) 
     */
    @MavlinkMessageField(
        position = 5,
        length = 4
    )
    public final Builder pointingC(int pointingC) {
      this.pointingC = pointingC;
      return this;
    }

    public final MountStatus build() {
      return new MountStatus(targetSystem, targetComponent, pointingA, pointingB, pointingC);
    }
  }
}
