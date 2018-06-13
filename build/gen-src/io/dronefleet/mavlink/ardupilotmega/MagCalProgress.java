package io.dronefleet.mavlink.ardupilotmega;

import io.dronefleet.mavlink.annotations.MavlinkMessage;
import io.dronefleet.mavlink.annotations.MavlinkMessageField;
import java.lang.Integer;
import java.util.List;

/**
 * Reports progress of compass calibration. 
 */
@MavlinkMessage(
    id = 191,
    crc = 92
)
public final class MagCalProgress {
  private final int compassId;

  private final int calMask;

  private final MagCalStatus calStatus;

  private final int attempt;

  private final int completionPct;

  private final List<Integer> completionMask;

  private final float directionX;

  private final float directionY;

  private final float directionZ;

  private MagCalProgress(int compassId, int calMask, MagCalStatus calStatus, int attempt,
      int completionPct, List<Integer> completionMask, float directionX, float directionY,
      float directionZ) {
    this.compassId = compassId;
    this.calMask = calMask;
    this.calStatus = calStatus;
    this.attempt = attempt;
    this.completionPct = completionPct;
    this.completionMask = completionMask;
    this.directionX = directionX;
    this.directionY = directionY;
    this.directionZ = directionZ;
  }

  public static Builder builder() {
    return new Builder();
  }

  /**
   * Compass being calibrated 
   */
  @MavlinkMessageField(
      position = 1,
      length = 1
  )
  public final int compassId() {
    return compassId;
  }

  /**
   * Bitmask of compasses being calibrated 
   */
  @MavlinkMessageField(
      position = 2,
      length = 1
  )
  public final int calMask() {
    return calMask;
  }

  /**
   * Status (see MAG_CAL_STATUS enum) 
   */
  @MavlinkMessageField(
      position = 3,
      length = 1
  )
  public final MagCalStatus calStatus() {
    return calStatus;
  }

  /**
   * Attempt number 
   */
  @MavlinkMessageField(
      position = 4,
      length = 1
  )
  public final int attempt() {
    return attempt;
  }

  /**
   * Completion percentage 
   */
  @MavlinkMessageField(
      position = 5,
      length = 1
  )
  public final int completionPct() {
    return completionPct;
  }

  /**
   * Bitmask of sphere sections (see http://en.wikipedia.org/wiki/Geodesic_grid) 
   */
  @MavlinkMessageField(
      position = 6,
      length = 1,
      arraySize = 10
  )
  public final List<Integer> completionMask() {
    return completionMask;
  }

  /**
   * Body frame direction vector for display 
   */
  @MavlinkMessageField(
      position = 7,
      length = 4
  )
  public final float directionX() {
    return directionX;
  }

  /**
   * Body frame direction vector for display 
   */
  @MavlinkMessageField(
      position = 8,
      length = 4
  )
  public final float directionY() {
    return directionY;
  }

  /**
   * Body frame direction vector for display 
   */
  @MavlinkMessageField(
      position = 9,
      length = 4
  )
  public final float directionZ() {
    return directionZ;
  }

  public class Builder {
    private int compassId;

    private int calMask;

    private MagCalStatus calStatus;

    private int attempt;

    private int completionPct;

    private List<Integer> completionMask;

    private float directionX;

    private float directionY;

    private float directionZ;

    private Builder() {
    }

    /**
     * Compass being calibrated 
     */
    @MavlinkMessageField(
        position = 1,
        length = 1
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
        length = 1
    )
    public final Builder calMask(int calMask) {
      this.calMask = calMask;
      return this;
    }

    /**
     * Status (see MAG_CAL_STATUS enum) 
     */
    @MavlinkMessageField(
        position = 3,
        length = 1
    )
    public final Builder calStatus(MagCalStatus calStatus) {
      this.calStatus = calStatus;
      return this;
    }

    /**
     * Attempt number 
     */
    @MavlinkMessageField(
        position = 4,
        length = 1
    )
    public final Builder attempt(int attempt) {
      this.attempt = attempt;
      return this;
    }

    /**
     * Completion percentage 
     */
    @MavlinkMessageField(
        position = 5,
        length = 1
    )
    public final Builder completionPct(int completionPct) {
      this.completionPct = completionPct;
      return this;
    }

    /**
     * Bitmask of sphere sections (see http://en.wikipedia.org/wiki/Geodesic_grid) 
     */
    @MavlinkMessageField(
        position = 6,
        length = 1,
        arraySize = 10
    )
    public final Builder completionMask(List<Integer> completionMask) {
      this.completionMask = completionMask;
      return this;
    }

    /**
     * Body frame direction vector for display 
     */
    @MavlinkMessageField(
        position = 7,
        length = 4
    )
    public final Builder directionX(float directionX) {
      this.directionX = directionX;
      return this;
    }

    /**
     * Body frame direction vector for display 
     */
    @MavlinkMessageField(
        position = 8,
        length = 4
    )
    public final Builder directionY(float directionY) {
      this.directionY = directionY;
      return this;
    }

    /**
     * Body frame direction vector for display 
     */
    @MavlinkMessageField(
        position = 9,
        length = 4
    )
    public final Builder directionZ(float directionZ) {
      this.directionZ = directionZ;
      return this;
    }

    public final MagCalProgress build() {
      return new MagCalProgress(compassId, calMask, calStatus, attempt, completionPct, completionMask, directionX, directionY, directionZ);
    }
  }
}
