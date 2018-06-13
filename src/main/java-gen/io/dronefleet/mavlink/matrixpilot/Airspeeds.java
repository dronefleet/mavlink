package io.dronefleet.mavlink.matrixpilot;

import io.dronefleet.mavlink.annotations.MavlinkMessage;
import io.dronefleet.mavlink.annotations.MavlinkMessageField;

/**
 * The airspeed measured by sensors and IMU 
 */
@MavlinkMessage(
    id = 182,
    crc = 154
)
public final class Airspeeds {
  /**
   * Timestamp (milliseconds since system boot) 
   */
  private final long timeBootMs;

  /**
   * Airspeed estimate from IMU, cm/s 
   */
  private final int airspeedImu;

  /**
   * Pitot measured forward airpseed, cm/s 
   */
  private final int airspeedPitot;

  /**
   * Hot wire anenometer measured airspeed, cm/s 
   */
  private final int airspeedHotWire;

  /**
   * Ultrasonic measured airspeed, cm/s 
   */
  private final int airspeedUltrasonic;

  /**
   * Angle of attack sensor, degrees * 10 
   */
  private final int aoa;

  /**
   * Yaw angle sensor, degrees * 10 
   */
  private final int aoy;

  private Airspeeds(long timeBootMs, int airspeedImu, int airspeedPitot, int airspeedHotWire,
      int airspeedUltrasonic, int aoa, int aoy) {
    this.timeBootMs = timeBootMs;
    this.airspeedImu = airspeedImu;
    this.airspeedPitot = airspeedPitot;
    this.airspeedHotWire = airspeedHotWire;
    this.airspeedUltrasonic = airspeedUltrasonic;
    this.aoa = aoa;
    this.aoy = aoy;
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
   * Airspeed estimate from IMU, cm/s 
   */
  @MavlinkMessageField(
      position = 2,
      length = 2
  )
  public final int airspeedImu() {
    return airspeedImu;
  }

  /**
   * Pitot measured forward airpseed, cm/s 
   */
  @MavlinkMessageField(
      position = 3,
      length = 2
  )
  public final int airspeedPitot() {
    return airspeedPitot;
  }

  /**
   * Hot wire anenometer measured airspeed, cm/s 
   */
  @MavlinkMessageField(
      position = 4,
      length = 2
  )
  public final int airspeedHotWire() {
    return airspeedHotWire;
  }

  /**
   * Ultrasonic measured airspeed, cm/s 
   */
  @MavlinkMessageField(
      position = 5,
      length = 2
  )
  public final int airspeedUltrasonic() {
    return airspeedUltrasonic;
  }

  /**
   * Angle of attack sensor, degrees * 10 
   */
  @MavlinkMessageField(
      position = 6,
      length = 2
  )
  public final int aoa() {
    return aoa;
  }

  /**
   * Yaw angle sensor, degrees * 10 
   */
  @MavlinkMessageField(
      position = 7,
      length = 2
  )
  public final int aoy() {
    return aoy;
  }

  public static class Builder {
    private long timeBootMs;

    private int airspeedImu;

    private int airspeedPitot;

    private int airspeedHotWire;

    private int airspeedUltrasonic;

    private int aoa;

    private int aoy;

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
     * Airspeed estimate from IMU, cm/s 
     */
    @MavlinkMessageField(
        position = 2,
        length = 2
    )
    public final Builder airspeedImu(int airspeedImu) {
      this.airspeedImu = airspeedImu;
      return this;
    }

    /**
     * Pitot measured forward airpseed, cm/s 
     */
    @MavlinkMessageField(
        position = 3,
        length = 2
    )
    public final Builder airspeedPitot(int airspeedPitot) {
      this.airspeedPitot = airspeedPitot;
      return this;
    }

    /**
     * Hot wire anenometer measured airspeed, cm/s 
     */
    @MavlinkMessageField(
        position = 4,
        length = 2
    )
    public final Builder airspeedHotWire(int airspeedHotWire) {
      this.airspeedHotWire = airspeedHotWire;
      return this;
    }

    /**
     * Ultrasonic measured airspeed, cm/s 
     */
    @MavlinkMessageField(
        position = 5,
        length = 2
    )
    public final Builder airspeedUltrasonic(int airspeedUltrasonic) {
      this.airspeedUltrasonic = airspeedUltrasonic;
      return this;
    }

    /**
     * Angle of attack sensor, degrees * 10 
     */
    @MavlinkMessageField(
        position = 6,
        length = 2
    )
    public final Builder aoa(int aoa) {
      this.aoa = aoa;
      return this;
    }

    /**
     * Yaw angle sensor, degrees * 10 
     */
    @MavlinkMessageField(
        position = 7,
        length = 2
    )
    public final Builder aoy(int aoy) {
      this.aoy = aoy;
      return this;
    }

    public final Airspeeds build() {
      return new Airspeeds(timeBootMs, airspeedImu, airspeedPitot, airspeedHotWire, airspeedUltrasonic, aoa, aoy);
    }
  }
}
