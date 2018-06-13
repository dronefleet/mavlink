package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkMessage;
import io.dronefleet.mavlink.annotations.MavlinkMessageField;

/**
 * Metrics typically displayed on a HUD for fixed wing aircraft 
 */
@MavlinkMessage(
    id = 74,
    crc = 20
)
public final class VfrHud {
  private final float airspeed;

  private final float groundspeed;

  private final int heading;

  private final int throttle;

  private final float alt;

  private final float climb;

  private VfrHud(float airspeed, float groundspeed, int heading, int throttle, float alt,
      float climb) {
    this.airspeed = airspeed;
    this.groundspeed = groundspeed;
    this.heading = heading;
    this.throttle = throttle;
    this.alt = alt;
    this.climb = climb;
  }

  public static Builder builder() {
    return new Builder();
  }

  /**
   * Current airspeed in m/s 
   */
  @MavlinkMessageField(
      position = 1,
      length = 4
  )
  public final float airspeed() {
    return airspeed;
  }

  /**
   * Current ground speed in m/s 
   */
  @MavlinkMessageField(
      position = 2,
      length = 4
  )
  public final float groundspeed() {
    return groundspeed;
  }

  /**
   * Current heading in degrees, in compass units (0..360, 0=north) 
   */
  @MavlinkMessageField(
      position = 3,
      length = 2
  )
  public final int heading() {
    return heading;
  }

  /**
   * Current throttle setting in integer percent, 0 to 100 
   */
  @MavlinkMessageField(
      position = 4,
      length = 2
  )
  public final int throttle() {
    return throttle;
  }

  /**
   * Current altitude (MSL), in meters 
   */
  @MavlinkMessageField(
      position = 5,
      length = 4
  )
  public final float alt() {
    return alt;
  }

  /**
   * Current climb rate in meters/second 
   */
  @MavlinkMessageField(
      position = 6,
      length = 4
  )
  public final float climb() {
    return climb;
  }

  public class Builder {
    private float airspeed;

    private float groundspeed;

    private int heading;

    private int throttle;

    private float alt;

    private float climb;

    private Builder() {
    }

    /**
     * Current airspeed in m/s 
     */
    @MavlinkMessageField(
        position = 1,
        length = 4
    )
    public final Builder airspeed(float airspeed) {
      this.airspeed = airspeed;
      return this;
    }

    /**
     * Current ground speed in m/s 
     */
    @MavlinkMessageField(
        position = 2,
        length = 4
    )
    public final Builder groundspeed(float groundspeed) {
      this.groundspeed = groundspeed;
      return this;
    }

    /**
     * Current heading in degrees, in compass units (0..360, 0=north) 
     */
    @MavlinkMessageField(
        position = 3,
        length = 2
    )
    public final Builder heading(int heading) {
      this.heading = heading;
      return this;
    }

    /**
     * Current throttle setting in integer percent, 0 to 100 
     */
    @MavlinkMessageField(
        position = 4,
        length = 2
    )
    public final Builder throttle(int throttle) {
      this.throttle = throttle;
      return this;
    }

    /**
     * Current altitude (MSL), in meters 
     */
    @MavlinkMessageField(
        position = 5,
        length = 4
    )
    public final Builder alt(float alt) {
      this.alt = alt;
      return this;
    }

    /**
     * Current climb rate in meters/second 
     */
    @MavlinkMessageField(
        position = 6,
        length = 4
    )
    public final Builder climb(float climb) {
      this.climb = climb;
      return this;
    }

    public final VfrHud build() {
      return new VfrHud(airspeed, groundspeed, heading, throttle, alt, climb);
    }
  }
}
