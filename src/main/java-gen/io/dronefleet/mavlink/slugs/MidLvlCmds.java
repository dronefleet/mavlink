package io.dronefleet.mavlink.slugs;

import io.dronefleet.mavlink.annotations.MavlinkMessage;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageField;
import java.lang.Override;
import java.lang.String;

/**
 * Mid Level commands sent from the GS to the autopilot. These are only sent when being operated in 
 * mid-level commands mode from the ground. 
 */
@MavlinkMessage(
    id = 180,
    crc = 146
)
public final class MidLvlCmds {
  /**
   * Commanded Altitude 
   */
  private final float hcommand;

  /**
   * Commanded Airspeed 
   */
  private final float ucommand;

  /**
   * Commanded Turnrate 
   */
  private final float rcommand;

  /**
   * The system setting the commands 
   */
  private final int target;

  private MidLvlCmds(float hcommand, float ucommand, float rcommand, int target) {
    this.hcommand = hcommand;
    this.ucommand = ucommand;
    this.rcommand = rcommand;
    this.target = target;
  }

  @MavlinkMessageBuilder
  public static Builder builder() {
    return new Builder();
  }

  @Override
  public String toString() {
    return "MidLvlCmds{target=" + target
         + ", hcommand=" + hcommand
         + ", ucommand=" + ucommand
         + ", rcommand=" + rcommand + "}";
  }

  /**
   * Commanded Altitude 
   */
  @MavlinkMessageField(
      position = 2,
      unitSize = 4
  )
  public final float hcommand() {
    return hcommand;
  }

  /**
   * Commanded Airspeed 
   */
  @MavlinkMessageField(
      position = 3,
      unitSize = 4
  )
  public final float ucommand() {
    return ucommand;
  }

  /**
   * Commanded Turnrate 
   */
  @MavlinkMessageField(
      position = 4,
      unitSize = 4
  )
  public final float rcommand() {
    return rcommand;
  }

  /**
   * The system setting the commands 
   */
  @MavlinkMessageField(
      position = 1,
      unitSize = 1
  )
  public final int target() {
    return target;
  }

  public static class Builder {
    private float hcommand;

    private float ucommand;

    private float rcommand;

    private int target;

    private Builder() {
    }

    /**
     * Commanded Altitude 
     */
    @MavlinkMessageField(
        position = 2,
        unitSize = 4
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
        unitSize = 4
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
        unitSize = 4
    )
    public final Builder rcommand(float rcommand) {
      this.rcommand = rcommand;
      return this;
    }

    /**
     * The system setting the commands 
     */
    @MavlinkMessageField(
        position = 1,
        unitSize = 1
    )
    public final Builder target(int target) {
      this.target = target;
      return this;
    }

    public final MidLvlCmds build() {
      return new MidLvlCmds(hcommand, ucommand, rcommand, target);
    }
  }
}
