package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkMessage;
import io.dronefleet.mavlink.annotations.MavlinkMessageField;
import java.lang.Integer;
import java.util.List;

/**
 * data for injecting into the onboard GPS (used for DGPS) 
 */
@MavlinkMessage(
    id = 123,
    crc = 250
)
public final class GpsInjectData {
  private final int targetSystem;

  private final int targetComponent;

  private final int len;

  private final List<Integer> data;

  private GpsInjectData(int targetSystem, int targetComponent, int len, List<Integer> data) {
    this.targetSystem = targetSystem;
    this.targetComponent = targetComponent;
    this.len = len;
    this.data = data;
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
   * data length 
   */
  @MavlinkMessageField(
      position = 3,
      length = 1
  )
  public final int len() {
    return len;
  }

  /**
   * raw data (110 is enough for 12 satellites of RTCMv2) 
   */
  @MavlinkMessageField(
      position = 4,
      length = 1,
      arraySize = 110
  )
  public final List<Integer> data() {
    return data;
  }

  public class Builder {
    private int targetSystem;

    private int targetComponent;

    private int len;

    private List<Integer> data;

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
     * data length 
     */
    @MavlinkMessageField(
        position = 3,
        length = 1
    )
    public final Builder len(int len) {
      this.len = len;
      return this;
    }

    /**
     * raw data (110 is enough for 12 satellites of RTCMv2) 
     */
    @MavlinkMessageField(
        position = 4,
        length = 1,
        arraySize = 110
    )
    public final Builder data(List<Integer> data) {
      this.data = data;
      return this;
    }

    public final GpsInjectData build() {
      return new GpsInjectData(targetSystem, targetComponent, len, data);
    }
  }
}
