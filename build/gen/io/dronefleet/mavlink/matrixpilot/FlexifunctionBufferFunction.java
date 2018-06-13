package io.dronefleet.mavlink.matrixpilot;

import io.dronefleet.mavlink.annotations.MavlinkMessage;
import io.dronefleet.mavlink.annotations.MavlinkMessageField;
import java.lang.Integer;
import java.util.List;

/**
 * Flexifunction type and parameters for component at function index from buffer 
 */
@MavlinkMessage(
    id = 152,
    crc = 101
)
public final class FlexifunctionBufferFunction {
  private final int targetSystem;

  private final int targetComponent;

  private final int funcIndex;

  private final int funcCount;

  private final int dataAddress;

  private final int dataSize;

  private final List<Integer> data;

  private FlexifunctionBufferFunction(int targetSystem, int targetComponent, int funcIndex,
      int funcCount, int dataAddress, int dataSize, List<Integer> data) {
    this.targetSystem = targetSystem;
    this.targetComponent = targetComponent;
    this.funcIndex = funcIndex;
    this.funcCount = funcCount;
    this.dataAddress = dataAddress;
    this.dataSize = dataSize;
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
   * Function index 
   */
  @MavlinkMessageField(
      position = 3,
      length = 2
  )
  public final int funcIndex() {
    return funcIndex;
  }

  /**
   * Total count of functions 
   */
  @MavlinkMessageField(
      position = 4,
      length = 2
  )
  public final int funcCount() {
    return funcCount;
  }

  /**
   * Address in the flexifunction data, Set to 0xFFFF to use address in target memory 
   */
  @MavlinkMessageField(
      position = 5,
      length = 2
  )
  public final int dataAddress() {
    return dataAddress;
  }

  /**
   * Size of the 
   */
  @MavlinkMessageField(
      position = 6,
      length = 2
  )
  public final int dataSize() {
    return dataSize;
  }

  /**
   * Settings data 
   */
  @MavlinkMessageField(
      position = 7,
      length = 1,
      arraySize = 48
  )
  public final List<Integer> data() {
    return data;
  }

  public class Builder {
    private int targetSystem;

    private int targetComponent;

    private int funcIndex;

    private int funcCount;

    private int dataAddress;

    private int dataSize;

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
     * Function index 
     */
    @MavlinkMessageField(
        position = 3,
        length = 2
    )
    public final Builder funcIndex(int funcIndex) {
      this.funcIndex = funcIndex;
      return this;
    }

    /**
     * Total count of functions 
     */
    @MavlinkMessageField(
        position = 4,
        length = 2
    )
    public final Builder funcCount(int funcCount) {
      this.funcCount = funcCount;
      return this;
    }

    /**
     * Address in the flexifunction data, Set to 0xFFFF to use address in target memory 
     */
    @MavlinkMessageField(
        position = 5,
        length = 2
    )
    public final Builder dataAddress(int dataAddress) {
      this.dataAddress = dataAddress;
      return this;
    }

    /**
     * Size of the 
     */
    @MavlinkMessageField(
        position = 6,
        length = 2
    )
    public final Builder dataSize(int dataSize) {
      this.dataSize = dataSize;
      return this;
    }

    /**
     * Settings data 
     */
    @MavlinkMessageField(
        position = 7,
        length = 1,
        arraySize = 48
    )
    public final Builder data(List<Integer> data) {
      this.data = data;
      return this;
    }

    public final FlexifunctionBufferFunction build() {
      return new FlexifunctionBufferFunction(targetSystem, targetComponent, funcIndex, funcCount, dataAddress, dataSize, data);
    }
  }
}
