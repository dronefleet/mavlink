package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkMessage;
import io.dronefleet.mavlink.annotations.MavlinkMessageField;
import java.lang.String;

/**
 * Send a key-value pair as integer. The use of this message is discouraged for normal packets, but 
 * a quite efficient way for testing new messages and getting experimental debug output. 
 */
@MavlinkMessage(
    id = 252,
    crc = 44
)
public final class NamedValueInt {
  /**
   * Timestamp (milliseconds since system boot) 
   */
  private final long timeBootMs;

  /**
   * Name of the debug variable 
   */
  private final String name;

  /**
   * Signed integer value 
   */
  private final int value;

  private NamedValueInt(long timeBootMs, String name, int value) {
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
   * Signed integer value 
   */
  @MavlinkMessageField(
      position = 3,
      length = 4
  )
  public final int value() {
    return value;
  }

  public static class Builder {
    private long timeBootMs;

    private String name;

    private int value;

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
     * Signed integer value 
     */
    @MavlinkMessageField(
        position = 3,
        length = 4
    )
    public final Builder value(int value) {
      this.value = value;
      return this;
    }

    public final NamedValueInt build() {
      return new NamedValueInt(timeBootMs, name, value);
    }
  }
}
