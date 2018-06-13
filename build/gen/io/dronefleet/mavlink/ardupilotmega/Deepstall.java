package io.dronefleet.mavlink.ardupilotmega;

import io.dronefleet.mavlink.annotations.MavlinkMessage;
import io.dronefleet.mavlink.annotations.MavlinkMessageField;

/**
 * Deepstall path planning 
 */
@MavlinkMessage(
    id = 195,
    crc = 120
)
public final class Deepstall {
  private final int landingLat;

  private final int landingLon;

  private final int pathLat;

  private final int pathLon;

  private final int arcEntryLat;

  private final int arcEntryLon;

  private final float altitude;

  private final float expectedTravelDistance;

  private final float crossTrackError;

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

  public static Builder builder() {
    return new Builder();
  }

  /**
   * Landing latitude (deg * 1E7) 
   */
  @MavlinkMessageField(
      position = 1,
      length = 4
  )
  public final int landingLat() {
    return landingLat;
  }

  /**
   * Landing longitude (deg * 1E7) 
   */
  @MavlinkMessageField(
      position = 2,
      length = 4
  )
  public final int landingLon() {
    return landingLon;
  }

  /**
   * Final heading start point, latitude (deg * 1E7) 
   */
  @MavlinkMessageField(
      position = 3,
      length = 4
  )
  public final int pathLat() {
    return pathLat;
  }

  /**
   * Final heading start point, longitude (deg * 1E7) 
   */
  @MavlinkMessageField(
      position = 4,
      length = 4
  )
  public final int pathLon() {
    return pathLon;
  }

  /**
   * Arc entry point, latitude (deg * 1E7) 
   */
  @MavlinkMessageField(
      position = 5,
      length = 4
  )
  public final int arcEntryLat() {
    return arcEntryLat;
  }

  /**
   * Arc entry point, longitude (deg * 1E7) 
   */
  @MavlinkMessageField(
      position = 6,
      length = 4
  )
  public final int arcEntryLon() {
    return arcEntryLon;
  }

  /**
   * Altitude (meters) 
   */
  @MavlinkMessageField(
      position = 7,
      length = 4
  )
  public final float altitude() {
    return altitude;
  }

  /**
   * Distance the aircraft expects to travel during the deepstall 
   */
  @MavlinkMessageField(
      position = 8,
      length = 4
  )
  public final float expectedTravelDistance() {
    return expectedTravelDistance;
  }

  /**
   * Deepstall cross track error in meters (only valid when in DEEPSTALL_STAGE_LAND) 
   */
  @MavlinkMessageField(
      position = 9,
      length = 4
  )
  public final float crossTrackError() {
    return crossTrackError;
  }

  /**
   * Deepstall stage, see enum MAV_DEEPSTALL_STAGE 
   */
  @MavlinkMessageField(
      position = 10,
      length = 1
  )
  public final DeepstallStage stage() {
    return stage;
  }

  public class Builder {
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
        length = 4
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
        length = 4
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
        length = 4
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
        length = 4
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
        length = 4
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
        length = 4
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
        length = 4
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
        length = 4
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
        length = 4
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
        length = 1
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
