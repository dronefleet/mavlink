package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkMessage;
import io.dronefleet.mavlink.annotations.MavlinkMessageField;

/**
 * Information about a potential collision 
 */
@MavlinkMessage(
    id = 247,
    crc = 81
)
public final class Collision {
  /**
   * Collision data source 
   */
  private final MavCollisionSrc src;

  /**
   * Unique identifier, domain based on src field 
   */
  private final long id;

  /**
   * Action that is being taken to avoid this collision 
   */
  private final MavCollisionAction action;

  /**
   * How concerned the aircraft is about this collision 
   */
  private final MavCollisionThreatLevel threatLevel;

  /**
   * Estimated time until collision occurs (seconds) 
   */
  private final float timeToMinimumDelta;

  /**
   * Closest vertical distance in meters between vehicle and object 
   */
  private final float altitudeMinimumDelta;

  /**
   * Closest horizontal distance in meteres between vehicle and object 
   */
  private final float horizontalMinimumDelta;

  private Collision(MavCollisionSrc src, long id, MavCollisionAction action,
      MavCollisionThreatLevel threatLevel, float timeToMinimumDelta, float altitudeMinimumDelta,
      float horizontalMinimumDelta) {
    this.src = src;
    this.id = id;
    this.action = action;
    this.threatLevel = threatLevel;
    this.timeToMinimumDelta = timeToMinimumDelta;
    this.altitudeMinimumDelta = altitudeMinimumDelta;
    this.horizontalMinimumDelta = horizontalMinimumDelta;
  }

  public static Builder builder() {
    return new Builder();
  }

  /**
   * Collision data source 
   */
  @MavlinkMessageField(
      position = 1,
      length = 1
  )
  public final MavCollisionSrc src() {
    return src;
  }

  /**
   * Unique identifier, domain based on src field 
   */
  @MavlinkMessageField(
      position = 2,
      length = 4
  )
  public final long id() {
    return id;
  }

  /**
   * Action that is being taken to avoid this collision 
   */
  @MavlinkMessageField(
      position = 3,
      length = 1
  )
  public final MavCollisionAction action() {
    return action;
  }

  /**
   * How concerned the aircraft is about this collision 
   */
  @MavlinkMessageField(
      position = 4,
      length = 1
  )
  public final MavCollisionThreatLevel threatLevel() {
    return threatLevel;
  }

  /**
   * Estimated time until collision occurs (seconds) 
   */
  @MavlinkMessageField(
      position = 5,
      length = 4
  )
  public final float timeToMinimumDelta() {
    return timeToMinimumDelta;
  }

  /**
   * Closest vertical distance in meters between vehicle and object 
   */
  @MavlinkMessageField(
      position = 6,
      length = 4
  )
  public final float altitudeMinimumDelta() {
    return altitudeMinimumDelta;
  }

  /**
   * Closest horizontal distance in meteres between vehicle and object 
   */
  @MavlinkMessageField(
      position = 7,
      length = 4
  )
  public final float horizontalMinimumDelta() {
    return horizontalMinimumDelta;
  }

  public static class Builder {
    private MavCollisionSrc src;

    private long id;

    private MavCollisionAction action;

    private MavCollisionThreatLevel threatLevel;

    private float timeToMinimumDelta;

    private float altitudeMinimumDelta;

    private float horizontalMinimumDelta;

    private Builder() {
    }

    /**
     * Collision data source 
     */
    @MavlinkMessageField(
        position = 1,
        length = 1
    )
    public final Builder src(MavCollisionSrc src) {
      this.src = src;
      return this;
    }

    /**
     * Unique identifier, domain based on src field 
     */
    @MavlinkMessageField(
        position = 2,
        length = 4
    )
    public final Builder id(long id) {
      this.id = id;
      return this;
    }

    /**
     * Action that is being taken to avoid this collision 
     */
    @MavlinkMessageField(
        position = 3,
        length = 1
    )
    public final Builder action(MavCollisionAction action) {
      this.action = action;
      return this;
    }

    /**
     * How concerned the aircraft is about this collision 
     */
    @MavlinkMessageField(
        position = 4,
        length = 1
    )
    public final Builder threatLevel(MavCollisionThreatLevel threatLevel) {
      this.threatLevel = threatLevel;
      return this;
    }

    /**
     * Estimated time until collision occurs (seconds) 
     */
    @MavlinkMessageField(
        position = 5,
        length = 4
    )
    public final Builder timeToMinimumDelta(float timeToMinimumDelta) {
      this.timeToMinimumDelta = timeToMinimumDelta;
      return this;
    }

    /**
     * Closest vertical distance in meters between vehicle and object 
     */
    @MavlinkMessageField(
        position = 6,
        length = 4
    )
    public final Builder altitudeMinimumDelta(float altitudeMinimumDelta) {
      this.altitudeMinimumDelta = altitudeMinimumDelta;
      return this;
    }

    /**
     * Closest horizontal distance in meteres between vehicle and object 
     */
    @MavlinkMessageField(
        position = 7,
        length = 4
    )
    public final Builder horizontalMinimumDelta(float horizontalMinimumDelta) {
      this.horizontalMinimumDelta = horizontalMinimumDelta;
      return this;
    }

    public final Collision build() {
      return new Collision(src, id, action, threatLevel, timeToMinimumDelta, altitudeMinimumDelta, horizontalMinimumDelta);
    }
  }
}
