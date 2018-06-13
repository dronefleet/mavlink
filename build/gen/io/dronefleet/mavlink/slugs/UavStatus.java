package io.dronefleet.mavlink.slugs;

import io.dronefleet.mavlink.annotations.MavlinkMessage;
import io.dronefleet.mavlink.annotations.MavlinkMessageField;

/**
 * Transmits the actual status values UAV in flight 
 */
@MavlinkMessage(
    id = 193,
    crc = 160
)
public final class UavStatus {
  private final int target;

  private final float latitude;

  private final float longitude;

  private final float altitude;

  private final float speed;

  private final float course;

  private UavStatus(int target, float latitude, float longitude, float altitude, float speed,
      float course) {
    this.target = target;
    this.latitude = latitude;
    this.longitude = longitude;
    this.altitude = altitude;
    this.speed = speed;
    this.course = course;
  }

  public static Builder builder() {
    return new Builder();
  }

  /**
   * The ID system reporting the action 
   */
  @MavlinkMessageField(
      position = 1,
      length = 1
  )
  public final int target() {
    return target;
  }

  /**
   * Latitude UAV 
   */
  @MavlinkMessageField(
      position = 2,
      length = 4
  )
  public final float latitude() {
    return latitude;
  }

  /**
   * Longitude UAV 
   */
  @MavlinkMessageField(
      position = 3,
      length = 4
  )
  public final float longitude() {
    return longitude;
  }

  /**
   * Altitude UAV 
   */
  @MavlinkMessageField(
      position = 4,
      length = 4
  )
  public final float altitude() {
    return altitude;
  }

  /**
   * Speed UAV 
   */
  @MavlinkMessageField(
      position = 5,
      length = 4
  )
  public final float speed() {
    return speed;
  }

  /**
   * Course UAV 
   */
  @MavlinkMessageField(
      position = 6,
      length = 4
  )
  public final float course() {
    return course;
  }

  public class Builder {
    private int target;

    private float latitude;

    private float longitude;

    private float altitude;

    private float speed;

    private float course;

    private Builder() {
    }

    /**
     * The ID system reporting the action 
     */
    @MavlinkMessageField(
        position = 1,
        length = 1
    )
    public final Builder target(int target) {
      this.target = target;
      return this;
    }

    /**
     * Latitude UAV 
     */
    @MavlinkMessageField(
        position = 2,
        length = 4
    )
    public final Builder latitude(float latitude) {
      this.latitude = latitude;
      return this;
    }

    /**
     * Longitude UAV 
     */
    @MavlinkMessageField(
        position = 3,
        length = 4
    )
    public final Builder longitude(float longitude) {
      this.longitude = longitude;
      return this;
    }

    /**
     * Altitude UAV 
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
     * Speed UAV 
     */
    @MavlinkMessageField(
        position = 5,
        length = 4
    )
    public final Builder speed(float speed) {
      this.speed = speed;
      return this;
    }

    /**
     * Course UAV 
     */
    @MavlinkMessageField(
        position = 6,
        length = 4
    )
    public final Builder course(float course) {
      this.course = course;
      return this;
    }

    public final UavStatus build() {
      return new UavStatus(target, latitude, longitude, altitude, speed, course);
    }
  }
}
