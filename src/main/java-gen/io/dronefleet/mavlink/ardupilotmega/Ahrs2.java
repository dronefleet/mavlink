package io.dronefleet.mavlink.ardupilotmega;

import io.dronefleet.mavlink.annotations.MavlinkMessage;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageField;
import java.lang.Override;
import java.lang.String;

/**
 * Status of secondary {@link io.dronefleet.mavlink.ardupilotmega.Ahrs Ahrs} filter if available 
 */
@MavlinkMessage(
    id = 178,
    crc = 47
)
public final class Ahrs2 {
  /**
   * Roll angle (rad) 
   */
  private final float roll;

  /**
   * Pitch angle (rad) 
   */
  private final float pitch;

  /**
   * Yaw angle (rad) 
   */
  private final float yaw;

  /**
   * Altitude (MSL) 
   */
  private final float altitude;

  /**
   * Latitude in degrees * 1E7 
   */
  private final int lat;

  /**
   * Longitude in degrees * 1E7 
   */
  private final int lng;

  private Ahrs2(float roll, float pitch, float yaw, float altitude, int lat, int lng) {
    this.roll = roll;
    this.pitch = pitch;
    this.yaw = yaw;
    this.altitude = altitude;
    this.lat = lat;
    this.lng = lng;
  }

  @MavlinkMessageBuilder
  public static Builder builder() {
    return new Builder();
  }

  @Override
  public String toString() {
    return "Ahrs2{roll=" + roll
         + ", pitch=" + pitch
         + ", yaw=" + yaw
         + ", altitude=" + altitude
         + ", lat=" + lat
         + ", lng=" + lng + "}";
  }

  /**
   * Roll angle (rad) 
   */
  @MavlinkMessageField(
      position = 1,
      unitSize = 4
  )
  public final float roll() {
    return roll;
  }

  /**
   * Pitch angle (rad) 
   */
  @MavlinkMessageField(
      position = 2,
      unitSize = 4
  )
  public final float pitch() {
    return pitch;
  }

  /**
   * Yaw angle (rad) 
   */
  @MavlinkMessageField(
      position = 3,
      unitSize = 4
  )
  public final float yaw() {
    return yaw;
  }

  /**
   * Altitude (MSL) 
   */
  @MavlinkMessageField(
      position = 4,
      unitSize = 4
  )
  public final float altitude() {
    return altitude;
  }

  /**
   * Latitude in degrees * 1E7 
   */
  @MavlinkMessageField(
      position = 5,
      unitSize = 4
  )
  public final int lat() {
    return lat;
  }

  /**
   * Longitude in degrees * 1E7 
   */
  @MavlinkMessageField(
      position = 6,
      unitSize = 4
  )
  public final int lng() {
    return lng;
  }

  public static class Builder {
    private float roll;

    private float pitch;

    private float yaw;

    private float altitude;

    private int lat;

    private int lng;

    private Builder() {
    }

    /**
     * Roll angle (rad) 
     */
    @MavlinkMessageField(
        position = 1,
        unitSize = 4
    )
    public final Builder roll(float roll) {
      this.roll = roll;
      return this;
    }

    /**
     * Pitch angle (rad) 
     */
    @MavlinkMessageField(
        position = 2,
        unitSize = 4
    )
    public final Builder pitch(float pitch) {
      this.pitch = pitch;
      return this;
    }

    /**
     * Yaw angle (rad) 
     */
    @MavlinkMessageField(
        position = 3,
        unitSize = 4
    )
    public final Builder yaw(float yaw) {
      this.yaw = yaw;
      return this;
    }

    /**
     * Altitude (MSL) 
     */
    @MavlinkMessageField(
        position = 4,
        unitSize = 4
    )
    public final Builder altitude(float altitude) {
      this.altitude = altitude;
      return this;
    }

    /**
     * Latitude in degrees * 1E7 
     */
    @MavlinkMessageField(
        position = 5,
        unitSize = 4
    )
    public final Builder lat(int lat) {
      this.lat = lat;
      return this;
    }

    /**
     * Longitude in degrees * 1E7 
     */
    @MavlinkMessageField(
        position = 6,
        unitSize = 4
    )
    public final Builder lng(int lng) {
      this.lng = lng;
      return this;
    }

    public final Ahrs2 build() {
      return new Ahrs2(roll, pitch, yaw, altitude, lat, lng);
    }
  }
}
