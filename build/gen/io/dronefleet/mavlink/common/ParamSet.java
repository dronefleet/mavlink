package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkMessage;
import io.dronefleet.mavlink.annotations.MavlinkMessageField;
import java.lang.Integer;
import java.util.List;

/**
 * Set a parameter value TEMPORARILY to RAM. It will be reset to default on system reboot. Send the 
 * ACTION MAV_ACTION_STORAGE_WRITE to PERMANENTLY write the RAM contents to EEPROM. 
 * IMPORTANT: The receiving component should acknowledge the new parameter value by sending a 
 * param_value message to all communication partners. This will also ensure that multiple GCS 
 * all have an up-to-date list of all parameters. If the sending GCS did not receive a PARAM_VALUE 
 * message within its timeout time, it should re-send the PARAM_SET message. 
 */
@MavlinkMessage(
    id = 23,
    crc = 168
)
public final class ParamSet {
  private final int targetSystem;

  private final int targetComponent;

  private final List<Integer> paramId;

  private final float paramValue;

  private final MavParamType paramType;

  private ParamSet(int targetSystem, int targetComponent, List<Integer> paramId, float paramValue,
      MavParamType paramType) {
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
   * Onboard parameter value 
   */
  @MavlinkMessageField(
      position = 4,
      length = 4
  )
  public final float paramValue() {
    return paramValue;
  }

  /**
   * Onboard parameter type: see the MAV_PARAM_TYPE enum for supported data types. 
   */
  @MavlinkMessageField(
      position = 5,
      length = 1
  )
  public final MavParamType paramType() {
    return paramType;
  }

  public class Builder {
    private int targetSystem;

    private int targetComponent;

    private List<Integer> paramId;

    private float paramValue;

    private MavParamType paramType;

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
     * Onboard parameter value 
     */
    @MavlinkMessageField(
        position = 4,
        length = 4
    )
    public final Builder paramValue(float paramValue) {
      this.paramValue = paramValue;
      return this;
    }

    /**
     * Onboard parameter type: see the MAV_PARAM_TYPE enum for supported data types. 
     */
    @MavlinkMessageField(
        position = 5,
        length = 1
    )
    public final Builder paramType(MavParamType paramType) {
      this.paramType = paramType;
      return this;
    }

    public final ParamSet build() {
      return new ParamSet(targetSystem, targetComponent, paramId, paramValue, paramType);
    }
  }
}
