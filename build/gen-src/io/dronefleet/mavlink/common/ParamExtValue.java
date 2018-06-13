package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkMessage;
import io.dronefleet.mavlink.annotations.MavlinkMessageField;
import java.lang.Integer;
import java.util.List;

/**
 * Emit the value of a parameter. The inclusion of param_count and param_index in the message 
 * allows the recipient to keep track of received parameters and allows them to re-request 
 * missing parameters after a loss or timeout. 
 */
@MavlinkMessage(
    id = 322,
    crc = 243
)
public final class ParamExtValue {
  private final List<Integer> paramId;

  private final List<Integer> paramValue;

  private final MavParamExtType paramType;

  private final int paramCount;

  private final int paramIndex;

  private ParamExtValue(List<Integer> paramId, List<Integer> paramValue, MavParamExtType paramType,
      int paramCount, int paramIndex) {
    this.paramId = paramId;
    this.paramValue = paramValue;
    this.paramType = paramType;
    this.paramCount = paramCount;
    this.paramIndex = paramIndex;
  }

  public static Builder builder() {
    return new Builder();
  }

  /**
   * Parameter id, terminated by NULL if the length is less than 16 human-readable chars and WITHOUT 
   * null termination (NULL) byte if the length is exactly 16 chars - applications have to provide 
   * 16+1 bytes storage if the ID is stored as string 
   */
  @MavlinkMessageField(
      position = 1,
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
      position = 2,
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
      position = 3,
      length = 1
  )
  public final MavParamExtType paramType() {
    return paramType;
  }

  /**
   * Total number of parameters 
   */
  @MavlinkMessageField(
      position = 4,
      length = 2
  )
  public final int paramCount() {
    return paramCount;
  }

  /**
   * Index of this parameter 
   */
  @MavlinkMessageField(
      position = 5,
      length = 2
  )
  public final int paramIndex() {
    return paramIndex;
  }

  public class Builder {
    private List<Integer> paramId;

    private List<Integer> paramValue;

    private MavParamExtType paramType;

    private int paramCount;

    private int paramIndex;

    private Builder() {
    }

    /**
     * Parameter id, terminated by NULL if the length is less than 16 human-readable chars and WITHOUT 
     * null termination (NULL) byte if the length is exactly 16 chars - applications have to provide 
     * 16+1 bytes storage if the ID is stored as string 
     */
    @MavlinkMessageField(
        position = 1,
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
        position = 2,
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
        position = 3,
        length = 1
    )
    public final Builder paramType(MavParamExtType paramType) {
      this.paramType = paramType;
      return this;
    }

    /**
     * Total number of parameters 
     */
    @MavlinkMessageField(
        position = 4,
        length = 2
    )
    public final Builder paramCount(int paramCount) {
      this.paramCount = paramCount;
      return this;
    }

    /**
     * Index of this parameter 
     */
    @MavlinkMessageField(
        position = 5,
        length = 2
    )
    public final Builder paramIndex(int paramIndex) {
      this.paramIndex = paramIndex;
      return this;
    }

    public final ParamExtValue build() {
      return new ParamExtValue(paramId, paramValue, paramType, paramCount, paramIndex);
    }
  }
}
