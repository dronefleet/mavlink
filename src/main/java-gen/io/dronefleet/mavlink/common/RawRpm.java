package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;

/**
 * RPM sensor data message. 
 */
@MavlinkMessageInfo(
        id = 339,
        crc = 199,
        description = "RPM sensor data message."
)
public final class RawRpm {
    private final int index;

    private final float frequency;

    private RawRpm(int index, float frequency) {
        this.index = index;
        this.frequency = frequency;
    }

    /**
     * Returns a builder instance for this message.
     */
    @MavlinkMessageBuilder
    public static Builder builder() {
        return new Builder();
    }

    /**
     * Index of this RPM sensor (0-indexed) 
     */
    @MavlinkFieldInfo(
            position = 1,
            unitSize = 1,
            description = "Index of this RPM sensor (0-indexed)"
    )
    public final int index() {
        return this.index;
    }

    /**
     * Indicated rate 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 4,
            description = "Indicated rate"
    )
    public final float frequency() {
        return this.frequency;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !getClass().equals(o.getClass())) return false;
        RawRpm other = (RawRpm)o;
        if (!Objects.deepEquals(index, other.index)) return false;
        if (!Objects.deepEquals(frequency, other.frequency)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + Objects.hashCode(index);
        result = 31 * result + Objects.hashCode(frequency);
        return result;
    }

    @Override
    public String toString() {
        return "RawRpm{index=" + index
                 + ", frequency=" + frequency + "}";
    }

    public static final class Builder {
        private int index;

        private float frequency;

        /**
         * Index of this RPM sensor (0-indexed) 
         */
        @MavlinkFieldInfo(
                position = 1,
                unitSize = 1,
                description = "Index of this RPM sensor (0-indexed)"
        )
        public final Builder index(int index) {
            this.index = index;
            return this;
        }

        /**
         * Indicated rate 
         */
        @MavlinkFieldInfo(
                position = 2,
                unitSize = 4,
                description = "Indicated rate"
        )
        public final Builder frequency(float frequency) {
            this.frequency = frequency;
            return this;
        }

        public final RawRpm build() {
            return new RawRpm(index, frequency);
        }
    }
}
