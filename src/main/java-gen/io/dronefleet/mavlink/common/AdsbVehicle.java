package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkMessage;
import io.dronefleet.mavlink.annotations.MavlinkMessageField;
import io.dronefleet.mavlink.util.EnumFlagSet;
import java.lang.String;

/**
 * The location and information of an ADSB vehicle 
 */
@MavlinkMessage(
    id = 246,
    crc = 184
)
public final class AdsbVehicle {
  /**
   * ICAO address 
   */
  private final long icaoAddress;

  /**
   * Latitude, expressed as degrees * 1E7 
   */
  private final int lat;

  /**
   * Longitude, expressed as degrees * 1E7 
   */
  private final int lon;

  /**
   * Type from {@link io.dronefleet.mavlink.common.AdsbAltitudeType AdsbAltitudeType} enum 
   */
  private final AdsbAltitudeType altitudeType;

  /**
   * Altitude(ASL) in millimeters 
   */
  private final int altitude;

  /**
   * Course over ground in centidegrees 
   */
  private final int heading;

  /**
   * The horizontal velocity in centimeters/second 
   */
  private final int horVelocity;

  /**
   * The vertical velocity in centimeters/second, positive is up 
   */
  private final int verVelocity;

  /**
   * The callsign, 8+null 
   */
  private final String callsign;

  /**
   * Type from {@link io.dronefleet.mavlink.common.AdsbEmitterType AdsbEmitterType} enum 
   */
  private final AdsbEmitterType emitterType;

  /**
   * Time since last communication in seconds 
   */
  private final int tslc;

  /**
   * Flags to indicate various statuses including valid data fields 
   */
  private final EnumFlagSet<AdsbFlags> flags;

  /**
   * Squawk code 
   */
  private final int squawk;

  private AdsbVehicle(long icaoAddress, int lat, int lon, AdsbAltitudeType altitudeType,
      int altitude, int heading, int horVelocity, int verVelocity, String callsign,
      AdsbEmitterType emitterType, int tslc, EnumFlagSet<AdsbFlags> flags, int squawk) {
    this.icaoAddress = icaoAddress;
    this.lat = lat;
    this.lon = lon;
    this.altitudeType = altitudeType;
    this.altitude = altitude;
    this.heading = heading;
    this.horVelocity = horVelocity;
    this.verVelocity = verVelocity;
    this.callsign = callsign;
    this.emitterType = emitterType;
    this.tslc = tslc;
    this.flags = flags;
    this.squawk = squawk;
  }

  public static Builder builder() {
    return new Builder();
  }

  /**
   * ICAO address 
   */
  @MavlinkMessageField(
      position = 1,
      length = 4
  )
  public final long icaoAddress() {
    return icaoAddress;
  }

  /**
   * Latitude, expressed as degrees * 1E7 
   */
  @MavlinkMessageField(
      position = 2,
      length = 4
  )
  public final int lat() {
    return lat;
  }

  /**
   * Longitude, expressed as degrees * 1E7 
   */
  @MavlinkMessageField(
      position = 3,
      length = 4
  )
  public final int lon() {
    return lon;
  }

  /**
   * Type from {@link io.dronefleet.mavlink.common.AdsbAltitudeType AdsbAltitudeType} enum 
   */
  @MavlinkMessageField(
      position = 4,
      length = 1
  )
  public final AdsbAltitudeType altitudeType() {
    return altitudeType;
  }

  /**
   * Altitude(ASL) in millimeters 
   */
  @MavlinkMessageField(
      position = 5,
      length = 4
  )
  public final int altitude() {
    return altitude;
  }

  /**
   * Course over ground in centidegrees 
   */
  @MavlinkMessageField(
      position = 6,
      length = 2
  )
  public final int heading() {
    return heading;
  }

  /**
   * The horizontal velocity in centimeters/second 
   */
  @MavlinkMessageField(
      position = 7,
      length = 2
  )
  public final int horVelocity() {
    return horVelocity;
  }

  /**
   * The vertical velocity in centimeters/second, positive is up 
   */
  @MavlinkMessageField(
      position = 8,
      length = 2
  )
  public final int verVelocity() {
    return verVelocity;
  }

  /**
   * The callsign, 8+null 
   */
  @MavlinkMessageField(
      position = 9,
      length = 1,
      arraySize = 9
  )
  public final String callsign() {
    return callsign;
  }

  /**
   * Type from {@link io.dronefleet.mavlink.common.AdsbEmitterType AdsbEmitterType} enum 
   */
  @MavlinkMessageField(
      position = 10,
      length = 1
  )
  public final AdsbEmitterType emitterType() {
    return emitterType;
  }

  /**
   * Time since last communication in seconds 
   */
  @MavlinkMessageField(
      position = 11,
      length = 1
  )
  public final int tslc() {
    return tslc;
  }

  /**
   * Flags to indicate various statuses including valid data fields 
   */
  @MavlinkMessageField(
      position = 12,
      length = 2
  )
  public final EnumFlagSet<AdsbFlags> flags() {
    return flags;
  }

  /**
   * Squawk code 
   */
  @MavlinkMessageField(
      position = 13,
      length = 2
  )
  public final int squawk() {
    return squawk;
  }

  public static class Builder {
    private long icaoAddress;

    private int lat;

    private int lon;

    private AdsbAltitudeType altitudeType;

    private int altitude;

    private int heading;

    private int horVelocity;

    private int verVelocity;

    private String callsign;

    private AdsbEmitterType emitterType;

    private int tslc;

    private EnumFlagSet<AdsbFlags> flags;

    private int squawk;

    private Builder() {
    }

    /**
     * ICAO address 
     */
    @MavlinkMessageField(
        position = 1,
        length = 4
    )
    public final Builder icaoAddress(long icaoAddress) {
      this.icaoAddress = icaoAddress;
      return this;
    }

    /**
     * Latitude, expressed as degrees * 1E7 
     */
    @MavlinkMessageField(
        position = 2,
        length = 4
    )
    public final Builder lat(int lat) {
      this.lat = lat;
      return this;
    }

    /**
     * Longitude, expressed as degrees * 1E7 
     */
    @MavlinkMessageField(
        position = 3,
        length = 4
    )
    public final Builder lon(int lon) {
      this.lon = lon;
      return this;
    }

    /**
     * Type from {@link io.dronefleet.mavlink.common.AdsbAltitudeType AdsbAltitudeType} enum 
     */
    @MavlinkMessageField(
        position = 4,
        length = 1
    )
    public final Builder altitudeType(AdsbAltitudeType altitudeType) {
      this.altitudeType = altitudeType;
      return this;
    }

    /**
     * Altitude(ASL) in millimeters 
     */
    @MavlinkMessageField(
        position = 5,
        length = 4
    )
    public final Builder altitude(int altitude) {
      this.altitude = altitude;
      return this;
    }

    /**
     * Course over ground in centidegrees 
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
     * The horizontal velocity in centimeters/second 
     */
    @MavlinkMessageField(
        position = 7,
        length = 2
    )
    public final Builder horVelocity(int horVelocity) {
      this.horVelocity = horVelocity;
      return this;
    }

    /**
     * The vertical velocity in centimeters/second, positive is up 
     */
    @MavlinkMessageField(
        position = 8,
        length = 2
    )
    public final Builder verVelocity(int verVelocity) {
      this.verVelocity = verVelocity;
      return this;
    }

    /**
     * The callsign, 8+null 
     */
    @MavlinkMessageField(
        position = 9,
        length = 1,
        arraySize = 9
    )
    public final Builder callsign(String callsign) {
      this.callsign = callsign;
      return this;
    }

    /**
     * Type from {@link io.dronefleet.mavlink.common.AdsbEmitterType AdsbEmitterType} enum 
     */
    @MavlinkMessageField(
        position = 10,
        length = 1
    )
    public final Builder emitterType(AdsbEmitterType emitterType) {
      this.emitterType = emitterType;
      return this;
    }

    /**
     * Time since last communication in seconds 
     */
    @MavlinkMessageField(
        position = 11,
        length = 1
    )
    public final Builder tslc(int tslc) {
      this.tslc = tslc;
      return this;
    }

    /**
     * Flags to indicate various statuses including valid data fields 
     */
    @MavlinkMessageField(
        position = 12,
        length = 2
    )
    public final Builder flags(EnumFlagSet<AdsbFlags> flags) {
      this.flags = flags;
      return this;
    }

    /**
     * Squawk code 
     */
    @MavlinkMessageField(
        position = 13,
        length = 2
    )
    public final Builder squawk(int squawk) {
      this.squawk = squawk;
      return this;
    }

    public final AdsbVehicle build() {
      return new AdsbVehicle(icaoAddress, lat, lon, altitudeType, altitude, heading, horVelocity, verVelocity, callsign, emitterType, tslc, flags, squawk);
    }
  }
}
