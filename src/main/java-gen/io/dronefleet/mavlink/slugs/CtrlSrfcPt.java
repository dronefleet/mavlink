package io.dronefleet.mavlink.slugs;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import io.dronefleet.mavlink.util.EnumFlagSet;
import java.lang.Override;
import java.lang.String;

/**
 * This message sets the control surfaces for selective passthrough mode. 
 */
@MavlinkMessageInfo(
        id = 181,
        crc = 104
)
public final class CtrlSrfcPt {
    /**
     * Bitfield containing the passthrough configuration, see {@link io.dronefleet.mavlink.slugs.ControlSurfaceFlag ControlSurfaceFlag} ENUM. 
     */
    private final EnumFlagSet<ControlSurfaceFlag> bitfieldpt;

    /**
     * The system setting the commands 
     */
    private final int target;

    private CtrlSrfcPt(EnumFlagSet<ControlSurfaceFlag> bitfieldpt, int target) {
        this.bitfieldpt = bitfieldpt;
        this.target = target;
    }

    @MavlinkMessageBuilder
    public static Builder builder() {
        return new Builder();
    }

    @Override
    public String toString() {
        return "CtrlSrfcPt{target=" + target
                 + ", bitfieldpt=" + bitfieldpt + "}";
    }

    /**
     * Bitfield containing the passthrough configuration, see {@link io.dronefleet.mavlink.slugs.ControlSurfaceFlag ControlSurfaceFlag} ENUM. 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 2
    )
    public final EnumFlagSet<ControlSurfaceFlag> bitfieldpt() {
        return bitfieldpt;
    }

    /**
     * The system setting the commands 
     */
    @MavlinkFieldInfo(
            position = 1,
            unitSize = 1
    )
    public final int target() {
        return target;
    }

    public static class Builder {
        private EnumFlagSet<ControlSurfaceFlag> bitfieldpt;

        private int target;

        private Builder() {
        }

        /**
         * Bitfield containing the passthrough configuration, see {@link io.dronefleet.mavlink.slugs.ControlSurfaceFlag ControlSurfaceFlag} ENUM. 
         */
        @MavlinkFieldInfo(
                position = 2,
                unitSize = 2
        )
        public final Builder bitfieldpt(EnumFlagSet<ControlSurfaceFlag> bitfieldpt) {
            this.bitfieldpt = bitfieldpt;
            return this;
        }

        /**
         * The system setting the commands 
         */
        @MavlinkFieldInfo(
                position = 1,
                unitSize = 1
        )
        public final Builder target(int target) {
            this.target = target;
            return this;
        }

        public final CtrlSrfcPt build() {
            return new CtrlSrfcPt(bitfieldpt, target);
        }
    }
}
