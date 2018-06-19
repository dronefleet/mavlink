package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkMessage;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageField;
import java.lang.Override;
import java.lang.String;

/**
 * Emit the value of a onboard parameter. The inclusion of param_count and param_index in the 
 * message allows the recipient to keep track of received parameters and allows him to re-request 
 * missing parameters after a loss or timeout. 
 */
@MavlinkMessage(
    id = 22,
    crc = 220
)
public final class ParamValue {
  /**
   * Onboard parameter value 
   */
  private final float paramValue;

  /**
   * Total number of onboard parameters 
   */
  private final int paramCount;

  /**
   * Index of this onboard parameter 
   */
  private final int paramIndex;

  /**
   * Onboard parameter id, terminated by NULL if the length is less than 16 human-readable chars and 
   * WITHOUT null termination (NULL) byte if the length is exactly 16 chars - applications have to 
   * provide 16+1 bytes storage if the ID is stored as string 
   */
  private final String paramId;

  /**
   * Onboard parameter type: see the {@link io.dronefleet.mavlink.common.MavParamType MavParamType} enum for supported data types. 
   */
  private final MavParamType paramType;

  private ParamValue(float paramValue, int paramCount, int paramIndex, String paramId,
      MavParamType paramType) {
    this.paramValue = paramValue;
    this.paramCount = paramCount;
    this.paramIndex = paramIndex;
    this.paramId = paramId;
    this.paramType = paramType;
  }

  @MavlinkMessageBuilder
  public static Builder builder() {
    return new Builder();
  }

  @Override
  public String toString() {
    return "ParamValue{paramId=" + paramId
         + ", paramValue=" + paramValue
         + ", paramType=" + paramType
         + ", paramCount=" + paramCount
         + ", paramIndex=" + paramIndex + "}";
  }

  /**
   * Onboard parameter value 
   */
  @MavlinkMessageField(
      position = 2,
      unitSize = 4
  )
  public final float paramValue() {
    return paramValue;
  }

  /**
   * Total number of onboard parameters 
   */
  @MavlinkMessageField(
      position = 4,
      unitSize = 2
  )
  public final int paramCount() {
    return paramCount;
  }

  /**
   * Index of this onboard parameter 
   */
  @MavlinkMessageField(
      position = 5,
      unitSize = 2
  )
  public final int paramIndex() {
    return paramIndex;
  }

  /**
   * Onboard parameter id, terminated by NULL if the length is less than 16 human-readable chars and 
   * WITHOUT null termination (NULL) byte if the length is exactly 16 chars - applications have to 
   * provide 16+1 bytes storage if the ID is stored as string 
   */
  @MavlinkMessageField(
      position = 1,
      unitSize = 1,
      arraySize = 16
  )
  public final String paramId() {
    return paramId;
  }

  /**
   * Onboard parameter type: see the {@link io.dronefleet.mavlink.common.MavParamType MavParamType} enum for supported data types. 
   */
  @MavlinkMessageField(
      position = 3,
      unitSize = 1
  )
  public final MavParamType paramType() {
    return paramType;
  }

  public static class Builder {
    private float paramValue;

    private int paramCount;

    private int paramIndex;

    private String paramId;

    private MavParamType paramType;

    private Builder() {
    }

    /**
     * Onboard parameter value 
     */
    @MavlinkMessageField(
        position = 2,
        unitSize = 4
    )
    public final Builder paramValue(float paramValue) {
      this.paramValue = paramValue;
      return this;
    }

    /**
     * Total number of onboard parameters 
     */
    @MavlinkMessageField(
        position = 4,
        unitSize = 2
    )
    public final Builder paramCount(int paramCount) {
      this.paramCount = paramCount;
      return this;
    }

    /**
     * Index of this onboard parameter 
     */
    @MavlinkMessageField(
        position = 5,
        unitSize = 2
    )
    public final Builder paramIndex(int paramIndex) {
      this.paramIndex = paramIndex;
      return this;
    }

    /**
     * Onboard parameter id, terminated by NULL if the length is less than 16 human-readable chars and 
     * WITHOUT null termination (NULL) byte if the length is exactly 16 chars - applications have to 
     * provide 16+1 bytes storage if the ID is stored as string 
     */
    @MavlinkMessageField(
        position = 1,
        unitSize = 1,
        arraySize = 16
    )
    public final Builder paramId(String paramId) {
      this.paramId = paramId;
      return this;
    }

    /**
     * Onboard parameter type: see the {@link io.dronefleet.mavlink.common.MavParamType MavParamType} enum for supported data types. 
     */
    @MavlinkMessageField(
        position = 3,
        unitSize = 1
    )
    public final Builder paramType(MavParamType paramType) {
      this.paramType = paramType;
      return this;
    }

    public final ParamValue build() {
      return new ParamValue(paramValue, paramCount, paramIndex, paramId, paramType);
    }
  }
}
