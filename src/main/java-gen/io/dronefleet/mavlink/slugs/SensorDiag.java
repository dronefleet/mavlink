package io.dronefleet.mavlink.slugs;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import java.lang.Override;
import java.lang.String;

/**
 * Diagnostic data Sensor MCU 
 */
@MavlinkMessageInfo(
        id = 196,
        crc = 129
)
public final class SensorDiag {
    /**
     * Float field 1 
     */
    private final float float1;

    /**
     * Float field 2 
     */
    private final float float2;

    /**
     * Int 16 field 1 
     */
    private final int int1;

    /**
     * Int 8 field 1 
     */
    private final int char1;

    private SensorDiag(float float1, float float2, int int1, int char1) {
        this.float1 = float1;
        this.float2 = float2;
        this.int1 = int1;
        this.char1 = char1;
    }

    @MavlinkMessageBuilder
    public static Builder builder() {
        return new Builder();
    }

    @Override
    public String toString() {
        return "SensorDiag{float1=" + float1
                 + ", float2=" + float2
                 + ", int1=" + int1
                 + ", char1=" + char1 + "}";
    }

    /**
     * Float field 1 
     */
    @MavlinkFieldInfo(
            position = 1,
            unitSize = 4
    )
    public final float float1() {
        return float1;
    }

    /**
     * Float field 2 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 4
    )
    public final float float2() {
        return float2;
    }

    /**
     * Int 16 field 1 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 2,
            signed = true
    )
    public final int int1() {
        return int1;
    }

    /**
     * Int 8 field 1 
     */
    @MavlinkFieldInfo(
            position = 4,
            unitSize = 1,
            signed = true
    )
    public final int char1() {
        return char1;
    }

    public static class Builder {
        private float float1;

        private float float2;

        private int int1;

        private int char1;

        private Builder() {
        }

        /**
         * Float field 1 
         */
        @MavlinkFieldInfo(
                position = 1,
                unitSize = 4
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
                unitSize = 4
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
                signed = true
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
                signed = true
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
