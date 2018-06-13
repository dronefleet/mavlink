package io.dronefleet.mavlink.slugs;

import io.dronefleet.mavlink.annotations.MavlinkMessage;
import io.dronefleet.mavlink.annotations.MavlinkMessageField;

/**
 * Control for surface; pending and order to origin. 
 */
@MavlinkMessage(
    id = 185,
    crc = 113
)
public final class ControlSurface {
  /**
   * The system setting the commands 
   */
  private final int target;

  /**
   * ID control surface send 0: throttle 1: aileron 2: elevator 3: rudder 
   */
  private final int idsurface;

  /**
   * Pending 
   */
  private final float mcontrol;

  /**
   * Order to origin 
   */
  private final float bcontrol;

  private ControlSurface(int target, int idsurface, float mcontrol, float bcontrol) {
    this.target = target;
    this.idsurface = idsurface;
    this.mcontrol = mcontrol;
    this.bcontrol = bcontrol;
  }

  public static Builder builder() {
    return new Builder();
  }

  /**
   * The system setting the commands 
   */
  @MavlinkMessageField(
      position = 1,
      length = 1
  )
  public final int target() {
    return target;
  }

  /**
   * ID control surface send 0: throttle 1: aileron 2: elevator 3: rudder 
   */
  @MavlinkMessageField(
      position = 2,
      length = 1
  )
  public final int idsurface() {
    return idsurface;
  }

  /**
   * Pending 
   */
  @MavlinkMessageField(
      position = 3,
      length = 4
  )
  public final float mcontrol() {
    return mcontrol;
  }

  /**
   * Order to origin 
   */
  @MavlinkMessageField(
      position = 4,
      length = 4
  )
  public final float bcontrol() {
    return bcontrol;
  }

  public static class Builder {
    private int target;

    private int idsurface;

    private float mcontrol;

    private float bcontrol;

    private Builder() {
    }

    /**
     * The system setting the commands 
     */
    @MavlinkMessageField(
        position = 1,
        length = 1
    )
    public final Builder target(int target) {
      this.target = target;
      return this;
    }

    /**
     * ID control surface send 0: throttle 1: aileron 2: elevator 3: rudder 
     */
    @MavlinkMessageField(
        position = 2,
        length = 1
    )
    public final Builder idsurface(int idsurface) {
      this.idsurface = idsurface;
      return this;
    }

    /**
     * Pending 
     */
    @MavlinkMessageField(
        position = 3,
        length = 4
    )
    public final Builder mcontrol(float mcontrol) {
      this.mcontrol = mcontrol;
      return this;
    }

    /**
     * Order to origin 
     */
    @MavlinkMessageField(
        position = 4,
        length = 4
    )
    public final Builder bcontrol(float bcontrol) {
      this.bcontrol = bcontrol;
      return this;
    }

    public final ControlSurface build() {
      return new ControlSurface(target, idsurface, mcontrol, bcontrol);
    }
  }
}
