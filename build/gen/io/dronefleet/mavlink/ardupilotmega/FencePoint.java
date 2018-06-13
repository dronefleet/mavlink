package io.dronefleet.mavlink.ardupilotmega;

import io.dronefleet.mavlink.annotations.MavlinkMessage;
import io.dronefleet.mavlink.annotations.MavlinkMessageField;

/**
 * A fence point. Used to set a point when from GCS -> MAV. Also used to return a point from MAV -> GCS 
 */
@MavlinkMessage(
    id = 160,
    crc = 78
)
public final class FencePoint {
  private final int targetSystem;

  private final int targetComponent;

  private final int idx;

  private final int count;

  private final float lat;

  private final float lng;

  private FencePoint(int targetSystem, int targetComponent, int idx, int count, float lat,
      float lng) {
    this.targetSystem = targetSystem;
    this.targetComponent = targetComponent;
    this.idx = idx;
    this.count = count;
    this.lat = lat;
    this.lng = lng;
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
   * Component ID 
   */
  @MavlinkMessageField(
      position = 2,
      length = 1
  )
  public final int targetComponent() {
    return targetComponent;
  }

  /**
   * point index (first point is 1, 0 is for return point) 
   */
  @MavlinkMessageField(
      position = 3,
      length = 1
  )
  public final int idx() {
    return idx;
  }

  /**
   * total number of points (for sanity checking) 
   */
  @MavlinkMessageField(
      position = 4,
      length = 1
  )
  public final int count() {
    return count;
  }

  /**
   * Latitude of point 
   */
  @MavlinkMessageField(
      position = 5,
      length = 4
  )
  public final float lat() {
    return lat;
  }

  /**
   * Longitude of point 
   */
  @MavlinkMessageField(
      position = 6,
      length = 4
  )
  public final float lng() {
    return lng;
  }

  public class Builder {
    private int targetSystem;

    private int targetComponent;

    private int idx;

    private int count;

    private float lat;

    private float lng;

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
     * Component ID 
     */
    @MavlinkMessageField(
        position = 2,
        length = 1
    )
    public final Builder targetComponent(int targetComponent) {
      this.targetComponent = targetComponent;
      return this;
    }

    /**
     * point index (first point is 1, 0 is for return point) 
     */
    @MavlinkMessageField(
        position = 3,
        length = 1
    )
    public final Builder idx(int idx) {
      this.idx = idx;
      return this;
    }

    /**
     * total number of points (for sanity checking) 
     */
    @MavlinkMessageField(
        position = 4,
        length = 1
    )
    public final Builder count(int count) {
      this.count = count;
      return this;
    }

    /**
     * Latitude of point 
     */
    @MavlinkMessageField(
        position = 5,
        length = 4
    )
    public final Builder lat(float lat) {
      this.lat = lat;
      return this;
    }

    /**
     * Longitude of point 
     */
    @MavlinkMessageField(
        position = 6,
        length = 4
    )
    public final Builder lng(float lng) {
      this.lng = lng;
      return this;
    }

    public final FencePoint build() {
      return new FencePoint(targetSystem, targetComponent, idx, count, lat, lng);
    }
  }
}
