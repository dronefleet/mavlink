package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkMessage;
import io.dronefleet.mavlink.annotations.MavlinkMessageField;

/**
 * The RAW IMU readings for the usual 9DOF sensor setup. This message should contain the scaled 
 * values to the described units 
 */
@MavlinkMessage(
    id = 26,
    crc = 170
)
public final class ScaledImu {
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

  private ScaledImu(long timeBootMs, int xacc, int yacc, int zacc, int xgyro, int ygyro, int zgyro,
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

  public static Builder builder() {
    return new Builder();
  }

  /**
   * Timestamp (milliseconds since system boot) 
   */
  @MavlinkMessageField(
      position = 1,
      length = 4
  )
  public final long timeBootMs() {
    return timeBootMs;
  }

  /**
   * X acceleration (mg) 
   */
  @MavlinkMessageField(
      position = 2,
      length = 2
  )
  public final int xacc() {
    return xacc;
  }

  /**
   * Y acceleration (mg) 
   */
  @MavlinkMessageField(
      position = 3,
      length = 2
  )
  public final int yacc() {
    return yacc;
  }

  /**
   * Z acceleration (mg) 
   */
  @MavlinkMessageField(
      position = 4,
      length = 2
  )
  public final int zacc() {
    return zacc;
  }

  /**
   * Angular speed around X axis (millirad /sec) 
   */
  @MavlinkMessageField(
      position = 5,
      length = 2
  )
  public final int xgyro() {
    return xgyro;
  }

  /**
   * Angular speed around Y axis (millirad /sec) 
   */
  @MavlinkMessageField(
      position = 6,
      length = 2
  )
  public final int ygyro() {
    return ygyro;
  }

  /**
   * Angular speed around Z axis (millirad /sec) 
   */
  @MavlinkMessageField(
      position = 7,
      length = 2
  )
  public final int zgyro() {
    return zgyro;
  }

  /**
   * X Magnetic field (milli tesla) 
   */
  @MavlinkMessageField(
      position = 8,
      length = 2
  )
  public final int xmag() {
    return xmag;
  }

  /**
   * Y Magnetic field (milli tesla) 
   */
  @MavlinkMessageField(
      position = 9,
      length = 2
  )
  public final int ymag() {
    return ymag;
  }

  /**
   * Z Magnetic field (milli tesla) 
   */
  @MavlinkMessageField(
      position = 10,
      length = 2
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
    @MavlinkMessageField(
        position = 1,
        length = 4
    )
    public final Builder timeBootMs(long timeBootMs) {
      this.timeBootMs = timeBootMs;
      return this;
    }

    /**
     * X acceleration (mg) 
     */
    @MavlinkMessageField(
        position = 2,
        length = 2
    )
    public final Builder xacc(int xacc) {
      this.xacc = xacc;
      return this;
    }

    /**
     * Y acceleration (mg) 
     */
    @MavlinkMessageField(
        position = 3,
        length = 2
    )
    public final Builder yacc(int yacc) {
      this.yacc = yacc;
      return this;
    }

    /**
     * Z acceleration (mg) 
     */
    @MavlinkMessageField(
        position = 4,
        length = 2
    )
    public final Builder zacc(int zacc) {
      this.zacc = zacc;
      return this;
    }

    /**
     * Angular speed around X axis (millirad /sec) 
     */
    @MavlinkMessageField(
        position = 5,
        length = 2
    )
    public final Builder xgyro(int xgyro) {
      this.xgyro = xgyro;
      return this;
    }

    /**
     * Angular speed around Y axis (millirad /sec) 
     */
    @MavlinkMessageField(
        position = 6,
        length = 2
    )
    public final Builder ygyro(int ygyro) {
      this.ygyro = ygyro;
      return this;
    }

    /**
     * Angular speed around Z axis (millirad /sec) 
     */
    @MavlinkMessageField(
        position = 7,
        length = 2
    )
    public final Builder zgyro(int zgyro) {
      this.zgyro = zgyro;
      return this;
    }

    /**
     * X Magnetic field (milli tesla) 
     */
    @MavlinkMessageField(
        position = 8,
        length = 2
    )
    public final Builder xmag(int xmag) {
      this.xmag = xmag;
      return this;
    }

    /**
     * Y Magnetic field (milli tesla) 
     */
    @MavlinkMessageField(
        position = 9,
        length = 2
    )
    public final Builder ymag(int ymag) {
      this.ymag = ymag;
      return this;
    }

    /**
     * Z Magnetic field (milli tesla) 
     */
    @MavlinkMessageField(
        position = 10,
        length = 2
    )
    public final Builder zmag(int zmag) {
      this.zmag = zmag;
      return this;
    }

    public final ScaledImu build() {
      return new ScaledImu(timeBootMs, xacc, yacc, zacc, xgyro, ygyro, zgyro, xmag, ymag, zmag);
    }
  }
}
