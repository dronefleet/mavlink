package io.dronefleet.mavlink.avssuas;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;

/**
 * Drone operation mode. 
 */
@MavlinkMessageInfo(
        id = 60053,
        crc = 45,
        description = "Drone operation mode."
)
public final class AvssDroneOperationMode {
    private final long timeBootMs;

    private final int m300OperationMode;

    private final int horseflyOperationMode;

    private AvssDroneOperationMode(long timeBootMs, int m300OperationMode,
            int horseflyOperationMode) {
        this.timeBootMs = timeBootMs;
        this.m300OperationMode = m300OperationMode;
        this.horseflyOperationMode = horseflyOperationMode;
    }

    /**
     * Returns a builder instance for this message.
     */
    @MavlinkMessageBuilder
    public static Builder builder() {
        return new Builder();
    }

    /**
     * Timestamp (time since FC boot). 
     */
    @MavlinkFieldInfo(
            position = 1,
            unitSize = 4,
            description = "Timestamp (time since FC boot)."
    )
    public final long timeBootMs() {
        return this.timeBootMs;
    }

    /**
     * DJI M300 operation mode 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 1,
            description = "DJI M300 operation mode"
    )
    public final int m300OperationMode() {
        return this.m300OperationMode;
    }

    /**
     * horsefly operation mode 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 1,
            description = "horsefly operation mode"
    )
    public final int horseflyOperationMode() {
        return this.horseflyOperationMode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !getClass().equals(o.getClass())) return false;
        AvssDroneOperationMode other = (AvssDroneOperationMode)o;
        if (!Objects.deepEquals(timeBootMs, other.timeBootMs)) return false;
        if (!Objects.deepEquals(m300OperationMode, other.m300OperationMode)) return false;
        if (!Objects.deepEquals(horseflyOperationMode, other.horseflyOperationMode)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + Objects.hashCode(timeBootMs);
        result = 31 * result + Objects.hashCode(m300OperationMode);
        result = 31 * result + Objects.hashCode(horseflyOperationMode);
        return result;
    }

    @Override
    public String toString() {
        return "AvssDroneOperationMode{timeBootMs=" + timeBootMs
                 + ", m300OperationMode=" + m300OperationMode
                 + ", horseflyOperationMode=" + horseflyOperationMode + "}";
    }

    public static final class Builder {
        private long timeBootMs;

        private int m300OperationMode;

        private int horseflyOperationMode;

        /**
         * Timestamp (time since FC boot). 
         */
        @MavlinkFieldInfo(
                position = 1,
                unitSize = 4,
                description = "Timestamp (time since FC boot)."
        )
        public final Builder timeBootMs(long timeBootMs) {
            this.timeBootMs = timeBootMs;
            return this;
        }

        /**
         * DJI M300 operation mode 
         */
        @MavlinkFieldInfo(
                position = 2,
                unitSize = 1,
                description = "DJI M300 operation mode"
        )
        public final Builder m300OperationMode(int m300OperationMode) {
            this.m300OperationMode = m300OperationMode;
            return this;
        }

        /**
         * horsefly operation mode 
         */
        @MavlinkFieldInfo(
                position = 3,
                unitSize = 1,
                description = "horsefly operation mode"
        )
        public final Builder horseflyOperationMode(int horseflyOperationMode) {
            this.horseflyOperationMode = horseflyOperationMode;
            return this;
        }

        public final AvssDroneOperationMode build() {
            return new AvssDroneOperationMode(timeBootMs, m300OperationMode, horseflyOperationMode);
        }
    }
}
