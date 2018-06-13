package io.dronefleet.mavlink.ardupilotmega;

import io.dronefleet.mavlink.annotations.MavlinkMessage;
import io.dronefleet.mavlink.annotations.MavlinkMessageField;
import io.dronefleet.mavlink.common.MavMountMode;

/**
 * Message to configure a camera mount, directional antenna, etc. 
 */
@MavlinkMessage(
    id = 156,
    crc = 19
)
public final class MountConfigure {
  private final int targetSystem;

  private final int targetComponent;

  private final MavMountMode mountMode;

  private final int stabRoll;

  private final int stabPitch;

  private final int stabYaw;

  private MountConfigure(int targetSystem, int targetComponent, MavMountMode mountMode,
      int stabRoll, int stabPitch, int stabYaw) {
    this.targetSystem = targetSystem;
    this.targetComponent = targetComponent;
    this.mountMode = mountMode;
    this.stabRoll = stabRoll;
    this.stabPitch = stabPitch;
    this.stabYaw = stabYaw;
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
   * mount operating mode (see MAV_MOUNT_MODE enum) 
   */
  @MavlinkMessageField(
      position = 3,
      length = 1
  )
  public final MavMountMode mountMode() {
    return mountMode;
  }

  /**
   * (1 = yes, 0 = no) 
   */
  @MavlinkMessageField(
      position = 4,
      length = 1
  )
  public final int stabRoll() {
    return stabRoll;
  }

  /**
   * (1 = yes, 0 = no) 
   */
  @MavlinkMessageField(
      position = 5,
      length = 1
  )
  public final int stabPitch() {
    return stabPitch;
  }

  /**
   * (1 = yes, 0 = no) 
   */
  @MavlinkMessageField(
      position = 6,
      length = 1
  )
  public final int stabYaw() {
    return stabYaw;
  }

  public class Builder {
    private int targetSystem;

    private int targetComponent;

    private MavMountMode mountMode;

    private int stabRoll;

    private int stabPitch;

    private int stabYaw;

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
     * mount operating mode (see MAV_MOUNT_MODE enum) 
     */
    @MavlinkMessageField(
        position = 3,
        length = 1
    )
    public final Builder mountMode(MavMountMode mountMode) {
      this.mountMode = mountMode;
      return this;
    }

    /**
     * (1 = yes, 0 = no) 
     */
    @MavlinkMessageField(
        position = 4,
        length = 1
    )
    public final Builder stabRoll(int stabRoll) {
      this.stabRoll = stabRoll;
      return this;
    }

    /**
     * (1 = yes, 0 = no) 
     */
    @MavlinkMessageField(
        position = 5,
        length = 1
    )
    public final Builder stabPitch(int stabPitch) {
      this.stabPitch = stabPitch;
      return this;
    }

    /**
     * (1 = yes, 0 = no) 
     */
    @MavlinkMessageField(
        position = 6,
        length = 1
    )
    public final Builder stabYaw(int stabYaw) {
      this.stabYaw = stabYaw;
      return this;
    }

    public final MountConfigure build() {
      return new MountConfigure(targetSystem, targetComponent, mountMode, stabRoll, stabPitch, stabYaw);
    }
  }
}
