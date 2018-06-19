package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkMessage;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageField;
import java.lang.Override;
import java.lang.String;

/**
 * Status of simulation environment, if used 
 */
@MavlinkMessage(
    id = 108,
    crc = 32
)
public final class SimState {
  /**
   * True attitude quaternion component 1, w (1 in null-rotation) 
   */
  private final float q1;

  /**
   * True attitude quaternion component 2, x (0 in null-rotation) 
   */
  private final float q2;

  /**
   * True attitude quaternion component 3, y (0 in null-rotation) 
   */
  private final float q3;

  /**
   * True attitude quaternion component 4, z (0 in null-rotation) 
   */
  private final float q4;

  /**
   * Attitude roll expressed as Euler angles, not recommended except for human-readable outputs 
   */
  private final float roll;

  /**
   * Attitude pitch expressed as Euler angles, not recommended except for human-readable outputs 
   */
  private final float pitch;

  /**
   * Attitude yaw expressed as Euler angles, not recommended except for human-readable outputs 
   */
  private final float yaw;

  /**
   * X acceleration m/s/s 
   */
  private final float xacc;

  /**
   * Y acceleration m/s/s 
   */
  private final float yacc;

  /**
   * Z acceleration m/s/s 
   */
  private final float zacc;

  /**
   * Angular speed around X axis rad/s 
   */
  private final float xgyro;

  /**
   * Angular speed around Y axis rad/s 
   */
  private final float ygyro;

  /**
   * Angular speed around Z axis rad/s 
   */
  private final float zgyro;

  /**
   * Latitude in degrees 
   */
  private final float lat;

  /**
   * Longitude in degrees 
   */
  private final float lon;

  /**
   * Altitude in meters 
   */
  private final float alt;

  /**
   * Horizontal position standard deviation 
   */
  private final float stdDevHorz;

  /**
   * Vertical position standard deviation 
   */
  private final float stdDevVert;

  /**
   * True velocity in m/s in NORTH direction in earth-fixed NED frame 
   */
  private final float vn;

  /**
   * True velocity in m/s in EAST direction in earth-fixed NED frame 
   */
  private final float ve;

  /**
   * True velocity in m/s in DOWN direction in earth-fixed NED frame 
   */
  private final float vd;

  private SimState(float q1, float q2, float q3, float q4, float roll, float pitch, float yaw,
      float xacc, float yacc, float zacc, float xgyro, float ygyro, float zgyro, float lat,
      float lon, float alt, float stdDevHorz, float stdDevVert, float vn, float ve, float vd) {
    this.q1 = q1;
    this.q2 = q2;
    this.q3 = q3;
    this.q4 = q4;
    this.roll = roll;
    this.pitch = pitch;
    this.yaw = yaw;
    this.xacc = xacc;
    this.yacc = yacc;
    this.zacc = zacc;
    this.xgyro = xgyro;
    this.ygyro = ygyro;
    this.zgyro = zgyro;
    this.lat = lat;
    this.lon = lon;
    this.alt = alt;
    this.stdDevHorz = stdDevHorz;
    this.stdDevVert = stdDevVert;
    this.vn = vn;
    this.ve = ve;
    this.vd = vd;
  }

  @MavlinkMessageBuilder
  public static Builder builder() {
    return new Builder();
  }

  @Override
  public String toString() {
    return "SimState{q1=" + q1
         + ", q2=" + q2
         + ", q3=" + q3
         + ", q4=" + q4
         + ", roll=" + roll
         + ", pitch=" + pitch
         + ", yaw=" + yaw
         + ", xacc=" + xacc
         + ", yacc=" + yacc
         + ", zacc=" + zacc
         + ", xgyro=" + xgyro
         + ", ygyro=" + ygyro
         + ", zgyro=" + zgyro
         + ", lat=" + lat
         + ", lon=" + lon
         + ", alt=" + alt
         + ", stdDevHorz=" + stdDevHorz
         + ", stdDevVert=" + stdDevVert
         + ", vn=" + vn
         + ", ve=" + ve
         + ", vd=" + vd + "}";
  }

  /**
   * True attitude quaternion component 1, w (1 in null-rotation) 
   */
  @MavlinkMessageField(
      position = 1,
      unitSize = 4
  )
  public final float q1() {
    return q1;
  }

  /**
   * True attitude quaternion component 2, x (0 in null-rotation) 
   */
  @MavlinkMessageField(
      position = 2,
      unitSize = 4
  )
  public final float q2() {
    return q2;
  }

  /**
   * True attitude quaternion component 3, y (0 in null-rotation) 
   */
  @MavlinkMessageField(
      position = 3,
      unitSize = 4
  )
  public final float q3() {
    return q3;
  }

  /**
   * True attitude quaternion component 4, z (0 in null-rotation) 
   */
  @MavlinkMessageField(
      position = 4,
      unitSize = 4
  )
  public final float q4() {
    return q4;
  }

  /**
   * Attitude roll expressed as Euler angles, not recommended except for human-readable outputs 
   */
  @MavlinkMessageField(
      position = 5,
      unitSize = 4
  )
  public final float roll() {
    return roll;
  }

  /**
   * Attitude pitch expressed as Euler angles, not recommended except for human-readable outputs 
   */
  @MavlinkMessageField(
      position = 6,
      unitSize = 4
  )
  public final float pitch() {
    return pitch;
  }

  /**
   * Attitude yaw expressed as Euler angles, not recommended except for human-readable outputs 
   */
  @MavlinkMessageField(
      position = 7,
      unitSize = 4
  )
  public final float yaw() {
    return yaw;
  }

  /**
   * X acceleration m/s/s 
   */
  @MavlinkMessageField(
      position = 8,
      unitSize = 4
  )
  public final float xacc() {
    return xacc;
  }

  /**
   * Y acceleration m/s/s 
   */
  @MavlinkMessageField(
      position = 9,
      unitSize = 4
  )
  public final float yacc() {
    return yacc;
  }

  /**
   * Z acceleration m/s/s 
   */
  @MavlinkMessageField(
      position = 10,
      unitSize = 4
  )
  public final float zacc() {
    return zacc;
  }

  /**
   * Angular speed around X axis rad/s 
   */
  @MavlinkMessageField(
      position = 11,
      unitSize = 4
  )
  public final float xgyro() {
    return xgyro;
  }

  /**
   * Angular speed around Y axis rad/s 
   */
  @MavlinkMessageField(
      position = 12,
      unitSize = 4
  )
  public final float ygyro() {
    return ygyro;
  }

  /**
   * Angular speed around Z axis rad/s 
   */
  @MavlinkMessageField(
      position = 13,
      unitSize = 4
  )
  public final float zgyro() {
    return zgyro;
  }

  /**
   * Latitude in degrees 
   */
  @MavlinkMessageField(
      position = 14,
      unitSize = 4
  )
  public final float lat() {
    return lat;
  }

  /**
   * Longitude in degrees 
   */
  @MavlinkMessageField(
      position = 15,
      unitSize = 4
  )
  public final float lon() {
    return lon;
  }

  /**
   * Altitude in meters 
   */
  @MavlinkMessageField(
      position = 16,
      unitSize = 4
  )
  public final float alt() {
    return alt;
  }

  /**
   * Horizontal position standard deviation 
   */
  @MavlinkMessageField(
      position = 17,
      unitSize = 4
  )
  public final float stdDevHorz() {
    return stdDevHorz;
  }

  /**
   * Vertical position standard deviation 
   */
  @MavlinkMessageField(
      position = 18,
      unitSize = 4
  )
  public final float stdDevVert() {
    return stdDevVert;
  }

  /**
   * True velocity in m/s in NORTH direction in earth-fixed NED frame 
   */
  @MavlinkMessageField(
      position = 19,
      unitSize = 4
  )
  public final float vn() {
    return vn;
  }

  /**
   * True velocity in m/s in EAST direction in earth-fixed NED frame 
   */
  @MavlinkMessageField(
      position = 20,
      unitSize = 4
  )
  public final float ve() {
    return ve;
  }

  /**
   * True velocity in m/s in DOWN direction in earth-fixed NED frame 
   */
  @MavlinkMessageField(
      position = 21,
      unitSize = 4
  )
  public final float vd() {
    return vd;
  }

  public static class Builder {
    private float q1;

    private float q2;

    private float q3;

    private float q4;

    private float roll;

    private float pitch;

    private float yaw;

    private float xacc;

    private float yacc;

    private float zacc;

    private float xgyro;

    private float ygyro;

    private float zgyro;

    private float lat;

    private float lon;

    private float alt;

    private float stdDevHorz;

    private float stdDevVert;

    private float vn;

    private float ve;

    private float vd;

    private Builder() {
    }

    /**
     * True attitude quaternion component 1, w (1 in null-rotation) 
     */
    @MavlinkMessageField(
        position = 1,
        unitSize = 4
    )
    public final Builder q1(float q1) {
      this.q1 = q1;
      return this;
    }

    /**
     * True attitude quaternion component 2, x (0 in null-rotation) 
     */
    @MavlinkMessageField(
        position = 2,
        unitSize = 4
    )
    public final Builder q2(float q2) {
      this.q2 = q2;
      return this;
    }

    /**
     * True attitude quaternion component 3, y (0 in null-rotation) 
     */
    @MavlinkMessageField(
        position = 3,
        unitSize = 4
    )
    public final Builder q3(float q3) {
      this.q3 = q3;
      return this;
    }

    /**
     * True attitude quaternion component 4, z (0 in null-rotation) 
     */
    @MavlinkMessageField(
        position = 4,
        unitSize = 4
    )
    public final Builder q4(float q4) {
      this.q4 = q4;
      return this;
    }

    /**
     * Attitude roll expressed as Euler angles, not recommended except for human-readable outputs 
     */
    @MavlinkMessageField(
        position = 5,
        unitSize = 4
    )
    public final Builder roll(float roll) {
      this.roll = roll;
      return this;
    }

    /**
     * Attitude pitch expressed as Euler angles, not recommended except for human-readable outputs 
     */
    @MavlinkMessageField(
        position = 6,
        unitSize = 4
    )
    public final Builder pitch(float pitch) {
      this.pitch = pitch;
      return this;
    }

    /**
     * Attitude yaw expressed as Euler angles, not recommended except for human-readable outputs 
     */
    @MavlinkMessageField(
        position = 7,
        unitSize = 4
    )
    public final Builder yaw(float yaw) {
      this.yaw = yaw;
      return this;
    }

    /**
     * X acceleration m/s/s 
     */
    @MavlinkMessageField(
        position = 8,
        unitSize = 4
    )
    public final Builder xacc(float xacc) {
      this.xacc = xacc;
      return this;
    }

    /**
     * Y acceleration m/s/s 
     */
    @MavlinkMessageField(
        position = 9,
        unitSize = 4
    )
    public final Builder yacc(float yacc) {
      this.yacc = yacc;
      return this;
    }

    /**
     * Z acceleration m/s/s 
     */
    @MavlinkMessageField(
        position = 10,
        unitSize = 4
    )
    public final Builder zacc(float zacc) {
      this.zacc = zacc;
      return this;
    }

    /**
     * Angular speed around X axis rad/s 
     */
    @MavlinkMessageField(
        position = 11,
        unitSize = 4
    )
    public final Builder xgyro(float xgyro) {
      this.xgyro = xgyro;
      return this;
    }

    /**
     * Angular speed around Y axis rad/s 
     */
    @MavlinkMessageField(
        position = 12,
        unitSize = 4
    )
    public final Builder ygyro(float ygyro) {
      this.ygyro = ygyro;
      return this;
    }

    /**
     * Angular speed around Z axis rad/s 
     */
    @MavlinkMessageField(
        position = 13,
        unitSize = 4
    )
    public final Builder zgyro(float zgyro) {
      this.zgyro = zgyro;
      return this;
    }

    /**
     * Latitude in degrees 
     */
    @MavlinkMessageField(
        position = 14,
        unitSize = 4
    )
    public final Builder lat(float lat) {
      this.lat = lat;
      return this;
    }

    /**
     * Longitude in degrees 
     */
    @MavlinkMessageField(
        position = 15,
        unitSize = 4
    )
    public final Builder lon(float lon) {
      this.lon = lon;
      return this;
    }

    /**
     * Altitude in meters 
     */
    @MavlinkMessageField(
        position = 16,
        unitSize = 4
    )
    public final Builder alt(float alt) {
      this.alt = alt;
      return this;
    }

    /**
     * Horizontal position standard deviation 
     */
    @MavlinkMessageField(
        position = 17,
        unitSize = 4
    )
    public final Builder stdDevHorz(float stdDevHorz) {
      this.stdDevHorz = stdDevHorz;
      return this;
    }

    /**
     * Vertical position standard deviation 
     */
    @MavlinkMessageField(
        position = 18,
        unitSize = 4
    )
    public final Builder stdDevVert(float stdDevVert) {
      this.stdDevVert = stdDevVert;
      return this;
    }

    /**
     * True velocity in m/s in NORTH direction in earth-fixed NED frame 
     */
    @MavlinkMessageField(
        position = 19,
        unitSize = 4
    )
    public final Builder vn(float vn) {
      this.vn = vn;
      return this;
    }

    /**
     * True velocity in m/s in EAST direction in earth-fixed NED frame 
     */
    @MavlinkMessageField(
        position = 20,
        unitSize = 4
    )
    public final Builder ve(float ve) {
      this.ve = ve;
      return this;
    }

    /**
     * True velocity in m/s in DOWN direction in earth-fixed NED frame 
     */
    @MavlinkMessageField(
        position = 21,
        unitSize = 4
    )
    public final Builder vd(float vd) {
      this.vd = vd;
      return this;
    }

    public final SimState build() {
      return new SimState(q1, q2, q3, q4, roll, pitch, yaw, xacc, yacc, zacc, xgyro, ygyro, zgyro, lat, lon, alt, stdDevHorz, stdDevVert, vn, ve, vd);
    }
  }
}
