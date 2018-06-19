package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkMessage;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageField;
import java.lang.Override;
import java.lang.String;
import java.math.BigInteger;

/**
 * As local waypoints exist, the global waypoint reference allows to transform between the local 
 * coordinate frame and the global (GPS) coordinate frame. This can be necessary when e.g. in- and 
 * outdoor settings are connected and the MAV should move from in- to outdoor. 
 */
@MavlinkMessage(
    id = 48,
    crc = 41
)
public final class SetGpsGlobalOrigin {
  /**
   * Latitude (WGS84), in degrees * 1E7 
   */
  private final int latitude;

  /**
   * Longitude (WGS84), in degrees * 1E7 
   */
  private final int longitude;

  /**
   * Altitude (AMSL), in meters * 1000 (positive for up) 
   */
  private final int altitude;

  /**
   * System ID 
   */
  private final int targetSystem;

  /**
   * Timestamp (microseconds since UNIX epoch or microseconds since system boot) 
   */
  private final BigInteger timeUsec;

  private SetGpsGlobalOrigin(int latitude, int longitude, int altitude, int targetSystem,
      BigInteger timeUsec) {
    this.latitude = latitude;
    this.longitude = longitude;
    this.altitude = altitude;
    this.targetSystem = targetSystem;
    this.timeUsec = timeUsec;
  }

  @MavlinkMessageBuilder
  public static Builder builder() {
    return new Builder();
  }

  @Override
  public String toString() {
    return "SetGpsGlobalOrigin{targetSystem=" + targetSystem
         + ", latitude=" + latitude
         + ", longitude=" + longitude
         + ", altitude=" + altitude
         + ", timeUsec=" + timeUsec + "}";
  }

  /**
   * Latitude (WGS84), in degrees * 1E7 
   */
  @MavlinkMessageField(
      position = 2,
      unitSize = 4
  )
  public final int latitude() {
    return latitude;
  }

  /**
   * Longitude (WGS84), in degrees * 1E7 
   */
  @MavlinkMessageField(
      position = 3,
      unitSize = 4
  )
  public final int longitude() {
    return longitude;
  }

  /**
   * Altitude (AMSL), in meters * 1000 (positive for up) 
   */
  @MavlinkMessageField(
      position = 4,
      unitSize = 4
  )
  public final int altitude() {
    return altitude;
  }

  /**
   * System ID 
   */
  @MavlinkMessageField(
      position = 1,
      unitSize = 1
  )
  public final int targetSystem() {
    return targetSystem;
  }

  /**
   * Timestamp (microseconds since UNIX epoch or microseconds since system boot) 
   */
  @MavlinkMessageField(
      position = 6,
      unitSize = 8,
      extension = true
  )
  public final BigInteger timeUsec() {
    return timeUsec;
  }

  public static class Builder {
    private int latitude;

    private int longitude;

    private int altitude;

    private int targetSystem;

    private BigInteger timeUsec;

    private Builder() {
    }

    /**
     * Latitude (WGS84), in degrees * 1E7 
     */
    @MavlinkMessageField(
        position = 2,
        unitSize = 4
    )
    public final Builder latitude(int latitude) {
      this.latitude = latitude;
      return this;
    }

    /**
     * Longitude (WGS84), in degrees * 1E7 
     */
    @MavlinkMessageField(
        position = 3,
        unitSize = 4
    )
    public final Builder longitude(int longitude) {
      this.longitude = longitude;
      return this;
    }

    /**
     * Altitude (AMSL), in meters * 1000 (positive for up) 
     */
    @MavlinkMessageField(
        position = 4,
        unitSize = 4
    )
    public final Builder altitude(int altitude) {
      this.altitude = altitude;
      return this;
    }

    /**
     * System ID 
     */
    @MavlinkMessageField(
        position = 1,
        unitSize = 1
    )
    public final Builder targetSystem(int targetSystem) {
      this.targetSystem = targetSystem;
      return this;
    }

    /**
     * Timestamp (microseconds since UNIX epoch or microseconds since system boot) 
     */
    @MavlinkMessageField(
        position = 6,
        unitSize = 8,
        extension = true
    )
    public final Builder timeUsec(BigInteger timeUsec) {
      this.timeUsec = timeUsec;
      return this;
    }

    public final SetGpsGlobalOrigin build() {
      return new SetGpsGlobalOrigin(latitude, longitude, altitude, targetSystem, timeUsec);
    }
  }
}
