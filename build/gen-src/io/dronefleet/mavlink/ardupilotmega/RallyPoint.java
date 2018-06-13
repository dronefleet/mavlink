package io.dronefleet.mavlink.ardupilotmega;

import io.dronefleet.mavlink.annotations.MavlinkMessage;
import io.dronefleet.mavlink.annotations.MavlinkMessageField;
import io.dronefleet.mavlink.util.EnumFlagSet;

/**
 * A rally point. Used to set a point when from GCS -> MAV. Also used to return a point from MAV -> GCS 
 */
@MavlinkMessage(
    id = 175,
    crc = 138
)
public final class RallyPoint {
  private final int targetSystem;

  private final int targetComponent;

  private final int idx;

  private final int count;

  private final int lat;

  private final int lng;

  private final int alt;

  private final int breakAlt;

  private final int landDir;

  private final EnumFlagSet<RallyFlags> flags;

  private RallyPoint(int targetSystem, int targetComponent, int idx, int count, int lat, int lng,
      int alt, int breakAlt, int landDir, EnumFlagSet<RallyFlags> flags) {
    this.targetSystem = targetSystem;
    this.targetComponent = targetComponent;
    this.idx = idx;
    this.count = count;
    this.lat = lat;
    this.lng = lng;
    this.alt = alt;
    this.breakAlt = breakAlt;
    this.landDir = landDir;
    this.flags = flags;
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
   * point index (first point is 0) 
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
   * Latitude of point in degrees * 1E7 
   */
  @MavlinkMessageField(
      position = 5,
      length = 4
  )
  public final int lat() {
    return lat;
  }

  /**
   * Longitude of point in degrees * 1E7 
   */
  @MavlinkMessageField(
      position = 6,
      length = 4
  )
  public final int lng() {
    return lng;
  }

  /**
   * Transit / loiter altitude in meters relative to home 
   */
  @MavlinkMessageField(
      position = 7,
      length = 2
  )
  public final int alt() {
    return alt;
  }

  /**
   * Break altitude in meters relative to home 
   */
  @MavlinkMessageField(
      position = 8,
      length = 2
  )
  public final int breakAlt() {
    return breakAlt;
  }

  /**
   * Heading to aim for when landing. In centi-degrees. 
   */
  @MavlinkMessageField(
      position = 9,
      length = 2
  )
  public final int landDir() {
    return landDir;
  }

  /**
   * See RALLY_FLAGS enum for definition of the bitmask. 
   */
  @MavlinkMessageField(
      position = 10,
      length = 1
  )
  public final EnumFlagSet<RallyFlags> flags() {
    return flags;
  }

  public class Builder {
    private int targetSystem;

    private int targetComponent;

    private int idx;

    private int count;

    private int lat;

    private int lng;

    private int alt;

    private int breakAlt;

    private int landDir;

    private EnumFlagSet<RallyFlags> flags;

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
     * point index (first point is 0) 
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
     * Latitude of point in degrees * 1E7 
     */
    @MavlinkMessageField(
        position = 5,
        length = 4
    )
    public final Builder lat(int lat) {
      this.lat = lat;
      return this;
    }

    /**
     * Longitude of point in degrees * 1E7 
     */
    @MavlinkMessageField(
        position = 6,
        length = 4
    )
    public final Builder lng(int lng) {
      this.lng = lng;
      return this;
    }

    /**
     * Transit / loiter altitude in meters relative to home 
     */
    @MavlinkMessageField(
        position = 7,
        length = 2
    )
    public final Builder alt(int alt) {
      this.alt = alt;
      return this;
    }

    /**
     * Break altitude in meters relative to home 
     */
    @MavlinkMessageField(
        position = 8,
        length = 2
    )
    public final Builder breakAlt(int breakAlt) {
      this.breakAlt = breakAlt;
      return this;
    }

    /**
     * Heading to aim for when landing. In centi-degrees. 
     */
    @MavlinkMessageField(
        position = 9,
        length = 2
    )
    public final Builder landDir(int landDir) {
      this.landDir = landDir;
      return this;
    }

    /**
     * See RALLY_FLAGS enum for definition of the bitmask. 
     */
    @MavlinkMessageField(
        position = 10,
        length = 1
    )
    public final Builder flags(EnumFlagSet<RallyFlags> flags) {
      this.flags = flags;
      return this;
    }

    public final RallyPoint build() {
      return new RallyPoint(targetSystem, targetComponent, idx, count, lat, lng, alt, breakAlt, landDir, flags);
    }
  }
}
