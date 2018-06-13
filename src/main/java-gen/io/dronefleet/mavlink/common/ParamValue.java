package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkMessage;
import io.dronefleet.mavlink.annotations.MavlinkMessageField;
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
   * Onboard parameter id, terminated by NULL if the length is less than 16 human-readable chars and 
   * WITHOUT null termination (NULL) byte if the length is exactly 16 chars - applications have to 
   * provide 16+1 bytes storage if the ID is stored as string 
   */
  private final String paramId;

  /**
   * Onboard parameter value 
   */
  private final float paramValue;

  /**
   * Onboard parameter type: see the {@link io.dronefleet.mavlink.common.MavParamType MavParamType} enum for supported data types. 
   */
  private final MavParamType paramType;

  /**
   * Total number of onboard parameters 
   */
  private final int paramCount;

  /**
   * Index of this onboard parameter 
   */
  private final int paramIndex;

  private ParamValue(String paramId, float paramValue, MavParamType paramType, int paramCount,
      int paramIndex) {
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
   * Onboard parameter id, terminated by NULL if the length is less than 16 human-readable chars and 
   * WITHOUT null termination (NULL) byte if the length is exactly 16 chars - applications have to 
   * provide 16+1 bytes storage if the ID is stored as string 
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
   * Onboard parameter value 
   */
  @MavlinkMessageField(
      position = 2,
      length = 4
  )
  public final float paramValue() {
    return paramValue;
  }

  /**
   * Onboard parameter type: see the {@link io.dronefleet.mavlink.common.MavParamType MavParamType} enum for supported data types. 
   */
  @MavlinkMessageField(
      position = 3,
      length = 1
  )
  public final MavParamType paramType() {
    return paramType;
  }

  /**
   * Total number of onboard parameters 
   */
  @MavlinkMessageField(
      position = 4,
      length = 2
  )
  public final int paramCount() {
    return paramCount;
  }

  /**
   * Index of this onboard parameter 
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

    private float paramValue;

    private MavParamType paramType;

    private int paramCount;

    private int paramIndex;

    private Builder() {
    }

    /**
     * Onboard parameter id, terminated by NULL if the length is less than 16 human-readable chars and 
     * WITHOUT null termination (NULL) byte if the length is exactly 16 chars - applications have to 
     * provide 16+1 bytes storage if the ID is stored as string 
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
     * Onboard parameter value 
     */
    @MavlinkMessageField(
        position = 2,
        length = 4
    )
    public final Builder paramValue(float paramValue) {
      this.paramValue = paramValue;
      return this;
    }

    /**
     * Onboard parameter type: see the {@link io.dronefleet.mavlink.common.MavParamType MavParamType} enum for supported data types. 
     */
    @MavlinkMessageField(
        position = 3,
        length = 1
    )
    public final Builder paramType(MavParamType paramType) {
      this.paramType = paramType;
      return this;
    }

    /**
     * Total number of onboard parameters 
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
     * Index of this onboard parameter 
     */
    @MavlinkMessageField(
        position = 5,
        length = 2
    )
    public final Builder paramIndex(int paramIndex) {
      this.paramIndex = paramIndex;
      return this;
    }

    public final ParamValue build() {
      return new ParamValue(paramId, paramValue, paramType, paramCount, paramIndex);
    }
  }
}
