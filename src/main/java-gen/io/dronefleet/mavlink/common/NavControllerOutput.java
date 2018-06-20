package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import java.lang.Override;
import java.lang.String;

/**
 * The state of the fixed wing navigation and position controller. 
 */
@MavlinkMessageInfo(
    id = 62,
    crc = 183
)
public final class NavControllerOutput {
  /**
   * Current desired roll in degrees 
   */
  private final float navRoll;

  /**
   * Current desired pitch in degrees 
   */
  private final float navPitch;

  /**
   * Current altitude error in meters 
   */
  private final float altError;

  /**
   * Current airspeed error in meters/second 
   */
  private final float aspdError;

  /**
   * Current crosstrack error on x-y plane in meters 
   */
  private final float xtrackError;

  /**
   * Current desired heading in degrees 
   */
  private final int navBearing;

  /**
   * Bearing to current waypoint/target in degrees 
   */
  private final int targetBearing;

  /**
   * Distance to active waypoint in meters 
   */
  private final int wpDist;

  private NavControllerOutput(float navRoll, float navPitch, float altError, float aspdError,
      float xtrackError, int navBearing, int targetBearing, int wpDist) {
    this.navRoll = navRoll;
    this.navPitch = navPitch;
    this.altError = altError;
    this.aspdError = aspdError;
    this.xtrackError = xtrackError;
    this.navBearing = navBearing;
    this.targetBearing = targetBearing;
    this.wpDist = wpDist;
  }

  @MavlinkMessageBuilder
  public static Builder builder() {
    return new Builder();
  }

  @Override
  public String toString() {
    return "NavControllerOutput{navRoll=" + navRoll
         + ", navPitch=" + navPitch
         + ", navBearing=" + navBearing
         + ", targetBearing=" + targetBearing
         + ", wpDist=" + wpDist
         + ", altError=" + altError
         + ", aspdError=" + aspdError
         + ", xtrackError=" + xtrackError + "}";
  }

  /**
   * Current desired roll in degrees 
   */
  @MavlinkFieldInfo(
      position = 1,
      unitSize = 4
  )
  public final float navRoll() {
    return navRoll;
  }

  /**
   * Current desired pitch in degrees 
   */
  @MavlinkFieldInfo(
      position = 2,
      unitSize = 4
  )
  public final float navPitch() {
    return navPitch;
  }

  /**
   * Current altitude error in meters 
   */
  @MavlinkFieldInfo(
      position = 6,
      unitSize = 4
  )
  public final float altError() {
    return altError;
  }

  /**
   * Current airspeed error in meters/second 
   */
  @MavlinkFieldInfo(
      position = 7,
      unitSize = 4
  )
  public final float aspdError() {
    return aspdError;
  }

  /**
   * Current crosstrack error on x-y plane in meters 
   */
  @MavlinkFieldInfo(
      position = 8,
      unitSize = 4
  )
  public final float xtrackError() {
    return xtrackError;
  }

  /**
   * Current desired heading in degrees 
   */
  @MavlinkFieldInfo(
      position = 3,
      unitSize = 2
  )
  public final int navBearing() {
    return navBearing;
  }

  /**
   * Bearing to current waypoint/target in degrees 
   */
  @MavlinkFieldInfo(
      position = 4,
      unitSize = 2
  )
  public final int targetBearing() {
    return targetBearing;
  }

  /**
   * Distance to active waypoint in meters 
   */
  @MavlinkFieldInfo(
      position = 5,
      unitSize = 2
  )
  public final int wpDist() {
    return wpDist;
  }

  public static class Builder {
    private float navRoll;

    private float navPitch;

    private float altError;

    private float aspdError;

    private float xtrackError;

    private int navBearing;

    private int targetBearing;

    private int wpDist;

    private Builder() {
    }

    /**
     * Current desired roll in degrees 
     */
    @MavlinkFieldInfo(
        position = 1,
        unitSize = 4
    )
    public final Builder navRoll(float navRoll) {
      this.navRoll = navRoll;
      return this;
    }

    /**
     * Current desired pitch in degrees 
     */
    @MavlinkFieldInfo(
        position = 2,
        unitSize = 4
    )
    public final Builder navPitch(float navPitch) {
      this.navPitch = navPitch;
      return this;
    }

    /**
     * Current altitude error in meters 
     */
    @MavlinkFieldInfo(
        position = 6,
        unitSize = 4
    )
    public final Builder altError(float altError) {
      this.altError = altError;
      return this;
    }

    /**
     * Current airspeed error in meters/second 
     */
    @MavlinkFieldInfo(
        position = 7,
        unitSize = 4
    )
    public final Builder aspdError(float aspdError) {
      this.aspdError = aspdError;
      return this;
    }

    /**
     * Current crosstrack error on x-y plane in meters 
     */
    @MavlinkFieldInfo(
        position = 8,
        unitSize = 4
    )
    public final Builder xtrackError(float xtrackError) {
      this.xtrackError = xtrackError;
      return this;
    }

    /**
     * Current desired heading in degrees 
     */
    @MavlinkFieldInfo(
        position = 3,
        unitSize = 2
    )
    public final Builder navBearing(int navBearing) {
      this.navBearing = navBearing;
      return this;
    }

    /**
     * Bearing to current waypoint/target in degrees 
     */
    @MavlinkFieldInfo(
        position = 4,
        unitSize = 2
    )
    public final Builder targetBearing(int targetBearing) {
      this.targetBearing = targetBearing;
      return this;
    }

    /**
     * Distance to active waypoint in meters 
     */
    @MavlinkFieldInfo(
        position = 5,
        unitSize = 2
    )
    public final Builder wpDist(int wpDist) {
      this.wpDist = wpDist;
      return this;
    }

    public final NavControllerOutput build() {
      return new NavControllerOutput(navRoll, navPitch, altError, aspdError, xtrackError, navBearing, targetBearing, wpDist);
    }
  }
}
