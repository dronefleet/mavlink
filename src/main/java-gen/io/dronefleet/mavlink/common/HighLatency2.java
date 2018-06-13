package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkMessage;
import io.dronefleet.mavlink.annotations.MavlinkMessageField;
import io.dronefleet.mavlink.util.EnumFlagSet;

/**
 * WIP: Message appropriate for high latency connections like Iridium (version 2) 
 */
@MavlinkMessage(
    id = 235,
    crc = 179
)
public final class HighLatency2 {
  /**
   * Timestamp (milliseconds since boot or Unix epoch) 
   */
  private final long timestamp;

  /**
   * Type of the MAV (quadrotor, helicopter, etc., up to 15 types, defined in {@link io.dronefleet.mavlink.common.MavType MavType} ENUM) 
   */
  private final MavType type;

  /**
   * Autopilot type / class. defined in {@link io.dronefleet.mavlink.common.MavAutopilot MavAutopilot} ENUM 
   */
  private final MavAutopilot autopilot;

  /**
   * A bitfield for use for autopilot-specific flags (2 byte version). 
   */
  private final int customMode;

  /**
   * Latitude, expressed as degrees * 1E7 
   */
  private final int latitude;

  /**
   * Longitude, expressed as degrees * 1E7 
   */
  private final int longitude;

  /**
   * Altitude above mean sea level 
   */
  private final int altitude;

  /**
   * Altitude setpoint 
   */
  private final int targetAltitude;

  /**
   * Heading (degrees / 2) 
   */
  private final int heading;

  /**
   * Heading setpoint (degrees / 2) 
   */
  private final int targetHeading;

  /**
   * Distance to target waypoint or position (meters / 10) 
   */
  private final int targetDistance;

  /**
   * Throttle (percentage) 
   */
  private final int throttle;

  /**
   * Airspeed (m/s * 5) 
   */
  private final int airspeed;

  /**
   * Airspeed setpoint (m/s * 5) 
   */
  private final int airspeedSp;

  /**
   * Groundspeed (m/s * 5) 
   */
  private final int groundspeed;

  /**
   * Windspeed (m/s * 5) 
   */
  private final int windspeed;

  /**
   * Wind heading (deg / 2) 
   */
  private final int windHeading;

  /**
   * Maximum error horizontal position since last message (m * 10) 
   */
  private final int eph;

  /**
   * Maximum error vertical position since last message (m * 10) 
   */
  private final int epv;

  /**
   * Air temperature (degrees C) from airspeed sensor 
   */
  private final int temperatureAir;

  /**
   * Maximum climb rate magnitude since last message (m/s * 10) 
   */
  private final int climbRate;

  /**
   * Battery (percentage, -1 for DNU) 
   */
  private final int battery;

  /**
   * Current waypoint number 
   */
  private final int wpNum;

  /**
   * Indicates failures as defined in {@link io.dronefleet.mavlink.common.HlFailureFlag HlFailureFlag} ENUM. 
   */
  private final EnumFlagSet<HlFailureFlag> failureFlags;

  /**
   * Field for custom payload. 
   */
  private final int custom0;

  /**
   * Field for custom payload. 
   */
  private final int custom1;

  /**
   * Field for custom payload. 
   */
  private final int custom2;

  private HighLatency2(long timestamp, MavType type, MavAutopilot autopilot, int customMode,
      int latitude, int longitude, int altitude, int targetAltitude, int heading, int targetHeading,
      int targetDistance, int throttle, int airspeed, int airspeedSp, int groundspeed,
      int windspeed, int windHeading, int eph, int epv, int temperatureAir, int climbRate,
      int battery, int wpNum, EnumFlagSet<HlFailureFlag> failureFlags, int custom0, int custom1,
      int custom2) {
    this.timestamp = timestamp;
    this.type = type;
    this.autopilot = autopilot;
    this.customMode = customMode;
    this.latitude = latitude;
    this.longitude = longitude;
    this.altitude = altitude;
    this.targetAltitude = targetAltitude;
    this.heading = heading;
    this.targetHeading = targetHeading;
    this.targetDistance = targetDistance;
    this.throttle = throttle;
    this.airspeed = airspeed;
    this.airspeedSp = airspeedSp;
    this.groundspeed = groundspeed;
    this.windspeed = windspeed;
    this.windHeading = windHeading;
    this.eph = eph;
    this.epv = epv;
    this.temperatureAir = temperatureAir;
    this.climbRate = climbRate;
    this.battery = battery;
    this.wpNum = wpNum;
    this.failureFlags = failureFlags;
    this.custom0 = custom0;
    this.custom1 = custom1;
    this.custom2 = custom2;
  }

  public static Builder builder() {
    return new Builder();
  }

  /**
   * Timestamp (milliseconds since boot or Unix epoch) 
   */
  @MavlinkMessageField(
      position = 1,
      length = 4
  )
  public final long timestamp() {
    return timestamp;
  }

  /**
   * Type of the MAV (quadrotor, helicopter, etc., up to 15 types, defined in {@link io.dronefleet.mavlink.common.MavType MavType} ENUM) 
   */
  @MavlinkMessageField(
      position = 2,
      length = 1
  )
  public final MavType type() {
    return type;
  }

  /**
   * Autopilot type / class. defined in {@link io.dronefleet.mavlink.common.MavAutopilot MavAutopilot} ENUM 
   */
  @MavlinkMessageField(
      position = 3,
      length = 1
  )
  public final MavAutopilot autopilot() {
    return autopilot;
  }

  /**
   * A bitfield for use for autopilot-specific flags (2 byte version). 
   */
  @MavlinkMessageField(
      position = 4,
      length = 2
  )
  public final int customMode() {
    return customMode;
  }

  /**
   * Latitude, expressed as degrees * 1E7 
   */
  @MavlinkMessageField(
      position = 5,
      length = 4
  )
  public final int latitude() {
    return latitude;
  }

  /**
   * Longitude, expressed as degrees * 1E7 
   */
  @MavlinkMessageField(
      position = 6,
      length = 4
  )
  public final int longitude() {
    return longitude;
  }

  /**
   * Altitude above mean sea level 
   */
  @MavlinkMessageField(
      position = 7,
      length = 2
  )
  public final int altitude() {
    return altitude;
  }

  /**
   * Altitude setpoint 
   */
  @MavlinkMessageField(
      position = 8,
      length = 2
  )
  public final int targetAltitude() {
    return targetAltitude;
  }

  /**
   * Heading (degrees / 2) 
   */
  @MavlinkMessageField(
      position = 9,
      length = 1
  )
  public final int heading() {
    return heading;
  }

  /**
   * Heading setpoint (degrees / 2) 
   */
  @MavlinkMessageField(
      position = 10,
      length = 1
  )
  public final int targetHeading() {
    return targetHeading;
  }

  /**
   * Distance to target waypoint or position (meters / 10) 
   */
  @MavlinkMessageField(
      position = 11,
      length = 2
  )
  public final int targetDistance() {
    return targetDistance;
  }

  /**
   * Throttle (percentage) 
   */
  @MavlinkMessageField(
      position = 12,
      length = 1
  )
  public final int throttle() {
    return throttle;
  }

  /**
   * Airspeed (m/s * 5) 
   */
  @MavlinkMessageField(
      position = 13,
      length = 1
  )
  public final int airspeed() {
    return airspeed;
  }

  /**
   * Airspeed setpoint (m/s * 5) 
   */
  @MavlinkMessageField(
      position = 14,
      length = 1
  )
  public final int airspeedSp() {
    return airspeedSp;
  }

  /**
   * Groundspeed (m/s * 5) 
   */
  @MavlinkMessageField(
      position = 15,
      length = 1
  )
  public final int groundspeed() {
    return groundspeed;
  }

  /**
   * Windspeed (m/s * 5) 
   */
  @MavlinkMessageField(
      position = 16,
      length = 1
  )
  public final int windspeed() {
    return windspeed;
  }

  /**
   * Wind heading (deg / 2) 
   */
  @MavlinkMessageField(
      position = 17,
      length = 1
  )
  public final int windHeading() {
    return windHeading;
  }

  /**
   * Maximum error horizontal position since last message (m * 10) 
   */
  @MavlinkMessageField(
      position = 18,
      length = 1
  )
  public final int eph() {
    return eph;
  }

  /**
   * Maximum error vertical position since last message (m * 10) 
   */
  @MavlinkMessageField(
      position = 19,
      length = 1
  )
  public final int epv() {
    return epv;
  }

  /**
   * Air temperature (degrees C) from airspeed sensor 
   */
  @MavlinkMessageField(
      position = 20,
      length = 1
  )
  public final int temperatureAir() {
    return temperatureAir;
  }

  /**
   * Maximum climb rate magnitude since last message (m/s * 10) 
   */
  @MavlinkMessageField(
      position = 21,
      length = 1
  )
  public final int climbRate() {
    return climbRate;
  }

  /**
   * Battery (percentage, -1 for DNU) 
   */
  @MavlinkMessageField(
      position = 22,
      length = 1
  )
  public final int battery() {
    return battery;
  }

  /**
   * Current waypoint number 
   */
  @MavlinkMessageField(
      position = 23,
      length = 2
  )
  public final int wpNum() {
    return wpNum;
  }

  /**
   * Indicates failures as defined in {@link io.dronefleet.mavlink.common.HlFailureFlag HlFailureFlag} ENUM. 
   */
  @MavlinkMessageField(
      position = 24,
      length = 2
  )
  public final EnumFlagSet<HlFailureFlag> failureFlags() {
    return failureFlags;
  }

  /**
   * Field for custom payload. 
   */
  @MavlinkMessageField(
      position = 25,
      length = 1
  )
  public final int custom0() {
    return custom0;
  }

  /**
   * Field for custom payload. 
   */
  @MavlinkMessageField(
      position = 26,
      length = 1
  )
  public final int custom1() {
    return custom1;
  }

  /**
   * Field for custom payload. 
   */
  @MavlinkMessageField(
      position = 27,
      length = 1
  )
  public final int custom2() {
    return custom2;
  }

  public static class Builder {
    private long timestamp;

    private MavType type;

    private MavAutopilot autopilot;

    private int customMode;

    private int latitude;

    private int longitude;

    private int altitude;

    private int targetAltitude;

    private int heading;

    private int targetHeading;

    private int targetDistance;

    private int throttle;

    private int airspeed;

    private int airspeedSp;

    private int groundspeed;

    private int windspeed;

    private int windHeading;

    private int eph;

    private int epv;

    private int temperatureAir;

    private int climbRate;

    private int battery;

    private int wpNum;

    private EnumFlagSet<HlFailureFlag> failureFlags;

    private int custom0;

    private int custom1;

    private int custom2;

    private Builder() {
    }

    /**
     * Timestamp (milliseconds since boot or Unix epoch) 
     */
    @MavlinkMessageField(
        position = 1,
        length = 4
    )
    public final Builder timestamp(long timestamp) {
      this.timestamp = timestamp;
      return this;
    }

    /**
     * Type of the MAV (quadrotor, helicopter, etc., up to 15 types, defined in {@link io.dronefleet.mavlink.common.MavType MavType} ENUM) 
     */
    @MavlinkMessageField(
        position = 2,
        length = 1
    )
    public final Builder type(MavType type) {
      this.type = type;
      return this;
    }

    /**
     * Autopilot type / class. defined in {@link io.dronefleet.mavlink.common.MavAutopilot MavAutopilot} ENUM 
     */
    @MavlinkMessageField(
        position = 3,
        length = 1
    )
    public final Builder autopilot(MavAutopilot autopilot) {
      this.autopilot = autopilot;
      return this;
    }

    /**
     * A bitfield for use for autopilot-specific flags (2 byte version). 
     */
    @MavlinkMessageField(
        position = 4,
        length = 2
    )
    public final Builder customMode(int customMode) {
      this.customMode = customMode;
      return this;
    }

    /**
     * Latitude, expressed as degrees * 1E7 
     */
    @MavlinkMessageField(
        position = 5,
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
        position = 6,
        length = 4
    )
    public final Builder longitude(int longitude) {
      this.longitude = longitude;
      return this;
    }

    /**
     * Altitude above mean sea level 
     */
    @MavlinkMessageField(
        position = 7,
        length = 2
    )
    public final Builder altitude(int altitude) {
      this.altitude = altitude;
      return this;
    }

    /**
     * Altitude setpoint 
     */
    @MavlinkMessageField(
        position = 8,
        length = 2
    )
    public final Builder targetAltitude(int targetAltitude) {
      this.targetAltitude = targetAltitude;
      return this;
    }

    /**
     * Heading (degrees / 2) 
     */
    @MavlinkMessageField(
        position = 9,
        length = 1
    )
    public final Builder heading(int heading) {
      this.heading = heading;
      return this;
    }

    /**
     * Heading setpoint (degrees / 2) 
     */
    @MavlinkMessageField(
        position = 10,
        length = 1
    )
    public final Builder targetHeading(int targetHeading) {
      this.targetHeading = targetHeading;
      return this;
    }

    /**
     * Distance to target waypoint or position (meters / 10) 
     */
    @MavlinkMessageField(
        position = 11,
        length = 2
    )
    public final Builder targetDistance(int targetDistance) {
      this.targetDistance = targetDistance;
      return this;
    }

    /**
     * Throttle (percentage) 
     */
    @MavlinkMessageField(
        position = 12,
        length = 1
    )
    public final Builder throttle(int throttle) {
      this.throttle = throttle;
      return this;
    }

    /**
     * Airspeed (m/s * 5) 
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
     * Airspeed setpoint (m/s * 5) 
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
     * Groundspeed (m/s * 5) 
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
     * Windspeed (m/s * 5) 
     */
    @MavlinkMessageField(
        position = 16,
        length = 1
    )
    public final Builder windspeed(int windspeed) {
      this.windspeed = windspeed;
      return this;
    }

    /**
     * Wind heading (deg / 2) 
     */
    @MavlinkMessageField(
        position = 17,
        length = 1
    )
    public final Builder windHeading(int windHeading) {
      this.windHeading = windHeading;
      return this;
    }

    /**
     * Maximum error horizontal position since last message (m * 10) 
     */
    @MavlinkMessageField(
        position = 18,
        length = 1
    )
    public final Builder eph(int eph) {
      this.eph = eph;
      return this;
    }

    /**
     * Maximum error vertical position since last message (m * 10) 
     */
    @MavlinkMessageField(
        position = 19,
        length = 1
    )
    public final Builder epv(int epv) {
      this.epv = epv;
      return this;
    }

    /**
     * Air temperature (degrees C) from airspeed sensor 
     */
    @MavlinkMessageField(
        position = 20,
        length = 1
    )
    public final Builder temperatureAir(int temperatureAir) {
      this.temperatureAir = temperatureAir;
      return this;
    }

    /**
     * Maximum climb rate magnitude since last message (m/s * 10) 
     */
    @MavlinkMessageField(
        position = 21,
        length = 1
    )
    public final Builder climbRate(int climbRate) {
      this.climbRate = climbRate;
      return this;
    }

    /**
     * Battery (percentage, -1 for DNU) 
     */
    @MavlinkMessageField(
        position = 22,
        length = 1
    )
    public final Builder battery(int battery) {
      this.battery = battery;
      return this;
    }

    /**
     * Current waypoint number 
     */
    @MavlinkMessageField(
        position = 23,
        length = 2
    )
    public final Builder wpNum(int wpNum) {
      this.wpNum = wpNum;
      return this;
    }

    /**
     * Indicates failures as defined in {@link io.dronefleet.mavlink.common.HlFailureFlag HlFailureFlag} ENUM. 
     */
    @MavlinkMessageField(
        position = 24,
        length = 2
    )
    public final Builder failureFlags(EnumFlagSet<HlFailureFlag> failureFlags) {
      this.failureFlags = failureFlags;
      return this;
    }

    /**
     * Field for custom payload. 
     */
    @MavlinkMessageField(
        position = 25,
        length = 1
    )
    public final Builder custom0(int custom0) {
      this.custom0 = custom0;
      return this;
    }

    /**
     * Field for custom payload. 
     */
    @MavlinkMessageField(
        position = 26,
        length = 1
    )
    public final Builder custom1(int custom1) {
      this.custom1 = custom1;
      return this;
    }

    /**
     * Field for custom payload. 
     */
    @MavlinkMessageField(
        position = 27,
        length = 1
    )
    public final Builder custom2(int custom2) {
      this.custom2 = custom2;
      return this;
    }

    public final HighLatency2 build() {
      return new HighLatency2(timestamp, type, autopilot, customMode, latitude, longitude, altitude, targetAltitude, heading, targetHeading, targetDistance, throttle, airspeed, airspeedSp, groundspeed, windspeed, windHeading, eph, epv, temperatureAir, climbRate, battery, wpNum, failureFlags, custom0, custom1, custom2);
    }
  }
}
