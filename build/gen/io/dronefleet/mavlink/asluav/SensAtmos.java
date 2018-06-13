package io.dronefleet.mavlink.asluav;

import io.dronefleet.mavlink.annotations.MavlinkMessage;
import io.dronefleet.mavlink.annotations.MavlinkMessageField;

/**
 * Atmospheric sensors (temperature, humidity, ...) 
 */
@MavlinkMessage(
    id = 208,
    crc = 175
)
public final class SensAtmos {
  private final float tempambient;

  private final float humidity;

  private SensAtmos(float tempambient, float humidity) {
    this.tempambient = tempambient;
    this.humidity = humidity;
  }

  public static Builder builder() {
    return new Builder();
  }

  /**
   * Ambient temperature 
   */
  @MavlinkMessageField(
      position = 1,
      length = 4
  )
  public final float tempambient() {
    return tempambient;
  }

  /**
   * Relative humidity 
   */
  @MavlinkMessageField(
      position = 2,
      length = 4
  )
  public final float humidity() {
    return humidity;
  }

  public class Builder {
    private float tempambient;

    private float humidity;

    private Builder() {
    }

    /**
     * Ambient temperature 
     */
    @MavlinkMessageField(
        position = 1,
        length = 4
    )
    public final Builder tempambient(float tempambient) {
      this.tempambient = tempambient;
      return this;
    }

    /**
     * Relative humidity 
     */
    @MavlinkMessageField(
        position = 2,
        length = 4
    )
    public final Builder humidity(float humidity) {
      this.humidity = humidity;
      return this;
    }

    public final SensAtmos build() {
      return new SensAtmos(tempambient, humidity);
    }
  }
}
