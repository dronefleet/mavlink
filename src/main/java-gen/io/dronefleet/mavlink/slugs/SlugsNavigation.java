package io.dronefleet.mavlink.slugs;

import io.dronefleet.mavlink.annotations.MavlinkMessage;
import io.dronefleet.mavlink.annotations.MavlinkMessageField;

/**
 * Data used in the navigation algorithm. 
 */
@MavlinkMessage(
    id = 176,
    crc = 228
)
public final class SlugsNavigation {
  /**
   * Measured Airspeed prior to the nav filter 
   */
  private final float uM;

  /**
   * Commanded Roll 
   */
  private final float phiC;

  /**
   * Commanded Pitch 
   */
  private final float thetaC;

  /**
   * Commanded Turn rate 
   */
  private final float psidotC;

  /**
   * Y component of the body acceleration 
   */
  private final float ayBody;

  /**
   * Total Distance to Run on this leg of Navigation 
   */
  private final float totaldist;

  /**
   * Remaining distance to Run on this leg of Navigation 
   */
  private final float dist2go;

  /**
   * Origin WP 
   */
  private final int fromwp;

  /**
   * Destination WP 
   */
  private final int towp;

  /**
   * Commanded altitude 
   */
  private final int hC;

  private SlugsNavigation(float uM, float phiC, float thetaC, float psidotC, float ayBody,
      float totaldist, float dist2go, int fromwp, int towp, int hC) {
    this.uM = uM;
    this.phiC = phiC;
    this.thetaC = thetaC;
    this.psidotC = psidotC;
    this.ayBody = ayBody;
    this.totaldist = totaldist;
    this.dist2go = dist2go;
    this.fromwp = fromwp;
    this.towp = towp;
    this.hC = hC;
  }

  public static Builder builder() {
    return new Builder();
  }

  /**
   * Measured Airspeed prior to the nav filter 
   */
  @MavlinkMessageField(
      position = 1,
      length = 4
  )
  public final float uM() {
    return uM;
  }

  /**
   * Commanded Roll 
   */
  @MavlinkMessageField(
      position = 2,
      length = 4
  )
  public final float phiC() {
    return phiC;
  }

  /**
   * Commanded Pitch 
   */
  @MavlinkMessageField(
      position = 3,
      length = 4
  )
  public final float thetaC() {
    return thetaC;
  }

  /**
   * Commanded Turn rate 
   */
  @MavlinkMessageField(
      position = 4,
      length = 4
  )
  public final float psidotC() {
    return psidotC;
  }

  /**
   * Y component of the body acceleration 
   */
  @MavlinkMessageField(
      position = 5,
      length = 4
  )
  public final float ayBody() {
    return ayBody;
  }

  /**
   * Total Distance to Run on this leg of Navigation 
   */
  @MavlinkMessageField(
      position = 6,
      length = 4
  )
  public final float totaldist() {
    return totaldist;
  }

  /**
   * Remaining distance to Run on this leg of Navigation 
   */
  @MavlinkMessageField(
      position = 7,
      length = 4
  )
  public final float dist2go() {
    return dist2go;
  }

  /**
   * Origin WP 
   */
  @MavlinkMessageField(
      position = 8,
      length = 1
  )
  public final int fromwp() {
    return fromwp;
  }

  /**
   * Destination WP 
   */
  @MavlinkMessageField(
      position = 9,
      length = 1
  )
  public final int towp() {
    return towp;
  }

  /**
   * Commanded altitude 
   */
  @MavlinkMessageField(
      position = 10,
      length = 2
  )
  public final int hC() {
    return hC;
  }

  public static class Builder {
    private float uM;

    private float phiC;

    private float thetaC;

    private float psidotC;

    private float ayBody;

    private float totaldist;

    private float dist2go;

    private int fromwp;

    private int towp;

    private int hC;

    private Builder() {
    }

    /**
     * Measured Airspeed prior to the nav filter 
     */
    @MavlinkMessageField(
        position = 1,
        length = 4
    )
    public final Builder uM(float uM) {
      this.uM = uM;
      return this;
    }

    /**
     * Commanded Roll 
     */
    @MavlinkMessageField(
        position = 2,
        length = 4
    )
    public final Builder phiC(float phiC) {
      this.phiC = phiC;
      return this;
    }

    /**
     * Commanded Pitch 
     */
    @MavlinkMessageField(
        position = 3,
        length = 4
    )
    public final Builder thetaC(float thetaC) {
      this.thetaC = thetaC;
      return this;
    }

    /**
     * Commanded Turn rate 
     */
    @MavlinkMessageField(
        position = 4,
        length = 4
    )
    public final Builder psidotC(float psidotC) {
      this.psidotC = psidotC;
      return this;
    }

    /**
     * Y component of the body acceleration 
     */
    @MavlinkMessageField(
        position = 5,
        length = 4
    )
    public final Builder ayBody(float ayBody) {
      this.ayBody = ayBody;
      return this;
    }

    /**
     * Total Distance to Run on this leg of Navigation 
     */
    @MavlinkMessageField(
        position = 6,
        length = 4
    )
    public final Builder totaldist(float totaldist) {
      this.totaldist = totaldist;
      return this;
    }

    /**
     * Remaining distance to Run on this leg of Navigation 
     */
    @MavlinkMessageField(
        position = 7,
        length = 4
    )
    public final Builder dist2go(float dist2go) {
      this.dist2go = dist2go;
      return this;
    }

    /**
     * Origin WP 
     */
    @MavlinkMessageField(
        position = 8,
        length = 1
    )
    public final Builder fromwp(int fromwp) {
      this.fromwp = fromwp;
      return this;
    }

    /**
     * Destination WP 
     */
    @MavlinkMessageField(
        position = 9,
        length = 1
    )
    public final Builder towp(int towp) {
      this.towp = towp;
      return this;
    }

    /**
     * Commanded altitude 
     */
    @MavlinkMessageField(
        position = 10,
        length = 2
    )
    public final Builder hC(int hC) {
      this.hC = hC;
      return this;
    }

    public final SlugsNavigation build() {
      return new SlugsNavigation(uM, phiC, thetaC, psidotC, ayBody, totaldist, dist2go, fromwp, towp, hC);
    }
  }
}
