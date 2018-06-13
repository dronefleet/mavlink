package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkMessage;
import io.dronefleet.mavlink.annotations.MavlinkMessageField;
import java.lang.Integer;
import java.util.List;

/**
 * Terrain data sent from GCS. The lat/lon and grid_spacing must be the same as a lat/lon from a 
 * TERRAIN_REQUEST 
 */
@MavlinkMessage(
    id = 134,
    crc = 229
)
public final class TerrainData {
  private final int lat;

  private final int lon;

  private final int gridSpacing;

  private final int gridbit;

  private final List<Integer> data;

  private TerrainData(int lat, int lon, int gridSpacing, int gridbit, List<Integer> data) {
    this.lat = lat;
    this.lon = lon;
    this.gridSpacing = gridSpacing;
    this.gridbit = gridbit;
    this.data = data;
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
   * bit within the terrain request mask 
   */
  @MavlinkMessageField(
      position = 4,
      length = 1
  )
  public final int gridbit() {
    return gridbit;
  }

  /**
   * Terrain data in meters AMSL 
   */
  @MavlinkMessageField(
      position = 5,
      length = 2,
      arraySize = 16
  )
  public final List<Integer> data() {
    return data;
  }

  public class Builder {
    private int lat;

    private int lon;

    private int gridSpacing;

    private int gridbit;

    private List<Integer> data;

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
     * bit within the terrain request mask 
     */
    @MavlinkMessageField(
        position = 4,
        length = 1
    )
    public final Builder gridbit(int gridbit) {
      this.gridbit = gridbit;
      return this;
    }

    /**
     * Terrain data in meters AMSL 
     */
    @MavlinkMessageField(
        position = 5,
        length = 2,
        arraySize = 16
    )
    public final Builder data(List<Integer> data) {
      this.data = data;
      return this;
    }

    public final TerrainData build() {
      return new TerrainData(lat, lon, gridSpacing, gridbit, data);
    }
  }
}
