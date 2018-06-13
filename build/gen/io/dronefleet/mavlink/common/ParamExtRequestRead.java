package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkMessage;
import io.dronefleet.mavlink.annotations.MavlinkMessageField;
import java.lang.Integer;
import java.util.List;

/**
 * Request to read the value of a parameter with the either the param_id string id or param_index. 
 */
@MavlinkMessage(
    id = 320,
    crc = 243
)
public final class ParamExtRequestRead {
  private final int targetSystem;

  private final int targetComponent;

  private final List<Integer> paramId;

  private final int paramIndex;

  private ParamExtRequestRead(int targetSystem, int targetComponent, List<Integer> paramId,
      int paramIndex) {
    this.targetSystem = targetSystem;
    this.targetComponent = targetComponent;
    this.paramId = paramId;
    this.paramIndex = paramIndex;
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
   * Parameter id, terminated by NULL if the length is less than 16 human-readable chars and WITHOUT 
   * null termination (NULL) byte if the length is exactly 16 chars - applications have to provide 
   * 16+1 bytes storage if the ID is stored as string 
   */
  @MavlinkMessageField(
      position = 3,
      length = 1,
      arraySize = 16
  )
  public final List<Integer> paramId() {
    return paramId;
  }

  /**
   * Parameter index. Set to -1 to use the Parameter ID field as identifier (else param_id will be 
   * ignored) 
   */
  @MavlinkMessageField(
      position = 4,
      length = 2
  )
  public final int paramIndex() {
    return paramIndex;
  }

  public class Builder {
    private int targetSystem;

    private int targetComponent;

    private List<Integer> paramId;

    private int paramIndex;

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
     * Parameter id, terminated by NULL if the length is less than 16 human-readable chars and WITHOUT 
     * null termination (NULL) byte if the length is exactly 16 chars - applications have to provide 
     * 16+1 bytes storage if the ID is stored as string 
     */
    @MavlinkMessageField(
        position = 3,
        length = 1,
        arraySize = 16
    )
    public final Builder paramId(List<Integer> paramId) {
      this.paramId = paramId;
      return this;
    }

    /**
     * Parameter index. Set to -1 to use the Parameter ID field as identifier (else param_id will be 
     * ignored) 
     */
    @MavlinkMessageField(
        position = 4,
        length = 2
    )
    public final Builder paramIndex(int paramIndex) {
      this.paramIndex = paramIndex;
      return this;
    }

    public final ParamExtRequestRead build() {
      return new ParamExtRequestRead(targetSystem, targetComponent, paramId, paramIndex);
    }
  }
}
