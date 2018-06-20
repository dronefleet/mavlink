package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import java.lang.Override;
import java.lang.String;

/**
 * The filtered global position (e.g. fused GPS and accelerometers). The position is in 
 * GPS-frame (right-handed, Z-up). It is designed as scaled integer message since the 
 * resolution of float is not sufficient. 
 */
@MavlinkMessageInfo(
    id = 33,
    crc = 104
)
public final class GlobalPositionInt {
  /**
   * Timestamp (milliseconds since system boot) 
   */
  private final long timeBootMs;

  /**
   * Latitude, expressed as degrees * 1E7 
   */
  private final int lat;

  /**
   * Longitude, expressed as degrees * 1E7 
   */
  private final int lon;

  /**
   * Altitude in meters, expressed as * 1000 (millimeters), AMSL (not WGS84 - note that virtually 
   * all GPS modules provide the AMSL as well) 
   */
  private final int alt;

  /**
   * Altitude above ground in meters, expressed as * 1000 (millimeters) 
   */
  private final int relativeAlt;

  /**
   * Ground X Speed (Latitude, positive north), expressed as m/s * 100 
   */
  private final int vx;

  /**
   * Ground Y Speed (Longitude, positive east), expressed as m/s * 100 
   */
  private final int vy;

  /**
   * Ground Z Speed (Altitude, positive down), expressed as m/s * 100 
   */
  private final int vz;

  /**
   * Vehicle heading (yaw angle) in degrees * 100, 0.0..359.99 degrees. If unknown, set to: 
   * UINT16_MAX 
   */
  private final int hdg;

  private GlobalPositionInt(long timeBootMs, int lat, int lon, int alt, int relativeAlt, int vx,
      int vy, int vz, int hdg) {
    this.timeBootMs = timeBootMs;
    this.lat = lat;
    this.lon = lon;
    this.alt = alt;
    this.relativeAlt = relativeAlt;
    this.vx = vx;
    this.vy = vy;
    this.vz = vz;
    this.hdg = hdg;
  }

  @MavlinkMessageBuilder
  public static Builder builder() {
    return new Builder();
  }

  @Override
  public String toString() {
    return "GlobalPositionInt{timeBootMs=" + timeBootMs
         + ", lat=" + lat
         + ", lon=" + lon
         + ", alt=" + alt
         + ", relativeAlt=" + relativeAlt
         + ", vx=" + vx
         + ", vy=" + vy
         + ", vz=" + vz
         + ", hdg=" + hdg + "}";
  }

  /**
   * Timestamp (milliseconds since system boot) 
   */
  @MavlinkFieldInfo(
      position = 1,
      unitSize = 4
  )
  public final long timeBootMs() {
    return timeBootMs;
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
   * Altitude in meters, expressed as * 1000 (millimeters), AMSL (not WGS84 - note that virtually 
   * all GPS modules provide the AMSL as well) 
   */
  @MavlinkFieldInfo(
      position = 4,
      unitSize = 4
  )
  public final int alt() {
    return alt;
  }

  /**
   * Altitude above ground in meters, expressed as * 1000 (millimeters) 
   */
  @MavlinkFieldInfo(
      position = 5,
      unitSize = 4
  )
  public final int relativeAlt() {
    return relativeAlt;
  }

  /**
   * Ground X Speed (Latitude, positive north), expressed as m/s * 100 
   */
  @MavlinkFieldInfo(
      position = 6,
      unitSize = 2
  )
  public final int vx() {
    return vx;
  }

  /**
   * Ground Y Speed (Longitude, positive east), expressed as m/s * 100 
   */
  @MavlinkFieldInfo(
      position = 7,
      unitSize = 2
  )
  public final int vy() {
    return vy;
  }

  /**
   * Ground Z Speed (Altitude, positive down), expressed as m/s * 100 
   */
  @MavlinkFieldInfo(
      position = 8,
      unitSize = 2
  )
  public final int vz() {
    return vz;
  }

  /**
   * Vehicle heading (yaw angle) in degrees * 100, 0.0..359.99 degrees. If unknown, set to: 
   * UINT16_MAX 
   */
  @MavlinkFieldInfo(
      position = 9,
      unitSize = 2
  )
  public final int hdg() {
    return hdg;
  }

  public static class Builder {
    private long timeBootMs;

    private int lat;

    private int lon;

    private int alt;

    private int relativeAlt;

    private int vx;

    private int vy;

    private int vz;

    private int hdg;

    private Builder() {
    }

    /**
     * Timestamp (milliseconds since system boot) 
     */
    @MavlinkFieldInfo(
        position = 1,
        unitSize = 4
    )
    public final Builder timeBootMs(long timeBootMs) {
      this.timeBootMs = timeBootMs;
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
     * Altitude in meters, expressed as * 1000 (millimeters), AMSL (not WGS84 - note that virtually 
     * all GPS modules provide the AMSL as well) 
     */
    @MavlinkFieldInfo(
        position = 4,
        unitSize = 4
    )
    public final Builder alt(int alt) {
      this.alt = alt;
      return this;
    }

    /**
     * Altitude above ground in meters, expressed as * 1000 (millimeters) 
     */
    @MavlinkFieldInfo(
        position = 5,
        unitSize = 4
    )
    public final Builder relativeAlt(int relativeAlt) {
      this.relativeAlt = relativeAlt;
      return this;
    }

    /**
     * Ground X Speed (Latitude, positive north), expressed as m/s * 100 
     */
    @MavlinkFieldInfo(
        position = 6,
        unitSize = 2
    )
    public final Builder vx(int vx) {
      this.vx = vx;
      return this;
    }

    /**
     * Ground Y Speed (Longitude, positive east), expressed as m/s * 100 
     */
    @MavlinkFieldInfo(
        position = 7,
        unitSize = 2
    )
    public final Builder vy(int vy) {
      this.vy = vy;
      return this;
    }

    /**
     * Ground Z Speed (Altitude, positive down), expressed as m/s * 100 
     */
    @MavlinkFieldInfo(
        position = 8,
        unitSize = 2
    )
    public final Builder vz(int vz) {
      this.vz = vz;
      return this;
    }

    /**
     * Vehicle heading (yaw angle) in degrees * 100, 0.0..359.99 degrees. If unknown, set to: 
     * UINT16_MAX 
     */
    @MavlinkFieldInfo(
        position = 9,
        unitSize = 2
    )
    public final Builder hdg(int hdg) {
      this.hdg = hdg;
      return this;
    }

    public final GlobalPositionInt build() {
      return new GlobalPositionInt(timeBootMs, lat, lon, alt, relativeAlt, vx, vy, vz, hdg);
    }
  }
}
