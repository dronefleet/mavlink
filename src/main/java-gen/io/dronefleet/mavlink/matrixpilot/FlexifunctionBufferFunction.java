package io.dronefleet.mavlink.matrixpilot;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import java.lang.Integer;
import java.lang.Override;
import java.lang.String;
import java.util.List;

/**
 * Flexifunction type and parameters for component at function index from buffer 
 */
@MavlinkMessageInfo(
    id = 152,
    crc = 101
)
public final class FlexifunctionBufferFunction {
  /**
   * Function index 
   */
  private final int funcIndex;

  /**
   * Total count of functions 
   */
  private final int funcCount;

  /**
   * Address in the flexifunction data, Set to 0xFFFF to use address in target memory 
   */
  private final int dataAddress;

  /**
   * Size of the 
   */
  private final int dataSize;

  /**
   * System ID 
   */
  private final int targetSystem;

  /**
   * Component ID 
   */
  private final int targetComponent;

  /**
   * Settings data 
   */
  private final List<Integer> data;

  private FlexifunctionBufferFunction(int funcIndex, int funcCount, int dataAddress, int dataSize,
      int targetSystem, int targetComponent, List<Integer> data) {
    this.funcIndex = funcIndex;
    this.funcCount = funcCount;
    this.dataAddress = dataAddress;
    this.dataSize = dataSize;
    this.targetSystem = targetSystem;
    this.targetComponent = targetComponent;
    this.data = data;
  }

  @MavlinkMessageBuilder
  public static Builder builder() {
    return new Builder();
  }

  @Override
  public String toString() {
    return "FlexifunctionBufferFunction{targetSystem=" + targetSystem
         + ", targetComponent=" + targetComponent
         + ", funcIndex=" + funcIndex
         + ", funcCount=" + funcCount
         + ", dataAddress=" + dataAddress
         + ", dataSize=" + dataSize
         + ", data=" + data + "}";
  }

  /**
   * Function index 
   */
  @MavlinkFieldInfo(
      position = 3,
      unitSize = 2
  )
  public final int funcIndex() {
    return funcIndex;
  }

  /**
   * Total count of functions 
   */
  @MavlinkFieldInfo(
      position = 4,
      unitSize = 2
  )
  public final int funcCount() {
    return funcCount;
  }

  /**
   * Address in the flexifunction data, Set to 0xFFFF to use address in target memory 
   */
  @MavlinkFieldInfo(
      position = 5,
      unitSize = 2
  )
  public final int dataAddress() {
    return dataAddress;
  }

  /**
   * Size of the 
   */
  @MavlinkFieldInfo(
      position = 6,
      unitSize = 2
  )
  public final int dataSize() {
    return dataSize;
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
   * Settings data 
   */
  @MavlinkFieldInfo(
      position = 7,
      unitSize = 1,
      arraySize = 48
  )
  public final List<Integer> data() {
    return data;
  }

  public static class Builder {
    private int funcIndex;

    private int funcCount;

    private int dataAddress;

    private int dataSize;

    private int targetSystem;

    private int targetComponent;

    private List<Integer> data;

    private Builder() {
    }

    /**
     * Function index 
     */
    @MavlinkFieldInfo(
        position = 3,
        unitSize = 2
    )
    public final Builder funcIndex(int funcIndex) {
      this.funcIndex = funcIndex;
      return this;
    }

    /**
     * Total count of functions 
     */
    @MavlinkFieldInfo(
        position = 4,
        unitSize = 2
    )
    public final Builder funcCount(int funcCount) {
      this.funcCount = funcCount;
      return this;
    }

    /**
     * Address in the flexifunction data, Set to 0xFFFF to use address in target memory 
     */
    @MavlinkFieldInfo(
        position = 5,
        unitSize = 2
    )
    public final Builder dataAddress(int dataAddress) {
      this.dataAddress = dataAddress;
      return this;
    }

    /**
     * Size of the 
     */
    @MavlinkFieldInfo(
        position = 6,
        unitSize = 2
    )
    public final Builder dataSize(int dataSize) {
      this.dataSize = dataSize;
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
     * Settings data 
     */
    @MavlinkFieldInfo(
        position = 7,
        unitSize = 1,
        arraySize = 48
    )
    public final Builder data(List<Integer> data) {
      this.data = data;
      return this;
    }

    public final FlexifunctionBufferFunction build() {
      return new FlexifunctionBufferFunction(funcIndex, funcCount, dataAddress, dataSize, targetSystem, targetComponent, data);
    }
  }
}
