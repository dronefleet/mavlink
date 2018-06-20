package io.dronefleet.mavlink.asluav;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import java.lang.Override;
import java.lang.String;
import java.math.BigInteger;

/**
 * ASL-fixed-wing controller data 
 */
@MavlinkMessageInfo(
    id = 203,
    crc = 172
)
public final class AslctrlData {
  /**
   * Timestamp 
   */
  private final BigInteger timestamp;

  /**
   * See sourcecode for a description of these values... 
   */
  private final float h;

  /**
   * null
   */
  private final float href;

  /**
   * null
   */
  private final float hrefT;

  /**
   * Pitch angle 
   */
  private final float pitchangle;

  /**
   * Pitch angle reference 
   */
  private final float pitchangleref;

  /**
   * null
   */
  private final float q;

  /**
   * null
   */
  private final float qref;

  /**
   * null
   */
  private final float uelev;

  /**
   * null
   */
  private final float uthrot;

  /**
   * null
   */
  private final float uthrot2;

  /**
   * null
   */
  private final float nz;

  /**
   * Airspeed reference 
   */
  private final float airspeedref;

  /**
   * Yaw angle 
   */
  private final float yawangle;

  /**
   * Yaw angle reference 
   */
  private final float yawangleref;

  /**
   * Roll angle 
   */
  private final float rollangle;

  /**
   * Roll angle reference 
   */
  private final float rollangleref;

  /**
   * null
   */
  private final float p;

  /**
   * null
   */
  private final float pref;

  /**
   * null
   */
  private final float r;

  /**
   * null
   */
  private final float rref;

  /**
   * null
   */
  private final float uail;

  /**
   * null
   */
  private final float urud;

  /**
   * ASLCTRL control-mode (manual, stabilized, auto, etc...) 
   */
  private final int aslctrlMode;

  /**
   * null
   */
  private final int spoilersengaged;

  private AslctrlData(BigInteger timestamp, float h, float href, float hrefT, float pitchangle,
      float pitchangleref, float q, float qref, float uelev, float uthrot, float uthrot2, float nz,
      float airspeedref, float yawangle, float yawangleref, float rollangle, float rollangleref,
      float p, float pref, float r, float rref, float uail, float urud, int aslctrlMode,
      int spoilersengaged) {
    this.timestamp = timestamp;
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
    this.aslctrlMode = aslctrlMode;
    this.spoilersengaged = spoilersengaged;
  }

  @MavlinkMessageBuilder
  public static Builder builder() {
    return new Builder();
  }

  @Override
  public String toString() {
    return "AslctrlData{timestamp=" + timestamp
         + ", aslctrlMode=" + aslctrlMode
         + ", h=" + h
         + ", href=" + href
         + ", hrefT=" + hrefT
         + ", pitchangle=" + pitchangle
         + ", pitchangleref=" + pitchangleref
         + ", q=" + q
         + ", qref=" + qref
         + ", uelev=" + uelev
         + ", uthrot=" + uthrot
         + ", uthrot2=" + uthrot2
         + ", nz=" + nz
         + ", airspeedref=" + airspeedref
         + ", spoilersengaged=" + spoilersengaged
         + ", yawangle=" + yawangle
         + ", yawangleref=" + yawangleref
         + ", rollangle=" + rollangle
         + ", rollangleref=" + rollangleref
         + ", p=" + p
         + ", pref=" + pref
         + ", r=" + r
         + ", rref=" + rref
         + ", uail=" + uail
         + ", urud=" + urud + "}";
  }

  /**
   * Timestamp 
   */
  @MavlinkFieldInfo(
      position = 1,
      unitSize = 8
  )
  public final BigInteger timestamp() {
    return timestamp;
  }

  /**
   * See sourcecode for a description of these values... 
   */
  @MavlinkFieldInfo(
      position = 3,
      unitSize = 4
  )
  public final float h() {
    return h;
  }

  /**
   * null
   */
  @MavlinkFieldInfo(
      position = 4,
      unitSize = 4
  )
  public final float href() {
    return href;
  }

  /**
   * null
   */
  @MavlinkFieldInfo(
      position = 5,
      unitSize = 4
  )
  public final float hrefT() {
    return hrefT;
  }

  /**
   * Pitch angle 
   */
  @MavlinkFieldInfo(
      position = 6,
      unitSize = 4
  )
  public final float pitchangle() {
    return pitchangle;
  }

  /**
   * Pitch angle reference 
   */
  @MavlinkFieldInfo(
      position = 7,
      unitSize = 4
  )
  public final float pitchangleref() {
    return pitchangleref;
  }

  /**
   * null
   */
  @MavlinkFieldInfo(
      position = 8,
      unitSize = 4
  )
  public final float q() {
    return q;
  }

  /**
   * null
   */
  @MavlinkFieldInfo(
      position = 9,
      unitSize = 4
  )
  public final float qref() {
    return qref;
  }

  /**
   * null
   */
  @MavlinkFieldInfo(
      position = 10,
      unitSize = 4
  )
  public final float uelev() {
    return uelev;
  }

  /**
   * null
   */
  @MavlinkFieldInfo(
      position = 11,
      unitSize = 4
  )
  public final float uthrot() {
    return uthrot;
  }

  /**
   * null
   */
  @MavlinkFieldInfo(
      position = 12,
      unitSize = 4
  )
  public final float uthrot2() {
    return uthrot2;
  }

  /**
   * null
   */
  @MavlinkFieldInfo(
      position = 13,
      unitSize = 4
  )
  public final float nz() {
    return nz;
  }

  /**
   * Airspeed reference 
   */
  @MavlinkFieldInfo(
      position = 14,
      unitSize = 4
  )
  public final float airspeedref() {
    return airspeedref;
  }

  /**
   * Yaw angle 
   */
  @MavlinkFieldInfo(
      position = 16,
      unitSize = 4
  )
  public final float yawangle() {
    return yawangle;
  }

  /**
   * Yaw angle reference 
   */
  @MavlinkFieldInfo(
      position = 17,
      unitSize = 4
  )
  public final float yawangleref() {
    return yawangleref;
  }

  /**
   * Roll angle 
   */
  @MavlinkFieldInfo(
      position = 18,
      unitSize = 4
  )
  public final float rollangle() {
    return rollangle;
  }

  /**
   * Roll angle reference 
   */
  @MavlinkFieldInfo(
      position = 19,
      unitSize = 4
  )
  public final float rollangleref() {
    return rollangleref;
  }

  /**
   * null
   */
  @MavlinkFieldInfo(
      position = 20,
      unitSize = 4
  )
  public final float p() {
    return p;
  }

  /**
   * null
   */
  @MavlinkFieldInfo(
      position = 21,
      unitSize = 4
  )
  public final float pref() {
    return pref;
  }

  /**
   * null
   */
  @MavlinkFieldInfo(
      position = 22,
      unitSize = 4
  )
  public final float r() {
    return r;
  }

  /**
   * null
   */
  @MavlinkFieldInfo(
      position = 23,
      unitSize = 4
  )
  public final float rref() {
    return rref;
  }

  /**
   * null
   */
  @MavlinkFieldInfo(
      position = 24,
      unitSize = 4
  )
  public final float uail() {
    return uail;
  }

  /**
   * null
   */
  @MavlinkFieldInfo(
      position = 25,
      unitSize = 4
  )
  public final float urud() {
    return urud;
  }

  /**
   * ASLCTRL control-mode (manual, stabilized, auto, etc...) 
   */
  @MavlinkFieldInfo(
      position = 2,
      unitSize = 1
  )
  public final int aslctrlMode() {
    return aslctrlMode;
  }

  /**
   * null
   */
  @MavlinkFieldInfo(
      position = 15,
      unitSize = 1
  )
  public final int spoilersengaged() {
    return spoilersengaged;
  }

  public static class Builder {
    private BigInteger timestamp;

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

    private int aslctrlMode;

    private int spoilersengaged;

    private Builder() {
    }

    /**
     * Timestamp 
     */
    @MavlinkFieldInfo(
        position = 1,
        unitSize = 8
    )
    public final Builder timestamp(BigInteger timestamp) {
      this.timestamp = timestamp;
      return this;
    }

    /**
     * See sourcecode for a description of these values... 
     */
    @MavlinkFieldInfo(
        position = 3,
        unitSize = 4
    )
    public final Builder h(float h) {
      this.h = h;
      return this;
    }

    /**
     * null
     */
    @MavlinkFieldInfo(
        position = 4,
        unitSize = 4
    )
    public final Builder href(float href) {
      this.href = href;
      return this;
    }

    /**
     * null
     */
    @MavlinkFieldInfo(
        position = 5,
        unitSize = 4
    )
    public final Builder hrefT(float hrefT) {
      this.hrefT = hrefT;
      return this;
    }

    /**
     * Pitch angle 
     */
    @MavlinkFieldInfo(
        position = 6,
        unitSize = 4
    )
    public final Builder pitchangle(float pitchangle) {
      this.pitchangle = pitchangle;
      return this;
    }

    /**
     * Pitch angle reference 
     */
    @MavlinkFieldInfo(
        position = 7,
        unitSize = 4
    )
    public final Builder pitchangleref(float pitchangleref) {
      this.pitchangleref = pitchangleref;
      return this;
    }

    /**
     * null
     */
    @MavlinkFieldInfo(
        position = 8,
        unitSize = 4
    )
    public final Builder q(float q) {
      this.q = q;
      return this;
    }

    /**
     * null
     */
    @MavlinkFieldInfo(
        position = 9,
        unitSize = 4
    )
    public final Builder qref(float qref) {
      this.qref = qref;
      return this;
    }

    /**
     * null
     */
    @MavlinkFieldInfo(
        position = 10,
        unitSize = 4
    )
    public final Builder uelev(float uelev) {
      this.uelev = uelev;
      return this;
    }

    /**
     * null
     */
    @MavlinkFieldInfo(
        position = 11,
        unitSize = 4
    )
    public final Builder uthrot(float uthrot) {
      this.uthrot = uthrot;
      return this;
    }

    /**
     * null
     */
    @MavlinkFieldInfo(
        position = 12,
        unitSize = 4
    )
    public final Builder uthrot2(float uthrot2) {
      this.uthrot2 = uthrot2;
      return this;
    }

    /**
     * null
     */
    @MavlinkFieldInfo(
        position = 13,
        unitSize = 4
    )
    public final Builder nz(float nz) {
      this.nz = nz;
      return this;
    }

    /**
     * Airspeed reference 
     */
    @MavlinkFieldInfo(
        position = 14,
        unitSize = 4
    )
    public final Builder airspeedref(float airspeedref) {
      this.airspeedref = airspeedref;
      return this;
    }

    /**
     * Yaw angle 
     */
    @MavlinkFieldInfo(
        position = 16,
        unitSize = 4
    )
    public final Builder yawangle(float yawangle) {
      this.yawangle = yawangle;
      return this;
    }

    /**
     * Yaw angle reference 
     */
    @MavlinkFieldInfo(
        position = 17,
        unitSize = 4
    )
    public final Builder yawangleref(float yawangleref) {
      this.yawangleref = yawangleref;
      return this;
    }

    /**
     * Roll angle 
     */
    @MavlinkFieldInfo(
        position = 18,
        unitSize = 4
    )
    public final Builder rollangle(float rollangle) {
      this.rollangle = rollangle;
      return this;
    }

    /**
     * Roll angle reference 
     */
    @MavlinkFieldInfo(
        position = 19,
        unitSize = 4
    )
    public final Builder rollangleref(float rollangleref) {
      this.rollangleref = rollangleref;
      return this;
    }

    /**
     * null
     */
    @MavlinkFieldInfo(
        position = 20,
        unitSize = 4
    )
    public final Builder p(float p) {
      this.p = p;
      return this;
    }

    /**
     * null
     */
    @MavlinkFieldInfo(
        position = 21,
        unitSize = 4
    )
    public final Builder pref(float pref) {
      this.pref = pref;
      return this;
    }

    /**
     * null
     */
    @MavlinkFieldInfo(
        position = 22,
        unitSize = 4
    )
    public final Builder r(float r) {
      this.r = r;
      return this;
    }

    /**
     * null
     */
    @MavlinkFieldInfo(
        position = 23,
        unitSize = 4
    )
    public final Builder rref(float rref) {
      this.rref = rref;
      return this;
    }

    /**
     * null
     */
    @MavlinkFieldInfo(
        position = 24,
        unitSize = 4
    )
    public final Builder uail(float uail) {
      this.uail = uail;
      return this;
    }

    /**
     * null
     */
    @MavlinkFieldInfo(
        position = 25,
        unitSize = 4
    )
    public final Builder urud(float urud) {
      this.urud = urud;
      return this;
    }

    /**
     * ASLCTRL control-mode (manual, stabilized, auto, etc...) 
     */
    @MavlinkFieldInfo(
        position = 2,
        unitSize = 1
    )
    public final Builder aslctrlMode(int aslctrlMode) {
      this.aslctrlMode = aslctrlMode;
      return this;
    }

    /**
     * null
     */
    @MavlinkFieldInfo(
        position = 15,
        unitSize = 1
    )
    public final Builder spoilersengaged(int spoilersengaged) {
      this.spoilersengaged = spoilersengaged;
      return this;
    }

    public final AslctrlData build() {
      return new AslctrlData(timestamp, h, href, hrefT, pitchangle, pitchangleref, q, qref, uelev, uthrot, uthrot2, nz, airspeedref, yawangle, yawangleref, rollangle, rollangleref, p, pref, r, rref, uail, urud, aslctrlMode, spoilersengaged);
    }
  }
}
