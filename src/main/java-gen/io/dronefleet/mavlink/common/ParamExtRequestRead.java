package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkMessage;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageField;
import java.lang.Override;
import java.lang.String;

/**
 * Request to read the value of a parameter with the either the param_id string id or param_index. 
 */
@MavlinkMessage(
    id = 320,
    crc = 243
)
public final class ParamExtRequestRead {
  /**
   * Parameter index. Set to -1 to use the Parameter ID field as identifier (else param_id will be 
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
   * Parameter id, terminated by NULL if the length is less than 16 human-readable chars and WITHOUT 
   * null termination (NULL) byte if the length is exactly 16 chars - applications have to provide 
   * 16+1 bytes storage if the ID is stored as string 
   */
  private final String paramId;

  private ParamExtRequestRead(int paramIndex, int targetSystem, int targetComponent,
      String paramId) {
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
    return "ParamExtRequestRead{targetSystem=" + targetSystem
         + ", targetComponent=" + targetComponent
         + ", paramId=" + paramId
         + ", paramIndex=" + paramIndex + "}";
  }

  /**
   * Parameter index. Set to -1 to use the Parameter ID field as identifier (else param_id will be 
   * ignored) 
   */
  @MavlinkMessageField(
      position = 4,
      unitSize = 2
  )
  public final int paramIndex() {
    return paramIndex;
  }

  /**
   * System ID 
   */
  @MavlinkMessageField(
      position = 1,
      unitSize = 1
  )
  public final int targetSystem() {
    return targetSystem;
  }

  /**
   * Component ID 
   */
  @MavlinkMessageField(
      position = 2,
      unitSize = 1
  )
  public final int targetComponent() {
    return targetComponent;
  }

  /**
   * Parameter id, terminated by NULL if the length is less than 16 human-readable chars and WITHOUT 
   * null termination (NULL) byte if the length is exactly 16 chars - applications have to provide 
   * 16+1 bytes storage if the ID is stored as string 
   */
  @MavlinkMessageField(
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
     * Parameter index. Set to -1 to use the Parameter ID field as identifier (else param_id will be 
     * ignored) 
     */
    @MavlinkMessageField(
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
    @MavlinkMessageField(
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
    @MavlinkMessageField(
        position = 2,
        unitSize = 1
    )
    public final Builder targetComponent(int targetComponent) {
      this.targetComponent = targetComponent;
      return this;
    }

    /**
     * Parameter id, terminated by NULL if the length is less than 16 human-readable chars and WITHOUT 
     * null termination (NULL) byte if the length is exactly 16 chars - applications have to provide 
     * 16+1 bytes storage if the ID is stored as string 
     */
    @MavlinkMessageField(
        position = 3,
        unitSize = 1,
        arraySize = 16
    )
    public final Builder paramId(String paramId) {
      this.paramId = paramId;
      return this;
    }

    public final ParamExtRequestRead build() {
      return new ParamExtRequestRead(paramIndex, targetSystem, targetComponent, paramId);
    }
  }
}
