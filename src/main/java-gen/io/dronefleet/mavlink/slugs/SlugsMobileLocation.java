package io.dronefleet.mavlink.slugs;

import io.dronefleet.mavlink.annotations.MavlinkMessage;
import io.dronefleet.mavlink.annotations.MavlinkMessageField;

/**
 * Transmits the last known position of the mobile GS to the UAV. Very relevant when Track Mobile is 
 * enabled 
 */
@MavlinkMessage(
    id = 186,
    crc = 101
)
public final class SlugsMobileLocation {
  /**
   * The system reporting the action 
   */
  private final int target;

  /**
   * Mobile Latitude 
   */
  private final float latitude;

  /**
   * Mobile Longitude 
   */
  private final float longitude;

  private SlugsMobileLocation(int target, float latitude, float longitude) {
    this.target = target;
    this.latitude = latitude;
    this.longitude = longitude;
  }

  public static Builder builder() {
    return new Builder();
  }

  /**
   * The system reporting the action 
   */
  @MavlinkMessageField(
      position = 1,
      length = 1
  )
  public final int target() {
    return target;
  }

  /**
   * Mobile Latitude 
   */
  @MavlinkMessageField(
      position = 2,
      length = 4
  )
  public final float latitude() {
    return latitude;
  }

  /**
   * Mobile Longitude 
   */
  @MavlinkMessageField(
      position = 3,
      length = 4
  )
  public final float longitude() {
    return longitude;
  }

  public static class Builder {
    private int target;

    private float latitude;

    private float longitude;

    private Builder() {
    }

    /**
     * The system reporting the action 
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
     * Mobile Latitude 
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
     * Mobile Longitude 
     */
    @MavlinkMessageField(
        position = 3,
        length = 4
    )
    public final Builder longitude(float longitude) {
      this.longitude = longitude;
      return this;
    }

    public final SlugsMobileLocation build() {
      return new SlugsMobileLocation(target, latitude, longitude);
    }
  }
}
