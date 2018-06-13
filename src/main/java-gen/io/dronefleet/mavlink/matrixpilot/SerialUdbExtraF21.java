package io.dronefleet.mavlink.matrixpilot;

import io.dronefleet.mavlink.annotations.MavlinkMessage;
import io.dronefleet.mavlink.annotations.MavlinkMessageField;

/**
 * Backwards compatible version of SERIAL_UDB_EXTRA F21 format 
 */
@MavlinkMessage(
    id = 187,
    crc = 134
)
public final class SerialUdbExtraF21 {
  /**
   * SUE X accelerometer offset 
   */
  private final int sueAccelXOffset;

  /**
   * SUE Y accelerometer offset 
   */
  private final int sueAccelYOffset;

  /**
   * SUE Z accelerometer offset 
   */
  private final int sueAccelZOffset;

  /**
   * SUE X gyro offset 
   */
  private final int sueGyroXOffset;

  /**
   * SUE Y gyro offset 
   */
  private final int sueGyroYOffset;

  /**
   * SUE Z gyro offset 
   */
  private final int sueGyroZOffset;

  private SerialUdbExtraF21(int sueAccelXOffset, int sueAccelYOffset, int sueAccelZOffset,
      int sueGyroXOffset, int sueGyroYOffset, int sueGyroZOffset) {
    this.sueAccelXOffset = sueAccelXOffset;
    this.sueAccelYOffset = sueAccelYOffset;
    this.sueAccelZOffset = sueAccelZOffset;
    this.sueGyroXOffset = sueGyroXOffset;
    this.sueGyroYOffset = sueGyroYOffset;
    this.sueGyroZOffset = sueGyroZOffset;
  }

  public static Builder builder() {
    return new Builder();
  }

  /**
   * SUE X accelerometer offset 
   */
  @MavlinkMessageField(
      position = 1,
      length = 2
  )
  public final int sueAccelXOffset() {
    return sueAccelXOffset;
  }

  /**
   * SUE Y accelerometer offset 
   */
  @MavlinkMessageField(
      position = 2,
      length = 2
  )
  public final int sueAccelYOffset() {
    return sueAccelYOffset;
  }

  /**
   * SUE Z accelerometer offset 
   */
  @MavlinkMessageField(
      position = 3,
      length = 2
  )
  public final int sueAccelZOffset() {
    return sueAccelZOffset;
  }

  /**
   * SUE X gyro offset 
   */
  @MavlinkMessageField(
      position = 4,
      length = 2
  )
  public final int sueGyroXOffset() {
    return sueGyroXOffset;
  }

  /**
   * SUE Y gyro offset 
   */
  @MavlinkMessageField(
      position = 5,
      length = 2
  )
  public final int sueGyroYOffset() {
    return sueGyroYOffset;
  }

  /**
   * SUE Z gyro offset 
   */
  @MavlinkMessageField(
      position = 6,
      length = 2
  )
  public final int sueGyroZOffset() {
    return sueGyroZOffset;
  }

  public static class Builder {
    private int sueAccelXOffset;

    private int sueAccelYOffset;

    private int sueAccelZOffset;

    private int sueGyroXOffset;

    private int sueGyroYOffset;

    private int sueGyroZOffset;

    private Builder() {
    }

    /**
     * SUE X accelerometer offset 
     */
    @MavlinkMessageField(
        position = 1,
        length = 2
    )
    public final Builder sueAccelXOffset(int sueAccelXOffset) {
      this.sueAccelXOffset = sueAccelXOffset;
      return this;
    }

    /**
     * SUE Y accelerometer offset 
     */
    @MavlinkMessageField(
        position = 2,
        length = 2
    )
    public final Builder sueAccelYOffset(int sueAccelYOffset) {
      this.sueAccelYOffset = sueAccelYOffset;
      return this;
    }

    /**
     * SUE Z accelerometer offset 
     */
    @MavlinkMessageField(
        position = 3,
        length = 2
    )
    public final Builder sueAccelZOffset(int sueAccelZOffset) {
      this.sueAccelZOffset = sueAccelZOffset;
      return this;
    }

    /**
     * SUE X gyro offset 
     */
    @MavlinkMessageField(
        position = 4,
        length = 2
    )
    public final Builder sueGyroXOffset(int sueGyroXOffset) {
      this.sueGyroXOffset = sueGyroXOffset;
      return this;
    }

    /**
     * SUE Y gyro offset 
     */
    @MavlinkMessageField(
        position = 5,
        length = 2
    )
    public final Builder sueGyroYOffset(int sueGyroYOffset) {
      this.sueGyroYOffset = sueGyroYOffset;
      return this;
    }

    /**
     * SUE Z gyro offset 
     */
    @MavlinkMessageField(
        position = 6,
        length = 2
    )
    public final Builder sueGyroZOffset(int sueGyroZOffset) {
      this.sueGyroZOffset = sueGyroZOffset;
      return this;
    }

    public final SerialUdbExtraF21 build() {
      return new SerialUdbExtraF21(sueAccelXOffset, sueAccelYOffset, sueAccelZOffset, sueGyroXOffset, sueGyroYOffset, sueGyroZOffset);
    }
  }
}
