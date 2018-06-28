package io.dronefleet.mavlink.slugs;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;

/**
 * Transmits the position of watch 
 */
@MavlinkMessageInfo(
        id = 189,
        crc = 246
)
public final class IsrLocation {
    private final int target;

    private final float latitude;

    private final float longitude;

    private final float height;

    private final int option1;

    private final int option2;

    private final int option3;

    private IsrLocation(int target, float latitude, float longitude, float height, int option1,
            int option2, int option3) {
        this.target = target;
        this.latitude = latitude;
        this.longitude = longitude;
        this.height = height;
        this.option1 = option1;
        this.option2 = option2;
        this.option3 = option3;
    }

    /**
     * Returns a builder instance for this message.
     */
    @MavlinkMessageBuilder
    public static Builder builder() {
        return new Builder();
    }

    /**
     * The system reporting the action 
     */
    @MavlinkFieldInfo(
            position = 1,
            unitSize = 1
    )
    public final int target() {
        return this.target;
    }

    /**
     * ISR Latitude 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 4
    )
    public final float latitude() {
        return this.latitude;
    }

    /**
     * ISR Longitude 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 4
    )
    public final float longitude() {
        return this.longitude;
    }

    /**
     * ISR Height 
     */
    @MavlinkFieldInfo(
            position = 4,
            unitSize = 4
    )
    public final float height() {
        return this.height;
    }

    /**
     * Option 1 
     */
    @MavlinkFieldInfo(
            position = 5,
            unitSize = 1
    )
    public final int option1() {
        return this.option1;
    }

    /**
     * Option 2 
     */
    @MavlinkFieldInfo(
            position = 6,
            unitSize = 1
    )
    public final int option2() {
        return this.option2;
    }

    /**
     * Option 3 
     */
    @MavlinkFieldInfo(
            position = 7,
            unitSize = 1
    )
    public final int option3() {
        return this.option3;
    }

    public static final class Builder {
        private int target;

        private float latitude;

        private float longitude;

        private float height;

        private int option1;

        private int option2;

        private int option3;

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
            return new IsrLocation(target, latitude, longitude, height, option1, option2, option3);
        }
    }
}
