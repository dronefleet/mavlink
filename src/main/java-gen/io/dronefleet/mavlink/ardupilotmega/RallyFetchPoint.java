package io.dronefleet.mavlink.ardupilotmega;

import io.dronefleet.mavlink.annotations.MavlinkMessage;
import io.dronefleet.mavlink.annotations.MavlinkMessageField;

/**
 * Request a current rally point from MAV. MAV should respond with a {@link io.dronefleet.mavlink.ardupilotmega.RallyPoint RallyPoint} message. MAV 
 * should not respond if the request is invalid. 
 */
@MavlinkMessage(
    id = 176,
    crc = 234
)
public final class RallyFetchPoint {
  /**
   * System ID 
   */
  private final int targetSystem;

  /**
   * Component ID 
   */
  private final int targetComponent;

  /**
   * point index (first point is 0) 
   */
  private final int idx;

  private RallyFetchPoint(int targetSystem, int targetComponent, int idx) {
    this.targetSystem = targetSystem;
    this.targetComponent = targetComponent;
    this.idx = idx;
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

  public static class Builder {
    private int targetSystem;

    private int targetComponent;

    private int idx;

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

    public final RallyFetchPoint build() {
      return new RallyFetchPoint(targetSystem, targetComponent, idx);
    }
  }
}
