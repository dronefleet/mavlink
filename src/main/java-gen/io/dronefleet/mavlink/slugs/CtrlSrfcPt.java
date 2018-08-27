package io.dronefleet.mavlink.slugs;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import io.dronefleet.mavlink.util.EnumValue;
import java.lang.Enum;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;

/**
 * This message sets the control surfaces for selective passthrough mode. 
 */
@MavlinkMessageInfo(
        id = 181,
        crc = 104
)
public final class CtrlSrfcPt {
    private final int target;

    private final EnumValue<ControlSurfaceFlag> bitfieldpt;

    private CtrlSrfcPt(int target, EnumValue<ControlSurfaceFlag> bitfieldpt) {
        this.target = target;
        this.bitfieldpt = bitfieldpt;
    }

    /**
     * Returns a builder instance for this message.
     */
    @MavlinkMessageBuilder
    public static Builder builder() {
        return new Builder();
    }

    /**
     * The system setting the commands 
     */
    @MavlinkFieldInfo(
            position = 1,
            unitSize = 1
    )
    public final int target() {
        return this.target;
    }

    /**
     * Bitfield containing the passthrough configuration, see {@link io.dronefleet.mavlink.slugs.ControlSurfaceFlag CONTROL_SURFACE_FLAG} ENUM. 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 2,
            enumType = ControlSurfaceFlag.class
    )
    public final EnumValue<ControlSurfaceFlag> bitfieldpt() {
        return this.bitfieldpt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !getClass().equals(o.getClass())) return false;
        CtrlSrfcPt other = (CtrlSrfcPt)o;
        if (!Objects.deepEquals(target, other.target)) return false;
        if (!Objects.deepEquals(bitfieldpt, other.bitfieldpt)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + Objects.hashCode(target);
        result = 31 * result + Objects.hashCode(bitfieldpt);
        return result;
    }

    @Override
    public String toString() {
        return "CtrlSrfcPt{target=" + target
                 + ", bitfieldpt=" + bitfieldpt + "}";
    }

    public static final class Builder {
        private int target;

        private EnumValue<ControlSurfaceFlag> bitfieldpt;

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

        /**
         * Bitfield containing the passthrough configuration, see {@link io.dronefleet.mavlink.slugs.ControlSurfaceFlag CONTROL_SURFACE_FLAG} ENUM. 
         */
        @MavlinkFieldInfo(
                position = 2,
                unitSize = 2,
                enumType = ControlSurfaceFlag.class
        )
        public final Builder bitfieldpt(EnumValue<ControlSurfaceFlag> bitfieldpt) {
            this.bitfieldpt = bitfieldpt;
            return this;
        }

        /**
         * Bitfield containing the passthrough configuration, see {@link io.dronefleet.mavlink.slugs.ControlSurfaceFlag CONTROL_SURFACE_FLAG} ENUM. 
         */
        public final Builder bitfieldpt(ControlSurfaceFlag entry) {
            this.bitfieldpt = EnumValue.of(entry);
            return this;
        }

        /**
         * Bitfield containing the passthrough configuration, see {@link io.dronefleet.mavlink.slugs.ControlSurfaceFlag CONTROL_SURFACE_FLAG} ENUM. 
         */
        public final Builder bitfieldpt(Enum... flags) {
            this.bitfieldpt = EnumValue.create(flags);
            return this;
        }

        public final CtrlSrfcPt build() {
            return new CtrlSrfcPt(target, bitfieldpt);
        }
    }
}
