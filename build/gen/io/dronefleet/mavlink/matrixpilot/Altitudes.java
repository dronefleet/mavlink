package io.dronefleet.mavlink.matrixpilot;

import io.dronefleet.mavlink.annotations.MavlinkMessage;
import io.dronefleet.mavlink.annotations.MavlinkMessageField;

/**
 * The altitude measured by sensors and IMU 
 */
@MavlinkMessage(
    id = 181,
    crc = 55
)
public final class Altitudes {
  private final long timeBootMs;

  private final int altGps;

  private final int altImu;

  private final int altBarometric;

  private final int altOpticalFlow;

  private final int altRangeFinder;

  private final int altExtra;

  private Altitudes(long timeBootMs, int altGps, int altImu, int altBarometric, int altOpticalFlow,
      int altRangeFinder, int altExtra) {
    this.timeBootMs = timeBootMs;
    this.altGps = altGps;
    this.altImu = altImu;
    this.altBarometric = altBarometric;
    this.altOpticalFlow = altOpticalFlow;
    this.altRangeFinder = altRangeFinder;
    this.altExtra = altExtra;
  }

  public static Builder builder() {
    return new Builder();
  }

  /**
   * Timestamp (milliseconds since system boot) 
   */
  @MavlinkMessageField(
      position = 1,
      length = 4
  )
  public final long timeBootMs() {
    return timeBootMs;
  }

  /**
   * GPS altitude in meters, expressed as * 1000 (millimeters), above MSL 
   */
  @MavlinkMessageField(
      position = 2,
      length = 4
  )
  public final int altGps() {
    return altGps;
  }

  /**
   * IMU altitude above ground in meters, expressed as * 1000 (millimeters) 
   */
  @MavlinkMessageField(
      position = 3,
      length = 4
  )
  public final int altImu() {
    return altImu;
  }

  /**
   * barometeric altitude above ground in meters, expressed as * 1000 (millimeters) 
   */
  @MavlinkMessageField(
      position = 4,
      length = 4
  )
  public final int altBarometric() {
    return altBarometric;
  }

  /**
   * Optical flow altitude above ground in meters, expressed as * 1000 (millimeters) 
   */
  @MavlinkMessageField(
      position = 5,
      length = 4
  )
  public final int altOpticalFlow() {
    return altOpticalFlow;
  }

  /**
   * Rangefinder Altitude above ground in meters, expressed as * 1000 (millimeters) 
   */
  @MavlinkMessageField(
      position = 6,
      length = 4
  )
  public final int altRangeFinder() {
    return altRangeFinder;
  }

  /**
   * Extra altitude above ground in meters, expressed as * 1000 (millimeters) 
   */
  @MavlinkMessageField(
      position = 7,
      length = 4
  )
  public final int altExtra() {
    return altExtra;
  }

  public class Builder {
    private long timeBootMs;

    private int altGps;

    private int altImu;

    private int altBarometric;

    private int altOpticalFlow;

    private int altRangeFinder;

    private int altExtra;

    private Builder() {
    }

    /**
     * Timestamp (milliseconds since system boot) 
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
     * GPS altitude in meters, expressed as * 1000 (millimeters), above MSL 
     */
    @MavlinkMessageField(
        position = 2,
        length = 4
    )
    public final Builder altGps(int altGps) {
      this.altGps = altGps;
      return this;
    }

    /**
     * IMU altitude above ground in meters, expressed as * 1000 (millimeters) 
     */
    @MavlinkMessageField(
        position = 3,
        length = 4
    )
    public final Builder altImu(int altImu) {
      this.altImu = altImu;
      return this;
    }

    /**
     * barometeric altitude above ground in meters, expressed as * 1000 (millimeters) 
     */
    @MavlinkMessageField(
        position = 4,
        length = 4
    )
    public final Builder altBarometric(int altBarometric) {
      this.altBarometric = altBarometric;
      return this;
    }

    /**
     * Optical flow altitude above ground in meters, expressed as * 1000 (millimeters) 
     */
    @MavlinkMessageField(
        position = 5,
        length = 4
    )
    public final Builder altOpticalFlow(int altOpticalFlow) {
      this.altOpticalFlow = altOpticalFlow;
      return this;
    }

    /**
     * Rangefinder Altitude above ground in meters, expressed as * 1000 (millimeters) 
     */
    @MavlinkMessageField(
        position = 6,
        length = 4
    )
    public final Builder altRangeFinder(int altRangeFinder) {
      this.altRangeFinder = altRangeFinder;
      return this;
    }

    /**
     * Extra altitude above ground in meters, expressed as * 1000 (millimeters) 
     */
    @MavlinkMessageField(
        position = 7,
        length = 4
    )
    public final Builder altExtra(int altExtra) {
      this.altExtra = altExtra;
      return this;
    }

    public final Altitudes build() {
      return new Altitudes(timeBootMs, altGps, altImu, altBarometric, altOpticalFlow, altRangeFinder, altExtra);
    }
  }
}
