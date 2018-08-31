package io.dronefleet.mavlink.slugs;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;

/**
 * Diagnostic data Sensor MCU 
 */
@MavlinkMessageInfo(
        id = 196,
        crc = 129,
        description = "Diagnostic data Sensor MCU"
)
public final class SensorDiag {
    private final float float1;

    private final float float2;

    private final int int1;

    private final int char1;

    private SensorDiag(float float1, float float2, int int1, int char1) {
        this.float1 = float1;
        this.float2 = float2;
        this.int1 = int1;
        this.char1 = char1;
    }

    /**
     * Returns a builder instance for this message.
     */
    @MavlinkMessageBuilder
    public static Builder builder() {
        return new Builder();
    }

    /**
     * Float field 1 
     */
    @MavlinkFieldInfo(
            position = 1,
            unitSize = 4,
            description = "Float field 1"
    )
    public final float float1() {
        return this.float1;
    }

    /**
     * Float field 2 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 4,
            description = "Float field 2"
    )
    public final float float2() {
        return this.float2;
    }

    /**
     * Int 16 field 1 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 2,
            signed = true,
            description = "Int 16 field 1"
    )
    public final int int1() {
        return this.int1;
    }

    /**
     * Int 8 field 1 
     */
    @MavlinkFieldInfo(
            position = 4,
            unitSize = 1,
            signed = true,
            description = "Int 8 field 1"
    )
    public final int char1() {
        return this.char1;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !getClass().equals(o.getClass())) return false;
        SensorDiag other = (SensorDiag)o;
        if (!Objects.deepEquals(float1, other.float1)) return false;
        if (!Objects.deepEquals(float2, other.float2)) return false;
        if (!Objects.deepEquals(int1, other.int1)) return false;
        if (!Objects.deepEquals(char1, other.char1)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + Objects.hashCode(float1);
        result = 31 * result + Objects.hashCode(float2);
        result = 31 * result + Objects.hashCode(int1);
        result = 31 * result + Objects.hashCode(char1);
        return result;
    }

    @Override
    public String toString() {
        return "SensorDiag{float1=" + float1
                 + ", float2=" + float2
                 + ", int1=" + int1
                 + ", char1=" + char1 + "}";
    }

    public static final class Builder {
        private float float1;

        private float float2;

        private int int1;

        private int char1;

        /**
         * Float field 1 
         */
        @MavlinkFieldInfo(
                position = 1,
                unitSize = 4,
                description = "Float field 1"
        )
        public final Builder float1(float float1) {
            this.float1 = float1;
            return this;
        }

        /**
         * Float field 2 
         */
        @MavlinkFieldInfo(
                position = 2,
                unitSize = 4,
                description = "Float field 2"
        )
        public final Builder float2(float float2) {
            this.float2 = float2;
            return this;
        }

        /**
         * Int 16 field 1 
         */
        @MavlinkFieldInfo(
                position = 3,
                unitSize = 2,
                signed = true,
                description = "Int 16 field 1"
        )
        public final Builder int1(int int1) {
            this.int1 = int1;
            return this;
        }

        /**
         * Int 8 field 1 
         */
        @MavlinkFieldInfo(
                position = 4,
                unitSize = 1,
                signed = true,
                description = "Int 8 field 1"
        )
        public final Builder char1(int char1) {
            this.char1 = char1;
            return this;
        }

        public final SensorDiag build() {
            return new SensorDiag(float1, float2, int1, char1);
        }
    }
}
