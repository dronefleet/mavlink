package io.dronefleet.mavlink.ardupilotmega;

import io.dronefleet.mavlink.annotations.MavlinkMessage;
import io.dronefleet.mavlink.annotations.MavlinkMessageField;

/**
 * state of APM memory 
 */
@MavlinkMessage(
    id = 152,
    crc = 208
)
public final class Meminfo {
  private final int brkval;

  private final int freemem;

  private final long freemem32;

  private Meminfo(int brkval, int freemem, long freemem32) {
    this.brkval = brkval;
    this.freemem = freemem;
    this.freemem32 = freemem32;
  }

  public static Builder builder() {
    return new Builder();
  }

  /**
   * heap top 
   */
  @MavlinkMessageField(
      position = 1,
      length = 2
  )
  public final int brkval() {
    return brkval;
  }

  /**
   * free memory 
   */
  @MavlinkMessageField(
      position = 2,
      length = 2
  )
  public final int freemem() {
    return freemem;
  }

  /**
   * free memory (32 bit) 
   */
  @MavlinkMessageField(
      position = 4,
      length = 4,
      extension = true
  )
  public final long freemem32() {
    return freemem32;
  }

  public class Builder {
    private int brkval;

    private int freemem;

    private long freemem32;

    private Builder() {
    }

    /**
     * heap top 
     */
    @MavlinkMessageField(
        position = 1,
        length = 2
    )
    public final Builder brkval(int brkval) {
      this.brkval = brkval;
      return this;
    }

    /**
     * free memory 
     */
    @MavlinkMessageField(
        position = 2,
        length = 2
    )
    public final Builder freemem(int freemem) {
      this.freemem = freemem;
      return this;
    }

    /**
     * free memory (32 bit) 
     */
    @MavlinkMessageField(
        position = 4,
        length = 4,
        extension = true
    )
    public final Builder freemem32(long freemem32) {
      this.freemem32 = freemem32;
      return this;
    }

    public final Meminfo build() {
      return new Meminfo(brkval, freemem, freemem32);
    }
  }
}
