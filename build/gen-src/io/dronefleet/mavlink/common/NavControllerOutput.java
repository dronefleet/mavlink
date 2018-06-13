package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkMessage;
import io.dronefleet.mavlink.annotations.MavlinkMessageField;

/**
 * The state of the fixed wing navigation and position controller. 
 */
@MavlinkMessage(
    id = 62,
    crc = 183
)
public final class NavControllerOutput {
  private final float navRoll;

  private final float navPitch;

  private final int navBearing;

  private final int targetBearing;

  private final int wpDist;

  private final float altError;

  private final float aspdError;

  private final float xtrackError;

  private NavControllerOutput(float navRoll, float navPitch, int navBearing, int targetBearing,
      int wpDist, float altError, float aspdError, float xtrackError) {
    this.navRoll = navRoll;
    this.navPitch = navPitch;
    this.navBearing = navBearing;
    this.targetBearing = targetBearing;
    this.wpDist = wpDist;
    this.altError = altError;
    this.aspdError = aspdError;
    this.xtrackError = xtrackError;
  }

  public static Builder builder() {
    return new Builder();
  }

  /**
   * Current desired roll in degrees 
   */
  @MavlinkMessageField(
      position = 1,
      length = 4
  )
  public final float navRoll() {
    return navRoll;
  }

  /**
   * Current desired pitch in degrees 
   */
  @MavlinkMessageField(
      position = 2,
      length = 4
  )
  public final float navPitch() {
    return navPitch;
  }

  /**
   * Current desired heading in degrees 
   */
  @MavlinkMessageField(
      position = 3,
      length = 2
  )
  public final int navBearing() {
    return navBearing;
  }

  /**
   * Bearing to current waypoint/target in degrees 
   */
  @MavlinkMessageField(
      position = 4,
      length = 2
  )
  public final int targetBearing() {
    return targetBearing;
  }

  /**
   * Distance to active waypoint in meters 
   */
  @MavlinkMessageField(
      position = 5,
      length = 2
  )
  public final int wpDist() {
    return wpDist;
  }

  /**
   * Current altitude error in meters 
   */
  @MavlinkMessageField(
      position = 6,
      length = 4
  )
  public final float altError() {
    return altError;
  }

  /**
   * Current airspeed error in meters/second 
   */
  @MavlinkMessageField(
      position = 7,
      length = 4
  )
  public final float aspdError() {
    return aspdError;
  }

  /**
   * Current crosstrack error on x-y plane in meters 
   */
  @MavlinkMessageField(
      position = 8,
      length = 4
  )
  public final float xtrackError() {
    return xtrackError;
  }

  public class Builder {
    private float navRoll;

    private float navPitch;

    private int navBearing;

    private int targetBearing;

    private int wpDist;

    private float altError;

    private float aspdError;

    private float xtrackError;

    private Builder() {
    }

    /**
     * Current desired roll in degrees 
     */
    @MavlinkMessageField(
        position = 1,
        length = 4
    )
    public final Builder navRoll(float navRoll) {
      this.navRoll = navRoll;
      return this;
    }

    /**
     * Current desired pitch in degrees 
     */
    @MavlinkMessageField(
        position = 2,
        length = 4
    )
    public final Builder navPitch(float navPitch) {
      this.navPitch = navPitch;
      return this;
    }

    /**
     * Current desired heading in degrees 
     */
    @MavlinkMessageField(
        position = 3,
        length = 2
    )
    public final Builder navBearing(int navBearing) {
      this.navBearing = navBearing;
      return this;
    }

    /**
     * Bearing to current waypoint/target in degrees 
     */
    @MavlinkMessageField(
        position = 4,
        length = 2
    )
    public final Builder targetBearing(int targetBearing) {
      this.targetBearing = targetBearing;
      return this;
    }

    /**
     * Distance to active waypoint in meters 
     */
    @MavlinkMessageField(
        position = 5,
        length = 2
    )
    public final Builder wpDist(int wpDist) {
      this.wpDist = wpDist;
      return this;
    }

    /**
     * Current altitude error in meters 
     */
    @MavlinkMessageField(
        position = 6,
        length = 4
    )
    public final Builder altError(float altError) {
      this.altError = altError;
      return this;
    }

    /**
     * Current airspeed error in meters/second 
     */
    @MavlinkMessageField(
        position = 7,
        length = 4
    )
    public final Builder aspdError(float aspdError) {
      this.aspdError = aspdError;
      return this;
    }

    /**
     * Current crosstrack error on x-y plane in meters 
     */
    @MavlinkMessageField(
        position = 8,
        length = 4
    )
    public final Builder xtrackError(float xtrackError) {
      this.xtrackError = xtrackError;
      return this;
    }

    public final NavControllerOutput build() {
      return new NavControllerOutput(navRoll, navPitch, navBearing, targetBearing, wpDist, altError, aspdError, xtrackError);
    }
  }
}
