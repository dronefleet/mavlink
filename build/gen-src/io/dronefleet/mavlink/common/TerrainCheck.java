package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkMessage;
import io.dronefleet.mavlink.annotations.MavlinkMessageField;

/**
 * Request that the vehicle report terrain height at the given location. Used by GCS to check if 
 * vehicle has all terrain data needed for a mission. 
 */
@MavlinkMessage(
    id = 135,
    crc = 203
)
public final class TerrainCheck {
  private final int lat;

  private final int lon;

  private TerrainCheck(int lat, int lon) {
    this.lat = lat;
    this.lon = lon;
  }

  public static Builder builder() {
    return new Builder();
  }

  /**
   * Latitude (degrees *10^7) 
   */
  @MavlinkMessageField(
      position = 1,
      length = 4
  )
  public final int lat() {
    return lat;
  }

  /**
   * Longitude (degrees *10^7) 
   */
  @MavlinkMessageField(
      position = 2,
      length = 4
  )
  public final int lon() {
    return lon;
  }

  public class Builder {
    private int lat;

    private int lon;

    private Builder() {
    }

    /**
     * Latitude (degrees *10^7) 
     */
    @MavlinkMessageField(
        position = 1,
        length = 4
    )
    public final Builder lat(int lat) {
      this.lat = lat;
      return this;
    }

    /**
     * Longitude (degrees *10^7) 
     */
    @MavlinkMessageField(
        position = 2,
        length = 4
    )
    public final Builder lon(int lon) {
      this.lon = lon;
      return this;
    }

    public final TerrainCheck build() {
      return new TerrainCheck(lat, lon);
    }
  }
}
