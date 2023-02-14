package io.dronefleet.mavlink.cubepilot;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;

/**
 * Raw RC Data 
 */
@MavlinkMessageInfo(
        id = 50001,
        crc = 246,
        description = "Raw RC Data"
)
public final class CubepilotRawRc {
    private final byte[] rcRaw;

    private CubepilotRawRc(byte[] rcRaw) {
        this.rcRaw = rcRaw;
    }

    /**
     * Returns a builder instance for this message.
     */
    @MavlinkMessageBuilder
    public static Builder builder() {
        return new Builder();
    }

    /**
     *  
     */
    @MavlinkFieldInfo(
            position = 1,
            unitSize = 1,
            arraySize = 32
    )
    public final byte[] rcRaw() {
        return this.rcRaw;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !getClass().equals(o.getClass())) return false;
        CubepilotRawRc other = (CubepilotRawRc)o;
        if (!Objects.deepEquals(rcRaw, other.rcRaw)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + Objects.hashCode(rcRaw);
        return result;
    }

    @Override
    public String toString() {
        return "CubepilotRawRc{rcRaw=" + rcRaw + "}";
    }

    public static final class Builder {
        private byte[] rcRaw;

        /**
         *  
         */
        @MavlinkFieldInfo(
                position = 1,
                unitSize = 1,
                arraySize = 32
        )
        public final Builder rcRaw(byte[] rcRaw) {
            this.rcRaw = rcRaw;
            return this;
        }

        public final CubepilotRawRc build() {
            return new CubepilotRawRc(rcRaw);
        }
    }
}
