package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import java.lang.Override;
import java.lang.String;

/**
 * Response from a {@link io.dronefleet.mavlink.common.TerrainCheck TerrainCheck} request 
 */
@MavlinkMessageInfo(
    id = 136,
    crc = 1
)
public final class TerrainReport {
  /**
   * Latitude (degrees *10^7) 
   */
  private final int lat;

  /**
   * Longitude (degrees *10^7) 
   */
  private final int lon;

  /**
   * Terrain height in meters AMSL 
   */
  private final float terrainHeight;

  /**
   * Current vehicle height above lat/lon terrain height (meters) 
   */
  private final float currentHeight;

  /**
   * grid spacing (zero if terrain at this location unavailable) 
   */
  private final int spacing;

  /**
   * Number of 4x4 terrain blocks waiting to be received or read from disk 
   */
  private final int pending;

  /**
   * Number of 4x4 terrain blocks in memory 
   */
  private final int loaded;

  private TerrainReport(int lat, int lon, float terrainHeight, float currentHeight, int spacing,
      int pending, int loaded) {
    this.lat = lat;
    this.lon = lon;
    this.terrainHeight = terrainHeight;
    this.currentHeight = currentHeight;
    this.spacing = spacing;
    this.pending = pending;
    this.loaded = loaded;
  }

  @MavlinkMessageBuilder
  public static Builder builder() {
    return new Builder();
  }

  @Override
  public String toString() {
    return "TerrainReport{lat=" + lat
         + ", lon=" + lon
         + ", spacing=" + spacing
         + ", terrainHeight=" + terrainHeight
         + ", currentHeight=" + currentHeight
         + ", pending=" + pending
         + ", loaded=" + loaded + "}";
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

  /**
   * Terrain height in meters AMSL 
   */
  @MavlinkFieldInfo(
      position = 4,
      unitSize = 4
  )
  public final float terrainHeight() {
    return terrainHeight;
  }

  /**
   * Current vehicle height above lat/lon terrain height (meters) 
   */
  @MavlinkFieldInfo(
      position = 5,
      unitSize = 4
  )
  public final float currentHeight() {
    return currentHeight;
  }

  /**
   * grid spacing (zero if terrain at this location unavailable) 
   */
  @MavlinkFieldInfo(
      position = 3,
      unitSize = 2
  )
  public final int spacing() {
    return spacing;
  }

  /**
   * Number of 4x4 terrain blocks waiting to be received or read from disk 
   */
  @MavlinkFieldInfo(
      position = 6,
      unitSize = 2
  )
  public final int pending() {
    return pending;
  }

  /**
   * Number of 4x4 terrain blocks in memory 
   */
  @MavlinkFieldInfo(
      position = 7,
      unitSize = 2
  )
  public final int loaded() {
    return loaded;
  }

  public static class Builder {
    private int lat;

    private int lon;

    private float terrainHeight;

    private float currentHeight;

    private int spacing;

    private int pending;

    private int loaded;

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

    /**
     * Terrain height in meters AMSL 
     */
    @MavlinkFieldInfo(
        position = 4,
        unitSize = 4
    )
    public final Builder terrainHeight(float terrainHeight) {
      this.terrainHeight = terrainHeight;
      return this;
    }

    /**
     * Current vehicle height above lat/lon terrain height (meters) 
     */
    @MavlinkFieldInfo(
        position = 5,
        unitSize = 4
    )
    public final Builder currentHeight(float currentHeight) {
      this.currentHeight = currentHeight;
      return this;
    }

    /**
     * grid spacing (zero if terrain at this location unavailable) 
     */
    @MavlinkFieldInfo(
        position = 3,
        unitSize = 2
    )
    public final Builder spacing(int spacing) {
      this.spacing = spacing;
      return this;
    }

    /**
     * Number of 4x4 terrain blocks waiting to be received or read from disk 
     */
    @MavlinkFieldInfo(
        position = 6,
        unitSize = 2
    )
    public final Builder pending(int pending) {
      this.pending = pending;
      return this;
    }

    /**
     * Number of 4x4 terrain blocks in memory 
     */
    @MavlinkFieldInfo(
        position = 7,
        unitSize = 2
    )
    public final Builder loaded(int loaded) {
      this.loaded = loaded;
      return this;
    }

    public final TerrainReport build() {
      return new TerrainReport(lat, lon, terrainHeight, currentHeight, spacing, pending, loaded);
    }
  }
}
