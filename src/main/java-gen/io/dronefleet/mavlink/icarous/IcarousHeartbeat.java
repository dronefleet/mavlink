package io.dronefleet.mavlink.icarous;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import io.dronefleet.mavlink.util.EnumValue;
import java.lang.Enum;
import java.lang.Object;
import java.lang.Override;
import java.util.Objects;

/**
 * ICAROUS heartbeat 
 */
@MavlinkMessageInfo(
        id = 42000,
        crc = 227
)
public final class IcarousHeartbeat {
    private final EnumValue<IcarousFmsState> status;

    private IcarousHeartbeat(EnumValue<IcarousFmsState> status) {
        this.status = status;
    }

    /**
     * Returns a builder instance for this message.
     */
    @MavlinkMessageBuilder
    public static Builder builder() {
        return new Builder();
    }

    /**
     * See the FMS_STATE enum. 
     */
    @MavlinkFieldInfo(
            position = 1,
            unitSize = 1,
            enumType = IcarousFmsState.class
    )
    public final EnumValue<IcarousFmsState> status() {
        return this.status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !getClass().equals(o.getClass())) return false;
        IcarousHeartbeat other = (IcarousHeartbeat)o;
        if (!Objects.deepEquals(status, other.status)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + Objects.hashCode(status);
        return result;
    }

    public static final class Builder {
        private EnumValue<IcarousFmsState> status;

        /**
         * See the FMS_STATE enum. 
         */
        @MavlinkFieldInfo(
                position = 1,
                unitSize = 1,
                enumType = IcarousFmsState.class
        )
        public final Builder status(EnumValue<IcarousFmsState> status) {
            this.status = status;
            return this;
        }

        /**
         * See the FMS_STATE enum. 
         */
        public final Builder status(IcarousFmsState entry) {
            this.status = EnumValue.of(entry);
            return this;
        }

        /**
         * See the FMS_STATE enum. 
         */
        public final Builder status(Enum... flags) {
            this.status = EnumValue.create(flags);
            return this;
        }

        public final IcarousHeartbeat build() {
            return new IcarousHeartbeat(status);
        }
    }
}
