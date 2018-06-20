package io.dronefleet.mavlink.slugs;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import java.lang.Override;
import java.lang.String;

/**
 * Accelerometer and gyro biases. 
 */
@MavlinkMessageInfo(
    id = 172,
    crc = 168
)
public final class SensorBias {
  /**
   * Accelerometer X bias 
   */
  private final float axbias;

  /**
   * Accelerometer Y bias 
   */
  private final float aybias;

  /**
   * Accelerometer Z bias 
   */
  private final float azbias;

  /**
   * Gyro X bias 
   */
  private final float gxbias;

  /**
   * Gyro Y bias 
   */
  private final float gybias;

  /**
   * Gyro Z bias 
   */
  private final float gzbias;

  private SensorBias(float axbias, float aybias, float azbias, float gxbias, float gybias,
      float gzbias) {
    this.axbias = axbias;
    this.aybias = aybias;
    this.azbias = azbias;
    this.gxbias = gxbias;
    this.gybias = gybias;
    this.gzbias = gzbias;
  }

  @MavlinkMessageBuilder
  public static Builder builder() {
    return new Builder();
  }

  @Override
  public String toString() {
    return "SensorBias{axbias=" + axbias
         + ", aybias=" + aybias
         + ", azbias=" + azbias
         + ", gxbias=" + gxbias
         + ", gybias=" + gybias
         + ", gzbias=" + gzbias + "}";
  }

  /**
   * Accelerometer X bias 
   */
  @MavlinkFieldInfo(
      position = 1,
      unitSize = 4
  )
  public final float axbias() {
    return axbias;
  }

  /**
   * Accelerometer Y bias 
   */
  @MavlinkFieldInfo(
      position = 2,
      unitSize = 4
  )
  public final float aybias() {
    return aybias;
  }

  /**
   * Accelerometer Z bias 
   */
  @MavlinkFieldInfo(
      position = 3,
      unitSize = 4
  )
  public final float azbias() {
    return azbias;
  }

  /**
   * Gyro X bias 
   */
  @MavlinkFieldInfo(
      position = 4,
      unitSize = 4
  )
  public final float gxbias() {
    return gxbias;
  }

  /**
   * Gyro Y bias 
   */
  @MavlinkFieldInfo(
      position = 5,
      unitSize = 4
  )
  public final float gybias() {
    return gybias;
  }

  /**
   * Gyro Z bias 
   */
  @MavlinkFieldInfo(
      position = 6,
      unitSize = 4
  )
  public final float gzbias() {
    return gzbias;
  }

  public static class Builder {
    private float axbias;

    private float aybias;

    private float azbias;

    private float gxbias;

    private float gybias;

    private float gzbias;

    private Builder() {
    }

    /**
     * Accelerometer X bias 
     */
    @MavlinkFieldInfo(
        position = 1,
        unitSize = 4
    )
    public final Builder axbias(float axbias) {
      this.axbias = axbias;
      return this;
    }

    /**
     * Accelerometer Y bias 
     */
    @MavlinkFieldInfo(
        position = 2,
        unitSize = 4
    )
    public final Builder aybias(float aybias) {
      this.aybias = aybias;
      return this;
    }

    /**
     * Accelerometer Z bias 
     */
    @MavlinkFieldInfo(
        position = 3,
        unitSize = 4
    )
    public final Builder azbias(float azbias) {
      this.azbias = azbias;
      return this;
    }

    /**
     * Gyro X bias 
     */
    @MavlinkFieldInfo(
        position = 4,
        unitSize = 4
    )
    public final Builder gxbias(float gxbias) {
      this.gxbias = gxbias;
      return this;
    }

    /**
     * Gyro Y bias 
     */
    @MavlinkFieldInfo(
        position = 5,
        unitSize = 4
    )
    public final Builder gybias(float gybias) {
      this.gybias = gybias;
      return this;
    }

    /**
     * Gyro Z bias 
     */
    @MavlinkFieldInfo(
        position = 6,
        unitSize = 4
    )
    public final Builder gzbias(float gzbias) {
      this.gzbias = gzbias;
      return this;
    }

    public final SensorBias build() {
      return new SensorBias(axbias, aybias, azbias, gxbias, gybias, gzbias);
    }
  }
}
