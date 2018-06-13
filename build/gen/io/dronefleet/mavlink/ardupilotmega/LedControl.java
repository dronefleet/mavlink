package io.dronefleet.mavlink.ardupilotmega;

import io.dronefleet.mavlink.annotations.MavlinkMessage;
import io.dronefleet.mavlink.annotations.MavlinkMessageField;
import java.lang.Integer;
import java.util.List;

/**
 * Control vehicle LEDs 
 */
@MavlinkMessage(
    id = 186,
    crc = 72
)
public final class LedControl {
  private final int targetSystem;

  private final int targetComponent;

  private final int instance;

  private final int pattern;

  private final int customLen;

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
   * Instance (LED instance to control or 255 for all LEDs) 
   */
  @MavlinkMessageField(
      position = 3,
      length = 1
  )
  public final int instance() {
    return instance;
  }

  /**
   * Pattern (see LED_PATTERN_ENUM) 
   */
  @MavlinkMessageField(
      position = 4,
      length = 1
  )
  public final int pattern() {
    return pattern;
  }

  /**
   * Custom Byte Length 
   */
  @MavlinkMessageField(
      position = 5,
      length = 1
  )
  public final int customLen() {
    return customLen;
  }

  /**
   * Custom Bytes 
   */
  @MavlinkMessageField(
      position = 6,
      length = 1,
      arraySize = 24
  )
  public final List<Integer> customBytes() {
    return customBytes;
  }

  public class Builder {
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
     * Instance (LED instance to control or 255 for all LEDs) 
     */
    @MavlinkMessageField(
        position = 3,
        length = 1
    )
    public final Builder instance(int instance) {
      this.instance = instance;
      return this;
    }

    /**
     * Pattern (see LED_PATTERN_ENUM) 
     */
    @MavlinkMessageField(
        position = 4,
        length = 1
    )
    public final Builder pattern(int pattern) {
      this.pattern = pattern;
      return this;
    }

    /**
     * Custom Byte Length 
     */
    @MavlinkMessageField(
        position = 5,
        length = 1
    )
    public final Builder customLen(int customLen) {
      this.customLen = customLen;
      return this;
    }

    /**
     * Custom Bytes 
     */
    @MavlinkMessageField(
        position = 6,
        length = 1,
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
