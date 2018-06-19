package io.dronefleet.mavlink.ardupilotmega;

import io.dronefleet.mavlink.annotations.MavlinkMessage;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageField;
import io.dronefleet.mavlink.common.MavMountMode;
import java.lang.Override;
import java.lang.String;

/**
 * Message to configure a camera mount, directional antenna, etc. 
 */
@MavlinkMessage(
    id = 156,
    crc = 19
)
public final class MountConfigure {
  /**
   * System ID 
   */
  private final int targetSystem;

  /**
   * Component ID 
   */
  private final int targetComponent;

  /**
   * mount operating mode (see {@link io.dronefleet.mavlink.common.MavMountMode MavMountMode} enum) 
   */
  private final MavMountMode mountMode;

  /**
   * (1 = yes, 0 = no) 
   */
  private final int stabRoll;

  /**
   * (1 = yes, 0 = no) 
   */
  private final int stabPitch;

  /**
   * (1 = yes, 0 = no) 
   */
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

  @MavlinkMessageBuilder
  public static Builder builder() {
    return new Builder();
  }

  @Override
  public String toString() {
    return "MountConfigure{targetSystem=" + targetSystem
         + ", targetComponent=" + targetComponent
         + ", mountMode=" + mountMode
         + ", stabRoll=" + stabRoll
         + ", stabPitch=" + stabPitch
         + ", stabYaw=" + stabYaw + "}";
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

  /**
   * mount operating mode (see {@link io.dronefleet.mavlink.common.MavMountMode MavMountMode} enum) 
   */
  @MavlinkMessageField(
      position = 3,
      unitSize = 1
  )
  public final MavMountMode mountMode() {
    return mountMode;
  }

  /**
   * (1 = yes, 0 = no) 
   */
  @MavlinkMessageField(
      position = 4,
      unitSize = 1
  )
  public final int stabRoll() {
    return stabRoll;
  }

  /**
   * (1 = yes, 0 = no) 
   */
  @MavlinkMessageField(
      position = 5,
      unitSize = 1
  )
  public final int stabPitch() {
    return stabPitch;
  }

  /**
   * (1 = yes, 0 = no) 
   */
  @MavlinkMessageField(
      position = 6,
      unitSize = 1
  )
  public final int stabYaw() {
    return stabYaw;
  }

  public static class Builder {
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

    /**
     * mount operating mode (see {@link io.dronefleet.mavlink.common.MavMountMode MavMountMode} enum) 
     */
    @MavlinkMessageField(
        position = 3,
        unitSize = 1
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
        unitSize = 1
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
        unitSize = 1
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
        unitSize = 1
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
