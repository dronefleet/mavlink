package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkMessage;
import io.dronefleet.mavlink.annotations.MavlinkMessageField;
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
  private final int targetSystem;

  private final int latitude;

  private final int longitude;

  private final int altitude;

  private final BigInteger timeUsec;

  private SetGpsGlobalOrigin(int targetSystem, int latitude, int longitude, int altitude,
      BigInteger timeUsec) {
    this.targetSystem = targetSystem;
    this.latitude = latitude;
    this.longitude = longitude;
    this.altitude = altitude;
    this.timeUsec = timeUsec;
  }

  public static Builder builder() {
    return new Builder();
  }

  /**
   * System ID 
   */
  @MavlinkMessageField(
      position = 1,
      length = 1
  )
  public final int targetSystem() {
    return targetSystem;
  }

  /**
   * Latitude (WGS84), in degrees * 1E7 
   */
  @MavlinkMessageField(
      position = 2,
      length = 4
  )
  public final int latitude() {
    return latitude;
  }

  /**
   * Longitude (WGS84), in degrees * 1E7 
   */
  @MavlinkMessageField(
      position = 3,
      length = 4
  )
  public final int longitude() {
    return longitude;
  }

  /**
   * Altitude (AMSL), in meters * 1000 (positive for up) 
   */
  @MavlinkMessageField(
      position = 4,
      length = 4
  )
  public final int altitude() {
    return altitude;
  }

  /**
   * Timestamp (microseconds since UNIX epoch or microseconds since system boot) 
   */
  @MavlinkMessageField(
      position = 6,
      length = 8,
      extension = true
  )
  public final BigInteger timeUsec() {
    return timeUsec;
  }

  public class Builder {
    private int targetSystem;

    private int latitude;

    private int longitude;

    private int altitude;

    private BigInteger timeUsec;

    private Builder() {
    }

    /**
     * System ID 
     */
    @MavlinkMessageField(
        position = 1,
        length = 1
    )
    public final Builder targetSystem(int targetSystem) {
      this.targetSystem = targetSystem;
      return this;
    }

    /**
     * Latitude (WGS84), in degrees * 1E7 
     */
    @MavlinkMessageField(
        position = 2,
        length = 4
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
        length = 4
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
        length = 4
    )
    public final Builder altitude(int altitude) {
      this.altitude = altitude;
      return this;
    }

    /**
     * Timestamp (microseconds since UNIX epoch or microseconds since system boot) 
     */
    @MavlinkMessageField(
        position = 6,
        length = 8,
        extension = true
    )
    public final Builder timeUsec(BigInteger timeUsec) {
      this.timeUsec = timeUsec;
      return this;
    }

    public final SetGpsGlobalOrigin build() {
      return new SetGpsGlobalOrigin(targetSystem, latitude, longitude, altitude, timeUsec);
    }
  }
}
