package io.dronefleet.mavlink.ardupilotmega;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import java.lang.Integer;
import java.lang.Override;
import java.lang.String;
import java.util.List;

/**
 * Control vehicle LEDs 
 */
@MavlinkMessageInfo(
    id = 186,
    crc = 72
)
public final class LedControl {
  /**
   * System ID 
   */
  private final int targetSystem;

  /**
   * Component ID 
   */
  private final int targetComponent;

  /**
   * Instance (LED instance to control or 255 for all LEDs) 
   */
  private final int instance;

  /**
   * Pattern (see LED_PATTERN_ENUM) 
   */
  private final int pattern;

  /**
   * Custom Byte Length 
   */
  private final int customLen;

  /**
   * Custom Bytes 
   */
  private final List<Integer> customBytes;

  private LedControl(int targetSystem, int targetComponent, int instance, int pattern,
      int customLen, List<Integer> customBytes) {
    this.targetSystem = targetSystem;
    this.targetComponent = targetComponent;
    this.instance = instance;
    this.pattern = pattern;
    this.customLen = customLen;
    this.customBytes = customBytes;
  }

  @MavlinkMessageBuilder
  public static Builder builder() {
    return new Builder();
  }

  @Override
  public String toString() {
    return "LedControl{targetSystem=" + targetSystem
         + ", targetComponent=" + targetComponent
         + ", instance=" + instance
         + ", pattern=" + pattern
         + ", customLen=" + customLen
         + ", customBytes=" + customBytes + "}";
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
   * Instance (LED instance to control or 255 for all LEDs) 
   */
  @MavlinkFieldInfo(
      position = 3,
      unitSize = 1
  )
  public final int instance() {
    return instance;
  }

  /**
   * Pattern (see LED_PATTERN_ENUM) 
   */
  @MavlinkFieldInfo(
      position = 4,
      unitSize = 1
  )
  public final int pattern() {
    return pattern;
  }

  /**
   * Custom Byte Length 
   */
  @MavlinkFieldInfo(
      position = 5,
      unitSize = 1
  )
  public final int customLen() {
    return customLen;
  }

  /**
   * Custom Bytes 
   */
  @MavlinkFieldInfo(
      position = 6,
      unitSize = 1,
      arraySize = 24
  )
  public final List<Integer> customBytes() {
    return customBytes;
  }

  public static class Builder {
    private int targetSystem;

    private int targetComponent;

    private int instance;

    private int pattern;

    private int customLen;

    private List<Integer> customBytes;

    private Builder() {
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
     * Instance (LED instance to control or 255 for all LEDs) 
     */
    @MavlinkFieldInfo(
        position = 3,
        unitSize = 1
    )
    public final Builder instance(int instance) {
      this.instance = instance;
      return this;
    }

    /**
     * Pattern (see LED_PATTERN_ENUM) 
     */
    @MavlinkFieldInfo(
        position = 4,
        unitSize = 1
    )
    public final Builder pattern(int pattern) {
      this.pattern = pattern;
      return this;
    }

    /**
     * Custom Byte Length 
     */
    @MavlinkFieldInfo(
        position = 5,
        unitSize = 1
    )
    public final Builder customLen(int customLen) {
      this.customLen = customLen;
      return this;
    }

    /**
     * Custom Bytes 
     */
    @MavlinkFieldInfo(
        position = 6,
        unitSize = 1,
        arraySize = 24
    )
    public final Builder customBytes(List<Integer> customBytes) {
      this.customBytes = customBytes;
      return this;
    }

    public final LedControl build() {
      return new LedControl(targetSystem, targetComponent, instance, pattern, customLen, customBytes);
    }
  }
}
