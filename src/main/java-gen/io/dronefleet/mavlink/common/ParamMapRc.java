package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import java.lang.Override;
import java.lang.String;

/**
 * Bind a RC channel to a parameter. The parameter should change accoding to the RC channel value. 
 */
@MavlinkMessageInfo(
    id = 50,
    crc = 78
)
public final class ParamMapRc {
  /**
   * Initial parameter value 
   */
  private final float paramValue0;

  /**
   * Scale, maps the RC range [-1, 1] to a parameter value 
   */
  private final float scale;

  /**
   * Minimum param value. The protocol does not define if this overwrites an onboard minimum value. 
   * (Depends on implementation) 
   */
  private final float paramValueMin;

  /**
   * Maximum param value. The protocol does not define if this overwrites an onboard maximum value. 
   * (Depends on implementation) 
   */
  private final float paramValueMax;

  /**
   * Parameter index. Send -1 to use the param ID field as identifier (else the param id will be 
   * ignored), send -2 to disable any existing map for this rc_channel_index. 
   */
  private final int paramIndex;

  /**
   * System ID 
   */
  private final int targetSystem;

  /**
   * Component ID 
   */
  private final int targetComponent;

  /**
   * Onboard parameter id, terminated by NULL if the length is less than 16 human-readable chars and 
   * WITHOUT null termination (NULL) byte if the length is exactly 16 chars - applications have to 
   * provide 16+1 bytes storage if the ID is stored as string 
   */
  private final String paramId;

  /**
   * Index of parameter RC channel. Not equal to the RC channel id. Typically correpsonds to a 
   * potentiometer-knob on the RC. 
   */
  private final int parameterRcChannelIndex;

  private ParamMapRc(float paramValue0, float scale, float paramValueMin, float paramValueMax,
      int paramIndex, int targetSystem, int targetComponent, String paramId,
      int parameterRcChannelIndex) {
    this.paramValue0 = paramValue0;
    this.scale = scale;
    this.paramValueMin = paramValueMin;
    this.paramValueMax = paramValueMax;
    this.paramIndex = paramIndex;
    this.targetSystem = targetSystem;
    this.targetComponent = targetComponent;
    this.paramId = paramId;
    this.parameterRcChannelIndex = parameterRcChannelIndex;
  }

  @MavlinkMessageBuilder
  public static Builder builder() {
    return new Builder();
  }

  @Override
  public String toString() {
    return "ParamMapRc{targetSystem=" + targetSystem
         + ", targetComponent=" + targetComponent
         + ", paramId=" + paramId
         + ", paramIndex=" + paramIndex
         + ", parameterRcChannelIndex=" + parameterRcChannelIndex
         + ", paramValue0=" + paramValue0
         + ", scale=" + scale
         + ", paramValueMin=" + paramValueMin
         + ", paramValueMax=" + paramValueMax + "}";
  }

  /**
   * Initial parameter value 
   */
  @MavlinkFieldInfo(
      position = 6,
      unitSize = 4
  )
  public final float paramValue0() {
    return paramValue0;
  }

  /**
   * Scale, maps the RC range [-1, 1] to a parameter value 
   */
  @MavlinkFieldInfo(
      position = 7,
      unitSize = 4
  )
  public final float scale() {
    return scale;
  }

  /**
   * Minimum param value. The protocol does not define if this overwrites an onboard minimum value. 
   * (Depends on implementation) 
   */
  @MavlinkFieldInfo(
      position = 8,
      unitSize = 4
  )
  public final float paramValueMin() {
    return paramValueMin;
  }

  /**
   * Maximum param value. The protocol does not define if this overwrites an onboard maximum value. 
   * (Depends on implementation) 
   */
  @MavlinkFieldInfo(
      position = 9,
      unitSize = 4
  )
  public final float paramValueMax() {
    return paramValueMax;
  }

  /**
   * Parameter index. Send -1 to use the param ID field as identifier (else the param id will be 
   * ignored), send -2 to disable any existing map for this rc_channel_index. 
   */
  @MavlinkFieldInfo(
      position = 4,
      unitSize = 2
  )
  public final int paramIndex() {
    return paramIndex;
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
   * Onboard parameter id, terminated by NULL if the length is less than 16 human-readable chars and 
   * WITHOUT null termination (NULL) byte if the length is exactly 16 chars - applications have to 
   * provide 16+1 bytes storage if the ID is stored as string 
   */
  @MavlinkFieldInfo(
      position = 3,
      unitSize = 1,
      arraySize = 16
  )
  public final String paramId() {
    return paramId;
  }

  /**
   * Index of parameter RC channel. Not equal to the RC channel id. Typically correpsonds to a 
   * potentiometer-knob on the RC. 
   */
  @MavlinkFieldInfo(
      position = 5,
      unitSize = 1
  )
  public final int parameterRcChannelIndex() {
    return parameterRcChannelIndex;
  }

  public static class Builder {
    private float paramValue0;

    private float scale;

    private float paramValueMin;

    private float paramValueMax;

    private int paramIndex;

    private int targetSystem;

    private int targetComponent;

    private String paramId;

    private int parameterRcChannelIndex;

    private Builder() {
    }

    /**
     * Initial parameter value 
     */
    @MavlinkFieldInfo(
        position = 6,
        unitSize = 4
    )
    public final Builder paramValue0(float paramValue0) {
      this.paramValue0 = paramValue0;
      return this;
    }

    /**
     * Scale, maps the RC range [-1, 1] to a parameter value 
     */
    @MavlinkFieldInfo(
        position = 7,
        unitSize = 4
    )
    public final Builder scale(float scale) {
      this.scale = scale;
      return this;
    }

    /**
     * Minimum param value. The protocol does not define if this overwrites an onboard minimum value. 
     * (Depends on implementation) 
     */
    @MavlinkFieldInfo(
        position = 8,
        unitSize = 4
    )
    public final Builder paramValueMin(float paramValueMin) {
      this.paramValueMin = paramValueMin;
      return this;
    }

    /**
     * Maximum param value. The protocol does not define if this overwrites an onboard maximum value. 
     * (Depends on implementation) 
     */
    @MavlinkFieldInfo(
        position = 9,
        unitSize = 4
    )
    public final Builder paramValueMax(float paramValueMax) {
      this.paramValueMax = paramValueMax;
      return this;
    }

    /**
     * Parameter index. Send -1 to use the param ID field as identifier (else the param id will be 
     * ignored), send -2 to disable any existing map for this rc_channel_index. 
     */
    @MavlinkFieldInfo(
        position = 4,
        unitSize = 2
    )
    public final Builder paramIndex(int paramIndex) {
      this.paramIndex = paramIndex;
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
     * Onboard parameter id, terminated by NULL if the length is less than 16 human-readable chars and 
     * WITHOUT null termination (NULL) byte if the length is exactly 16 chars - applications have to 
     * provide 16+1 bytes storage if the ID is stored as string 
     */
    @MavlinkFieldInfo(
        position = 3,
        unitSize = 1,
        arraySize = 16
    )
    public final Builder paramId(String paramId) {
      this.paramId = paramId;
      return this;
    }

    /**
     * Index of parameter RC channel. Not equal to the RC channel id. Typically correpsonds to a 
     * potentiometer-knob on the RC. 
     */
    @MavlinkFieldInfo(
        position = 5,
        unitSize = 1
    )
    public final Builder parameterRcChannelIndex(int parameterRcChannelIndex) {
      this.parameterRcChannelIndex = parameterRcChannelIndex;
      return this;
    }

    public final ParamMapRc build() {
      return new ParamMapRc(paramValue0, scale, paramValueMin, paramValueMax, paramIndex, targetSystem, targetComponent, paramId, parameterRcChannelIndex);
    }
  }
}
