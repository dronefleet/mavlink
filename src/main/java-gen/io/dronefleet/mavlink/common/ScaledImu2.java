package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import java.lang.Override;
import java.lang.String;

/**
 * The RAW IMU readings for secondary 9DOF sensor setup. This message should contain the scaled 
 * values to the described units 
 */
@MavlinkMessageInfo(
    id = 116,
    crc = 76
)
public final class ScaledImu2 {
  /**
   * Timestamp (milliseconds since system boot) 
   */
  private final long timeBootMs;

  /**
   * X acceleration (mg) 
   */
  private final int xacc;

  /**
   * Y acceleration (mg) 
   */
  private final int yacc;

  /**
   * Z acceleration (mg) 
   */
  private final int zacc;

  /**
   * Angular speed around X axis (millirad /sec) 
   */
  private final int xgyro;

  /**
   * Angular speed around Y axis (millirad /sec) 
   */
  private final int ygyro;

  /**
   * Angular speed around Z axis (millirad /sec) 
   */
  private final int zgyro;

  /**
   * X Magnetic field (milli tesla) 
   */
  private final int xmag;

  /**
   * Y Magnetic field (milli tesla) 
   */
  private final int ymag;

  /**
   * Z Magnetic field (milli tesla) 
   */
  private final int zmag;

  private ScaledImu2(long timeBootMs, int xacc, int yacc, int zacc, int xgyro, int ygyro, int zgyro,
      int xmag, int ymag, int zmag) {
    this.timeBootMs = timeBootMs;
    this.xacc = xacc;
    this.yacc = yacc;
    this.zacc = zacc;
    this.xgyro = xgyro;
    this.ygyro = ygyro;
    this.zgyro = zgyro;
    this.xmag = xmag;
    this.ymag = ymag;
    this.zmag = zmag;
  }

  @MavlinkMessageBuilder
  public static Builder builder() {
    return new Builder();
  }

  @Override
  public String toString() {
    return "ScaledImu2{timeBootMs=" + timeBootMs
         + ", xacc=" + xacc
         + ", yacc=" + yacc
         + ", zacc=" + zacc
         + ", xgyro=" + xgyro
         + ", ygyro=" + ygyro
         + ", zgyro=" + zgyro
         + ", xmag=" + xmag
         + ", ymag=" + ymag
         + ", zmag=" + zmag + "}";
  }

  /**
   * Timestamp (milliseconds since system boot) 
   */
  @MavlinkFieldInfo(
      position = 1,
      unitSize = 4
  )
  public final long timeBootMs() {
    return timeBootMs;
  }

  /**
   * X acceleration (mg) 
   */
  @MavlinkFieldInfo(
      position = 2,
      unitSize = 2
  )
  public final int xacc() {
    return xacc;
  }

  /**
   * Y acceleration (mg) 
   */
  @MavlinkFieldInfo(
      position = 3,
      unitSize = 2
  )
  public final int yacc() {
    return yacc;
  }

  /**
   * Z acceleration (mg) 
   */
  @MavlinkFieldInfo(
      position = 4,
      unitSize = 2
  )
  public final int zacc() {
    return zacc;
  }

  /**
   * Angular speed around X axis (millirad /sec) 
   */
  @MavlinkFieldInfo(
      position = 5,
      unitSize = 2
  )
  public final int xgyro() {
    return xgyro;
  }

  /**
   * Angular speed around Y axis (millirad /sec) 
   */
  @MavlinkFieldInfo(
      position = 6,
      unitSize = 2
  )
  public final int ygyro() {
    return ygyro;
  }

  /**
   * Angular speed around Z axis (millirad /sec) 
   */
  @MavlinkFieldInfo(
      position = 7,
      unitSize = 2
  )
  public final int zgyro() {
    return zgyro;
  }

  /**
   * X Magnetic field (milli tesla) 
   */
  @MavlinkFieldInfo(
      position = 8,
      unitSize = 2
  )
  public final int xmag() {
    return xmag;
  }

  /**
   * Y Magnetic field (milli tesla) 
   */
  @MavlinkFieldInfo(
      position = 9,
      unitSize = 2
  )
  public final int ymag() {
    return ymag;
  }

  /**
   * Z Magnetic field (milli tesla) 
   */
  @MavlinkFieldInfo(
      position = 10,
      unitSize = 2
  )
  public final int zmag() {
    return zmag;
  }

  public static class Builder {
    private long timeBootMs;

    private int xacc;

    private int yacc;

    private int zacc;

    private int xgyro;

    private int ygyro;

    private int zgyro;

    private int xmag;

    private int ymag;

    private int zmag;

    private Builder() {
    }

    /**
     * Timestamp (milliseconds since system boot) 
     */
    @MavlinkFieldInfo(
        position = 1,
        unitSize = 4
    )
    public final Builder timeBootMs(long timeBootMs) {
      this.timeBootMs = timeBootMs;
      return this;
    }

    /**
     * X acceleration (mg) 
     */
    @MavlinkFieldInfo(
        position = 2,
        unitSize = 2
    )
    public final Builder xacc(int xacc) {
      this.xacc = xacc;
      return this;
    }

    /**
     * Y acceleration (mg) 
     */
    @MavlinkFieldInfo(
        position = 3,
        unitSize = 2
    )
    public final Builder yacc(int yacc) {
      this.yacc = yacc;
      return this;
    }

    /**
     * Z acceleration (mg) 
     */
    @MavlinkFieldInfo(
        position = 4,
        unitSize = 2
    )
    public final Builder zacc(int zacc) {
      this.zacc = zacc;
      return this;
    }

    /**
     * Angular speed around X axis (millirad /sec) 
     */
    @MavlinkFieldInfo(
        position = 5,
        unitSize = 2
    )
    public final Builder xgyro(int xgyro) {
      this.xgyro = xgyro;
      return this;
    }

    /**
     * Angular speed around Y axis (millirad /sec) 
     */
    @MavlinkFieldInfo(
        position = 6,
        unitSize = 2
    )
    public final Builder ygyro(int ygyro) {
      this.ygyro = ygyro;
      return this;
    }

    /**
     * Angular speed around Z axis (millirad /sec) 
     */
    @MavlinkFieldInfo(
        position = 7,
        unitSize = 2
    )
    public final Builder zgyro(int zgyro) {
      this.zgyro = zgyro;
      return this;
    }

    /**
     * X Magnetic field (milli tesla) 
     */
    @MavlinkFieldInfo(
        position = 8,
        unitSize = 2
    )
    public final Builder xmag(int xmag) {
      this.xmag = xmag;
      return this;
    }

    /**
     * Y Magnetic field (milli tesla) 
     */
    @MavlinkFieldInfo(
        position = 9,
        unitSize = 2
    )
    public final Builder ymag(int ymag) {
      this.ymag = ymag;
      return this;
    }

    /**
     * Z Magnetic field (milli tesla) 
     */
    @MavlinkFieldInfo(
        position = 10,
        unitSize = 2
    )
    public final Builder zmag(int zmag) {
      this.zmag = zmag;
      return this;
    }

    public final ScaledImu2 build() {
      return new ScaledImu2(timeBootMs, xacc, yacc, zacc, xgyro, ygyro, zgyro, xmag, ymag, zmag);
    }
  }
}
