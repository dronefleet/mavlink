package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkMessage;
import io.dronefleet.mavlink.annotations.MavlinkMessageField;
import java.math.BigInteger;

/**
 * The global position, as returned by the Global Positioning System (GPS). This is NOT the global 
 * position estimate of the system, but rather a RAW sensor value. See message GLOBAL_POSITION 
 * for the global position estimate. 
 */
@MavlinkMessage(
    id = 24,
    crc = 24
)
public final class GpsRawInt {
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

  private final int altEllipsoid;

  private final long hAcc;

  private final long vAcc;

  private final long velAcc;

  private final long hdgAcc;

  private GpsRawInt(BigInteger timeUsec, GpsFixType fixType, int lat, int lon, int alt, int eph,
      int epv, int vel, int cog, int satellitesVisible, int altEllipsoid, long hAcc, long vAcc,
      long velAcc, long hdgAcc) {
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
    this.altEllipsoid = altEllipsoid;
    this.hAcc = hAcc;
    this.vAcc = vAcc;
    this.velAcc = velAcc;
    this.hdgAcc = hdgAcc;
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
   * Latitude (WGS84, EGM96 ellipsoid), in degrees * 1E7 
   */
  @MavlinkMessageField(
      position = 3,
      length = 4
  )
  public final int lat() {
    return lat;
  }

  /**
   * Longitude (WGS84, EGM96 ellipsoid), in degrees * 1E7 
   */
  @MavlinkMessageField(
      position = 4,
      length = 4
  )
  public final int lon() {
    return lon;
  }

  /**
   * Altitude (AMSL, NOT WGS84), in meters * 1000 (positive for up). Note that virtually all GPS 
   * modules provide the AMSL altitude in addition to the WGS84 altitude. 
   */
  @MavlinkMessageField(
      position = 5,
      length = 4
  )
  public final int alt() {
    return alt;
  }

  /**
   * GPS HDOP horizontal dilution of position (unitless). If unknown, set to: UINT16_MAX 
   */
  @MavlinkMessageField(
      position = 6,
      length = 2
  )
  public final int eph() {
    return eph;
  }

  /**
   * GPS VDOP vertical dilution of position (unitless). If unknown, set to: UINT16_MAX 
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
   * Altitude (above WGS84, EGM96 ellipsoid), in meters * 1000 (positive for up). 
   */
  @MavlinkMessageField(
      position = 12,
      length = 4,
      extension = true
  )
  public final int altEllipsoid() {
    return altEllipsoid;
  }

  /**
   * Position uncertainty in meters * 1000 (positive for up). 
   */
  @MavlinkMessageField(
      position = 13,
      length = 4,
      extension = true
  )
  public final long hAcc() {
    return hAcc;
  }

  /**
   * Altitude uncertainty in meters * 1000 (positive for up). 
   */
  @MavlinkMessageField(
      position = 14,
      length = 4,
      extension = true
  )
  public final long vAcc() {
    return vAcc;
  }

  /**
   * Speed uncertainty in meters * 1000 (positive for up). 
   */
  @MavlinkMessageField(
      position = 15,
      length = 4,
      extension = true
  )
  public final long velAcc() {
    return velAcc;
  }

  /**
   * Heading / track uncertainty in degrees * 1e5. 
   */
  @MavlinkMessageField(
      position = 16,
      length = 4,
      extension = true
  )
  public final long hdgAcc() {
    return hdgAcc;
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

    private int altEllipsoid;

    private long hAcc;

    private long vAcc;

    private long velAcc;

    private long hdgAcc;

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
     * Latitude (WGS84, EGM96 ellipsoid), in degrees * 1E7 
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
     * Longitude (WGS84, EGM96 ellipsoid), in degrees * 1E7 
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
     * Altitude (AMSL, NOT WGS84), in meters * 1000 (positive for up). Note that virtually all GPS 
     * modules provide the AMSL altitude in addition to the WGS84 altitude. 
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
     * GPS HDOP horizontal dilution of position (unitless). If unknown, set to: UINT16_MAX 
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
     * GPS VDOP vertical dilution of position (unitless). If unknown, set to: UINT16_MAX 
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
     * Altitude (above WGS84, EGM96 ellipsoid), in meters * 1000 (positive for up). 
     */
    @MavlinkMessageField(
        position = 12,
        length = 4,
        extension = true
    )
    public final Builder altEllipsoid(int altEllipsoid) {
      this.altEllipsoid = altEllipsoid;
      return this;
    }

    /**
     * Position uncertainty in meters * 1000 (positive for up). 
     */
    @MavlinkMessageField(
        position = 13,
        length = 4,
        extension = true
    )
    public final Builder hAcc(long hAcc) {
      this.hAcc = hAcc;
      return this;
    }

    /**
     * Altitude uncertainty in meters * 1000 (positive for up). 
     */
    @MavlinkMessageField(
        position = 14,
        length = 4,
        extension = true
    )
    public final Builder vAcc(long vAcc) {
      this.vAcc = vAcc;
      return this;
    }

    /**
     * Speed uncertainty in meters * 1000 (positive for up). 
     */
    @MavlinkMessageField(
        position = 15,
        length = 4,
        extension = true
    )
    public final Builder velAcc(long velAcc) {
      this.velAcc = velAcc;
      return this;
    }

    /**
     * Heading / track uncertainty in degrees * 1e5. 
     */
    @MavlinkMessageField(
        position = 16,
        length = 4,
        extension = true
    )
    public final Builder hdgAcc(long hdgAcc) {
      this.hdgAcc = hdgAcc;
      return this;
    }

    public final GpsRawInt build() {
      return new GpsRawInt(timeUsec, fixType, lat, lon, alt, eph, epv, vel, cog, satellitesVisible, altEllipsoid, hAcc, vAcc, velAcc, hdgAcc);
    }
  }
}
