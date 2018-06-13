package io.dronefleet.mavlink.ardupilotmega;

import io.dronefleet.mavlink.annotations.MavlinkMessage;
import io.dronefleet.mavlink.annotations.MavlinkMessageField;

/**
 * Offsets and calibrations values for hardware sensors. This makes it easier to debug the 
 * calibration process. 
 */
@MavlinkMessage(
    id = 150,
    crc = 134
)
public final class SensorOffsets {
  /**
   * magnetometer X offset 
   */
  private final int magOfsX;

  /**
   * magnetometer Y offset 
   */
  private final int magOfsY;

  /**
   * magnetometer Z offset 
   */
  private final int magOfsZ;

  /**
   * magnetic declination (radians) 
   */
  private final float magDeclination;

  /**
   * raw pressure from barometer 
   */
  private final int rawPress;

  /**
   * raw temperature from barometer 
   */
  private final int rawTemp;

  /**
   * gyro X calibration 
   */
  private final float gyroCalX;

  /**
   * gyro Y calibration 
   */
  private final float gyroCalY;

  /**
   * gyro Z calibration 
   */
  private final float gyroCalZ;

  /**
   * accel X calibration 
   */
  private final float accelCalX;

  /**
   * accel Y calibration 
   */
  private final float accelCalY;

  /**
   * accel Z calibration 
   */
  private final float accelCalZ;

  private SensorOffsets(int magOfsX, int magOfsY, int magOfsZ, float magDeclination, int rawPress,
      int rawTemp, float gyroCalX, float gyroCalY, float gyroCalZ, float accelCalX, float accelCalY,
      float accelCalZ) {
    this.magOfsX = magOfsX;
    this.magOfsY = magOfsY;
    this.magOfsZ = magOfsZ;
    this.magDeclination = magDeclination;
    this.rawPress = rawPress;
    this.rawTemp = rawTemp;
    this.gyroCalX = gyroCalX;
    this.gyroCalY = gyroCalY;
    this.gyroCalZ = gyroCalZ;
    this.accelCalX = accelCalX;
    this.accelCalY = accelCalY;
    this.accelCalZ = accelCalZ;
  }

  public static Builder builder() {
    return new Builder();
  }

  /**
   * magnetometer X offset 
   */
  @MavlinkMessageField(
      position = 1,
      length = 2
  )
  public final int magOfsX() {
    return magOfsX;
  }

  /**
   * magnetometer Y offset 
   */
  @MavlinkMessageField(
      position = 2,
      length = 2
  )
  public final int magOfsY() {
    return magOfsY;
  }

  /**
   * magnetometer Z offset 
   */
  @MavlinkMessageField(
      position = 3,
      length = 2
  )
  public final int magOfsZ() {
    return magOfsZ;
  }

  /**
   * magnetic declination (radians) 
   */
  @MavlinkMessageField(
      position = 4,
      length = 4
  )
  public final float magDeclination() {
    return magDeclination;
  }

  /**
   * raw pressure from barometer 
   */
  @MavlinkMessageField(
      position = 5,
      length = 4
  )
  public final int rawPress() {
    return rawPress;
  }

  /**
   * raw temperature from barometer 
   */
  @MavlinkMessageField(
      position = 6,
      length = 4
  )
  public final int rawTemp() {
    return rawTemp;
  }

  /**
   * gyro X calibration 
   */
  @MavlinkMessageField(
      position = 7,
      length = 4
  )
  public final float gyroCalX() {
    return gyroCalX;
  }

  /**
   * gyro Y calibration 
   */
  @MavlinkMessageField(
      position = 8,
      length = 4
  )
  public final float gyroCalY() {
    return gyroCalY;
  }

  /**
   * gyro Z calibration 
   */
  @MavlinkMessageField(
      position = 9,
      length = 4
  )
  public final float gyroCalZ() {
    return gyroCalZ;
  }

  /**
   * accel X calibration 
   */
  @MavlinkMessageField(
      position = 10,
      length = 4
  )
  public final float accelCalX() {
    return accelCalX;
  }

  /**
   * accel Y calibration 
   */
  @MavlinkMessageField(
      position = 11,
      length = 4
  )
  public final float accelCalY() {
    return accelCalY;
  }

  /**
   * accel Z calibration 
   */
  @MavlinkMessageField(
      position = 12,
      length = 4
  )
  public final float accelCalZ() {
    return accelCalZ;
  }

  public static class Builder {
    private int magOfsX;

    private int magOfsY;

    private int magOfsZ;

    private float magDeclination;

    private int rawPress;

    private int rawTemp;

    private float gyroCalX;

    private float gyroCalY;

    private float gyroCalZ;

    private float accelCalX;

    private float accelCalY;

    private float accelCalZ;

    private Builder() {
    }

    /**
     * magnetometer X offset 
     */
    @MavlinkMessageField(
        position = 1,
        length = 2
    )
    public final Builder magOfsX(int magOfsX) {
      this.magOfsX = magOfsX;
      return this;
    }

    /**
     * magnetometer Y offset 
     */
    @MavlinkMessageField(
        position = 2,
        length = 2
    )
    public final Builder magOfsY(int magOfsY) {
      this.magOfsY = magOfsY;
      return this;
    }

    /**
     * magnetometer Z offset 
     */
    @MavlinkMessageField(
        position = 3,
        length = 2
    )
    public final Builder magOfsZ(int magOfsZ) {
      this.magOfsZ = magOfsZ;
      return this;
    }

    /**
     * magnetic declination (radians) 
     */
    @MavlinkMessageField(
        position = 4,
        length = 4
    )
    public final Builder magDeclination(float magDeclination) {
      this.magDeclination = magDeclination;
      return this;
    }

    /**
     * raw pressure from barometer 
     */
    @MavlinkMessageField(
        position = 5,
        length = 4
    )
    public final Builder rawPress(int rawPress) {
      this.rawPress = rawPress;
      return this;
    }

    /**
     * raw temperature from barometer 
     */
    @MavlinkMessageField(
        position = 6,
        length = 4
    )
    public final Builder rawTemp(int rawTemp) {
      this.rawTemp = rawTemp;
      return this;
    }

    /**
     * gyro X calibration 
     */
    @MavlinkMessageField(
        position = 7,
        length = 4
    )
    public final Builder gyroCalX(float gyroCalX) {
      this.gyroCalX = gyroCalX;
      return this;
    }

    /**
     * gyro Y calibration 
     */
    @MavlinkMessageField(
        position = 8,
        length = 4
    )
    public final Builder gyroCalY(float gyroCalY) {
      this.gyroCalY = gyroCalY;
      return this;
    }

    /**
     * gyro Z calibration 
     */
    @MavlinkMessageField(
        position = 9,
        length = 4
    )
    public final Builder gyroCalZ(float gyroCalZ) {
      this.gyroCalZ = gyroCalZ;
      return this;
    }

    /**
     * accel X calibration 
     */
    @MavlinkMessageField(
        position = 10,
        length = 4
    )
    public final Builder accelCalX(float accelCalX) {
      this.accelCalX = accelCalX;
      return this;
    }

    /**
     * accel Y calibration 
     */
    @MavlinkMessageField(
        position = 11,
        length = 4
    )
    public final Builder accelCalY(float accelCalY) {
      this.accelCalY = accelCalY;
      return this;
    }

    /**
     * accel Z calibration 
     */
    @MavlinkMessageField(
        position = 12,
        length = 4
    )
    public final Builder accelCalZ(float accelCalZ) {
      this.accelCalZ = accelCalZ;
      return this;
    }

    public final SensorOffsets build() {
      return new SensorOffsets(magOfsX, magOfsY, magOfsZ, magDeclination, rawPress, rawTemp, gyroCalX, gyroCalY, gyroCalZ, accelCalX, accelCalY, accelCalZ);
    }
  }
}
