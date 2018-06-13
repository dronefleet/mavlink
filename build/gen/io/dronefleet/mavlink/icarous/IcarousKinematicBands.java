package io.dronefleet.mavlink.icarous;

import io.dronefleet.mavlink.annotations.MavlinkMessage;
import io.dronefleet.mavlink.annotations.MavlinkMessageField;

/**
 * Kinematic multi bands (track) output from Daidalus 
 */
@MavlinkMessage(
    id = 42001,
    crc = 239
)
public final class IcarousKinematicBands {
  private final int numbands;

  private final IcarousTrackBandTypes type1;

  private final float min1;

  private final float max1;

  private final IcarousTrackBandTypes type2;

  private final float min2;

  private final float max2;

  private final IcarousTrackBandTypes type3;

  private final float min3;

  private final float max3;

  private final IcarousTrackBandTypes type4;

  private final float min4;

  private final float max4;

  private final IcarousTrackBandTypes type5;

  private final float min5;

  private final float max5;

  private IcarousKinematicBands(int numbands, IcarousTrackBandTypes type1, float min1, float max1,
      IcarousTrackBandTypes type2, float min2, float max2, IcarousTrackBandTypes type3, float min3,
      float max3, IcarousTrackBandTypes type4, float min4, float max4, IcarousTrackBandTypes type5,
      float min5, float max5) {
    this.numbands = numbands;
    this.type1 = type1;
    this.min1 = min1;
    this.max1 = max1;
    this.type2 = type2;
    this.min2 = min2;
    this.max2 = max2;
    this.type3 = type3;
    this.min3 = min3;
    this.max3 = max3;
    this.type4 = type4;
    this.min4 = min4;
    this.max4 = max4;
    this.type5 = type5;
    this.min5 = min5;
    this.max5 = max5;
  }

  public static Builder builder() {
    return new Builder();
  }

  /**
   * Number of track bands 
   */
  @MavlinkMessageField(
      position = 1,
      length = 1
  )
  public final int numbands() {
    return numbands;
  }

  /**
   * See the TRACK_BAND_TYPES enum. 
   */
  @MavlinkMessageField(
      position = 2,
      length = 1
  )
  public final IcarousTrackBandTypes type1() {
    return type1;
  }

  /**
   * min angle (degrees) 
   */
  @MavlinkMessageField(
      position = 3,
      length = 4
  )
  public final float min1() {
    return min1;
  }

  /**
   * max angle (degrees) 
   */
  @MavlinkMessageField(
      position = 4,
      length = 4
  )
  public final float max1() {
    return max1;
  }

  /**
   * See the TRACK_BAND_TYPES enum. 
   */
  @MavlinkMessageField(
      position = 5,
      length = 1
  )
  public final IcarousTrackBandTypes type2() {
    return type2;
  }

  /**
   * min angle (degrees) 
   */
  @MavlinkMessageField(
      position = 6,
      length = 4
  )
  public final float min2() {
    return min2;
  }

  /**
   * max angle (degrees) 
   */
  @MavlinkMessageField(
      position = 7,
      length = 4
  )
  public final float max2() {
    return max2;
  }

  /**
   * See the TRACK_BAND_TYPES enum. 
   */
  @MavlinkMessageField(
      position = 8,
      length = 1
  )
  public final IcarousTrackBandTypes type3() {
    return type3;
  }

  /**
   * min angle (degrees) 
   */
  @MavlinkMessageField(
      position = 9,
      length = 4
  )
  public final float min3() {
    return min3;
  }

  /**
   * max angle (degrees) 
   */
  @MavlinkMessageField(
      position = 10,
      length = 4
  )
  public final float max3() {
    return max3;
  }

  /**
   * See the TRACK_BAND_TYPES enum. 
   */
  @MavlinkMessageField(
      position = 11,
      length = 1
  )
  public final IcarousTrackBandTypes type4() {
    return type4;
  }

  /**
   * min angle (degrees) 
   */
  @MavlinkMessageField(
      position = 12,
      length = 4
  )
  public final float min4() {
    return min4;
  }

  /**
   * max angle (degrees) 
   */
  @MavlinkMessageField(
      position = 13,
      length = 4
  )
  public final float max4() {
    return max4;
  }

  /**
   * See the TRACK_BAND_TYPES enum. 
   */
  @MavlinkMessageField(
      position = 14,
      length = 1
  )
  public final IcarousTrackBandTypes type5() {
    return type5;
  }

  /**
   * min angle (degrees) 
   */
  @MavlinkMessageField(
      position = 15,
      length = 4
  )
  public final float min5() {
    return min5;
  }

  /**
   * max angle (degrees) 
   */
  @MavlinkMessageField(
      position = 16,
      length = 4
  )
  public final float max5() {
    return max5;
  }

  public class Builder {
    private int numbands;

    private IcarousTrackBandTypes type1;

    private float min1;

    private float max1;

    private IcarousTrackBandTypes type2;

    private float min2;

    private float max2;

    private IcarousTrackBandTypes type3;

    private float min3;

    private float max3;

    private IcarousTrackBandTypes type4;

    private float min4;

    private float max4;

    private IcarousTrackBandTypes type5;

    private float min5;

    private float max5;

    private Builder() {
    }

    /**
     * Number of track bands 
     */
    @MavlinkMessageField(
        position = 1,
        length = 1
    )
    public final Builder numbands(int numbands) {
      this.numbands = numbands;
      return this;
    }

    /**
     * See the TRACK_BAND_TYPES enum. 
     */
    @MavlinkMessageField(
        position = 2,
        length = 1
    )
    public final Builder type1(IcarousTrackBandTypes type1) {
      this.type1 = type1;
      return this;
    }

    /**
     * min angle (degrees) 
     */
    @MavlinkMessageField(
        position = 3,
        length = 4
    )
    public final Builder min1(float min1) {
      this.min1 = min1;
      return this;
    }

    /**
     * max angle (degrees) 
     */
    @MavlinkMessageField(
        position = 4,
        length = 4
    )
    public final Builder max1(float max1) {
      this.max1 = max1;
      return this;
    }

    /**
     * See the TRACK_BAND_TYPES enum. 
     */
    @MavlinkMessageField(
        position = 5,
        length = 1
    )
    public final Builder type2(IcarousTrackBandTypes type2) {
      this.type2 = type2;
      return this;
    }

    /**
     * min angle (degrees) 
     */
    @MavlinkMessageField(
        position = 6,
        length = 4
    )
    public final Builder min2(float min2) {
      this.min2 = min2;
      return this;
    }

    /**
     * max angle (degrees) 
     */
    @MavlinkMessageField(
        position = 7,
        length = 4
    )
    public final Builder max2(float max2) {
      this.max2 = max2;
      return this;
    }

    /**
     * See the TRACK_BAND_TYPES enum. 
     */
    @MavlinkMessageField(
        position = 8,
        length = 1
    )
    public final Builder type3(IcarousTrackBandTypes type3) {
      this.type3 = type3;
      return this;
    }

    /**
     * min angle (degrees) 
     */
    @MavlinkMessageField(
        position = 9,
        length = 4
    )
    public final Builder min3(float min3) {
      this.min3 = min3;
      return this;
    }

    /**
     * max angle (degrees) 
     */
    @MavlinkMessageField(
        position = 10,
        length = 4
    )
    public final Builder max3(float max3) {
      this.max3 = max3;
      return this;
    }

    /**
     * See the TRACK_BAND_TYPES enum. 
     */
    @MavlinkMessageField(
        position = 11,
        length = 1
    )
    public final Builder type4(IcarousTrackBandTypes type4) {
      this.type4 = type4;
      return this;
    }

    /**
     * min angle (degrees) 
     */
    @MavlinkMessageField(
        position = 12,
        length = 4
    )
    public final Builder min4(float min4) {
      this.min4 = min4;
      return this;
    }

    /**
     * max angle (degrees) 
     */
    @MavlinkMessageField(
        position = 13,
        length = 4
    )
    public final Builder max4(float max4) {
      this.max4 = max4;
      return this;
    }

    /**
     * See the TRACK_BAND_TYPES enum. 
     */
    @MavlinkMessageField(
        position = 14,
        length = 1
    )
    public final Builder type5(IcarousTrackBandTypes type5) {
      this.type5 = type5;
      return this;
    }

    /**
     * min angle (degrees) 
     */
    @MavlinkMessageField(
        position = 15,
        length = 4
    )
    public final Builder min5(float min5) {
      this.min5 = min5;
      return this;
    }

    /**
     * max angle (degrees) 
     */
    @MavlinkMessageField(
        position = 16,
        length = 4
    )
    public final Builder max5(float max5) {
      this.max5 = max5;
      return this;
    }

    public final IcarousKinematicBands build() {
      return new IcarousKinematicBands(numbands, type1, min1, max1, type2, min2, max2, type3, min3, max3, type4, min4, max4, type5, min5, max5);
    }
  }
}
