package io.dronefleet.mavlink.slugs;

import io.dronefleet.mavlink.annotations.MavlinkMessage;
import io.dronefleet.mavlink.annotations.MavlinkMessageField;

/**
 * This contains the status of the GPS readings 
 */
@MavlinkMessage(
    id = 194,
    crc = 51
)
public final class StatusGps {
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
   * Magnetic variation 
   */
  private final float magvar;

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

  private StatusGps(int csfails, int gpsquality, int msgstype, int posstatus, float magvar,
      int magdir, int modeind) {
    this.csfails = csfails;
    this.gpsquality = gpsquality;
    this.msgstype = msgstype;
    this.posstatus = posstatus;
    this.magvar = magvar;
    this.magdir = magdir;
    this.modeind = modeind;
  }

  public static Builder builder() {
    return new Builder();
  }

  /**
   * Number of times checksum has failed 
   */
  @MavlinkMessageField(
      position = 1,
      length = 2
  )
  public final int csfails() {
    return csfails;
  }

  /**
   * The quality indicator, 0=fix not available or invalid, 1=GPS fix, 2=C/A differential GPS, 
   * 6=Dead reckoning mode, 7=Manual input mode (fixed position), 8=Simulator mode, 9= WAAS a 
   */
  @MavlinkMessageField(
      position = 2,
      length = 1
  )
  public final int gpsquality() {
    return gpsquality;
  }

  /**
   * Indicates if GN, GL or GP messages are being received 
   */
  @MavlinkMessageField(
      position = 3,
      length = 1
  )
  public final int msgstype() {
    return msgstype;
  }

  /**
   * A = data valid, V = data invalid 
   */
  @MavlinkMessageField(
      position = 4,
      length = 1
  )
  public final int posstatus() {
    return posstatus;
  }

  /**
   * Magnetic variation 
   */
  @MavlinkMessageField(
      position = 5,
      length = 4
  )
  public final float magvar() {
    return magvar;
  }

  /**
   * Magnetic variation direction E/W. Easterly variation (E) subtracts from True course and 
   * Westerly variation (W) adds to True course 
   */
  @MavlinkMessageField(
      position = 6,
      length = 1
  )
  public final int magdir() {
    return magdir;
  }

  /**
   * Positioning system mode indicator. A - Autonomous;D-Differential; E-Estimated (dead 
   * reckoning) mode;M-Manual input; N-Data not valid 
   */
  @MavlinkMessageField(
      position = 7,
      length = 1
  )
  public final int modeind() {
    return modeind;
  }

  public static class Builder {
    private int csfails;

    private int gpsquality;

    private int msgstype;

    private int posstatus;

    private float magvar;

    private int magdir;

    private int modeind;

    private Builder() {
    }

    /**
     * Number of times checksum has failed 
     */
    @MavlinkMessageField(
        position = 1,
        length = 2
    )
    public final Builder csfails(int csfails) {
      this.csfails = csfails;
      return this;
    }

    /**
     * The quality indicator, 0=fix not available or invalid, 1=GPS fix, 2=C/A differential GPS, 
     * 6=Dead reckoning mode, 7=Manual input mode (fixed position), 8=Simulator mode, 9= WAAS a 
     */
    @MavlinkMessageField(
        position = 2,
        length = 1
    )
    public final Builder gpsquality(int gpsquality) {
      this.gpsquality = gpsquality;
      return this;
    }

    /**
     * Indicates if GN, GL or GP messages are being received 
     */
    @MavlinkMessageField(
        position = 3,
        length = 1
    )
    public final Builder msgstype(int msgstype) {
      this.msgstype = msgstype;
      return this;
    }

    /**
     * A = data valid, V = data invalid 
     */
    @MavlinkMessageField(
        position = 4,
        length = 1
    )
    public final Builder posstatus(int posstatus) {
      this.posstatus = posstatus;
      return this;
    }

    /**
     * Magnetic variation 
     */
    @MavlinkMessageField(
        position = 5,
        length = 4
    )
    public final Builder magvar(float magvar) {
      this.magvar = magvar;
      return this;
    }

    /**
     * Magnetic variation direction E/W. Easterly variation (E) subtracts from True course and 
     * Westerly variation (W) adds to True course 
     */
    @MavlinkMessageField(
        position = 6,
        length = 1
    )
    public final Builder magdir(int magdir) {
      this.magdir = magdir;
      return this;
    }

    /**
     * Positioning system mode indicator. A - Autonomous;D-Differential; E-Estimated (dead 
     * reckoning) mode;M-Manual input; N-Data not valid 
     */
    @MavlinkMessageField(
        position = 7,
        length = 1
    )
    public final Builder modeind(int modeind) {
      this.modeind = modeind;
      return this;
    }

    public final StatusGps build() {
      return new StatusGps(csfails, gpsquality, msgstype, posstatus, magvar, magdir, modeind);
    }
  }
}
