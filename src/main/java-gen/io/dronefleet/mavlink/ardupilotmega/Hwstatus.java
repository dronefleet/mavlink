package io.dronefleet.mavlink.ardupilotmega;

import io.dronefleet.mavlink.annotations.MavlinkMessage;
import io.dronefleet.mavlink.annotations.MavlinkMessageField;

/**
 * Status of key hardware 
 */
@MavlinkMessage(
    id = 165,
    crc = 21
)
public final class Hwstatus {
  /**
   * board voltage (mV) 
   */
  private final int vcc;

  /**
   * I2C error count 
   */
  private final int i2cerr;

  private Hwstatus(int vcc, int i2cerr) {
    this.vcc = vcc;
    this.i2cerr = i2cerr;
  }

  public static Builder builder() {
    return new Builder();
  }

  /**
   * board voltage (mV) 
   */
  @MavlinkMessageField(
      position = 1,
      length = 2
  )
  public final int vcc() {
    return vcc;
  }

  /**
   * I2C error count 
   */
  @MavlinkMessageField(
      position = 2,
      length = 1
  )
  public final int i2cerr() {
    return i2cerr;
  }

  public static class Builder {
    private int vcc;

    private int i2cerr;

    private Builder() {
    }

    /**
     * board voltage (mV) 
     */
    @MavlinkMessageField(
        position = 1,
        length = 2
    )
    public final Builder vcc(int vcc) {
      this.vcc = vcc;
      return this;
    }

    /**
     * I2C error count 
     */
    @MavlinkMessageField(
        position = 2,
        length = 1
    )
    public final Builder i2cerr(int i2cerr) {
      this.i2cerr = i2cerr;
      return this;
    }

    public final Hwstatus build() {
      return new Hwstatus(vcc, i2cerr);
    }
  }
}
