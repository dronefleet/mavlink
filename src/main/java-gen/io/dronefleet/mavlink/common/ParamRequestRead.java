package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import java.lang.Override;
import java.lang.String;

/**
 * Request to read the onboard parameter with the param_id string id. Onboard parameters are 
 * stored as key[const char*] -> value[float]. This allows to send a parameter to any other 
 * component (such as the GCS) without the need of previous knowledge of possible parameter 
 * names. Thus the same GCS can store different parameters for different autopilots. See also 
 * https://mavlink.io/en/protocol/parameter.html for a full documentation of 
 * QGroundControl and IMU code. 
 */
@MavlinkMessageInfo(
    id = 20,
    crc = 214
)
public final class ParamRequestRead {
  /**
   * Parameter index. Send -1 to use the param ID field as identifier (else the param id will be 
   * ignored) 
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

  private ParamRequestRead(int paramIndex, int targetSystem, int targetComponent, String paramId) {
    this.paramIndex = paramIndex;
    this.targetSystem = targetSystem;
    this.targetComponent = targetComponent;
    this.paramId = paramId;
  }

  @MavlinkMessageBuilder
  public static Builder builder() {
    return new Builder();
  }

  @Override
  public String toString() {
    return "ParamRequestRead{targetSystem=" + targetSystem
         + ", targetComponent=" + targetComponent
         + ", paramId=" + paramId
         + ", paramIndex=" + paramIndex + "}";
  }

  /**
   * Parameter index. Send -1 to use the param ID field as identifier (else the param id will be 
   * ignored) 
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

  public static class Builder {
    private int paramIndex;

    private int targetSystem;

    private int targetComponent;

    private String paramId;

    private Builder() {
    }

    /**
     * Parameter index. Send -1 to use the param ID field as identifier (else the param id will be 
     * ignored) 
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

    public final ParamRequestRead build() {
      return new ParamRequestRead(paramIndex, targetSystem, targetComponent, paramId);
    }
  }
}
