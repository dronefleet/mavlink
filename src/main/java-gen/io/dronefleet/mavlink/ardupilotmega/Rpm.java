package io.dronefleet.mavlink.ardupilotmega;

import io.dronefleet.mavlink.annotations.MavlinkMessage;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageField;
import java.lang.Override;
import java.lang.String;

/**
 * RPM sensor output 
 */
@MavlinkMessage(
    id = 226,
    crc = 207
)
public final class Rpm {
  /**
   * RPM Sensor1 
   */
  private final float rpm1;

  /**
   * RPM Sensor2 
   */
  private final float rpm2;

  private Rpm(float rpm1, float rpm2) {
    this.rpm1 = rpm1;
    this.rpm2 = rpm2;
  }

  @MavlinkMessageBuilder
  public static Builder builder() {
    return new Builder();
  }

  @Override
  public String toString() {
    return "Rpm{rpm1=" + rpm1
         + ", rpm2=" + rpm2 + "}";
  }

  /**
   * RPM Sensor1 
   */
  @MavlinkMessageField(
      position = 1,
      unitSize = 4
  )
  public final float rpm1() {
    return rpm1;
  }

  /**
   * RPM Sensor2 
   */
  @MavlinkMessageField(
      position = 2,
      unitSize = 4
  )
  public final float rpm2() {
    return rpm2;
  }

  public static class Builder {
    private float rpm1;

    private float rpm2;

    private Builder() {
    }

    /**
     * RPM Sensor1 
     */
    @MavlinkMessageField(
        position = 1,
        unitSize = 4
    )
    public final Builder rpm1(float rpm1) {
      this.rpm1 = rpm1;
      return this;
    }

    /**
     * RPM Sensor2 
     */
    @MavlinkMessageField(
        position = 2,
        unitSize = 4
    )
    public final Builder rpm2(float rpm2) {
      this.rpm2 = rpm2;
      return this;
    }

    public final Rpm build() {
      return new Rpm(rpm1, rpm2);
    }
  }
}
