package io.dronefleet.mavlink.ardupilotmega;

import io.dronefleet.mavlink.annotations.MavlinkMessage;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageField;
import java.lang.Override;
import java.lang.String;

/**
 * Reports results of completed compass calibration. Sent until MAG_CAL_ACK received. 
 */
@MavlinkMessage(
    id = 192,
    crc = 36
)
public final class MagCalReport {
  /**
   * RMS milligauss residuals 
   */
  private final float fitness;

  /**
   * X offset 
   */
  private final float ofsX;

  /**
   * Y offset 
   */
  private final float ofsY;

  /**
   * Z offset 
   */
  private final float ofsZ;

  /**
   * X diagonal (matrix 11) 
   */
  private final float diagX;

  /**
   * Y diagonal (matrix 22) 
   */
  private final float diagY;

  /**
   * Z diagonal (matrix 33) 
   */
  private final float diagZ;

  /**
   * X off-diagonal (matrix 12 and 21) 
   */
  private final float offdiagX;

  /**
   * Y off-diagonal (matrix 13 and 31) 
   */
  private final float offdiagY;

  /**
   * Z off-diagonal (matrix 32 and 23) 
   */
  private final float offdiagZ;

  /**
   * Compass being calibrated 
   */
  private final int compassId;

  /**
   * Bitmask of compasses being calibrated 
   */
  private final int calMask;

  /**
   * Status (see {@link io.dronefleet.mavlink.ardupilotmega.MagCalStatus MagCalStatus} enum) 
   */
  private final MagCalStatus calStatus;

  /**
   * 0=requires a MAV_CMD_DO_ACCEPT_MAG_CAL, 1=saved to parameters 
   */
  private final int autosaved;

  private MagCalReport(float fitness, float ofsX, float ofsY, float ofsZ, float diagX, float diagY,
      float diagZ, float offdiagX, float offdiagY, float offdiagZ, int compassId, int calMask,
      MagCalStatus calStatus, int autosaved) {
    this.fitness = fitness;
    this.ofsX = ofsX;
    this.ofsY = ofsY;
    this.ofsZ = ofsZ;
    this.diagX = diagX;
    this.diagY = diagY;
    this.diagZ = diagZ;
    this.offdiagX = offdiagX;
    this.offdiagY = offdiagY;
    this.offdiagZ = offdiagZ;
    this.compassId = compassId;
    this.calMask = calMask;
    this.calStatus = calStatus;
    this.autosaved = autosaved;
  }

  @MavlinkMessageBuilder
  public static Builder builder() {
    return new Builder();
  }

  @Override
  public String toString() {
    return "MagCalReport{compassId=" + compassId
         + ", calMask=" + calMask
         + ", calStatus=" + calStatus
         + ", autosaved=" + autosaved
         + ", fitness=" + fitness
         + ", ofsX=" + ofsX
         + ", ofsY=" + ofsY
         + ", ofsZ=" + ofsZ
         + ", diagX=" + diagX
         + ", diagY=" + diagY
         + ", diagZ=" + diagZ
         + ", offdiagX=" + offdiagX
         + ", offdiagY=" + offdiagY
         + ", offdiagZ=" + offdiagZ + "}";
  }

  /**
   * RMS milligauss residuals 
   */
  @MavlinkMessageField(
      position = 5,
      unitSize = 4
  )
  public final float fitness() {
    return fitness;
  }

  /**
   * X offset 
   */
  @MavlinkMessageField(
      position = 6,
      unitSize = 4
  )
  public final float ofsX() {
    return ofsX;
  }

  /**
   * Y offset 
   */
  @MavlinkMessageField(
      position = 7,
      unitSize = 4
  )
  public final float ofsY() {
    return ofsY;
  }

  /**
   * Z offset 
   */
  @MavlinkMessageField(
      position = 8,
      unitSize = 4
  )
  public final float ofsZ() {
    return ofsZ;
  }

  /**
   * X diagonal (matrix 11) 
   */
  @MavlinkMessageField(
      position = 9,
      unitSize = 4
  )
  public final float diagX() {
    return diagX;
  }

  /**
   * Y diagonal (matrix 22) 
   */
  @MavlinkMessageField(
      position = 10,
      unitSize = 4
  )
  public final float diagY() {
    return diagY;
  }

  /**
   * Z diagonal (matrix 33) 
   */
  @MavlinkMessageField(
      position = 11,
      unitSize = 4
  )
  public final float diagZ() {
    return diagZ;
  }

  /**
   * X off-diagonal (matrix 12 and 21) 
   */
  @MavlinkMessageField(
      position = 12,
      unitSize = 4
  )
  public final float offdiagX() {
    return offdiagX;
  }

  /**
   * Y off-diagonal (matrix 13 and 31) 
   */
  @MavlinkMessageField(
      position = 13,
      unitSize = 4
  )
  public final float offdiagY() {
    return offdiagY;
  }

  /**
   * Z off-diagonal (matrix 32 and 23) 
   */
  @MavlinkMessageField(
      position = 14,
      unitSize = 4
  )
  public final float offdiagZ() {
    return offdiagZ;
  }

  /**
   * Compass being calibrated 
   */
  @MavlinkMessageField(
      position = 1,
      unitSize = 1
  )
  public final int compassId() {
    return compassId;
  }

  /**
   * Bitmask of compasses being calibrated 
   */
  @MavlinkMessageField(
      position = 2,
      unitSize = 1
  )
  public final int calMask() {
    return calMask;
  }

  /**
   * Status (see {@link io.dronefleet.mavlink.ardupilotmega.MagCalStatus MagCalStatus} enum) 
   */
  @MavlinkMessageField(
      position = 3,
      unitSize = 1
  )
  public final MagCalStatus calStatus() {
    return calStatus;
  }

  /**
   * 0=requires a MAV_CMD_DO_ACCEPT_MAG_CAL, 1=saved to parameters 
   */
  @MavlinkMessageField(
      position = 4,
      unitSize = 1
  )
  public final int autosaved() {
    return autosaved;
  }

  public static class Builder {
    private float fitness;

    private float ofsX;

    private float ofsY;

    private float ofsZ;

    private float diagX;

    private float diagY;

    private float diagZ;

    private float offdiagX;

    private float offdiagY;

    private float offdiagZ;

    private int compassId;

    private int calMask;

    private MagCalStatus calStatus;

    private int autosaved;

    private Builder() {
    }

    /**
     * RMS milligauss residuals 
     */
    @MavlinkMessageField(
        position = 5,
        unitSize = 4
    )
    public final Builder fitness(float fitness) {
      this.fitness = fitness;
      return this;
    }

    /**
     * X offset 
     */
    @MavlinkMessageField(
        position = 6,
        unitSize = 4
    )
    public final Builder ofsX(float ofsX) {
      this.ofsX = ofsX;
      return this;
    }

    /**
     * Y offset 
     */
    @MavlinkMessageField(
        position = 7,
        unitSize = 4
    )
    public final Builder ofsY(float ofsY) {
      this.ofsY = ofsY;
      return this;
    }

    /**
     * Z offset 
     */
    @MavlinkMessageField(
        position = 8,
        unitSize = 4
    )
    public final Builder ofsZ(float ofsZ) {
      this.ofsZ = ofsZ;
      return this;
    }

    /**
     * X diagonal (matrix 11) 
     */
    @MavlinkMessageField(
        position = 9,
        unitSize = 4
    )
    public final Builder diagX(float diagX) {
      this.diagX = diagX;
      return this;
    }

    /**
     * Y diagonal (matrix 22) 
     */
    @MavlinkMessageField(
        position = 10,
        unitSize = 4
    )
    public final Builder diagY(float diagY) {
      this.diagY = diagY;
      return this;
    }

    /**
     * Z diagonal (matrix 33) 
     */
    @MavlinkMessageField(
        position = 11,
        unitSize = 4
    )
    public final Builder diagZ(float diagZ) {
      this.diagZ = diagZ;
      return this;
    }

    /**
     * X off-diagonal (matrix 12 and 21) 
     */
    @MavlinkMessageField(
        position = 12,
        unitSize = 4
    )
    public final Builder offdiagX(float offdiagX) {
      this.offdiagX = offdiagX;
      return this;
    }

    /**
     * Y off-diagonal (matrix 13 and 31) 
     */
    @MavlinkMessageField(
        position = 13,
        unitSize = 4
    )
    public final Builder offdiagY(float offdiagY) {
      this.offdiagY = offdiagY;
      return this;
    }

    /**
     * Z off-diagonal (matrix 32 and 23) 
     */
    @MavlinkMessageField(
        position = 14,
        unitSize = 4
    )
    public final Builder offdiagZ(float offdiagZ) {
      this.offdiagZ = offdiagZ;
      return this;
    }

    /**
     * Compass being calibrated 
     */
    @MavlinkMessageField(
        position = 1,
        unitSize = 1
    )
    public final Builder compassId(int compassId) {
      this.compassId = compassId;
      return this;
    }

    /**
     * Bitmask of compasses being calibrated 
     */
    @MavlinkMessageField(
        position = 2,
        unitSize = 1
    )
    public final Builder calMask(int calMask) {
      this.calMask = calMask;
      return this;
    }

    /**
     * Status (see {@link io.dronefleet.mavlink.ardupilotmega.MagCalStatus MagCalStatus} enum) 
     */
    @MavlinkMessageField(
        position = 3,
        unitSize = 1
    )
    public final Builder calStatus(MagCalStatus calStatus) {
      this.calStatus = calStatus;
      return this;
    }

    /**
     * 0=requires a MAV_CMD_DO_ACCEPT_MAG_CAL, 1=saved to parameters 
     */
    @MavlinkMessageField(
        position = 4,
        unitSize = 1
    )
    public final Builder autosaved(int autosaved) {
      this.autosaved = autosaved;
      return this;
    }

    public final MagCalReport build() {
      return new MagCalReport(fitness, ofsX, ofsY, ofsZ, diagX, diagY, diagZ, offdiagX, offdiagY, offdiagZ, compassId, calMask, calStatus, autosaved);
    }
  }
}
