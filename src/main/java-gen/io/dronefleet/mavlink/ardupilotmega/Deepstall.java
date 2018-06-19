package io.dronefleet.mavlink.ardupilotmega;

import io.dronefleet.mavlink.annotations.MavlinkMessage;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageField;
import java.lang.Override;
import java.lang.String;

/**
 * Deepstall path planning 
 */
@MavlinkMessage(
    id = 195,
    crc = 120
)
public final class Deepstall {
  /**
   * Landing latitude (deg * 1E7) 
   */
  private final int landingLat;

  /**
   * Landing longitude (deg * 1E7) 
   */
  private final int landingLon;

  /**
   * Final heading start point, latitude (deg * 1E7) 
   */
  private final int pathLat;

  /**
   * Final heading start point, longitude (deg * 1E7) 
   */
  private final int pathLon;

  /**
   * Arc entry point, latitude (deg * 1E7) 
   */
  private final int arcEntryLat;

  /**
   * Arc entry point, longitude (deg * 1E7) 
   */
  private final int arcEntryLon;

  /**
   * Altitude (meters) 
   */
  private final float altitude;

  /**
   * Distance the aircraft expects to travel during the deepstall 
   */
  private final float expectedTravelDistance;

  /**
   * Deepstall cross track error in meters (only valid when in DEEPSTALL_STAGE_LAND) 
   */
  private final float crossTrackError;

  /**
   * Deepstall stage, see enum MAV_DEEPSTALL_STAGE 
   */
  private final DeepstallStage stage;

  private Deepstall(int landingLat, int landingLon, int pathLat, int pathLon, int arcEntryLat,
      int arcEntryLon, float altitude, float expectedTravelDistance, float crossTrackError,
      DeepstallStage stage) {
    this.landingLat = landingLat;
    this.landingLon = landingLon;
    this.pathLat = pathLat;
    this.pathLon = pathLon;
    this.arcEntryLat = arcEntryLat;
    this.arcEntryLon = arcEntryLon;
    this.altitude = altitude;
    this.expectedTravelDistance = expectedTravelDistance;
    this.crossTrackError = crossTrackError;
    this.stage = stage;
  }

  @MavlinkMessageBuilder
  public static Builder builder() {
    return new Builder();
  }

  @Override
  public String toString() {
    return "Deepstall{landingLat=" + landingLat
         + ", landingLon=" + landingLon
         + ", pathLat=" + pathLat
         + ", pathLon=" + pathLon
         + ", arcEntryLat=" + arcEntryLat
         + ", arcEntryLon=" + arcEntryLon
         + ", altitude=" + altitude
         + ", expectedTravelDistance=" + expectedTravelDistance
         + ", crossTrackError=" + crossTrackError
         + ", stage=" + stage + "}";
  }

  /**
   * Landing latitude (deg * 1E7) 
   */
  @MavlinkMessageField(
      position = 1,
      unitSize = 4
  )
  public final int landingLat() {
    return landingLat;
  }

  /**
   * Landing longitude (deg * 1E7) 
   */
  @MavlinkMessageField(
      position = 2,
      unitSize = 4
  )
  public final int landingLon() {
    return landingLon;
  }

  /**
   * Final heading start point, latitude (deg * 1E7) 
   */
  @MavlinkMessageField(
      position = 3,
      unitSize = 4
  )
  public final int pathLat() {
    return pathLat;
  }

  /**
   * Final heading start point, longitude (deg * 1E7) 
   */
  @MavlinkMessageField(
      position = 4,
      unitSize = 4
  )
  public final int pathLon() {
    return pathLon;
  }

  /**
   * Arc entry point, latitude (deg * 1E7) 
   */
  @MavlinkMessageField(
      position = 5,
      unitSize = 4
  )
  public final int arcEntryLat() {
    return arcEntryLat;
  }

  /**
   * Arc entry point, longitude (deg * 1E7) 
   */
  @MavlinkMessageField(
      position = 6,
      unitSize = 4
  )
  public final int arcEntryLon() {
    return arcEntryLon;
  }

  /**
   * Altitude (meters) 
   */
  @MavlinkMessageField(
      position = 7,
      unitSize = 4
  )
  public final float altitude() {
    return altitude;
  }

  /**
   * Distance the aircraft expects to travel during the deepstall 
   */
  @MavlinkMessageField(
      position = 8,
      unitSize = 4
  )
  public final float expectedTravelDistance() {
    return expectedTravelDistance;
  }

  /**
   * Deepstall cross track error in meters (only valid when in DEEPSTALL_STAGE_LAND) 
   */
  @MavlinkMessageField(
      position = 9,
      unitSize = 4
  )
  public final float crossTrackError() {
    return crossTrackError;
  }

  /**
   * Deepstall stage, see enum MAV_DEEPSTALL_STAGE 
   */
  @MavlinkMessageField(
      position = 10,
      unitSize = 1
  )
  public final DeepstallStage stage() {
    return stage;
  }

  public static class Builder {
    private int landingLat;

    private int landingLon;

    private int pathLat;

    private int pathLon;

    private int arcEntryLat;

    private int arcEntryLon;

    private float altitude;

    private float expectedTravelDistance;

    private float crossTrackError;

    private DeepstallStage stage;

    private Builder() {
    }

    /**
     * Landing latitude (deg * 1E7) 
     */
    @MavlinkMessageField(
        position = 1,
        unitSize = 4
    )
    public final Builder landingLat(int landingLat) {
      this.landingLat = landingLat;
      return this;
    }

    /**
     * Landing longitude (deg * 1E7) 
     */
    @MavlinkMessageField(
        position = 2,
        unitSize = 4
    )
    public final Builder landingLon(int landingLon) {
      this.landingLon = landingLon;
      return this;
    }

    /**
     * Final heading start point, latitude (deg * 1E7) 
     */
    @MavlinkMessageField(
        position = 3,
        unitSize = 4
    )
    public final Builder pathLat(int pathLat) {
      this.pathLat = pathLat;
      return this;
    }

    /**
     * Final heading start point, longitude (deg * 1E7) 
     */
    @MavlinkMessageField(
        position = 4,
        unitSize = 4
    )
    public final Builder pathLon(int pathLon) {
      this.pathLon = pathLon;
      return this;
    }

    /**
     * Arc entry point, latitude (deg * 1E7) 
     */
    @MavlinkMessageField(
        position = 5,
        unitSize = 4
    )
    public final Builder arcEntryLat(int arcEntryLat) {
      this.arcEntryLat = arcEntryLat;
      return this;
    }

    /**
     * Arc entry point, longitude (deg * 1E7) 
     */
    @MavlinkMessageField(
        position = 6,
        unitSize = 4
    )
    public final Builder arcEntryLon(int arcEntryLon) {
      this.arcEntryLon = arcEntryLon;
      return this;
    }

    /**
     * Altitude (meters) 
     */
    @MavlinkMessageField(
        position = 7,
        unitSize = 4
    )
    public final Builder altitude(float altitude) {
      this.altitude = altitude;
      return this;
    }

    /**
     * Distance the aircraft expects to travel during the deepstall 
     */
    @MavlinkMessageField(
        position = 8,
        unitSize = 4
    )
    public final Builder expectedTravelDistance(float expectedTravelDistance) {
      this.expectedTravelDistance = expectedTravelDistance;
      return this;
    }

    /**
     * Deepstall cross track error in meters (only valid when in DEEPSTALL_STAGE_LAND) 
     */
    @MavlinkMessageField(
        position = 9,
        unitSize = 4
    )
    public final Builder crossTrackError(float crossTrackError) {
      this.crossTrackError = crossTrackError;
      return this;
    }

    /**
     * Deepstall stage, see enum MAV_DEEPSTALL_STAGE 
     */
    @MavlinkMessageField(
        position = 10,
        unitSize = 1
    )
    public final Builder stage(DeepstallStage stage) {
      this.stage = stage;
      return this;
    }

    public final Deepstall build() {
      return new Deepstall(landingLat, landingLon, pathLat, pathLon, arcEntryLat, arcEntryLon, altitude, expectedTravelDistance, crossTrackError, stage);
    }
  }
}
