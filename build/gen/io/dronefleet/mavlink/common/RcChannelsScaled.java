package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkMessage;
import io.dronefleet.mavlink.annotations.MavlinkMessageField;

/**
 * The scaled values of the RC channels received. (-100%) -10000, (0%) 0, (100%) 10000. Channels 
 * that are inactive should be set to UINT16_MAX. 
 */
@MavlinkMessage(
    id = 34,
    crc = 237
)
public final class RcChannelsScaled {
  private final long timeBootMs;

  private final int port;

  private final int chan1Scaled;

  private final int chan2Scaled;

  private final int chan3Scaled;

  private final int chan4Scaled;

  private final int chan5Scaled;

  private final int chan6Scaled;

  private final int chan7Scaled;

  private final int chan8Scaled;

  private final int rssi;

  private RcChannelsScaled(long timeBootMs, int port, int chan1Scaled, int chan2Scaled,
      int chan3Scaled, int chan4Scaled, int chan5Scaled, int chan6Scaled, int chan7Scaled,
      int chan8Scaled, int rssi) {
    this.timeBootMs = timeBootMs;
    this.port = port;
    this.chan1Scaled = chan1Scaled;
    this.chan2Scaled = chan2Scaled;
    this.chan3Scaled = chan3Scaled;
    this.chan4Scaled = chan4Scaled;
    this.chan5Scaled = chan5Scaled;
    this.chan6Scaled = chan6Scaled;
    this.chan7Scaled = chan7Scaled;
    this.chan8Scaled = chan8Scaled;
    this.rssi = rssi;
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
   * Servo output port (set of 8 outputs = 1 port). Most MAVs will just use one, but this allows for more 
   * than 8 servos. 
   */
  @MavlinkMessageField(
      position = 2,
      length = 1
  )
  public final int port() {
    return port;
  }

  /**
   * RC channel 1 value scaled, (-100%) -10000, (0%) 0, (100%) 10000, (invalid) INT16_MAX. 
   */
  @MavlinkMessageField(
      position = 3,
      length = 2
  )
  public final int chan1Scaled() {
    return chan1Scaled;
  }

  /**
   * RC channel 2 value scaled, (-100%) -10000, (0%) 0, (100%) 10000, (invalid) INT16_MAX. 
   */
  @MavlinkMessageField(
      position = 4,
      length = 2
  )
  public final int chan2Scaled() {
    return chan2Scaled;
  }

  /**
   * RC channel 3 value scaled, (-100%) -10000, (0%) 0, (100%) 10000, (invalid) INT16_MAX. 
   */
  @MavlinkMessageField(
      position = 5,
      length = 2
  )
  public final int chan3Scaled() {
    return chan3Scaled;
  }

  /**
   * RC channel 4 value scaled, (-100%) -10000, (0%) 0, (100%) 10000, (invalid) INT16_MAX. 
   */
  @MavlinkMessageField(
      position = 6,
      length = 2
  )
  public final int chan4Scaled() {
    return chan4Scaled;
  }

  /**
   * RC channel 5 value scaled, (-100%) -10000, (0%) 0, (100%) 10000, (invalid) INT16_MAX. 
   */
  @MavlinkMessageField(
      position = 7,
      length = 2
  )
  public final int chan5Scaled() {
    return chan5Scaled;
  }

  /**
   * RC channel 6 value scaled, (-100%) -10000, (0%) 0, (100%) 10000, (invalid) INT16_MAX. 
   */
  @MavlinkMessageField(
      position = 8,
      length = 2
  )
  public final int chan6Scaled() {
    return chan6Scaled;
  }

  /**
   * RC channel 7 value scaled, (-100%) -10000, (0%) 0, (100%) 10000, (invalid) INT16_MAX. 
   */
  @MavlinkMessageField(
      position = 9,
      length = 2
  )
  public final int chan7Scaled() {
    return chan7Scaled;
  }

  /**
   * RC channel 8 value scaled, (-100%) -10000, (0%) 0, (100%) 10000, (invalid) INT16_MAX. 
   */
  @MavlinkMessageField(
      position = 10,
      length = 2
  )
  public final int chan8Scaled() {
    return chan8Scaled;
  }

  /**
   * Receive signal strength indicator, 0: 0%, 100: 100%, 255: invalid/unknown. 
   */
  @MavlinkMessageField(
      position = 11,
      length = 1
  )
  public final int rssi() {
    return rssi;
  }

  public class Builder {
    private long timeBootMs;

    private int port;

    private int chan1Scaled;

    private int chan2Scaled;

    private int chan3Scaled;

    private int chan4Scaled;

    private int chan5Scaled;

    private int chan6Scaled;

    private int chan7Scaled;

    private int chan8Scaled;

    private int rssi;

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
     * Servo output port (set of 8 outputs = 1 port). Most MAVs will just use one, but this allows for more 
     * than 8 servos. 
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
     * RC channel 1 value scaled, (-100%) -10000, (0%) 0, (100%) 10000, (invalid) INT16_MAX. 
     */
    @MavlinkMessageField(
        position = 3,
        length = 2
    )
    public final Builder chan1Scaled(int chan1Scaled) {
      this.chan1Scaled = chan1Scaled;
      return this;
    }

    /**
     * RC channel 2 value scaled, (-100%) -10000, (0%) 0, (100%) 10000, (invalid) INT16_MAX. 
     */
    @MavlinkMessageField(
        position = 4,
        length = 2
    )
    public final Builder chan2Scaled(int chan2Scaled) {
      this.chan2Scaled = chan2Scaled;
      return this;
    }

    /**
     * RC channel 3 value scaled, (-100%) -10000, (0%) 0, (100%) 10000, (invalid) INT16_MAX. 
     */
    @MavlinkMessageField(
        position = 5,
        length = 2
    )
    public final Builder chan3Scaled(int chan3Scaled) {
      this.chan3Scaled = chan3Scaled;
      return this;
    }

    /**
     * RC channel 4 value scaled, (-100%) -10000, (0%) 0, (100%) 10000, (invalid) INT16_MAX. 
     */
    @MavlinkMessageField(
        position = 6,
        length = 2
    )
    public final Builder chan4Scaled(int chan4Scaled) {
      this.chan4Scaled = chan4Scaled;
      return this;
    }

    /**
     * RC channel 5 value scaled, (-100%) -10000, (0%) 0, (100%) 10000, (invalid) INT16_MAX. 
     */
    @MavlinkMessageField(
        position = 7,
        length = 2
    )
    public final Builder chan5Scaled(int chan5Scaled) {
      this.chan5Scaled = chan5Scaled;
      return this;
    }

    /**
     * RC channel 6 value scaled, (-100%) -10000, (0%) 0, (100%) 10000, (invalid) INT16_MAX. 
     */
    @MavlinkMessageField(
        position = 8,
        length = 2
    )
    public final Builder chan6Scaled(int chan6Scaled) {
      this.chan6Scaled = chan6Scaled;
      return this;
    }

    /**
     * RC channel 7 value scaled, (-100%) -10000, (0%) 0, (100%) 10000, (invalid) INT16_MAX. 
     */
    @MavlinkMessageField(
        position = 9,
        length = 2
    )
    public final Builder chan7Scaled(int chan7Scaled) {
      this.chan7Scaled = chan7Scaled;
      return this;
    }

    /**
     * RC channel 8 value scaled, (-100%) -10000, (0%) 0, (100%) 10000, (invalid) INT16_MAX. 
     */
    @MavlinkMessageField(
        position = 10,
        length = 2
    )
    public final Builder chan8Scaled(int chan8Scaled) {
      this.chan8Scaled = chan8Scaled;
      return this;
    }

    /**
     * Receive signal strength indicator, 0: 0%, 100: 100%, 255: invalid/unknown. 
     */
    @MavlinkMessageField(
        position = 11,
        length = 1
    )
    public final Builder rssi(int rssi) {
      this.rssi = rssi;
      return this;
    }

    public final RcChannelsScaled build() {
      return new RcChannelsScaled(timeBootMs, port, chan1Scaled, chan2Scaled, chan3Scaled, chan4Scaled, chan5Scaled, chan6Scaled, chan7Scaled, chan8Scaled, rssi);
    }
  }
}
