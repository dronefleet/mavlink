package io.dronefleet.mavlink.asluav;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import java.lang.Override;
import java.lang.String;

/**
 * Atmospheric sensors (temperature, humidity, ...) 
 */
@MavlinkMessageInfo(
    id = 208,
    crc = 175
)
public final class SensAtmos {
  /**
   * Ambient temperature 
   */
  private final float tempambient;

  /**
   * Relative humidity 
   */
  private final float humidity;

  private SensAtmos(float tempambient, float humidity) {
    this.tempambient = tempambient;
    this.humidity = humidity;
  }

  @MavlinkMessageBuilder
  public static Builder builder() {
    return new Builder();
  }

  @Override
  public String toString() {
    return "SensAtmos{tempambient=" + tempambient
         + ", humidity=" + humidity + "}";
  }

  /**
   * Ambient temperature 
   */
  @MavlinkFieldInfo(
      position = 1,
      unitSize = 4
  )
  public final float tempambient() {
    return tempambient;
  }

  /**
   * Relative humidity 
   */
  @MavlinkFieldInfo(
      position = 2,
      unitSize = 4
  )
  public final float humidity() {
    return humidity;
  }

  public static class Builder {
    private float tempambient;

    private float humidity;

    private Builder() {
    }

    /**
     * Ambient temperature 
     */
    @MavlinkFieldInfo(
        position = 1,
        unitSize = 4
    )
    public final Builder tempambient(float tempambient) {
      this.tempambient = tempambient;
      return this;
    }

    /**
     * Relative humidity 
     */
    @MavlinkFieldInfo(
        position = 2,
        unitSize = 4
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
