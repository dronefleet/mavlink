package io.dronefleet.mavlink.ardupilotmega;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import java.lang.Integer;
import java.lang.Override;
import java.lang.String;
import java.util.List;

/**
 * Read registers reply 
 */
@MavlinkMessageInfo(
    id = 11001,
    crc = 15
)
public final class DeviceOpReadReply {
  /**
   * request ID - copied from request 
   */
  private final long requestId;

  /**
   * 0 for success, anything else is failure code 
   */
  private final int result;

  /**
   * starting register 
   */
  private final int regstart;

  /**
   * count of bytes read 
   */
  private final int count;

  /**
   * reply data 
   */
  private final List<Integer> data;

  private DeviceOpReadReply(long requestId, int result, int regstart, int count,
      List<Integer> data) {
    this.requestId = requestId;
    this.result = result;
    this.regstart = regstart;
    this.count = count;
    this.data = data;
  }

  @MavlinkMessageBuilder
  public static Builder builder() {
    return new Builder();
  }

  @Override
  public String toString() {
    return "DeviceOpReadReply{requestId=" + requestId
         + ", result=" + result
         + ", regstart=" + regstart
         + ", count=" + count
         + ", data=" + data + "}";
  }

  /**
   * request ID - copied from request 
   */
  @MavlinkFieldInfo(
      position = 1,
      unitSize = 4
  )
  public final long requestId() {
    return requestId;
  }

  /**
   * 0 for success, anything else is failure code 
   */
  @MavlinkFieldInfo(
      position = 2,
      unitSize = 1
  )
  public final int result() {
    return result;
  }

  /**
   * starting register 
   */
  @MavlinkFieldInfo(
      position = 3,
      unitSize = 1
  )
  public final int regstart() {
    return regstart;
  }

  /**
   * count of bytes read 
   */
  @MavlinkFieldInfo(
      position = 4,
      unitSize = 1
  )
  public final int count() {
    return count;
  }

  /**
   * reply data 
   */
  @MavlinkFieldInfo(
      position = 5,
      unitSize = 1,
      arraySize = 128
  )
  public final List<Integer> data() {
    return data;
  }

  public static class Builder {
    private long requestId;

    private int result;

    private int regstart;

    private int count;

    private List<Integer> data;

    private Builder() {
    }

    /**
     * request ID - copied from request 
     */
    @MavlinkFieldInfo(
        position = 1,
        unitSize = 4
    )
    public final Builder requestId(long requestId) {
      this.requestId = requestId;
      return this;
    }

    /**
     * 0 for success, anything else is failure code 
     */
    @MavlinkFieldInfo(
        position = 2,
        unitSize = 1
    )
    public final Builder result(int result) {
      this.result = result;
      return this;
    }

    /**
     * starting register 
     */
    @MavlinkFieldInfo(
        position = 3,
        unitSize = 1
    )
    public final Builder regstart(int regstart) {
      this.regstart = regstart;
      return this;
    }

    /**
     * count of bytes read 
     */
    @MavlinkFieldInfo(
        position = 4,
        unitSize = 1
    )
    public final Builder count(int count) {
      this.count = count;
      return this;
    }

    /**
     * reply data 
     */
    @MavlinkFieldInfo(
        position = 5,
        unitSize = 1,
        arraySize = 128
    )
    public final Builder data(List<Integer> data) {
      this.data = data;
      return this;
    }

    public final DeviceOpReadReply build() {
      return new DeviceOpReadReply(requestId, result, regstart, count, data);
    }
  }
}
