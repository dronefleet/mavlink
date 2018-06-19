package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkMessage;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageField;
import java.lang.Override;
import java.lang.String;

/**
 * Barometer readings for 3rd barometer 
 */
@MavlinkMessage(
    id = 143,
    crc = 131
)
public final class ScaledPressure3 {
  /**
   * Timestamp (milliseconds since system boot) 
   */
  private final long timeBootMs;

  /**
   * Absolute pressure (hectopascal) 
   */
  private final float pressAbs;

  /**
   * Differential pressure 1 (hectopascal) 
   */
  private final float pressDiff;

  /**
   * Temperature measurement (0.01 degrees celsius) 
   */
  private final int temperature;

  private ScaledPressure3(long timeBootMs, float pressAbs, float pressDiff, int temperature) {
    this.timeBootMs = timeBootMs;
    this.pressAbs = pressAbs;
    this.pressDiff = pressDiff;
    this.temperature = temperature;
  }

  @MavlinkMessageBuilder
  public static Builder builder() {
    return new Builder();
  }

  @Override
  public String toString() {
    return "ScaledPressure3{timeBootMs=" + timeBootMs
         + ", pressAbs=" + pressAbs
         + ", pressDiff=" + pressDiff
         + ", temperature=" + temperature + "}";
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
   * Absolute pressure (hectopascal) 
   */
  @MavlinkMessageField(
      position = 2,
      unitSize = 4
  )
  public final float pressAbs() {
    return pressAbs;
  }

  /**
   * Differential pressure 1 (hectopascal) 
   */
  @MavlinkMessageField(
      position = 3,
      unitSize = 4
  )
  public final float pressDiff() {
    return pressDiff;
  }

  /**
   * Temperature measurement (0.01 degrees celsius) 
   */
  @MavlinkMessageField(
      position = 4,
      unitSize = 2
  )
  public final int temperature() {
    return temperature;
  }

  public static class Builder {
    private long timeBootMs;

    private float pressAbs;

    private float pressDiff;

    private int temperature;

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
     * Absolute pressure (hectopascal) 
     */
    @MavlinkMessageField(
        position = 2,
        unitSize = 4
    )
    public final Builder pressAbs(float pressAbs) {
      this.pressAbs = pressAbs;
      return this;
    }

    /**
     * Differential pressure 1 (hectopascal) 
     */
    @MavlinkMessageField(
        position = 3,
        unitSize = 4
    )
    public final Builder pressDiff(float pressDiff) {
      this.pressDiff = pressDiff;
      return this;
    }

    /**
     * Temperature measurement (0.01 degrees celsius) 
     */
    @MavlinkMessageField(
        position = 4,
        unitSize = 2
    )
    public final Builder temperature(int temperature) {
      this.temperature = temperature;
      return this;
    }

    public final ScaledPressure3 build() {
      return new ScaledPressure3(timeBootMs, pressAbs, pressDiff, temperature);
    }
  }
}
