package io.dronefleet.mavlink.slugs;

import io.dronefleet.mavlink.annotations.MavlinkMessage;
import io.dronefleet.mavlink.annotations.MavlinkMessageField;

/**
 * Configurable diagnostic messages. 
 */
@MavlinkMessage(
    id = 173,
    crc = 2
)
public final class Diagnostic {
  private final float diagfl1;

  private final float diagfl2;

  private final float diagfl3;

  private final int diagsh1;

  private final int diagsh2;

  private final int diagsh3;

  private Diagnostic(float diagfl1, float diagfl2, float diagfl3, int diagsh1, int diagsh2,
      int diagsh3) {
    this.diagfl1 = diagfl1;
    this.diagfl2 = diagfl2;
    this.diagfl3 = diagfl3;
    this.diagsh1 = diagsh1;
    this.diagsh2 = diagsh2;
    this.diagsh3 = diagsh3;
  }

  public static Builder builder() {
    return new Builder();
  }

  /**
   * Diagnostic float 1 
   */
  @MavlinkMessageField(
      position = 1,
      length = 4
  )
  public final float diagfl1() {
    return diagfl1;
  }

  /**
   * Diagnostic float 2 
   */
  @MavlinkMessageField(
      position = 2,
      length = 4
  )
  public final float diagfl2() {
    return diagfl2;
  }

  /**
   * Diagnostic float 3 
   */
  @MavlinkMessageField(
      position = 3,
      length = 4
  )
  public final float diagfl3() {
    return diagfl3;
  }

  /**
   * Diagnostic short 1 
   */
  @MavlinkMessageField(
      position = 4,
      length = 2
  )
  public final int diagsh1() {
    return diagsh1;
  }

  /**
   * Diagnostic short 2 
   */
  @MavlinkMessageField(
      position = 5,
      length = 2
  )
  public final int diagsh2() {
    return diagsh2;
  }

  /**
   * Diagnostic short 3 
   */
  @MavlinkMessageField(
      position = 6,
      length = 2
  )
  public final int diagsh3() {
    return diagsh3;
  }

  public class Builder {
    private float diagfl1;

    private float diagfl2;

    private float diagfl3;

    private int diagsh1;

    private int diagsh2;

    private int diagsh3;

    private Builder() {
    }

    /**
     * Diagnostic float 1 
     */
    @MavlinkMessageField(
        position = 1,
        length = 4
    )
    public final Builder diagfl1(float diagfl1) {
      this.diagfl1 = diagfl1;
      return this;
    }

    /**
     * Diagnostic float 2 
     */
    @MavlinkMessageField(
        position = 2,
        length = 4
    )
    public final Builder diagfl2(float diagfl2) {
      this.diagfl2 = diagfl2;
      return this;
    }

    /**
     * Diagnostic float 3 
     */
    @MavlinkMessageField(
        position = 3,
        length = 4
    )
    public final Builder diagfl3(float diagfl3) {
      this.diagfl3 = diagfl3;
      return this;
    }

    /**
     * Diagnostic short 1 
     */
    @MavlinkMessageField(
        position = 4,
        length = 2
    )
    public final Builder diagsh1(int diagsh1) {
      this.diagsh1 = diagsh1;
      return this;
    }

    /**
     * Diagnostic short 2 
     */
    @MavlinkMessageField(
        position = 5,
        length = 2
    )
    public final Builder diagsh2(int diagsh2) {
      this.diagsh2 = diagsh2;
      return this;
    }

    /**
     * Diagnostic short 3 
     */
    @MavlinkMessageField(
        position = 6,
        length = 2
    )
    public final Builder diagsh3(int diagsh3) {
      this.diagsh3 = diagsh3;
      return this;
    }

    public final Diagnostic build() {
      return new Diagnostic(diagfl1, diagfl2, diagfl3, diagsh1, diagsh2, diagsh3);
    }
  }
}
