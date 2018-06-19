package io.dronefleet.mavlink.ardupilotmega;

import io.dronefleet.mavlink.annotations.MavlinkMessage;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageField;
import java.lang.Override;
import java.lang.String;

/**
 * Airspeed auto-calibration 
 */
@MavlinkMessage(
    id = 174,
    crc = 167
)
public final class AirspeedAutocal {
  /**
   * GPS velocity north m/s 
   */
  private final float vx;

  /**
   * GPS velocity east m/s 
   */
  private final float vy;

  /**
   * GPS velocity down m/s 
   */
  private final float vz;

  /**
   * Differential pressure pascals 
   */
  private final float diffPressure;

  /**
   * Estimated to true airspeed ratio 
   */
  private final float eas2tas;

  /**
   * Airspeed ratio 
   */
  private final float ratio;

  /**
   * EKF state x 
   */
  private final float stateX;

  /**
   * EKF state y 
   */
  private final float stateY;

  /**
   * EKF state z 
   */
  private final float stateZ;

  /**
   * EKF Pax 
   */
  private final float pax;

  /**
   * EKF Pby 
   */
  private final float pby;

  /**
   * EKF Pcz 
   */
  private final float pcz;

  private AirspeedAutocal(float vx, float vy, float vz, float diffPressure, float eas2tas,
      float ratio, float stateX, float stateY, float stateZ, float pax, float pby, float pcz) {
    this.vx = vx;
    this.vy = vy;
    this.vz = vz;
    this.diffPressure = diffPressure;
    this.eas2tas = eas2tas;
    this.ratio = ratio;
    this.stateX = stateX;
    this.stateY = stateY;
    this.stateZ = stateZ;
    this.pax = pax;
    this.pby = pby;
    this.pcz = pcz;
  }

  @MavlinkMessageBuilder
  public static Builder builder() {
    return new Builder();
  }

  @Override
  public String toString() {
    return "AirspeedAutocal{vx=" + vx
         + ", vy=" + vy
         + ", vz=" + vz
         + ", diffPressure=" + diffPressure
         + ", eas2tas=" + eas2tas
         + ", ratio=" + ratio
         + ", stateX=" + stateX
         + ", stateY=" + stateY
         + ", stateZ=" + stateZ
         + ", pax=" + pax
         + ", pby=" + pby
         + ", pcz=" + pcz + "}";
  }

  /**
   * GPS velocity north m/s 
   */
  @MavlinkMessageField(
      position = 1,
      unitSize = 4
  )
  public final float vx() {
    return vx;
  }

  /**
   * GPS velocity east m/s 
   */
  @MavlinkMessageField(
      position = 2,
      unitSize = 4
  )
  public final float vy() {
    return vy;
  }

  /**
   * GPS velocity down m/s 
   */
  @MavlinkMessageField(
      position = 3,
      unitSize = 4
  )
  public final float vz() {
    return vz;
  }

  /**
   * Differential pressure pascals 
   */
  @MavlinkMessageField(
      position = 4,
      unitSize = 4
  )
  public final float diffPressure() {
    return diffPressure;
  }

  /**
   * Estimated to true airspeed ratio 
   */
  @MavlinkMessageField(
      position = 5,
      unitSize = 4
  )
  public final float eas2tas() {
    return eas2tas;
  }

  /**
   * Airspeed ratio 
   */
  @MavlinkMessageField(
      position = 6,
      unitSize = 4
  )
  public final float ratio() {
    return ratio;
  }

  /**
   * EKF state x 
   */
  @MavlinkMessageField(
      position = 7,
      unitSize = 4
  )
  public final float stateX() {
    return stateX;
  }

  /**
   * EKF state y 
   */
  @MavlinkMessageField(
      position = 8,
      unitSize = 4
  )
  public final float stateY() {
    return stateY;
  }

  /**
   * EKF state z 
   */
  @MavlinkMessageField(
      position = 9,
      unitSize = 4
  )
  public final float stateZ() {
    return stateZ;
  }

  /**
   * EKF Pax 
   */
  @MavlinkMessageField(
      position = 10,
      unitSize = 4
  )
  public final float pax() {
    return pax;
  }

  /**
   * EKF Pby 
   */
  @MavlinkMessageField(
      position = 11,
      unitSize = 4
  )
  public final float pby() {
    return pby;
  }

  /**
   * EKF Pcz 
   */
  @MavlinkMessageField(
      position = 12,
      unitSize = 4
  )
  public final float pcz() {
    return pcz;
  }

  public static class Builder {
    private float vx;

    private float vy;

    private float vz;

    private float diffPressure;

    private float eas2tas;

    private float ratio;

    private float stateX;

    private float stateY;

    private float stateZ;

    private float pax;

    private float pby;

    private float pcz;

    private Builder() {
    }

    /**
     * GPS velocity north m/s 
     */
    @MavlinkMessageField(
        position = 1,
        unitSize = 4
    )
    public final Builder vx(float vx) {
      this.vx = vx;
      return this;
    }

    /**
     * GPS velocity east m/s 
     */
    @MavlinkMessageField(
        position = 2,
        unitSize = 4
    )
    public final Builder vy(float vy) {
      this.vy = vy;
      return this;
    }

    /**
     * GPS velocity down m/s 
     */
    @MavlinkMessageField(
        position = 3,
        unitSize = 4
    )
    public final Builder vz(float vz) {
      this.vz = vz;
      return this;
    }

    /**
     * Differential pressure pascals 
     */
    @MavlinkMessageField(
        position = 4,
        unitSize = 4
    )
    public final Builder diffPressure(float diffPressure) {
      this.diffPressure = diffPressure;
      return this;
    }

    /**
     * Estimated to true airspeed ratio 
     */
    @MavlinkMessageField(
        position = 5,
        unitSize = 4
    )
    public final Builder eas2tas(float eas2tas) {
      this.eas2tas = eas2tas;
      return this;
    }

    /**
     * Airspeed ratio 
     */
    @MavlinkMessageField(
        position = 6,
        unitSize = 4
    )
    public final Builder ratio(float ratio) {
      this.ratio = ratio;
      return this;
    }

    /**
     * EKF state x 
     */
    @MavlinkMessageField(
        position = 7,
        unitSize = 4
    )
    public final Builder stateX(float stateX) {
      this.stateX = stateX;
      return this;
    }

    /**
     * EKF state y 
     */
    @MavlinkMessageField(
        position = 8,
        unitSize = 4
    )
    public final Builder stateY(float stateY) {
      this.stateY = stateY;
      return this;
    }

    /**
     * EKF state z 
     */
    @MavlinkMessageField(
        position = 9,
        unitSize = 4
    )
    public final Builder stateZ(float stateZ) {
      this.stateZ = stateZ;
      return this;
    }

    /**
     * EKF Pax 
     */
    @MavlinkMessageField(
        position = 10,
        unitSize = 4
    )
    public final Builder pax(float pax) {
      this.pax = pax;
      return this;
    }

    /**
     * EKF Pby 
     */
    @MavlinkMessageField(
        position = 11,
        unitSize = 4
    )
    public final Builder pby(float pby) {
      this.pby = pby;
      return this;
    }

    /**
     * EKF Pcz 
     */
    @MavlinkMessageField(
        position = 12,
        unitSize = 4
    )
    public final Builder pcz(float pcz) {
      this.pcz = pcz;
      return this;
    }

    public final AirspeedAutocal build() {
      return new AirspeedAutocal(vx, vy, vz, diffPressure, eas2tas, ratio, stateX, stateY, stateZ, pax, pby, pcz);
    }
  }
}
