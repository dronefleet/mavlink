package io.dronefleet.mavlink.asluav;

import io.dronefleet.mavlink.annotations.MavlinkMessage;
import io.dronefleet.mavlink.annotations.MavlinkMessageField;
import java.math.BigInteger;

/**
 * Monitoring of sensorpod status 
 */
@MavlinkMessage(
    id = 211,
    crc = 54
)
public final class SensorpodStatus {
  private final BigInteger timestamp;

  private final int visensorRate1;

  private final int visensorRate2;

  private final int visensorRate3;

  private final int visensorRate4;

  private final int recordingNodesCount;

  private final int cpuTemp;

  private final int freeSpace;

  private SensorpodStatus(BigInteger timestamp, int visensorRate1, int visensorRate2,
      int visensorRate3, int visensorRate4, int recordingNodesCount, int cpuTemp, int freeSpace) {
    this.timestamp = timestamp;
    this.visensorRate1 = visensorRate1;
    this.visensorRate2 = visensorRate2;
    this.visensorRate3 = visensorRate3;
    this.visensorRate4 = visensorRate4;
    this.recordingNodesCount = recordingNodesCount;
    this.cpuTemp = cpuTemp;
    this.freeSpace = freeSpace;
  }

  public static Builder builder() {
    return new Builder();
  }

  /**
   * Timestamp in linuxtime (since 1.1.1970) 
   */
  @MavlinkMessageField(
      position = 1,
      length = 8
  )
  public final BigInteger timestamp() {
    return timestamp;
  }

  /**
   * Rate of ROS topic 1 
   */
  @MavlinkMessageField(
      position = 2,
      length = 1
  )
  public final int visensorRate1() {
    return visensorRate1;
  }

  /**
   * Rate of ROS topic 2 
   */
  @MavlinkMessageField(
      position = 3,
      length = 1
  )
  public final int visensorRate2() {
    return visensorRate2;
  }

  /**
   * Rate of ROS topic 3 
   */
  @MavlinkMessageField(
      position = 4,
      length = 1
  )
  public final int visensorRate3() {
    return visensorRate3;
  }

  /**
   * Rate of ROS topic 4 
   */
  @MavlinkMessageField(
      position = 5,
      length = 1
  )
  public final int visensorRate4() {
    return visensorRate4;
  }

  /**
   * Number of recording nodes 
   */
  @MavlinkMessageField(
      position = 6,
      length = 1
  )
  public final int recordingNodesCount() {
    return recordingNodesCount;
  }

  /**
   * Temperature of sensorpod CPU in 
   */
  @MavlinkMessageField(
      position = 7,
      length = 1
  )
  public final int cpuTemp() {
    return cpuTemp;
  }

  /**
   * Free space available in recordings directory in [Gb] * 1e2 
   */
  @MavlinkMessageField(
      position = 8,
      length = 2
  )
  public final int freeSpace() {
    return freeSpace;
  }

  public class Builder {
    private BigInteger timestamp;

    private int visensorRate1;

    private int visensorRate2;

    private int visensorRate3;

    private int visensorRate4;

    private int recordingNodesCount;

    private int cpuTemp;

    private int freeSpace;

    private Builder() {
    }

    /**
     * Timestamp in linuxtime (since 1.1.1970) 
     */
    @MavlinkMessageField(
        position = 1,
        length = 8
    )
    public final Builder timestamp(BigInteger timestamp) {
      this.timestamp = timestamp;
      return this;
    }

    /**
     * Rate of ROS topic 1 
     */
    @MavlinkMessageField(
        position = 2,
        length = 1
    )
    public final Builder visensorRate1(int visensorRate1) {
      this.visensorRate1 = visensorRate1;
      return this;
    }

    /**
     * Rate of ROS topic 2 
     */
    @MavlinkMessageField(
        position = 3,
        length = 1
    )
    public final Builder visensorRate2(int visensorRate2) {
      this.visensorRate2 = visensorRate2;
      return this;
    }

    /**
     * Rate of ROS topic 3 
     */
    @MavlinkMessageField(
        position = 4,
        length = 1
    )
    public final Builder visensorRate3(int visensorRate3) {
      this.visensorRate3 = visensorRate3;
      return this;
    }

    /**
     * Rate of ROS topic 4 
     */
    @MavlinkMessageField(
        position = 5,
        length = 1
    )
    public final Builder visensorRate4(int visensorRate4) {
      this.visensorRate4 = visensorRate4;
      return this;
    }

    /**
     * Number of recording nodes 
     */
    @MavlinkMessageField(
        position = 6,
        length = 1
    )
    public final Builder recordingNodesCount(int recordingNodesCount) {
      this.recordingNodesCount = recordingNodesCount;
      return this;
    }

    /**
     * Temperature of sensorpod CPU in 
     */
    @MavlinkMessageField(
        position = 7,
        length = 1
    )
    public final Builder cpuTemp(int cpuTemp) {
      this.cpuTemp = cpuTemp;
      return this;
    }

    /**
     * Free space available in recordings directory in [Gb] * 1e2 
     */
    @MavlinkMessageField(
        position = 8,
        length = 2
    )
    public final Builder freeSpace(int freeSpace) {
      this.freeSpace = freeSpace;
      return this;
    }

    public final SensorpodStatus build() {
      return new SensorpodStatus(timestamp, visensorRate1, visensorRate2, visensorRate3, visensorRate4, recordingNodesCount, cpuTemp, freeSpace);
    }
  }
}
