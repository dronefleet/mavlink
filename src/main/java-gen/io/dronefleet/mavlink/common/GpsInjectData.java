package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import java.lang.Integer;
import java.lang.Override;
import java.lang.String;
import java.util.List;

/**
 * data for injecting into the onboard GPS (used for DGPS) 
 */
@MavlinkMessageInfo(
    id = 123,
    crc = 250
)
public final class GpsInjectData {
  /**
   * System ID 
   */
  private final int targetSystem;

  /**
   * Component ID 
   */
  private final int targetComponent;

  /**
   * data length 
   */
  private final int len;

  /**
   * raw data (110 is enough for 12 satellites of RTCMv2) 
   */
  private final List<Integer> data;

  private GpsInjectData(int targetSystem, int targetComponent, int len, List<Integer> data) {
    this.targetSystem = targetSystem;
    this.targetComponent = targetComponent;
    this.len = len;
    this.data = data;
  }

  @MavlinkMessageBuilder
  public static Builder builder() {
    return new Builder();
  }

  @Override
  public String toString() {
    return "GpsInjectData{targetSystem=" + targetSystem
         + ", targetComponent=" + targetComponent
         + ", len=" + len
         + ", data=" + data + "}";
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
   * data length 
   */
  @MavlinkFieldInfo(
      position = 3,
      unitSize = 1
  )
  public final int len() {
    return len;
  }

  /**
   * raw data (110 is enough for 12 satellites of RTCMv2) 
   */
  @MavlinkFieldInfo(
      position = 4,
      unitSize = 1,
      arraySize = 110
  )
  public final List<Integer> data() {
    return data;
  }

  public static class Builder {
    private int targetSystem;

    private int targetComponent;

    private int len;

    private List<Integer> data;

    private Builder() {
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
     * data length 
     */
    @MavlinkFieldInfo(
        position = 3,
        unitSize = 1
    )
    public final Builder len(int len) {
      this.len = len;
      return this;
    }

    /**
     * raw data (110 is enough for 12 satellites of RTCMv2) 
     */
    @MavlinkFieldInfo(
        position = 4,
        unitSize = 1,
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
