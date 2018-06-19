package io.dronefleet.mavlink.autoquad;

import io.dronefleet.mavlink.annotations.MavlinkMessage;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageField;
import java.lang.Integer;
import java.lang.Long;
import java.lang.Override;
import java.lang.String;
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
  /**
   * Timestamp of the component clock since boot time in ms. 
   */
  private final long timeBootMs;

  /**
   * Data bits 1-32 for each ESC. 
   */
  private final List<Long> data0;

  /**
   * Data bits 33-64 for each ESC. 
   */
  private final List<Long> data1;

  /**
   * Age of each ESC telemetry reading in ms compared to boot time. A value of 0xFFFF means timeout/no 
   * data. 
   */
  private final List<Integer> statusAge;

  /**
   * Sequence number of message (first set of 4 motors is #1, next 4 is #2, etc). 
   */
  private final int seq;

  /**
   * Total number of active ESCs/motors on the system. 
   */
  private final int numMotors;

  /**
   * Number of active ESCs in this sequence (1 through this many array members will be populated with 
   * data) 
   */
  private final int numInSeq;

  /**
   * ESC/Motor ID 
   */
  private final List<Integer> escid;

  /**
   * Version of data structure (determines contents). 
   */
  private final List<Integer> dataVersion;

  private AqEscTelemetry(long timeBootMs, List<Long> data0, List<Long> data1,
      List<Integer> statusAge, int seq, int numMotors, int numInSeq, List<Integer> escid,
      List<Integer> dataVersion) {
    this.timeBootMs = timeBootMs;
    this.data0 = data0;
    this.data1 = data1;
    this.statusAge = statusAge;
    this.seq = seq;
    this.numMotors = numMotors;
    this.numInSeq = numInSeq;
    this.escid = escid;
    this.dataVersion = dataVersion;
  }

  @MavlinkMessageBuilder
  public static Builder builder() {
    return new Builder();
  }

  @Override
  public String toString() {
    return "AqEscTelemetry{timeBootMs=" + timeBootMs
         + ", seq=" + seq
         + ", numMotors=" + numMotors
         + ", numInSeq=" + numInSeq
         + ", escid=" + escid
         + ", statusAge=" + statusAge
         + ", dataVersion=" + dataVersion
         + ", data0=" + data0
         + ", data1=" + data1 + "}";
  }

  /**
   * Timestamp of the component clock since boot time in ms. 
   */
  @MavlinkMessageField(
      position = 1,
      unitSize = 4
  )
  public final long timeBootMs() {
    return timeBootMs;
  }

  /**
   * Data bits 1-32 for each ESC. 
   */
  @MavlinkMessageField(
      position = 8,
      unitSize = 4,
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
      unitSize = 4,
      arraySize = 4
  )
  public final List<Long> data1() {
    return data1;
  }

  /**
   * Age of each ESC telemetry reading in ms compared to boot time. A value of 0xFFFF means timeout/no 
   * data. 
   */
  @MavlinkMessageField(
      position = 6,
      unitSize = 2,
      arraySize = 4
  )
  public final List<Integer> statusAge() {
    return statusAge;
  }

  /**
   * Sequence number of message (first set of 4 motors is #1, next 4 is #2, etc). 
   */
  @MavlinkMessageField(
      position = 2,
      unitSize = 1
  )
  public final int seq() {
    return seq;
  }

  /**
   * Total number of active ESCs/motors on the system. 
   */
  @MavlinkMessageField(
      position = 3,
      unitSize = 1
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
      unitSize = 1
  )
  public final int numInSeq() {
    return numInSeq;
  }

  /**
   * ESC/Motor ID 
   */
  @MavlinkMessageField(
      position = 5,
      unitSize = 1,
      arraySize = 4
  )
  public final List<Integer> escid() {
    return escid;
  }

  /**
   * Version of data structure (determines contents). 
   */
  @MavlinkMessageField(
      position = 7,
      unitSize = 1,
      arraySize = 4
  )
  public final List<Integer> dataVersion() {
    return dataVersion;
  }

  public static class Builder {
    private long timeBootMs;

    private List<Long> data0;

    private List<Long> data1;

    private List<Integer> statusAge;

    private int seq;

    private int numMotors;

    private int numInSeq;

    private List<Integer> escid;

    private List<Integer> dataVersion;

    private Builder() {
    }

    /**
     * Timestamp of the component clock since boot time in ms. 
     */
    @MavlinkMessageField(
        position = 1,
        unitSize = 4
    )
    public final Builder timeBootMs(long timeBootMs) {
      this.timeBootMs = timeBootMs;
      return this;
    }

    /**
     * Data bits 1-32 for each ESC. 
     */
    @MavlinkMessageField(
        position = 8,
        unitSize = 4,
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
        unitSize = 4,
        arraySize = 4
    )
    public final Builder data1(List<Long> data1) {
      this.data1 = data1;
      return this;
    }

    /**
     * Age of each ESC telemetry reading in ms compared to boot time. A value of 0xFFFF means timeout/no 
     * data. 
     */
    @MavlinkMessageField(
        position = 6,
        unitSize = 2,
        arraySize = 4
    )
    public final Builder statusAge(List<Integer> statusAge) {
      this.statusAge = statusAge;
      return this;
    }

    /**
     * Sequence number of message (first set of 4 motors is #1, next 4 is #2, etc). 
     */
    @MavlinkMessageField(
        position = 2,
        unitSize = 1
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
        unitSize = 1
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
        unitSize = 1
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
        unitSize = 1,
        arraySize = 4
    )
    public final Builder escid(List<Integer> escid) {
      this.escid = escid;
      return this;
    }

    /**
     * Version of data structure (determines contents). 
     */
    @MavlinkMessageField(
        position = 7,
        unitSize = 1,
        arraySize = 4
    )
    public final Builder dataVersion(List<Integer> dataVersion) {
      this.dataVersion = dataVersion;
      return this;
    }

    public final AqEscTelemetry build() {
      return new AqEscTelemetry(timeBootMs, data0, data1, statusAge, seq, numMotors, numInSeq, escid, dataVersion);
    }
  }
}
