package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkMessage;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageField;
import io.dronefleet.mavlink.util.EnumFlagSet;
import java.lang.Override;
import java.lang.String;
import java.math.BigInteger;

/**
 * GPS sensor input message. This is a raw sensor value sent by the GPS. This is NOT the global 
 * position estimate of the sytem. 
 */
@MavlinkMessage(
    id = 232,
    crc = 151
)
public final class GpsInput {
  /**
   * Timestamp (micros since boot or Unix epoch) 
   */
  private final BigInteger timeUsec;

  /**
   * GPS time (milliseconds from start of GPS week) 
   */
  private final long timeWeekMs;

  /**
   * Latitude (WGS84), in degrees * 1E7 
   */
  private final int lat;

  /**
   * Longitude (WGS84), in degrees * 1E7 
   */
  private final int lon;

  /**
   * Altitude (AMSL, not WGS84), in m (positive for up) 
   */
  private final float alt;

  /**
   * GPS HDOP horizontal dilution of position in m 
   */
  private final float hdop;

  /**
   * GPS VDOP vertical dilution of position in m 
   */
  private final float vdop;

  /**
   * GPS velocity in m/s in NORTH direction in earth-fixed NED frame 
   */
  private final float vn;

  /**
   * GPS velocity in m/s in EAST direction in earth-fixed NED frame 
   */
  private final float ve;

  /**
   * GPS velocity in m/s in DOWN direction in earth-fixed NED frame 
   */
  private final float vd;

  /**
   * GPS speed accuracy in m/s 
   */
  private final float speedAccuracy;

  /**
   * GPS horizontal accuracy in m 
   */
  private final float horizAccuracy;

  /**
   * GPS vertical accuracy in m 
   */
  private final float vertAccuracy;

  /**
   * Flags indicating which fields to ignore (see {@link io.dronefleet.mavlink.common.GpsInputIgnoreFlags GpsInputIgnoreFlags} enum). All other fields 
   * must be provided. 
   */
  private final EnumFlagSet<GpsInputIgnoreFlags> ignoreFlags;

  /**
   * GPS week number 
   */
  private final int timeWeek;

  /**
   * ID of the GPS for multiple GPS inputs 
   */
  private final int gpsId;

  /**
   * 0-1: no fix, 2: 2D fix, 3: 3D fix. 4: 3D with DGPS. 5: 3D with RTK 
   */
  private final int fixType;

  /**
   * Number of satellites visible. 
   */
  private final int satellitesVisible;

  private GpsInput(BigInteger timeUsec, long timeWeekMs, int lat, int lon, float alt, float hdop,
      float vdop, float vn, float ve, float vd, float speedAccuracy, float horizAccuracy,
      float vertAccuracy, EnumFlagSet<GpsInputIgnoreFlags> ignoreFlags, int timeWeek, int gpsId,
      int fixType, int satellitesVisible) {
    this.timeUsec = timeUsec;
    this.timeWeekMs = timeWeekMs;
    this.lat = lat;
    this.lon = lon;
    this.alt = alt;
    this.hdop = hdop;
    this.vdop = vdop;
    this.vn = vn;
    this.ve = ve;
    this.vd = vd;
    this.speedAccuracy = speedAccuracy;
    this.horizAccuracy = horizAccuracy;
    this.vertAccuracy = vertAccuracy;
    this.ignoreFlags = ignoreFlags;
    this.timeWeek = timeWeek;
    this.gpsId = gpsId;
    this.fixType = fixType;
    this.satellitesVisible = satellitesVisible;
  }

  @MavlinkMessageBuilder
  public static Builder builder() {
    return new Builder();
  }

  @Override
  public String toString() {
    return "GpsInput{timeUsec=" + timeUsec
         + ", gpsId=" + gpsId
         + ", ignoreFlags=" + ignoreFlags
         + ", timeWeekMs=" + timeWeekMs
         + ", timeWeek=" + timeWeek
         + ", fixType=" + fixType
         + ", lat=" + lat
         + ", lon=" + lon
         + ", alt=" + alt
         + ", hdop=" + hdop
         + ", vdop=" + vdop
         + ", vn=" + vn
         + ", ve=" + ve
         + ", vd=" + vd
         + ", speedAccuracy=" + speedAccuracy
         + ", horizAccuracy=" + horizAccuracy
         + ", vertAccuracy=" + vertAccuracy
         + ", satellitesVisible=" + satellitesVisible + "}";
  }

  /**
   * Timestamp (micros since boot or Unix epoch) 
   */
  @MavlinkMessageField(
      position = 1,
      unitSize = 8
  )
  public final BigInteger timeUsec() {
    return timeUsec;
  }

  /**
   * GPS time (milliseconds from start of GPS week) 
   */
  @MavlinkMessageField(
      position = 4,
      unitSize = 4
  )
  public final long timeWeekMs() {
    return timeWeekMs;
  }

  /**
   * Latitude (WGS84), in degrees * 1E7 
   */
  @MavlinkMessageField(
      position = 7,
      unitSize = 4
  )
  public final int lat() {
    return lat;
  }

  /**
   * Longitude (WGS84), in degrees * 1E7 
   */
  @MavlinkMessageField(
      position = 8,
      unitSize = 4
  )
  public final int lon() {
    return lon;
  }

  /**
   * Altitude (AMSL, not WGS84), in m (positive for up) 
   */
  @MavlinkMessageField(
      position = 9,
      unitSize = 4
  )
  public final float alt() {
    return alt;
  }

  /**
   * GPS HDOP horizontal dilution of position in m 
   */
  @MavlinkMessageField(
      position = 10,
      unitSize = 4
  )
  public final float hdop() {
    return hdop;
  }

  /**
   * GPS VDOP vertical dilution of position in m 
   */
  @MavlinkMessageField(
      position = 11,
      unitSize = 4
  )
  public final float vdop() {
    return vdop;
  }

  /**
   * GPS velocity in m/s in NORTH direction in earth-fixed NED frame 
   */
  @MavlinkMessageField(
      position = 12,
      unitSize = 4
  )
  public final float vn() {
    return vn;
  }

  /**
   * GPS velocity in m/s in EAST direction in earth-fixed NED frame 
   */
  @MavlinkMessageField(
      position = 13,
      unitSize = 4
  )
  public final float ve() {
    return ve;
  }

  /**
   * GPS velocity in m/s in DOWN direction in earth-fixed NED frame 
   */
  @MavlinkMessageField(
      position = 14,
      unitSize = 4
  )
  public final float vd() {
    return vd;
  }

  /**
   * GPS speed accuracy in m/s 
   */
  @MavlinkMessageField(
      position = 15,
      unitSize = 4
  )
  public final float speedAccuracy() {
    return speedAccuracy;
  }

  /**
   * GPS horizontal accuracy in m 
   */
  @MavlinkMessageField(
      position = 16,
      unitSize = 4
  )
  public final float horizAccuracy() {
    return horizAccuracy;
  }

  /**
   * GPS vertical accuracy in m 
   */
  @MavlinkMessageField(
      position = 17,
      unitSize = 4
  )
  public final float vertAccuracy() {
    return vertAccuracy;
  }

  /**
   * Flags indicating which fields to ignore (see {@link io.dronefleet.mavlink.common.GpsInputIgnoreFlags GpsInputIgnoreFlags} enum). All other fields 
   * must be provided. 
   */
  @MavlinkMessageField(
      position = 3,
      unitSize = 2
  )
  public final EnumFlagSet<GpsInputIgnoreFlags> ignoreFlags() {
    return ignoreFlags;
  }

  /**
   * GPS week number 
   */
  @MavlinkMessageField(
      position = 5,
      unitSize = 2
  )
  public final int timeWeek() {
    return timeWeek;
  }

  /**
   * ID of the GPS for multiple GPS inputs 
   */
  @MavlinkMessageField(
      position = 2,
      unitSize = 1
  )
  public final int gpsId() {
    return gpsId;
  }

  /**
   * 0-1: no fix, 2: 2D fix, 3: 3D fix. 4: 3D with DGPS. 5: 3D with RTK 
   */
  @MavlinkMessageField(
      position = 6,
      unitSize = 1
  )
  public final int fixType() {
    return fixType;
  }

  /**
   * Number of satellites visible. 
   */
  @MavlinkMessageField(
      position = 18,
      unitSize = 1
  )
  public final int satellitesVisible() {
    return satellitesVisible;
  }

  public static class Builder {
    private BigInteger timeUsec;

    private long timeWeekMs;

    private int lat;

    private int lon;

    private float alt;

    private float hdop;

    private float vdop;

    private float vn;

    private float ve;

    private float vd;

    private float speedAccuracy;

    private float horizAccuracy;

    private float vertAccuracy;

    private EnumFlagSet<GpsInputIgnoreFlags> ignoreFlags;

    private int timeWeek;

    private int gpsId;

    private int fixType;

    private int satellitesVisible;

    private Builder() {
    }

    /**
     * Timestamp (micros since boot or Unix epoch) 
     */
    @MavlinkMessageField(
        position = 1,
        unitSize = 8
    )
    public final Builder timeUsec(BigInteger timeUsec) {
      this.timeUsec = timeUsec;
      return this;
    }

    /**
     * GPS time (milliseconds from start of GPS week) 
     */
    @MavlinkMessageField(
        position = 4,
        unitSize = 4
    )
    public final Builder timeWeekMs(long timeWeekMs) {
      this.timeWeekMs = timeWeekMs;
      return this;
    }

    /**
     * Latitude (WGS84), in degrees * 1E7 
     */
    @MavlinkMessageField(
        position = 7,
        unitSize = 4
    )
    public final Builder lat(int lat) {
      this.lat = lat;
      return this;
    }

    /**
     * Longitude (WGS84), in degrees * 1E7 
     */
    @MavlinkMessageField(
        position = 8,
        unitSize = 4
    )
    public final Builder lon(int lon) {
      this.lon = lon;
      return this;
    }

    /**
     * Altitude (AMSL, not WGS84), in m (positive for up) 
     */
    @MavlinkMessageField(
        position = 9,
        unitSize = 4
    )
    public final Builder alt(float alt) {
      this.alt = alt;
      return this;
    }

    /**
     * GPS HDOP horizontal dilution of position in m 
     */
    @MavlinkMessageField(
        position = 10,
        unitSize = 4
    )
    public final Builder hdop(float hdop) {
      this.hdop = hdop;
      return this;
    }

    /**
     * GPS VDOP vertical dilution of position in m 
     */
    @MavlinkMessageField(
        position = 11,
        unitSize = 4
    )
    public final Builder vdop(float vdop) {
      this.vdop = vdop;
      return this;
    }

    /**
     * GPS velocity in m/s in NORTH direction in earth-fixed NED frame 
     */
    @MavlinkMessageField(
        position = 12,
        unitSize = 4
    )
    public final Builder vn(float vn) {
      this.vn = vn;
      return this;
    }

    /**
     * GPS velocity in m/s in EAST direction in earth-fixed NED frame 
     */
    @MavlinkMessageField(
        position = 13,
        unitSize = 4
    )
    public final Builder ve(float ve) {
      this.ve = ve;
      return this;
    }

    /**
     * GPS velocity in m/s in DOWN direction in earth-fixed NED frame 
     */
    @MavlinkMessageField(
        position = 14,
        unitSize = 4
    )
    public final Builder vd(float vd) {
      this.vd = vd;
      return this;
    }

    /**
     * GPS speed accuracy in m/s 
     */
    @MavlinkMessageField(
        position = 15,
        unitSize = 4
    )
    public final Builder speedAccuracy(float speedAccuracy) {
      this.speedAccuracy = speedAccuracy;
      return this;
    }

    /**
     * GPS horizontal accuracy in m 
     */
    @MavlinkMessageField(
        position = 16,
        unitSize = 4
    )
    public final Builder horizAccuracy(float horizAccuracy) {
      this.horizAccuracy = horizAccuracy;
      return this;
    }

    /**
     * GPS vertical accuracy in m 
     */
    @MavlinkMessageField(
        position = 17,
        unitSize = 4
    )
    public final Builder vertAccuracy(float vertAccuracy) {
      this.vertAccuracy = vertAccuracy;
      return this;
    }

    /**
     * Flags indicating which fields to ignore (see {@link io.dronefleet.mavlink.common.GpsInputIgnoreFlags GpsInputIgnoreFlags} enum). All other fields 
     * must be provided. 
     */
    @MavlinkMessageField(
        position = 3,
        unitSize = 2
    )
    public final Builder ignoreFlags(EnumFlagSet<GpsInputIgnoreFlags> ignoreFlags) {
      this.ignoreFlags = ignoreFlags;
      return this;
    }

    /**
     * GPS week number 
     */
    @MavlinkMessageField(
        position = 5,
        unitSize = 2
    )
    public final Builder timeWeek(int timeWeek) {
      this.timeWeek = timeWeek;
      return this;
    }

    /**
     * ID of the GPS for multiple GPS inputs 
     */
    @MavlinkMessageField(
        position = 2,
        unitSize = 1
    )
    public final Builder gpsId(int gpsId) {
      this.gpsId = gpsId;
      return this;
    }

    /**
     * 0-1: no fix, 2: 2D fix, 3: 3D fix. 4: 3D with DGPS. 5: 3D with RTK 
     */
    @MavlinkMessageField(
        position = 6,
        unitSize = 1
    )
    public final Builder fixType(int fixType) {
      this.fixType = fixType;
      return this;
    }

    /**
     * Number of satellites visible. 
     */
    @MavlinkMessageField(
        position = 18,
        unitSize = 1
    )
    public final Builder satellitesVisible(int satellitesVisible) {
      this.satellitesVisible = satellitesVisible;
      return this;
    }

    public final GpsInput build() {
      return new GpsInput(timeUsec, timeWeekMs, lat, lon, alt, hdop, vdop, vn, ve, vd, speedAccuracy, horizAccuracy, vertAccuracy, ignoreFlags, timeWeek, gpsId, fixType, satellitesVisible);
    }
  }
}
