package io.dronefleet.mavlink.slugs;

import io.dronefleet.mavlink.annotations.MavlinkMessage;
import io.dronefleet.mavlink.annotations.MavlinkMessageField;

/**
 * Transmits the position of watch 
 */
@MavlinkMessage(
    id = 189,
    crc = 246
)
public final class IsrLocation {
  private final int target;

  private final float latitude;

  private final float longitude;

  private final float height;

  private final int option1;

  private final int option2;

  private final int option3;

  private IsrLocation(int target, float latitude, float longitude, float height, int option1,
      int option2, int option3) {
    this.target = target;
    this.latitude = latitude;
    this.longitude = longitude;
    this.height = height;
    this.option1 = option1;
    this.option2 = option2;
    this.option3 = option3;
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
   * ISR Latitude 
   */
  @MavlinkMessageField(
      position = 2,
      length = 4
  )
  public final float latitude() {
    return latitude;
  }

  /**
   * ISR Longitude 
   */
  @MavlinkMessageField(
      position = 3,
      length = 4
  )
  public final float longitude() {
    return longitude;
  }

  /**
   * ISR Height 
   */
  @MavlinkMessageField(
      position = 4,
      length = 4
  )
  public final float height() {
    return height;
  }

  /**
   * Option 1 
   */
  @MavlinkMessageField(
      position = 5,
      length = 1
  )
  public final int option1() {
    return option1;
  }

  /**
   * Option 2 
   */
  @MavlinkMessageField(
      position = 6,
      length = 1
  )
  public final int option2() {
    return option2;
  }

  /**
   * Option 3 
   */
  @MavlinkMessageField(
      position = 7,
      length = 1
  )
  public final int option3() {
    return option3;
  }

  public class Builder {
    private int target;

    private float latitude;

    private float longitude;

    private float height;

    private int option1;

    private int option2;

    private int option3;

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
     * ISR Latitude 
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
     * ISR Longitude 
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
     * ISR Height 
     */
    @MavlinkMessageField(
        position = 4,
        length = 4
    )
    public final Builder height(float height) {
      this.height = height;
      return this;
    }

    /**
     * Option 1 
     */
    @MavlinkMessageField(
        position = 5,
        length = 1
    )
    public final Builder option1(int option1) {
      this.option1 = option1;
      return this;
    }

    /**
     * Option 2 
     */
    @MavlinkMessageField(
        position = 6,
        length = 1
    )
    public final Builder option2(int option2) {
      this.option2 = option2;
      return this;
    }

    /**
     * Option 3 
     */
    @MavlinkMessageField(
        position = 7,
        length = 1
    )
    public final Builder option3(int option3) {
      this.option3 = option3;
      return this;
    }

    public final IsrLocation build() {
      return new IsrLocation(target, latitude, longitude, height, option1, option2, option3);
    }
  }
}
