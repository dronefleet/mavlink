package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkMessage;
import io.dronefleet.mavlink.annotations.MavlinkMessageField;

/**
 * The RAW values of the servo outputs (for RC input from the remote, use the RC_CHANNELS 
 * messages). The standard PPM modulation is as follows: 1000 microseconds: 0%, 2000 
 * microseconds: 100%. 
 */
@MavlinkMessage(
    id = 36,
    crc = 222
)
public final class ServoOutputRaw {
  private final long timeUsec;

  private final int port;

  private final int servo1Raw;

  private final int servo2Raw;

  private final int servo3Raw;

  private final int servo4Raw;

  private final int servo5Raw;

  private final int servo6Raw;

  private final int servo7Raw;

  private final int servo8Raw;

  private final int servo9Raw;

  private final int servo10Raw;

  private final int servo11Raw;

  private final int servo12Raw;

  private final int servo13Raw;

  private final int servo14Raw;

  private final int servo15Raw;

  private final int servo16Raw;

  private ServoOutputRaw(long timeUsec, int port, int servo1Raw, int servo2Raw, int servo3Raw,
      int servo4Raw, int servo5Raw, int servo6Raw, int servo7Raw, int servo8Raw, int servo9Raw,
      int servo10Raw, int servo11Raw, int servo12Raw, int servo13Raw, int servo14Raw,
      int servo15Raw, int servo16Raw) {
    this.timeUsec = timeUsec;
    this.port = port;
    this.servo1Raw = servo1Raw;
    this.servo2Raw = servo2Raw;
    this.servo3Raw = servo3Raw;
    this.servo4Raw = servo4Raw;
    this.servo5Raw = servo5Raw;
    this.servo6Raw = servo6Raw;
    this.servo7Raw = servo7Raw;
    this.servo8Raw = servo8Raw;
    this.servo9Raw = servo9Raw;
    this.servo10Raw = servo10Raw;
    this.servo11Raw = servo11Raw;
    this.servo12Raw = servo12Raw;
    this.servo13Raw = servo13Raw;
    this.servo14Raw = servo14Raw;
    this.servo15Raw = servo15Raw;
    this.servo16Raw = servo16Raw;
  }

  public static Builder builder() {
    return new Builder();
  }

  /**
   * Timestamp (microseconds since system boot) 
   */
  @MavlinkMessageField(
      position = 1,
      length = 4
  )
  public final long timeUsec() {
    return timeUsec;
  }

  /**
   * Servo output port (set of 8 outputs = 1 port). Most MAVs will just use one, but this allows to 
   * encode more than 8 servos. 
   */
  @MavlinkMessageField(
      position = 2,
      length = 1
  )
  public final int port() {
    return port;
  }

  /**
   * Servo output 1 value, in microseconds 
   */
  @MavlinkMessageField(
      position = 3,
      length = 2
  )
  public final int servo1Raw() {
    return servo1Raw;
  }

  /**
   * Servo output 2 value, in microseconds 
   */
  @MavlinkMessageField(
      position = 4,
      length = 2
  )
  public final int servo2Raw() {
    return servo2Raw;
  }

  /**
   * Servo output 3 value, in microseconds 
   */
  @MavlinkMessageField(
      position = 5,
      length = 2
  )
  public final int servo3Raw() {
    return servo3Raw;
  }

  /**
   * Servo output 4 value, in microseconds 
   */
  @MavlinkMessageField(
      position = 6,
      length = 2
  )
  public final int servo4Raw() {
    return servo4Raw;
  }

  /**
   * Servo output 5 value, in microseconds 
   */
  @MavlinkMessageField(
      position = 7,
      length = 2
  )
  public final int servo5Raw() {
    return servo5Raw;
  }

  /**
   * Servo output 6 value, in microseconds 
   */
  @MavlinkMessageField(
      position = 8,
      length = 2
  )
  public final int servo6Raw() {
    return servo6Raw;
  }

  /**
   * Servo output 7 value, in microseconds 
   */
  @MavlinkMessageField(
      position = 9,
      length = 2
  )
  public final int servo7Raw() {
    return servo7Raw;
  }

  /**
   * Servo output 8 value, in microseconds 
   */
  @MavlinkMessageField(
      position = 10,
      length = 2
  )
  public final int servo8Raw() {
    return servo8Raw;
  }

  /**
   * Servo output 9 value, in microseconds 
   */
  @MavlinkMessageField(
      position = 12,
      length = 2,
      extension = true
  )
  public final int servo9Raw() {
    return servo9Raw;
  }

  /**
   * Servo output 10 value, in microseconds 
   */
  @MavlinkMessageField(
      position = 13,
      length = 2,
      extension = true
  )
  public final int servo10Raw() {
    return servo10Raw;
  }

  /**
   * Servo output 11 value, in microseconds 
   */
  @MavlinkMessageField(
      position = 14,
      length = 2,
      extension = true
  )
  public final int servo11Raw() {
    return servo11Raw;
  }

  /**
   * Servo output 12 value, in microseconds 
   */
  @MavlinkMessageField(
      position = 15,
      length = 2,
      extension = true
  )
  public final int servo12Raw() {
    return servo12Raw;
  }

  /**
   * Servo output 13 value, in microseconds 
   */
  @MavlinkMessageField(
      position = 16,
      length = 2,
      extension = true
  )
  public final int servo13Raw() {
    return servo13Raw;
  }

  /**
   * Servo output 14 value, in microseconds 
   */
  @MavlinkMessageField(
      position = 17,
      length = 2,
      extension = true
  )
  public final int servo14Raw() {
    return servo14Raw;
  }

  /**
   * Servo output 15 value, in microseconds 
   */
  @MavlinkMessageField(
      position = 18,
      length = 2,
      extension = true
  )
  public final int servo15Raw() {
    return servo15Raw;
  }

  /**
   * Servo output 16 value, in microseconds 
   */
  @MavlinkMessageField(
      position = 19,
      length = 2,
      extension = true
  )
  public final int servo16Raw() {
    return servo16Raw;
  }

  public class Builder {
    private long timeUsec;

    private int port;

    private int servo1Raw;

    private int servo2Raw;

    private int servo3Raw;

    private int servo4Raw;

    private int servo5Raw;

    private int servo6Raw;

    private int servo7Raw;

    private int servo8Raw;

    private int servo9Raw;

    private int servo10Raw;

    private int servo11Raw;

    private int servo12Raw;

    private int servo13Raw;

    private int servo14Raw;

    private int servo15Raw;

    private int servo16Raw;

    private Builder() {
    }

    /**
     * Timestamp (microseconds since system boot) 
     */
    @MavlinkMessageField(
        position = 1,
        length = 4
    )
    public final Builder timeUsec(long timeUsec) {
      this.timeUsec = timeUsec;
      return this;
    }

    /**
     * Servo output port (set of 8 outputs = 1 port). Most MAVs will just use one, but this allows to 
     * encode more than 8 servos. 
     */
    @MavlinkMessageField(
        position = 2,
        length = 1
    )
    public final Builder port(int port) {
      this.port = port;
      return this;
    }

    /**
     * Servo output 1 value, in microseconds 
     */
    @MavlinkMessageField(
        position = 3,
        length = 2
    )
    public final Builder servo1Raw(int servo1Raw) {
      this.servo1Raw = servo1Raw;
      return this;
    }

    /**
     * Servo output 2 value, in microseconds 
     */
    @MavlinkMessageField(
        position = 4,
        length = 2
    )
    public final Builder servo2Raw(int servo2Raw) {
      this.servo2Raw = servo2Raw;
      return this;
    }

    /**
     * Servo output 3 value, in microseconds 
     */
    @MavlinkMessageField(
        position = 5,
        length = 2
    )
    public final Builder servo3Raw(int servo3Raw) {
      this.servo3Raw = servo3Raw;
      return this;
    }

    /**
     * Servo output 4 value, in microseconds 
     */
    @MavlinkMessageField(
        position = 6,
        length = 2
    )
    public final Builder servo4Raw(int servo4Raw) {
      this.servo4Raw = servo4Raw;
      return this;
    }

    /**
     * Servo output 5 value, in microseconds 
     */
    @MavlinkMessageField(
        position = 7,
        length = 2
    )
    public final Builder servo5Raw(int servo5Raw) {
      this.servo5Raw = servo5Raw;
      return this;
    }

    /**
     * Servo output 6 value, in microseconds 
     */
    @MavlinkMessageField(
        position = 8,
        length = 2
    )
    public final Builder servo6Raw(int servo6Raw) {
      this.servo6Raw = servo6Raw;
      return this;
    }

    /**
     * Servo output 7 value, in microseconds 
     */
    @MavlinkMessageField(
        position = 9,
        length = 2
    )
    public final Builder servo7Raw(int servo7Raw) {
      this.servo7Raw = servo7Raw;
      return this;
    }

    /**
     * Servo output 8 value, in microseconds 
     */
    @MavlinkMessageField(
        position = 10,
        length = 2
    )
    public final Builder servo8Raw(int servo8Raw) {
      this.servo8Raw = servo8Raw;
      return this;
    }

    /**
     * Servo output 9 value, in microseconds 
     */
    @MavlinkMessageField(
        position = 12,
        length = 2,
        extension = true
    )
    public final Builder servo9Raw(int servo9Raw) {
      this.servo9Raw = servo9Raw;
      return this;
    }

    /**
     * Servo output 10 value, in microseconds 
     */
    @MavlinkMessageField(
        position = 13,
        length = 2,
        extension = true
    )
    public final Builder servo10Raw(int servo10Raw) {
      this.servo10Raw = servo10Raw;
      return this;
    }

    /**
     * Servo output 11 value, in microseconds 
     */
    @MavlinkMessageField(
        position = 14,
        length = 2,
        extension = true
    )
    public final Builder servo11Raw(int servo11Raw) {
      this.servo11Raw = servo11Raw;
      return this;
    }

    /**
     * Servo output 12 value, in microseconds 
     */
    @MavlinkMessageField(
        position = 15,
        length = 2,
        extension = true
    )
    public final Builder servo12Raw(int servo12Raw) {
      this.servo12Raw = servo12Raw;
      return this;
    }

    /**
     * Servo output 13 value, in microseconds 
     */
    @MavlinkMessageField(
        position = 16,
        length = 2,
        extension = true
    )
    public final Builder servo13Raw(int servo13Raw) {
      this.servo13Raw = servo13Raw;
      return this;
    }

    /**
     * Servo output 14 value, in microseconds 
     */
    @MavlinkMessageField(
        position = 17,
        length = 2,
        extension = true
    )
    public final Builder servo14Raw(int servo14Raw) {
      this.servo14Raw = servo14Raw;
      return this;
    }

    /**
     * Servo output 15 value, in microseconds 
     */
    @MavlinkMessageField(
        position = 18,
        length = 2,
        extension = true
    )
    public final Builder servo15Raw(int servo15Raw) {
      this.servo15Raw = servo15Raw;
      return this;
    }

    /**
     * Servo output 16 value, in microseconds 
     */
    @MavlinkMessageField(
        position = 19,
        length = 2,
        extension = true
    )
    public final Builder servo16Raw(int servo16Raw) {
      this.servo16Raw = servo16Raw;
      return this;
    }

    public final ServoOutputRaw build() {
      return new ServoOutputRaw(timeUsec, port, servo1Raw, servo2Raw, servo3Raw, servo4Raw, servo5Raw, servo6Raw, servo7Raw, servo8Raw, servo9Raw, servo10Raw, servo11Raw, servo12Raw, servo13Raw, servo14Raw, servo15Raw, servo16Raw);
    }
  }
}
