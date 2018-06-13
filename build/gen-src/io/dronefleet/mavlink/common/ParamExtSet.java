package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkMessage;
import io.dronefleet.mavlink.annotations.MavlinkMessageField;
import java.lang.Integer;
import java.util.List;

/**
 * Set a parameter value. In order to deal with message loss (and retransmission of 
 * PARAM_EXT_SET), when setting a parameter value and the new value is the same as the current 
 * value, you will immediately get a PARAM_ACK_ACCEPTED response. If the current state is 
 * PARAM_ACK_IN_PROGRESS, you will accordingly receive a PARAM_ACK_IN_PROGRESS in response. 
 */
@MavlinkMessage(
    id = 323,
    crc = 78
)
public final class ParamExtSet {
  private final int targetSystem;

  private final int targetComponent;

  private final List<Integer> paramId;

  private final List<Integer> paramValue;

  private final MavParamExtType paramType;

  private ParamExtSet(int targetSystem, int targetComponent, List<Integer> paramId,
      List<Integer> paramValue, MavParamExtType paramType) {
    this.targetSystem = targetSystem;
    this.targetComponent = targetComponent;
    this.paramId = paramId;
    this.paramValue = paramValue;
    this.paramType = paramType;
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
   * Parameter value 
   */
  @MavlinkMessageField(
      position = 4,
      length = 1,
      arraySize = 128
  )
  public final List<Integer> paramValue() {
    return paramValue;
  }

  /**
   * Parameter type: see the MAV_PARAM_EXT_TYPE enum for supported data types. 
   */
  @MavlinkMessageField(
      position = 5,
      length = 1
  )
  public final MavParamExtType paramType() {
    return paramType;
  }

  public class Builder {
    private int targetSystem;

    private int targetComponent;

    private List<Integer> paramId;

    private List<Integer> paramValue;

    private MavParamExtType paramType;

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
     * Parameter value 
     */
    @MavlinkMessageField(
        position = 4,
        length = 1,
        arraySize = 128
    )
    public final Builder paramValue(List<Integer> paramValue) {
      this.paramValue = paramValue;
      return this;
    }

    /**
     * Parameter type: see the MAV_PARAM_EXT_TYPE enum for supported data types. 
     */
    @MavlinkMessageField(
        position = 5,
        length = 1
    )
    public final Builder paramType(MavParamExtType paramType) {
      this.paramType = paramType;
      return this;
    }

    public final ParamExtSet build() {
      return new ParamExtSet(targetSystem, targetComponent, paramId, paramValue, paramType);
    }
  }
}
