package io.dronefleet.mavlink.asluav;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import java.lang.Override;
import java.lang.String;
import java.math.BigInteger;

/**
 * Monitoring of sensorpod status 
 */
@MavlinkMessageInfo(
    id = 211,
    crc = 54
)
public final class SensorpodStatus {
  /**
   * Timestamp in linuxtime (since 1.1.1970) 
   */
  private final BigInteger timestamp;

  /**
   * Free space available in recordings directory in [Gb] * 1e2 
   */
  private final int freeSpace;

  /**
   * Rate of ROS topic 1 
   */
  private final int visensorRate1;

  /**
   * Rate of ROS topic 2 
   */
  private final int visensorRate2;

  /**
   * Rate of ROS topic 3 
   */
  private final int visensorRate3;

  /**
   * Rate of ROS topic 4 
   */
  private final int visensorRate4;

  /**
   * Number of recording nodes 
   */
  private final int recordingNodesCount;

  /**
   * Temperature of sensorpod CPU in 
   */
  private final int cpuTemp;

  private SensorpodStatus(BigInteger timestamp, int freeSpace, int visensorRate1, int visensorRate2,
      int visensorRate3, int visensorRate4, int recordingNodesCount, int cpuTemp) {
    this.timestamp = timestamp;
    this.freeSpace = freeSpace;
    this.visensorRate1 = visensorRate1;
    this.visensorRate2 = visensorRate2;
    this.visensorRate3 = visensorRate3;
    this.visensorRate4 = visensorRate4;
    this.recordingNodesCount = recordingNodesCount;
    this.cpuTemp = cpuTemp;
  }

  @MavlinkMessageBuilder
  public static Builder builder() {
    return new Builder();
  }

  @Override
  public String toString() {
    return "SensorpodStatus{timestamp=" + timestamp
         + ", visensorRate1=" + visensorRate1
         + ", visensorRate2=" + visensorRate2
         + ", visensorRate3=" + visensorRate3
         + ", visensorRate4=" + visensorRate4
         + ", recordingNodesCount=" + recordingNodesCount
         + ", cpuTemp=" + cpuTemp
         + ", freeSpace=" + freeSpace + "}";
  }

  /**
   * Timestamp in linuxtime (since 1.1.1970) 
   */
  @MavlinkFieldInfo(
      position = 1,
      unitSize = 8
  )
  public final BigInteger timestamp() {
    return timestamp;
  }

  /**
   * Free space available in recordings directory in [Gb] * 1e2 
   */
  @MavlinkFieldInfo(
      position = 8,
      unitSize = 2
  )
  public final int freeSpace() {
    return freeSpace;
  }

  /**
   * Rate of ROS topic 1 
   */
  @MavlinkFieldInfo(
      position = 2,
      unitSize = 1
  )
  public final int visensorRate1() {
    return visensorRate1;
  }

  /**
   * Rate of ROS topic 2 
   */
  @MavlinkFieldInfo(
      position = 3,
      unitSize = 1
  )
  public final int visensorRate2() {
    return visensorRate2;
  }

  /**
   * Rate of ROS topic 3 
   */
  @MavlinkFieldInfo(
      position = 4,
      unitSize = 1
  )
  public final int visensorRate3() {
    return visensorRate3;
  }

  /**
   * Rate of ROS topic 4 
   */
  @MavlinkFieldInfo(
      position = 5,
      unitSize = 1
  )
  public final int visensorRate4() {
    return visensorRate4;
  }

  /**
   * Number of recording nodes 
   */
  @MavlinkFieldInfo(
      position = 6,
      unitSize = 1
  )
  public final int recordingNodesCount() {
    return recordingNodesCount;
  }

  /**
   * Temperature of sensorpod CPU in 
   */
  @MavlinkFieldInfo(
      position = 7,
      unitSize = 1
  )
  public final int cpuTemp() {
    return cpuTemp;
  }

  public static class Builder {
    private BigInteger timestamp;

    private int freeSpace;

    private int visensorRate1;

    private int visensorRate2;

    private int visensorRate3;

    private int visensorRate4;

    private int recordingNodesCount;

    private int cpuTemp;

    private Builder() {
    }

    /**
     * Timestamp in linuxtime (since 1.1.1970) 
     */
    @MavlinkFieldInfo(
        position = 1,
        unitSize = 8
    )
    public final Builder timestamp(BigInteger timestamp) {
      this.timestamp = timestamp;
      return this;
    }

    /**
     * Free space available in recordings directory in [Gb] * 1e2 
     */
    @MavlinkFieldInfo(
        position = 8,
        unitSize = 2
    )
    public final Builder freeSpace(int freeSpace) {
      this.freeSpace = freeSpace;
      return this;
    }

    /**
     * Rate of ROS topic 1 
     */
    @MavlinkFieldInfo(
        position = 2,
        unitSize = 1
    )
    public final Builder visensorRate1(int visensorRate1) {
      this.visensorRate1 = visensorRate1;
      return this;
    }

    /**
     * Rate of ROS topic 2 
     */
    @MavlinkFieldInfo(
        position = 3,
        unitSize = 1
    )
    public final Builder visensorRate2(int visensorRate2) {
      this.visensorRate2 = visensorRate2;
      return this;
    }

    /**
     * Rate of ROS topic 3 
     */
    @MavlinkFieldInfo(
        position = 4,
        unitSize = 1
    )
    public final Builder visensorRate3(int visensorRate3) {
      this.visensorRate3 = visensorRate3;
      return this;
    }

    /**
     * Rate of ROS topic 4 
     */
    @MavlinkFieldInfo(
        position = 5,
        unitSize = 1
    )
    public final Builder visensorRate4(int visensorRate4) {
      this.visensorRate4 = visensorRate4;
      return this;
    }

    /**
     * Number of recording nodes 
     */
    @MavlinkFieldInfo(
        position = 6,
        unitSize = 1
    )
    public final Builder recordingNodesCount(int recordingNodesCount) {
      this.recordingNodesCount = recordingNodesCount;
      return this;
    }

    /**
     * Temperature of sensorpod CPU in 
     */
    @MavlinkFieldInfo(
        position = 7,
        unitSize = 1
    )
    public final Builder cpuTemp(int cpuTemp) {
      this.cpuTemp = cpuTemp;
      return this;
    }

    public final SensorpodStatus build() {
      return new SensorpodStatus(timestamp, freeSpace, visensorRate1, visensorRate2, visensorRate3, visensorRate4, recordingNodesCount, cpuTemp);
    }
  }
}
