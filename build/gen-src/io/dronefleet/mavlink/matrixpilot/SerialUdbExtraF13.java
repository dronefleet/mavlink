package io.dronefleet.mavlink.matrixpilot;

import io.dronefleet.mavlink.annotations.MavlinkMessage;
import io.dronefleet.mavlink.annotations.MavlinkMessageField;

/**
 * Backwards compatible version of SERIAL_UDB_EXTRA F13: format 
 */
@MavlinkMessage(
    id = 177,
    crc = 249
)
public final class SerialUdbExtraF13 {
  private final int sueWeekNo;

  private final int sueLatOrigin;

  private final int sueLonOrigin;

  private final int sueAltOrigin;

  private SerialUdbExtraF13(int sueWeekNo, int sueLatOrigin, int sueLonOrigin, int sueAltOrigin) {
    this.sueWeekNo = sueWeekNo;
    this.sueLatOrigin = sueLatOrigin;
    this.sueLonOrigin = sueLonOrigin;
    this.sueAltOrigin = sueAltOrigin;
  }

  public static Builder builder() {
    return new Builder();
  }

  /**
   * Serial UDB Extra GPS Week Number 
   */
  @MavlinkMessageField(
      position = 1,
      length = 2
  )
  public final int sueWeekNo() {
    return sueWeekNo;
  }

  /**
   * Serial UDB Extra MP Origin Latitude 
   */
  @MavlinkMessageField(
      position = 2,
      length = 4
  )
  public final int sueLatOrigin() {
    return sueLatOrigin;
  }

  /**
   * Serial UDB Extra MP Origin Longitude 
   */
  @MavlinkMessageField(
      position = 3,
      length = 4
  )
  public final int sueLonOrigin() {
    return sueLonOrigin;
  }

  /**
   * Serial UDB Extra MP Origin Altitude Above Sea Level 
   */
  @MavlinkMessageField(
      position = 4,
      length = 4
  )
  public final int sueAltOrigin() {
    return sueAltOrigin;
  }

  public class Builder {
    private int sueWeekNo;

    private int sueLatOrigin;

    private int sueLonOrigin;

    private int sueAltOrigin;

    private Builder() {
    }

    /**
     * Serial UDB Extra GPS Week Number 
     */
    @MavlinkMessageField(
        position = 1,
        length = 2
    )
    public final Builder sueWeekNo(int sueWeekNo) {
      this.sueWeekNo = sueWeekNo;
      return this;
    }

    /**
     * Serial UDB Extra MP Origin Latitude 
     */
    @MavlinkMessageField(
        position = 2,
        length = 4
    )
    public final Builder sueLatOrigin(int sueLatOrigin) {
      this.sueLatOrigin = sueLatOrigin;
      return this;
    }

    /**
     * Serial UDB Extra MP Origin Longitude 
     */
    @MavlinkMessageField(
        position = 3,
        length = 4
    )
    public final Builder sueLonOrigin(int sueLonOrigin) {
      this.sueLonOrigin = sueLonOrigin;
      return this;
    }

    /**
     * Serial UDB Extra MP Origin Altitude Above Sea Level 
     */
    @MavlinkMessageField(
        position = 4,
        length = 4
    )
    public final Builder sueAltOrigin(int sueAltOrigin) {
      this.sueAltOrigin = sueAltOrigin;
      return this;
    }

    public final SerialUdbExtraF13 build() {
      return new SerialUdbExtraF13(sueWeekNo, sueLatOrigin, sueLonOrigin, sueAltOrigin);
    }
  }
}
