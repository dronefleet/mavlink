package io.dronefleet.mavlink.slugs;

import io.dronefleet.mavlink.annotations.MavlinkMessage;
import io.dronefleet.mavlink.annotations.MavlinkMessageField;

/**
 * Mid Level commands sent from the GS to the autopilot. These are only sent when being operated in 
 * mid-level commands mode from the ground. 
 */
@MavlinkMessage(
    id = 180,
    crc = 146
)
public final class MidLvlCmds {
  private final int target;

  private final float hcommand;

  private final float ucommand;

  private final float rcommand;

  private MidLvlCmds(int target, float hcommand, float ucommand, float rcommand) {
    this.target = target;
    this.hcommand = hcommand;
    this.ucommand = ucommand;
    this.rcommand = rcommand;
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
   * Commanded Altitude 
   */
  @MavlinkMessageField(
      position = 2,
      length = 4
  )
  public final float hcommand() {
    return hcommand;
  }

  /**
   * Commanded Airspeed 
   */
  @MavlinkMessageField(
      position = 3,
      length = 4
  )
  public final float ucommand() {
    return ucommand;
  }

  /**
   * Commanded Turnrate 
   */
  @MavlinkMessageField(
      position = 4,
      length = 4
  )
  public final float rcommand() {
    return rcommand;
  }

  public class Builder {
    private int target;

    private float hcommand;

    private float ucommand;

    private float rcommand;

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
     * Commanded Altitude 
     */
    @MavlinkMessageField(
        position = 2,
        length = 4
    )
    public final Builder hcommand(float hcommand) {
      this.hcommand = hcommand;
      return this;
    }

    /**
     * Commanded Airspeed 
     */
    @MavlinkMessageField(
        position = 3,
        length = 4
    )
    public final Builder ucommand(float ucommand) {
      this.ucommand = ucommand;
      return this;
    }

    /**
     * Commanded Turnrate 
     */
    @MavlinkMessageField(
        position = 4,
        length = 4
    )
    public final Builder rcommand(float rcommand) {
      this.rcommand = rcommand;
      return this;
    }

    public final MidLvlCmds build() {
      return new MidLvlCmds(target, hcommand, ucommand, rcommand);
    }
  }
}
