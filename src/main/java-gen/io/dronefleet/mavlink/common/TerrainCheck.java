package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import java.lang.Override;
import java.lang.String;

/**
 * Request that the vehicle report terrain height at the given location. Used by GCS to check if 
 * vehicle has all terrain data needed for a mission. 
 */
@MavlinkMessageInfo(
    id = 135,
    crc = 203
)
public final class TerrainCheck {
  /**
   * Latitude (degrees *10^7) 
   */
  private final int lat;

  /**
   * Longitude (degrees *10^7) 
   */
  private final int lon;

  private TerrainCheck(int lat, int lon) {
    this.lat = lat;
    this.lon = lon;
  }

  @MavlinkMessageBuilder
  public static Builder builder() {
    return new Builder();
  }

  @Override
  public String toString() {
    return "TerrainCheck{lat=" + lat
         + ", lon=" + lon + "}";
  }

  /**
   * Latitude (degrees *10^7) 
   */
  @MavlinkFieldInfo(
      position = 1,
      unitSize = 4
  )
  public final int lat() {
    return lat;
  }

  /**
   * Longitude (degrees *10^7) 
   */
  @MavlinkFieldInfo(
      position = 2,
      unitSize = 4
  )
  public final int lon() {
    return lon;
  }

  public static class Builder {
    private int lat;

    private int lon;

    private Builder() {
    }

    /**
     * Latitude (degrees *10^7) 
     */
    @MavlinkFieldInfo(
        position = 1,
        unitSize = 4
    )
    public final Builder lat(int lat) {
      this.lat = lat;
      return this;
    }

    /**
     * Longitude (degrees *10^7) 
     */
    @MavlinkFieldInfo(
        position = 2,
        unitSize = 4
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
