package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkMessage;
import io.dronefleet.mavlink.annotations.MavlinkMessageField;
import java.math.BigInteger;

/**
 * The IMU readings in SI units in NED body frame 
 */
@MavlinkMessage(
    id = 105,
    crc = 93
)
public final class HighresImu {
  private final BigInteger timeUsec;

  private final float xacc;

  private final float yacc;

  private final float zacc;

  private final float xgyro;

  private final float ygyro;

  private final float zgyro;

  private final float xmag;

  private final float ymag;

  private final float zmag;

  private final float absPressure;

  private final float diffPressure;

  private final float pressureAlt;

  private final float temperature;

  private final int fieldsUpdated;

  private HighresImu(BigInteger timeUsec, float xacc, float yacc, float zacc, float xgyro,
      float ygyro, float zgyro, float xmag, float ymag, float zmag, float absPressure,
      float diffPressure, float pressureAlt, float temperature, int fieldsUpdated) {
    this.timeUsec = timeUsec;
    this.xacc = xacc;
    this.yacc = yacc;
    this.zacc = zacc;
    this.xgyro = xgyro;
    this.ygyro = ygyro;
    this.zgyro = zgyro;
    this.xmag = xmag;
    this.ymag = ymag;
    this.zmag = zmag;
    this.absPressure = absPressure;
    this.diffPressure = diffPressure;
    this.pressureAlt = pressureAlt;
    this.temperature = temperature;
    this.fieldsUpdated = fieldsUpdated;
  }

  public static Builder builder() {
    return new Builder();
  }

  /**
   * Timestamp (microseconds, synced to UNIX time or since system boot) 
   */
  @MavlinkMessageField(
      position = 1,
      length = 8
  )
  public final BigInteger timeUsec() {
    return timeUsec;
  }

  /**
   * X acceleration (m/s^2) 
   */
  @MavlinkMessageField(
      position = 2,
      length = 4
  )
  public final float xacc() {
    return xacc;
  }

  /**
   * Y acceleration (m/s^2) 
   */
  @MavlinkMessageField(
      position = 3,
      length = 4
  )
  public final float yacc() {
    return yacc;
  }

  /**
   * Z acceleration (m/s^2) 
   */
  @MavlinkMessageField(
      position = 4,
      length = 4
  )
  public final float zacc() {
    return zacc;
  }

  /**
   * Angular speed around X axis (rad / sec) 
   */
  @MavlinkMessageField(
      position = 5,
      length = 4
  )
  public final float xgyro() {
    return xgyro;
  }

  /**
   * Angular speed around Y axis (rad / sec) 
   */
  @MavlinkMessageField(
      position = 6,
      length = 4
  )
  public final float ygyro() {
    return ygyro;
  }

  /**
   * Angular speed around Z axis (rad / sec) 
   */
  @MavlinkMessageField(
      position = 7,
      length = 4
  )
  public final float zgyro() {
    return zgyro;
  }

  /**
   * X Magnetic field (Gauss) 
   */
  @MavlinkMessageField(
      position = 8,
      length = 4
  )
  public final float xmag() {
    return xmag;
  }

  /**
   * Y Magnetic field (Gauss) 
   */
  @MavlinkMessageField(
      position = 9,
      length = 4
  )
  public final float ymag() {
    return ymag;
  }

  /**
   * Z Magnetic field (Gauss) 
   */
  @MavlinkMessageField(
      position = 10,
      length = 4
  )
  public final float zmag() {
    return zmag;
  }

  /**
   * Absolute pressure in millibar 
   */
  @MavlinkMessageField(
      position = 11,
      length = 4
  )
  public final float absPressure() {
    return absPressure;
  }

  /**
   * Differential pressure in millibar 
   */
  @MavlinkMessageField(
      position = 12,
      length = 4
  )
  public final float diffPressure() {
    return diffPressure;
  }

  /**
   * Altitude calculated from pressure 
   */
  @MavlinkMessageField(
      position = 13,
      length = 4
  )
  public final float pressureAlt() {
    return pressureAlt;
  }

  /**
   * Temperature in degrees celsius 
   */
  @MavlinkMessageField(
      position = 14,
      length = 4
  )
  public final float temperature() {
    return temperature;
  }

  /**
   * Bitmask for fields that have updated since last message, bit 0 = xacc, bit 12: temperature 
   */
  @MavlinkMessageField(
      position = 15,
      length = 2
  )
  public final int fieldsUpdated() {
    return fieldsUpdated;
  }

  public class Builder {
    private BigInteger timeUsec;

    private float xacc;

    private float yacc;

    private float zacc;

    private float xgyro;

    private float ygyro;

    private float zgyro;

    private float xmag;

    private float ymag;

    private float zmag;

    private float absPressure;

    private float diffPressure;

    private float pressureAlt;

    private float temperature;

    private int fieldsUpdated;

    private Builder() {
    }

    /**
     * Timestamp (microseconds, synced to UNIX time or since system boot) 
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
     * X acceleration (m/s^2) 
     */
    @MavlinkMessageField(
        position = 2,
        length = 4
    )
    public final Builder xacc(float xacc) {
      this.xacc = xacc;
      return this;
    }

    /**
     * Y acceleration (m/s^2) 
     */
    @MavlinkMessageField(
        position = 3,
        length = 4
    )
    public final Builder yacc(float yacc) {
      this.yacc = yacc;
      return this;
    }

    /**
     * Z acceleration (m/s^2) 
     */
    @MavlinkMessageField(
        position = 4,
        length = 4
    )
    public final Builder zacc(float zacc) {
      this.zacc = zacc;
      return this;
    }

    /**
     * Angular speed around X axis (rad / sec) 
     */
    @MavlinkMessageField(
        position = 5,
        length = 4
    )
    public final Builder xgyro(float xgyro) {
      this.xgyro = xgyro;
      return this;
    }

    /**
     * Angular speed around Y axis (rad / sec) 
     */
    @MavlinkMessageField(
        position = 6,
        length = 4
    )
    public final Builder ygyro(float ygyro) {
      this.ygyro = ygyro;
      return this;
    }

    /**
     * Angular speed around Z axis (rad / sec) 
     */
    @MavlinkMessageField(
        position = 7,
        length = 4
    )
    public final Builder zgyro(float zgyro) {
      this.zgyro = zgyro;
      return this;
    }

    /**
     * X Magnetic field (Gauss) 
     */
    @MavlinkMessageField(
        position = 8,
        length = 4
    )
    public final Builder xmag(float xmag) {
      this.xmag = xmag;
      return this;
    }

    /**
     * Y Magnetic field (Gauss) 
     */
    @MavlinkMessageField(
        position = 9,
        length = 4
    )
    public final Builder ymag(float ymag) {
      this.ymag = ymag;
      return this;
    }

    /**
     * Z Magnetic field (Gauss) 
     */
    @MavlinkMessageField(
        position = 10,
        length = 4
    )
    public final Builder zmag(float zmag) {
      this.zmag = zmag;
      return this;
    }

    /**
     * Absolute pressure in millibar 
     */
    @MavlinkMessageField(
        position = 11,
        length = 4
    )
    public final Builder absPressure(float absPressure) {
      this.absPressure = absPressure;
      return this;
    }

    /**
     * Differential pressure in millibar 
     */
    @MavlinkMessageField(
        position = 12,
        length = 4
    )
    public final Builder diffPressure(float diffPressure) {
      this.diffPressure = diffPressure;
      return this;
    }

    /**
     * Altitude calculated from pressure 
     */
    @MavlinkMessageField(
        position = 13,
        length = 4
    )
    public final Builder pressureAlt(float pressureAlt) {
      this.pressureAlt = pressureAlt;
      return this;
    }

    /**
     * Temperature in degrees celsius 
     */
    @MavlinkMessageField(
        position = 14,
        length = 4
    )
    public final Builder temperature(float temperature) {
      this.temperature = temperature;
      return this;
    }

    /**
     * Bitmask for fields that have updated since last message, bit 0 = xacc, bit 12: temperature 
     */
    @MavlinkMessageField(
        position = 15,
        length = 2
    )
    public final Builder fieldsUpdated(int fieldsUpdated) {
      this.fieldsUpdated = fieldsUpdated;
      return this;
    }

    public final HighresImu build() {
      return new HighresImu(timeUsec, xacc, yacc, zacc, xgyro, ygyro, zgyro, xmag, ymag, zmag, absPressure, diffPressure, pressureAlt, temperature, fieldsUpdated);
    }
  }
}
