package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkMessage;
import io.dronefleet.mavlink.annotations.MavlinkMessageField;
import java.lang.String;

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
  /**
   * Parameter id, terminated by NULL if the length is less than 16 human-readable chars and WITHOUT 
   * null termination (NULL) byte if the length is exactly 16 chars - applications have to provide 
   * 16+1 bytes storage if the ID is stored as string 
   */
  private final String paramId;

  /**
   * Parameter value 
   */
  private final String paramValue;

  /**
   * Parameter type: see the {@link io.dronefleet.mavlink.common.MavParamExtType MavParamExtType} enum for supported data types. 
   */
  private final MavParamExtType paramType;

  /**
   * Total number of parameters 
   */
  private final int paramCount;

  /**
   * Index of this parameter 
   */
  private final int paramIndex;

  private ParamExtValue(String paramId, String paramValue, MavParamExtType paramType,
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
  public final String paramId() {
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
  public final String paramValue() {
    return paramValue;
  }

  /**
   * Parameter type: see the {@link io.dronefleet.mavlink.common.MavParamExtType MavParamExtType} enum for supported data types. 
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

  public static class Builder {
    private String paramId;

    private String paramValue;

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
    public final Builder paramId(String paramId) {
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
    public final Builder paramValue(String paramValue) {
      this.paramValue = paramValue;
      return this;
    }

    /**
     * Parameter type: see the {@link io.dronefleet.mavlink.common.MavParamExtType MavParamExtType} enum for supported data types. 
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
