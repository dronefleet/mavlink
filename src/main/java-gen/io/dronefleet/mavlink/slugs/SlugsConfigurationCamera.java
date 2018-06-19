package io.dronefleet.mavlink.slugs;

import io.dronefleet.mavlink.annotations.MavlinkMessage;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageField;
import java.lang.Override;
import java.lang.String;

/**
 * Control for camara. 
 */
@MavlinkMessage(
    id = 188,
    crc = 5
)
public final class SlugsConfigurationCamera {
  /**
   * The system setting the commands 
   */
  private final int target;

  /**
   * ID 0: brightness 1: aperture 2: iris 3: ICR 4: backlight 
   */
  private final int idorder;

  /**
   * 1: up/on 2: down/off 3: auto/reset/no action 
   */
  private final int order;

  private SlugsConfigurationCamera(int target, int idorder, int order) {
    this.target = target;
    this.idorder = idorder;
    this.order = order;
  }

  @MavlinkMessageBuilder
  public static Builder builder() {
    return new Builder();
  }

  @Override
  public String toString() {
    return "SlugsConfigurationCamera{target=" + target
         + ", idorder=" + idorder
         + ", order=" + order + "}";
  }

  /**
   * The system setting the commands 
   */
  @MavlinkMessageField(
      position = 1,
      unitSize = 1
  )
  public final int target() {
    return target;
  }

  /**
   * ID 0: brightness 1: aperture 2: iris 3: ICR 4: backlight 
   */
  @MavlinkMessageField(
      position = 2,
      unitSize = 1
  )
  public final int idorder() {
    return idorder;
  }

  /**
   * 1: up/on 2: down/off 3: auto/reset/no action 
   */
  @MavlinkMessageField(
      position = 3,
      unitSize = 1
  )
  public final int order() {
    return order;
  }

  public static class Builder {
    private int target;

    private int idorder;

    private int order;

    private Builder() {
    }

    /**
     * The system setting the commands 
     */
    @MavlinkMessageField(
        position = 1,
        unitSize = 1
    )
    public final Builder target(int target) {
      this.target = target;
      return this;
    }

    /**
     * ID 0: brightness 1: aperture 2: iris 3: ICR 4: backlight 
     */
    @MavlinkMessageField(
        position = 2,
        unitSize = 1
    )
    public final Builder idorder(int idorder) {
      this.idorder = idorder;
      return this;
    }

    /**
     * 1: up/on 2: down/off 3: auto/reset/no action 
     */
    @MavlinkMessageField(
        position = 3,
        unitSize = 1
    )
    public final Builder order(int order) {
      this.order = order;
      return this;
    }

    public final SlugsConfigurationCamera build() {
      return new SlugsConfigurationCamera(target, idorder, order);
    }
  }
}
