package io.dronefleet.mavlink.slugs;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import java.lang.Override;
import java.lang.String;

/**
 * Transmits the position of watch 
 */
@MavlinkMessageInfo(
        id = 189,
        crc = 246
)
public final class IsrLocation {
    /**
     * ISR Latitude 
     */
    private final float latitude;

    /**
     * ISR Longitude 
     */
    private final float longitude;

    /**
     * ISR Height 
     */
    private final float height;

    /**
     * The system reporting the action 
     */
    private final int target;

    /**
     * Option 1 
     */
    private final int option1;

    /**
     * Option 2 
     */
    private final int option2;

    /**
     * Option 3 
     */
    private final int option3;

    private IsrLocation(float latitude, float longitude, float height, int target, int option1,
            int option2, int option3) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.height = height;
        this.target = target;
        this.option1 = option1;
        this.option2 = option2;
        this.option3 = option3;
    }

    @MavlinkMessageBuilder
    public static Builder builder() {
        return new Builder();
    }

    @Override
    public String toString() {
        return "IsrLocation{target=" + target
                 + ", latitude=" + latitude
                 + ", longitude=" + longitude
                 + ", height=" + height
                 + ", option1=" + option1
                 + ", option2=" + option2
                 + ", option3=" + option3 + "}";
    }

    /**
     * ISR Latitude 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 4
    )
    public final float latitude() {
        return latitude;
    }

    /**
     * ISR Longitude 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 4
    )
    public final float longitude() {
        return longitude;
    }

    /**
     * ISR Height 
     */
    @MavlinkFieldInfo(
            position = 4,
            unitSize = 4
    )
    public final float height() {
        return height;
    }

    /**
     * The system reporting the action 
     */
    @MavlinkFieldInfo(
            position = 1,
            unitSize = 1
    )
    public final int target() {
        return target;
    }

    /**
     * Option 1 
     */
    @MavlinkFieldInfo(
            position = 5,
            unitSize = 1
    )
    public final int option1() {
        return option1;
    }

    /**
     * Option 2 
     */
    @MavlinkFieldInfo(
            position = 6,
            unitSize = 1
    )
    public final int option2() {
        return option2;
    }

    /**
     * Option 3 
     */
    @MavlinkFieldInfo(
            position = 7,
            unitSize = 1
    )
    public final int option3() {
        return option3;
    }

    public static class Builder {
        private float latitude;

        private float longitude;

        private float height;

        private int target;

        private int option1;

        private int option2;

        private int option3;

        private Builder() {
        }

        /**
         * ISR Latitude 
         */
        @MavlinkFieldInfo(
                position = 2,
                unitSize = 4
        )
        public final Builder latitude(float latitude) {
            this.latitude = latitude;
            return this;
        }

        /**
         * ISR Longitude 
         */
        @MavlinkFieldInfo(
                position = 3,
                unitSize = 4
        )
        public final Builder longitude(float longitude) {
            this.longitude = longitude;
            return this;
        }

        /**
         * ISR Height 
         */
        @MavlinkFieldInfo(
                position = 4,
                unitSize = 4
        )
        public final Builder height(float height) {
            this.height = height;
            return this;
        }

        /**
         * The system reporting the action 
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
         * Option 1 
         */
        @MavlinkFieldInfo(
                position = 5,
                unitSize = 1
        )
        public final Builder option1(int option1) {
            this.option1 = option1;
            return this;
        }

        /**
         * Option 2 
         */
        @MavlinkFieldInfo(
                position = 6,
                unitSize = 1
        )
        public final Builder option2(int option2) {
            this.option2 = option2;
            return this;
        }

        /**
         * Option 3 
         */
        @MavlinkFieldInfo(
                position = 7,
                unitSize = 1
        )
        public final Builder option3(int option3) {
            this.option3 = option3;
            return this;
        }

        public final IsrLocation build() {
            return new IsrLocation(latitude, longitude, height, target, option1, option2, option3);
        }
    }
}
