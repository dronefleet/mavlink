package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkMessage;
import io.dronefleet.mavlink.annotations.MavlinkMessageField;
import java.math.BigInteger;

/**
 * null
 */
@MavlinkMessage(
    id = 231,
    crc = 105
)
public final class WindCov {
  private final BigInteger timeUsec;

  private final float windX;

  private final float windY;

  private final float windZ;

  private final float varHoriz;

  private final float varVert;

  private final float windAlt;

  private final float horizAccuracy;

  private final float vertAccuracy;

  private WindCov(BigInteger timeUsec, float windX, float windY, float windZ, float varHoriz,
      float varVert, float windAlt, float horizAccuracy, float vertAccuracy) {
    this.timeUsec = timeUsec;
    this.windX = windX;
    this.windY = windY;
    this.windZ = windZ;
    this.varHoriz = varHoriz;
    this.varVert = varVert;
    this.windAlt = windAlt;
    this.horizAccuracy = horizAccuracy;
    this.vertAccuracy = vertAccuracy;
  }

  public static Builder builder() {
    return new Builder();
  }

  /**
   * Timestamp (micros since boot or Unix epoch) 
   */
  @MavlinkMessageField(
      position = 0,
      length = 8
  )
  public final BigInteger timeUsec() {
    return timeUsec;
  }

  /**
   * Wind in X (NED) direction in m/s 
   */
  @MavlinkMessageField(
      position = 1,
      length = 4
  )
  public final float windX() {
    return windX;
  }

  /**
   * Wind in Y (NED) direction in m/s 
   */
  @MavlinkMessageField(
      position = 2,
      length = 4
  )
  public final float windY() {
    return windY;
  }

  /**
   * Wind in Z (NED) direction in m/s 
   */
  @MavlinkMessageField(
      position = 3,
      length = 4
  )
  public final float windZ() {
    return windZ;
  }

  /**
   * Variability of the wind in XY. RMS of a 1 Hz lowpassed wind estimate. 
   */
  @MavlinkMessageField(
      position = 4,
      length = 4
  )
  public final float varHoriz() {
    return varHoriz;
  }

  /**
   * Variability of the wind in Z. RMS of a 1 Hz lowpassed wind estimate. 
   */
  @MavlinkMessageField(
      position = 5,
      length = 4
  )
  public final float varVert() {
    return varVert;
  }

  /**
   * AMSL altitude (m) this measurement was taken at 
   */
  @MavlinkMessageField(
      position = 6,
      length = 4
  )
  public final float windAlt() {
    return windAlt;
  }

  /**
   * Horizontal speed 1-STD accuracy 
   */
  @MavlinkMessageField(
      position = 7,
      length = 4
  )
  public final float horizAccuracy() {
    return horizAccuracy;
  }

  /**
   * Vertical speed 1-STD accuracy 
   */
  @MavlinkMessageField(
      position = 8,
      length = 4
  )
  public final float vertAccuracy() {
    return vertAccuracy;
  }

  public class Builder {
    private BigInteger timeUsec;

    private float windX;

    private float windY;

    private float windZ;

    private float varHoriz;

    private float varVert;

    private float windAlt;

    private float horizAccuracy;

    private float vertAccuracy;

    private Builder() {
    }

    /**
     * Timestamp (micros since boot or Unix epoch) 
     */
    @MavlinkMessageField(
        position = 0,
        length = 8
    )
    public final Builder timeUsec(BigInteger timeUsec) {
      this.timeUsec = timeUsec;
      return this;
    }

    /**
     * Wind in X (NED) direction in m/s 
     */
    @MavlinkMessageField(
        position = 1,
        length = 4
    )
    public final Builder windX(float windX) {
      this.windX = windX;
      return this;
    }

    /**
     * Wind in Y (NED) direction in m/s 
     */
    @MavlinkMessageField(
        position = 2,
        length = 4
    )
    public final Builder windY(float windY) {
      this.windY = windY;
      return this;
    }

    /**
     * Wind in Z (NED) direction in m/s 
     */
    @MavlinkMessageField(
        position = 3,
        length = 4
    )
    public final Builder windZ(float windZ) {
      this.windZ = windZ;
      return this;
    }

    /**
     * Variability of the wind in XY. RMS of a 1 Hz lowpassed wind estimate. 
     */
    @MavlinkMessageField(
        position = 4,
        length = 4
    )
    public final Builder varHoriz(float varHoriz) {
      this.varHoriz = varHoriz;
      return this;
    }

    /**
     * Variability of the wind in Z. RMS of a 1 Hz lowpassed wind estimate. 
     */
    @MavlinkMessageField(
        position = 5,
        length = 4
    )
    public final Builder varVert(float varVert) {
      this.varVert = varVert;
      return this;
    }

    /**
     * AMSL altitude (m) this measurement was taken at 
     */
    @MavlinkMessageField(
        position = 6,
        length = 4
    )
    public final Builder windAlt(float windAlt) {
      this.windAlt = windAlt;
      return this;
    }

    /**
     * Horizontal speed 1-STD accuracy 
     */
    @MavlinkMessageField(
        position = 7,
        length = 4
    )
    public final Builder horizAccuracy(float horizAccuracy) {
      this.horizAccuracy = horizAccuracy;
      return this;
    }

    /**
     * Vertical speed 1-STD accuracy 
     */
    @MavlinkMessageField(
        position = 8,
        length = 4
    )
    public final Builder vertAccuracy(float vertAccuracy) {
      this.vertAccuracy = vertAccuracy;
      return this;
    }

    public final WindCov build() {
      return new WindCov(timeUsec, windX, windY, windZ, varHoriz, varVert, windAlt, horizAccuracy, vertAccuracy);
    }
  }
}
