package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import java.lang.Override;
import java.lang.String;
import java.math.BigInteger;

/**
 * The IMU readings in SI units in NED body frame 
 */
@MavlinkMessageInfo(
    id = 107,
    crc = 108
)
public final class HilSensor {
  /**
   * Timestamp (microseconds, synced to UNIX time or since system boot) 
   */
  private final BigInteger timeUsec;

  /**
   * X acceleration (m/s^2) 
   */
  private final float xacc;

  /**
   * Y acceleration (m/s^2) 
   */
  private final float yacc;

  /**
   * Z acceleration (m/s^2) 
   */
  private final float zacc;

  /**
   * Angular speed around X axis in body frame (rad / sec) 
   */
  private final float xgyro;

  /**
   * Angular speed around Y axis in body frame (rad / sec) 
   */
  private final float ygyro;

  /**
   * Angular speed around Z axis in body frame (rad / sec) 
   */
  private final float zgyro;

  /**
   * X Magnetic field (Gauss) 
   */
  private final float xmag;

  /**
   * Y Magnetic field (Gauss) 
   */
  private final float ymag;

  /**
   * Z Magnetic field (Gauss) 
   */
  private final float zmag;

  /**
   * Absolute pressure in millibar 
   */
  private final float absPressure;

  /**
   * Differential pressure (airspeed) in millibar 
   */
  private final float diffPressure;

  /**
   * Altitude calculated from pressure 
   */
  private final float pressureAlt;

  /**
   * Temperature in degrees celsius 
   */
  private final float temperature;

  /**
   * Bitmask for fields that have updated since last message, bit 0 = xacc, bit 12: temperature, bit 
   * 31: full reset of attitude/position/velocities/etc was performed in sim. 
   */
  private final long fieldsUpdated;

  private HilSensor(BigInteger timeUsec, float xacc, float yacc, float zacc, float xgyro,
      float ygyro, float zgyro, float xmag, float ymag, float zmag, float absPressure,
      float diffPressure, float pressureAlt, float temperature, long fieldsUpdated) {
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

  @MavlinkMessageBuilder
  public static Builder builder() {
    return new Builder();
  }

  @Override
  public String toString() {
    return "HilSensor{timeUsec=" + timeUsec
         + ", xacc=" + xacc
         + ", yacc=" + yacc
         + ", zacc=" + zacc
         + ", xgyro=" + xgyro
         + ", ygyro=" + ygyro
         + ", zgyro=" + zgyro
         + ", xmag=" + xmag
         + ", ymag=" + ymag
         + ", zmag=" + zmag
         + ", absPressure=" + absPressure
         + ", diffPressure=" + diffPressure
         + ", pressureAlt=" + pressureAlt
         + ", temperature=" + temperature
         + ", fieldsUpdated=" + fieldsUpdated + "}";
  }

  /**
   * Timestamp (microseconds, synced to UNIX time or since system boot) 
   */
  @MavlinkFieldInfo(
      position = 1,
      unitSize = 8
  )
  public final BigInteger timeUsec() {
    return timeUsec;
  }

  /**
   * X acceleration (m/s^2) 
   */
  @MavlinkFieldInfo(
      position = 2,
      unitSize = 4
  )
  public final float xacc() {
    return xacc;
  }

  /**
   * Y acceleration (m/s^2) 
   */
  @MavlinkFieldInfo(
      position = 3,
      unitSize = 4
  )
  public final float yacc() {
    return yacc;
  }

  /**
   * Z acceleration (m/s^2) 
   */
  @MavlinkFieldInfo(
      position = 4,
      unitSize = 4
  )
  public final float zacc() {
    return zacc;
  }

  /**
   * Angular speed around X axis in body frame (rad / sec) 
   */
  @MavlinkFieldInfo(
      position = 5,
      unitSize = 4
  )
  public final float xgyro() {
    return xgyro;
  }

  /**
   * Angular speed around Y axis in body frame (rad / sec) 
   */
  @MavlinkFieldInfo(
      position = 6,
      unitSize = 4
  )
  public final float ygyro() {
    return ygyro;
  }

  /**
   * Angular speed around Z axis in body frame (rad / sec) 
   */
  @MavlinkFieldInfo(
      position = 7,
      unitSize = 4
  )
  public final float zgyro() {
    return zgyro;
  }

  /**
   * X Magnetic field (Gauss) 
   */
  @MavlinkFieldInfo(
      position = 8,
      unitSize = 4
  )
  public final float xmag() {
    return xmag;
  }

  /**
   * Y Magnetic field (Gauss) 
   */
  @MavlinkFieldInfo(
      position = 9,
      unitSize = 4
  )
  public final float ymag() {
    return ymag;
  }

  /**
   * Z Magnetic field (Gauss) 
   */
  @MavlinkFieldInfo(
      position = 10,
      unitSize = 4
  )
  public final float zmag() {
    return zmag;
  }

  /**
   * Absolute pressure in millibar 
   */
  @MavlinkFieldInfo(
      position = 11,
      unitSize = 4
  )
  public final float absPressure() {
    return absPressure;
  }

  /**
   * Differential pressure (airspeed) in millibar 
   */
  @MavlinkFieldInfo(
      position = 12,
      unitSize = 4
  )
  public final float diffPressure() {
    return diffPressure;
  }

  /**
   * Altitude calculated from pressure 
   */
  @MavlinkFieldInfo(
      position = 13,
      unitSize = 4
  )
  public final float pressureAlt() {
    return pressureAlt;
  }

  /**
   * Temperature in degrees celsius 
   */
  @MavlinkFieldInfo(
      position = 14,
      unitSize = 4
  )
  public final float temperature() {
    return temperature;
  }

  /**
   * Bitmask for fields that have updated since last message, bit 0 = xacc, bit 12: temperature, bit 
   * 31: full reset of attitude/position/velocities/etc was performed in sim. 
   */
  @MavlinkFieldInfo(
      position = 15,
      unitSize = 4
  )
  public final long fieldsUpdated() {
    return fieldsUpdated;
  }

  public static class Builder {
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

    private long fieldsUpdated;

    private Builder() {
    }

    /**
     * Timestamp (microseconds, synced to UNIX time or since system boot) 
     */
    @MavlinkFieldInfo(
        position = 1,
        unitSize = 8
    )
    public final Builder timeUsec(BigInteger timeUsec) {
      this.timeUsec = timeUsec;
      return this;
    }

    /**
     * X acceleration (m/s^2) 
     */
    @MavlinkFieldInfo(
        position = 2,
        unitSize = 4
    )
    public final Builder xacc(float xacc) {
      this.xacc = xacc;
      return this;
    }

    /**
     * Y acceleration (m/s^2) 
     */
    @MavlinkFieldInfo(
        position = 3,
        unitSize = 4
    )
    public final Builder yacc(float yacc) {
      this.yacc = yacc;
      return this;
    }

    /**
     * Z acceleration (m/s^2) 
     */
    @MavlinkFieldInfo(
        position = 4,
        unitSize = 4
    )
    public final Builder zacc(float zacc) {
      this.zacc = zacc;
      return this;
    }

    /**
     * Angular speed around X axis in body frame (rad / sec) 
     */
    @MavlinkFieldInfo(
        position = 5,
        unitSize = 4
    )
    public final Builder xgyro(float xgyro) {
      this.xgyro = xgyro;
      return this;
    }

    /**
     * Angular speed around Y axis in body frame (rad / sec) 
     */
    @MavlinkFieldInfo(
        position = 6,
        unitSize = 4
    )
    public final Builder ygyro(float ygyro) {
      this.ygyro = ygyro;
      return this;
    }

    /**
     * Angular speed around Z axis in body frame (rad / sec) 
     */
    @MavlinkFieldInfo(
        position = 7,
        unitSize = 4
    )
    public final Builder zgyro(float zgyro) {
      this.zgyro = zgyro;
      return this;
    }

    /**
     * X Magnetic field (Gauss) 
     */
    @MavlinkFieldInfo(
        position = 8,
        unitSize = 4
    )
    public final Builder xmag(float xmag) {
      this.xmag = xmag;
      return this;
    }

    /**
     * Y Magnetic field (Gauss) 
     */
    @MavlinkFieldInfo(
        position = 9,
        unitSize = 4
    )
    public final Builder ymag(float ymag) {
      this.ymag = ymag;
      return this;
    }

    /**
     * Z Magnetic field (Gauss) 
     */
    @MavlinkFieldInfo(
        position = 10,
        unitSize = 4
    )
    public final Builder zmag(float zmag) {
      this.zmag = zmag;
      return this;
    }

    /**
     * Absolute pressure in millibar 
     */
    @MavlinkFieldInfo(
        position = 11,
        unitSize = 4
    )
    public final Builder absPressure(float absPressure) {
      this.absPressure = absPressure;
      return this;
    }

    /**
     * Differential pressure (airspeed) in millibar 
     */
    @MavlinkFieldInfo(
        position = 12,
        unitSize = 4
    )
    public final Builder diffPressure(float diffPressure) {
      this.diffPressure = diffPressure;
      return this;
    }

    /**
     * Altitude calculated from pressure 
     */
    @MavlinkFieldInfo(
        position = 13,
        unitSize = 4
    )
    public final Builder pressureAlt(float pressureAlt) {
      this.pressureAlt = pressureAlt;
      return this;
    }

    /**
     * Temperature in degrees celsius 
     */
    @MavlinkFieldInfo(
        position = 14,
        unitSize = 4
    )
    public final Builder temperature(float temperature) {
      this.temperature = temperature;
      return this;
    }

    /**
     * Bitmask for fields that have updated since last message, bit 0 = xacc, bit 12: temperature, bit 
     * 31: full reset of attitude/position/velocities/etc was performed in sim. 
     */
    @MavlinkFieldInfo(
        position = 15,
        unitSize = 4
    )
    public final Builder fieldsUpdated(long fieldsUpdated) {
      this.fieldsUpdated = fieldsUpdated;
      return this;
    }

    public final HilSensor build() {
      return new HilSensor(timeUsec, xacc, yacc, zacc, xgyro, ygyro, zgyro, xmag, ymag, zmag, absPressure, diffPressure, pressureAlt, temperature, fieldsUpdated);
    }
  }
}
