package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import java.lang.Override;
import java.lang.String;
import java.math.BigInteger;

/**
 * null
 */
@MavlinkMessageInfo(
    id = 231,
    crc = 105
)
public final class WindCov {
  /**
   * Timestamp (micros since boot or Unix epoch) 
   */
  private final BigInteger timeUsec;

  /**
   * Wind in X (NED) direction in m/s 
   */
  private final float windX;

  /**
   * Wind in Y (NED) direction in m/s 
   */
  private final float windY;

  /**
   * Wind in Z (NED) direction in m/s 
   */
  private final float windZ;

  /**
   * Variability of the wind in XY. RMS of a 1 Hz lowpassed wind estimate. 
   */
  private final float varHoriz;

  /**
   * Variability of the wind in Z. RMS of a 1 Hz lowpassed wind estimate. 
   */
  private final float varVert;

  /**
   * AMSL altitude (m) this measurement was taken at 
   */
  private final float windAlt;

  /**
   * Horizontal speed 1-STD accuracy 
   */
  private final float horizAccuracy;

  /**
   * Vertical speed 1-STD accuracy 
   */
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

  @MavlinkMessageBuilder
  public static Builder builder() {
    return new Builder();
  }

  @Override
  public String toString() {
    return "WindCov{timeUsec=" + timeUsec
         + ", windX=" + windX
         + ", windY=" + windY
         + ", windZ=" + windZ
         + ", varHoriz=" + varHoriz
         + ", varVert=" + varVert
         + ", windAlt=" + windAlt
         + ", horizAccuracy=" + horizAccuracy
         + ", vertAccuracy=" + vertAccuracy + "}";
  }

  /**
   * Timestamp (micros since boot or Unix epoch) 
   */
  @MavlinkFieldInfo(
      position = 0,
      unitSize = 8
  )
  public final BigInteger timeUsec() {
    return timeUsec;
  }

  /**
   * Wind in X (NED) direction in m/s 
   */
  @MavlinkFieldInfo(
      position = 1,
      unitSize = 4
  )
  public final float windX() {
    return windX;
  }

  /**
   * Wind in Y (NED) direction in m/s 
   */
  @MavlinkFieldInfo(
      position = 2,
      unitSize = 4
  )
  public final float windY() {
    return windY;
  }

  /**
   * Wind in Z (NED) direction in m/s 
   */
  @MavlinkFieldInfo(
      position = 3,
      unitSize = 4
  )
  public final float windZ() {
    return windZ;
  }

  /**
   * Variability of the wind in XY. RMS of a 1 Hz lowpassed wind estimate. 
   */
  @MavlinkFieldInfo(
      position = 4,
      unitSize = 4
  )
  public final float varHoriz() {
    return varHoriz;
  }

  /**
   * Variability of the wind in Z. RMS of a 1 Hz lowpassed wind estimate. 
   */
  @MavlinkFieldInfo(
      position = 5,
      unitSize = 4
  )
  public final float varVert() {
    return varVert;
  }

  /**
   * AMSL altitude (m) this measurement was taken at 
   */
  @MavlinkFieldInfo(
      position = 6,
      unitSize = 4
  )
  public final float windAlt() {
    return windAlt;
  }

  /**
   * Horizontal speed 1-STD accuracy 
   */
  @MavlinkFieldInfo(
      position = 7,
      unitSize = 4
  )
  public final float horizAccuracy() {
    return horizAccuracy;
  }

  /**
   * Vertical speed 1-STD accuracy 
   */
  @MavlinkFieldInfo(
      position = 8,
      unitSize = 4
  )
  public final float vertAccuracy() {
    return vertAccuracy;
  }

  public static class Builder {
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
    @MavlinkFieldInfo(
        position = 0,
        unitSize = 8
    )
    public final Builder timeUsec(BigInteger timeUsec) {
      this.timeUsec = timeUsec;
      return this;
    }

    /**
     * Wind in X (NED) direction in m/s 
     */
    @MavlinkFieldInfo(
        position = 1,
        unitSize = 4
    )
    public final Builder windX(float windX) {
      this.windX = windX;
      return this;
    }

    /**
     * Wind in Y (NED) direction in m/s 
     */
    @MavlinkFieldInfo(
        position = 2,
        unitSize = 4
    )
    public final Builder windY(float windY) {
      this.windY = windY;
      return this;
    }

    /**
     * Wind in Z (NED) direction in m/s 
     */
    @MavlinkFieldInfo(
        position = 3,
        unitSize = 4
    )
    public final Builder windZ(float windZ) {
      this.windZ = windZ;
      return this;
    }

    /**
     * Variability of the wind in XY. RMS of a 1 Hz lowpassed wind estimate. 
     */
    @MavlinkFieldInfo(
        position = 4,
        unitSize = 4
    )
    public final Builder varHoriz(float varHoriz) {
      this.varHoriz = varHoriz;
      return this;
    }

    /**
     * Variability of the wind in Z. RMS of a 1 Hz lowpassed wind estimate. 
     */
    @MavlinkFieldInfo(
        position = 5,
        unitSize = 4
    )
    public final Builder varVert(float varVert) {
      this.varVert = varVert;
      return this;
    }

    /**
     * AMSL altitude (m) this measurement was taken at 
     */
    @MavlinkFieldInfo(
        position = 6,
        unitSize = 4
    )
    public final Builder windAlt(float windAlt) {
      this.windAlt = windAlt;
      return this;
    }

    /**
     * Horizontal speed 1-STD accuracy 
     */
    @MavlinkFieldInfo(
        position = 7,
        unitSize = 4
    )
    public final Builder horizAccuracy(float horizAccuracy) {
      this.horizAccuracy = horizAccuracy;
      return this;
    }

    /**
     * Vertical speed 1-STD accuracy 
     */
    @MavlinkFieldInfo(
        position = 8,
        unitSize = 4
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
