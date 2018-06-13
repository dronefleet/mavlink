package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkMessage;
import io.dronefleet.mavlink.annotations.MavlinkMessageField;
import java.math.BigInteger;

/**
 * Second GPS data. 
 */
@MavlinkMessage(
    id = 124,
    crc = 87
)
public final class Gps2Raw {
  private final BigInteger timeUsec;

  private final GpsFixType fixType;

  private final int lat;

  private final int lon;

  private final int alt;

  private final int eph;

  private final int epv;

  private final int vel;

  private final int cog;

  private final int satellitesVisible;

  private final int dgpsNumch;

  private final long dgpsAge;

  private Gps2Raw(BigInteger timeUsec, GpsFixType fixType, int lat, int lon, int alt, int eph,
      int epv, int vel, int cog, int satellitesVisible, int dgpsNumch, long dgpsAge) {
    this.timeUsec = timeUsec;
    this.fixType = fixType;
    this.lat = lat;
    this.lon = lon;
    this.alt = alt;
    this.eph = eph;
    this.epv = epv;
    this.vel = vel;
    this.cog = cog;
    this.satellitesVisible = satellitesVisible;
    this.dgpsNumch = dgpsNumch;
    this.dgpsAge = dgpsAge;
  }

  public static Builder builder() {
    return new Builder();
  }

  /**
   * Timestamp (microseconds since UNIX epoch or microseconds since system boot) 
   */
  @MavlinkMessageField(
      position = 1,
      length = 8
  )
  public final BigInteger timeUsec() {
    return timeUsec;
  }

  /**
   * See the GPS_FIX_TYPE enum. 
   */
  @MavlinkMessageField(
      position = 2,
      length = 1
  )
  public final GpsFixType fixType() {
    return fixType;
  }

  /**
   * Latitude (WGS84), in degrees * 1E7 
   */
  @MavlinkMessageField(
      position = 3,
      length = 4
  )
  public final int lat() {
    return lat;
  }

  /**
   * Longitude (WGS84), in degrees * 1E7 
   */
  @MavlinkMessageField(
      position = 4,
      length = 4
  )
  public final int lon() {
    return lon;
  }

  /**
   * Altitude (AMSL, not WGS84), in meters * 1000 (positive for up) 
   */
  @MavlinkMessageField(
      position = 5,
      length = 4
  )
  public final int alt() {
    return alt;
  }

  /**
   * GPS HDOP horizontal dilution of position in cm (m*100). If unknown, set to: UINT16_MAX 
   */
  @MavlinkMessageField(
      position = 6,
      length = 2
  )
  public final int eph() {
    return eph;
  }

  /**
   * GPS VDOP vertical dilution of position in cm (m*100). If unknown, set to: UINT16_MAX 
   */
  @MavlinkMessageField(
      position = 7,
      length = 2
  )
  public final int epv() {
    return epv;
  }

  /**
   * GPS ground speed (m/s * 100). If unknown, set to: UINT16_MAX 
   */
  @MavlinkMessageField(
      position = 8,
      length = 2
  )
  public final int vel() {
    return vel;
  }

  /**
   * Course over ground (NOT heading, but direction of movement) in degrees * 100, 0.0..359.99 
   * degrees. If unknown, set to: UINT16_MAX 
   */
  @MavlinkMessageField(
      position = 9,
      length = 2
  )
  public final int cog() {
    return cog;
  }

  /**
   * Number of satellites visible. If unknown, set to 255 
   */
  @MavlinkMessageField(
      position = 10,
      length = 1
  )
  public final int satellitesVisible() {
    return satellitesVisible;
  }

  /**
   * Number of DGPS satellites 
   */
  @MavlinkMessageField(
      position = 11,
      length = 1
  )
  public final int dgpsNumch() {
    return dgpsNumch;
  }

  /**
   * Age of DGPS info 
   */
  @MavlinkMessageField(
      position = 12,
      length = 4
  )
  public final long dgpsAge() {
    return dgpsAge;
  }

  public class Builder {
    private BigInteger timeUsec;

    private GpsFixType fixType;

    private int lat;

    private int lon;

    private int alt;

    private int eph;

    private int epv;

    private int vel;

    private int cog;

    private int satellitesVisible;

    private int dgpsNumch;

    private long dgpsAge;

    private Builder() {
    }

    /**
     * Timestamp (microseconds since UNIX epoch or microseconds since system boot) 
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
     * See the GPS_FIX_TYPE enum. 
     */
    @MavlinkMessageField(
        position = 2,
        length = 1
    )
    public final Builder fixType(GpsFixType fixType) {
      this.fixType = fixType;
      return this;
    }

    /**
     * Latitude (WGS84), in degrees * 1E7 
     */
    @MavlinkMessageField(
        position = 3,
        length = 4
    )
    public final Builder lat(int lat) {
      this.lat = lat;
      return this;
    }

    /**
     * Longitude (WGS84), in degrees * 1E7 
     */
    @MavlinkMessageField(
        position = 4,
        length = 4
    )
    public final Builder lon(int lon) {
      this.lon = lon;
      return this;
    }

    /**
     * Altitude (AMSL, not WGS84), in meters * 1000 (positive for up) 
     */
    @MavlinkMessageField(
        position = 5,
        length = 4
    )
    public final Builder alt(int alt) {
      this.alt = alt;
      return this;
    }

    /**
     * GPS HDOP horizontal dilution of position in cm (m*100). If unknown, set to: UINT16_MAX 
     */
    @MavlinkMessageField(
        position = 6,
        length = 2
    )
    public final Builder eph(int eph) {
      this.eph = eph;
      return this;
    }

    /**
     * GPS VDOP vertical dilution of position in cm (m*100). If unknown, set to: UINT16_MAX 
     */
    @MavlinkMessageField(
        position = 7,
        length = 2
    )
    public final Builder epv(int epv) {
      this.epv = epv;
      return this;
    }

    /**
     * GPS ground speed (m/s * 100). If unknown, set to: UINT16_MAX 
     */
    @MavlinkMessageField(
        position = 8,
        length = 2
    )
    public final Builder vel(int vel) {
      this.vel = vel;
      return this;
    }

    /**
     * Course over ground (NOT heading, but direction of movement) in degrees * 100, 0.0..359.99 
     * degrees. If unknown, set to: UINT16_MAX 
     */
    @MavlinkMessageField(
        position = 9,
        length = 2
    )
    public final Builder cog(int cog) {
      this.cog = cog;
      return this;
    }

    /**
     * Number of satellites visible. If unknown, set to 255 
     */
    @MavlinkMessageField(
        position = 10,
        length = 1
    )
    public final Builder satellitesVisible(int satellitesVisible) {
      this.satellitesVisible = satellitesVisible;
      return this;
    }

    /**
     * Number of DGPS satellites 
     */
    @MavlinkMessageField(
        position = 11,
        length = 1
    )
    public final Builder dgpsNumch(int dgpsNumch) {
      this.dgpsNumch = dgpsNumch;
      return this;
    }

    /**
     * Age of DGPS info 
     */
    @MavlinkMessageField(
        position = 12,
        length = 4
    )
    public final Builder dgpsAge(long dgpsAge) {
      this.dgpsAge = dgpsAge;
      return this;
    }

    public final Gps2Raw build() {
      return new Gps2Raw(timeUsec, fixType, lat, lon, alt, eph, epv, vel, cog, satellitesVisible, dgpsNumch, dgpsAge);
    }
  }
}
