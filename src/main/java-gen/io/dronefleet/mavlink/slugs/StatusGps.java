package io.dronefleet.mavlink.slugs;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import java.lang.Override;
import java.lang.String;

/**
 * This contains the status of the GPS readings 
 */
@MavlinkMessageInfo(
    id = 194,
    crc = 51
)
public final class StatusGps {
  /**
   * Magnetic variation 
   */
  private final float magvar;

  /**
   * Number of times checksum has failed 
   */
  private final int csfails;

  /**
   * The quality indicator, 0=fix not available or invalid, 1=GPS fix, 2=C/A differential GPS, 
   * 6=Dead reckoning mode, 7=Manual input mode (fixed position), 8=Simulator mode, 9= WAAS a 
   */
  private final int gpsquality;

  /**
   * Indicates if GN, GL or GP messages are being received 
   */
  private final int msgstype;

  /**
   * A = data valid, V = data invalid 
   */
  private final int posstatus;

  /**
   * Magnetic variation direction E/W. Easterly variation (E) subtracts from True course and 
   * Westerly variation (W) adds to True course 
   */
  private final int magdir;

  /**
   * Positioning system mode indicator. A - Autonomous;D-Differential; E-Estimated (dead 
   * reckoning) mode;M-Manual input; N-Data not valid 
   */
  private final int modeind;

  private StatusGps(float magvar, int csfails, int gpsquality, int msgstype, int posstatus,
      int magdir, int modeind) {
    this.magvar = magvar;
    this.csfails = csfails;
    this.gpsquality = gpsquality;
    this.msgstype = msgstype;
    this.posstatus = posstatus;
    this.magdir = magdir;
    this.modeind = modeind;
  }

  @MavlinkMessageBuilder
  public static Builder builder() {
    return new Builder();
  }

  @Override
  public String toString() {
    return "StatusGps{csfails=" + csfails
         + ", gpsquality=" + gpsquality
         + ", msgstype=" + msgstype
         + ", posstatus=" + posstatus
         + ", magvar=" + magvar
         + ", magdir=" + magdir
         + ", modeind=" + modeind + "}";
  }

  /**
   * Magnetic variation 
   */
  @MavlinkFieldInfo(
      position = 5,
      unitSize = 4
  )
  public final float magvar() {
    return magvar;
  }

  /**
   * Number of times checksum has failed 
   */
  @MavlinkFieldInfo(
      position = 1,
      unitSize = 2
  )
  public final int csfails() {
    return csfails;
  }

  /**
   * The quality indicator, 0=fix not available or invalid, 1=GPS fix, 2=C/A differential GPS, 
   * 6=Dead reckoning mode, 7=Manual input mode (fixed position), 8=Simulator mode, 9= WAAS a 
   */
  @MavlinkFieldInfo(
      position = 2,
      unitSize = 1
  )
  public final int gpsquality() {
    return gpsquality;
  }

  /**
   * Indicates if GN, GL or GP messages are being received 
   */
  @MavlinkFieldInfo(
      position = 3,
      unitSize = 1
  )
  public final int msgstype() {
    return msgstype;
  }

  /**
   * A = data valid, V = data invalid 
   */
  @MavlinkFieldInfo(
      position = 4,
      unitSize = 1
  )
  public final int posstatus() {
    return posstatus;
  }

  /**
   * Magnetic variation direction E/W. Easterly variation (E) subtracts from True course and 
   * Westerly variation (W) adds to True course 
   */
  @MavlinkFieldInfo(
      position = 6,
      unitSize = 1
  )
  public final int magdir() {
    return magdir;
  }

  /**
   * Positioning system mode indicator. A - Autonomous;D-Differential; E-Estimated (dead 
   * reckoning) mode;M-Manual input; N-Data not valid 
   */
  @MavlinkFieldInfo(
      position = 7,
      unitSize = 1
  )
  public final int modeind() {
    return modeind;
  }

  public static class Builder {
    private float magvar;

    private int csfails;

    private int gpsquality;

    private int msgstype;

    private int posstatus;

    private int magdir;

    private int modeind;

    private Builder() {
    }

    /**
     * Magnetic variation 
     */
    @MavlinkFieldInfo(
        position = 5,
        unitSize = 4
    )
    public final Builder magvar(float magvar) {
      this.magvar = magvar;
      return this;
    }

    /**
     * Number of times checksum has failed 
     */
    @MavlinkFieldInfo(
        position = 1,
        unitSize = 2
    )
    public final Builder csfails(int csfails) {
      this.csfails = csfails;
      return this;
    }

    /**
     * The quality indicator, 0=fix not available or invalid, 1=GPS fix, 2=C/A differential GPS, 
     * 6=Dead reckoning mode, 7=Manual input mode (fixed position), 8=Simulator mode, 9= WAAS a 
     */
    @MavlinkFieldInfo(
        position = 2,
        unitSize = 1
    )
    public final Builder gpsquality(int gpsquality) {
      this.gpsquality = gpsquality;
      return this;
    }

    /**
     * Indicates if GN, GL or GP messages are being received 
     */
    @MavlinkFieldInfo(
        position = 3,
        unitSize = 1
    )
    public final Builder msgstype(int msgstype) {
      this.msgstype = msgstype;
      return this;
    }

    /**
     * A = data valid, V = data invalid 
     */
    @MavlinkFieldInfo(
        position = 4,
        unitSize = 1
    )
    public final Builder posstatus(int posstatus) {
      this.posstatus = posstatus;
      return this;
    }

    /**
     * Magnetic variation direction E/W. Easterly variation (E) subtracts from True course and 
     * Westerly variation (W) adds to True course 
     */
    @MavlinkFieldInfo(
        position = 6,
        unitSize = 1
    )
    public final Builder magdir(int magdir) {
      this.magdir = magdir;
      return this;
    }

    /**
     * Positioning system mode indicator. A - Autonomous;D-Differential; E-Estimated (dead 
     * reckoning) mode;M-Manual input; N-Data not valid 
     */
    @MavlinkFieldInfo(
        position = 7,
        unitSize = 1
    )
    public final Builder modeind(int modeind) {
      this.modeind = modeind;
      return this;
    }

    public final StatusGps build() {
      return new StatusGps(magvar, csfails, gpsquality, msgstype, posstatus, magdir, modeind);
    }
  }
}
