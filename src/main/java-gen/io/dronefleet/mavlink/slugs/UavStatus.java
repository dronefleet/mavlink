package io.dronefleet.mavlink.slugs;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import java.lang.Override;
import java.lang.String;

/**
 * Transmits the actual status values UAV in flight 
 */
@MavlinkMessageInfo(
    id = 193,
    crc = 160
)
public final class UavStatus {
  /**
   * Latitude UAV 
   */
  private final float latitude;

  /**
   * Longitude UAV 
   */
  private final float longitude;

  /**
   * Altitude UAV 
   */
  private final float altitude;

  /**
   * Speed UAV 
   */
  private final float speed;

  /**
   * Course UAV 
   */
  private final float course;

  /**
   * The ID system reporting the action 
   */
  private final int target;

  private UavStatus(float latitude, float longitude, float altitude, float speed, float course,
      int target) {
    this.latitude = latitude;
    this.longitude = longitude;
    this.altitude = altitude;
    this.speed = speed;
    this.course = course;
    this.target = target;
  }

  @MavlinkMessageBuilder
  public static Builder builder() {
    return new Builder();
  }

  @Override
  public String toString() {
    return "UavStatus{target=" + target
         + ", latitude=" + latitude
         + ", longitude=" + longitude
         + ", altitude=" + altitude
         + ", speed=" + speed
         + ", course=" + course + "}";
  }

  /**
   * Latitude UAV 
   */
  @MavlinkFieldInfo(
      position = 2,
      unitSize = 4
  )
  public final float latitude() {
    return latitude;
  }

  /**
   * Longitude UAV 
   */
  @MavlinkFieldInfo(
      position = 3,
      unitSize = 4
  )
  public final float longitude() {
    return longitude;
  }

  /**
   * Altitude UAV 
   */
  @MavlinkFieldInfo(
      position = 4,
      unitSize = 4
  )
  public final float altitude() {
    return altitude;
  }

  /**
   * Speed UAV 
   */
  @MavlinkFieldInfo(
      position = 5,
      unitSize = 4
  )
  public final float speed() {
    return speed;
  }

  /**
   * Course UAV 
   */
  @MavlinkFieldInfo(
      position = 6,
      unitSize = 4
  )
  public final float course() {
    return course;
  }

  /**
   * The ID system reporting the action 
   */
  @MavlinkFieldInfo(
      position = 1,
      unitSize = 1
  )
  public final int target() {
    return target;
  }

  public static class Builder {
    private float latitude;

    private float longitude;

    private float altitude;

    private float speed;

    private float course;

    private int target;

    private Builder() {
    }

    /**
     * Latitude UAV 
     */
    @MavlinkFieldInfo(
        position = 2,
        unitSize = 4
    )
    public final Builder latitude(float latitude) {
      this.latitude = latitude;
      return this;
    }

    /**
     * Longitude UAV 
     */
    @MavlinkFieldInfo(
        position = 3,
        unitSize = 4
    )
    public final Builder longitude(float longitude) {
      this.longitude = longitude;
      return this;
    }

    /**
     * Altitude UAV 
     */
    @MavlinkFieldInfo(
        position = 4,
        unitSize = 4
    )
    public final Builder altitude(float altitude) {
      this.altitude = altitude;
      return this;
    }

    /**
     * Speed UAV 
     */
    @MavlinkFieldInfo(
        position = 5,
        unitSize = 4
    )
    public final Builder speed(float speed) {
      this.speed = speed;
      return this;
    }

    /**
     * Course UAV 
     */
    @MavlinkFieldInfo(
        position = 6,
        unitSize = 4
    )
    public final Builder course(float course) {
      this.course = course;
      return this;
    }

    /**
     * The ID system reporting the action 
     */
    @MavlinkFieldInfo(
        position = 1,
        unitSize = 1
    )
    public final Builder target(int target) {
      this.target = target;
      return this;
    }

    public final UavStatus build() {
      return new UavStatus(latitude, longitude, altitude, speed, course, target);
    }
  }
}
