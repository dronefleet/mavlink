package io.dronefleet.mavlink.slugs;

import io.dronefleet.mavlink.annotations.MavlinkMessage;
import io.dronefleet.mavlink.annotations.MavlinkMessageField;

/**
 * Accelerometer and gyro biases. 
 */
@MavlinkMessage(
    id = 172,
    crc = 168
)
public final class SensorBias {
  private final float axbias;

  private final float aybias;

  private final float azbias;

  private final float gxbias;

  private final float gybias;

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

  public static Builder builder() {
    return new Builder();
  }

  /**
   * Accelerometer X bias 
   */
  @MavlinkMessageField(
      position = 1,
      length = 4
  )
  public final float axbias() {
    return axbias;
  }

  /**
   * Accelerometer Y bias 
   */
  @MavlinkMessageField(
      position = 2,
      length = 4
  )
  public final float aybias() {
    return aybias;
  }

  /**
   * Accelerometer Z bias 
   */
  @MavlinkMessageField(
      position = 3,
      length = 4
  )
  public final float azbias() {
    return azbias;
  }

  /**
   * Gyro X bias 
   */
  @MavlinkMessageField(
      position = 4,
      length = 4
  )
  public final float gxbias() {
    return gxbias;
  }

  /**
   * Gyro Y bias 
   */
  @MavlinkMessageField(
      position = 5,
      length = 4
  )
  public final float gybias() {
    return gybias;
  }

  /**
   * Gyro Z bias 
   */
  @MavlinkMessageField(
      position = 6,
      length = 4
  )
  public final float gzbias() {
    return gzbias;
  }

  public class Builder {
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
    @MavlinkMessageField(
        position = 1,
        length = 4
    )
    public final Builder axbias(float axbias) {
      this.axbias = axbias;
      return this;
    }

    /**
     * Accelerometer Y bias 
     */
    @MavlinkMessageField(
        position = 2,
        length = 4
    )
    public final Builder aybias(float aybias) {
      this.aybias = aybias;
      return this;
    }

    /**
     * Accelerometer Z bias 
     */
    @MavlinkMessageField(
        position = 3,
        length = 4
    )
    public final Builder azbias(float azbias) {
      this.azbias = azbias;
      return this;
    }

    /**
     * Gyro X bias 
     */
    @MavlinkMessageField(
        position = 4,
        length = 4
    )
    public final Builder gxbias(float gxbias) {
      this.gxbias = gxbias;
      return this;
    }

    /**
     * Gyro Y bias 
     */
    @MavlinkMessageField(
        position = 5,
        length = 4
    )
    public final Builder gybias(float gybias) {
      this.gybias = gybias;
      return this;
    }

    /**
     * Gyro Z bias 
     */
    @MavlinkMessageField(
        position = 6,
        length = 4
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
