package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkMessage;
import io.dronefleet.mavlink.annotations.MavlinkMessageField;
import java.lang.Integer;
import java.util.List;

/**
 * RTCM message for injecting into the onboard GPS (used for DGPS) 
 */
@MavlinkMessage(
    id = 233,
    crc = 35
)
public final class GpsRtcmData {
  private final int flags;

  private final int len;

  private final List<Integer> data;

  private GpsRtcmData(int flags, int len, List<Integer> data) {
    this.flags = flags;
    this.len = len;
    this.data = data;
  }

  public static Builder builder() {
    return new Builder();
  }

  /**
   * LSB: 1 means message is fragmented, next 2 bits are the fragment ID, the remaining 5 bits are used 
   * for the sequence ID. Messages are only to be flushed to the GPS when the entire message has been 
   * reconstructed on the autopilot. The fragment ID specifies which order the fragments should be 
   * assembled into a buffer, while the sequence ID is used to detect a mismatch between different 
   * buffers. The buffer is considered fully reconstructed when either all 4 fragments are 
   * present, or all the fragments before the first fragment with a non full payload is received. 
   * This management is used to ensure that normal GPS operation doesn't corrupt RTCM data, and to 
   * recover from a unreliable transport delivery order. 
   */
  @MavlinkMessageField(
      position = 1,
      length = 1
  )
  public final int flags() {
    return flags;
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
   * RTCM message (may be fragmented) 
   */
  @MavlinkMessageField(
      position = 3,
      length = 1,
      arraySize = 180
  )
  public final List<Integer> data() {
    return data;
  }

  public class Builder {
    private int flags;

    private int len;

    private List<Integer> data;

    private Builder() {
    }

    /**
     * LSB: 1 means message is fragmented, next 2 bits are the fragment ID, the remaining 5 bits are used 
     * for the sequence ID. Messages are only to be flushed to the GPS when the entire message has been 
     * reconstructed on the autopilot. The fragment ID specifies which order the fragments should be 
     * assembled into a buffer, while the sequence ID is used to detect a mismatch between different 
     * buffers. The buffer is considered fully reconstructed when either all 4 fragments are 
     * present, or all the fragments before the first fragment with a non full payload is received. 
     * This management is used to ensure that normal GPS operation doesn't corrupt RTCM data, and to 
     * recover from a unreliable transport delivery order. 
     */
    @MavlinkMessageField(
        position = 1,
        length = 1
    )
    public final Builder flags(int flags) {
      this.flags = flags;
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
     * RTCM message (may be fragmented) 
     */
    @MavlinkMessageField(
        position = 3,
        length = 1,
        arraySize = 180
    )
    public final Builder data(List<Integer> data) {
      this.data = data;
      return this;
    }

    public final GpsRtcmData build() {
      return new GpsRtcmData(flags, len, data);
    }
  }
}
