package io.dronefleet.mavlink.matrixpilot;

import io.dronefleet.mavlink.annotations.MavlinkMessage;
import io.dronefleet.mavlink.annotations.MavlinkMessageField;

/**
 * Reqest reading of flexifunction data 
 */
@MavlinkMessage(
    id = 151,
    crc = 26
)
public final class FlexifunctionReadReq {
  /**
   * System ID 
   */
  private final int targetSystem;

  /**
   * Component ID 
   */
  private final int targetComponent;

  /**
   * Type of flexifunction data requested 
   */
  private final int readReqType;

  /**
   * index into data where needed 
   */
  private final int dataIndex;

  private FlexifunctionReadReq(int targetSystem, int targetComponent, int readReqType,
      int dataIndex) {
    this.targetSystem = targetSystem;
    this.targetComponent = targetComponent;
    this.readReqType = readReqType;
    this.dataIndex = dataIndex;
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
   * Type of flexifunction data requested 
   */
  @MavlinkMessageField(
      position = 3,
      length = 2
  )
  public final int readReqType() {
    return readReqType;
  }

  /**
   * index into data where needed 
   */
  @MavlinkMessageField(
      position = 4,
      length = 2
  )
  public final int dataIndex() {
    return dataIndex;
  }

  public static class Builder {
    private int targetSystem;

    private int targetComponent;

    private int readReqType;

    private int dataIndex;

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
     * Type of flexifunction data requested 
     */
    @MavlinkMessageField(
        position = 3,
        length = 2
    )
    public final Builder readReqType(int readReqType) {
      this.readReqType = readReqType;
      return this;
    }

    /**
     * index into data where needed 
     */
    @MavlinkMessageField(
        position = 4,
        length = 2
    )
    public final Builder dataIndex(int dataIndex) {
      this.dataIndex = dataIndex;
      return this;
    }

    public final FlexifunctionReadReq build() {
      return new FlexifunctionReadReq(targetSystem, targetComponent, readReqType, dataIndex);
    }
  }
}
