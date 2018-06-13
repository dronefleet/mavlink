package io.dronefleet.mavlink.asluav;

import io.dronefleet.mavlink.annotations.MavlinkMessage;
import io.dronefleet.mavlink.annotations.MavlinkMessageField;
import java.math.BigInteger;

/**
 * ASL-fixed-wing controller data 
 */
@MavlinkMessage(
    id = 203,
    crc = 172
)
public final class AslctrlData {
  private final BigInteger timestamp;

  private final int aslctrlMode;

  private final float h;

  private final float href;

  private final float hrefT;

  private final float pitchangle;

  private final float pitchangleref;

  private final float q;

  private final float qref;

  private final float uelev;

  private final float uthrot;

  private final float uthrot2;

  private final float nz;

  private final float airspeedref;

  private final int spoilersengaged;

  private final float yawangle;

  private final float yawangleref;

  private final float rollangle;

  private final float rollangleref;

  private final float p;

  private final float pref;

  private final float r;

  private final float rref;

  private final float uail;

  private final float urud;

  private AslctrlData(BigInteger timestamp, int aslctrlMode, float h, float href, float hrefT,
      float pitchangle, float pitchangleref, float q, float qref, float uelev, float uthrot,
      float uthrot2, float nz, float airspeedref, int spoilersengaged, float yawangle,
      float yawangleref, float rollangle, float rollangleref, float p, float pref, float r,
      float rref, float uail, float urud) {
    this.timestamp = timestamp;
    this.aslctrlMode = aslctrlMode;
    this.h = h;
    this.href = href;
    this.hrefT = hrefT;
    this.pitchangle = pitchangle;
    this.pitchangleref = pitchangleref;
    this.q = q;
    this.qref = qref;
    this.uelev = uelev;
    this.uthrot = uthrot;
    this.uthrot2 = uthrot2;
    this.nz = nz;
    this.airspeedref = airspeedref;
    this.spoilersengaged = spoilersengaged;
    this.yawangle = yawangle;
    this.yawangleref = yawangleref;
    this.rollangle = rollangle;
    this.rollangleref = rollangleref;
    this.p = p;
    this.pref = pref;
    this.r = r;
    this.rref = rref;
    this.uail = uail;
    this.urud = urud;
  }

  public static Builder builder() {
    return new Builder();
  }

  /**
   * Timestamp 
   */
  @MavlinkMessageField(
      position = 1,
      length = 8
  )
  public final BigInteger timestamp() {
    return timestamp;
  }

  /**
   * ASLCTRL control-mode (manual, stabilized, auto, etc...) 
   */
  @MavlinkMessageField(
      position = 2,
      length = 1
  )
  public final int aslctrlMode() {
    return aslctrlMode;
  }

  /**
   * See sourcecode for a description of these values... 
   */
  @MavlinkMessageField(
      position = 3,
      length = 4
  )
  public final float h() {
    return h;
  }

  /**
   * null
   */
  @MavlinkMessageField(
      position = 4,
      length = 4
  )
  public final float href() {
    return href;
  }

  /**
   * null
   */
  @MavlinkMessageField(
      position = 5,
      length = 4
  )
  public final float hrefT() {
    return hrefT;
  }

  /**
   * Pitch angle 
   */
  @MavlinkMessageField(
      position = 6,
      length = 4
  )
  public final float pitchangle() {
    return pitchangle;
  }

  /**
   * Pitch angle reference 
   */
  @MavlinkMessageField(
      position = 7,
      length = 4
  )
  public final float pitchangleref() {
    return pitchangleref;
  }

  /**
   * null
   */
  @MavlinkMessageField(
      position = 8,
      length = 4
  )
  public final float q() {
    return q;
  }

  /**
   * null
   */
  @MavlinkMessageField(
      position = 9,
      length = 4
  )
  public final float qref() {
    return qref;
  }

  /**
   * null
   */
  @MavlinkMessageField(
      position = 10,
      length = 4
  )
  public final float uelev() {
    return uelev;
  }

  /**
   * null
   */
  @MavlinkMessageField(
      position = 11,
      length = 4
  )
  public final float uthrot() {
    return uthrot;
  }

  /**
   * null
   */
  @MavlinkMessageField(
      position = 12,
      length = 4
  )
  public final float uthrot2() {
    return uthrot2;
  }

  /**
   * null
   */
  @MavlinkMessageField(
      position = 13,
      length = 4
  )
  public final float nz() {
    return nz;
  }

  /**
   * Airspeed reference 
   */
  @MavlinkMessageField(
      position = 14,
      length = 4
  )
  public final float airspeedref() {
    return airspeedref;
  }

  /**
   * null
   */
  @MavlinkMessageField(
      position = 15,
      length = 1
  )
  public final int spoilersengaged() {
    return spoilersengaged;
  }

  /**
   * Yaw angle 
   */
  @MavlinkMessageField(
      position = 16,
      length = 4
  )
  public final float yawangle() {
    return yawangle;
  }

  /**
   * Yaw angle reference 
   */
  @MavlinkMessageField(
      position = 17,
      length = 4
  )
  public final float yawangleref() {
    return yawangleref;
  }

  /**
   * Roll angle 
   */
  @MavlinkMessageField(
      position = 18,
      length = 4
  )
  public final float rollangle() {
    return rollangle;
  }

  /**
   * Roll angle reference 
   */
  @MavlinkMessageField(
      position = 19,
      length = 4
  )
  public final float rollangleref() {
    return rollangleref;
  }

  /**
   * null
   */
  @MavlinkMessageField(
      position = 20,
      length = 4
  )
  public final float p() {
    return p;
  }

  /**
   * null
   */
  @MavlinkMessageField(
      position = 21,
      length = 4
  )
  public final float pref() {
    return pref;
  }

  /**
   * null
   */
  @MavlinkMessageField(
      position = 22,
      length = 4
  )
  public final float r() {
    return r;
  }

  /**
   * null
   */
  @MavlinkMessageField(
      position = 23,
      length = 4
  )
  public final float rref() {
    return rref;
  }

  /**
   * null
   */
  @MavlinkMessageField(
      position = 24,
      length = 4
  )
  public final float uail() {
    return uail;
  }

  /**
   * null
   */
  @MavlinkMessageField(
      position = 25,
      length = 4
  )
  public final float urud() {
    return urud;
  }

  public class Builder {
    private BigInteger timestamp;

    private int aslctrlMode;

    private float h;

    private float href;

    private float hrefT;

    private float pitchangle;

    private float pitchangleref;

    private float q;

    private float qref;

    private float uelev;

    private float uthrot;

    private float uthrot2;

    private float nz;

    private float airspeedref;

    private int spoilersengaged;

    private float yawangle;

    private float yawangleref;

    private float rollangle;

    private float rollangleref;

    private float p;

    private float pref;

    private float r;

    private float rref;

    private float uail;

    private float urud;

    private Builder() {
    }

    /**
     * Timestamp 
     */
    @MavlinkMessageField(
        position = 1,
        length = 8
    )
    public final Builder timestamp(BigInteger timestamp) {
      this.timestamp = timestamp;
      return this;
    }

    /**
     * ASLCTRL control-mode (manual, stabilized, auto, etc...) 
     */
    @MavlinkMessageField(
        position = 2,
        length = 1
    )
    public final Builder aslctrlMode(int aslctrlMode) {
      this.aslctrlMode = aslctrlMode;
      return this;
    }

    /**
     * See sourcecode for a description of these values... 
     */
    @MavlinkMessageField(
        position = 3,
        length = 4
    )
    public final Builder h(float h) {
      this.h = h;
      return this;
    }

    /**
     * null
     */
    @MavlinkMessageField(
        position = 4,
        length = 4
    )
    public final Builder href(float href) {
      this.href = href;
      return this;
    }

    /**
     * null
     */
    @MavlinkMessageField(
        position = 5,
        length = 4
    )
    public final Builder hrefT(float hrefT) {
      this.hrefT = hrefT;
      return this;
    }

    /**
     * Pitch angle 
     */
    @MavlinkMessageField(
        position = 6,
        length = 4
    )
    public final Builder pitchangle(float pitchangle) {
      this.pitchangle = pitchangle;
      return this;
    }

    /**
     * Pitch angle reference 
     */
    @MavlinkMessageField(
        position = 7,
        length = 4
    )
    public final Builder pitchangleref(float pitchangleref) {
      this.pitchangleref = pitchangleref;
      return this;
    }

    /**
     * null
     */
    @MavlinkMessageField(
        position = 8,
        length = 4
    )
    public final Builder q(float q) {
      this.q = q;
      return this;
    }

    /**
     * null
     */
    @MavlinkMessageField(
        position = 9,
        length = 4
    )
    public final Builder qref(float qref) {
      this.qref = qref;
      return this;
    }

    /**
     * null
     */
    @MavlinkMessageField(
        position = 10,
        length = 4
    )
    public final Builder uelev(float uelev) {
      this.uelev = uelev;
      return this;
    }

    /**
     * null
     */
    @MavlinkMessageField(
        position = 11,
        length = 4
    )
    public final Builder uthrot(float uthrot) {
      this.uthrot = uthrot;
      return this;
    }

    /**
     * null
     */
    @MavlinkMessageField(
        position = 12,
        length = 4
    )
    public final Builder uthrot2(float uthrot2) {
      this.uthrot2 = uthrot2;
      return this;
    }

    /**
     * null
     */
    @MavlinkMessageField(
        position = 13,
        length = 4
    )
    public final Builder nz(float nz) {
      this.nz = nz;
      return this;
    }

    /**
     * Airspeed reference 
     */
    @MavlinkMessageField(
        position = 14,
        length = 4
    )
    public final Builder airspeedref(float airspeedref) {
      this.airspeedref = airspeedref;
      return this;
    }

    /**
     * null
     */
    @MavlinkMessageField(
        position = 15,
        length = 1
    )
    public final Builder spoilersengaged(int spoilersengaged) {
      this.spoilersengaged = spoilersengaged;
      return this;
    }

    /**
     * Yaw angle 
     */
    @MavlinkMessageField(
        position = 16,
        length = 4
    )
    public final Builder yawangle(float yawangle) {
      this.yawangle = yawangle;
      return this;
    }

    /**
     * Yaw angle reference 
     */
    @MavlinkMessageField(
        position = 17,
        length = 4
    )
    public final Builder yawangleref(float yawangleref) {
      this.yawangleref = yawangleref;
      return this;
    }

    /**
     * Roll angle 
     */
    @MavlinkMessageField(
        position = 18,
        length = 4
    )
    public final Builder rollangle(float rollangle) {
      this.rollangle = rollangle;
      return this;
    }

    /**
     * Roll angle reference 
     */
    @MavlinkMessageField(
        position = 19,
        length = 4
    )
    public final Builder rollangleref(float rollangleref) {
      this.rollangleref = rollangleref;
      return this;
    }

    /**
     * null
     */
    @MavlinkMessageField(
        position = 20,
        length = 4
    )
    public final Builder p(float p) {
      this.p = p;
      return this;
    }

    /**
     * null
     */
    @MavlinkMessageField(
        position = 21,
        length = 4
    )
    public final Builder pref(float pref) {
      this.pref = pref;
      return this;
    }

    /**
     * null
     */
    @MavlinkMessageField(
        position = 22,
        length = 4
    )
    public final Builder r(float r) {
      this.r = r;
      return this;
    }

    /**
     * null
     */
    @MavlinkMessageField(
        position = 23,
        length = 4
    )
    public final Builder rref(float rref) {
      this.rref = rref;
      return this;
    }

    /**
     * null
     */
    @MavlinkMessageField(
        position = 24,
        length = 4
    )
    public final Builder uail(float uail) {
      this.uail = uail;
      return this;
    }

    /**
     * null
     */
    @MavlinkMessageField(
        position = 25,
        length = 4
    )
    public final Builder urud(float urud) {
      this.urud = urud;
      return this;
    }

    public final AslctrlData build() {
      return new AslctrlData(timestamp, aslctrlMode, h, href, hrefT, pitchangle, pitchangleref, q, qref, uelev, uthrot, uthrot2, nz, airspeedref, spoilersengaged, yawangle, yawangleref, rollangle, rollangleref, p, pref, r, rref, uail, urud);
    }
  }
}
