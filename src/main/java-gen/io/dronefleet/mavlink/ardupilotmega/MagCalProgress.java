package io.dronefleet.mavlink.ardupilotmega;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import java.lang.Integer;
import java.lang.Override;
import java.lang.String;
import java.util.List;

/**
 * Reports progress of compass calibration. 
 */
@MavlinkMessageInfo(
    id = 191,
    crc = 92
)
public final class MagCalProgress {
  /**
   * Body frame direction vector for display 
   */
  private final float directionX;

  /**
   * Body frame direction vector for display 
   */
  private final float directionY;

  /**
   * Body frame direction vector for display 
   */
  private final float directionZ;

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
   * Attempt number 
   */
  private final int attempt;

  /**
   * Completion percentage 
   */
  private final int completionPct;

  /**
   * Bitmask of sphere sections (see http://en.wikipedia.org/wiki/Geodesic_grid) 
   */
  private final List<Integer> completionMask;

  private MagCalProgress(float directionX, float directionY, float directionZ, int compassId,
      int calMask, MagCalStatus calStatus, int attempt, int completionPct,
      List<Integer> completionMask) {
    this.directionX = directionX;
    this.directionY = directionY;
    this.directionZ = directionZ;
    this.compassId = compassId;
    this.calMask = calMask;
    this.calStatus = calStatus;
    this.attempt = attempt;
    this.completionPct = completionPct;
    this.completionMask = completionMask;
  }

  @MavlinkMessageBuilder
  public static Builder builder() {
    return new Builder();
  }

  @Override
  public String toString() {
    return "MagCalProgress{compassId=" + compassId
         + ", calMask=" + calMask
         + ", calStatus=" + calStatus
         + ", attempt=" + attempt
         + ", completionPct=" + completionPct
         + ", completionMask=" + completionMask
         + ", directionX=" + directionX
         + ", directionY=" + directionY
         + ", directionZ=" + directionZ + "}";
  }

  /**
   * Body frame direction vector for display 
   */
  @MavlinkFieldInfo(
      position = 7,
      unitSize = 4
  )
  public final float directionX() {
    return directionX;
  }

  /**
   * Body frame direction vector for display 
   */
  @MavlinkFieldInfo(
      position = 8,
      unitSize = 4
  )
  public final float directionY() {
    return directionY;
  }

  /**
   * Body frame direction vector for display 
   */
  @MavlinkFieldInfo(
      position = 9,
      unitSize = 4
  )
  public final float directionZ() {
    return directionZ;
  }

  /**
   * Compass being calibrated 
   */
  @MavlinkFieldInfo(
      position = 1,
      unitSize = 1
  )
  public final int compassId() {
    return compassId;
  }

  /**
   * Bitmask of compasses being calibrated 
   */
  @MavlinkFieldInfo(
      position = 2,
      unitSize = 1
  )
  public final int calMask() {
    return calMask;
  }

  /**
   * Status (see {@link io.dronefleet.mavlink.ardupilotmega.MagCalStatus MagCalStatus} enum) 
   */
  @MavlinkFieldInfo(
      position = 3,
      unitSize = 1
  )
  public final MagCalStatus calStatus() {
    return calStatus;
  }

  /**
   * Attempt number 
   */
  @MavlinkFieldInfo(
      position = 4,
      unitSize = 1
  )
  public final int attempt() {
    return attempt;
  }

  /**
   * Completion percentage 
   */
  @MavlinkFieldInfo(
      position = 5,
      unitSize = 1
  )
  public final int completionPct() {
    return completionPct;
  }

  /**
   * Bitmask of sphere sections (see http://en.wikipedia.org/wiki/Geodesic_grid) 
   */
  @MavlinkFieldInfo(
      position = 6,
      unitSize = 1,
      arraySize = 10
  )
  public final List<Integer> completionMask() {
    return completionMask;
  }

  public static class Builder {
    private float directionX;

    private float directionY;

    private float directionZ;

    private int compassId;

    private int calMask;

    private MagCalStatus calStatus;

    private int attempt;

    private int completionPct;

    private List<Integer> completionMask;

    private Builder() {
    }

    /**
     * Body frame direction vector for display 
     */
    @MavlinkFieldInfo(
        position = 7,
        unitSize = 4
    )
    public final Builder directionX(float directionX) {
      this.directionX = directionX;
      return this;
    }

    /**
     * Body frame direction vector for display 
     */
    @MavlinkFieldInfo(
        position = 8,
        unitSize = 4
    )
    public final Builder directionY(float directionY) {
      this.directionY = directionY;
      return this;
    }

    /**
     * Body frame direction vector for display 
     */
    @MavlinkFieldInfo(
        position = 9,
        unitSize = 4
    )
    public final Builder directionZ(float directionZ) {
      this.directionZ = directionZ;
      return this;
    }

    /**
     * Compass being calibrated 
     */
    @MavlinkFieldInfo(
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
    @MavlinkFieldInfo(
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
    @MavlinkFieldInfo(
        position = 3,
        unitSize = 1
    )
    public final Builder calStatus(MagCalStatus calStatus) {
      this.calStatus = calStatus;
      return this;
    }

    /**
     * Attempt number 
     */
    @MavlinkFieldInfo(
        position = 4,
        unitSize = 1
    )
    public final Builder attempt(int attempt) {
      this.attempt = attempt;
      return this;
    }

    /**
     * Completion percentage 
     */
    @MavlinkFieldInfo(
        position = 5,
        unitSize = 1
    )
    public final Builder completionPct(int completionPct) {
      this.completionPct = completionPct;
      return this;
    }

    /**
     * Bitmask of sphere sections (see http://en.wikipedia.org/wiki/Geodesic_grid) 
     */
    @MavlinkFieldInfo(
        position = 6,
        unitSize = 1,
        arraySize = 10
    )
    public final Builder completionMask(List<Integer> completionMask) {
      this.completionMask = completionMask;
      return this;
    }

    public final MagCalProgress build() {
      return new MagCalProgress(directionX, directionY, directionZ, compassId, calMask, calStatus, attempt, completionPct, completionMask);
    }
  }
}
