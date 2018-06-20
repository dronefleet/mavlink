package io.dronefleet.mavlink.matrixpilot;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import java.lang.Override;
import java.lang.String;

/**
 * Reqest reading of flexifunction data 
 */
@MavlinkMessageInfo(
    id = 151,
    crc = 26
)
public final class FlexifunctionReadReq {
  /**
   * Type of flexifunction data requested 
   */
  private final int readReqType;

  /**
   * index into data where needed 
   */
  private final int dataIndex;

  /**
   * System ID 
   */
  private final int targetSystem;

  /**
   * Component ID 
   */
  private final int targetComponent;

  private FlexifunctionReadReq(int readReqType, int dataIndex, int targetSystem,
      int targetComponent) {
    this.readReqType = readReqType;
    this.dataIndex = dataIndex;
    this.targetSystem = targetSystem;
    this.targetComponent = targetComponent;
  }

  @MavlinkMessageBuilder
  public static Builder builder() {
    return new Builder();
  }

  @Override
  public String toString() {
    return "FlexifunctionReadReq{targetSystem=" + targetSystem
         + ", targetComponent=" + targetComponent
         + ", readReqType=" + readReqType
         + ", dataIndex=" + dataIndex + "}";
  }

  /**
   * Type of flexifunction data requested 
   */
  @MavlinkFieldInfo(
      position = 3,
      unitSize = 2
  )
  public final int readReqType() {
    return readReqType;
  }

  /**
   * index into data where needed 
   */
  @MavlinkFieldInfo(
      position = 4,
      unitSize = 2
  )
  public final int dataIndex() {
    return dataIndex;
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

  public static class Builder {
    private int readReqType;

    private int dataIndex;

    private int targetSystem;

    private int targetComponent;

    private Builder() {
    }

    /**
     * Type of flexifunction data requested 
     */
    @MavlinkFieldInfo(
        position = 3,
        unitSize = 2
    )
    public final Builder readReqType(int readReqType) {
      this.readReqType = readReqType;
      return this;
    }

    /**
     * index into data where needed 
     */
    @MavlinkFieldInfo(
        position = 4,
        unitSize = 2
    )
    public final Builder dataIndex(int dataIndex) {
      this.dataIndex = dataIndex;
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

    public final FlexifunctionReadReq build() {
      return new FlexifunctionReadReq(readReqType, dataIndex, targetSystem, targetComponent);
    }
  }
}
