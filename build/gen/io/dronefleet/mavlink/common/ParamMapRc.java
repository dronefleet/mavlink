package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkMessage;
import io.dronefleet.mavlink.annotations.MavlinkMessageField;
import java.lang.Integer;
import java.util.List;

/**
 * Bind a RC channel to a parameter. The parameter should change accoding to the RC channel value. 
 */
@MavlinkMessage(
    id = 50,
    crc = 78
)
public final class ParamMapRc {
  private final int targetSystem;

  private final int targetComponent;

  private final List<Integer> paramId;

  private final int paramIndex;

  private final int parameterRcChannelIndex;

  private final float paramValue0;

  private final float scale;

  private final float paramValueMin;

  private final float paramValueMax;

  private ParamMapRc(int targetSystem, int targetComponent, List<Integer> paramId, int paramIndex,
      int parameterRcChannelIndex, float paramValue0, float scale, float paramValueMin,
      float paramValueMax) {
    this.targetSystem = targetSystem;
    this.targetComponent = targetComponent;
    this.paramId = paramId;
    this.paramIndex = paramIndex;
    this.parameterRcChannelIndex = parameterRcChannelIndex;
    this.paramValue0 = paramValue0;
    this.scale = scale;
    this.paramValueMin = paramValueMin;
    this.paramValueMax = paramValueMax;
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
   * Onboard parameter id, terminated by NULL if the length is less than 16 human-readable chars and 
   * WITHOUT null termination (NULL) byte if the length is exactly 16 chars - applications have to 
   * provide 16+1 bytes storage if the ID is stored as string 
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
   * Parameter index. Send -1 to use the param ID field as identifier (else the param id will be 
   * ignored), send -2 to disable any existing map for this rc_channel_index. 
   */
  @MavlinkMessageField(
      position = 4,
      length = 2
  )
  public final int paramIndex() {
    return paramIndex;
  }

  /**
   * Index of parameter RC channel. Not equal to the RC channel id. Typically correpsonds to a 
   * potentiometer-knob on the RC. 
   */
  @MavlinkMessageField(
      position = 5,
      length = 1
  )
  public final int parameterRcChannelIndex() {
    return parameterRcChannelIndex;
  }

  /**
   * Initial parameter value 
   */
  @MavlinkMessageField(
      position = 6,
      length = 4
  )
  public final float paramValue0() {
    return paramValue0;
  }

  /**
   * Scale, maps the RC range [-1, 1] to a parameter value 
   */
  @MavlinkMessageField(
      position = 7,
      length = 4
  )
  public final float scale() {
    return scale;
  }

  /**
   * Minimum param value. The protocol does not define if this overwrites an onboard minimum value. 
   * (Depends on implementation) 
   */
  @MavlinkMessageField(
      position = 8,
      length = 4
  )
  public final float paramValueMin() {
    return paramValueMin;
  }

  /**
   * Maximum param value. The protocol does not define if this overwrites an onboard maximum value. 
   * (Depends on implementation) 
   */
  @MavlinkMessageField(
      position = 9,
      length = 4
  )
  public final float paramValueMax() {
    return paramValueMax;
  }

  public class Builder {
    private int targetSystem;

    private int targetComponent;

    private List<Integer> paramId;

    private int paramIndex;

    private int parameterRcChannelIndex;

    private float paramValue0;

    private float scale;

    private float paramValueMin;

    private float paramValueMax;

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
     * Onboard parameter id, terminated by NULL if the length is less than 16 human-readable chars and 
     * WITHOUT null termination (NULL) byte if the length is exactly 16 chars - applications have to 
     * provide 16+1 bytes storage if the ID is stored as string 
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
     * Parameter index. Send -1 to use the param ID field as identifier (else the param id will be 
     * ignored), send -2 to disable any existing map for this rc_channel_index. 
     */
    @MavlinkMessageField(
        position = 4,
        length = 2
    )
    public final Builder paramIndex(int paramIndex) {
      this.paramIndex = paramIndex;
      return this;
    }

    /**
     * Index of parameter RC channel. Not equal to the RC channel id. Typically correpsonds to a 
     * potentiometer-knob on the RC. 
     */
    @MavlinkMessageField(
        position = 5,
        length = 1
    )
    public final Builder parameterRcChannelIndex(int parameterRcChannelIndex) {
      this.parameterRcChannelIndex = parameterRcChannelIndex;
      return this;
    }

    /**
     * Initial parameter value 
     */
    @MavlinkMessageField(
        position = 6,
        length = 4
    )
    public final Builder paramValue0(float paramValue0) {
      this.paramValue0 = paramValue0;
      return this;
    }

    /**
     * Scale, maps the RC range [-1, 1] to a parameter value 
     */
    @MavlinkMessageField(
        position = 7,
        length = 4
    )
    public final Builder scale(float scale) {
      this.scale = scale;
      return this;
    }

    /**
     * Minimum param value. The protocol does not define if this overwrites an onboard minimum value. 
     * (Depends on implementation) 
     */
    @MavlinkMessageField(
        position = 8,
        length = 4
    )
    public final Builder paramValueMin(float paramValueMin) {
      this.paramValueMin = paramValueMin;
      return this;
    }

    /**
     * Maximum param value. The protocol does not define if this overwrites an onboard maximum value. 
     * (Depends on implementation) 
     */
    @MavlinkMessageField(
        position = 9,
        length = 4
    )
    public final Builder paramValueMax(float paramValueMax) {
      this.paramValueMax = paramValueMax;
      return this;
    }

    public final ParamMapRc build() {
      return new ParamMapRc(targetSystem, targetComponent, paramId, paramIndex, parameterRcChannelIndex, paramValue0, scale, paramValueMin, paramValueMax);
    }
  }
}
