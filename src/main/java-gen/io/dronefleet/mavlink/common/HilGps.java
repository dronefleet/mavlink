package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import java.lang.Override;
import java.lang.String;
import java.math.BigInteger;

/**
 * The global position, as returned by the Global Positioning System (GPS). This is NOT the global 
 * position estimate of the sytem, but rather a RAW sensor value. See message GLOBAL_POSITION for 
 * the global position estimate. 
 */
@MavlinkMessageInfo(
    id = 113,
    crc = 124
)
public final class HilGps {
  /**
   * Timestamp (microseconds since UNIX epoch or microseconds since system boot) 
   */
  private final BigInteger timeUsec;

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
   * 0-1: no fix, 2: 2D fix, 3: 3D fix. Some applications will not use the value of this field unless it 
   * is at least two, so always correctly fill in the fix. 
   */
  private final int fixType;

  /**
   * Number of satellites visible. If unknown, set to 255 
   */
  private final int satellitesVisible;

  private HilGps(BigInteger timeUsec, int lat, int lon, int alt, int eph, int epv, int vel, int vn,
      int ve, int vd, int cog, int fixType, int satellitesVisible) {
    this.timeUsec = timeUsec;
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
    this.fixType = fixType;
    this.satellitesVisible = satellitesVisible;
  }

  @MavlinkMessageBuilder
  public static Builder builder() {
    return new Builder();
  }

  @Override
  public String toString() {
    return "HilGps{timeUsec=" + timeUsec
         + ", fixType=" + fixType
         + ", lat=" + lat
         + ", lon=" + lon
         + ", alt=" + alt
         + ", eph=" + eph
         + ", epv=" + epv
         + ", vel=" + vel
         + ", vn=" + vn
         + ", ve=" + ve
         + ", vd=" + vd
         + ", cog=" + cog
         + ", satellitesVisible=" + satellitesVisible + "}";
  }

  /**
   * Timestamp (microseconds since UNIX epoch or microseconds since system boot) 
   */
  @MavlinkFieldInfo(
      position = 1,
      unitSize = 8
  )
  public final BigInteger timeUsec() {
    return timeUsec;
  }

  /**
   * Latitude (WGS84), in degrees * 1E7 
   */
  @MavlinkFieldInfo(
      position = 3,
      unitSize = 4
  )
  public final int lat() {
    return lat;
  }

  /**
   * Longitude (WGS84), in degrees * 1E7 
   */
  @MavlinkFieldInfo(
      position = 4,
      unitSize = 4
  )
  public final int lon() {
    return lon;
  }

  /**
   * Altitude (AMSL, not WGS84), in meters * 1000 (positive for up) 
   */
  @MavlinkFieldInfo(
      position = 5,
      unitSize = 4
  )
  public final int alt() {
    return alt;
  }

  /**
   * GPS HDOP horizontal dilution of position in cm (m*100). If unknown, set to: 65535 
   */
  @MavlinkFieldInfo(
      position = 6,
      unitSize = 2
  )
  public final int eph() {
    return eph;
  }

  /**
   * GPS VDOP vertical dilution of position in cm (m*100). If unknown, set to: 65535 
   */
  @MavlinkFieldInfo(
      position = 7,
      unitSize = 2
  )
  public final int epv() {
    return epv;
  }

  /**
   * GPS ground speed in cm/s. If unknown, set to: 65535 
   */
  @MavlinkFieldInfo(
      position = 8,
      unitSize = 2
  )
  public final int vel() {
    return vel;
  }

  /**
   * GPS velocity in cm/s in NORTH direction in earth-fixed NED frame 
   */
  @MavlinkFieldInfo(
      position = 9,
      unitSize = 2
  )
  public final int vn() {
    return vn;
  }

  /**
   * GPS velocity in cm/s in EAST direction in earth-fixed NED frame 
   */
  @MavlinkFieldInfo(
      position = 10,
      unitSize = 2
  )
  public final int ve() {
    return ve;
  }

  /**
   * GPS velocity in cm/s in DOWN direction in earth-fixed NED frame 
   */
  @MavlinkFieldInfo(
      position = 11,
      unitSize = 2
  )
  public final int vd() {
    return vd;
  }

  /**
   * Course over ground (NOT heading, but direction of movement) in degrees * 100, 0.0..359.99 
   * degrees. If unknown, set to: 65535 
   */
  @MavlinkFieldInfo(
      position = 12,
      unitSize = 2
  )
  public final int cog() {
    return cog;
  }

  /**
   * 0-1: no fix, 2: 2D fix, 3: 3D fix. Some applications will not use the value of this field unless it 
   * is at least two, so always correctly fill in the fix. 
   */
  @MavlinkFieldInfo(
      position = 2,
      unitSize = 1
  )
  public final int fixType() {
    return fixType;
  }

  /**
   * Number of satellites visible. If unknown, set to 255 
   */
  @MavlinkFieldInfo(
      position = 13,
      unitSize = 1
  )
  public final int satellitesVisible() {
    return satellitesVisible;
  }

  public static class Builder {
    private BigInteger timeUsec;

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

    private int fixType;

    private int satellitesVisible;

    private Builder() {
    }

    /**
     * Timestamp (microseconds since UNIX epoch or microseconds since system boot) 
     */
    @MavlinkFieldInfo(
        position = 1,
        unitSize = 8
    )
    public final Builder timeUsec(BigInteger timeUsec) {
      this.timeUsec = timeUsec;
      return this;
    }

    /**
     * Latitude (WGS84), in degrees * 1E7 
     */
    @MavlinkFieldInfo(
        position = 3,
        unitSize = 4
    )
    public final Builder lat(int lat) {
      this.lat = lat;
      return this;
    }

    /**
     * Longitude (WGS84), in degrees * 1E7 
     */
    @MavlinkFieldInfo(
        position = 4,
        unitSize = 4
    )
    public final Builder lon(int lon) {
      this.lon = lon;
      return this;
    }

    /**
     * Altitude (AMSL, not WGS84), in meters * 1000 (positive for up) 
     */
    @MavlinkFieldInfo(
        position = 5,
        unitSize = 4
    )
    public final Builder alt(int alt) {
      this.alt = alt;
      return this;
    }

    /**
     * GPS HDOP horizontal dilution of position in cm (m*100). If unknown, set to: 65535 
     */
    @MavlinkFieldInfo(
        position = 6,
        unitSize = 2
    )
    public final Builder eph(int eph) {
      this.eph = eph;
      return this;
    }

    /**
     * GPS VDOP vertical dilution of position in cm (m*100). If unknown, set to: 65535 
     */
    @MavlinkFieldInfo(
        position = 7,
        unitSize = 2
    )
    public final Builder epv(int epv) {
      this.epv = epv;
      return this;
    }

    /**
     * GPS ground speed in cm/s. If unknown, set to: 65535 
     */
    @MavlinkFieldInfo(
        position = 8,
        unitSize = 2
    )
    public final Builder vel(int vel) {
      this.vel = vel;
      return this;
    }

    /**
     * GPS velocity in cm/s in NORTH direction in earth-fixed NED frame 
     */
    @MavlinkFieldInfo(
        position = 9,
        unitSize = 2
    )
    public final Builder vn(int vn) {
      this.vn = vn;
      return this;
    }

    /**
     * GPS velocity in cm/s in EAST direction in earth-fixed NED frame 
     */
    @MavlinkFieldInfo(
        position = 10,
        unitSize = 2
    )
    public final Builder ve(int ve) {
      this.ve = ve;
      return this;
    }

    /**
     * GPS velocity in cm/s in DOWN direction in earth-fixed NED frame 
     */
    @MavlinkFieldInfo(
        position = 11,
        unitSize = 2
    )
    public final Builder vd(int vd) {
      this.vd = vd;
      return this;
    }

    /**
     * Course over ground (NOT heading, but direction of movement) in degrees * 100, 0.0..359.99 
     * degrees. If unknown, set to: 65535 
     */
    @MavlinkFieldInfo(
        position = 12,
        unitSize = 2
    )
    public final Builder cog(int cog) {
      this.cog = cog;
      return this;
    }

    /**
     * 0-1: no fix, 2: 2D fix, 3: 3D fix. Some applications will not use the value of this field unless it 
     * is at least two, so always correctly fill in the fix. 
     */
    @MavlinkFieldInfo(
        position = 2,
        unitSize = 1
    )
    public final Builder fixType(int fixType) {
      this.fixType = fixType;
      return this;
    }

    /**
     * Number of satellites visible. If unknown, set to 255 
     */
    @MavlinkFieldInfo(
        position = 13,
        unitSize = 1
    )
    public final Builder satellitesVisible(int satellitesVisible) {
      this.satellitesVisible = satellitesVisible;
      return this;
    }

    public final HilGps build() {
      return new HilGps(timeUsec, lat, lon, alt, eph, epv, vel, vn, ve, vd, cog, fixType, satellitesVisible);
    }
  }
}
