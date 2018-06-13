package io.dronefleet.mavlink.ardupilotmega;

import io.dronefleet.mavlink.annotations.MavlinkMessage;
import io.dronefleet.mavlink.annotations.MavlinkMessageField;
import java.lang.Integer;
import java.util.List;

/**
 * Data packet, size 16 
 */
@MavlinkMessage(
    id = 169,
    crc = 234
)
public final class Data16 {
  private final int type;

  private final int len;

  private final List<Integer> data;

  private Data16(int type, int len, List<Integer> data) {
    this.type = type;
    this.len = len;
    this.data = data;
  }

  public static Builder builder() {
    return new Builder();
  }

  /**
   * data type 
   */
  @MavlinkMessageField(
      position = 1,
      length = 1
  )
  public final int type() {
    return type;
  }

  /**
   * data length 
   */
  @MavlinkMessageField(
      position = 2,
      length = 1
  )
  public final int len() {
    return len;
  }

  /**
   * raw data 
   */
  @MavlinkMessageField(
      position = 3,
      length = 1,
      arraySize = 16
  )
  public final List<Integer> data() {
    return data;
  }

  public class Builder {
    private int type;

    private int len;

    private List<Integer> data;

    private Builder() {
    }

    /**
     * data type 
     */
    @MavlinkMessageField(
        position = 1,
        length = 1
    )
    public final Builder type(int type) {
      this.type = type;
      return this;
    }

    /**
     * data length 
     */
    @MavlinkMessageField(
        position = 2,
        length = 1
    )
    public final Builder len(int len) {
      this.len = len;
      return this;
    }

    /**
     * raw data 
     */
    @MavlinkMessageField(
        position = 3,
        length = 1,
        arraySize = 16
    )
    public final Builder data(List<Integer> data) {
      this.data = data;
      return this;
    }

    public final Data16 build() {
      return new Data16(type, len, data);
    }
  }
}
