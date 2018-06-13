package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkMessage;
import io.dronefleet.mavlink.annotations.MavlinkMessageField;
import java.math.BigInteger;

/**
 * The RAW IMU readings for the usual 9DOF sensor setup. This message should always contain the 
 * true raw values without any scaling to allow data capture and system debugging. 
 */
@MavlinkMessage(
    id = 27,
    crc = 144
)
public final class RawImu {
  /**
   * Timestamp (microseconds since UNIX epoch or microseconds since system boot) 
   */
  private final BigInteger timeUsec;

  /**
   * X acceleration (raw) 
   */
  private final int xacc;

  /**
   * Y acceleration (raw) 
   */
  private final int yacc;

  /**
   * Z acceleration (raw) 
   */
  private final int zacc;

  /**
   * Angular speed around X axis (raw) 
   */
  private final int xgyro;

  /**
   * Angular speed around Y axis (raw) 
   */
  private final int ygyro;

  /**
   * Angular speed around Z axis (raw) 
   */
  private final int zgyro;

  /**
   * X Magnetic field (raw) 
   */
  private final int xmag;

  /**
   * Y Magnetic field (raw) 
   */
  private final int ymag;

  /**
   * Z Magnetic field (raw) 
   */
  private final int zmag;

  private RawImu(BigInteger timeUsec, int xacc, int yacc, int zacc, int xgyro, int ygyro, int zgyro,
      int xmag, int ymag, int zmag) {
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
  }

  public static Builder builder() {
    return new Builder();
  }

  /**
   * Timestamp (microseconds since UNIX epoch or microseconds since system boot) 
   */
  @MavlinkMessageField(
      position = 1,
      length = 8
  )
  public final BigInteger timeUsec() {
    return timeUsec;
  }

  /**
   * X acceleration (raw) 
   */
  @MavlinkMessageField(
      position = 2,
      length = 2
  )
  public final int xacc() {
    return xacc;
  }

  /**
   * Y acceleration (raw) 
   */
  @MavlinkMessageField(
      position = 3,
      length = 2
  )
  public final int yacc() {
    return yacc;
  }

  /**
   * Z acceleration (raw) 
   */
  @MavlinkMessageField(
      position = 4,
      length = 2
  )
  public final int zacc() {
    return zacc;
  }

  /**
   * Angular speed around X axis (raw) 
   */
  @MavlinkMessageField(
      position = 5,
      length = 2
  )
  public final int xgyro() {
    return xgyro;
  }

  /**
   * Angular speed around Y axis (raw) 
   */
  @MavlinkMessageField(
      position = 6,
      length = 2
  )
  public final int ygyro() {
    return ygyro;
  }

  /**
   * Angular speed around Z axis (raw) 
   */
  @MavlinkMessageField(
      position = 7,
      length = 2
  )
  public final int zgyro() {
    return zgyro;
  }

  /**
   * X Magnetic field (raw) 
   */
  @MavlinkMessageField(
      position = 8,
      length = 2
  )
  public final int xmag() {
    return xmag;
  }

  /**
   * Y Magnetic field (raw) 
   */
  @MavlinkMessageField(
      position = 9,
      length = 2
  )
  public final int ymag() {
    return ymag;
  }

  /**
   * Z Magnetic field (raw) 
   */
  @MavlinkMessageField(
      position = 10,
      length = 2
  )
  public final int zmag() {
    return zmag;
  }

  public static class Builder {
    private BigInteger timeUsec;

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
     * Timestamp (microseconds since UNIX epoch or microseconds since system boot) 
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
     * X acceleration (raw) 
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
     * Y acceleration (raw) 
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
     * Z acceleration (raw) 
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
     * Angular speed around X axis (raw) 
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
     * Angular speed around Y axis (raw) 
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
     * Angular speed around Z axis (raw) 
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
     * X Magnetic field (raw) 
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
     * Y Magnetic field (raw) 
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
     * Z Magnetic field (raw) 
     */
    @MavlinkMessageField(
        position = 10,
        length = 2
    )
    public final Builder zmag(int zmag) {
      this.zmag = zmag;
      return this;
    }

    public final RawImu build() {
      return new RawImu(timeUsec, xacc, yacc, zacc, xgyro, ygyro, zgyro, xmag, ymag, zmag);
    }
  }
}
