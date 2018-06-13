package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkMessage;
import io.dronefleet.mavlink.annotations.MavlinkMessageField;
import java.lang.String;

/**
 * Response from a {@link io.dronefleet.mavlink.common.ParamExtSet ParamExtSet} message. 
 */
@MavlinkMessage(
    id = 324,
    crc = 132
)
public final class ParamExtAck {
  /**
   * Parameter id, terminated by NULL if the length is less than 16 human-readable chars and WITHOUT 
   * null termination (NULL) byte if the length is exactly 16 chars - applications have to provide 
   * 16+1 bytes storage if the ID is stored as string 
   */
  private final String paramId;

  /**
   * Parameter value (new value if PARAM_ACK_ACCEPTED, current value otherwise) 
   */
  private final String paramValue;

  /**
   * Parameter type: see the {@link io.dronefleet.mavlink.common.MavParamExtType MavParamExtType} enum for supported data types. 
   */
  private final MavParamExtType paramType;

  /**
   * Result code: see the {@link io.dronefleet.mavlink.common.ParamAck ParamAck} enum for possible codes. 
   */
  private final ParamAck paramResult;

  private ParamExtAck(String paramId, String paramValue, MavParamExtType paramType,
      ParamAck paramResult) {
    this.paramId = paramId;
    this.paramValue = paramValue;
    this.paramType = paramType;
    this.paramResult = paramResult;
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
   * Parameter value (new value if PARAM_ACK_ACCEPTED, current value otherwise) 
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
   * Result code: see the {@link io.dronefleet.mavlink.common.ParamAck ParamAck} enum for possible codes. 
   */
  @MavlinkMessageField(
      position = 4,
      length = 1
  )
  public final ParamAck paramResult() {
    return paramResult;
  }

  public static class Builder {
    private String paramId;

    private String paramValue;

    private MavParamExtType paramType;

    private ParamAck paramResult;

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
     * Parameter value (new value if PARAM_ACK_ACCEPTED, current value otherwise) 
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
     * Result code: see the {@link io.dronefleet.mavlink.common.ParamAck ParamAck} enum for possible codes. 
     */
    @MavlinkMessageField(
        position = 4,
        length = 1
    )
    public final Builder paramResult(ParamAck paramResult) {
      this.paramResult = paramResult;
      return this;
    }

    public final ParamExtAck build() {
      return new ParamExtAck(paramId, paramValue, paramType, paramResult);
    }
  }
}
