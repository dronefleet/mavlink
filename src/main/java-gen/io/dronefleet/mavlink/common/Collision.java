package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import java.lang.Override;
import java.lang.String;

/**
 * Information about a potential collision 
 */
@MavlinkMessageInfo(
    id = 247,
    crc = 81
)
public final class Collision {
  /**
   * Unique identifier, domain based on src field 
   */
  private final long id;

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

  /**
   * Collision data source 
   */
  private final MavCollisionSrc src;

  /**
   * Action that is being taken to avoid this collision 
   */
  private final MavCollisionAction action;

  /**
   * How concerned the aircraft is about this collision 
   */
  private final MavCollisionThreatLevel threatLevel;

  private Collision(long id, float timeToMinimumDelta, float altitudeMinimumDelta,
      float horizontalMinimumDelta, MavCollisionSrc src, MavCollisionAction action,
      MavCollisionThreatLevel threatLevel) {
    this.id = id;
    this.timeToMinimumDelta = timeToMinimumDelta;
    this.altitudeMinimumDelta = altitudeMinimumDelta;
    this.horizontalMinimumDelta = horizontalMinimumDelta;
    this.src = src;
    this.action = action;
    this.threatLevel = threatLevel;
  }

  @MavlinkMessageBuilder
  public static Builder builder() {
    return new Builder();
  }

  @Override
  public String toString() {
    return "Collision{src=" + src
         + ", id=" + id
         + ", action=" + action
         + ", threatLevel=" + threatLevel
         + ", timeToMinimumDelta=" + timeToMinimumDelta
         + ", altitudeMinimumDelta=" + altitudeMinimumDelta
         + ", horizontalMinimumDelta=" + horizontalMinimumDelta + "}";
  }

  /**
   * Unique identifier, domain based on src field 
   */
  @MavlinkFieldInfo(
      position = 2,
      unitSize = 4
  )
  public final long id() {
    return id;
  }

  /**
   * Estimated time until collision occurs (seconds) 
   */
  @MavlinkFieldInfo(
      position = 5,
      unitSize = 4
  )
  public final float timeToMinimumDelta() {
    return timeToMinimumDelta;
  }

  /**
   * Closest vertical distance in meters between vehicle and object 
   */
  @MavlinkFieldInfo(
      position = 6,
      unitSize = 4
  )
  public final float altitudeMinimumDelta() {
    return altitudeMinimumDelta;
  }

  /**
   * Closest horizontal distance in meteres between vehicle and object 
   */
  @MavlinkFieldInfo(
      position = 7,
      unitSize = 4
  )
  public final float horizontalMinimumDelta() {
    return horizontalMinimumDelta;
  }

  /**
   * Collision data source 
   */
  @MavlinkFieldInfo(
      position = 1,
      unitSize = 1
  )
  public final MavCollisionSrc src() {
    return src;
  }

  /**
   * Action that is being taken to avoid this collision 
   */
  @MavlinkFieldInfo(
      position = 3,
      unitSize = 1
  )
  public final MavCollisionAction action() {
    return action;
  }

  /**
   * How concerned the aircraft is about this collision 
   */
  @MavlinkFieldInfo(
      position = 4,
      unitSize = 1
  )
  public final MavCollisionThreatLevel threatLevel() {
    return threatLevel;
  }

  public static class Builder {
    private long id;

    private float timeToMinimumDelta;

    private float altitudeMinimumDelta;

    private float horizontalMinimumDelta;

    private MavCollisionSrc src;

    private MavCollisionAction action;

    private MavCollisionThreatLevel threatLevel;

    private Builder() {
    }

    /**
     * Unique identifier, domain based on src field 
     */
    @MavlinkFieldInfo(
        position = 2,
        unitSize = 4
    )
    public final Builder id(long id) {
      this.id = id;
      return this;
    }

    /**
     * Estimated time until collision occurs (seconds) 
     */
    @MavlinkFieldInfo(
        position = 5,
        unitSize = 4
    )
    public final Builder timeToMinimumDelta(float timeToMinimumDelta) {
      this.timeToMinimumDelta = timeToMinimumDelta;
      return this;
    }

    /**
     * Closest vertical distance in meters between vehicle and object 
     */
    @MavlinkFieldInfo(
        position = 6,
        unitSize = 4
    )
    public final Builder altitudeMinimumDelta(float altitudeMinimumDelta) {
      this.altitudeMinimumDelta = altitudeMinimumDelta;
      return this;
    }

    /**
     * Closest horizontal distance in meteres between vehicle and object 
     */
    @MavlinkFieldInfo(
        position = 7,
        unitSize = 4
    )
    public final Builder horizontalMinimumDelta(float horizontalMinimumDelta) {
      this.horizontalMinimumDelta = horizontalMinimumDelta;
      return this;
    }

    /**
     * Collision data source 
     */
    @MavlinkFieldInfo(
        position = 1,
        unitSize = 1
    )
    public final Builder src(MavCollisionSrc src) {
      this.src = src;
      return this;
    }

    /**
     * Action that is being taken to avoid this collision 
     */
    @MavlinkFieldInfo(
        position = 3,
        unitSize = 1
    )
    public final Builder action(MavCollisionAction action) {
      this.action = action;
      return this;
    }

    /**
     * How concerned the aircraft is about this collision 
     */
    @MavlinkFieldInfo(
        position = 4,
        unitSize = 1
    )
    public final Builder threatLevel(MavCollisionThreatLevel threatLevel) {
      this.threatLevel = threatLevel;
      return this;
    }

    public final Collision build() {
      return new Collision(id, timeToMinimumDelta, altitudeMinimumDelta, horizontalMinimumDelta, src, action, threatLevel);
    }
  }
}
