package io.dronefleet.mavlink.ardupilotmega;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import java.lang.Override;
import java.lang.String;

/**
 * A fence point. Used to set a point when from GCS -> MAV. Also used to return a point from MAV -> GCS 
 */
@MavlinkMessageInfo(
    id = 160,
    crc = 78
)
public final class FencePoint {
  /**
   * Latitude of point 
   */
  private final float lat;

  /**
   * Longitude of point 
   */
  private final float lng;

  /**
   * System ID 
   */
  private final int targetSystem;

  /**
   * Component ID 
   */
  private final int targetComponent;

  /**
   * point index (first point is 1, 0 is for return point) 
   */
  private final int idx;

  /**
   * total number of points (for sanity checking) 
   */
  private final int count;

  private FencePoint(float lat, float lng, int targetSystem, int targetComponent, int idx,
      int count) {
    this.lat = lat;
    this.lng = lng;
    this.targetSystem = targetSystem;
    this.targetComponent = targetComponent;
    this.idx = idx;
    this.count = count;
  }

  @MavlinkMessageBuilder
  public static Builder builder() {
    return new Builder();
  }

  @Override
  public String toString() {
    return "FencePoint{targetSystem=" + targetSystem
         + ", targetComponent=" + targetComponent
         + ", idx=" + idx
         + ", count=" + count
         + ", lat=" + lat
         + ", lng=" + lng + "}";
  }

  /**
   * Latitude of point 
   */
  @MavlinkFieldInfo(
      position = 5,
      unitSize = 4
  )
  public final float lat() {
    return lat;
  }

  /**
   * Longitude of point 
   */
  @MavlinkFieldInfo(
      position = 6,
      unitSize = 4
  )
  public final float lng() {
    return lng;
  }

  /**
   * System ID 
   */
  @MavlinkFieldInfo(
      position = 1,
      unitSize = 1
  )
  public final int targetSystem() {
    return targetSystem;
  }

  /**
   * Component ID 
   */
  @MavlinkFieldInfo(
      position = 2,
      unitSize = 1
  )
  public final int targetComponent() {
    return targetComponent;
  }

  /**
   * point index (first point is 1, 0 is for return point) 
   */
  @MavlinkFieldInfo(
      position = 3,
      unitSize = 1
  )
  public final int idx() {
    return idx;
  }

  /**
   * total number of points (for sanity checking) 
   */
  @MavlinkFieldInfo(
      position = 4,
      unitSize = 1
  )
  public final int count() {
    return count;
  }

  public static class Builder {
    private float lat;

    private float lng;

    private int targetSystem;

    private int targetComponent;

    private int idx;

    private int count;

    private Builder() {
    }

    /**
     * Latitude of point 
     */
    @MavlinkFieldInfo(
        position = 5,
        unitSize = 4
    )
    public final Builder lat(float lat) {
      this.lat = lat;
      return this;
    }

    /**
     * Longitude of point 
     */
    @MavlinkFieldInfo(
        position = 6,
        unitSize = 4
    )
    public final Builder lng(float lng) {
      this.lng = lng;
      return this;
    }

    /**
     * System ID 
     */
    @MavlinkFieldInfo(
        position = 1,
        unitSize = 1
    )
    public final Builder targetSystem(int targetSystem) {
      this.targetSystem = targetSystem;
      return this;
    }

    /**
     * Component ID 
     */
    @MavlinkFieldInfo(
        position = 2,
        unitSize = 1
    )
    public final Builder targetComponent(int targetComponent) {
      this.targetComponent = targetComponent;
      return this;
    }

    /**
     * point index (first point is 1, 0 is for return point) 
     */
    @MavlinkFieldInfo(
        position = 3,
        unitSize = 1
    )
    public final Builder idx(int idx) {
      this.idx = idx;
      return this;
    }

    /**
     * total number of points (for sanity checking) 
     */
    @MavlinkFieldInfo(
        position = 4,
        unitSize = 1
    )
    public final Builder count(int count) {
      this.count = count;
      return this;
    }

    public final FencePoint build() {
      return new FencePoint(lat, lng, targetSystem, targetComponent, idx, count);
    }
  }
}
