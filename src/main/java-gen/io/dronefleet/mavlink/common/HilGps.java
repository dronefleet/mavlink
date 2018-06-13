package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkMessage;
import io.dronefleet.mavlink.annotations.MavlinkMessageField;
import java.math.BigInteger;

/**
 * The global position, as returned by the Global Positioning System (GPS). This is NOT the global 
 * position estimate of the sytem, but rather a RAW sensor value. See message GLOBAL_POSITION for 
 * the global position estimate. 
 */
@MavlinkMessage(
    id = 113,
    crc = 124
)
public final class HilGps {
  /**
   * Timestamp (microseconds since UNIX epoch or microseconds since system boot) 
   */
  private final BigInteger timeUsec;

  /**
   * 0-1: no fix, 2: 2D fix, 3: 3D fix. Some applications will not use the value of this field unless it 
   * is at least two, so always correctly fill in the fix. 
   */
  private final int fixType;

  /**
   * Latitude (WGS84), in degrees * 1E7 
   */
  private final int lat;

  /**
   * Longitude (WGS84), in degrees * 1E7 
   */
  private final int lon;

  /**
   * Altitude (AMSL, not WGS84), in meters * 1000 (positive for up) 
   */
  private final int alt;

  /**
   * GPS HDOP horizontal dilution of position in cm (m*100). If unknown, set to: 65535 
   */
  private final int eph;

  /**
   * GPS VDOP vertical dilution of position in cm (m*100). If unknown, set to: 65535 
   */
  private final int epv;

  /**
   * GPS ground speed in cm/s. If unknown, set to: 65535 
   */
  private final int vel;

  /**
   * GPS velocity in cm/s in NORTH direction in earth-fixed NED frame 
   */
  private final int vn;

  /**
   * GPS velocity in cm/s in EAST direction in earth-fixed NED frame 
   */
  private final int ve;

  /**
   * GPS velocity in cm/s in DOWN direction in earth-fixed NED frame 
   */
  private final int vd;

  /**
   * Course over ground (NOT heading, but direction of movement) in degrees * 100, 0.0..359.99 
   * degrees. If unknown, set to: 65535 
   */
  private final int cog;

  /**
   * Number of satellites visible. If unknown, set to 255 
   */
  private final int satellitesVisible;

  private HilGps(BigInteger timeUsec, int fixType, int lat, int lon, int alt, int eph, int epv,
      int vel, int vn, int ve, int vd, int cog, int satellitesVisible) {
    this.timeUsec = timeUsec;
    this.fixType = fixType;
    this.lat = lat;
    this.lon = lon;
    this.alt = alt;
    this.eph = eph;
    this.epv = epv;
    this.vel = vel;
    this.vn = vn;
    this.ve = ve;
    this.vd = vd;
    this.cog = cog;
    this.satellitesVisible = satellitesVisible;
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
   * 0-1: no fix, 2: 2D fix, 3: 3D fix. Some applications will not use the value of this field unless it 
   * is at least two, so always correctly fill in the fix. 
   */
  @MavlinkMessageField(
      position = 2,
      length = 1
  )
  public final int fixType() {
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
   * GPS HDOP horizontal dilution of position in cm (m*100). If unknown, set to: 65535 
   */
  @MavlinkMessageField(
      position = 6,
      length = 2
  )
  public final int eph() {
    return eph;
  }

  /**
   * GPS VDOP vertical dilution of position in cm (m*100). If unknown, set to: 65535 
   */
  @MavlinkMessageField(
      position = 7,
      length = 2
  )
  public final int epv() {
    return epv;
  }

  /**
   * GPS ground speed in cm/s. If unknown, set to: 65535 
   */
  @MavlinkMessageField(
      position = 8,
      length = 2
  )
  public final int vel() {
    return vel;
  }

  /**
   * GPS velocity in cm/s in NORTH direction in earth-fixed NED frame 
   */
  @MavlinkMessageField(
      position = 9,
      length = 2
  )
  public final int vn() {
    return vn;
  }

  /**
   * GPS velocity in cm/s in EAST direction in earth-fixed NED frame 
   */
  @MavlinkMessageField(
      position = 10,
      length = 2
  )
  public final int ve() {
    return ve;
  }

  /**
   * GPS velocity in cm/s in DOWN direction in earth-fixed NED frame 
   */
  @MavlinkMessageField(
      position = 11,
      length = 2
  )
  public final int vd() {
    return vd;
  }

  /**
   * Course over ground (NOT heading, but direction of movement) in degrees * 100, 0.0..359.99 
   * degrees. If unknown, set to: 65535 
   */
  @MavlinkMessageField(
      position = 12,
      length = 2
  )
  public final int cog() {
    return cog;
  }

  /**
   * Number of satellites visible. If unknown, set to 255 
   */
  @MavlinkMessageField(
      position = 13,
      length = 1
  )
  public final int satellitesVisible() {
    return satellitesVisible;
  }

  public static class Builder {
    private BigInteger timeUsec;

    private int fixType;

    private int lat;

    private int lon;

    private int alt;

    private int eph;

    private int epv;

    private int vel;

    private int vn;

    private int ve;

    private int vd;

    private int cog;

    private int satellitesVisible;

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
     * 0-1: no fix, 2: 2D fix, 3: 3D fix. Some applications will not use the value of this field unless it 
     * is at least two, so always correctly fill in the fix. 
     */
    @MavlinkMessageField(
        position = 2,
        length = 1
    )
    public final Builder fixType(int fixType) {
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
     * GPS HDOP horizontal dilution of position in cm (m*100). If unknown, set to: 65535 
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
     * GPS VDOP vertical dilution of position in cm (m*100). If unknown, set to: 65535 
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
     * GPS ground speed in cm/s. If unknown, set to: 65535 
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
     * GPS velocity in cm/s in NORTH direction in earth-fixed NED frame 
     */
    @MavlinkMessageField(
        position = 9,
        length = 2
    )
    public final Builder vn(int vn) {
      this.vn = vn;
      return this;
    }

    /**
     * GPS velocity in cm/s in EAST direction in earth-fixed NED frame 
     */
    @MavlinkMessageField(
        position = 10,
        length = 2
    )
    public final Builder ve(int ve) {
      this.ve = ve;
      return this;
    }

    /**
     * GPS velocity in cm/s in DOWN direction in earth-fixed NED frame 
     */
    @MavlinkMessageField(
        position = 11,
        length = 2
    )
    public final Builder vd(int vd) {
      this.vd = vd;
      return this;
    }

    /**
     * Course over ground (NOT heading, but direction of movement) in degrees * 100, 0.0..359.99 
     * degrees. If unknown, set to: 65535 
     */
    @MavlinkMessageField(
        position = 12,
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
        position = 13,
        length = 1
    )
    public final Builder satellitesVisible(int satellitesVisible) {
      this.satellitesVisible = satellitesVisible;
      return this;
    }

    public final HilGps build() {
      return new HilGps(timeUsec, fixType, lat, lon, alt, eph, epv, vel, vn, ve, vd, cog, satellitesVisible);
    }
  }
}
