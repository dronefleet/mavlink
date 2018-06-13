package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkMessage;
import io.dronefleet.mavlink.annotations.MavlinkMessageField;
import java.lang.String;

/**
 * Send a key-value pair as float. The use of this message is discouraged for normal packets, but a 
 * quite efficient way for testing new messages and getting experimental debug output. 
 */
@MavlinkMessage(
    id = 251,
    crc = 170
)
public final class NamedValueFloat {
  /**
   * Timestamp (milliseconds since system boot) 
   */
  private final long timeBootMs;

  /**
   * Name of the debug variable 
   */
  private final String name;

  /**
   * Floating point value 
   */
  private final float value;

  private NamedValueFloat(long timeBootMs, String name, float value) {
    this.timeBootMs = timeBootMs;
    this.name = name;
    this.value = value;
  }

  public static Builder builder() {
    return new Builder();
  }

  /**
   * Timestamp (milliseconds since system boot) 
   */
  @MavlinkMessageField(
      position = 1,
      length = 4
  )
  public final long timeBootMs() {
    return timeBootMs;
  }

  /**
   * Name of the debug variable 
   */
  @MavlinkMessageField(
      position = 2,
      length = 1,
      arraySize = 10
  )
  public final String name() {
    return name;
  }

  /**
   * Floating point value 
   */
  @MavlinkMessageField(
      position = 3,
      length = 4
  )
  public final float value() {
    return value;
  }

  public static class Builder {
    private long timeBootMs;

    private String name;

    private float value;

    private Builder() {
    }

    /**
     * Timestamp (milliseconds since system boot) 
     */
    @MavlinkMessageField(
        position = 1,
        length = 4
    )
    public final Builder timeBootMs(long timeBootMs) {
      this.timeBootMs = timeBootMs;
      return this;
    }

    /**
     * Name of the debug variable 
     */
    @MavlinkMessageField(
        position = 2,
        length = 1,
        arraySize = 10
    )
    public final Builder name(String name) {
      this.name = name;
      return this;
    }

    /**
     * Floating point value 
     */
    @MavlinkMessageField(
        position = 3,
        length = 4
    )
    public final Builder value(float value) {
      this.value = value;
      return this;
    }

    public final NamedValueFloat build() {
      return new NamedValueFloat(timeBootMs, name, value);
    }
  }
}
