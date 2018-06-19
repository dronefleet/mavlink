package io.dronefleet.mavlink.slugs;

import io.dronefleet.mavlink.annotations.MavlinkMessage;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageField;
import java.lang.Override;
import java.lang.String;

/**
 * Transmits the diagnostics data from the Novatel OEMStar GPS 
 */
@MavlinkMessage(
    id = 195,
    crc = 59
)
public final class NovatelDiag {
  /**
   * Status Bitfield. See table 69 page 350 Novatel OEMstar Manual 
   */
  private final long receiverstatus;

  /**
   * Age of the position solution 
   */
  private final float possolage;

  /**
   * Times the CRC has failed since boot 
   */
  private final int csfails;

  /**
   * The Time Status. See Table 8 page 27 Novatel OEMStar Manual 
   */
  private final int timestatus;

  /**
   * solution Status. See table 44 page 197 
   */
  private final int solstatus;

  /**
   * position type. See table 43 page 196 
   */
  private final int postype;

  /**
   * velocity type. See table 43 page 196 
   */
  private final int veltype;

  private NovatelDiag(long receiverstatus, float possolage, int csfails, int timestatus,
      int solstatus, int postype, int veltype) {
    this.receiverstatus = receiverstatus;
    this.possolage = possolage;
    this.csfails = csfails;
    this.timestatus = timestatus;
    this.solstatus = solstatus;
    this.postype = postype;
    this.veltype = veltype;
  }

  @MavlinkMessageBuilder
  public static Builder builder() {
    return new Builder();
  }

  @Override
  public String toString() {
    return "NovatelDiag{timestatus=" + timestatus
         + ", receiverstatus=" + receiverstatus
         + ", solstatus=" + solstatus
         + ", postype=" + postype
         + ", veltype=" + veltype
         + ", possolage=" + possolage
         + ", csfails=" + csfails + "}";
  }

  /**
   * Status Bitfield. See table 69 page 350 Novatel OEMstar Manual 
   */
  @MavlinkMessageField(
      position = 2,
      unitSize = 4
  )
  public final long receiverstatus() {
    return receiverstatus;
  }

  /**
   * Age of the position solution 
   */
  @MavlinkMessageField(
      position = 6,
      unitSize = 4
  )
  public final float possolage() {
    return possolage;
  }

  /**
   * Times the CRC has failed since boot 
   */
  @MavlinkMessageField(
      position = 7,
      unitSize = 2
  )
  public final int csfails() {
    return csfails;
  }

  /**
   * The Time Status. See Table 8 page 27 Novatel OEMStar Manual 
   */
  @MavlinkMessageField(
      position = 1,
      unitSize = 1
  )
  public final int timestatus() {
    return timestatus;
  }

  /**
   * solution Status. See table 44 page 197 
   */
  @MavlinkMessageField(
      position = 3,
      unitSize = 1
  )
  public final int solstatus() {
    return solstatus;
  }

  /**
   * position type. See table 43 page 196 
   */
  @MavlinkMessageField(
      position = 4,
      unitSize = 1
  )
  public final int postype() {
    return postype;
  }

  /**
   * velocity type. See table 43 page 196 
   */
  @MavlinkMessageField(
      position = 5,
      unitSize = 1
  )
  public final int veltype() {
    return veltype;
  }

  public static class Builder {
    private long receiverstatus;

    private float possolage;

    private int csfails;

    private int timestatus;

    private int solstatus;

    private int postype;

    private int veltype;

    private Builder() {
    }

    /**
     * Status Bitfield. See table 69 page 350 Novatel OEMstar Manual 
     */
    @MavlinkMessageField(
        position = 2,
        unitSize = 4
    )
    public final Builder receiverstatus(long receiverstatus) {
      this.receiverstatus = receiverstatus;
      return this;
    }

    /**
     * Age of the position solution 
     */
    @MavlinkMessageField(
        position = 6,
        unitSize = 4
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
        unitSize = 2
    )
    public final Builder csfails(int csfails) {
      this.csfails = csfails;
      return this;
    }

    /**
     * The Time Status. See Table 8 page 27 Novatel OEMStar Manual 
     */
    @MavlinkMessageField(
        position = 1,
        unitSize = 1
    )
    public final Builder timestatus(int timestatus) {
      this.timestatus = timestatus;
      return this;
    }

    /**
     * solution Status. See table 44 page 197 
     */
    @MavlinkMessageField(
        position = 3,
        unitSize = 1
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
        unitSize = 1
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
        unitSize = 1
    )
    public final Builder veltype(int veltype) {
      this.veltype = veltype;
      return this;
    }

    public final NovatelDiag build() {
      return new NovatelDiag(receiverstatus, possolage, csfails, timestatus, solstatus, postype, veltype);
    }
  }
}
