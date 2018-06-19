package io.dronefleet.mavlink.matrixpilot;

import io.dronefleet.mavlink.annotations.MavlinkMessage;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageField;
import java.lang.Override;
import java.lang.String;

/**
 * Backwards compatible version of SERIAL_UDB_EXTRA F22 format 
 */
@MavlinkMessage(
    id = 188,
    crc = 91
)
public final class SerialUdbExtraF22 {
  /**
   * SUE X accelerometer at calibration time 
   */
  private final int sueAccelXAtCalibration;

  /**
   * SUE Y accelerometer at calibration time 
   */
  private final int sueAccelYAtCalibration;

  /**
   * SUE Z accelerometer at calibration time 
   */
  private final int sueAccelZAtCalibration;

  /**
   * SUE X gyro at calibration time 
   */
  private final int sueGyroXAtCalibration;

  /**
   * SUE Y gyro at calibration time 
   */
  private final int sueGyroYAtCalibration;

  /**
   * SUE Z gyro at calibration time 
   */
  private final int sueGyroZAtCalibration;

  private SerialUdbExtraF22(int sueAccelXAtCalibration, int sueAccelYAtCalibration,
      int sueAccelZAtCalibration, int sueGyroXAtCalibration, int sueGyroYAtCalibration,
      int sueGyroZAtCalibration) {
    this.sueAccelXAtCalibration = sueAccelXAtCalibration;
    this.sueAccelYAtCalibration = sueAccelYAtCalibration;
    this.sueAccelZAtCalibration = sueAccelZAtCalibration;
    this.sueGyroXAtCalibration = sueGyroXAtCalibration;
    this.sueGyroYAtCalibration = sueGyroYAtCalibration;
    this.sueGyroZAtCalibration = sueGyroZAtCalibration;
  }

  @MavlinkMessageBuilder
  public static Builder builder() {
    return new Builder();
  }

  @Override
  public String toString() {
    return "SerialUdbExtraF22{sueAccelXAtCalibration=" + sueAccelXAtCalibration
         + ", sueAccelYAtCalibration=" + sueAccelYAtCalibration
         + ", sueAccelZAtCalibration=" + sueAccelZAtCalibration
         + ", sueGyroXAtCalibration=" + sueGyroXAtCalibration
         + ", sueGyroYAtCalibration=" + sueGyroYAtCalibration
         + ", sueGyroZAtCalibration=" + sueGyroZAtCalibration + "}";
  }

  /**
   * SUE X accelerometer at calibration time 
   */
  @MavlinkMessageField(
      position = 1,
      unitSize = 2
  )
  public final int sueAccelXAtCalibration() {
    return sueAccelXAtCalibration;
  }

  /**
   * SUE Y accelerometer at calibration time 
   */
  @MavlinkMessageField(
      position = 2,
      unitSize = 2
  )
  public final int sueAccelYAtCalibration() {
    return sueAccelYAtCalibration;
  }

  /**
   * SUE Z accelerometer at calibration time 
   */
  @MavlinkMessageField(
      position = 3,
      unitSize = 2
  )
  public final int sueAccelZAtCalibration() {
    return sueAccelZAtCalibration;
  }

  /**
   * SUE X gyro at calibration time 
   */
  @MavlinkMessageField(
      position = 4,
      unitSize = 2
  )
  public final int sueGyroXAtCalibration() {
    return sueGyroXAtCalibration;
  }

  /**
   * SUE Y gyro at calibration time 
   */
  @MavlinkMessageField(
      position = 5,
      unitSize = 2
  )
  public final int sueGyroYAtCalibration() {
    return sueGyroYAtCalibration;
  }

  /**
   * SUE Z gyro at calibration time 
   */
  @MavlinkMessageField(
      position = 6,
      unitSize = 2
  )
  public final int sueGyroZAtCalibration() {
    return sueGyroZAtCalibration;
  }

  public static class Builder {
    private int sueAccelXAtCalibration;

    private int sueAccelYAtCalibration;

    private int sueAccelZAtCalibration;

    private int sueGyroXAtCalibration;

    private int sueGyroYAtCalibration;

    private int sueGyroZAtCalibration;

    private Builder() {
    }

    /**
     * SUE X accelerometer at calibration time 
     */
    @MavlinkMessageField(
        position = 1,
        unitSize = 2
    )
    public final Builder sueAccelXAtCalibration(int sueAccelXAtCalibration) {
      this.sueAccelXAtCalibration = sueAccelXAtCalibration;
      return this;
    }

    /**
     * SUE Y accelerometer at calibration time 
     */
    @MavlinkMessageField(
        position = 2,
        unitSize = 2
    )
    public final Builder sueAccelYAtCalibration(int sueAccelYAtCalibration) {
      this.sueAccelYAtCalibration = sueAccelYAtCalibration;
      return this;
    }

    /**
     * SUE Z accelerometer at calibration time 
     */
    @MavlinkMessageField(
        position = 3,
        unitSize = 2
    )
    public final Builder sueAccelZAtCalibration(int sueAccelZAtCalibration) {
      this.sueAccelZAtCalibration = sueAccelZAtCalibration;
      return this;
    }

    /**
     * SUE X gyro at calibration time 
     */
    @MavlinkMessageField(
        position = 4,
        unitSize = 2
    )
    public final Builder sueGyroXAtCalibration(int sueGyroXAtCalibration) {
      this.sueGyroXAtCalibration = sueGyroXAtCalibration;
      return this;
    }

    /**
     * SUE Y gyro at calibration time 
     */
    @MavlinkMessageField(
        position = 5,
        unitSize = 2
    )
    public final Builder sueGyroYAtCalibration(int sueGyroYAtCalibration) {
      this.sueGyroYAtCalibration = sueGyroYAtCalibration;
      return this;
    }

    /**
     * SUE Z gyro at calibration time 
     */
    @MavlinkMessageField(
        position = 6,
        unitSize = 2
    )
    public final Builder sueGyroZAtCalibration(int sueGyroZAtCalibration) {
      this.sueGyroZAtCalibration = sueGyroZAtCalibration;
      return this;
    }

    public final SerialUdbExtraF22 build() {
      return new SerialUdbExtraF22(sueAccelXAtCalibration, sueAccelYAtCalibration, sueAccelZAtCalibration, sueGyroXAtCalibration, sueGyroYAtCalibration, sueGyroZAtCalibration);
    }
  }
}
