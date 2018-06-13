package io.dronefleet.mavlink.ardupilotmega;

import io.dronefleet.mavlink.annotations.MavlinkMessage;
import io.dronefleet.mavlink.annotations.MavlinkMessageField;
import java.lang.Integer;
import java.util.List;

/**
 * Read registers reply 
 */
@MavlinkMessage(
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

  public static Builder builder() {
    return new Builder();
  }

  /**
   * request ID - copied from request 
   */
  @MavlinkMessageField(
      position = 1,
      length = 4
  )
  public final long requestId() {
    return requestId;
  }

  /**
   * 0 for success, anything else is failure code 
   */
  @MavlinkMessageField(
      position = 2,
      length = 1
  )
  public final int result() {
    return result;
  }

  /**
   * starting register 
   */
  @MavlinkMessageField(
      position = 3,
      length = 1
  )
  public final int regstart() {
    return regstart;
  }

  /**
   * count of bytes read 
   */
  @MavlinkMessageField(
      position = 4,
      length = 1
  )
  public final int count() {
    return count;
  }

  /**
   * reply data 
   */
  @MavlinkMessageField(
      position = 5,
      length = 1,
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
    @MavlinkMessageField(
        position = 1,
        length = 4
    )
    public final Builder requestId(long requestId) {
      this.requestId = requestId;
      return this;
    }

    /**
     * 0 for success, anything else is failure code 
     */
    @MavlinkMessageField(
        position = 2,
        length = 1
    )
    public final Builder result(int result) {
      this.result = result;
      return this;
    }

    /**
     * starting register 
     */
    @MavlinkMessageField(
        position = 3,
        length = 1
    )
    public final Builder regstart(int regstart) {
      this.regstart = regstart;
      return this;
    }

    /**
     * count of bytes read 
     */
    @MavlinkMessageField(
        position = 4,
        length = 1
    )
    public final Builder count(int count) {
      this.count = count;
      return this;
    }

    /**
     * reply data 
     */
    @MavlinkMessageField(
        position = 5,
        length = 1,
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
