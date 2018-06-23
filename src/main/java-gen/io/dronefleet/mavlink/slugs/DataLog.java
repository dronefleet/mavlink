package io.dronefleet.mavlink.slugs;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import java.lang.Override;
import java.lang.String;

/**
 * Configurable data log probes to be used inside Simulink 
 */
@MavlinkMessageInfo(
        id = 177,
        crc = 167
)
public final class DataLog {
    /**
     * Log value 1 
     */
    private final float fl1;

    /**
     * Log value 2 
     */
    private final float fl2;

    /**
     * Log value 3 
     */
    private final float fl3;

    /**
     * Log value 4 
     */
    private final float fl4;

    /**
     * Log value 5 
     */
    private final float fl5;

    /**
     * Log value 6 
     */
    private final float fl6;

    private DataLog(float fl1, float fl2, float fl3, float fl4, float fl5, float fl6) {
        this.fl1 = fl1;
        this.fl2 = fl2;
        this.fl3 = fl3;
        this.fl4 = fl4;
        this.fl5 = fl5;
        this.fl6 = fl6;
    }

    @MavlinkMessageBuilder
    public static Builder builder() {
        return new Builder();
    }

    @Override
    public String toString() {
        return "DataLog{fl1=" + fl1
                 + ", fl2=" + fl2
                 + ", fl3=" + fl3
                 + ", fl4=" + fl4
                 + ", fl5=" + fl5
                 + ", fl6=" + fl6 + "}";
    }

    /**
     * Log value 1 
     */
    @MavlinkFieldInfo(
            position = 1,
            unitSize = 4
    )
    public final float fl1() {
        return fl1;
    }

    /**
     * Log value 2 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 4
    )
    public final float fl2() {
        return fl2;
    }

    /**
     * Log value 3 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 4
    )
    public final float fl3() {
        return fl3;
    }

    /**
     * Log value 4 
     */
    @MavlinkFieldInfo(
            position = 4,
            unitSize = 4
    )
    public final float fl4() {
        return fl4;
    }

    /**
     * Log value 5 
     */
    @MavlinkFieldInfo(
            position = 5,
            unitSize = 4
    )
    public final float fl5() {
        return fl5;
    }

    /**
     * Log value 6 
     */
    @MavlinkFieldInfo(
            position = 6,
            unitSize = 4
    )
    public final float fl6() {
        return fl6;
    }

    public static class Builder {
        private float fl1;

        private float fl2;

        private float fl3;

        private float fl4;

        private float fl5;

        private float fl6;

        private Builder() {
        }

        /**
         * Log value 1 
         */
        @MavlinkFieldInfo(
                position = 1,
                unitSize = 4
        )
        public final Builder fl1(float fl1) {
            this.fl1 = fl1;
            return this;
        }

        /**
         * Log value 2 
         */
        @MavlinkFieldInfo(
                position = 2,
                unitSize = 4
        )
        public final Builder fl2(float fl2) {
            this.fl2 = fl2;
            return this;
        }

        /**
         * Log value 3 
         */
        @MavlinkFieldInfo(
                position = 3,
                unitSize = 4
        )
        public final Builder fl3(float fl3) {
            this.fl3 = fl3;
            return this;
        }

        /**
         * Log value 4 
         */
        @MavlinkFieldInfo(
                position = 4,
                unitSize = 4
        )
        public final Builder fl4(float fl4) {
            this.fl4 = fl4;
            return this;
        }

        /**
         * Log value 5 
         */
        @MavlinkFieldInfo(
                position = 5,
                unitSize = 4
        )
        public final Builder fl5(float fl5) {
            this.fl5 = fl5;
            return this;
        }

        /**
         * Log value 6 
         */
        @MavlinkFieldInfo(
                position = 6,
                unitSize = 4
        )
        public final Builder fl6(float fl6) {
            this.fl6 = fl6;
            return this;
        }

        public final DataLog build() {
            return new DataLog(fl1, fl2, fl3, fl4, fl5, fl6);
        }
    }
}
