package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import java.lang.Override;
import java.lang.String;

/**
 * Metrics typically displayed on a HUD for fixed wing aircraft 
 */
@MavlinkMessageInfo(
    id = 74,
    crc = 20
)
public final class VfrHud {
  /**
   * Current airspeed in m/s 
   */
  private final float airspeed;

  /**
   * Current ground speed in m/s 
   */
  private final float groundspeed;

  /**
   * Current altitude (MSL), in meters 
   */
  private final float alt;

  /**
   * Current climb rate in meters/second 
   */
  private final float climb;

  /**
   * Current heading in degrees, in compass units (0..360, 0=north) 
   */
  private final int heading;

  /**
   * Current throttle setting in integer percent, 0 to 100 
   */
  private final int throttle;

  private VfrHud(float airspeed, float groundspeed, float alt, float climb, int heading,
      int throttle) {
    this.airspeed = airspeed;
    this.groundspeed = groundspeed;
    this.alt = alt;
    this.climb = climb;
    this.heading = heading;
    this.throttle = throttle;
  }

  @MavlinkMessageBuilder
  public static Builder builder() {
    return new Builder();
  }

  @Override
  public String toString() {
    return "VfrHud{airspeed=" + airspeed
         + ", groundspeed=" + groundspeed
         + ", heading=" + heading
         + ", throttle=" + throttle
         + ", alt=" + alt
         + ", climb=" + climb + "}";
  }

  /**
   * Current airspeed in m/s 
   */
  @MavlinkFieldInfo(
      position = 1,
      unitSize = 4
  )
  public final float airspeed() {
    return airspeed;
  }

  /**
   * Current ground speed in m/s 
   */
  @MavlinkFieldInfo(
      position = 2,
      unitSize = 4
  )
  public final float groundspeed() {
    return groundspeed;
  }

  /**
   * Current altitude (MSL), in meters 
   */
  @MavlinkFieldInfo(
      position = 5,
      unitSize = 4
  )
  public final float alt() {
    return alt;
  }

  /**
   * Current climb rate in meters/second 
   */
  @MavlinkFieldInfo(
      position = 6,
      unitSize = 4
  )
  public final float climb() {
    return climb;
  }

  /**
   * Current heading in degrees, in compass units (0..360, 0=north) 
   */
  @MavlinkFieldInfo(
      position = 3,
      unitSize = 2
  )
  public final int heading() {
    return heading;
  }

  /**
   * Current throttle setting in integer percent, 0 to 100 
   */
  @MavlinkFieldInfo(
      position = 4,
      unitSize = 2
  )
  public final int throttle() {
    return throttle;
  }

  public static class Builder {
    private float airspeed;

    private float groundspeed;

    private float alt;

    private float climb;

    private int heading;

    private int throttle;

    private Builder() {
    }

    /**
     * Current airspeed in m/s 
     */
    @MavlinkFieldInfo(
        position = 1,
        unitSize = 4
    )
    public final Builder airspeed(float airspeed) {
      this.airspeed = airspeed;
      return this;
    }

    /**
     * Current ground speed in m/s 
     */
    @MavlinkFieldInfo(
        position = 2,
        unitSize = 4
    )
    public final Builder groundspeed(float groundspeed) {
      this.groundspeed = groundspeed;
      return this;
    }

    /**
     * Current altitude (MSL), in meters 
     */
    @MavlinkFieldInfo(
        position = 5,
        unitSize = 4
    )
    public final Builder alt(float alt) {
      this.alt = alt;
      return this;
    }

    /**
     * Current climb rate in meters/second 
     */
    @MavlinkFieldInfo(
        position = 6,
        unitSize = 4
    )
    public final Builder climb(float climb) {
      this.climb = climb;
      return this;
    }

    /**
     * Current heading in degrees, in compass units (0..360, 0=north) 
     */
    @MavlinkFieldInfo(
        position = 3,
        unitSize = 2
    )
    public final Builder heading(int heading) {
      this.heading = heading;
      return this;
    }

    /**
     * Current throttle setting in integer percent, 0 to 100 
     */
    @MavlinkFieldInfo(
        position = 4,
        unitSize = 2
    )
    public final Builder throttle(int throttle) {
      this.throttle = throttle;
      return this;
    }

    public final VfrHud build() {
      return new VfrHud(airspeed, groundspeed, alt, climb, heading, throttle);
    }
  }
}
