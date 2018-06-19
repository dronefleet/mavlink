package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkMessage;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageField;
import java.lang.Integer;
import java.lang.Override;
import java.lang.String;
import java.util.List;

/**
 * The positioning status, as reported by GPS. This message is intended to display status 
 * information about each satellite visible to the receiver. See message GLOBAL_POSITION for 
 * the global position estimate. This message can contain information for up to 20 satellites. 
 */
@MavlinkMessage(
    id = 25,
    crc = 23
)
public final class GpsStatus {
  /**
   * Number of satellites visible 
   */
  private final int satellitesVisible;

  /**
   * Global satellite ID 
   */
  private final List<Integer> satellitePrn;

  /**
   * 0: Satellite not used, 1: used for localization 
   */
  private final List<Integer> satelliteUsed;

  /**
   * Elevation (0: right on top of receiver, 90: on the horizon) of satellite 
   */
  private final List<Integer> satelliteElevation;

  /**
   * Direction of satellite, 0: 0 deg, 255: 360 deg. 
   */
  private final List<Integer> satelliteAzimuth;

  /**
   * Signal to noise ratio of satellite 
   */
  private final List<Integer> satelliteSnr;

  private GpsStatus(int satellitesVisible, List<Integer> satellitePrn, List<Integer> satelliteUsed,
      List<Integer> satelliteElevation, List<Integer> satelliteAzimuth,
      List<Integer> satelliteSnr) {
    this.satellitesVisible = satellitesVisible;
    this.satellitePrn = satellitePrn;
    this.satelliteUsed = satelliteUsed;
    this.satelliteElevation = satelliteElevation;
    this.satelliteAzimuth = satelliteAzimuth;
    this.satelliteSnr = satelliteSnr;
  }

  @MavlinkMessageBuilder
  public static Builder builder() {
    return new Builder();
  }

  @Override
  public String toString() {
    return "GpsStatus{satellitesVisible=" + satellitesVisible
         + ", satellitePrn=" + satellitePrn
         + ", satelliteUsed=" + satelliteUsed
         + ", satelliteElevation=" + satelliteElevation
         + ", satelliteAzimuth=" + satelliteAzimuth
         + ", satelliteSnr=" + satelliteSnr + "}";
  }

  /**
   * Number of satellites visible 
   */
  @MavlinkMessageField(
      position = 1,
      unitSize = 1
  )
  public final int satellitesVisible() {
    return satellitesVisible;
  }

  /**
   * Global satellite ID 
   */
  @MavlinkMessageField(
      position = 2,
      unitSize = 1,
      arraySize = 20
  )
  public final List<Integer> satellitePrn() {
    return satellitePrn;
  }

  /**
   * 0: Satellite not used, 1: used for localization 
   */
  @MavlinkMessageField(
      position = 3,
      unitSize = 1,
      arraySize = 20
  )
  public final List<Integer> satelliteUsed() {
    return satelliteUsed;
  }

  /**
   * Elevation (0: right on top of receiver, 90: on the horizon) of satellite 
   */
  @MavlinkMessageField(
      position = 4,
      unitSize = 1,
      arraySize = 20
  )
  public final List<Integer> satelliteElevation() {
    return satelliteElevation;
  }

  /**
   * Direction of satellite, 0: 0 deg, 255: 360 deg. 
   */
  @MavlinkMessageField(
      position = 5,
      unitSize = 1,
      arraySize = 20
  )
  public final List<Integer> satelliteAzimuth() {
    return satelliteAzimuth;
  }

  /**
   * Signal to noise ratio of satellite 
   */
  @MavlinkMessageField(
      position = 6,
      unitSize = 1,
      arraySize = 20
  )
  public final List<Integer> satelliteSnr() {
    return satelliteSnr;
  }

  public static class Builder {
    private int satellitesVisible;

    private List<Integer> satellitePrn;

    private List<Integer> satelliteUsed;

    private List<Integer> satelliteElevation;

    private List<Integer> satelliteAzimuth;

    private List<Integer> satelliteSnr;

    private Builder() {
    }

    /**
     * Number of satellites visible 
     */
    @MavlinkMessageField(
        position = 1,
        unitSize = 1
    )
    public final Builder satellitesVisible(int satellitesVisible) {
      this.satellitesVisible = satellitesVisible;
      return this;
    }

    /**
     * Global satellite ID 
     */
    @MavlinkMessageField(
        position = 2,
        unitSize = 1,
        arraySize = 20
    )
    public final Builder satellitePrn(List<Integer> satellitePrn) {
      this.satellitePrn = satellitePrn;
      return this;
    }

    /**
     * 0: Satellite not used, 1: used for localization 
     */
    @MavlinkMessageField(
        position = 3,
        unitSize = 1,
        arraySize = 20
    )
    public final Builder satelliteUsed(List<Integer> satelliteUsed) {
      this.satelliteUsed = satelliteUsed;
      return this;
    }

    /**
     * Elevation (0: right on top of receiver, 90: on the horizon) of satellite 
     */
    @MavlinkMessageField(
        position = 4,
        unitSize = 1,
        arraySize = 20
    )
    public final Builder satelliteElevation(List<Integer> satelliteElevation) {
      this.satelliteElevation = satelliteElevation;
      return this;
    }

    /**
     * Direction of satellite, 0: 0 deg, 255: 360 deg. 
     */
    @MavlinkMessageField(
        position = 5,
        unitSize = 1,
        arraySize = 20
    )
    public final Builder satelliteAzimuth(List<Integer> satelliteAzimuth) {
      this.satelliteAzimuth = satelliteAzimuth;
      return this;
    }

    /**
     * Signal to noise ratio of satellite 
     */
    @MavlinkMessageField(
        position = 6,
        unitSize = 1,
        arraySize = 20
    )
    public final Builder satelliteSnr(List<Integer> satelliteSnr) {
      this.satelliteSnr = satelliteSnr;
      return this;
    }

    public final GpsStatus build() {
      return new GpsStatus(satellitesVisible, satellitePrn, satelliteUsed, satelliteElevation, satelliteAzimuth, satelliteSnr);
    }
  }
}
