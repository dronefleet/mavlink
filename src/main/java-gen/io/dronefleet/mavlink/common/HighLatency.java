package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkMessage;
import io.dronefleet.mavlink.annotations.MavlinkMessageField;
import io.dronefleet.mavlink.util.EnumFlagSet;

/**
 * Message appropriate for high latency connections like Iridium 
 */
@MavlinkMessage(
    id = 234,
    crc = 150
)
public final class HighLatency {
  /**
   * System mode bitfield, as defined by {@link io.dronefleet.mavlink.common.MavModeFlag MavModeFlag} enum. 
   */
  private final EnumFlagSet<MavModeFlag> baseMode;

  /**
   * A bitfield for use for autopilot-specific flags. 
   */
  private final long customMode;

  /**
   * The landed state. Is set to MAV_LANDED_STATE_UNDEFINED if landed state is unknown. 
   */
  private final MavLandedState landedState;

  /**
   * roll (centidegrees) 
   */
  private final int roll;

  /**
   * pitch (centidegrees) 
   */
  private final int pitch;

  /**
   * heading (centidegrees) 
   */
  private final int heading;

  /**
   * throttle (percentage) 
   */
  private final int throttle;

  /**
   * heading setpoint (centidegrees) 
   */
  private final int headingSp;

  /**
   * Latitude, expressed as degrees * 1E7 
   */
  private final int latitude;

  /**
   * Longitude, expressed as degrees * 1E7 
   */
  private final int longitude;

  /**
   * Altitude above mean sea level (meters) 
   */
  private final int altitudeAmsl;

  /**
   * Altitude setpoint relative to the home position (meters) 
   */
  private final int altitudeSp;

  /**
   * airspeed (m/s) 
   */
  private final int airspeed;

  /**
   * airspeed setpoint (m/s) 
   */
  private final int airspeedSp;

  /**
   * groundspeed (m/s) 
   */
  private final int groundspeed;

  /**
   * climb rate (m/s) 
   */
  private final int climbRate;

  /**
   * Number of satellites visible. If unknown, set to 255 
   */
  private final int gpsNsat;

  /**
   * See the {@link io.dronefleet.mavlink.common.GpsFixType GpsFixType} enum. 
   */
  private final GpsFixType gpsFixType;

  /**
   * Remaining battery (percentage) 
   */
  private final int batteryRemaining;

  /**
   * Autopilot temperature (degrees C) 
   */
  private final int temperature;

  /**
   * Air temperature (degrees C) from airspeed sensor 
   */
  private final int temperatureAir;

  /**
   * failsafe (each bit represents a failsafe where 0=ok, 1=failsafe active (bit0:RC, bit1:batt, 
   * bit2:GPS, bit3:GCS, bit4:fence) 
   */
  private final int failsafe;

  /**
   * current waypoint number 
   */
  private final int wpNum;

  /**
   * distance to target (meters) 
   */
  private final int wpDistance;

  private HighLatency(EnumFlagSet<MavModeFlag> baseMode, long customMode,
      MavLandedState landedState, int roll, int pitch, int heading, int throttle, int headingSp,
      int latitude, int longitude, int altitudeAmsl, int altitudeSp, int airspeed, int airspeedSp,
      int groundspeed, int climbRate, int gpsNsat, GpsFixType gpsFixType, int batteryRemaining,
      int temperature, int temperatureAir, int failsafe, int wpNum, int wpDistance) {
    this.baseMode = baseMode;
    this.customMode = customMode;
    this.landedState = landedState;
    this.roll = roll;
    this.pitch = pitch;
    this.heading = heading;
    this.throttle = throttle;
    this.headingSp = headingSp;
    this.latitude = latitude;
    this.longitude = longitude;
    this.altitudeAmsl = altitudeAmsl;
    this.altitudeSp = altitudeSp;
    this.airspeed = airspeed;
    this.airspeedSp = airspeedSp;
    this.groundspeed = groundspeed;
    this.climbRate = climbRate;
    this.gpsNsat = gpsNsat;
    this.gpsFixType = gpsFixType;
    this.batteryRemaining = batteryRemaining;
    this.temperature = temperature;
    this.temperatureAir = temperatureAir;
    this.failsafe = failsafe;
    this.wpNum = wpNum;
    this.wpDistance = wpDistance;
  }

  public static Builder builder() {
    return new Builder();
  }

  /**
   * System mode bitfield, as defined by {@link io.dronefleet.mavlink.common.MavModeFlag MavModeFlag} enum. 
   */
  @MavlinkMessageField(
      position = 1,
      length = 1
  )
  public final EnumFlagSet<MavModeFlag> baseMode() {
    return baseMode;
  }

  /**
   * A bitfield for use for autopilot-specific flags. 
   */
  @MavlinkMessageField(
      position = 2,
      length = 4
  )
  public final long customMode() {
    return customMode;
  }

  /**
   * The landed state. Is set to MAV_LANDED_STATE_UNDEFINED if landed state is unknown. 
   */
  @MavlinkMessageField(
      position = 3,
      length = 1
  )
  public final MavLandedState landedState() {
    return landedState;
  }

  /**
   * roll (centidegrees) 
   */
  @MavlinkMessageField(
      position = 4,
      length = 2
  )
  public final int roll() {
    return roll;
  }

  /**
   * pitch (centidegrees) 
   */
  @MavlinkMessageField(
      position = 5,
      length = 2
  )
  public final int pitch() {
    return pitch;
  }

  /**
   * heading (centidegrees) 
   */
  @MavlinkMessageField(
      position = 6,
      length = 2
  )
  public final int heading() {
    return heading;
  }

  /**
   * throttle (percentage) 
   */
  @MavlinkMessageField(
      position = 7,
      length = 1
  )
  public final int throttle() {
    return throttle;
  }

  /**
   * heading setpoint (centidegrees) 
   */
  @MavlinkMessageField(
      position = 8,
      length = 2
  )
  public final int headingSp() {
    return headingSp;
  }

  /**
   * Latitude, expressed as degrees * 1E7 
   */
  @MavlinkMessageField(
      position = 9,
      length = 4
  )
  public final int latitude() {
    return latitude;
  }

  /**
   * Longitude, expressed as degrees * 1E7 
   */
  @MavlinkMessageField(
      position = 10,
      length = 4
  )
  public final int longitude() {
    return longitude;
  }

  /**
   * Altitude above mean sea level (meters) 
   */
  @MavlinkMessageField(
      position = 11,
      length = 2
  )
  public final int altitudeAmsl() {
    return altitudeAmsl;
  }

  /**
   * Altitude setpoint relative to the home position (meters) 
   */
  @MavlinkMessageField(
      position = 12,
      length = 2
  )
  public final int altitudeSp() {
    return altitudeSp;
  }

  /**
   * airspeed (m/s) 
   */
  @MavlinkMessageField(
      position = 13,
      length = 1
  )
  public final int airspeed() {
    return airspeed;
  }

  /**
   * airspeed setpoint (m/s) 
   */
  @MavlinkMessageField(
      position = 14,
      length = 1
  )
  public final int airspeedSp() {
    return airspeedSp;
  }

  /**
   * groundspeed (m/s) 
   */
  @MavlinkMessageField(
      position = 15,
      length = 1
  )
  public final int groundspeed() {
    return groundspeed;
  }

  /**
   * climb rate (m/s) 
   */
  @MavlinkMessageField(
      position = 16,
      length = 1
  )
  public final int climbRate() {
    return climbRate;
  }

  /**
   * Number of satellites visible. If unknown, set to 255 
   */
  @MavlinkMessageField(
      position = 17,
      length = 1
  )
  public final int gpsNsat() {
    return gpsNsat;
  }

  /**
   * See the {@link io.dronefleet.mavlink.common.GpsFixType GpsFixType} enum. 
   */
  @MavlinkMessageField(
      position = 18,
      length = 1
  )
  public final GpsFixType gpsFixType() {
    return gpsFixType;
  }

  /**
   * Remaining battery (percentage) 
   */
  @MavlinkMessageField(
      position = 19,
      length = 1
  )
  public final int batteryRemaining() {
    return batteryRemaining;
  }

  /**
   * Autopilot temperature (degrees C) 
   */
  @MavlinkMessageField(
      position = 20,
      length = 1
  )
  public final int temperature() {
    return temperature;
  }

  /**
   * Air temperature (degrees C) from airspeed sensor 
   */
  @MavlinkMessageField(
      position = 21,
      length = 1
  )
  public final int temperatureAir() {
    return temperatureAir;
  }

  /**
   * failsafe (each bit represents a failsafe where 0=ok, 1=failsafe active (bit0:RC, bit1:batt, 
   * bit2:GPS, bit3:GCS, bit4:fence) 
   */
  @MavlinkMessageField(
      position = 22,
      length = 1
  )
  public final int failsafe() {
    return failsafe;
  }

  /**
   * current waypoint number 
   */
  @MavlinkMessageField(
      position = 23,
      length = 1
  )
  public final int wpNum() {
    return wpNum;
  }

  /**
   * distance to target (meters) 
   */
  @MavlinkMessageField(
      position = 24,
      length = 2
  )
  public final int wpDistance() {
    return wpDistance;
  }

  public static class Builder {
    private EnumFlagSet<MavModeFlag> baseMode;

    private long customMode;

    private MavLandedState landedState;

    private int roll;

    private int pitch;

    private int heading;

    private int throttle;

    private int headingSp;

    private int latitude;

    private int longitude;

    private int altitudeAmsl;

    private int altitudeSp;

    private int airspeed;

    private int airspeedSp;

    private int groundspeed;

    private int climbRate;

    private int gpsNsat;

    private GpsFixType gpsFixType;

    private int batteryRemaining;

    private int temperature;

    private int temperatureAir;

    private int failsafe;

    private int wpNum;

    private int wpDistance;

    private Builder() {
    }

    /**
     * System mode bitfield, as defined by {@link io.dronefleet.mavlink.common.MavModeFlag MavModeFlag} enum. 
     */
    @MavlinkMessageField(
        position = 1,
        length = 1
    )
    public final Builder baseMode(EnumFlagSet<MavModeFlag> baseMode) {
      this.baseMode = baseMode;
      return this;
    }

    /**
     * A bitfield for use for autopilot-specific flags. 
     */
    @MavlinkMessageField(
        position = 2,
        length = 4
    )
    public final Builder customMode(long customMode) {
      this.customMode = customMode;
      return this;
    }

    /**
     * The landed state. Is set to MAV_LANDED_STATE_UNDEFINED if landed state is unknown. 
     */
    @MavlinkMessageField(
        position = 3,
        length = 1
    )
    public final Builder landedState(MavLandedState landedState) {
      this.landedState = landedState;
      return this;
    }

    /**
     * roll (centidegrees) 
     */
    @MavlinkMessageField(
        position = 4,
        length = 2
    )
    public final Builder roll(int roll) {
      this.roll = roll;
      return this;
    }

    /**
     * pitch (centidegrees) 
     */
    @MavlinkMessageField(
        position = 5,
        length = 2
    )
    public final Builder pitch(int pitch) {
      this.pitch = pitch;
      return this;
    }

    /**
     * heading (centidegrees) 
     */
    @MavlinkMessageField(
        position = 6,
        length = 2
    )
    public final Builder heading(int heading) {
      this.heading = heading;
      return this;
    }

    /**
     * throttle (percentage) 
     */
    @MavlinkMessageField(
        position = 7,
        length = 1
    )
    public final Builder throttle(int throttle) {
      this.throttle = throttle;
      return this;
    }

    /**
     * heading setpoint (centidegrees) 
     */
    @MavlinkMessageField(
        position = 8,
        length = 2
    )
    public final Builder headingSp(int headingSp) {
      this.headingSp = headingSp;
      return this;
    }

    /**
     * Latitude, expressed as degrees * 1E7 
     */
    @MavlinkMessageField(
        position = 9,
        length = 4
    )
    public final Builder latitude(int latitude) {
      this.latitude = latitude;
      return this;
    }

    /**
     * Longitude, expressed as degrees * 1E7 
     */
    @MavlinkMessageField(
        position = 10,
        length = 4
    )
    public final Builder longitude(int longitude) {
      this.longitude = longitude;
      return this;
    }

    /**
     * Altitude above mean sea level (meters) 
     */
    @MavlinkMessageField(
        position = 11,
        length = 2
    )
    public final Builder altitudeAmsl(int altitudeAmsl) {
      this.altitudeAmsl = altitudeAmsl;
      return this;
    }

    /**
     * Altitude setpoint relative to the home position (meters) 
     */
    @MavlinkMessageField(
        position = 12,
        length = 2
    )
    public final Builder altitudeSp(int altitudeSp) {
      this.altitudeSp = altitudeSp;
      return this;
    }

    /**
     * airspeed (m/s) 
     */
    @MavlinkMessageField(
        position = 13,
        length = 1
    )
    public final Builder airspeed(int airspeed) {
      this.airspeed = airspeed;
      return this;
    }

    /**
     * airspeed setpoint (m/s) 
     */
    @MavlinkMessageField(
        position = 14,
        length = 1
    )
    public final Builder airspeedSp(int airspeedSp) {
      this.airspeedSp = airspeedSp;
      return this;
    }

    /**
     * groundspeed (m/s) 
     */
    @MavlinkMessageField(
        position = 15,
        length = 1
    )
    public final Builder groundspeed(int groundspeed) {
      this.groundspeed = groundspeed;
      return this;
    }

    /**
     * climb rate (m/s) 
     */
    @MavlinkMessageField(
        position = 16,
        length = 1
    )
    public final Builder climbRate(int climbRate) {
      this.climbRate = climbRate;
      return this;
    }

    /**
     * Number of satellites visible. If unknown, set to 255 
     */
    @MavlinkMessageField(
        position = 17,
        length = 1
    )
    public final Builder gpsNsat(int gpsNsat) {
      this.gpsNsat = gpsNsat;
      return this;
    }

    /**
     * See the {@link io.dronefleet.mavlink.common.GpsFixType GpsFixType} enum. 
     */
    @MavlinkMessageField(
        position = 18,
        length = 1
    )
    public final Builder gpsFixType(GpsFixType gpsFixType) {
      this.gpsFixType = gpsFixType;
      return this;
    }

    /**
     * Remaining battery (percentage) 
     */
    @MavlinkMessageField(
        position = 19,
        length = 1
    )
    public final Builder batteryRemaining(int batteryRemaining) {
      this.batteryRemaining = batteryRemaining;
      return this;
    }

    /**
     * Autopilot temperature (degrees C) 
     */
    @MavlinkMessageField(
        position = 20,
        length = 1
    )
    public final Builder temperature(int temperature) {
      this.temperature = temperature;
      return this;
    }

    /**
     * Air temperature (degrees C) from airspeed sensor 
     */
    @MavlinkMessageField(
        position = 21,
        length = 1
    )
    public final Builder temperatureAir(int temperatureAir) {
      this.temperatureAir = temperatureAir;
      return this;
    }

    /**
     * failsafe (each bit represents a failsafe where 0=ok, 1=failsafe active (bit0:RC, bit1:batt, 
     * bit2:GPS, bit3:GCS, bit4:fence) 
     */
    @MavlinkMessageField(
        position = 22,
        length = 1
    )
    public final Builder failsafe(int failsafe) {
      this.failsafe = failsafe;
      return this;
    }

    /**
     * current waypoint number 
     */
    @MavlinkMessageField(
        position = 23,
        length = 1
    )
    public final Builder wpNum(int wpNum) {
      this.wpNum = wpNum;
      return this;
    }

    /**
     * distance to target (meters) 
     */
    @MavlinkMessageField(
        position = 24,
        length = 2
    )
    public final Builder wpDistance(int wpDistance) {
      this.wpDistance = wpDistance;
      return this;
    }

    public final HighLatency build() {
      return new HighLatency(baseMode, customMode, landedState, roll, pitch, heading, throttle, headingSp, latitude, longitude, altitudeAmsl, altitudeSp, airspeed, airspeedSp, groundspeed, climbRate, gpsNsat, gpsFixType, batteryRemaining, temperature, temperatureAir, failsafe, wpNum, wpDistance);
    }
  }
}
