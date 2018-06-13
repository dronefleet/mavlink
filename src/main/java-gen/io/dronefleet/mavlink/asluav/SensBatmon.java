package io.dronefleet.mavlink.asluav;

import io.dronefleet.mavlink.annotations.MavlinkMessage;
import io.dronefleet.mavlink.annotations.MavlinkMessageField;
import java.math.BigInteger;

/**
 * Battery pack monitoring data for Li-Ion batteries 
 */
@MavlinkMessage(
    id = 209,
    crc = 155
)
public final class SensBatmon {
  /**
   * Time since system start 
   */
  private final BigInteger batmonTimestamp;

  /**
   * Battery pack temperature 
   */
  private final float temperature;

  /**
   * Battery pack voltage 
   */
  private final int voltage;

  /**
   * Battery pack current 
   */
  private final int current;

  /**
   * Battery pack state-of-charge 
   */
  private final int soc;

  /**
   * Battery monitor status report bits in Hex 
   */
  private final int batterystatus;

  /**
   * Battery monitor serial number in Hex 
   */
  private final int serialnumber;

  /**
   * Battery monitor safetystatus report bits in Hex 
   */
  private final long safetystatus;

  /**
   * Battery monitor operation status report bits in Hex 
   */
  private final long operationstatus;

  /**
   * Battery pack cell 1 voltage 
   */
  private final int cellvoltage1;

  /**
   * Battery pack cell 2 voltage 
   */
  private final int cellvoltage2;

  /**
   * Battery pack cell 3 voltage 
   */
  private final int cellvoltage3;

  /**
   * Battery pack cell 4 voltage 
   */
  private final int cellvoltage4;

  /**
   * Battery pack cell 5 voltage 
   */
  private final int cellvoltage5;

  /**
   * Battery pack cell 6 voltage 
   */
  private final int cellvoltage6;

  private SensBatmon(BigInteger batmonTimestamp, float temperature, int voltage, int current,
      int soc, int batterystatus, int serialnumber, long safetystatus, long operationstatus,
      int cellvoltage1, int cellvoltage2, int cellvoltage3, int cellvoltage4, int cellvoltage5,
      int cellvoltage6) {
    this.batmonTimestamp = batmonTimestamp;
    this.temperature = temperature;
    this.voltage = voltage;
    this.current = current;
    this.soc = soc;
    this.batterystatus = batterystatus;
    this.serialnumber = serialnumber;
    this.safetystatus = safetystatus;
    this.operationstatus = operationstatus;
    this.cellvoltage1 = cellvoltage1;
    this.cellvoltage2 = cellvoltage2;
    this.cellvoltage3 = cellvoltage3;
    this.cellvoltage4 = cellvoltage4;
    this.cellvoltage5 = cellvoltage5;
    this.cellvoltage6 = cellvoltage6;
  }

  public static Builder builder() {
    return new Builder();
  }

  /**
   * Time since system start 
   */
  @MavlinkMessageField(
      position = 1,
      length = 8
  )
  public final BigInteger batmonTimestamp() {
    return batmonTimestamp;
  }

  /**
   * Battery pack temperature 
   */
  @MavlinkMessageField(
      position = 2,
      length = 4
  )
  public final float temperature() {
    return temperature;
  }

  /**
   * Battery pack voltage 
   */
  @MavlinkMessageField(
      position = 3,
      length = 2
  )
  public final int voltage() {
    return voltage;
  }

  /**
   * Battery pack current 
   */
  @MavlinkMessageField(
      position = 4,
      length = 2
  )
  public final int current() {
    return current;
  }

  /**
   * Battery pack state-of-charge 
   */
  @MavlinkMessageField(
      position = 5,
      length = 1
  )
  public final int soc() {
    return soc;
  }

  /**
   * Battery monitor status report bits in Hex 
   */
  @MavlinkMessageField(
      position = 6,
      length = 2
  )
  public final int batterystatus() {
    return batterystatus;
  }

  /**
   * Battery monitor serial number in Hex 
   */
  @MavlinkMessageField(
      position = 7,
      length = 2
  )
  public final int serialnumber() {
    return serialnumber;
  }

  /**
   * Battery monitor safetystatus report bits in Hex 
   */
  @MavlinkMessageField(
      position = 8,
      length = 4
  )
  public final long safetystatus() {
    return safetystatus;
  }

  /**
   * Battery monitor operation status report bits in Hex 
   */
  @MavlinkMessageField(
      position = 9,
      length = 4
  )
  public final long operationstatus() {
    return operationstatus;
  }

  /**
   * Battery pack cell 1 voltage 
   */
  @MavlinkMessageField(
      position = 10,
      length = 2
  )
  public final int cellvoltage1() {
    return cellvoltage1;
  }

  /**
   * Battery pack cell 2 voltage 
   */
  @MavlinkMessageField(
      position = 11,
      length = 2
  )
  public final int cellvoltage2() {
    return cellvoltage2;
  }

  /**
   * Battery pack cell 3 voltage 
   */
  @MavlinkMessageField(
      position = 12,
      length = 2
  )
  public final int cellvoltage3() {
    return cellvoltage3;
  }

  /**
   * Battery pack cell 4 voltage 
   */
  @MavlinkMessageField(
      position = 13,
      length = 2
  )
  public final int cellvoltage4() {
    return cellvoltage4;
  }

  /**
   * Battery pack cell 5 voltage 
   */
  @MavlinkMessageField(
      position = 14,
      length = 2
  )
  public final int cellvoltage5() {
    return cellvoltage5;
  }

  /**
   * Battery pack cell 6 voltage 
   */
  @MavlinkMessageField(
      position = 15,
      length = 2
  )
  public final int cellvoltage6() {
    return cellvoltage6;
  }

  public static class Builder {
    private BigInteger batmonTimestamp;

    private float temperature;

    private int voltage;

    private int current;

    private int soc;

    private int batterystatus;

    private int serialnumber;

    private long safetystatus;

    private long operationstatus;

    private int cellvoltage1;

    private int cellvoltage2;

    private int cellvoltage3;

    private int cellvoltage4;

    private int cellvoltage5;

    private int cellvoltage6;

    private Builder() {
    }

    /**
     * Time since system start 
     */
    @MavlinkMessageField(
        position = 1,
        length = 8
    )
    public final Builder batmonTimestamp(BigInteger batmonTimestamp) {
      this.batmonTimestamp = batmonTimestamp;
      return this;
    }

    /**
     * Battery pack temperature 
     */
    @MavlinkMessageField(
        position = 2,
        length = 4
    )
    public final Builder temperature(float temperature) {
      this.temperature = temperature;
      return this;
    }

    /**
     * Battery pack voltage 
     */
    @MavlinkMessageField(
        position = 3,
        length = 2
    )
    public final Builder voltage(int voltage) {
      this.voltage = voltage;
      return this;
    }

    /**
     * Battery pack current 
     */
    @MavlinkMessageField(
        position = 4,
        length = 2
    )
    public final Builder current(int current) {
      this.current = current;
      return this;
    }

    /**
     * Battery pack state-of-charge 
     */
    @MavlinkMessageField(
        position = 5,
        length = 1
    )
    public final Builder soc(int soc) {
      this.soc = soc;
      return this;
    }

    /**
     * Battery monitor status report bits in Hex 
     */
    @MavlinkMessageField(
        position = 6,
        length = 2
    )
    public final Builder batterystatus(int batterystatus) {
      this.batterystatus = batterystatus;
      return this;
    }

    /**
     * Battery monitor serial number in Hex 
     */
    @MavlinkMessageField(
        position = 7,
        length = 2
    )
    public final Builder serialnumber(int serialnumber) {
      this.serialnumber = serialnumber;
      return this;
    }

    /**
     * Battery monitor safetystatus report bits in Hex 
     */
    @MavlinkMessageField(
        position = 8,
        length = 4
    )
    public final Builder safetystatus(long safetystatus) {
      this.safetystatus = safetystatus;
      return this;
    }

    /**
     * Battery monitor operation status report bits in Hex 
     */
    @MavlinkMessageField(
        position = 9,
        length = 4
    )
    public final Builder operationstatus(long operationstatus) {
      this.operationstatus = operationstatus;
      return this;
    }

    /**
     * Battery pack cell 1 voltage 
     */
    @MavlinkMessageField(
        position = 10,
        length = 2
    )
    public final Builder cellvoltage1(int cellvoltage1) {
      this.cellvoltage1 = cellvoltage1;
      return this;
    }

    /**
     * Battery pack cell 2 voltage 
     */
    @MavlinkMessageField(
        position = 11,
        length = 2
    )
    public final Builder cellvoltage2(int cellvoltage2) {
      this.cellvoltage2 = cellvoltage2;
      return this;
    }

    /**
     * Battery pack cell 3 voltage 
     */
    @MavlinkMessageField(
        position = 12,
        length = 2
    )
    public final Builder cellvoltage3(int cellvoltage3) {
      this.cellvoltage3 = cellvoltage3;
      return this;
    }

    /**
     * Battery pack cell 4 voltage 
     */
    @MavlinkMessageField(
        position = 13,
        length = 2
    )
    public final Builder cellvoltage4(int cellvoltage4) {
      this.cellvoltage4 = cellvoltage4;
      return this;
    }

    /**
     * Battery pack cell 5 voltage 
     */
    @MavlinkMessageField(
        position = 14,
        length = 2
    )
    public final Builder cellvoltage5(int cellvoltage5) {
      this.cellvoltage5 = cellvoltage5;
      return this;
    }

    /**
     * Battery pack cell 6 voltage 
     */
    @MavlinkMessageField(
        position = 15,
        length = 2
    )
    public final Builder cellvoltage6(int cellvoltage6) {
      this.cellvoltage6 = cellvoltage6;
      return this;
    }

    public final SensBatmon build() {
      return new SensBatmon(batmonTimestamp, temperature, voltage, current, soc, batterystatus, serialnumber, safetystatus, operationstatus, cellvoltage1, cellvoltage2, cellvoltage3, cellvoltage4, cellvoltage5, cellvoltage6);
    }
  }
}
