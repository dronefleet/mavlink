package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkMessage;
import io.dronefleet.mavlink.annotations.MavlinkMessageField;
import java.math.BigInteger;

/**
 * Request for terrain data and terrain status 
 */
@MavlinkMessage(
    id = 133,
    crc = 6
)
public final class TerrainRequest {
  /**
   * Latitude of SW corner of first grid (degrees *10^7) 
   */
  private final int lat;

  /**
   * Longitude of SW corner of first grid (in degrees *10^7) 
   */
  private final int lon;

  /**
   * Grid spacing in meters 
   */
  private final int gridSpacing;

  /**
   * Bitmask of requested 4x4 grids (row major 8x7 array of grids, 56 bits) 
   */
  private final BigInteger mask;

  private TerrainRequest(int lat, int lon, int gridSpacing, BigInteger mask) {
    this.lat = lat;
    this.lon = lon;
    this.gridSpacing = gridSpacing;
    this.mask = mask;
  }

  public static Builder builder() {
    return new Builder();
  }

  /**
   * Latitude of SW corner of first grid (degrees *10^7) 
   */
  @MavlinkMessageField(
      position = 1,
      length = 4
  )
  public final int lat() {
    return lat;
  }

  /**
   * Longitude of SW corner of first grid (in degrees *10^7) 
   */
  @MavlinkMessageField(
      position = 2,
      length = 4
  )
  public final int lon() {
    return lon;
  }

  /**
   * Grid spacing in meters 
   */
  @MavlinkMessageField(
      position = 3,
      length = 2
  )
  public final int gridSpacing() {
    return gridSpacing;
  }

  /**
   * Bitmask of requested 4x4 grids (row major 8x7 array of grids, 56 bits) 
   */
  @MavlinkMessageField(
      position = 4,
      length = 8
  )
  public final BigInteger mask() {
    return mask;
  }

  public static class Builder {
    private int lat;

    private int lon;

    private int gridSpacing;

    private BigInteger mask;

    private Builder() {
    }

    /**
     * Latitude of SW corner of first grid (degrees *10^7) 
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
     * Longitude of SW corner of first grid (in degrees *10^7) 
     */
    @MavlinkMessageField(
        position = 2,
        length = 4
    )
    public final Builder lon(int lon) {
      this.lon = lon;
      return this;
    }

    /**
     * Grid spacing in meters 
     */
    @MavlinkMessageField(
        position = 3,
        length = 2
    )
    public final Builder gridSpacing(int gridSpacing) {
      this.gridSpacing = gridSpacing;
      return this;
    }

    /**
     * Bitmask of requested 4x4 grids (row major 8x7 array of grids, 56 bits) 
     */
    @MavlinkMessageField(
        position = 4,
        length = 8
    )
    public final Builder mask(BigInteger mask) {
      this.mask = mask;
      return this;
    }

    public final TerrainRequest build() {
      return new TerrainRequest(lat, lon, gridSpacing, mask);
    }
  }
}
