package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkMessage;
import io.dronefleet.mavlink.annotations.MavlinkMessageField;
import java.math.BigInteger;

/**
 * The current system altitude. 
 */
@MavlinkMessage(
    id = 141,
    crc = 47
)
public final class Altitude {
  /**
   * Timestamp (micros since boot or Unix epoch) 
   */
  private final BigInteger timeUsec;

  /**
   * This altitude measure is initialized on system boot and monotonic (it is never reset, but 
   * represents the local altitude change). The only guarantee on this field is that it will never be 
   * reset and is consistent within a flight. The recommended value for this field is the 
   * uncorrected barometric altitude at boot time. This altitude will also drift and vary between 
   * flights. 
   */
  private final float altitudeMonotonic;

  /**
   * This altitude measure is strictly above mean sea level and might be non-monotonic (it might 
   * reset on events like GPS lock or when a new QNH value is set). It should be the altitude to which 
   * global altitude waypoints are compared to. Note that it is *not* the GPS altitude, however, 
   * most GPS modules already output AMSL by default and not the WGS84 altitude. 
   */
  private final float altitudeAmsl;

  /**
   * This is the local altitude in the local coordinate frame. It is not the altitude above home, but 
   * in reference to the coordinate origin (0, 0, 0). It is up-positive. 
   */
  private final float altitudeLocal;

  /**
   * This is the altitude above the home position. It resets on each change of the current home 
   * position. 
   */
  private final float altitudeRelative;

  /**
   * This is the altitude above terrain. It might be fed by a terrain database or an altimeter. Values 
   * smaller than -1000 should be interpreted as unknown. 
   */
  private final float altitudeTerrain;

  /**
   * This is not the altitude, but the clear space below the system according to the fused clearance 
   * estimate. It generally should max out at the maximum range of e.g. the laser altimeter. It is 
   * generally a moving target. A negative value indicates no measurement available. 
   */
  private final float bottomClearance;

  private Altitude(BigInteger timeUsec, float altitudeMonotonic, float altitudeAmsl,
      float altitudeLocal, float altitudeRelative, float altitudeTerrain, float bottomClearance) {
    this.timeUsec = timeUsec;
    this.altitudeMonotonic = altitudeMonotonic;
    this.altitudeAmsl = altitudeAmsl;
    this.altitudeLocal = altitudeLocal;
    this.altitudeRelative = altitudeRelative;
    this.altitudeTerrain = altitudeTerrain;
    this.bottomClearance = bottomClearance;
  }

  public static Builder builder() {
    return new Builder();
  }

  /**
   * Timestamp (micros since boot or Unix epoch) 
   */
  @MavlinkMessageField(
      position = 1,
      length = 8
  )
  public final BigInteger timeUsec() {
    return timeUsec;
  }

  /**
   * This altitude measure is initialized on system boot and monotonic (it is never reset, but 
   * represents the local altitude change). The only guarantee on this field is that it will never be 
   * reset and is consistent within a flight. The recommended value for this field is the 
   * uncorrected barometric altitude at boot time. This altitude will also drift and vary between 
   * flights. 
   */
  @MavlinkMessageField(
      position = 2,
      length = 4
  )
  public final float altitudeMonotonic() {
    return altitudeMonotonic;
  }

  /**
   * This altitude measure is strictly above mean sea level and might be non-monotonic (it might 
   * reset on events like GPS lock or when a new QNH value is set). It should be the altitude to which 
   * global altitude waypoints are compared to. Note that it is *not* the GPS altitude, however, 
   * most GPS modules already output AMSL by default and not the WGS84 altitude. 
   */
  @MavlinkMessageField(
      position = 3,
      length = 4
  )
  public final float altitudeAmsl() {
    return altitudeAmsl;
  }

  /**
   * This is the local altitude in the local coordinate frame. It is not the altitude above home, but 
   * in reference to the coordinate origin (0, 0, 0). It is up-positive. 
   */
  @MavlinkMessageField(
      position = 4,
      length = 4
  )
  public final float altitudeLocal() {
    return altitudeLocal;
  }

  /**
   * This is the altitude above the home position. It resets on each change of the current home 
   * position. 
   */
  @MavlinkMessageField(
      position = 5,
      length = 4
  )
  public final float altitudeRelative() {
    return altitudeRelative;
  }

  /**
   * This is the altitude above terrain. It might be fed by a terrain database or an altimeter. Values 
   * smaller than -1000 should be interpreted as unknown. 
   */
  @MavlinkMessageField(
      position = 6,
      length = 4
  )
  public final float altitudeTerrain() {
    return altitudeTerrain;
  }

  /**
   * This is not the altitude, but the clear space below the system according to the fused clearance 
   * estimate. It generally should max out at the maximum range of e.g. the laser altimeter. It is 
   * generally a moving target. A negative value indicates no measurement available. 
   */
  @MavlinkMessageField(
      position = 7,
      length = 4
  )
  public final float bottomClearance() {
    return bottomClearance;
  }

  public static class Builder {
    private BigInteger timeUsec;

    private float altitudeMonotonic;

    private float altitudeAmsl;

    private float altitudeLocal;

    private float altitudeRelative;

    private float altitudeTerrain;

    private float bottomClearance;

    private Builder() {
    }

    /**
     * Timestamp (micros since boot or Unix epoch) 
     */
    @MavlinkMessageField(
        position = 1,
        length = 8
    )
    public final Builder timeUsec(BigInteger timeUsec) {
      this.timeUsec = timeUsec;
      return this;
    }

    /**
     * This altitude measure is initialized on system boot and monotonic (it is never reset, but 
     * represents the local altitude change). The only guarantee on this field is that it will never be 
     * reset and is consistent within a flight. The recommended value for this field is the 
     * uncorrected barometric altitude at boot time. This altitude will also drift and vary between 
     * flights. 
     */
    @MavlinkMessageField(
        position = 2,
        length = 4
    )
    public final Builder altitudeMonotonic(float altitudeMonotonic) {
      this.altitudeMonotonic = altitudeMonotonic;
      return this;
    }

    /**
     * This altitude measure is strictly above mean sea level and might be non-monotonic (it might 
     * reset on events like GPS lock or when a new QNH value is set). It should be the altitude to which 
     * global altitude waypoints are compared to. Note that it is *not* the GPS altitude, however, 
     * most GPS modules already output AMSL by default and not the WGS84 altitude. 
     */
    @MavlinkMessageField(
        position = 3,
        length = 4
    )
    public final Builder altitudeAmsl(float altitudeAmsl) {
      this.altitudeAmsl = altitudeAmsl;
      return this;
    }

    /**
     * This is the local altitude in the local coordinate frame. It is not the altitude above home, but 
     * in reference to the coordinate origin (0, 0, 0). It is up-positive. 
     */
    @MavlinkMessageField(
        position = 4,
        length = 4
    )
    public final Builder altitudeLocal(float altitudeLocal) {
      this.altitudeLocal = altitudeLocal;
      return this;
    }

    /**
     * This is the altitude above the home position. It resets on each change of the current home 
     * position. 
     */
    @MavlinkMessageField(
        position = 5,
        length = 4
    )
    public final Builder altitudeRelative(float altitudeRelative) {
      this.altitudeRelative = altitudeRelative;
      return this;
    }

    /**
     * This is the altitude above terrain. It might be fed by a terrain database or an altimeter. Values 
     * smaller than -1000 should be interpreted as unknown. 
     */
    @MavlinkMessageField(
        position = 6,
        length = 4
    )
    public final Builder altitudeTerrain(float altitudeTerrain) {
      this.altitudeTerrain = altitudeTerrain;
      return this;
    }

    /**
     * This is not the altitude, but the clear space below the system according to the fused clearance 
     * estimate. It generally should max out at the maximum range of e.g. the laser altimeter. It is 
     * generally a moving target. A negative value indicates no measurement available. 
     */
    @MavlinkMessageField(
        position = 7,
        length = 4
    )
    public final Builder bottomClearance(float bottomClearance) {
      this.bottomClearance = bottomClearance;
      return this;
    }

    public final Altitude build() {
      return new Altitude(timeUsec, altitudeMonotonic, altitudeAmsl, altitudeLocal, altitudeRelative, altitudeTerrain, bottomClearance);
    }
  }
}
