package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkMessage;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageField;
import java.lang.Integer;
import java.lang.Override;
import java.lang.String;
import java.util.List;

/**
 * RTCM message for injecting into the onboard GPS (used for DGPS) 
 */
@MavlinkMessage(
    id = 233,
    crc = 35
)
public final class GpsRtcmData {
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
  private final int flags;

  /**
   * data length 
   */
  private final int len;

  /**
   * RTCM message (may be fragmented) 
   */
  private final List<Integer> data;

  private GpsRtcmData(int flags, int len, List<Integer> data) {
    this.flags = flags;
    this.len = len;
    this.data = data;
  }

  @MavlinkMessageBuilder
  public static Builder builder() {
    return new Builder();
  }

  @Override
  public String toString() {
    return "GpsRtcmData{flags=" + flags
         + ", len=" + len
         + ", data=" + data + "}";
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
      unitSize = 1
  )
  public final int flags() {
    return flags;
  }

  /**
   * data length 
   */
  @MavlinkMessageField(
      position = 2,
      unitSize = 1
  )
  public final int len() {
    return len;
  }

  /**
   * RTCM message (may be fragmented) 
   */
  @MavlinkMessageField(
      position = 3,
      unitSize = 1,
      arraySize = 180
  )
  public final List<Integer> data() {
    return data;
  }

  public static class Builder {
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
        unitSize = 1
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
        unitSize = 1
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
        unitSize = 1,
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
