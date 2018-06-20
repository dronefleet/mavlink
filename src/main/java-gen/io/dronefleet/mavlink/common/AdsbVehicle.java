package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import io.dronefleet.mavlink.util.EnumFlagSet;
import java.lang.Override;
import java.lang.String;

/**
 * The location and information of an ADSB vehicle 
 */
@MavlinkMessageInfo(
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
   * Flags to indicate various statuses including valid data fields 
   */
  private final EnumFlagSet<AdsbFlags> flags;

  /**
   * Squawk code 
   */
  private final int squawk;

  /**
   * Type from {@link io.dronefleet.mavlink.common.AdsbAltitudeType AdsbAltitudeType} enum 
   */
  private final AdsbAltitudeType altitudeType;

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

  private AdsbVehicle(long icaoAddress, int lat, int lon, int altitude, int heading,
      int horVelocity, int verVelocity, EnumFlagSet<AdsbFlags> flags, int squawk,
      AdsbAltitudeType altitudeType, String callsign, AdsbEmitterType emitterType, int tslc) {
    this.icaoAddress = icaoAddress;
    this.lat = lat;
    this.lon = lon;
    this.altitude = altitude;
    this.heading = heading;
    this.horVelocity = horVelocity;
    this.verVelocity = verVelocity;
    this.flags = flags;
    this.squawk = squawk;
    this.altitudeType = altitudeType;
    this.callsign = callsign;
    this.emitterType = emitterType;
    this.tslc = tslc;
  }

  @MavlinkMessageBuilder
  public static Builder builder() {
    return new Builder();
  }

  @Override
  public String toString() {
    return "AdsbVehicle{icaoAddress=" + icaoAddress
         + ", lat=" + lat
         + ", lon=" + lon
         + ", altitudeType=" + altitudeType
         + ", altitude=" + altitude
         + ", heading=" + heading
         + ", horVelocity=" + horVelocity
         + ", verVelocity=" + verVelocity
         + ", callsign=" + callsign
         + ", emitterType=" + emitterType
         + ", tslc=" + tslc
         + ", flags=" + flags
         + ", squawk=" + squawk + "}";
  }

  /**
   * ICAO address 
   */
  @MavlinkFieldInfo(
      position = 1,
      unitSize = 4
  )
  public final long icaoAddress() {
    return icaoAddress;
  }

  /**
   * Latitude, expressed as degrees * 1E7 
   */
  @MavlinkFieldInfo(
      position = 2,
      unitSize = 4
  )
  public final int lat() {
    return lat;
  }

  /**
   * Longitude, expressed as degrees * 1E7 
   */
  @MavlinkFieldInfo(
      position = 3,
      unitSize = 4
  )
  public final int lon() {
    return lon;
  }

  /**
   * Altitude(ASL) in millimeters 
   */
  @MavlinkFieldInfo(
      position = 5,
      unitSize = 4
  )
  public final int altitude() {
    return altitude;
  }

  /**
   * Course over ground in centidegrees 
   */
  @MavlinkFieldInfo(
      position = 6,
      unitSize = 2
  )
  public final int heading() {
    return heading;
  }

  /**
   * The horizontal velocity in centimeters/second 
   */
  @MavlinkFieldInfo(
      position = 7,
      unitSize = 2
  )
  public final int horVelocity() {
    return horVelocity;
  }

  /**
   * The vertical velocity in centimeters/second, positive is up 
   */
  @MavlinkFieldInfo(
      position = 8,
      unitSize = 2
  )
  public final int verVelocity() {
    return verVelocity;
  }

  /**
   * Flags to indicate various statuses including valid data fields 
   */
  @MavlinkFieldInfo(
      position = 12,
      unitSize = 2
  )
  public final EnumFlagSet<AdsbFlags> flags() {
    return flags;
  }

  /**
   * Squawk code 
   */
  @MavlinkFieldInfo(
      position = 13,
      unitSize = 2
  )
  public final int squawk() {
    return squawk;
  }

  /**
   * Type from {@link io.dronefleet.mavlink.common.AdsbAltitudeType AdsbAltitudeType} enum 
   */
  @MavlinkFieldInfo(
      position = 4,
      unitSize = 1
  )
  public final AdsbAltitudeType altitudeType() {
    return altitudeType;
  }

  /**
   * The callsign, 8+null 
   */
  @MavlinkFieldInfo(
      position = 9,
      unitSize = 1,
      arraySize = 9
  )
  public final String callsign() {
    return callsign;
  }

  /**
   * Type from {@link io.dronefleet.mavlink.common.AdsbEmitterType AdsbEmitterType} enum 
   */
  @MavlinkFieldInfo(
      position = 10,
      unitSize = 1
  )
  public final AdsbEmitterType emitterType() {
    return emitterType;
  }

  /**
   * Time since last communication in seconds 
   */
  @MavlinkFieldInfo(
      position = 11,
      unitSize = 1
  )
  public final int tslc() {
    return tslc;
  }

  public static class Builder {
    private long icaoAddress;

    private int lat;

    private int lon;

    private int altitude;

    private int heading;

    private int horVelocity;

    private int verVelocity;

    private EnumFlagSet<AdsbFlags> flags;

    private int squawk;

    private AdsbAltitudeType altitudeType;

    private String callsign;

    private AdsbEmitterType emitterType;

    private int tslc;

    private Builder() {
    }

    /**
     * ICAO address 
     */
    @MavlinkFieldInfo(
        position = 1,
        unitSize = 4
    )
    public final Builder icaoAddress(long icaoAddress) {
      this.icaoAddress = icaoAddress;
      return this;
    }

    /**
     * Latitude, expressed as degrees * 1E7 
     */
    @MavlinkFieldInfo(
        position = 2,
        unitSize = 4
    )
    public final Builder lat(int lat) {
      this.lat = lat;
      return this;
    }

    /**
     * Longitude, expressed as degrees * 1E7 
     */
    @MavlinkFieldInfo(
        position = 3,
        unitSize = 4
    )
    public final Builder lon(int lon) {
      this.lon = lon;
      return this;
    }

    /**
     * Altitude(ASL) in millimeters 
     */
    @MavlinkFieldInfo(
        position = 5,
        unitSize = 4
    )
    public final Builder altitude(int altitude) {
      this.altitude = altitude;
      return this;
    }

    /**
     * Course over ground in centidegrees 
     */
    @MavlinkFieldInfo(
        position = 6,
        unitSize = 2
    )
    public final Builder heading(int heading) {
      this.heading = heading;
      return this;
    }

    /**
     * The horizontal velocity in centimeters/second 
     */
    @MavlinkFieldInfo(
        position = 7,
        unitSize = 2
    )
    public final Builder horVelocity(int horVelocity) {
      this.horVelocity = horVelocity;
      return this;
    }

    /**
     * The vertical velocity in centimeters/second, positive is up 
     */
    @MavlinkFieldInfo(
        position = 8,
        unitSize = 2
    )
    public final Builder verVelocity(int verVelocity) {
      this.verVelocity = verVelocity;
      return this;
    }

    /**
     * Flags to indicate various statuses including valid data fields 
     */
    @MavlinkFieldInfo(
        position = 12,
        unitSize = 2
    )
    public final Builder flags(EnumFlagSet<AdsbFlags> flags) {
      this.flags = flags;
      return this;
    }

    /**
     * Squawk code 
     */
    @MavlinkFieldInfo(
        position = 13,
        unitSize = 2
    )
    public final Builder squawk(int squawk) {
      this.squawk = squawk;
      return this;
    }

    /**
     * Type from {@link io.dronefleet.mavlink.common.AdsbAltitudeType AdsbAltitudeType} enum 
     */
    @MavlinkFieldInfo(
        position = 4,
        unitSize = 1
    )
    public final Builder altitudeType(AdsbAltitudeType altitudeType) {
      this.altitudeType = altitudeType;
      return this;
    }

    /**
     * The callsign, 8+null 
     */
    @MavlinkFieldInfo(
        position = 9,
        unitSize = 1,
        arraySize = 9
    )
    public final Builder callsign(String callsign) {
      this.callsign = callsign;
      return this;
    }

    /**
     * Type from {@link io.dronefleet.mavlink.common.AdsbEmitterType AdsbEmitterType} enum 
     */
    @MavlinkFieldInfo(
        position = 10,
        unitSize = 1
    )
    public final Builder emitterType(AdsbEmitterType emitterType) {
      this.emitterType = emitterType;
      return this;
    }

    /**
     * Time since last communication in seconds 
     */
    @MavlinkFieldInfo(
        position = 11,
        unitSize = 1
    )
    public final Builder tslc(int tslc) {
      this.tslc = tslc;
      return this;
    }

    public final AdsbVehicle build() {
      return new AdsbVehicle(icaoAddress, lat, lon, altitude, heading, horVelocity, verVelocity, flags, squawk, altitudeType, callsign, emitterType, tslc);
    }
  }
}
