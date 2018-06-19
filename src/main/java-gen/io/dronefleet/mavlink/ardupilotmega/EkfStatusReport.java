package io.dronefleet.mavlink.ardupilotmega;

import io.dronefleet.mavlink.annotations.MavlinkMessage;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageField;
import java.lang.Override;
import java.lang.String;

/**
 * EKF Status message including flags and variances 
 */
@MavlinkMessage(
    id = 193,
    crc = 71
)
public final class EkfStatusReport {
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
   * Flags 
   */
  private final EkfStatusFlags flags;

  /**
   * Airspeed variance 
   */
  private final float airspeedVariance;

  private EkfStatusReport(float velocityVariance, float posHorizVariance, float posVertVariance,
      float compassVariance, float terrainAltVariance, EkfStatusFlags flags,
      float airspeedVariance) {
    this.velocityVariance = velocityVariance;
    this.posHorizVariance = posHorizVariance;
    this.posVertVariance = posVertVariance;
    this.compassVariance = compassVariance;
    this.terrainAltVariance = terrainAltVariance;
    this.flags = flags;
    this.airspeedVariance = airspeedVariance;
  }

  @MavlinkMessageBuilder
  public static Builder builder() {
    return new Builder();
  }

  @Override
  public String toString() {
    return "EkfStatusReport{flags=" + flags
         + ", velocityVariance=" + velocityVariance
         + ", posHorizVariance=" + posHorizVariance
         + ", posVertVariance=" + posVertVariance
         + ", compassVariance=" + compassVariance
         + ", terrainAltVariance=" + terrainAltVariance
         + ", airspeedVariance=" + airspeedVariance + "}";
  }

  /**
   * Velocity variance 
   */
  @MavlinkMessageField(
      position = 2,
      unitSize = 4
  )
  public final float velocityVariance() {
    return velocityVariance;
  }

  /**
   * Horizontal Position variance 
   */
  @MavlinkMessageField(
      position = 3,
      unitSize = 4
  )
  public final float posHorizVariance() {
    return posHorizVariance;
  }

  /**
   * Vertical Position variance 
   */
  @MavlinkMessageField(
      position = 4,
      unitSize = 4
  )
  public final float posVertVariance() {
    return posVertVariance;
  }

  /**
   * Compass variance 
   */
  @MavlinkMessageField(
      position = 5,
      unitSize = 4
  )
  public final float compassVariance() {
    return compassVariance;
  }

  /**
   * Terrain Altitude variance 
   */
  @MavlinkMessageField(
      position = 6,
      unitSize = 4
  )
  public final float terrainAltVariance() {
    return terrainAltVariance;
  }

  /**
   * Flags 
   */
  @MavlinkMessageField(
      position = 1,
      unitSize = 2
  )
  public final EkfStatusFlags flags() {
    return flags;
  }

  /**
   * Airspeed variance 
   */
  @MavlinkMessageField(
      position = 8,
      unitSize = 4,
      extension = true
  )
  public final float airspeedVariance() {
    return airspeedVariance;
  }

  public static class Builder {
    private float velocityVariance;

    private float posHorizVariance;

    private float posVertVariance;

    private float compassVariance;

    private float terrainAltVariance;

    private EkfStatusFlags flags;

    private float airspeedVariance;

    private Builder() {
    }

    /**
     * Velocity variance 
     */
    @MavlinkMessageField(
        position = 2,
        unitSize = 4
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
        unitSize = 4
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
        unitSize = 4
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
        unitSize = 4
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
        unitSize = 4
    )
    public final Builder terrainAltVariance(float terrainAltVariance) {
      this.terrainAltVariance = terrainAltVariance;
      return this;
    }

    /**
     * Flags 
     */
    @MavlinkMessageField(
        position = 1,
        unitSize = 2
    )
    public final Builder flags(EkfStatusFlags flags) {
      this.flags = flags;
      return this;
    }

    /**
     * Airspeed variance 
     */
    @MavlinkMessageField(
        position = 8,
        unitSize = 4,
        extension = true
    )
    public final Builder airspeedVariance(float airspeedVariance) {
      this.airspeedVariance = airspeedVariance;
      return this;
    }

    public final EkfStatusReport build() {
      return new EkfStatusReport(velocityVariance, posHorizVariance, posVertVariance, compassVariance, terrainAltVariance, flags, airspeedVariance);
    }
  }
}
