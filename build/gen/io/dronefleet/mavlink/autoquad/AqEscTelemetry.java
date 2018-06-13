package io.dronefleet.mavlink.autoquad;

import io.dronefleet.mavlink.annotations.MavlinkMessage;
import io.dronefleet.mavlink.annotations.MavlinkMessageField;
import java.lang.Integer;
import java.lang.Long;
import java.util.List;

/**
 * Sends ESC32 telemetry data for up to 4 motors. Multiple messages may be sent in sequence when 
 * system has > 4 motors. Data is described as follows: // unsigned int state : 3; // unsigned int vin 
 * : 12; // x 100 // unsigned int amps : 14; // x 100 // unsigned int rpm : 15; // unsigned int duty : 8; // x 
 * (255/100) // - Data Version 2 - // unsigned int errors : 9; // Bad detects error count // - Data 
 * Version 3 - // unsigned int temp : 9; // (Deg C + 32) * 4 // unsigned int errCode : 3; 
 */
@MavlinkMessage(
    id = 152,
    crc = 115
)
public final class AqEscTelemetry {
  private final long timeBootMs;

  private final int seq;

  private final int numMotors;

  private final int numInSeq;

  private final List<Integer> escid;

  private final List<Integer> statusAge;

  private final List<Integer> dataVersion;

  private final List<Long> data0;

  private final List<Long> data1;

  private AqEscTelemetry(long timeBootMs, int seq, int numMotors, int numInSeq, List<Integer> escid,
      List<Integer> statusAge, List<Integer> dataVersion, List<Long> data0, List<Long> data1) {
    this.timeBootMs = timeBootMs;
    this.seq = seq;
    this.numMotors = numMotors;
    this.numInSeq = numInSeq;
    this.escid = escid;
    this.statusAge = statusAge;
    this.dataVersion = dataVersion;
    this.data0 = data0;
    this.data1 = data1;
  }

  public static Builder builder() {
    return new Builder();
  }

  /**
   * Timestamp of the component clock since boot time in ms. 
   */
  @MavlinkMessageField(
      position = 1,
      length = 4
  )
  public final long timeBootMs() {
    return timeBootMs;
  }

  /**
   * Sequence number of message (first set of 4 motors is #1, next 4 is #2, etc). 
   */
  @MavlinkMessageField(
      position = 2,
      length = 1
  )
  public final int seq() {
    return seq;
  }

  /**
   * Total number of active ESCs/motors on the system. 
   */
  @MavlinkMessageField(
      position = 3,
      length = 1
  )
  public final int numMotors() {
    return numMotors;
  }

  /**
   * Number of active ESCs in this sequence (1 through this many array members will be populated with 
   * data) 
   */
  @MavlinkMessageField(
      position = 4,
      length = 1
  )
  public final int numInSeq() {
    return numInSeq;
  }

  /**
   * ESC/Motor ID 
   */
  @MavlinkMessageField(
      position = 5,
      length = 1,
      arraySize = 4
  )
  public final List<Integer> escid() {
    return escid;
  }

  /**
   * Age of each ESC telemetry reading in ms compared to boot time. A value of 0xFFFF means timeout/no 
   * data. 
   */
  @MavlinkMessageField(
      position = 6,
      length = 2,
      arraySize = 4
  )
  public final List<Integer> statusAge() {
    return statusAge;
  }

  /**
   * Version of data structure (determines contents). 
   */
  @MavlinkMessageField(
      position = 7,
      length = 1,
      arraySize = 4
  )
  public final List<Integer> dataVersion() {
    return dataVersion;
  }

  /**
   * Data bits 1-32 for each ESC. 
   */
  @MavlinkMessageField(
      position = 8,
      length = 4,
      arraySize = 4
  )
  public final List<Long> data0() {
    return data0;
  }

  /**
   * Data bits 33-64 for each ESC. 
   */
  @MavlinkMessageField(
      position = 9,
      length = 4,
      arraySize = 4
  )
  public final List<Long> data1() {
    return data1;
  }

  public class Builder {
    private long timeBootMs;

    private int seq;

    private int numMotors;

    private int numInSeq;

    private List<Integer> escid;

    private List<Integer> statusAge;

    private List<Integer> dataVersion;

    private List<Long> data0;

    private List<Long> data1;

    private Builder() {
    }

    /**
     * Timestamp of the component clock since boot time in ms. 
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
     * Sequence number of message (first set of 4 motors is #1, next 4 is #2, etc). 
     */
    @MavlinkMessageField(
        position = 2,
        length = 1
    )
    public final Builder seq(int seq) {
      this.seq = seq;
      return this;
    }

    /**
     * Total number of active ESCs/motors on the system. 
     */
    @MavlinkMessageField(
        position = 3,
        length = 1
    )
    public final Builder numMotors(int numMotors) {
      this.numMotors = numMotors;
      return this;
    }

    /**
     * Number of active ESCs in this sequence (1 through this many array members will be populated with 
     * data) 
     */
    @MavlinkMessageField(
        position = 4,
        length = 1
    )
    public final Builder numInSeq(int numInSeq) {
      this.numInSeq = numInSeq;
      return this;
    }

    /**
     * ESC/Motor ID 
     */
    @MavlinkMessageField(
        position = 5,
        length = 1,
        arraySize = 4
    )
    public final Builder escid(List<Integer> escid) {
      this.escid = escid;
      return this;
    }

    /**
     * Age of each ESC telemetry reading in ms compared to boot time. A value of 0xFFFF means timeout/no 
     * data. 
     */
    @MavlinkMessageField(
        position = 6,
        length = 2,
        arraySize = 4
    )
    public final Builder statusAge(List<Integer> statusAge) {
      this.statusAge = statusAge;
      return this;
    }

    /**
     * Version of data structure (determines contents). 
     */
    @MavlinkMessageField(
        position = 7,
        length = 1,
        arraySize = 4
    )
    public final Builder dataVersion(List<Integer> dataVersion) {
      this.dataVersion = dataVersion;
      return this;
    }

    /**
     * Data bits 1-32 for each ESC. 
     */
    @MavlinkMessageField(
        position = 8,
        length = 4,
        arraySize = 4
    )
    public final Builder data0(List<Long> data0) {
      this.data0 = data0;
      return this;
    }

    /**
     * Data bits 33-64 for each ESC. 
     */
    @MavlinkMessageField(
        position = 9,
        length = 4,
        arraySize = 4
    )
    public final Builder data1(List<Long> data1) {
      this.data1 = data1;
      return this;
    }

    public final AqEscTelemetry build() {
      return new AqEscTelemetry(timeBootMs, seq, numMotors, numInSeq, escid, statusAge, dataVersion, data0, data1);
    }
  }
}
