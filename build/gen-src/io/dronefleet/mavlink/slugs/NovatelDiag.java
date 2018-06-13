package io.dronefleet.mavlink.slugs;

import io.dronefleet.mavlink.annotations.MavlinkMessage;
import io.dronefleet.mavlink.annotations.MavlinkMessageField;

/**
 * Transmits the diagnostics data from the Novatel OEMStar GPS 
 */
@MavlinkMessage(
    id = 195,
    crc = 59
)
public final class NovatelDiag {
  private final int timestatus;

  private final long receiverstatus;

  private final int solstatus;

  private final int postype;

  private final int veltype;

  private final float possolage;

  private final int csfails;

  private NovatelDiag(int timestatus, long receiverstatus, int solstatus, int postype, int veltype,
      float possolage, int csfails) {
    this.timestatus = timestatus;
    this.receiverstatus = receiverstatus;
    this.solstatus = solstatus;
    this.postype = postype;
    this.veltype = veltype;
    this.possolage = possolage;
    this.csfails = csfails;
  }

  public static Builder builder() {
    return new Builder();
  }

  /**
   * The Time Status. See Table 8 page 27 Novatel OEMStar Manual 
   */
  @MavlinkMessageField(
      position = 1,
      length = 1
  )
  public final int timestatus() {
    return timestatus;
  }

  /**
   * Status Bitfield. See table 69 page 350 Novatel OEMstar Manual 
   */
  @MavlinkMessageField(
      position = 2,
      length = 4
  )
  public final long receiverstatus() {
    return receiverstatus;
  }

  /**
   * solution Status. See table 44 page 197 
   */
  @MavlinkMessageField(
      position = 3,
      length = 1
  )
  public final int solstatus() {
    return solstatus;
  }

  /**
   * position type. See table 43 page 196 
   */
  @MavlinkMessageField(
      position = 4,
      length = 1
  )
  public final int postype() {
    return postype;
  }

  /**
   * velocity type. See table 43 page 196 
   */
  @MavlinkMessageField(
      position = 5,
      length = 1
  )
  public final int veltype() {
    return veltype;
  }

  /**
   * Age of the position solution 
   */
  @MavlinkMessageField(
      position = 6,
      length = 4
  )
  public final float possolage() {
    return possolage;
  }

  /**
   * Times the CRC has failed since boot 
   */
  @MavlinkMessageField(
      position = 7,
      length = 2
  )
  public final int csfails() {
    return csfails;
  }

  public class Builder {
    private int timestatus;

    private long receiverstatus;

    private int solstatus;

    private int postype;

    private int veltype;

    private float possolage;

    private int csfails;

    private Builder() {
    }

    /**
     * The Time Status. See Table 8 page 27 Novatel OEMStar Manual 
     */
    @MavlinkMessageField(
        position = 1,
        length = 1
    )
    public final Builder timestatus(int timestatus) {
      this.timestatus = timestatus;
      return this;
    }

    /**
     * Status Bitfield. See table 69 page 350 Novatel OEMstar Manual 
     */
    @MavlinkMessageField(
        position = 2,
        length = 4
    )
    public final Builder receiverstatus(long receiverstatus) {
      this.receiverstatus = receiverstatus;
      return this;
    }

    /**
     * solution Status. See table 44 page 197 
     */
    @MavlinkMessageField(
        position = 3,
        length = 1
    )
    public final Builder solstatus(int solstatus) {
      this.solstatus = solstatus;
      return this;
    }

    /**
     * position type. See table 43 page 196 
     */
    @MavlinkMessageField(
        position = 4,
        length = 1
    )
    public final Builder postype(int postype) {
      this.postype = postype;
      return this;
    }

    /**
     * velocity type. See table 43 page 196 
     */
    @MavlinkMessageField(
        position = 5,
        length = 1
    )
    public final Builder veltype(int veltype) {
      this.veltype = veltype;
      return this;
    }

    /**
     * Age of the position solution 
     */
    @MavlinkMessageField(
        position = 6,
        length = 4
    )
    public final Builder possolage(float possolage) {
      this.possolage = possolage;
      return this;
    }

    /**
     * Times the CRC has failed since boot 
     */
    @MavlinkMessageField(
        position = 7,
        length = 2
    )
    public final Builder csfails(int csfails) {
      this.csfails = csfails;
      return this;
    }

    public final NovatelDiag build() {
      return new NovatelDiag(timestatus, receiverstatus, solstatus, postype, veltype, possolage, csfails);
    }
  }
}
