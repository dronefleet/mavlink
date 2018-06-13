package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkMessage;
import io.dronefleet.mavlink.annotations.MavlinkMessageField;
import java.lang.Integer;
import java.math.BigInteger;
import java.util.List;

/**
 * General information describing a particular UAVCAN node. Please refer to the definition of 
 * the UAVCAN service "uavcan.protocol.GetNodeInfo" for the background information. This 
 * message should be emitted by the system whenever a new node appears online, or an existing node 
 * reboots. Additionally, it can be emitted upon request from the other end of the MAVLink channel 
 * (see MAV_CMD_UAVCAN_GET_NODE_INFO). It is also not prohibited to emit this message 
 * unconditionally at a low frequency. The UAVCAN specification is available at 
 * http://uavcan.org. 
 */
@MavlinkMessage(
    id = 311,
    crc = 95
)
public final class UavcanNodeInfo {
  private final BigInteger timeUsec;

  private final long uptimeSec;

  private final List<Integer> name;

  private final int hwVersionMajor;

  private final int hwVersionMinor;

  private final List<Integer> hwUniqueId;

  private final int swVersionMajor;

  private final int swVersionMinor;

  private final long swVcsCommit;

  private UavcanNodeInfo(BigInteger timeUsec, long uptimeSec, List<Integer> name,
      int hwVersionMajor, int hwVersionMinor, List<Integer> hwUniqueId, int swVersionMajor,
      int swVersionMinor, long swVcsCommit) {
    this.timeUsec = timeUsec;
    this.uptimeSec = uptimeSec;
    this.name = name;
    this.hwVersionMajor = hwVersionMajor;
    this.hwVersionMinor = hwVersionMinor;
    this.hwUniqueId = hwUniqueId;
    this.swVersionMajor = swVersionMajor;
    this.swVersionMinor = swVersionMinor;
    this.swVcsCommit = swVcsCommit;
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
   * The number of seconds since the start-up of the node. 
   */
  @MavlinkMessageField(
      position = 2,
      length = 4
  )
  public final long uptimeSec() {
    return uptimeSec;
  }

  /**
   * Node name string. For example, "sapog.px4.io". 
   */
  @MavlinkMessageField(
      position = 3,
      length = 1,
      arraySize = 80
  )
  public final List<Integer> name() {
    return name;
  }

  /**
   * Hardware major version number. 
   */
  @MavlinkMessageField(
      position = 4,
      length = 1
  )
  public final int hwVersionMajor() {
    return hwVersionMajor;
  }

  /**
   * Hardware minor version number. 
   */
  @MavlinkMessageField(
      position = 5,
      length = 1
  )
  public final int hwVersionMinor() {
    return hwVersionMinor;
  }

  /**
   * Hardware unique 128-bit ID. 
   */
  @MavlinkMessageField(
      position = 6,
      length = 1,
      arraySize = 16
  )
  public final List<Integer> hwUniqueId() {
    return hwUniqueId;
  }

  /**
   * Software major version number. 
   */
  @MavlinkMessageField(
      position = 7,
      length = 1
  )
  public final int swVersionMajor() {
    return swVersionMajor;
  }

  /**
   * Software minor version number. 
   */
  @MavlinkMessageField(
      position = 8,
      length = 1
  )
  public final int swVersionMinor() {
    return swVersionMinor;
  }

  /**
   * Version control system (VCS) revision identifier (e.g. git short commit hash). Zero if 
   * unknown. 
   */
  @MavlinkMessageField(
      position = 9,
      length = 4
  )
  public final long swVcsCommit() {
    return swVcsCommit;
  }

  public class Builder {
    private BigInteger timeUsec;

    private long uptimeSec;

    private List<Integer> name;

    private int hwVersionMajor;

    private int hwVersionMinor;

    private List<Integer> hwUniqueId;

    private int swVersionMajor;

    private int swVersionMinor;

    private long swVcsCommit;

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
     * The number of seconds since the start-up of the node. 
     */
    @MavlinkMessageField(
        position = 2,
        length = 4
    )
    public final Builder uptimeSec(long uptimeSec) {
      this.uptimeSec = uptimeSec;
      return this;
    }

    /**
     * Node name string. For example, "sapog.px4.io". 
     */
    @MavlinkMessageField(
        position = 3,
        length = 1,
        arraySize = 80
    )
    public final Builder name(List<Integer> name) {
      this.name = name;
      return this;
    }

    /**
     * Hardware major version number. 
     */
    @MavlinkMessageField(
        position = 4,
        length = 1
    )
    public final Builder hwVersionMajor(int hwVersionMajor) {
      this.hwVersionMajor = hwVersionMajor;
      return this;
    }

    /**
     * Hardware minor version number. 
     */
    @MavlinkMessageField(
        position = 5,
        length = 1
    )
    public final Builder hwVersionMinor(int hwVersionMinor) {
      this.hwVersionMinor = hwVersionMinor;
      return this;
    }

    /**
     * Hardware unique 128-bit ID. 
     */
    @MavlinkMessageField(
        position = 6,
        length = 1,
        arraySize = 16
    )
    public final Builder hwUniqueId(List<Integer> hwUniqueId) {
      this.hwUniqueId = hwUniqueId;
      return this;
    }

    /**
     * Software major version number. 
     */
    @MavlinkMessageField(
        position = 7,
        length = 1
    )
    public final Builder swVersionMajor(int swVersionMajor) {
      this.swVersionMajor = swVersionMajor;
      return this;
    }

    /**
     * Software minor version number. 
     */
    @MavlinkMessageField(
        position = 8,
        length = 1
    )
    public final Builder swVersionMinor(int swVersionMinor) {
      this.swVersionMinor = swVersionMinor;
      return this;
    }

    /**
     * Version control system (VCS) revision identifier (e.g. git short commit hash). Zero if 
     * unknown. 
     */
    @MavlinkMessageField(
        position = 9,
        length = 4
    )
    public final Builder swVcsCommit(long swVcsCommit) {
      this.swVcsCommit = swVcsCommit;
      return this;
    }

    public final UavcanNodeInfo build() {
      return new UavcanNodeInfo(timeUsec, uptimeSec, name, hwVersionMajor, hwVersionMinor, hwUniqueId, swVersionMajor, swVersionMinor, swVcsCommit);
    }
  }
}
