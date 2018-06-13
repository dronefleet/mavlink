package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkMessage;
import io.dronefleet.mavlink.annotations.MavlinkMessageField;

/**
 * Response from a TERRAIN_CHECK request 
 */
@MavlinkMessage(
    id = 136,
    crc = 1
)
public final class TerrainReport {
  private final int lat;

  private final int lon;

  private final int spacing;

  private final float terrainHeight;

  private final float currentHeight;

  private final int pending;

  private final int loaded;

  private TerrainReport(int lat, int lon, int spacing, float terrainHeight, float currentHeight,
      int pending, int loaded) {
    this.lat = lat;
    this.lon = lon;
    this.spacing = spacing;
    this.terrainHeight = terrainHeight;
    this.currentHeight = currentHeight;
    this.pending = pending;
    this.loaded = loaded;
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

  /**
   * grid spacing (zero if terrain at this location unavailable) 
   */
  @MavlinkMessageField(
      position = 3,
      length = 2
  )
  public final int spacing() {
    return spacing;
  }

  /**
   * Terrain height in meters AMSL 
   */
  @MavlinkMessageField(
      position = 4,
      length = 4
  )
  public final float terrainHeight() {
    return terrainHeight;
  }

  /**
   * Current vehicle height above lat/lon terrain height (meters) 
   */
  @MavlinkMessageField(
      position = 5,
      length = 4
  )
  public final float currentHeight() {
    return currentHeight;
  }

  /**
   * Number of 4x4 terrain blocks waiting to be received or read from disk 
   */
  @MavlinkMessageField(
      position = 6,
      length = 2
  )
  public final int pending() {
    return pending;
  }

  /**
   * Number of 4x4 terrain blocks in memory 
   */
  @MavlinkMessageField(
      position = 7,
      length = 2
  )
  public final int loaded() {
    return loaded;
  }

  public class Builder {
    private int lat;

    private int lon;

    private int spacing;

    private float terrainHeight;

    private float currentHeight;

    private int pending;

    private int loaded;

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

    /**
     * grid spacing (zero if terrain at this location unavailable) 
     */
    @MavlinkMessageField(
        position = 3,
        length = 2
    )
    public final Builder spacing(int spacing) {
      this.spacing = spacing;
      return this;
    }

    /**
     * Terrain height in meters AMSL 
     */
    @MavlinkMessageField(
        position = 4,
        length = 4
    )
    public final Builder terrainHeight(float terrainHeight) {
      this.terrainHeight = terrainHeight;
      return this;
    }

    /**
     * Current vehicle height above lat/lon terrain height (meters) 
     */
    @MavlinkMessageField(
        position = 5,
        length = 4
    )
    public final Builder currentHeight(float currentHeight) {
      this.currentHeight = currentHeight;
      return this;
    }

    /**
     * Number of 4x4 terrain blocks waiting to be received or read from disk 
     */
    @MavlinkMessageField(
        position = 6,
        length = 2
    )
    public final Builder pending(int pending) {
      this.pending = pending;
      return this;
    }

    /**
     * Number of 4x4 terrain blocks in memory 
     */
    @MavlinkMessageField(
        position = 7,
        length = 2
    )
    public final Builder loaded(int loaded) {
      this.loaded = loaded;
      return this;
    }

    public final TerrainReport build() {
      return new TerrainReport(lat, lon, spacing, terrainHeight, currentHeight, pending, loaded);
    }
  }
}
