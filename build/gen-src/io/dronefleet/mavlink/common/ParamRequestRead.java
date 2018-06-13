package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkMessage;
import io.dronefleet.mavlink.annotations.MavlinkMessageField;
import java.lang.Integer;
import java.util.List;

/**
 * Request to read the onboard parameter with the param_id string id. Onboard parameters are 
 * stored as key[const char*] -> value[float]. This allows to send a parameter to any other 
 * component (such as the GCS) without the need of previous knowledge of possible parameter 
 * names. Thus the same GCS can store different parameters for different autopilots. See also 
 * https://mavlink.io/en/protocol/parameter.html for a full documentation of 
 * QGroundControl and IMU code. 
 */
@MavlinkMessage(
    id = 20,
    crc = 214
)
public final class ParamRequestRead {
  private final int targetSystem;

  private final int targetComponent;

  private final List<Integer> paramId;

  private final int paramIndex;

  private ParamRequestRead(int targetSystem, int targetComponent, List<Integer> paramId,
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

    public final ParamRequestRead build() {
      return new ParamRequestRead(targetSystem, targetComponent, paramId, paramIndex);
    }
  }
}
