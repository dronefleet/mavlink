package io.dronefleet.mavlink.ardupilotmega;

import io.dronefleet.mavlink.annotations.MavlinkMessage;
import io.dronefleet.mavlink.annotations.MavlinkMessageField;

/**
 * Status of third AHRS filter if available. This is for ANU research group (Ali and Sean) 
 */
@MavlinkMessage(
    id = 182,
    crc = 229
)
public final class Ahrs3 {
  private final float roll;

  private final float pitch;

  private final float yaw;

  private final float altitude;

  private final int lat;

  private final int lng;

  private final float v1;

  private final float v2;

  private final float v3;

  private final float v4;

  private Ahrs3(float roll, float pitch, float yaw, float altitude, int lat, int lng, float v1,
      float v2, float v3, float v4) {
    this.roll = roll;
    this.pitch = pitch;
    this.yaw = yaw;
    this.altitude = altitude;
    this.lat = lat;
    this.lng = lng;
    this.v1 = v1;
    this.v2 = v2;
    this.v3 = v3;
    this.v4 = v4;
  }

  public static Builder builder() {
    return new Builder();
  }

  /**
   * Roll angle (rad) 
   */
  @MavlinkMessageField(
      position = 1,
      length = 4
  )
  public final float roll() {
    return roll;
  }

  /**
   * Pitch angle (rad) 
   */
  @MavlinkMessageField(
      position = 2,
      length = 4
  )
  public final float pitch() {
    return pitch;
  }

  /**
   * Yaw angle (rad) 
   */
  @MavlinkMessageField(
      position = 3,
      length = 4
  )
  public final float yaw() {
    return yaw;
  }

  /**
   * Altitude (MSL) 
   */
  @MavlinkMessageField(
      position = 4,
      length = 4
  )
  public final float altitude() {
    return altitude;
  }

  /**
   * Latitude in degrees * 1E7 
   */
  @MavlinkMessageField(
      position = 5,
      length = 4
  )
  public final int lat() {
    return lat;
  }

  /**
   * Longitude in degrees * 1E7 
   */
  @MavlinkMessageField(
      position = 6,
      length = 4
  )
  public final int lng() {
    return lng;
  }

  /**
   * test variable1 
   */
  @MavlinkMessageField(
      position = 7,
      length = 4
  )
  public final float v1() {
    return v1;
  }

  /**
   * test variable2 
   */
  @MavlinkMessageField(
      position = 8,
      length = 4
  )
  public final float v2() {
    return v2;
  }

  /**
   * test variable3 
   */
  @MavlinkMessageField(
      position = 9,
      length = 4
  )
  public final float v3() {
    return v3;
  }

  /**
   * test variable4 
   */
  @MavlinkMessageField(
      position = 10,
      length = 4
  )
  public final float v4() {
    return v4;
  }

  public class Builder {
    private float roll;

    private float pitch;

    private float yaw;

    private float altitude;

    private int lat;

    private int lng;

    private float v1;

    private float v2;

    private float v3;

    private float v4;

    private Builder() {
    }

    /**
     * Roll angle (rad) 
     */
    @MavlinkMessageField(
        position = 1,
        length = 4
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
        length = 4
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
        length = 4
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
        length = 4
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
        length = 4
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
        length = 4
    )
    public final Builder lng(int lng) {
      this.lng = lng;
      return this;
    }

    /**
     * test variable1 
     */
    @MavlinkMessageField(
        position = 7,
        length = 4
    )
    public final Builder v1(float v1) {
      this.v1 = v1;
      return this;
    }

    /**
     * test variable2 
     */
    @MavlinkMessageField(
        position = 8,
        length = 4
    )
    public final Builder v2(float v2) {
      this.v2 = v2;
      return this;
    }

    /**
     * test variable3 
     */
    @MavlinkMessageField(
        position = 9,
        length = 4
    )
    public final Builder v3(float v3) {
      this.v3 = v3;
      return this;
    }

    /**
     * test variable4 
     */
    @MavlinkMessageField(
        position = 10,
        length = 4
    )
    public final Builder v4(float v4) {
      this.v4 = v4;
      return this;
    }

    public final Ahrs3 build() {
      return new Ahrs3(roll, pitch, yaw, altitude, lat, lng, v1, v2, v3, v4);
    }
  }
}
