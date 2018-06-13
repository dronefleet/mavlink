package io.dronefleet.mavlink.ardupilotmega;

import io.dronefleet.mavlink.annotations.MavlinkMessage;
import io.dronefleet.mavlink.annotations.MavlinkMessageField;

/**
 * EKF Status message including flags and variances 
 */
@MavlinkMessage(
    id = 193,
    crc = 71
)
public final class EkfStatusReport {
  /**
   * Flags 
   */
  private final EkfStatusFlags flags;

  /**
   * Velocity variance 
   */
  private final float velocityVariance;

  /**
   * Horizontal Position variance 
   */
  private final float posHorizVariance;

  /**
   * Vertical Position variance 
   */
  private final float posVertVariance;

  /**
   * Compass variance 
   */
  private final float compassVariance;

  /**
   * Terrain Altitude variance 
   */
  private final float terrainAltVariance;

  /**
   * Airspeed variance 
   */
  private final float airspeedVariance;

  private EkfStatusReport(EkfStatusFlags flags, float velocityVariance, float posHorizVariance,
      float posVertVariance, float compassVariance, float terrainAltVariance,
      float airspeedVariance) {
    this.flags = flags;
    this.velocityVariance = velocityVariance;
    this.posHorizVariance = posHorizVariance;
    this.posVertVariance = posVertVariance;
    this.compassVariance = compassVariance;
    this.terrainAltVariance = terrainAltVariance;
    this.airspeedVariance = airspeedVariance;
  }

  public static Builder builder() {
    return new Builder();
  }

  /**
   * Flags 
   */
  @MavlinkMessageField(
      position = 1,
      length = 2
  )
  public final EkfStatusFlags flags() {
    return flags;
  }

  /**
   * Velocity variance 
   */
  @MavlinkMessageField(
      position = 2,
      length = 4
  )
  public final float velocityVariance() {
    return velocityVariance;
  }

  /**
   * Horizontal Position variance 
   */
  @MavlinkMessageField(
      position = 3,
      length = 4
  )
  public final float posHorizVariance() {
    return posHorizVariance;
  }

  /**
   * Vertical Position variance 
   */
  @MavlinkMessageField(
      position = 4,
      length = 4
  )
  public final float posVertVariance() {
    return posVertVariance;
  }

  /**
   * Compass variance 
   */
  @MavlinkMessageField(
      position = 5,
      length = 4
  )
  public final float compassVariance() {
    return compassVariance;
  }

  /**
   * Terrain Altitude variance 
   */
  @MavlinkMessageField(
      position = 6,
      length = 4
  )
  public final float terrainAltVariance() {
    return terrainAltVariance;
  }

  /**
   * Airspeed variance 
   */
  @MavlinkMessageField(
      position = 8,
      length = 4,
      extension = true
  )
  public final float airspeedVariance() {
    return airspeedVariance;
  }

  public static class Builder {
    private EkfStatusFlags flags;

    private float velocityVariance;

    private float posHorizVariance;

    private float posVertVariance;

    private float compassVariance;

    private float terrainAltVariance;

    private float airspeedVariance;

    private Builder() {
    }

    /**
     * Flags 
     */
    @MavlinkMessageField(
        position = 1,
        length = 2
    )
    public final Builder flags(EkfStatusFlags flags) {
      this.flags = flags;
      return this;
    }

    /**
     * Velocity variance 
     */
    @MavlinkMessageField(
        position = 2,
        length = 4
    )
    public final Builder velocityVariance(float velocityVariance) {
      this.velocityVariance = velocityVariance;
      return this;
    }

    /**
     * Horizontal Position variance 
     */
    @MavlinkMessageField(
        position = 3,
        length = 4
    )
    public final Builder posHorizVariance(float posHorizVariance) {
      this.posHorizVariance = posHorizVariance;
      return this;
    }

    /**
     * Vertical Position variance 
     */
    @MavlinkMessageField(
        position = 4,
        length = 4
    )
    public final Builder posVertVariance(float posVertVariance) {
      this.posVertVariance = posVertVariance;
      return this;
    }

    /**
     * Compass variance 
     */
    @MavlinkMessageField(
        position = 5,
        length = 4
    )
    public final Builder compassVariance(float compassVariance) {
      this.compassVariance = compassVariance;
      return this;
    }

    /**
     * Terrain Altitude variance 
     */
    @MavlinkMessageField(
        position = 6,
        length = 4
    )
    public final Builder terrainAltVariance(float terrainAltVariance) {
      this.terrainAltVariance = terrainAltVariance;
      return this;
    }

    /**
     * Airspeed variance 
     */
    @MavlinkMessageField(
        position = 8,
        length = 4,
        extension = true
    )
    public final Builder airspeedVariance(float airspeedVariance) {
      this.airspeedVariance = airspeedVariance;
      return this;
    }

    public final EkfStatusReport build() {
      return new EkfStatusReport(flags, velocityVariance, posHorizVariance, posVertVariance, compassVariance, terrainAltVariance, airspeedVariance);
    }
  }
}
