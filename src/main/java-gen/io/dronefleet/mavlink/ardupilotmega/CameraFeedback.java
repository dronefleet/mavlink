package io.dronefleet.mavlink.ardupilotmega;

import io.dronefleet.mavlink.annotations.MavlinkMessage;
import io.dronefleet.mavlink.annotations.MavlinkMessageField;
import java.math.BigInteger;

/**
 * Camera Capture Feedback 
 */
@MavlinkMessage(
    id = 180,
    crc = 52
)
public final class CameraFeedback {
  /**
   * Image timestamp (microseconds since UNIX epoch), as passed in by {@link io.dronefleet.mavlink.ardupilotmega.CameraStatus CameraStatus} message (or 
   * autopilot if no CCB) 
   */
  private final BigInteger timeUsec;

  /**
   * System ID 
   */
  private final int targetSystem;

  /**
   * Camera ID 
   */
  private final int camIdx;

  /**
   * Image index 
   */
  private final int imgIdx;

  /**
   * Latitude in (deg * 1E7) 
   */
  private final int lat;

  /**
   * Longitude in (deg * 1E7) 
   */
  private final int lng;

  /**
   * Altitude Absolute (meters AMSL) 
   */
  private final float altMsl;

  /**
   * Altitude Relative (meters above HOME location) 
   */
  private final float altRel;

  /**
   * Camera Roll angle (earth frame, degrees, +-180) 
   */
  private final float roll;

  /**
   * Camera Pitch angle (earth frame, degrees, +-180) 
   */
  private final float pitch;

  /**
   * Camera Yaw (earth frame, degrees, 0-360, true) 
   */
  private final float yaw;

  /**
   * Focal Length (mm) 
   */
  private final float focLen;

  /**
   * See {@link io.dronefleet.mavlink.ardupilotmega.CameraFeedbackFlags CameraFeedbackFlags} enum for definition of the bitmask 
   */
  private final CameraFeedbackFlags flags;

  /**
   * Completed image captures 
   */
  private final int completedCaptures;

  private CameraFeedback(BigInteger timeUsec, int targetSystem, int camIdx, int imgIdx, int lat,
      int lng, float altMsl, float altRel, float roll, float pitch, float yaw, float focLen,
      CameraFeedbackFlags flags, int completedCaptures) {
    this.timeUsec = timeUsec;
    this.targetSystem = targetSystem;
    this.camIdx = camIdx;
    this.imgIdx = imgIdx;
    this.lat = lat;
    this.lng = lng;
    this.altMsl = altMsl;
    this.altRel = altRel;
    this.roll = roll;
    this.pitch = pitch;
    this.yaw = yaw;
    this.focLen = focLen;
    this.flags = flags;
    this.completedCaptures = completedCaptures;
  }

  public static Builder builder() {
    return new Builder();
  }

  /**
   * Image timestamp (microseconds since UNIX epoch), as passed in by {@link io.dronefleet.mavlink.ardupilotmega.CameraStatus CameraStatus} message (or 
   * autopilot if no CCB) 
   */
  @MavlinkMessageField(
      position = 1,
      length = 8
  )
  public final BigInteger timeUsec() {
    return timeUsec;
  }

  /**
   * System ID 
   */
  @MavlinkMessageField(
      position = 2,
      length = 1
  )
  public final int targetSystem() {
    return targetSystem;
  }

  /**
   * Camera ID 
   */
  @MavlinkMessageField(
      position = 3,
      length = 1
  )
  public final int camIdx() {
    return camIdx;
  }

  /**
   * Image index 
   */
  @MavlinkMessageField(
      position = 4,
      length = 2
  )
  public final int imgIdx() {
    return imgIdx;
  }

  /**
   * Latitude in (deg * 1E7) 
   */
  @MavlinkMessageField(
      position = 5,
      length = 4
  )
  public final int lat() {
    return lat;
  }

  /**
   * Longitude in (deg * 1E7) 
   */
  @MavlinkMessageField(
      position = 6,
      length = 4
  )
  public final int lng() {
    return lng;
  }

  /**
   * Altitude Absolute (meters AMSL) 
   */
  @MavlinkMessageField(
      position = 7,
      length = 4
  )
  public final float altMsl() {
    return altMsl;
  }

  /**
   * Altitude Relative (meters above HOME location) 
   */
  @MavlinkMessageField(
      position = 8,
      length = 4
  )
  public final float altRel() {
    return altRel;
  }

  /**
   * Camera Roll angle (earth frame, degrees, +-180) 
   */
  @MavlinkMessageField(
      position = 9,
      length = 4
  )
  public final float roll() {
    return roll;
  }

  /**
   * Camera Pitch angle (earth frame, degrees, +-180) 
   */
  @MavlinkMessageField(
      position = 10,
      length = 4
  )
  public final float pitch() {
    return pitch;
  }

  /**
   * Camera Yaw (earth frame, degrees, 0-360, true) 
   */
  @MavlinkMessageField(
      position = 11,
      length = 4
  )
  public final float yaw() {
    return yaw;
  }

  /**
   * Focal Length (mm) 
   */
  @MavlinkMessageField(
      position = 12,
      length = 4
  )
  public final float focLen() {
    return focLen;
  }

  /**
   * See {@link io.dronefleet.mavlink.ardupilotmega.CameraFeedbackFlags CameraFeedbackFlags} enum for definition of the bitmask 
   */
  @MavlinkMessageField(
      position = 13,
      length = 1
  )
  public final CameraFeedbackFlags flags() {
    return flags;
  }

  /**
   * Completed image captures 
   */
  @MavlinkMessageField(
      position = 15,
      length = 2,
      extension = true
  )
  public final int completedCaptures() {
    return completedCaptures;
  }

  public static class Builder {
    private BigInteger timeUsec;

    private int targetSystem;

    private int camIdx;

    private int imgIdx;

    private int lat;

    private int lng;

    private float altMsl;

    private float altRel;

    private float roll;

    private float pitch;

    private float yaw;

    private float focLen;

    private CameraFeedbackFlags flags;

    private int completedCaptures;

    private Builder() {
    }

    /**
     * Image timestamp (microseconds since UNIX epoch), as passed in by {@link io.dronefleet.mavlink.ardupilotmega.CameraStatus CameraStatus} message (or 
     * autopilot if no CCB) 
     */
    @MavlinkMessageField(
        position = 1,
        length = 8
    )
    public final Builder timeUsec(BigInteger timeUsec) {
      this.timeUsec = timeUsec;
      return this;
    }

    /**
     * System ID 
     */
    @MavlinkMessageField(
        position = 2,
        length = 1
    )
    public final Builder targetSystem(int targetSystem) {
      this.targetSystem = targetSystem;
      return this;
    }

    /**
     * Camera ID 
     */
    @MavlinkMessageField(
        position = 3,
        length = 1
    )
    public final Builder camIdx(int camIdx) {
      this.camIdx = camIdx;
      return this;
    }

    /**
     * Image index 
     */
    @MavlinkMessageField(
        position = 4,
        length = 2
    )
    public final Builder imgIdx(int imgIdx) {
      this.imgIdx = imgIdx;
      return this;
    }

    /**
     * Latitude in (deg * 1E7) 
     */
    @MavlinkMessageField(
        position = 5,
        length = 4
    )
    public final Builder lat(int lat) {
      this.lat = lat;
      return this;
    }

    /**
     * Longitude in (deg * 1E7) 
     */
    @MavlinkMessageField(
        position = 6,
        length = 4
    )
    public final Builder lng(int lng) {
      this.lng = lng;
      return this;
    }

    /**
     * Altitude Absolute (meters AMSL) 
     */
    @MavlinkMessageField(
        position = 7,
        length = 4
    )
    public final Builder altMsl(float altMsl) {
      this.altMsl = altMsl;
      return this;
    }

    /**
     * Altitude Relative (meters above HOME location) 
     */
    @MavlinkMessageField(
        position = 8,
        length = 4
    )
    public final Builder altRel(float altRel) {
      this.altRel = altRel;
      return this;
    }

    /**
     * Camera Roll angle (earth frame, degrees, +-180) 
     */
    @MavlinkMessageField(
        position = 9,
        length = 4
    )
    public final Builder roll(float roll) {
      this.roll = roll;
      return this;
    }

    /**
     * Camera Pitch angle (earth frame, degrees, +-180) 
     */
    @MavlinkMessageField(
        position = 10,
        length = 4
    )
    public final Builder pitch(float pitch) {
      this.pitch = pitch;
      return this;
    }

    /**
     * Camera Yaw (earth frame, degrees, 0-360, true) 
     */
    @MavlinkMessageField(
        position = 11,
        length = 4
    )
    public final Builder yaw(float yaw) {
      this.yaw = yaw;
      return this;
    }

    /**
     * Focal Length (mm) 
     */
    @MavlinkMessageField(
        position = 12,
        length = 4
    )
    public final Builder focLen(float focLen) {
      this.focLen = focLen;
      return this;
    }

    /**
     * See {@link io.dronefleet.mavlink.ardupilotmega.CameraFeedbackFlags CameraFeedbackFlags} enum for definition of the bitmask 
     */
    @MavlinkMessageField(
        position = 13,
        length = 1
    )
    public final Builder flags(CameraFeedbackFlags flags) {
      this.flags = flags;
      return this;
    }

    /**
     * Completed image captures 
     */
    @MavlinkMessageField(
        position = 15,
        length = 2,
        extension = true
    )
    public final Builder completedCaptures(int completedCaptures) {
      this.completedCaptures = completedCaptures;
      return this;
    }

    public final CameraFeedback build() {
      return new CameraFeedback(timeUsec, targetSystem, camIdx, imgIdx, lat, lng, altMsl, altRel, roll, pitch, yaw, focLen, flags, completedCaptures);
    }
  }
}
