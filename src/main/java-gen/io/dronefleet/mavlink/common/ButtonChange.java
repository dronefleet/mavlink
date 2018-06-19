package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkMessage;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageField;
import java.lang.Override;
import java.lang.String;

/**
 * Report button state change 
 */
@MavlinkMessage(
    id = 257,
    crc = 131
)
public final class ButtonChange {
  /**
   * Timestamp (milliseconds since system boot) 
   */
  private final long timeBootMs;

  /**
   * Time of last change of button state 
   */
  private final long lastChangeMs;

  /**
   * Bitmap state of buttons 
   */
  private final int state;

  private ButtonChange(long timeBootMs, long lastChangeMs, int state) {
    this.timeBootMs = timeBootMs;
    this.lastChangeMs = lastChangeMs;
    this.state = state;
  }

  @MavlinkMessageBuilder
  public static Builder builder() {
    return new Builder();
  }

  @Override
  public String toString() {
    return "ButtonChange{timeBootMs=" + timeBootMs
         + ", lastChangeMs=" + lastChangeMs
         + ", state=" + state + "}";
  }

  /**
   * Timestamp (milliseconds since system boot) 
   */
  @MavlinkMessageField(
      position = 1,
      unitSize = 4
  )
  public final long timeBootMs() {
    return timeBootMs;
  }

  /**
   * Time of last change of button state 
   */
  @MavlinkMessageField(
      position = 2,
      unitSize = 4
  )
  public final long lastChangeMs() {
    return lastChangeMs;
  }

  /**
   * Bitmap state of buttons 
   */
  @MavlinkMessageField(
      position = 3,
      unitSize = 1
  )
  public final int state() {
    return state;
  }

  public static class Builder {
    private long timeBootMs;

    private long lastChangeMs;

    private int state;

    private Builder() {
    }

    /**
     * Timestamp (milliseconds since system boot) 
     */
    @MavlinkMessageField(
        position = 1,
        unitSize = 4
    )
    public final Builder timeBootMs(long timeBootMs) {
      this.timeBootMs = timeBootMs;
      return this;
    }

    /**
     * Time of last change of button state 
     */
    @MavlinkMessageField(
        position = 2,
        unitSize = 4
    )
    public final Builder lastChangeMs(long lastChangeMs) {
      this.lastChangeMs = lastChangeMs;
      return this;
    }

    /**
     * Bitmap state of buttons 
     */
    @MavlinkMessageField(
        position = 3,
        unitSize = 1
    )
    public final Builder state(int state) {
      this.state = state;
      return this;
    }

    public final ButtonChange build() {
      return new ButtonChange(timeBootMs, lastChangeMs, state);
    }
  }
}
